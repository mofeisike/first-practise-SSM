package com.mofei.controller;


import com.mofei.pojo.Category;
import com.mofei.pojo.NewsComment;
import com.mofei.service.CategoryService;
import com.mofei.service.NewsCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/comments")
public class NewsCommentController {

    @Autowired
    NewsCommentService newsCommentService;
    @Autowired
    CategoryService categoryService;

    @RequestMapping("/query/newid/{id}")
    public String queryCommentsByNewsId(@PathVariable("id") Integer newsId, Model model){
        List<NewsComment> l = newsCommentService.queryCommentsByNewsId(newsId);
        model.addAttribute("comments",l);
        return "comments";
    }

    @RequestMapping("/addTo/{id}")
    public String addTo(@PathVariable("id") Integer newsId, Model model){
        model.addAttribute("newsId",newsId);
        return "addComment";
    }

    @RequestMapping("/add")
    public String add(NewsComment newsComment, Model model){
        final boolean add = newsCommentService.add(newsComment);
        Category category = categoryService.get(1);
        newsComment.setCategory(category);
        System.out.println(newsComment);
        List<NewsComment> l = newsCommentService.queryCommentsByNewsId(newsComment.getCategory().getId());
        model.addAttribute("comments",l);
        return "comments";
    }

}
