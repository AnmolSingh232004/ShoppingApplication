package com.example.ShoppingApp.ShoppingClasses;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @SequenceGenerator(
            name = "orders_sequence",
            sequenceName = "orders_sequence",
            initialValue = 2000,
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "orders_sequence"
    )
    private Long id;
    @ManyToOne // Each order must have a user associated with it
    private Users users_order;
    @OneToMany(mappedBy = "orders_id") // A user can have multiple orders
    private List<Product> products;
    private Double orderValue;
    private int orderQuantity;
    private LocalDate orderDate;
    private String couponUsed;
    private String status;
    private String description;

    public Orders() {

    }
    public Orders(Users users, List<Product> products, int orderQuantity, Double orderValue, String couponUsed) {
        this.users_order = users;
        this.products = products;
        this.orderQuantity = orderQuantity;
        this.orderValue = orderValue;
        this.couponUsed = couponUsed;
    }

    public Double getOrderValue() {
        return orderValue;
    }

    public void setOrderValue(Double orderValue) {
        this.orderValue = orderValue;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public String getCouponUsed() {
        return couponUsed;
    }

    public void setCouponUsed(String couponUsed) {
        this.couponUsed = couponUsed;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Users getUser() {
        return users_order;
    }

    public void setUser(Users users_order) {
        this.users_order = users_order;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public LocalDate getLocalDate() {
        return LocalDate.now();
    }

    public void setLocalDate(LocalDate localDate) {
        this.orderDate = localDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
