package com.enoca.hrcases.dto.product;


import lombok.Data;

@Data
public class ProductStockUpdateRequestDto {
    private long produdctId;
    private int stock;

}
