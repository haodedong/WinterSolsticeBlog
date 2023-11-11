package com.hdd.winterSolsticeBlog.service.impl;

import com.hdd.winterSolsticeBlog.entity.User;
import com.hdd.winterSolsticeBlog.mapper.UserMapper;
import com.hdd.winterSolsticeBlog.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author haodedong
 * @since 2023-11-11
 */
@Service
public class UserServiceImp extends ServiceImpl<UserMapper, User> implements UserService {

}
