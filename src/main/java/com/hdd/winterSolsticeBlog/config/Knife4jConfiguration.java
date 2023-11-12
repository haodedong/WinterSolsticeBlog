package com.hdd.winterSolsticeBlog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

/**
 * @Author hdd
 * @Date 2023-11-11
 **/
@Configuration
@EnableSwagger2WebMvc
@EnableWebMvc
public class Knife4jConfiguration implements WebMvcConfigurer {

    @Bean(value = "defaultApi2")
    public Docket defaultApi2() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        .title("冬至博客 RESTful APIs")
                        .description("#冬至博客 RESTful APIs")
                        .termsOfServiceUrl("http://www.xx.com/")
                        .contact("haodedong1996@163.com")
                        .version("1.0")
                        .build())
                //分组名称
                .groupName("0.1版本")
                .select()
                //这里指定Controller扫描包路径
                .apis(RequestHandlerSelectors.basePackage("com.hdd.winterSolsticeBlog.controller"))
                .paths(PathSelectors.any())
                .build();
        return docket;
    }

    /**
     * fix knife4j文档页面，报404
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/");
        registry.addResourceHandler("doc.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

}
