package com.hdd.winterSolsticeBlog.service.impl;

import com.hdd.winterSolsticeBlog.entity.Comments;
import com.hdd.winterSolsticeBlog.dao.CommentsDao;
import com.hdd.winterSolsticeBlog.service.ICommentsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author haodedong
 * @since 2023-11-11
 */
@Service
public class CommentsServiceImpl extends ServiceImpl<CommentsDao, Comments> implements ICommentsService {

}
