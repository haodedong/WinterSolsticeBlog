package com.hdd.winterSolsticeBlog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hdd.winterSolsticeBlog.common.vo.ResponsePage;
import com.hdd.winterSolsticeBlog.dto.ArticleDTO;
import com.hdd.winterSolsticeBlog.dto.request.GetArticlePageListRequest;
import com.hdd.winterSolsticeBlog.entity.Article;
import com.hdd.winterSolsticeBlog.entity.ArticleTag;
import com.hdd.winterSolsticeBlog.entity.Category;
import com.hdd.winterSolsticeBlog.entity.Tag;
import com.hdd.winterSolsticeBlog.mapper.ArticleMapper;
import com.hdd.winterSolsticeBlog.mapper.CategoryMapper;
import com.hdd.winterSolsticeBlog.mapper.TagMapper;
import com.hdd.winterSolsticeBlog.service.ArticleService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 服务实现类
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

    @Autowired
    private ArticleTagServiceImp articleTagService;

    @Override
    public ResponsePage<ArticleDTO> getArticlePageList(GetArticlePageListRequest request) {
        PageHelper.startPage(request.getPageNo(), request.getPageSize());
        // TODO 按时间倒序
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

    @Override
    public ArticleDTO getArticleById(Integer id) {
        ArticleDTO articleDTO = new ArticleDTO();

        Article article = articleMapper.selectById(id);
        if (article != null) {
            //TODO 考虑添加wrapper类，用于Article实体对象与ArticleDTO对象之间的属性复制、类的转换，
            // 可以考虑build模式往DTO中不断的.withTages(xxx).withCategory()
            // 以及分类和标签是否可以存在于缓存中

            BeanUtils.copyProperties(article, articleDTO);
            Category category = categoryMapper.selectById(article.getCategoryId());
            if (category != null) {
                articleDTO.setCategory(category);
            }

            List<Tag> tags = tagMapper.selectTagsByArticleId(id);
            if (CollectionUtils.isNotEmpty(tags)) {
                articleDTO.setTags(tags);
            }
        }
        return articleDTO;
    }

    @Transactional
    @Override
    public void saveOrUpdateArticle(ArticleDTO request) {
        Integer id = request.getId();

        Article articleEntity = new Article();
        BeanUtils.copyProperties(request, articleEntity);
        Category category = request.getCategory();
        if (category != null) {
            articleEntity.setCategoryId(category.getId());
        }
        List<Tag> tags = request.getTags();
        List<ArticleTag> needInsertArticleTags = null;
        if (CollectionUtils.isNotEmpty(tags)) {
            needInsertArticleTags = tags.stream().map(tag -> {
                ArticleTag articleTag = new ArticleTag();
                articleTag.setArticleId(articleEntity.getId());
                articleTag.setTagId(tag.getId());
                return articleTag;
            }).collect(Collectors.toList());
        }


        if (id == null) {
            // 创建博文
            articleMapper.insert(articleEntity);
            if (CollectionUtils.isNotEmpty(needInsertArticleTags)) {
                articleTagService.batchInsert(needInsertArticleTags);
            }
        } else {
            // 更新博文
            articleMapper.updateById(articleEntity);

            if (CollectionUtils.isNotEmpty(needInsertArticleTags)) {
                LambdaQueryWrapper<ArticleTag> lambdaQueryWrapper = new LambdaQueryWrapper<>();
                lambdaQueryWrapper.eq(ArticleTag::getArticleId, request.getId());
                articleTagService.remove(lambdaQueryWrapper);
                articleTagService.batchInsert(needInsertArticleTags);
            }
        }
    }

}
