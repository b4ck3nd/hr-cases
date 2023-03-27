package com.enoca.hrcases.dto.product;


import lombok.Data;

@Data
public class ProductCreateRequestDto {
    private String productName;
    private String productDescription;
    private Double productPrice;

    private long sellerId;
    private int stock;
}
