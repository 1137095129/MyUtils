package com.thhy.fixedassets.dao;

import com.thhy.fixedassets.domain.UserInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoDao {

    UserInfo findUserInfoByUserId(int userId);

}
