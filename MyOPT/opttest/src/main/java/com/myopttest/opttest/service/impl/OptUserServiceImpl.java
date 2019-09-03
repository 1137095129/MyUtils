package com.myopttest.opttest.service.impl;

import com.myopttest.opttest.dao.OptUserDao;
import com.myopttest.opttest.domain.OptUser;
import com.myopttest.opttest.service.OptUserService;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OptUserServiceImpl implements OptUserService {

    @Autowired
    private OptUserDao optUserDao;

    @Override
    public OptUser findById(int id) {
        return optUserDao.findById(id);
    }

    /**
     * 管理员登录时需要生成日志
     * @param account
     * @param password
     * @return
     */
    @Override
    public OptUser login(String account, String password) {
        return optUserDao.login(account,password);
    }

    /**
     *
     * @param optUser 被修改的管理员
     * @param user 执行操作的管理员
     */
    @Override
    @Transactional
    public void updateRole(OptUser optUser,OptUser user) {
        optUserDao.updateRole(optUser);
    }

    /**
     *
     * @param optUser 被添加的管理员
     * @param user 执行操作的管理员
     */
    @Override
    @Transactional
    public void addNewAdmin(OptUser optUser, OptUser user) {
        optUserDao.addNewAdmin(optUser);
    }

    /**
     *
     * @param id 被删除的管理员的编号
     * @param user 执行操作的管理员
     */
    @Override
    @Transactional
    public void deleteAdminById(int id, OptUser user) {
        optUserDao.deleteAdminById(id);
    }
}
