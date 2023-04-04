package com.enoca.hrcases.service.user;


import com.enoca.hrcases.dto.product.ProductResponseDto;
import com.enoca.hrcases.dto.user.UserCreateRequestDto;
import com.enoca.hrcases.dto.user.UserResponseDto;
import com.enoca.hrcases.dto.user.UserUpdateDto;
import com.enoca.hrcases.exception.UndefinedException;
import com.enoca.hrcases.model.Product;
import com.enoca.hrcases.model.User;
import com.enoca.hrcases.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;

    private  final ModelMapper mapper;


    @Override
    public UserResponseDto deletedById(long id) {
        if (userRepository.findById(id).isPresent()) {
            UserResponseDto responseDto=mapper.map(userRepository.findById(id).get(), UserResponseDto.class);
            userRepository.deleteById(id);
            return responseDto;
        }
        else {
            throw new UndefinedException("satici bulunamadi");
        }
    }

    @Override
    public UserResponseDto add(UserCreateRequestDto dto) {
        User user = mapper.map(dto, User.class);
        userRepository.save(user);
        return mapper.map(user, UserResponseDto.class);
    }

    @Override
    public List<UserResponseDto> findAll() {
        List<UserResponseDto> dtos=new ArrayList<>();

        for (User user : userRepository.findAll()) {
            UserResponseDto map = mapper.map(user, UserResponseDto.class);
            dtos.add(map);
        }

        return dtos;
    }

    @Override
    public UserResponseDto findById(long id) {
        if (userRepository.findById(id).isPresent()) {
            return mapper.map(userRepository.findById(id).get(), UserResponseDto.class);
        }
        else {
            throw new UndefinedException("satici bulunamadi");
        }
    }

    @Override
    public UserResponseDto updateSellerById(UserUpdateDto dto) {

        if (userRepository.findById(dto.getId()).isPresent()) {
            User oldUser = userRepository.findById(dto.getId()).get();
            User map = mapper.map(dto, User.class);
            User user = updateSellerBySellerId(oldUser, map);
            userRepository.save(user);
            return mapper.map(user, UserResponseDto.class);
        }
        else {
            throw new UndefinedException("satici bulunamadi");
        }
    }

    @Override
    public List<ProductResponseDto> findProductBySellerId(long id) {
        if (userRepository.findById(id).isPresent()) {
            List<ProductResponseDto> dtos=new ArrayList<>();
            List<Product> products = userRepository.findById(id).get().getProducts();
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

    private User updateSellerBySellerId(User oldUser, User temp) {
        temp.setProducts(oldUser.getProducts());
        temp.setEmail(oldUser.getEmail());
        temp.setName(oldUser.getName());
        temp.setPassword(oldUser.getPassword());
        return temp;
    }
}
