package com.mofei.controller;


import com.mofei.pojo.Category;
import com.mofei.pojo.Property;
import com.mofei.service.CategoryService;
import com.mofei.service.PropertyService;
import com.mofei.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/propety")
public class PropetyController {

    @Autowired
    PropertyService propertyService;
    @Autowired
    CategoryService categoryService;

    @RequestMapping("/addProperty")
    public ModelAndView addProperty(Property property){
        //System.out.println("property:"+property.toString());
        propertyService.add(property);
        ModelAndView mav = new ModelAndView("redirect:/propety/listProperty?id="+property.getCid());
        return mav;
    }

    @RequestMapping("/deleteProperty")
    public ModelAndView deleteProperty(Property property){
        Property p = propertyService.get(property.getId());
        propertyService.detele(p);
        ModelAndView mav = new ModelAndView("redirect:/propety/listProperty?id="+p.getCid());
        return mav;
    }

    @RequestMapping("/editProperty")
    public ModelAndView editProperty(Property property){
        Property p = propertyService.get(property.getId());
        Category category = categoryService.get(p.getCid());
        p.setCategory(category);
        ModelAndView mav = new ModelAndView("editProperty","p",p);
        return mav;
    }

    @RequestMapping("/updateProperty")
    public ModelAndView updateProperty(Property property){
        propertyService.update(property);
        ModelAndView mav = new ModelAndView("redirect:/propety/listProperty?id="+property.getCid());
        return mav;
    }

    //传统风格
    @RequestMapping("/listProperty")
    public ModelAndView listProperty(int id){
        Category cc = categoryService.get(id);
        List<Property> ps = propertyService.list(id);
        ModelAndView mav = new ModelAndView("listProperty");
        mav.addObject("ps",ps);
        mav.addObject("cc",cc);
        //System.out.println(cc.toString());
        return mav;
    }

}
