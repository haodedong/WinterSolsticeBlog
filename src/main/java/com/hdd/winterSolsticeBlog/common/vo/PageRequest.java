package com.hdd.winterSolsticeBlog.common.vo;

import lombok.Data;

/**
 * 通用分页请求体
 *
 * @Author hdd
 * @Date 2023-11-11
 **/
@Data
public class PageRequest {
    private Integer pageNo;

    private Integer pageSize;
}
