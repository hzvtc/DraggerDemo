package com.fjq.draggerdemo.activity.app;

import android.app.Application;

import com.fjq.draggerdemo.activity.component.AppComponent;
import com.fjq.draggerdemo.activity.component.DaggerAppComponent;
import com.fjq.draggerdemo.activity.module.AppModule;
import com.fjq.draggerdemo.activity.module.GithubApiModule;

/**
 * Created by 2 on 2017/4/11.
 */
public class AppApplication extends Application {
    private static AppApplication sInstance;
    private AppComponent appComponent;
    @Override
    public void onCreate() {
        super.onCreate();
        this.sInstance = this;
        setupCompoent();
    }

    private void setupCompoent(){
        appComponent = DaggerAppComponent.builder()
                .githubApiModule(new GithubApiModule())
                .appModule(new AppModule(this))
                .build();
    }

    public static AppApplication getsInstance(){
        return sInstance;
    }

    public AppComponent getAppComponent(){
        return appComponent;
    }
}
