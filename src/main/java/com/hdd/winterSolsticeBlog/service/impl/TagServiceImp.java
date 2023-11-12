package com.hdd.winterSolsticeBlog.service.impl;

import com.hdd.winterSolsticeBlog.entity.Tag;
import com.hdd.winterSolsticeBlog.mapper.TagMapper;
import com.hdd.winterSolsticeBlog.service.TagService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 博客标签表 服务实现类
 * </p>
 *
 * @author haodedong
 * @since 2023-11-12
 */
@Service
public class TagServiceImp extends ServiceImpl<TagMapper, Tag> implements TagService {

}
