package com.rbinternational.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {
    @Id
    private int accountNo;
    private String name;
    private String address;
    private float currentBalance;
    private String password;


    public Customer() {
    }

    public Customer(int accountNo, String name, String address, float currentBalance, String password) {
        this.accountNo = accountNo;
        this.name = name;
        this.address = address;
        this.currentBalance = currentBalance;
        this.password = password;
    }

    public int getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(float currentBalance) {
        this.currentBalance = currentBalance;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "accountNo=" + accountNo +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", currentBalance=" + currentBalance +
                ", password='" + password + '\'' +
                '}';
    }
}
