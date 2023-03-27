package com.enoca.hrcases.controller;


import com.enoca.hrcases.dto.product.ProductCreateRequestDto;
import com.enoca.hrcases.dto.product.ProductResponseDto;
import com.enoca.hrcases.dto.product.ProductUpdateRequestDto;
import com.enoca.hrcases.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/")
    public ResponseEntity<List<ProductResponseDto>>  findAll() {
        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<ProductResponseDto> createProduct(@RequestBody ProductCreateRequestDto dto) {
        return new ResponseEntity<>(productService.addProduct(dto),HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<ProductResponseDto> updateProduct(@RequestBody ProductUpdateRequestDto dto) {
        return new ResponseEntity<>(productService.updateProductByProductId(dto),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ProductResponseDto> deleteProductById(@PathVariable long id) {
        return new ResponseEntity<>(productService.deleteProductById(id),HttpStatus.OK);
    }

    @GetMapping("/search{term}")
    public ResponseEntity<List<ProductResponseDto>> findProductByProductNameContaining(@PathVariable String term) {
        return new ResponseEntity<>(productService.findProductByProductNameContaining(term),HttpStatus.OK);
    }


}
