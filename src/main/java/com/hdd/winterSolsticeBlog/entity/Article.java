package com.hdd.winterSolsticeBlog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author haodedong
 * @since 2023-11-12
 */
@Getter
@Setter
@TableName("article")
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 标题
     */
    @TableField("title")
    private String title;

    /**
     * 内容
     */
    @TableField("content")
    private String content;

    /**
     * 博客摘要，如为传递，则中正文中截取开头一段
     */
    @TableField("summary")
    private String summary;

    /**
     * 分类ID,一篇文章只允许属于一个分类
     */
    @TableField("category_id")
    private Integer categoryId;

    /**
     * 作者ID
     */
    @TableField("author_id")
    private Integer authorId;

    /**
     * 创建时间
     */
    @TableField("created_at")
    private LocalDateTime createdAt;

    /**
     * 更新时间
     */
    @TableField("updated_at")
    private LocalDateTime updatedAt;
}
