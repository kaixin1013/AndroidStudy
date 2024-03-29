package edu.niit.android.myapplication.entity;

import java.io.Serializable;

public class UserInfo implements Serializable {
    private int _id;
    private String username;
    private String nickname;
    private String sex;
    private String signature;

    public UserInfo(String username, String nickname, String sex, String signature) {
        this.username = username;
        this.nickname = nickname;
        this.sex = sex;
        this.signature = signature;
    }

    public UserInfo() {

    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "username='" + username + '\'' +
                ", nickname='" + nickname + '\'' +
                ", sex='" + sex + '\'' +
                ", signature='" + signature + '\'' +
                '}';
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public void save() {
    }
}