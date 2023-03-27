package com.enoca.hrcases.service.seller;


import com.enoca.hrcases.dto.product.ProductResponseDto;
import com.enoca.hrcases.dto.seller.SellerCreateRequestDto;
import com.enoca.hrcases.dto.seller.SellerResponseDto;
import com.enoca.hrcases.dto.seller.SellerUpdateDto;
import com.enoca.hrcases.exception.UndefinedException;
import com.enoca.hrcases.model.Product;
import com.enoca.hrcases.model.Seller;
import com.enoca.hrcases.repository.SellerRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SellerServiceImpl implements SellerService{


    private final SellerRepository sellerRepository;

    private  final ModelMapper mapper;


    @Override
    public SellerResponseDto deletedById(long id) {
        if (sellerRepository.findById(id).isPresent()) {
            SellerResponseDto responseDto=mapper.map(sellerRepository.findById(id).get(),SellerResponseDto.class);
            sellerRepository.deleteById(id);
            return responseDto;
        }
        else {
            throw new UndefinedException("satici bulunamadi");
        }
    }

    @Override
    public SellerResponseDto add(SellerCreateRequestDto dto) {
        Seller seller = mapper.map(dto, Seller.class);
        sellerRepository.save(seller);
        return mapper.map(seller,SellerResponseDto.class);
    }

    @Override
    public List<SellerResponseDto> findAll() {
        List<SellerResponseDto> dtos=new ArrayList<>();

        for (Seller seller : sellerRepository.findAll()) {
            SellerResponseDto map = mapper.map(seller, SellerResponseDto.class);
            dtos.add(map);
        }

        return dtos;
    }

    @Override
    public SellerResponseDto findById(long id) {
        if (sellerRepository.findById(id).isPresent()) {
            return mapper.map(sellerRepository.findById(id).get(), SellerResponseDto.class);
        }
        else {
            throw new UndefinedException("satici bulunamadi");
        }
    }

    @Override
    public SellerResponseDto updateSellerById(SellerUpdateDto dto) {

        if (sellerRepository.findById(dto.getId()).isPresent()) {
            Seller oldSeller=sellerRepository.findById(dto.getId()).get();
            Seller map = mapper.map(dto, Seller.class);
            Seller seller = updateSellerBySellerId(oldSeller, map);
            sellerRepository.save(seller);
            return mapper.map(seller,SellerResponseDto.class);
        }
        else {
            throw new UndefinedException("satici bulunamadi");
        }
    }

    @Override
    public List<ProductResponseDto> findProductBySellerId(long id) {
        if (sellerRepository.findById(id).isPresent()) {
            List<ProductResponseDto> dtos=new ArrayList<>();
            List<Product> products = sellerRepository.findById(id).get().getProducts();
            for (Product product : products) {
                ProductResponseDto map = mapper.map(product, ProductResponseDto.class);
                dtos.add(map);
            }
            return dtos;
        }
        else {
            throw new UndefinedException("satici bulunamadi");
        }
    }

    private Seller updateSellerBySellerId(Seller oldSeller,Seller temp) {
        temp.setProducts(oldSeller.getProducts());
        temp.setEmail(oldSeller.getEmail());
        temp.setName(oldSeller.getName());
        temp.setPassword(oldSeller.getPassword());
        return temp;
    }
}
