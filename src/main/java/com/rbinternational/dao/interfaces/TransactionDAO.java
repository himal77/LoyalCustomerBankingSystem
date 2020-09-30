package com.rbinternational.dao.interfaces;

import com.rbinternational.model.Customer;
import com.rbinternational.model.Transaction;

import java.sql.Date;
import java.util.List;

public interface TransactionDAO {
    public int insert(Transaction transaction);
    public List<Transaction> getTransactionList();
    public Transaction getTransaction(int transactionId);
    public List<Transaction> getSentTransactionByAccountNumber(Customer customer);
    public List<Transaction> getReceivedTransactionByAccountNumber(Customer customer);
    public List<Transaction> getLastSevenDayOfSentTransaction(Customer customer, Date date);
    public List<Transaction> getLastSevenDayOfReceivedTransaction(Customer customer, Date date);
}
