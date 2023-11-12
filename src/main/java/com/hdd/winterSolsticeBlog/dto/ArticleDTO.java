package com.hdd.winterSolsticeBlog.dto;

import com.hdd.winterSolsticeBlog.entity.Category;
import com.hdd.winterSolsticeBlog.entity.Tag;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

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
    private Category category;

    @ApiModelProperty(value = "标签列表")
    private List<Tag> tags;

    @ApiModelProperty(value = "作者ID")
    private Integer authorId;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createdAt;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updatedAt;

}
