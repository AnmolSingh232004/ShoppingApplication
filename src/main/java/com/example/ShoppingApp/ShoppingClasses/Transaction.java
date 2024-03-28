package com.example.ShoppingApp.ShoppingClasses;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @SequenceGenerator(
            name = "transaction_sequence",
            sequenceName = "transaction_sequence",
            initialValue = 6000,
            allocationSize = 6
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "transaction_sequence"
    )
    private Long iD;
    private LocalDate transactionDate;
    private Long orderId;

    public Transaction() {
    }
    public Transaction(Long orderId) {
        this.orderId = orderId;
    }

    public Long getiD() {
        return iD;
    }

    public void setiD(Long iD) {
        this.iD = iD;
    }

    public LocalDate getLocalDate() {
        return LocalDate.now();
    }

    public void setLocalDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }
}
