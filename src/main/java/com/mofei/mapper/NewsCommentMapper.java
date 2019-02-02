package com.mofei.mapper;


import com.mofei.pojo.Category;
import com.mofei.pojo.NewsComment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NewsCommentMapper {


    List<NewsComment> queryCommentsByNewsId(@Param("newsId") Integer newsId);

    int add(@Param("newsComment") NewsComment newsComment);

    //删除新闻的评论
    void deleteComment(@Param("newsid") Integer id);

    NewsComment get(@Param("id") Integer id);
}
