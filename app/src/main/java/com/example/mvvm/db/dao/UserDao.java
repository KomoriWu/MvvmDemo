package com.example.mvvm.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.mvvm.bean.UserBean;

import java.util.List;

/**
 * Author: KomoriWu
 * Date: 2019/8/28 13:32
 * Description :
 */
@Dao
public interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    List<Long> insert(UserBean... bean);

    @Query("SELECT * from UserBean")
    LiveData<List<UserBean>> getUserBeanAll();

}
