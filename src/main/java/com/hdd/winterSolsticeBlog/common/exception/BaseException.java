package com.hdd.winterSolsticeBlog.common.exception;

/**
 * @Author hdd
 * @Date 2023-11-11
 **/
public class BaseException extends RuntimeException {

    private final String errorMessage;

    public BaseException( String errorMessage) {
        super(errorMessage);

        this.errorMessage = errorMessage;
    }



    public String getErrorMessage() {
        return errorMessage;
    }
}