package com.rishiqing.AliyunCRM.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by 117_John on 7/20/2017.
 */
@Controller
public class AdminController {

    @RequestMapping("/adminCustomerInfo")
    public String admin(){return "admin/customerInfo";}
/*
    @RequestMapping("/login")
    public  String login(){return "admin/adminLogin";}
*/
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(
            @RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout) {

        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", "用户名密码错误!");
        }

        if (logout != null) {
            model.addObject("msg", "已成功登出！");
        }
        model.setViewName("admin/adminLogin");

        return model;

    }


}
