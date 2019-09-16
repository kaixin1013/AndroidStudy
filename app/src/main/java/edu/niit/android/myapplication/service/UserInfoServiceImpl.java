package edu.niit.android.myapplication.service;

import android.content.Context;

import edu.niit.android.myapplication.dao.UserInfoDao;
import edu.niit.android.myapplication.dao.UserInfoDaoImpl;
import edu.niit.android.myapplication.entity.UserInfo;

public class UserInfoServiceImpl implements UserInfoService {
    private UserInfoDao dao;
    public UserInfoServiceImpl(Context context){
        dao = new UserInfoDaoImpl(context);
    }
    @Override
    public UserInfo get(String username){
        return  dao.select(username);

    }
    @Override
    public void save(UserInfo userInfo){
        dao .insert(userInfo);
    }
    @Override
    public void modify(UserInfo userInfo){
        dao.update(userInfo);
    }

}
