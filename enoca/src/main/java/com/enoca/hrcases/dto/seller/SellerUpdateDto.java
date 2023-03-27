package com.enoca.hrcases.dto.seller;


import lombok.Data;

@Data
public class SellerUpdateDto {
    private String name;
    private String email;
    private long id;
    private String password;

}
