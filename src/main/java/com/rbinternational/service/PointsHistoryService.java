package com.rbinternational.service;

import com.rbinternational.dao.interfaces.PointsHistoryDAO;
import com.rbinternational.model.PointsHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PointsHistoryService {

    @Autowired
    private PointsHistoryDAO pointsHistoryDAO;

    public void insert(PointsHistory pointsHistory) {
        pointsHistoryDAO.insert(pointsHistory);
    }
}
