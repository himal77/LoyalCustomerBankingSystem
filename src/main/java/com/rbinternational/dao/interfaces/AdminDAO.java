package com.rbinternational.dao.interfaces;

import com.rbinternational.model.Admin;
import com.rbinternational.model.Customer;

public interface AdminDAO {
    public Admin getAdmin(Admin admin);
    public int addAdmin(Admin admin);

}
