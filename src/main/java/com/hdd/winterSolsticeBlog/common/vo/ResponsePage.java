package com.hdd.winterSolsticeBlog.common.vo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;


/**
 * 分页查询结果封装类
 *
 * @param <T> 查询结果的数据类型
 * @author haodedong
 */
@ApiModel(value = "分页查询结果")
@Data
public class ResponsePage<T> {
    @ApiModelProperty(value = "当前页码")
    private Integer pageNo;

    @ApiModelProperty(value = "每页查询数量")
    private Integer pageSize;

    @ApiModelProperty(value = "总记录数")
    private Long totalCount;

    @ApiModelProperty(value = "查询结果数据")
    private List<T> data;

}
