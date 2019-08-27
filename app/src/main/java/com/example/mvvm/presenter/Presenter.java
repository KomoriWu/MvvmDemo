package com.example.mvvm.presenter;

import android.view.View;

/**
 * Author: KomoriWu
 * Date: 2019/8/27 14:27
 * Description :
 */
public interface Presenter extends View.OnClickListener {
    @Override
    void onClick(View view);
}
