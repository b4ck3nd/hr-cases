package com.enoca.hrcases.controller;


import com.enoca.hrcases.dto.product.ProductResponseDto;
import com.enoca.hrcases.dto.user.UserCreateRequestDto;
import com.enoca.hrcases.dto.user.UserResponseDto;
import com.enoca.hrcases.dto.user.UserUpdateDto;
import com.enoca.hrcases.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/")
    public ResponseEntity<List<UserResponseDto>> findAll() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<UserResponseDto> createSeller(@RequestBody UserCreateRequestDto dto) {
        return new ResponseEntity<>(userService.add(dto),HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<UserResponseDto>  updateSellerById(@RequestBody UserUpdateDto dto) {
        return new ResponseEntity<>(userService.updateSellerById(dto),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<UserResponseDto> deleteSellerById(@PathVariable long id) {
        return new ResponseEntity<>(userService.deletedById(id),HttpStatus.OK);
    }

    @GetMapping("/{id}/products")
    public ResponseEntity<List<ProductResponseDto>> findProductsBySellerId(@PathVariable long id) {
        return new ResponseEntity<>(userService.findProductBySellerId(id),HttpStatus.OK);
    }

}
