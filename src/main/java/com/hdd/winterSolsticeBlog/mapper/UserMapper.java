package com.hdd.winterSolsticeBlog.mapper;

import com.hdd.winterSolsticeBlog.entity.BlogUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author haodedong
 * @since 2023-11-12
 */
@Mapper
public interface UserMapper extends BaseMapper<BlogUser> {
    BlogUser findByUsername(String username);
}
