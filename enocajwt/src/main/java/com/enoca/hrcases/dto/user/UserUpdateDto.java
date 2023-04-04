package com.enoca.hrcases.dto.user;


import lombok.Data;

@Data
public class UserUpdateDto {
    private String name;
    private String email;
    private long id;
    private String password;

}
