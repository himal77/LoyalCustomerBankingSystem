package com.rbinternational.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transactionId;
    private float amount;
    private Date date;
    private String type;

    @ManyToOne
    private Customer senderAccountNo;

    @ManyToOne
    private Customer receiverAccountNo;

    public Transaction() {
    }

    public Transaction(float amount, Date date, String type, Customer senderAccountNo, Customer receiverAccountNo) {
        this.amount = amount;
        this.date = date;
        this.type = type;
        this.senderAccountNo = senderAccountNo;
        this.receiverAccountNo = receiverAccountNo;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Customer getSenderAccountNo() {
        return senderAccountNo;
    }

    public void setSenderAccountNo(Customer senderAccountNo) {
        this.senderAccountNo = senderAccountNo;
    }

    public Customer getReceiverAccountNo() {
        return receiverAccountNo;
    }

    public void setReceiverAccountNo(Customer receiverAccountNo) {
        this.receiverAccountNo = receiverAccountNo;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", amount=" + amount +
                ", date=" + date +
                ", type='" + type + '\'' +
                ", senderAccountNo=" + senderAccountNo +
                ", receiverAccountNo=" + receiverAccountNo +
                '}';
    }
}
