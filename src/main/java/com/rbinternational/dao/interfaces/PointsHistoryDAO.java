package com.rbinternational.dao.interfaces;

import com.rbinternational.model.Customer;
import com.rbinternational.model.PointsHistory;

import java.util.List;

public interface PointsHistoryDAO {
    public List<PointsHistory> getPointHistoryList(Customer customer);
    public void insert(PointsHistory pointsHistory);
}
