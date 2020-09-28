package com.rbinternational.dao;

import com.rbinternational.dao.interfaces.CustomerDAO;
import com.rbinternational.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Transactional
    public int register(Customer customer) {
        if (hibernateTemplate.save(customer) == null) return 0;
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
        List<Customer> customerList = (List<Customer>) hibernateTemplate.find("FROM Customer c where c.accountNo = ?0 and c.password = ?1",
                accountNo, password);
        if(customerList.size() != 0) return customerList.get(0);
        return null;
    }
}
