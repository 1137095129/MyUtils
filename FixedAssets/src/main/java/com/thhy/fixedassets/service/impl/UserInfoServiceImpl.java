package com.thhy.fixedassets.service.impl;

import com.thhy.fixedassets.dao.UserInfoDao;
import com.thhy.fixedassets.domain.UserInfo;
import com.thhy.fixedassets.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoDao userInfoDao;

    /**
     * 根据用户编号查询用户信息
     * @param userId
     * @return
     */
    @Override
    public UserInfo findUserInfoByUserId(int userId) {
        return userInfoDao.findUserInfoByUserId(userId);
    }
}
