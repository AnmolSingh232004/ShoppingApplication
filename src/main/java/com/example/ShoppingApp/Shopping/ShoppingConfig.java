package com.example.ShoppingApp.Shopping;

import com.example.ShoppingApp.ShoppingClasses.Coupons;
import com.example.ShoppingApp.ShoppingClasses.Product;
import com.example.ShoppingApp.ShoppingClasses.User;
import com.example.ShoppingApp.ShoppingRepostories.CouponRepository;
import com.example.ShoppingApp.ShoppingRepostories.ProductRepository;
import com.example.ShoppingApp.ShoppingRepostories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ShoppingConfig {
    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository,
                                        CouponRepository couponRepository,
                                        ProductRepository productRepository
                                        ) {
        return args -> {
            User user = new User("Anmol");
            Coupons coupons = new Coupons("OFF5", 5.0);
            Coupons coupons1 = new Coupons("OFF15", 15.0);
            Product product = new Product(350.0, 100);
            userRepository.saveAll(List.of(user));
            couponRepository.saveAll(List.of(coupons, coupons1));
            productRepository.saveAll(List.of(product));
        };
    }
}
