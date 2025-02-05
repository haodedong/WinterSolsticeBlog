package com.hdd.winterSolsticeBlog.service;


import com.hdd.winterSolsticeBlog.entity.BlogUser;
import com.hdd.winterSolsticeBlog.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        BlogUser blogUser = userMapper.findByUsername(username);
        if (blogUser == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return org.springframework.security.core.userdetails.User
                .withUsername(blogUser.getUsername())
                .password(blogUser.getPassword())
                .roles("USER")
                .build();
    }


}
