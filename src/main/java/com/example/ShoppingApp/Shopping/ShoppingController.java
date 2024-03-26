package com.example.ShoppingApp.Shopping;

import com.example.ShoppingApp.ShoppingClasses.Coupons;
import com.example.ShoppingApp.ShoppingClasses.Orders;
import com.example.ShoppingApp.ShoppingClasses.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/shopping")
public class ShoppingController {
    private final ShoppingService shoppingService;

    @Autowired
    public ShoppingController(ShoppingService shoppingService) {
        this.shoppingService = shoppingService;
    }
    @GetMapping(path = "/inventory")
    public List<Product> inventory() {
        return shoppingService.getProductsList();
    }

    @GetMapping(path = "/fetchCoupons")
    public List<Coupons> fetchCoupons() {
        return shoppingService.getCouponsList();
    }

    @GetMapping(path = "{userId}/orders")
    public List<Orders> orders(@PathVariable("userId") Long iD) {
        return shoppingService.getOrdersList(iD);
    }

    @GetMapping(path = "{userId}/orders/{orderId}")
    public List<Orders> orders(@PathVariable("userId") Long userId,
                               @PathVariable("orderId") Long orderId) {
        return shoppingService.getParticularOrderList(userId, orderId);
    }

    @PostMapping(path = "{userId}/order")
    public void placeOrder(@RequestParam(required = true) int quantity,
                           @RequestParam(required = false) String coupon,
                           @PathVariable("userId") Long id) {
       shoppingService.placeOrder(id, quantity, coupon);
    }

    @PostMapping(path = "/{userId}/{orderId}/pay")
    public Orders pay(@PathVariable Long userId,
                    @PathVariable Long orderId,
                    @RequestParam(required = true) Double amount) {
        return shoppingService.payBill(userId, orderId, amount);
    }

}
