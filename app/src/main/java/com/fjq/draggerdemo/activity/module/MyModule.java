package com.fjq.draggerdemo.activity.module;

import com.fjq.draggerdemo.activity.common.IView;
import com.fjq.draggerdemo.activity.presenter.MyPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by 2 on 2017/4/11.
 */
@Module
public class MyModule {
    private IView mainView;

    public MyModule(IView mainView){
        this.mainView = mainView;
    }
    @Singleton
    @Provides
    public MyPresenter provideMyPresenter(){
        return new MyPresenter(mainView);
    }
}
