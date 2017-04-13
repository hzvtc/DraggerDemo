package com.fjq.draggerdemo.activity.component;

import com.fjq.draggerdemo.activity.MainActivity;
import com.fjq.draggerdemo.activity.module.MyModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by 2 on 2017/4/11.
 */
@Singleton
@Component(modules = MyModule.class)
public interface ActivityComponent {
    void inject(MainActivity activity);
}
