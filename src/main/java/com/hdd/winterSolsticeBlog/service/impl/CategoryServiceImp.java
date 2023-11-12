package com.hdd.winterSolsticeBlog.service.impl;

import com.hdd.winterSolsticeBlog.entity.Category;
import com.hdd.winterSolsticeBlog.mapper.CategoryMapper;
import com.hdd.winterSolsticeBlog.service.CategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author haodedong
 * @since 2023-11-12
 */
@Service
public class CategoryServiceImp extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

}
