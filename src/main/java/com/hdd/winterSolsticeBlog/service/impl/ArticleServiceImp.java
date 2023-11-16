package com.hdd.winterSolsticeBlog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hdd.winterSolsticeBlog.common.exception.ArticleException;
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
import com.hdd.winterSolsticeBlog.vo.ArticleVO;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static com.hdd.winterSolsticeBlog.common.exception.ErrorMessage.ARTICLE_CATEGORY_NOT_EXIST;
import static com.hdd.winterSolsticeBlog.common.exception.ErrorMessage.ARTICLE_TAG_NOT_EXIST;

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
    public ResponsePage<ArticleVO> getArticlePageList(GetArticlePageListRequest request) {
        PageHelper.startPage(request.getPageNo(), request.getPageSize());
        // TODO 按时间倒序
        List<ArticleVO> articleList = articleMapper.selectArticleList(request.getKeyword(),
                request.getCategoryId(),
                request.getTagId());
        PageInfo<ArticleVO> pageInfo = new PageInfo<>(articleList);

        ResponsePage<ArticleVO> responsePage = new ResponsePage<>();
        responsePage.setPageNo(pageInfo.getPageNum());
        responsePage.setPageSize(pageInfo.getPageSize());
        responsePage.setTotalCount(pageInfo.getTotal());
        responsePage.setData(articleList);

        return responsePage;
    }

    @Override
    public ArticleVO getArticleById(Integer id) {
        ArticleVO articleVO = new ArticleVO();

        Article article = articleMapper.selectById(id);
        if (article != null) {
            //TODO 考虑添加wrapper类，用于Article实体对象与ArticleDTO对象之间的属性复制、类的转换，
            // 可以考虑build模式往DTO中不断的.withTages(xxx).withCategory()
            // 以及分类和标签是否可以存在于缓存中

            BeanUtils.copyProperties(article, articleVO);
            Category category = categoryMapper.selectById(article.getCategoryId());
            if (category != null) {
                articleVO.setCategory(category);
            }

            List<Tag> tags = tagMapper.selectTagsByArticleId(id);
            if (CollectionUtils.isNotEmpty(tags)) {
                articleVO.setTags(tags);
            }
        }
        return articleVO;
    }

    @Transactional
    @Override
    public void saveOrUpdateArticle(ArticleDTO request) {
        Integer id = request.getId();
        Article articleEntity = new Article();
        BeanUtils.copyProperties(request, articleEntity);
        List<Integer> tagIds = request.getTagIds();
        List<ArticleTag> needInsertArticleTags = null;
        if (CollectionUtils.isNotEmpty(tagIds)) {
            needInsertArticleTags = tagIds.stream().map(tagId -> {
                ArticleTag articleTag = new ArticleTag();
                articleTag.setArticleId(articleEntity.getId());
                articleTag.setTagId(tagId);
                return articleTag;
            }).collect(Collectors.toList());
        }

        if (id == null) {
            // 创建博文
            articleEntity.setCreatedAt(LocalDateTime.now());
            articleEntity.setUpdatedAt(LocalDateTime.now());
            articleMapper.insert(articleEntity);
        } else {
            // 更新博文
            articleEntity.setUpdatedAt(LocalDateTime.now());
            articleMapper.updateById(articleEntity);

            LambdaQueryWrapper<ArticleTag> lambdaQueryWrapper = new LambdaQueryWrapper<>();
            lambdaQueryWrapper.eq(ArticleTag::getArticleId, request.getId());
            articleTagService.remove(lambdaQueryWrapper);
        }
        if (CollectionUtils.isNotEmpty(needInsertArticleTags)) {
            articleTagService.batchInsert(needInsertArticleTags);
        }
    }

    @Override
    public void checkArticleInfo(ArticleDTO request) {
        Integer categoryId = request.getCategoryId();
        if (categoryId != null) {
            LambdaQueryWrapper<Category> categoryLambdaQueryWrapper = new LambdaQueryWrapper<>();
            categoryLambdaQueryWrapper.eq(Category::getId, categoryId);
            Long categoryCount = categoryMapper.selectCount(categoryLambdaQueryWrapper);
            if (categoryCount == null || categoryCount != 1) {
                throw new ArticleException(ARTICLE_CATEGORY_NOT_EXIST, String.valueOf(categoryId));
            }

            List<Integer> tagIds = request.getTagIds();
            if (CollectionUtils.isNotEmpty(tagIds)) {
                LambdaQueryWrapper<Tag> tagLambdaQueryWrapper = new LambdaQueryWrapper<>();
                tagLambdaQueryWrapper.in(Tag::getId, tagIds);
                Long tagCount = tagMapper.selectCount(tagLambdaQueryWrapper);
                if (tagCount == null || tagCount != tagIds.size()) {
                    throw new ArticleException(ARTICLE_TAG_NOT_EXIST, tagIds.toString());//TODO gson
                }
            }

        }
    }

}
