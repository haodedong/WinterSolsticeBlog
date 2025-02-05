package com.hdd.winterSolsticeBlog.dto.request;

import lombok.Data;

@Data
public class AuthRequest {
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
}
