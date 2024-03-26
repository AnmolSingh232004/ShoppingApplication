package com.example.ShoppingApp.ShoppingRepositories;

import com.example.ShoppingApp.ShoppingClasses.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
