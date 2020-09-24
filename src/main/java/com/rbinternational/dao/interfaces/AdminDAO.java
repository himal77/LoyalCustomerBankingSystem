package com.rbinternational.dao.interfaces;

import com.rbinternational.model.Admin;

public interface AdminDAO {
    public Admin getAdmin(Admin admin);
    public int addAdmin(Admin admin);
}
