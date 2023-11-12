package com.hdd.winterSolsticeBlog.common.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 通用分页请求体
 *
 * @Author hdd
 * @Date 2023-11-11
 **/
@Data
public class PageRequest {
    @ApiModelProperty(value = "查询页码")
    private Integer pageNo = 1;
    @ApiModelProperty(value = "每页查询数量")
    private Integer pageSize = 5;
}
