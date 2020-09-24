package com.rbinternational.dao;

import com.rbinternational.dao.interfaces.CustomerDAO;
import com.rbinternational.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Transactional
    public int register(Customer customer) {
        if(hibernateTemplate.save(customer) == null) return 0;
        return 1;
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
