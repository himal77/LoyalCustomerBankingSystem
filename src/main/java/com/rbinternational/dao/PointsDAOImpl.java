package com.rbinternational.dao;

import com.rbinternational.dao.interfaces.PointsDAO;
import com.rbinternational.model.Points;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
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


    @Transactional
    public int save(Points points) {
        if(hibernateTemplate.save(points) != null) return 1;
        return 0;
    }

    @Transactional
    public void update(Points points) {
        hibernateTemplate.update(points);
    }
}
