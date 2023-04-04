package com.enoca.hrcases.service.user;

import com.enoca.hrcases.dto.product.ProductResponseDto;
import com.enoca.hrcases.dto.user.UserCreateRequestDto;
import com.enoca.hrcases.dto.user.UserResponseDto;
import com.enoca.hrcases.dto.user.UserUpdateDto;

import java.util.List;

public interface UserService {
    UserResponseDto deletedById(long id);
    UserResponseDto add(UserCreateRequestDto dto);
    List<UserResponseDto> findAll();
    UserResponseDto findById(long id);

    UserResponseDto updateSellerById(UserUpdateDto dto);

    List<ProductResponseDto> findProductBySellerId(long id);
}
