package com.example.mvvm.bean;

/**
 * Author: KomoriWu
 * Date: 2019/8/27 13:53
 * Description :
 */
public class UserBean {
    private String userName;
    private String phone;

    public UserBean(String userName, String phone) {
        this.userName = userName;
        this.phone = phone;
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
