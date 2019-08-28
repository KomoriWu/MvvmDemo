package com.example.mvvm.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.mvvm.MyApplication;
import com.example.mvvm.bean.UserBean;
import com.example.mvvm.db.dao.UserDao;

/**
 * Author: KomoriWu
 * Date: 2019/8/28 13:26
 * Description :
 */
@Database(entities = {UserBean.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public static final String DB_NAME = "word_database";
    private static volatile AppDatabase INSTANCE;

    public static AppDatabase getInstance() {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(MyApplication.getApplication(),
                            AppDatabase.class, DB_NAME)
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    //dao
    public abstract UserDao userDao();
}
