package com.enoca.hrcases.dto.product;


import lombok.Data;

@Data
public class ProductResponseDto {

    private String productName;
    private String productDescription;

    private Double productPrice;

    private String sellerName;


}
