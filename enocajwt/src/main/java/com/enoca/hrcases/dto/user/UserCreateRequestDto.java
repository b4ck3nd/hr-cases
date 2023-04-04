package com.enoca.hrcases.dto.user;


import lombok.Data;

@Data
public class UserCreateRequestDto {
    private String name;
    private String password;
    private String email;


}
