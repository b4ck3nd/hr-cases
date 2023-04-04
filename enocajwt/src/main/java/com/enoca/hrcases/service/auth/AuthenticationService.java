package com.enoca.hrcases.service.auth;

import com.enoca.hrcases.dto.login.LoginRequestDto;
import com.enoca.hrcases.dto.user.UserLoginResponseDto;
import com.enoca.hrcases.model.User;

public interface AuthenticationService {
    String login(LoginRequestDto loginRequest);
}
