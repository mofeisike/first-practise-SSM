package com.mofei.controller;


import com.mofei.pojo.Category;
import com.mofei.pojo.Entry;
import com.mofei.service.CategoryService;
import com.mofei.service.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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

    @RequestMapping("/addTo/{id}")
    public String addTo(@PathVariable("id") Integer id, Model model){
        //提出分类信息
        model.addAttribute("categoryId",id);
        return "addEntry";
    }

    //添加产品
    @RequestMapping("/add")
    public String add(Entry entry,Model model){
        //三目运算
        System.out.println(entry);
        boolean suc = entryService.add(entry) == 1 ? true : false;
        model.addAttribute("suc",suc);
        int id = entry.getId();
        {
            //保留选项的查询列表
            List<Category> cs = categoryService.listbyenrty();
            List<Entry> es = entryService.querylist(id);

            //提示没有数据
            model.addAttribute("em","empty");
            //保留查询结果
            model.addAttribute("categoryid",id);
            model.addAttribute("cs",cs);
            model.addAttribute("es",es);
        }
        return "listEntry";
    }

}
