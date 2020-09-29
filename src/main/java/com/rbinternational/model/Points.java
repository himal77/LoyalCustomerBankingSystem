package com.rbinternational.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Points {

    @Id
    private int customerAccountNo;

    private float currAvailablePoints;
    private float usedPoints;
    private float totalGatheredPoints;
    private float dismissedPoints;
    private Date lastDateOfTransaction;
    private float transactionTillNow;

    public Points() {
    }

    public Points(int customerAccountNo, float currAvailablePoints, float usedPoints, float totalGatheredPoints, float dismissedPoints, Date lastDateOfTransaction, float transactionTillNow) {
        this.customerAccountNo = customerAccountNo;
        this.currAvailablePoints = currAvailablePoints;
        this.usedPoints = usedPoints;
        this.totalGatheredPoints = totalGatheredPoints;
        this.dismissedPoints = dismissedPoints;
        this.lastDateOfTransaction = lastDateOfTransaction;
        this.transactionTillNow = transactionTillNow;
    }

    public int getCustomerAccountNo() {
        return customerAccountNo;
    }

    public void setCustomerAccountNo(int customerAccountNo) {
        this.customerAccountNo = customerAccountNo;
    }

    public float getCurrAvailablePoints() {
        return currAvailablePoints;
    }

    public void setCurrAvailablePoints(float currAvailablePoints) {
        this.currAvailablePoints = currAvailablePoints;
    }

    public float getUsedPoints() {
        return usedPoints;
    }

    public void setUsedPoints(float usedPoints) {
        this.usedPoints = usedPoints;
    }

    public float getTotalGatheredPoints() {
        return totalGatheredPoints;
    }

    public void setTotalGatheredPoints(float totalGatheredPoints) {
        this.totalGatheredPoints = totalGatheredPoints;
    }

    public float getDismissedPoints() {
        return dismissedPoints;
    }

    public void setDismissedPoints(float dismissedPoints) {
        this.dismissedPoints = dismissedPoints;
    }

    public Date getLastDateOfTransaction() {
        return lastDateOfTransaction;
    }

    public void setLastDateOfTransaction(Date lastDateOfTransaction) {
        this.lastDateOfTransaction = lastDateOfTransaction;
    }

    public float getTransactionTillNow() {
        return transactionTillNow;
    }

    public void setTransactionTillNow(float transactionTillNow) {
        this.transactionTillNow = transactionTillNow;
    }

    @Override
    public String toString() {
        return "Points{" +
                "customerAccountNo=" + customerAccountNo +
                ", currAvailablePoints=" + currAvailablePoints +
                ", usedPoints=" + usedPoints +
                ", totalGatheredPoints=" + totalGatheredPoints +
                ", dismissedPoints=" + dismissedPoints +
                ", lastDateOfTransaction=" + lastDateOfTransaction +
                ", transactionTillNow=" + transactionTillNow +
                '}';
    }
}
