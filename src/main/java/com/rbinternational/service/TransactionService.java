package com.rbinternational.service;

import com.rbinternational.dao.TransactionDAOImpl;
import com.rbinternational.dao.interfaces.TransactionDAO;
import com.rbinternational.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    @Autowired
    private TransactionDAO transactionDAO;

    public int insertTransaction(Transaction transaction) {
        return transactionDAO.insert(transaction);
    }
}