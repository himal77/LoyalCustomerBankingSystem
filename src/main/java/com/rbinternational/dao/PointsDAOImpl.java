package com.rbinternational.dao;

import com.rbinternational.dao.interfaces.PointsDAO;
import com.rbinternational.model.Customer;
import com.rbinternational.model.Points;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PointsDAOImpl implements PointsDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public Points getPointOfCustomer(int accountNo) {
        List<Points> pointsList = (List<Points>) hibernateTemplate.
                find("FROM Points p WHERE p.customerAccountNo = ?0", accountNo);
        if(pointsList.size() != 0) return pointsList.get(0);
        return null;
    }


    @Override
    public int addPointsForNewCustomer(Points points) {
        if(hibernateTemplate.save(points) != null) return 1;
        return 0;
    }
}
