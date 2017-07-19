package com.rishiqing.AliyunCRM.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by 117_John on 7/19/2017.
 */

@Controller
public class CustomerController {
    //@Autowired
    //private services
    @RequestMapping(value = "/saveInfo", method = RequestMethod.POST)
    public String saveCustomerInfo(@RequestParam String name,@RequestParam String emailAdd,@RequestParam String phoneNo,
                                   @RequestParam String veriCode,@RequestParam String note){


        return "finishedPage";
    }
    @RequestMapping(value = "/saveInfo", method = RequestMethod.POST)
    public String saveCustomerInfo(@RequestParam String name,@RequestParam String emailAdd,@RequestParam String phoneNo,
                                   @RequestParam String veriCode){
        String saveStatus = saveCustomerInfo(name,emailAdd,phoneNo,veriCode);


        return "finishedPage";
    }




}
