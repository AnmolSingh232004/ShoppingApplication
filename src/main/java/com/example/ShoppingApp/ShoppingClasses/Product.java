package com.example.ShoppingApp.ShoppingClasses;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @SequenceGenerator(
            name = "product_sequence",
            sequenceName = "product_sequence",
            initialValue = 1,
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_sequence"
    )
    private Long iD;
    private Double price;
    private int quantityAvailable;

    @ManyToOne // Each product must have one user/buyer
    private Orders orders_id;

    public Product() {

    }
    public Product(Double price, int quantityAvailable) {
        this.price = price;
        this.quantityAvailable = quantityAvailable;
    }

    public int getQuantityAvailable() {
        return quantityAvailable;
    }

    public void setQuantityAvailable(int quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }

    public Long getiD() {
        return iD;
    }

    public void setiD(Long iD) {
        this.iD = iD;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
