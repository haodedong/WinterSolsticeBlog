package com.hdd.winterSolsticeBlog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hdd.winterSolsticeBlog.dao.UsersDao;
import com.hdd.winterSolsticeBlog.entity.Users;
import com.hdd.winterSolsticeBlog.service.IUsersService;
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
public class UsersServiceImpl extends ServiceImpl<UsersDao, Users> implements IUsersService {

}
