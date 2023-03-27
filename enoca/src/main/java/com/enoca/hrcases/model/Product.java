package com.enoca.hrcases.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Entity
@Data
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "product_name",nullable = false)
    private String productName;

    @Column(name = "product_description",nullable = false)
    private String productDescription;

    @Column(name = "product_price",nullable = false)
    private Double productPrice;

    @Column(name = "product_stock",nullable = false)
    private int stock;


    @ManyToOne
    private Seller seller;


}
