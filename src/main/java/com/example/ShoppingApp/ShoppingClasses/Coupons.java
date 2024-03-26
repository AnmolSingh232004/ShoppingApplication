package com.example.ShoppingApp.ShoppingClasses;

import jakarta.persistence.*;

@Entity
@Table(name = "coupons")
public class Coupons {
    @Id
    @SequenceGenerator(
            name = "coupon_sequence",
            sequenceName = "coupon_sequence",
            initialValue = 1,
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "coupon_sequence"
    )
    private Long iD;
    private Double discount;
    private String couponName;

    public Coupons() {
    }
    public Coupons(String couponName, Double discount) {
        this.couponName = couponName;
        this.discount = discount;
    }

    public String getCouponName() {
        return couponName;
    }

    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }

    public Long getiD() {
        return iD;
    }

    public void setiD(Long iD) {
        this.iD = iD;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }
}
