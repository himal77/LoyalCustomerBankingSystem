package com.rbinternational.dao.interfaces;

import com.rbinternational.model.Customer;
import com.rbinternational.model.Points;

public interface PointsDAO {
    public Points getPointOfCustomer(int accountNo);
    public int save(Points points);
    public void update(Points points);
}
