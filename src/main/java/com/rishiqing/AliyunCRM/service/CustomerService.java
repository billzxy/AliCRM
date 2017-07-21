package com.rishiqing.AliyunCRM.service;

import com.rishiqing.AliyunCRM.dao.CustomerDao;
import com.rishiqing.AliyunCRM.model.Customer;
import com.sun.org.apache.xerces.internal.xs.StringList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 117_John on 7/19/2017.
 */
@Service("customerService")
public class CustomerService {
    @Autowired
    private CustomerDao customerDao;

    public long saveCustomer(Customer customer){
        customerDao.saveCustomer(customer);
        return 1;
    }
    public long updateCustomerById(long id, Customer customer){
        customerDao.updateCustomerById(id,customer);
        return 1;
    }
    public long deleteCustomerById(long id){
        customerDao.deleteCustomerById(id);
        return 1;
    }
    public Customer getCustomerById(long id){
        return customerDao.getCustomerById(id);
    }

    public List<Map<String,Object>> getAllCustomers(){
        List<Customer> lc = customerDao.getAllCustomers();
        List<Map<String,Object>> customers = new ArrayList<Map<String, Object>>();
        for(Customer c : lc){
            Map<String,Object> mmp = new HashMap<String, Object>();
            mmp.put("name",c.getName());
            mmp.put("emailAdd",c.getEmailAdd());
            mmp.put("phoneNo",c.getPhoneNo());
            mmp.put("verificationCode",c.getVerificationCode());
            mmp.put("note",c.getCustomerNote());
            mmp.put("adminNote",c.getAdminNote());
            mmp.put("status",c.getCustomerStatus());
            mmp.put("dateCreated",c.getDateCreated());
            mmp.put("id",c.getId());
            mmp.put("license",c.getRsqLicense());
            customers.add(mmp);
        }
        return customers;
    }
    public List<Map<String,Object>> getCustomerByBatch(int showMax, int offset){
        List<Customer> lc = customerDao.getCustomerByBatch(showMax, offset);
        List<Map<String,Object>> customers = new ArrayList<Map<String, Object>>();
        for(Customer c : lc){
            Map<String,Object> mmp = new HashMap<String, Object>();
            mmp.put("name",c.getName());
            mmp.put("emailAdd",c.getEmailAdd());
            mmp.put("phoneNo",c.getPhoneNo());
            mmp.put("verificationCode",c.getVerificationCode());
            mmp.put("note",c.getCustomerNote());
            mmp.put("adminNote",c.getAdminNote());
            mmp.put("status",c.getCustomerStatus());
            mmp.put("dateCreated",c.getDateCreated());
            mmp.put("id",c.getId());
            mmp.put("license",c.getRsqLicense());
            customers.add(mmp);
        }
        return customers;
    }

    public long getCustomerCount(){
        return customerDao.getCustomerCount();
    }

}
