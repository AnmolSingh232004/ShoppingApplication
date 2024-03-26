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
            initialValue = 1000,
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "transaction_sequence"
    )
    private Long iD;
    private LocalDate transactionDate;

    public Transaction() {
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
