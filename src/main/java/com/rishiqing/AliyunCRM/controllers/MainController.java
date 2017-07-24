package com.rishiqing.AliyunCRM.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by 117_John on 7/19/2017.
 */

@Controller
public class MainController {

    @RequestMapping("/")
    public String registrate(){return "customerInfoInput";}

    @RequestMapping("/finished")
    public String finished(){
        return "finishedPage";
    }

    @RequestMapping("/addFail")
    public String addFail(){return "error/addFailed";}

    @RequestMapping("/NotFound")
    public String fourohfour(){return "error/404";}

    @RequestMapping("/Denied")
    public String fivehundred(){return "error/500";}

    @RequestMapping("/Forbidden")
    public String fourohthree(){return "error/403";}

    @RequestMapping("/MethodNotAllowed")
    public String fourohfive(){return "error/405";}

}
