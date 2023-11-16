package com.hdd.winterSolsticeBlog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hdd.winterSolsticeBlog.entity.Article;
import com.hdd.winterSolsticeBlog.vo.ArticleVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author haodedong
 * @since 2023-11-12
 */
@Mapper
public interface ArticleMapper extends BaseMapper<Article> {

    List<ArticleVO> selectArticleList(String keyword, Integer categoryId, Integer tagId);
}
