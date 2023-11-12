package com.hdd.winterSolsticeBlog.mapper;

import com.hdd.winterSolsticeBlog.entity.ArticleTag;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 文章与标签关联关系表 Mapper 接口
 * </p>
 *
 * @author haodedong
 * @since 2023-11-12
 */
@Mapper
public interface ArticleTagMapper extends BaseMapper<ArticleTag> {

}
