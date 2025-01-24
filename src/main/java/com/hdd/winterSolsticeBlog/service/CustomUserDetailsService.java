package com.hdd.winterSolsticeBlog.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Here you can load user from database or any other source
        // For simplicity, we are using a hardcoded user
        if ("user".equals(username)) {
            return org.springframework.security.core.userdetails.User
                    .withUsername("user")
                    .password("{noop}password") // {noop} means no password encoder
                    .roles("USER")
                    .build();
        } else {
            throw new UsernameNotFoundException("User not found");
        }
    }
}
