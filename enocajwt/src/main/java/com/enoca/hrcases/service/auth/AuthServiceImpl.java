package com.enoca.hrcases.service.auth;

import com.enoca.hrcases.dto.login.LoginRequestDto;
import com.enoca.hrcases.dto.user.UserLoginResponseDto;
import com.enoca.hrcases.model.User;
import com.enoca.hrcases.security.UserPrincipal;
import com.enoca.hrcases.security.jwt.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthenticationService {
    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;
    @Override
    public UserLoginResponseDto login(LoginRequestDto loginRequest) {
        Authentication authentication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),loginRequest.getPassword()));
        UserPrincipal userPrincipal =(UserPrincipal) authentication.getPrincipal();
        String jwt=jwtProvider.generateToken(userPrincipal);
        User user = userPrincipal.getUser();
        UserLoginResponseDto dto=new UserLoginResponseDto();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setPassword(user.getPassword());

        return dto;
    }
}
