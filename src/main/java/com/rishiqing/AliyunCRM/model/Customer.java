package com.rishiqing.AliyunCRM.model;

import java.util.Date;

/**
 * Created by 117_John on 7/19/2017.
 */
public class Customer {
    private String name;
    private String phoneNo;
    private String emailAdd;
    private String verificationCode;
    private Date dateCreated;
    private int customerStatus;
    private String customerNote;
    private String adminNote;
    private int rsqLicense;
    private long id;

    public Customer(String name, String phoneNo, String emailAdd, String verificationCode, String customerNote) {
        this.name = name;
        this.phoneNo = phoneNo;
        this.emailAdd = emailAdd;
        this.verificationCode = verificationCode;
        this.customerNote = customerNote;
    }
    public Customer(String name, String phoneNo, String emailAdd, String verificationCode) {
        this.name = name;
        this.phoneNo = phoneNo;
        this.emailAdd = emailAdd;
        this.verificationCode = verificationCode;
    }
    public Customer(Customer c){
        this.name = c.name;
        this.phoneNo = c.phoneNo;
        this.emailAdd = c.emailAdd;
        this.verificationCode = c.verificationCode;
        this.dateCreated = c.dateCreated;
        this.customerStatus = c.customerStatus;
        this.customerNote = c.customerNote;
        this.adminNote = c.adminNote;
        this.rsqLicense = c.rsqLicense;
        this.id = c.id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmailAdd() {
        return emailAdd;
    }

    public void setEmailAdd(String emailAdd) {
        this.emailAdd = emailAdd;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public int getCustomerStatus() {
        return customerStatus;
    }

    public void setCustomerStatus(int customerStatus) {
        this.customerStatus = customerStatus;
    }

    public String getCustomerNote() {
        return customerNote;
    }

    public void setCustomerNote(String customerNote) {
        this.customerNote = customerNote;
    }

    public String getAdminNote() {
        return adminNote;
    }

    public void setAdminNote(String adminNote) {
        this.adminNote = adminNote;
    }

    public int getRsqLicense() {
        return rsqLicense;
    }

    public void setRsqLicense(int rsqLicense) {
        this.rsqLicense = rsqLicense;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
