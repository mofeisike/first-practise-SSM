package com.mofei.service.serviceimpl;

import com.mofei.mapper.CategoryMapper;
import com.mofei.mapper.NewsCommentMapper;
import com.mofei.pojo.Category;
import com.mofei.pojo.NewsComment;
import com.mofei.service.CategoryService;
import com.mofei.service.NewsCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("newsCommentsService")
public class NewsCommentServiceimpl implements NewsCommentService {

    @Autowired
    NewsCommentMapper newsCommentMapper;

    @Override
    public List<NewsComment> queryCommentsByNewsId(Integer newsId) {

        return newsCommentMapper.queryCommentsByNewsId(newsId);
    }

    @Override
    public boolean add(NewsComment newsComment) {
        int row = newsCommentMapper.add(newsComment);
        return row == 1 ? true : false;
    }

    //演示,其实是为了 Category的链表删除中使用,
    @Override
    public NewsComment get(int id) {
        return newsCommentMapper.get(id);
    }
}
