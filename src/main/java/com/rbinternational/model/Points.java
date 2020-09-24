package com.rbinternational.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Points {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pointId;
    private int customerAccount;
    private int currPoint;
    private int usedPoint;
    private int totalPoint;

    public Points() {
    }

    public Points(int pointId, int customerAccount, int currPoint, int usedPoint, int totalPoint) {
        this.pointId = pointId;
        this.customerAccount = customerAccount;
        this.currPoint = currPoint;
        this.usedPoint = usedPoint;
        this.totalPoint = totalPoint;
    }

    public int getPointId() {
        return pointId;
    }

    public void setPointId(int pointId) {
        this.pointId = pointId;
    }

    public int getCustomerAccount() {
        return customerAccount;
    }

    public void setCustomerAccount(int customerAccount) {
        this.customerAccount = customerAccount;
    }

    public int getCurrPoint() {
        return currPoint;
    }

    public void setCurrPoint(int currPoint) {
        this.currPoint = currPoint;
    }

    public int getUsedPoint() {
        return usedPoint;
    }

    public void setUsedPoint(int usedPoint) {
        this.usedPoint = usedPoint;
    }

    public int getTotalPoint() {
        return totalPoint;
    }

    public void setTotalPoint(int totalPoint) {
        this.totalPoint = totalPoint;
    }

    @Override
    public String toString() {
        return "Points{" +
                "pointId=" + pointId +
                ", customerAccount=" + customerAccount +
                ", currPoint=" + currPoint +
                ", usedPoint=" + usedPoint +
                ", totalPoint=" + totalPoint +
                '}';
    }
}
