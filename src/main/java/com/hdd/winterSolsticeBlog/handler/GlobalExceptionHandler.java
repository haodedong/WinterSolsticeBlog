package com.hdd.winterSolsticeBlog.handler;

import com.hdd.winterSolsticeBlog.common.exception.BaseException;
import com.hdd.winterSolsticeBlog.common.vo.JsonResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

/**
 * @Author hdd
 * @Date 2023-11-11
 **/
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(BaseException.class)
    public JsonResult<String> handleArticleException(BaseException ex) {
        // 处理额外参数逻辑
        return JsonResult.failure(ex.getErrorMessage(),500);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        String errorMessage = "发生异常: " + ex.getMessage();
        return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException ex) {
        // 处理约束违反异常
        // ...
        return ResponseEntity.badRequest().body("Validation failed: " + ex.getMessage());
    }

    // 其他自定义异常的处理方法
    // @ExceptionHandler 自定义异常类
    // public ResponseEntity<String> handleCustomException(CustomException ex) {
    //     // 处理自定义异常逻辑
    // }
}
