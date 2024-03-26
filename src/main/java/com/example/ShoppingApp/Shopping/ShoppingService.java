package com.example.ShoppingApp.Shopping;

import com.example.ShoppingApp.ShoppingClasses.Coupons;
import com.example.ShoppingApp.ShoppingClasses.Orders;
import com.example.ShoppingApp.ShoppingClasses.Product;
import com.example.ShoppingApp.ShoppingClasses.User;
import com.example.ShoppingApp.ShoppingRepostories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ShoppingService {
    private final UserRepository userRepository;
    private final OrderRepository orderRepository;
    private final CouponRepository couponRepository;
    private final ProductRepository productRepository;
    private final TransactionRepository transactionRepository;

    @Autowired
    public ShoppingService(UserRepository userRepository,
                           OrderRepository orderRepository,
                           CouponRepository couponRepository,
                           ProductRepository productRepository,
                           TransactionRepository transactionRepository) {
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
        this.couponRepository = couponRepository;
        this.productRepository = productRepository;
        this.transactionRepository = transactionRepository;
    }

    public List<Product> getProductsList() {
        return productRepository.findAll(); // gets list of all products available (only one due to constraints)
    }

    public List<Coupons> getCouponsList() {
        return couponRepository.findAll(); // get all available coupons
    }

    public List<Orders> getOrdersList(Long iD) {
        return orderRepository.findAll(); // finds all orders of a user
    }

    public List<Orders> getParticularOrderList(Long userId, Long orderId) {
        List<Orders> list = getOrdersList(userId); // A list of all orders of a user
        List<Orders> finalList = new ArrayList<>();
        for (int i=0; i<list.size(); i++) {
            if (list.get(i).getId().equals(orderId))finalList.add(list.get(i));
            // determines if a particular order of user has the order id we want we add it to our finalList
        }
        return finalList;
    }

    public void placeOrder(Long id, int quantity, String coupon) {
        Optional<User> userOptional = userRepository.findById(id);
        Optional<Coupons> optionalCoupons = couponRepository.findCouponByString(coupon);
        if (userOptional.isPresent() && optionalCoupons.isPresent()) {
            Optional<Product> product = productRepository.findById(1L); // Since only 1 product exists as of now
            if (product.isPresent()) {
                if (quantity <= product.get().getQuantityAvailable()) {
                    Double orderValue = product.get().getPrice();
                    Double priceAfterDiscount = orderValue - (orderValue * optionalCoupons.get().getDiscount() / 100);
                    List<Product> list = new ArrayList<>();
                    list.add(product.get());
                    Orders orders = new Orders(userOptional.get(), list, quantity, priceAfterDiscount, coupon);
                    orderRepository.save(orders);
                } else {
                    throw new IllegalArgumentException("Not enough quantity available");
                }
            } else {
                throw new IllegalArgumentException("No such product exists");
            }
        } else {
            throw new IllegalArgumentException("Either user id or coupon is invalid");
        }

    }

    public Orders payBill(Long userId, Long orderId, Double amount) {
        Optional<User> userOptional = userRepository.findById(userId);
        Optional<Orders> optionalOrders = orderRepository.findById(orderId);
        if (userOptional.isPresent() && optionalOrders.isPresent()) { // order id and user id valid
            Random random = new Random();
            int randomStatus = random.nextInt(1, 7);

            switch (randomStatus) {
                case 1:
                    Orders orders1 = orderRepository.getReferenceById(orderId);
                    orders1.setStatus("Successful");
                    return orders1;

                case 2:
                    Orders orders2 = orderRepository.getReferenceById(orderId);
                    orders2.setStatus("Payment failed as amount is invalid");
                    orders2.setStatus("Failed");
                    return orders2;

                case 3:
                    Orders orders3 = orderRepository.getReferenceById(orderId);
                    orders3.setDescription("Payment failed from bank");
                    orders3.setStatus("Failed");
                    return orders3;

                case 4:
                    Orders orders4 = orderRepository.getReferenceById(orderId);
                    orders4.setStatus("Failed");
                    orders4.setDescription("Payment failed due to invalid order id");
                    return orders4;

                case 5:
                    Orders orders5 = orderRepository.getReferenceById(orderId);
                    orders5.setStatus("Failed");
                    orders5.setDescription("No response from payment server");
                    return orders5;

                case 6:
                    Orders orders6 = orderRepository.getReferenceById(orderId);
                    orders6.setStatus("Failed");
                    orders6.setDescription("Order is already paid for");
                    return orders6;

            }

        }
        throw new InputMismatchException("Internal server error");
    }
}
