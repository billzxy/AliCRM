package com.rishiqing.AliyunCRM.controllers;

import com.alibaba.fastjson.JSONObject;
import com.rishiqing.AliyunCRM.model.Customer;
import com.rishiqing.AliyunCRM.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by 117_John on 7/19/2017.
 */

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/saveInfoWNote", method = RequestMethod.POST)
    @ResponseBody
    public String saveCustomerInfoWithNote(@RequestBody Map<String,Object> map){
                                           //@RequestParam String name,@RequestParam String emailAdd,@RequestParam String phoneNo,
        //                     @RequestParam String verificationCode,@RequestParam String note){

        String name = (String)map.get("name");
        String emailAdd = (String)map.get("emailAdd");
        String phoneNo = (String)map.get("phoneNo");
        String verificationCode = (String)map.get("verificationCode");
        String note = (String)map.get("note");

        long saveStatus = saveCustomer(name, emailAdd, phoneNo, verificationCode, note);
        if(saveStatus==1){
            System.out.println("saveCustomerInfoWithNote:OK");
            return "ok";
        }else{
            return "failed";
        }
    }
    @RequestMapping(value = "/saveInfo", method = RequestMethod.POST)
    @ResponseBody
    public String saveCustomerInfo(@RequestBody Map<String,Object> map){
            //@RequestParam String name,@RequestParam String emailAdd,@RequestParam String phoneNo,
              //                     @RequestParam String verificationCode){
        String name = (String)map.get("name");
        String emailAdd = (String)map.get("emailAdd");
        String phoneNo = (String)map.get("phoneNo");
        String verificationCode = (String)map.get("verificationCode");
        long saveStatus = saveCustomer(name,emailAdd,phoneNo,verificationCode);
        if(saveStatus==1){
            return "ok";
        }else{
            return "failed";
        }
    }
    private long saveCustomer(String name, String emailAdd, String phoneNo, String verificationCode, String note){
        Customer customer = new Customer(name,phoneNo,emailAdd,verificationCode,note);
        return customerService.saveCustomer(customer);

    }
    private long saveCustomer(String name, String emailAdd, String phoneNo, String verificationCode){
        Customer customer = new Customer(name,phoneNo,emailAdd,verificationCode);
        return customerService.saveCustomer(customer);
    }





}
