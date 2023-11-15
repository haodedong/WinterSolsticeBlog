package com.hdd.winterSolsticeBlog.controller;

import com.hdd.winterSolsticeBlog.common.vo.JsonResult;
import com.hdd.winterSolsticeBlog.common.vo.ResponsePage;
import com.hdd.winterSolsticeBlog.dto.ArticleDTO;
import com.hdd.winterSolsticeBlog.dto.request.GetArticlePageListRequest;
import com.hdd.winterSolsticeBlog.service.ArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author haodedong
 * @since 2023-11-11
 */
@Api(tags = "博客文章模块")
@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @ApiOperation(value = "分页展示博客列表")
    @PostMapping("page")
    public JsonResult<ResponsePage<ArticleDTO>> getArticlePageList(@RequestBody GetArticlePageListRequest request) {
        return JsonResult.success(articleService.getArticlePageList(request));
    }

    @ApiOperation(value = "根据ID查询博客文章信息")
    @GetMapping("/{id}")
    public JsonResult<ArticleDTO> getArticleById(@PathVariable(name = "id") Integer id) {
        return JsonResult.success(articleService.getArticleById(id));
    }

    @ApiOperation(value = "保持博客文章")
    @PostMapping("/")
    public JsonResult<Void> saveArticle(@Validated @RequestBody ArticleDTO request) {
        articleService.saveOrUpdateArticle(request);
        return JsonResult.success(null);
    }
}
