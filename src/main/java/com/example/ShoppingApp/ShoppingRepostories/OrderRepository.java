package com.example.ShoppingApp.ShoppingRepostories;

import com.example.ShoppingApp.ShoppingClasses.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {
}
