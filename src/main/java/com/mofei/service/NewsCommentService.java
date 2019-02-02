package com.mofei.service;


import com.mofei.pojo.Category;
import com.mofei.pojo.NewsComment;

import java.util.List;

public interface NewsCommentService {


    List<NewsComment> queryCommentsByNewsId(Integer newsId);

    boolean add(NewsComment newsComment);

    NewsComment get(int id);

}
