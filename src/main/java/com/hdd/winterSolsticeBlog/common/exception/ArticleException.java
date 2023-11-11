package com.hdd.winterSolsticeBlog.common.exception;

/**
 * 文章相关异常
 * @Author hdd
 * @Date 2023-11-11
 **/
public class ArticleException extends BaseException {
    public ArticleException(String errorMessage) {
        super(errorMessage);
    }

    public ArticleException( ErrorMessage errorMessage, String additionalParam) {
        super(errorMessage.getMessage() + additionalParam);
    }
}