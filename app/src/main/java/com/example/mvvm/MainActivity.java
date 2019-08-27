package com.example.mvvm;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.mvvm.aop.annotation.SingleClick;
import com.example.mvvm.bean.UserBean;
import com.example.mvvm.databinding.ActivityMainBinding;
import com.example.mvvm.presenter.Presenter;

public class MainActivity extends AppCompatActivity implements Presenter {

    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mBinding.setUser(new UserBean("komori", "176"));
        mBinding.setPresenter(this);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    mBinding.setUser(new UserBean("komori02", "176"));
//                    mBinding.tvHello.setText("komori03");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    @SingleClick
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn:
                Log.e("tag","click");
                break;
        }
    }
}
