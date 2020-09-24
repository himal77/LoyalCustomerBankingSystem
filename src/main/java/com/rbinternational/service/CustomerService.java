package com.rbinternational.service;

import com.rbinternational.dao.interfaces.CustomerDAO;
import com.rbinternational.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    public int registerCustomer(Customer customer) {
        return customerDAO.register(customer);
    }
}
