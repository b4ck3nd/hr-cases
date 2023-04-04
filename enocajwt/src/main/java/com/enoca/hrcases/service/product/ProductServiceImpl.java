package com.enoca.hrcases.service.product;


import com.enoca.hrcases.dto.product.ProductCreateRequestDto;
import com.enoca.hrcases.dto.product.ProductResponseDto;
import com.enoca.hrcases.dto.product.ProductUpdateRequestDto;
import com.enoca.hrcases.exception.UndefinedException;
import com.enoca.hrcases.model.Product;
import com.enoca.hrcases.model.User;
import com.enoca.hrcases.repository.ProductRepository;
import com.enoca.hrcases.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final ModelMapper mapper;

    @Override
    public ProductResponseDto updateProductStockByProductId(long productId, int stock) {
        if (productRepository.findById(productId).isPresent()) {
            Product product = productRepository.findById(productId).get();
            product.setStock(stock);
            productRepository.save(product);
            return mapper.map(product,ProductResponseDto.class);

        }
        else {
            throw new UndefinedException("urun bulunamadi");
        }
    }

    @Override
    public List<ProductResponseDto> findAll() {
        List<ProductResponseDto> dtos=new ArrayList<>();
        for (Product product : productRepository.findAll()) {
            ProductResponseDto map = mapper.map(product, ProductResponseDto.class);
            dtos.add(map);
        }
        return dtos;
    }

    @Override
    public ProductResponseDto updateProductByProductId(ProductUpdateRequestDto dto) {
        if (productRepository.findById(dto.getProductId()).isPresent()) {
            Product temp=mapper.map(dto,Product.class);
            Product product = updateProductByProductId(productRepository.findById(dto.getProductId()).get(), temp);
            return mapper.map(product,ProductResponseDto.class);
        }
       else {
           throw new UndefinedException("urun bulunamadi");
        }
    }

    @Override
    public ProductResponseDto deleteProductById(long id) {
        if (productRepository.findById(id).isPresent()) {
            ProductResponseDto product=mapper.map(productRepository.findById(id).get(), ProductResponseDto.class);
            productRepository.deleteById(id);
            return product;
        }
       else {
           throw new UndefinedException("urun bulunamadi");
        }
    }

    @Override
    public ProductResponseDto addProduct(ProductCreateRequestDto dto) {
        if (userRepository.findById(dto.getSellerId()).isPresent()) {
            User user = userRepository.findById(dto.getSellerId()).get();
            Product product = productRepository.saveAndFlush(mapper.map(dto, Product.class));
            List<Product> products=new ArrayList<>();
            products.add(product);
            user.setProducts(products);
            userRepository.save(user);
            return mapper.map(product,ProductResponseDto.class);
        }
        else {
            throw new UndefinedException("satici bulunamadi");
        }
    }

    @Override
    public List<ProductResponseDto> findProductByProductNameContaining(String name) {
        List<ProductResponseDto> dtos=new ArrayList<>();
        for (Product product : productRepository.findByProductNameContaining(name)) {
            ProductResponseDto map = mapper.map(product, ProductResponseDto.class);
            dtos.add(map);
        }

        return dtos;
    }

    @Override
    public ProductResponseDto findById(long id) {
        if (productRepository.findById(id).isPresent()) {
            return mapper.map(productRepository.findById(id).get(),ProductResponseDto.class);
        }
        else {
            throw new UndefinedException("urun bulunamadi");
        }
    }

    private Product updateProductByProductId(Product oldProduct,Product temp) {
        temp.setProductName(oldProduct.getProductName());
        temp.setProductDescription(oldProduct.getProductDescription());
        temp.setProductPrice(oldProduct.getProductPrice());
        temp.setStock(oldProduct.getStock());
        return temp;
    }


}
