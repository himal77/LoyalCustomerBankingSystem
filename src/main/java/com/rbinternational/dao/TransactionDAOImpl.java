package com.rbinternational.dao;

import com.rbinternational.dao.interfaces.TransactionDAO;
import com.rbinternational.model.Customer;
import com.rbinternational.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.List;

@Repository
public class TransactionDAOImpl implements TransactionDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Transactional
    public int insert(Transaction transaction) {
        if (hibernateTemplate.save(transaction) != null) return 1;
        return 0;
    }

    public List<Transaction> getTransactionList() {
        return null;
    }

    public Transaction getTransaction(int transactionId) {
        return null;
    }

    @Transactional
    public List<Transaction> getSentTransactionByAccountNumber(Customer customer) {
        List<Transaction> transactionList =
                (List<Transaction>) hibernateTemplate.find
                        ("FROM Transaction t where t.senderAccountNo = ?0",
                                customer);
        return transactionList;
    }

    @Transactional
    public List<Transaction> getReceivedTransactionByAccountNumber(Customer customer) {
        List<Transaction> transactionList =
                (List<Transaction>) hibernateTemplate.find
                        ("FROM Transaction t where t.receiverAccountNo = ?0 AND t.type = ?1",
                                customer, "Transfer");

        return transactionList;
    }

    public List<Transaction> getLastSevenDayOfSentTransaction(Customer customer, Date date) {
        System.out.println(date);
        List<Transaction> transactionList =
                (List<Transaction>) hibernateTemplate.find
                        ("FROM Transaction t where t.senderAccountNo = ?0 AND t.date >= ?1",
                                customer, date);
        return transactionList;
    }

    public List<Transaction> getLastSevenDayOfReceivedTransaction(Customer customer, Date date) {
        List<Transaction> transactionList =
                (List<Transaction>) hibernateTemplate.find
                        ("FROM Transaction t where t.receiverAccountNo = ?0 AND t.date >= ?1 AND t.type = ?2",
                                customer, date, "transfer");
        return transactionList;
    }
}
