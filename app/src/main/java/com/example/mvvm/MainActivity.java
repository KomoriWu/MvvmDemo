package com.example.mvvm;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.mvvm.aop.annotation.SingleClick;
import com.example.mvvm.bean.UserBean;
import com.example.mvvm.databinding.ActivityMainBinding;
import com.example.mvvm.db.AppDatabase;
import com.example.mvvm.presenter.Presenter;
import com.example.mvvm.vm.UserViewModel;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity implements Presenter {

    private ActivityMainBinding mBinding;
    private UserViewModel mViewModel;
    private int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
//        mBinding.setUser(new UserBean("komori", "176"));
        mBinding.setPresenter(this);
        mViewModel = ViewModelProviders.of(this).get(UserViewModel.class);
        mBinding.setVm(mViewModel);
        //数据改变，UI自动会更新
        mBinding.setLifecycleOwner(this);
//        setViewModel();

//        bindChange();
    }

    private void setViewModel() {
        mViewModel.getUserName().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
//                mBinding.setUser(new UserBean(s));
            }
        });
    }

    private void bindChange() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
//                    mBinding.setUser(new UserBean("komori02", "176"));
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
                Log.e("tag", "click");
//                mViewModel.getUserName().postValue("postValue");
                index++;

                UserBean user = new UserBean();
                user.setPhone("18988195061");
                user.setUserName("tuacy");
                List<Long> ids = AppDatabase.getInstance().userDao().insert(user);
                if (ids != null) {
                    for (Long id : ids) {
                        Log.d("tuacy", "id = " + id);
                    }
                }

                AppDatabase.getInstance().userDao()
                        .getUserBeanAll()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Consumer<List<UserBean>>() {
                            @Override
                            public void accept(List<UserBean> entities) {
                                if (entities != null) {
                                    for (UserBean user : entities) {
                                        Log.d("tuacy", user.toString());
                                    }
                                }

                            }
                        });
//                mViewModel.insert(new UserBean("insert user"+index, "131l"));
                break;
        }
    }


}
