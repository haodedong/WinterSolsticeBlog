package com.hdd.winterSolsticeBlog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hdd.winterSolsticeBlog.dao.ArticlesDao;
import com.hdd.winterSolsticeBlog.entity.Articles;
import com.hdd.winterSolsticeBlog.service.IArticlesService;
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
public class ArticlesServiceImpl extends ServiceImpl<ArticlesDao, Articles> implements IArticlesService {

}
