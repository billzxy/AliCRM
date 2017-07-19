package com.rishiqing.AliyunCRM.service;

import com.rishiqing.AliyunCRM.dao.CustomerDao;
import com.rishiqing.AliyunCRM.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<Customer> getAllCustomers(){
        return customerDao.getAllCustomers();
    }

}
