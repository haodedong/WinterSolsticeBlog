package com.hdd.winterSolsticeBlog.controller;

import com.hdd.winterSolsticeBlog.dto.request.AuthRequest;
import com.hdd.winterSolsticeBlog.service.CustomUserDetailsService;
import com.hdd.winterSolsticeBlog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author haodedong
 * @since 2023-11-11
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<String> createUser(@RequestBody AuthRequest authRequest) {
        userService.createUser(authRequest.getUsername(), authRequest.getPassword());
        return ResponseEntity.ok("User created successfully");
    }
}
