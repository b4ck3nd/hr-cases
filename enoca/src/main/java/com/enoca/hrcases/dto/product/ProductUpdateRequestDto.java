package com.enoca.hrcases.dto.product;


import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class ProductUpdateRequestDto {
    private long productId;
    private String productName;
    private String productDescription;
    private String productPrice;

    @Min(value = 1,message = "en az 1 ürün eklenmelidir")
    private int stock;

}
