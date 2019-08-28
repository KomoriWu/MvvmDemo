package com.example.mvvm.bean;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

/**
 * Author: KomoriWu
 * Date: 2019/8/27 13:53
 * Description :
 */
@Entity
public class UserBean {
    @PrimaryKey
    public int id;
    private String userName;
    private String phone;

    @Ignore
    public UserBean(String userName) {
        this.userName = userName;
    }

    public UserBean(String userName, String phone) {
        this.userName = userName;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
