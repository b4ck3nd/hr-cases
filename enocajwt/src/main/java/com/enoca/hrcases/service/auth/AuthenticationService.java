package com.enoca.hrcases.service.auth;

import com.enoca.hrcases.dto.auth.LoginRequestDto;
import com.enoca.hrcases.dto.auth.RegisterRequestDto;

public interface AuthenticationService {
    String login(LoginRequestDto loginRequest);
    String register(RegisterRequestDto dto);
}
