package com.hdd.winterSolsticeBlog.common.exception;

/**
 * 错误message文言
 * @Author hdd
 * @Date 2023-11-11
 **/
public enum ErrorMessage {
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
