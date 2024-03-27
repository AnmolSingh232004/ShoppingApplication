package com.example.ShoppingApp.ShoppingClasses;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "users")
public class Users {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            initialValue = 1,
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private Long iD;
    private String name;
    @OneToMany(mappedBy = "users_order") // One user can have many orders
    private List<Orders> orders;

    public Users(String name) {
        this.name = name;
    }

    public Users() {

    }

    public Long getId() {
        return iD;
    }

    public void setId(Long id) {
        this.iD = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
