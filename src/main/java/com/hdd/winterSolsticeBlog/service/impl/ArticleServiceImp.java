package com.hdd.winterSolsticeBlog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hdd.winterSolsticeBlog.common.vo.ResponsePage;
import com.hdd.winterSolsticeBlog.dto.ArticleDTO;
import com.hdd.winterSolsticeBlog.dto.request.GetArticlePageListRequest;
import com.hdd.winterSolsticeBlog.entity.Article;
import com.hdd.winterSolsticeBlog.entity.Category;
import com.hdd.winterSolsticeBlog.entity.Tag;
import com.hdd.winterSolsticeBlog.mapper.ArticleMapper;
import com.hdd.winterSolsticeBlog.mapper.CategoryMapper;
import com.hdd.winterSolsticeBlog.mapper.TagMapper;
import com.hdd.winterSolsticeBlog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author haodedong
 * @since 2023-11-12
 */
@Service
public class ArticleServiceImp extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private TagMapper tagMapper;
    @Override
    public ResponsePage<ArticleDTO> getArticlePageList(GetArticlePageListRequest request) {
        Category category = categoryMapper.selectById(1);
        List<Tag> tags = tagMapper.selectTagsByArticleId(1);
        PageHelper.startPage(request.getPageNo(), request.getPageSize());
        List<ArticleDTO> articleList = articleMapper.selectArticleList(request.getKeyword(),
                request.getCategoryId(),
                request.getTagId());
        PageInfo<ArticleDTO> pageInfo = new PageInfo<>(articleList);

        ResponsePage<ArticleDTO> responsePage = new ResponsePage<>();
        responsePage.setPageNo(pageInfo.getPageNum());
        responsePage.setPageSize(pageInfo.getPageSize());
        responsePage.setTotalCount(pageInfo.getTotal());
        responsePage.setData(articleList);

        return responsePage;
    }

}
