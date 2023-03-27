package com.enoca.hrcases.service.product;

import com.enoca.hrcases.dto.product.ProductCreateRequestDto;
import com.enoca.hrcases.dto.product.ProductResponseDto;
import com.enoca.hrcases.dto.product.ProductUpdateRequestDto;
import com.enoca.hrcases.model.Product;

import java.util.List;

public interface ProductService {

    ProductResponseDto updateProductStockByProductId(long productId,int stock);
    List<ProductResponseDto> findAll();

    ProductResponseDto updateProductByProductId(ProductUpdateRequestDto dto);

    ProductResponseDto deleteProductById(long id);

    ProductResponseDto addProduct(ProductCreateRequestDto dto);


}
