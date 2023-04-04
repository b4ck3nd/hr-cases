package com.enoca.hrcases.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.List;

@Entity
@Data
@Table(name = "sellers")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "seller_name",nullable = false)
    private String username;

    @Column(name = "seller_password",nullable = false)

    private String password;

    @Column(name = "seller_email",unique = true)
    private String email;


    @OneToMany(cascade = CascadeType.ALL)
    private List<Product> products;

    @Enumerated(EnumType.STRING)
    private Role role;


}
