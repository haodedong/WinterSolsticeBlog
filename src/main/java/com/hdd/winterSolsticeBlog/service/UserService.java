package com.hdd.winterSolsticeBlog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hdd.winterSolsticeBlog.entity.BlogUser;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author haodedong
 * @since 2023-11-12
 */
public interface UserService extends IService<BlogUser> {
    public void createUser(String username, String password);
}
