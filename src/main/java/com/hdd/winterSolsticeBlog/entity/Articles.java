package com.hdd.winterSolsticeBlog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author haodedong
 * @since 2023-11-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Articles implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 分类
     */
    private String category;

    /**
     * 作者ID
     */
    private Integer authorId;

    /**
     * 创建时间
     */
    private LocalDateTime createdAt;


}
