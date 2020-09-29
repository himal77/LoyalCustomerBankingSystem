package com.rbinternational.dao;

import com.rbinternational.dao.interfaces.PointsHistoryDAO;
import com.rbinternational.model.Customer;
import com.rbinternational.model.PointsHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PointsHistoryDAOImpl implements PointsHistoryDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public List<PointsHistory> getPointHistoryList(Customer customer) {
        return null;
    }

    @Override
    public void insert(PointsHistory pointsHistory) {
        hibernateTemplate.save(pointsHistory);
    }
}
