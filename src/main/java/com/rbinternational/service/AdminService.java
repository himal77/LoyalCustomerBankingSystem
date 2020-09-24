package com.rbinternational.service;

import com.rbinternational.dao.AdminDAOImpl;
import com.rbinternational.dao.interfaces.AdminDAO;
import com.rbinternational.model.Admin;
import com.rbinternational.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private AdminDAO adminDAO;

    @Autowired CustomerService customerService;

    public int addAdmin(Admin admin) { return this.adminDAO.addAdmin(admin); }
    public Admin getAdmin(Admin admin) {
       return this.adminDAO.getAdmin(admin);
    }
    public int addCustomer(Customer customer) {
        return customerService.registerCustomer(customer);
    }
    public List<Customer> getCustomerList() {
       return customerService.getCustomerList();
    }

    public void deleteCustomer(int accountNo) {
        customerService.deleteCustomer(accountNo);
    }

    public Customer getCustomer(int accountNo) {
        return customerService.getCustomer(accountNo);
    }

    public void updateCustomer(Customer customer) {
        customerService.updateCustomer(customer);
    }
}
