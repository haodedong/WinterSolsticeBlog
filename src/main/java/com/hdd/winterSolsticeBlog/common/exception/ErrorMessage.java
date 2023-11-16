package com.hdd.winterSolsticeBlog.common.exception;

/**
 * 错误message文言
 *
 * @Author hdd
 * @Date 2023-11-11
 **/
public enum ErrorMessage {
    ARTICLE_CATEGORY_NOT_EXIST("保存博文失败，该分类id：{0}不存在"),
    ARTICLE_TAG_NOT_EXIST("保存博文失败，标签id列表中{0}，部门标签不存在"),
    INVALID_INPUT("Invalid input"),
    NOT_FOUND("Resource not found"),
    UNAUTHORIZED("Unauthorized access");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
