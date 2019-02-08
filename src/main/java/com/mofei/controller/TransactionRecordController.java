package com.mofei.controller;


import com.github.pagehelper.PageInfo;
import com.mofei.dto.RecordDTO;
import com.mofei.pojo.Category;
import com.mofei.pojo.Entry;
import com.mofei.pojo.TransactionRecord;
import com.mofei.service.CategoryService;
import com.mofei.service.EntryService;
import com.mofei.service.TransactionRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/transactionrecord")
public class TransactionRecordController {

    @Autowired
    private TransactionRecordService transactionRecordService;

    /*
    * form表单 的传输方式
    * */
    @RequestMapping("/query")
    public String queryAllByTime(RecordDTO recordDTO, Model model){
        PageInfo<TransactionRecord> page =  transactionRecordService.queryByCardNo(recordDTO);
        model.addAttribute("page","records");
        System.out.println(page.getList());
        System.out.println(page.getPageNum());
        System.out.println(page.getPages());
        System.out.println(page.getTotal());
        //传输分页数据
        model.addAttribute("pageInfo",page);
        return "main";
    }

    @RequestMapping("/record")
    public String record(Model model){
        model.addAttribute("page","records");
        return "main";
    }



}
