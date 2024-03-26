package com.example.ShoppingApp.ShoppingRepositories;

import com.example.ShoppingApp.ShoppingClasses.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
//    @Query("SELECT p FROM Product p WHERE p.iD = ?1")
}
