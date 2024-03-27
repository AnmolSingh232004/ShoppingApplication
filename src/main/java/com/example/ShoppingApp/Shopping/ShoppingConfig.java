package com.example.ShoppingApp.Shopping;

import com.example.ShoppingApp.ShoppingClasses.Coupons;
import com.example.ShoppingApp.ShoppingClasses.Product;
import com.example.ShoppingApp.ShoppingClasses.Users;
import com.example.ShoppingApp.ShoppingRepositories.CouponRepository;
import com.example.ShoppingApp.ShoppingRepositories.ProductRepository;
import com.example.ShoppingApp.ShoppingRepositories.UserRepository;
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
            Users users = new Users("Anmol");
            Coupons coupons = new Coupons("OFF5", 5.0);
            Coupons coupons1 = new Coupons("OFF15", 15.0);
            Product product = new Product(350.0, 100);
            userRepository.saveAll(List.of(users));
            couponRepository.saveAll(List.of(coupons, coupons1));
            productRepository.saveAll(List.of(product));
        };
    }
}
