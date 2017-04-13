package com.fjq.draggerdemo.activity.component;

import com.fjq.draggerdemo.activity.MainActivity;
import com.fjq.draggerdemo.activity.ReposListActivity;
import com.fjq.draggerdemo.activity.module.AppModule;
import com.fjq.draggerdemo.activity.module.GithubApiModule;
import com.fjq.draggerdemo.activity.module.MyModule;

import dagger.Component;

/**
 * Created by 2 on 2017/4/11.
 */
@Component(modules = { AppModule.class, GithubApiModule.class})
public interface AppComponent {
    void inject(ReposListActivity activity);
}
