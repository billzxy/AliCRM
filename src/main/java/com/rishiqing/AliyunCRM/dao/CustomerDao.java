package com.rishiqing.AliyunCRM.dao;

import com.rishiqing.AliyunCRM.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 117_John on 7/19/2017.
 */
@Repository("customerDao")
public interface CustomerDao {
    long saveCustomer(Customer customer);
    long updateCustomerById(long id, Customer customer);
    long deleteCustomerById(long id);
    Customer getCustomerById(long id);
    List<Customer> getAllCustomers();

}
