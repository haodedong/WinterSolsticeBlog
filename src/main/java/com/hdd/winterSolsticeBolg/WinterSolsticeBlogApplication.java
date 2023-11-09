package com.hdd.winterSolsticeBolg;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * @author haodedong
 */
@MapperScan("com.hdd.winterSolsticeBlog.dao") // 指定Mapper接口所在的包路径
@SpringBootApplication
public class WinterSolsticeBlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(WinterSolsticeBlogApplication.class, args);
    }

}