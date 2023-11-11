package com.hdd.winterSolsticeBlog.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.sql.Timestamp;

/**
 * @Author hdd
 * @Date 2023-11-11
 **/
@ApiModel(description = "文章DTO")
@Data
public class ArticleDTO {
    @ApiModelProperty(value = "文章ID")
    private Integer id;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "内容")
    private String content;

    @ApiModelProperty(value = "分类")
    private String category;

    @ApiModelProperty(value = "作者ID")
    private Integer authorId;

    @ApiModelProperty(value = "创建时间")
    private Timestamp createdAt;

}
