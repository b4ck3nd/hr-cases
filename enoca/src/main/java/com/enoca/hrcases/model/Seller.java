package com.enoca.hrcases.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.List;

@Entity
@Data
@Table(name = "sellers")
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "seller_name",nullable = false)
    private String name;

    @Column(name = "seller_password",nullable = false)
    @Min(value = 8,message = "sifre en az 8 karakter olmalidir")
    @Max(value = 50,message = "sifre en fazla 50 karakter olabilir")
    private String password;

    @Column(name = "seller_email",unique = true)
    private String email;


    @OneToMany(cascade = CascadeType.ALL)
    private List<Product> products;
}
