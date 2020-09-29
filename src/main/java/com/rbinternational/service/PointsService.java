package com.rbinternational.service;

import com.rbinternational.dao.interfaces.PointsDAO;
import com.rbinternational.model.Customer;
import com.rbinternational.model.Points;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PointsService {

    @Autowired
    private PointsDAO pointsDAO;

    public Points getPointOfCustomer(int accountNo) {
        return pointsDAO.getPointOfCustomer(accountNo);
    }

    public int addPointsForNewCustomer(Points points) {
        return pointsDAO.addPointsForNewCustomer(points);
    }
}
