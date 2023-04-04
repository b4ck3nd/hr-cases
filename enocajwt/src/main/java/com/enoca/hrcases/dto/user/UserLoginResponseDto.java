package com.enoca.hrcases.dto.user;


import lombok.Data;

@Data
public class UserLoginResponseDto {
    private long id;
    private String username;
    private String password;

}
