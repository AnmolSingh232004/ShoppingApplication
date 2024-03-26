package com.example.ShoppingApp.ShoppingRepostories;

import com.example.ShoppingApp.ShoppingClasses.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
//    @Query("SELECT p FROM Product p WHERE p.iD = ?1")
}
