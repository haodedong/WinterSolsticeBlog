package com.hdd.winterSolsticeBlog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hdd.winterSolsticeBlog.entity.ArticleTag;
import com.hdd.winterSolsticeBlog.mapper.ArticleTagMapper;
import com.hdd.winterSolsticeBlog.service.ArticleTagService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 文章与标签关联关系表 服务实现类
 * </p>
 *
 * @author haodedong
 * @since 2023-11-12
 */
@Service
public class ArticleTagServiceImp extends ServiceImpl<ArticleTagMapper, ArticleTag> implements ArticleTagService {
    public void batchInsert(List<ArticleTag> articleTags) {
        saveBatch(articleTags);
    }
}
