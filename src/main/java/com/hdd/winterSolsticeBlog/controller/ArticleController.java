package com.hdd.winterSolsticeBlog.controller;

import com.hdd.winterSolsticeBlog.common.vo.JsonResult;
import com.hdd.winterSolsticeBlog.common.vo.ResponsePage;
import com.hdd.winterSolsticeBlog.dto.ArticleDTO;
import com.hdd.winterSolsticeBlog.dto.request.GetArticlePageListRequest;
import com.hdd.winterSolsticeBlog.service.ArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
//    @ApiImplicitParam(name = "name",value = "姓名",required = true)
//    @ApiOperation(value = "向客人问好")
//    @GetMapping("/sayHi")
//    public ResponseEntity<String> sayHi(@RequestParam(value = "name")String name){
//        if(true){
//            String additionalParam = "some additional information";
//            throw new ArticleException(ErrorMessage.INVALID_INPUT, additionalParam);
//        }
//
//        return ResponseEntity.ok("Hi:"+name);
//    }

    @ApiOperation(value = "分页展示博客列表")
    @PostMapping("page")
    public JsonResult<ResponsePage<ArticleDTO>> getArticlePageList(@RequestBody GetArticlePageListRequest request) {
        return JsonResult.success(articleService.getArticlePageList(request));
    }
}
