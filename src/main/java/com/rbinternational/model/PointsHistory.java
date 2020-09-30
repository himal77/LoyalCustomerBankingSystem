package com.rbinternational.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class PointsHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pointId;
    private Date date;
    private float points;

    @ManyToOne
    private Customer customerAccount;

    public PointsHistory(Date date, float points, Customer customerAccount) {
        this.date = date;
        this.points = points;
        this.customerAccount = customerAccount;
    }

    public PointsHistory() {

    }

    public int getPointId() {
        return pointId;
    }

    public void setPointId(int pointId) {
        this.pointId = pointId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getPoints() {
        return points;
    }

    public void setPoints(float points) {
        this.points = points;
    }

    public Customer getCustomerAccount() {
        return customerAccount;
    }

    public void setCustomerAccount(Customer customerAccount) {
        this.customerAccount = customerAccount;
    }

    @Override
    public String toString() {
        return "PointsHistory{" +
                "pointId=" + pointId +
                ", date=" + date +
                ", points=" + points +
                ", customerAccount=" + customerAccount +
                '}';
    }
}
