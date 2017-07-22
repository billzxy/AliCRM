package com.rishiqing.AliyunCRM.controllers;

import com.alibaba.fastjson.JSON;
import com.rishiqing.AliyunCRM.model.Customer;
import com.rishiqing.AliyunCRM.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
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

    @RequestMapping(value = "/getAllCustomers", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getAllCustomerList(){
        List<Map<String,Object>> lmso = customerService.getAllCustomers();
        Map<String,Object> mmp = new HashMap<String, Object>();
        mmp.put("data",lmso);
        mmp.put("totalCount",lmso.size());
        return JSON.toJSONString(mmp);
    }

    @RequestMapping(value="/customer",method=RequestMethod.GET, produces = "application/json; charset=utf-8")
    public String getCustomerById(@RequestParam String id, ModelMap mmp){
        if (id == null || id == "" || !id.matches("^\\d+$")) {
            //logger.warn("Invalid customerId");
            return "error/invalidCustomerId";
        }
        Customer c = customerService.getCustomerById(Integer.parseInt(id));
        if(c==null){
            return "error/invalidCustomerId";
        }
        mmp.addAttribute("name",c.getName());
        mmp.addAttribute("emailAdd",c.getEmailAdd());
        mmp.addAttribute("phoneNo",c.getPhoneNo());
        mmp.addAttribute("verificationCode",c.getVerificationCode());
        mmp.addAttribute("note",c.getCustomerNote());
        mmp.addAttribute("adminNote",c.getAdminNote());
        mmp.addAttribute("status",c.getCustomerStatus());
        mmp.addAttribute("dateCreated",c.getDateCreated());
        mmp.addAttribute("id",c.getId());
        mmp.addAttribute("license",c.getRsqLicense());
        return "admin/customerDetail";
    }

    @RequestMapping(value = "/getCustomer", method = RequestMethod.POST, produces ="application/json; charset=utf-8")
    @ResponseBody
    public String getCustomerByBatch(@RequestBody Map<String,Object> map){
        Integer showMax = (Integer) map.get("max");
        Integer pageN = Integer.parseInt((String)map.get("page"));
        /*if (max == null || max == "" || !max.matches("^\\d+$")) {
            //logger.warn("Invalid customerId");
            return null;
        }
        if (page == null || page == "" || !page.matches("^\\d+$")) {
            //logger.warn("Invalid customerId");
            return null;
        }*/

        if(pageN<=0){
            return null;
        }
        int offset = (pageN-1)*showMax;
        List<Map<String,Object>> lmso = customerService.getCustomerByBatch(showMax,offset);
        Map<String,Object> mmp = new HashMap<String, Object>();
        mmp.put("data",lmso);
        return JSON.toJSONString(mmp);
    }

    @RequestMapping(value = "/getCustomerCount", method = RequestMethod.GET)
    @ResponseBody
    public String getCustomerCount(){
        return String.valueOf( customerService.getCustomerCount());
    }

    @RequestMapping(value="/search",method=RequestMethod.POST, produces ="application/json; charset=utf-8")
    @ResponseBody
    public String search(@RequestBody Map<String,Object> map){
        map.put("status",Integer.parseInt((String)map.get("status")));
        map.put("rsqLicense",Integer.parseInt((String)map.get("rsqLicense")));
        map.put("maxResult",Integer.parseInt((String)map.get("maxResult")));
        List l =customerService.searchCustomer(map);
        if(l==null){
            return "error";
        }
        String s=  JSON.toJSONString(l);
        return s;
    }


}
