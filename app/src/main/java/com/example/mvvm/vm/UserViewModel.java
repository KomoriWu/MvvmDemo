package com.example.mvvm.vm;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvm.bean.UserBean;
import com.example.mvvm.db.AppDatabase;
import com.example.mvvm.db.dao.UserDao;

import java.util.List;

/**
 * Author: KomoriWu
 * Date: 2019/8/27 14:34
 * Description :
 */
public class UserViewModel extends ViewModel {
    private MutableLiveData<String> mUserName;
    private UserDao mUserDao;

    public UserViewModel() {
        mUserDao = AppDatabase.getInstance().userDao();
    }

    public MutableLiveData<String> getUserName() {
        if (mUserName == null) {
            mUserName = new MutableLiveData<>();
        }
        return mUserName;
    }

    public void setUserName(String userName) {
        mUserName.setValue(userName);
    }

    public void insert(UserBean bean) {
        mUserDao.insert(bean);
    }

    public LiveData<List<UserBean>> getUserBeanAll() {
        return mUserDao.getUserBeanAll();
    }
}
