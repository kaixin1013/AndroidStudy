package edu.niit.android.myapplication.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import java.util.ArrayList;
import java.util.List;

import edu.niit.android.myapplication.entity.UserInfo;
import edu.niit.android.myapplication.utils.DBHelper;

public class UserInfoDaoImpl implements UserInfoDao {
    private DBHelper helper;
    private SQLiteDatabase db;
    public UserInfoDaoImpl(Context context){
        helper= DBHelper.getInstance(context);
    }

    @Override
    public List<UserInfo> select() {
        List<UserInfo> userInfo=new ArrayList<>();
        return null;
    }

    @Override
    public UserInfo select(String username) {
        // String sql=" select * from "+DBHelper.TBL_NAME_USER+" where user_name " ;
        UserInfo userInfo=null;
        db=helper.getReadableDatabase();//获取了数据库对象
        Cursor cursor=db.query(DBHelper.TBL_NAME_USER,null,null,null
                ,null,null,null);
        // Cursor cursor=db.rawQuery(sql,new String[]{username});
        if (cursor !=null&& cursor.moveToFirst()) {
            userInfo = new UserInfo();
            userInfo.setUsername(cursor.getString(cursor.getColumnIndex("username")));
            userInfo.setNickname(cursor.getString(cursor.getColumnIndex("nickname")));
            userInfo.setSex(cursor.getString(cursor.getColumnIndex("sex")));
            userInfo.setSignature(cursor.getString(cursor.getColumnIndex("signature")));
            cursor.close();


        }
        db.close();
        return userInfo;
    }

    @Override
    public void insert(UserInfo userInfo) {
//        ContentValues values=new ContentValues();
//        values.put("username",userInfo.getUsername());
//        values.put("nick_name",userInfo.getNickname());
//        values.put("sex",userInfo.getSex());
//        values.put("signature",userInfo.getSignature());
//        db=helper.getWritableDatabase();
//        db.insert(DBHelper.TBL_NAME_USER,null,values);
        String sql="insert into "+DBHelper.TBL_NAME_USER+" values(null,?,?,?,?)";
        db.execSQL(sql,new String[]{
                userInfo.getUsername(),
                userInfo.getNickname(),
                userInfo.getSex(),
                userInfo.getSignature()});

//        db.close();
    }

    @Override
    public void update(UserInfo userInfo) {
        ContentValues values=new ContentValues();
        values.put("username",userInfo.getUsername());
        values.put("nick_name",userInfo.getNickname());
        values.put("sex",userInfo.getSex());
        values.put("signature",userInfo.getSignature());
        db=helper.getWritableDatabase();
        db.update(DBHelper.TBL_NAME_USER,null,"user_name=?",new String[]{userInfo.getUsername()});
        db.close();
    }

    @Override
    public void delete(UserInfo userInfo) {

    }
}
