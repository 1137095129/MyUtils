package com.myopttest.opttest.dao;

import com.myopttest.opttest.domain.OptUser;


public interface OptUserDao {
    OptUser findById(int id);
    OptUser login(String account,String password);
    void updateRole(OptUser optUser);
    void addNewAdmin(OptUser optUser);
    void deleteAdminById(int id);
}
