package com.rbinternational.dao.interfaces;

import com.rbinternational.model.Customer;

import java.util.List;

public interface CustomerDAO {
    public int register(Customer customer);
    public void delete(int accountNumber);
    public Customer getCustomer(int accountNo);
    public List<Customer> getCustomerList();
    public void update(Customer customer);
    public Customer getCustomerByAccNoAndPassword(int accountNo, String password);
}
