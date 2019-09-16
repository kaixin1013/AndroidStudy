package edu.niit.android.myapplication.dao;


import java.util.List;

import edu.niit.android.myapplication.entity.UserInfo;


//dao的作用：完成对一张表的增删改查的原子性操作
public interface UserInfoDao {
    List<UserInfo> select();
    UserInfo select(String username);
    void insert(UserInfo userInfo);
    void update(UserInfo userInfo);
    void delete(UserInfo userInfo);

}
