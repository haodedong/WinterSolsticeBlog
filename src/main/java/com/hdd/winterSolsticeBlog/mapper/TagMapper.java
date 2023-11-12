package com.hdd.winterSolsticeBlog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hdd.winterSolsticeBlog.entity.Tag;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 博客标签表 Mapper 接口
 * </p>
 *
 * @author haodedong
 * @since 2023-11-12
 */
@Mapper
public interface TagMapper extends BaseMapper<Tag> {
    List<Tag> selectTagsByArticleId(Integer articleId);
}
