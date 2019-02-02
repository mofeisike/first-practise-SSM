package com.mofei.service.serviceimpl;

import com.mofei.mapper.CategoryMapper;
import com.mofei.mapper.NewsCommentMapper;
import com.mofei.pojo.Category;
import com.mofei.pojo.NewsComment;
import com.mofei.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("categoryService")
public class CategoryServiceimpl implements CategoryService {


    @Autowired
    CategoryMapper categoryMapper;
    @Autowired
    NewsCommentMapper newsCommentMapper;

    @Override
    public List<Category> list() {
        return categoryMapper.list();
    }


    @Override
    public void add(Category category) {
        categoryMapper.add(category);
    }

    @Override
    public void detele(Category category) {
        categoryMapper.delete(category.getId());
    }

    @Override
    public void update(Category category) {
        categoryMapper.update(category);
    }

    @Override
    public Category get(int id) {
        return categoryMapper.get(id);
    }

    @Override
    public List<Category> getName(String name) {
        return categoryMapper.getName(name);
    }

    @Override
    public List<Category> getNameByObj(Category category) {
        return categoryMapper.getNameByObj(category);
    }

    @Override
    public boolean deteleComments(Integer id) {
        //调用两个mapper方法

        //这里的newid 是单独在Newcomments里面查询一次get的,不在Newcommnet实现,在Category里面实现
        //int newsid = newsCommentMapper.get(id).getNewid();
        //System.out.println(newsid);
        System.out.println(id);

        //1.删除所有评论 id = newid
        newsCommentMapper.deleteComment(id);

        //2 删除新闻
        int row = categoryMapper.deleteComment(id);

        return row == 1 ? true: false;
    }
}
