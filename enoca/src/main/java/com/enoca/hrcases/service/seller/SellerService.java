package com.enoca.hrcases.service.seller;

import com.enoca.hrcases.dto.product.ProductResponseDto;
import com.enoca.hrcases.dto.seller.SellerCreateRequestDto;
import com.enoca.hrcases.dto.seller.SellerResponseDto;
import com.enoca.hrcases.dto.seller.SellerUpdateDto;

import java.util.List;

public interface SellerService {
    SellerResponseDto deletedById(long id);
    SellerResponseDto add(SellerCreateRequestDto dto);
    List<SellerResponseDto> findAll();
    SellerResponseDto findById(long id);

    SellerResponseDto updateSellerById(SellerUpdateDto dto);

    List<ProductResponseDto> findProductBySellerId(long id);
}
