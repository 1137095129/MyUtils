package com.thhy.fixedassets.service;

import com.thhy.fixedassets.domain.UserInfo;

public interface UserInfoService {

    UserInfo findUserInfoByUserId(int userId);

}
