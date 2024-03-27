package com.example.ShoppingApp.ShoppingRepositories;

import com.example.ShoppingApp.ShoppingClasses.Coupons;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface CouponRepository extends JpaRepository<Coupons, Long> {
    @Query("SELECT c FROM Coupons c WHERE c.couponName = ?1")
    Optional<Coupons>findCouponByString(String Coupon);
}
