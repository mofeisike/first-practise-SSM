package com.mofei.controller;


import com.mofei.pojo.Category;
import com.mofei.pojo.Entry;
import com.mofei.service.CategoryService;
import com.mofei.service.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/entry")
public class EntryController {


    @Autowired
    EntryService entryService;
    @Autowired
    CategoryService categoryService;

    @RequestMapping("/listEntry")
    public ModelAndView listEnrty(){
        List<Category> cs = categoryService.listbyenrty();
        ModelAndView mav = new ModelAndView("listEntry","cs",cs);
        return mav;
    }

    @RequestMapping("/querytEnrty/categoryid")
    public ModelAndView querytEnrty(@RequestParam("id") Integer id){
        List<Category> cs = categoryService.listbyenrty();
        List<Entry> es = entryService.querylist(id);

        ModelAndView mav = new ModelAndView("listEntry");
        //提示没有数据
        mav.addObject("em","empty");
        //保留查询结果
        mav.addObject("categoryid",id);
        mav.addObject("cs",cs);
        mav.addObject("es",es);
        return mav;
    }

}
