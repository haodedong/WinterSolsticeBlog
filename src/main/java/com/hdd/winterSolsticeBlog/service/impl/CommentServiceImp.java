package com.hdd.winterSolsticeBlog.service.impl;

import com.hdd.winterSolsticeBlog.entity.Comment;
import com.hdd.winterSolsticeBlog.mapper.CommentMapper;
import com.hdd.winterSolsticeBlog.service.CommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author haodedong
 * @since 2023-11-12
 */
@Service
public class CommentServiceImp extends ServiceImpl<CommentMapper, Comment> implements CommentService {

}
