package com.rbinternational.service;

import com.rbinternational.dao.AdminDAOImpl;
import com.rbinternational.dao.interfaces.AdminDAO;
import com.rbinternational.model.Admin;
import com.rbinternational.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
