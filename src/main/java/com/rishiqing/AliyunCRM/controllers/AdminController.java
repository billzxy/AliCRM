package com.rishiqing.AliyunCRM.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 117_John on 7/20/2017.
 */
@Controller
public class AdminController {

    @RequestMapping("/adminCustomerInfo")
    public String admin(){return "admin/customerInfo";}

    @RequestMapping("/login")
    public  String login(){return "admin/adminLogin";}


}
