package com.example.mvvm.bean;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Author: KomoriWu
 * Date: 2019/8/27 13:53
 * Description :
 */
@Entity
public class UserBean {
    @PrimaryKey(autoGenerate = true)
    public long id;
    private String userName;
    private String phone;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    @Override
    public String toString() {
        return "UserBean{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
