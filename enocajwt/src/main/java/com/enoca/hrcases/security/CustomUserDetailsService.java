package com.enoca.hrcases.security;


import com.enoca.hrcases.model.User;
import com.enoca.hrcases.repository.UserRepository;
import com.enoca.hrcases.service.user.UserService;
import com.enoca.hrcases.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userRepository.findByUsername(username).orElseThrow(()-> new UsernameNotFoundException(username));
        Set<GrantedAuthority> authorities=Set.of(SecurityUtils.convertToAuthority(user.getRole().name()));

        return UserPrincipal.builder()
                .user(user).id(user.getId())
                .username(username)
                .password(user.getPassword())
                .authorities(authorities)
                .build()
                ;
    }
}
