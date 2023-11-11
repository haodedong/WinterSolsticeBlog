package com.hdd.winterSolsticeBlog.common.vo;

/**
 * 通用返回体
 * @Author hdd
 * @Date 2023-11-11
 **/
public class JsonResult<T> {
    private T data;
    private String message;
    private int code;

    public JsonResult() {
    }

    public JsonResult(T data, String message, int code) {
        this.data = data;
        this.message = message;
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    // 通用的成功响应方法
    public static <T> JsonResult<T> success(T data) {
        return new JsonResult<>(data, "Success", 200);
    }

    // 通用的失败响应方法
    public static <T> JsonResult<T> failure(String message, int code) {
        return new JsonResult<>(null, message, code);
    }
}