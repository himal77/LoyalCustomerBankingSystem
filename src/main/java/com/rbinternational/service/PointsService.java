package com.rbinternational.service;

import com.rbinternational.dao.interfaces.PointsDAO;
import com.rbinternational.model.Customer;
import com.rbinternational.model.Points;
import com.rbinternational.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class PointsService {

    @Autowired
    private PointsDAO pointsDAO;

    @Autowired
    private TransactionService transactionService;

    public Points getPointOfCustomer(int accountNo) {
        return pointsDAO.getPointOfCustomer(accountNo);
    }

    public void save(Points points) {
       pointsDAO.save(points);
    }

    public void update(Points points){
        pointsDAO.update(points);
    }

    public List<Transaction> getLastSevenDayTransaction(Customer customer, Date date) {
       return transactionService.getLastSevenDayTransaction(customer, date);
    }
}
