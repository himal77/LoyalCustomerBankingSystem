package com.rbinternational.service;

import com.rbinternational.dao.TransactionDAOImpl;
import com.rbinternational.dao.interfaces.CustomerDAO;
import com.rbinternational.dao.interfaces.TransactionDAO;
import com.rbinternational.model.Customer;
import com.rbinternational.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    @Autowired
    private TransactionDAO transactionDAO;

    @Autowired
    private CustomerService customerService;

    public int insertTransaction(Transaction transaction) {
        return transactionDAO.insert(transaction);
    }

    public List<Transaction> getSentTransactionList(Customer customer) {
        return transactionDAO.getSentTransactionByAccountNumber(customer);
    }
    public List<Transaction> getReceivedTransactionList(Customer customer) {
        return transactionDAO.getReceivedTransactionByAccountNumber(customer);
    }

}
