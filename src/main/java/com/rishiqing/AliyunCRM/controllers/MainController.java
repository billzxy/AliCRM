package com.rishiqing.AliyunCRM.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 117_John on 7/19/2017.
 */

@Controller
public class MainController {

    @RequestMapping("/registration")
    public String registrate(){
        return "customerInfoInput";
    }

    @RequestMapping("/finished")
    public String finished(){
        return "finishedPage";
    }

    @RequestMapping("/addFail")
    public String addFail(){return "/error/addFailed";}
}
