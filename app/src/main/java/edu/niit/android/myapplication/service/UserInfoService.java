package edu.niit.android.myapplication.service;

import edu.niit.android.myapplication.entity.UserInfo;

public interface UserInfoService {

    UserInfo get(String username);

    void save(UserInfo userInfo);

    void modify(UserInfo userInfo);
}
