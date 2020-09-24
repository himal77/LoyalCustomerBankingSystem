package com.rbinternational.dao;

import com.rbinternational.dao.interfaces.AdminDAO;
import com.rbinternational.model.Admin;
import com.rbinternational.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public class AdminDAOImpl implements AdminDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    public Admin getAdmin(Admin admin) {
        return hibernateTemplate.get(Admin.class, admin.getUserName());
    }

    @Transactional
    public int addAdmin(Admin admin) {
        if (hibernateTemplate.save(admin) != null) {
            return 1;
        }
        return 0;
    }


}
