package com.rbinternational.service;

import com.rbinternational.dao.interfaces.CustomerDAO;
import com.rbinternational.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    public int registerCustomer(Customer customer) {
        return customerDAO.register(customer);
    }

    public List<Customer> getCustomerList() {
        return customerDAO.getCustomerList();
    }

    public void deleteCustomer(int accountNo) {
        customerDAO.delete(accountNo);
    }

    public Customer getCustomer(int accountNo) {
      return  customerDAO.getCustomer(accountNo);
    }

    public void updateCustomer(Customer customer) {
        customerDAO.update(customer);
    }
}
