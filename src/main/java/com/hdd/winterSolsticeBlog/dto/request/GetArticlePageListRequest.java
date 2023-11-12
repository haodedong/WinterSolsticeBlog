package com.hdd.winterSolsticeBlog.dto.request;

import com.hdd.winterSolsticeBlog.common.vo.PageRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author hdd
 * @Date 2023-11-12
 **/
@Data
public class GetArticlePageListRequest extends PageRequest {
    @ApiModelProperty(value = "内容关键字")
    private String keyword;

    @ApiModelProperty(value = "分类ID")
    private Integer categoryId;

    @ApiModelProperty(value = "标签ID")
    private Integer tagId;
}
