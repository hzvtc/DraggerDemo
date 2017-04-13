package com.fjq.draggerdemo.activity.module;

import android.app.Application;

import dagger.Module;
import dagger.Provides;

/**
 * Created by 2 on 2017/4/11.
 */
@Module
public class AppModule {
    private Application application;

    public AppModule(Application application){
        this.application=application;
    }

    @Provides
    public Application provideApplication(){
        return application;
    }
}
