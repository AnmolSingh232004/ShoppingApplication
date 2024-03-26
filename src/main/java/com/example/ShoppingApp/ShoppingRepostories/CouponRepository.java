package com.example.ShoppingApp.ShoppingRepostories;

import com.example.ShoppingApp.ShoppingClasses.Coupons;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CouponRepository extends JpaRepository<Coupons, Long> {
    @Query("SELECT c FROM Coupons c WHERE c.couponName = ?1")
    Optional<Coupons>findCouponByString(String Coupon);
}
