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

    @Transactional
    public void delete(int accountNo) {
        Customer customer = new Customer();
        customer.setAccountNo(accountNo);
        hibernateTemplate.delete(customer);
    }

    @Transactional
    public void update(Customer customer) {
        hibernateTemplate.update(customer);
    }

    public Customer getCustomer(int accountNo) {
        return hibernateTemplate.get(Customer.class, accountNo);
    }

    public List<Customer> getCustomerList() {
        List<Customer> customerList = hibernateTemplate.loadAll(Customer.class);
        return customerList;
    }

    public Customer getCustomerByAccNoAndPassword(int accountNo, String password) {
        return null;
    }
}
