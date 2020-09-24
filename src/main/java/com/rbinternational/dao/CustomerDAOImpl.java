package com.rbinternational.dao;

import com.rbinternational.dao.interfaces.CustomerDAO;
import com.rbinternational.model.Customer;

import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {

    public int register(Customer customer) {
        return 0;
    }


    public void delete(int accountNumber) {

    }


    public Customer getSingleCustomer(int accountNumber) {
        return null;
    }

    public List<Customer> getAllCustomer() {
        return null;
    }


    public Customer getCustomerByAccNoAndPassword(int accountNo, String password) {
        return null;
    }
}
