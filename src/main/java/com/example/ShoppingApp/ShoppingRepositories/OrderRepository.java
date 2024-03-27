package com.example.ShoppingApp.ShoppingRepositories;

import com.example.ShoppingApp.ShoppingClasses.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {
    @Query("SELECT o FROM Orders o WHERE o.users_order.iD = ?1")
    List<Orders> findByUserId(Long iD);

    @Query("SELECT o FROM Orders o WHERE o.users_order.iD = ?1 AND o.id = ?2")
    List<Orders> findByUserIdAndOrderId(Long userId, Long orderId);

}
