package com.rbinternational.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Admin {
    @Id
    String userName;
    String kennwort;

    public Admin() {
    }

    public Admin(String userName, String kennwort) {
        this.userName = userName;
        this.kennwort = kennwort;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getKennwort() {
        return kennwort;
    }

    public void setKennwort(String password) {
        this.kennwort = password;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "userName='" + userName + '\'' +
                ", password='" + kennwort + '\'' +
                '}';
    }
}
