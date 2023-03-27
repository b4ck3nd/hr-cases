package com.enoca.hrcases.controller;


import com.enoca.hrcases.dto.seller.SellerCreateRequestDto;
import com.enoca.hrcases.dto.seller.SellerResponseDto;
import com.enoca.hrcases.dto.seller.SellerUpdateDto;
import com.enoca.hrcases.repository.SellerRepository;
import com.enoca.hrcases.service.seller.SellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seller")
@RequiredArgsConstructor
public class SellerController {
    private final SellerService sellerService;

    @GetMapping("/")
    public ResponseEntity<List<SellerResponseDto>> findAll() {
        return new ResponseEntity<>(sellerService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<SellerResponseDto> createSeller(@RequestBody SellerCreateRequestDto dto) {
        return new ResponseEntity<>(sellerService.add(dto),HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<SellerResponseDto>  updateSellerById(@RequestBody SellerUpdateDto dto) {
        return new ResponseEntity<>(sellerService.updateSellerById(dto),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<SellerResponseDto> deleteSellerById(@PathVariable long id) {
        return new ResponseEntity<>(sellerService.deletedById(id),HttpStatus.OK);
    }

}
