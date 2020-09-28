package com.rbinternational.dao.interfaces;

import com.rbinternational.model.Customer;
import com.rbinternational.model.Transaction;

import java.util.List;

public interface TransactionDAO {
    public int insert(Transaction transaction);
    public List<Transaction> getTransactionList();
    public Transaction getTransaction(int transactionId);
    public List<Transaction> getTransactionByAccountNumber(Customer customer);
}
