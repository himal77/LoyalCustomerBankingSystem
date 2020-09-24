package com.rbinternational.dao.interfaces;

import com.rbinternational.model.Customer;

import java.util.List;

public interface CustomerDAO {
    public int register(Customer customer);
    public void delete(int accountNumber);
    public Customer getSingleCustomer(int accountNumber);
    public List<Customer> getAllCustomer();
    public Customer getCustomerByAccNoAndPassword(int accountNo, String password);
}
