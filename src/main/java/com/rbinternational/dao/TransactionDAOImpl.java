package com.rbinternational.dao;

import com.rbinternational.dao.interfaces.TransactionDAO;
import com.rbinternational.model.Customer;
import com.rbinternational.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class TransactionDAOImpl implements TransactionDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Transactional
    public int insert(Transaction transaction) {
        if(hibernateTemplate.save(transaction) != null) return 1;
        return 0;
    }

    public List<Transaction> getTransactionList() {
        return null;
    }

    public Transaction getTransaction(int transactionId) {
        return null;
    }

    @Transactional
    public List<Transaction> getTransactionByAccountNumber(Customer customer) {
        List<Transaction> transactionList =
                (List<Transaction>) hibernateTemplate.find
                        ("FROM Transaction t where t.senderAccountNo = ?0",
                customer);
        System.out.println("The length of transaction list is: " + transactionList.size());

        return transactionList;
    }
}
