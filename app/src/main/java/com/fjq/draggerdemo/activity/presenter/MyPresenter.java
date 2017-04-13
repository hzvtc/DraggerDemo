package com.fjq.draggerdemo.activity.presenter;

import com.fjq.draggerdemo.activity.common.IPresenter;
import com.fjq.draggerdemo.activity.common.IView;

/**
 * Created by 2 on 2017/4/11.
 */
public class MyPresenter implements IPresenter {
    private IView mainView;

    public MyPresenter(IView view){
        mainView = view;
    }


    @Override
    public void loadData() {
        mainView.updateUi("Mvp Update UI "+System.currentTimeMillis());
    }
}
