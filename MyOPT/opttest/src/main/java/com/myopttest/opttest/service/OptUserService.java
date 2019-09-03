package com.myopttest.opttest.service;

import com.myopttest.opttest.domain.OptUser;

public interface OptUserService {
    OptUser findById(int id);
    OptUser login(String account,String password);
    void updateRole(OptUser optUser,OptUser user);
    void addNewAdmin(OptUser optUser, OptUser user);
    void deleteAdminById(int id, OptUser user);
}
