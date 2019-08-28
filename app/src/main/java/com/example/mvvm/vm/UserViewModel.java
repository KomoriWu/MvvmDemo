package com.example.mvvm.vm;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * Author: KomoriWu
 * Date: 2019/8/27 14:34
 * Description :
 */
public class UserViewModel extends ViewModel {
    private MutableLiveData<String> mUserName;

    public MutableLiveData<String> getUserName() {
        if (mUserName == null) {
            mUserName = new MutableLiveData<>();
        }
        return mUserName;
    }

    public void setUserName(String userName) {
        mUserName.setValue(userName);
    }
}
