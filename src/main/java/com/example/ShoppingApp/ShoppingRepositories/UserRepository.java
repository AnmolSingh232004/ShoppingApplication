package com.example.ShoppingApp.ShoppingRepositories;

import com.example.ShoppingApp.ShoppingClasses.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {


}
