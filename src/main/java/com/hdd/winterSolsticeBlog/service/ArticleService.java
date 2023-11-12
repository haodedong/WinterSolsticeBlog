package com.hdd.winterSolsticeBlog.service;

import com.hdd.winterSolsticeBlog.common.vo.ResponsePage;
import com.hdd.winterSolsticeBlog.dto.ArticleDTO;
import com.hdd.winterSolsticeBlog.dto.request.GetArticlePageListRequest;
import com.hdd.winterSolsticeBlog.entity.Article;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author haodedong
 * @since 2023-11-12
 */
public interface ArticleService extends IService<Article> {

    ResponsePage<ArticleDTO> getArticlePageList(GetArticlePageListRequest request);
}
