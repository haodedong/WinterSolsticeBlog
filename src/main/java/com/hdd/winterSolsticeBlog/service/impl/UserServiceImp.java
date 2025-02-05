package com.hdd.winterSolsticeBlog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hdd.winterSolsticeBlog.entity.BlogUser;
import com.hdd.winterSolsticeBlog.mapper.UserMapper;
import com.hdd.winterSolsticeBlog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author haodedong
 * @since 2023-11-12
 */
@Service
public class UserServiceImp extends ServiceImpl<UserMapper, BlogUser> implements UserService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserMapper userMapper;

    public void createUser(String username, String password) {
        BlogUser blogUser = new BlogUser();
        blogUser.setUsername(username);
        blogUser.setPassword(passwordEncoder.encode(password));
        blogUser.setBlogEmail("xxx@dd.com");
        userMapper.insert(blogUser);
    }
}
