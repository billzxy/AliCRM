package com.rishiqing.AliyunCRM.dao;

import com.rishiqing.AliyunCRM.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by 117_John on 7/19/2017.
 */
@Repository("customerDao")
public interface CustomerDao {
    long saveCustomer(Customer customer);
    long updateCustomerById(Map<String,Object>map);
    long deleteCustomerById(long id);
    Customer getCustomerById(long id);
    List<Customer> getAllCustomers();
    List<Customer> getCustomerByBatch(Map<String,Object>map);
    long getCustomerCount();
    List<Customer> searchCustomer(Map<String,Object> paramMap);
    //List<Customer> searchCustomer(String name,String phoneNo, String emailAdd, String verificationCode, Integer rsqLicense, Integer status,
    //Integer maxResult);

}
