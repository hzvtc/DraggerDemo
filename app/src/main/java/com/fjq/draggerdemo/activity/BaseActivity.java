package com.fjq.draggerdemo.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

import com.fjq.draggerdemo.activity.app.AppApplication;
import com.fjq.draggerdemo.activity.component.AppComponent;

import butterknife.ButterKnife;

/**
 * Created by 2 on 2017/4/11.
 */
public abstract class BaseActivity extends AppCompatActivity{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        setupActivityComponent(AppApplication.getsInstance().getAppComponent());
    }

    protected abstract void setupActivityComponent(AppComponent appComponent);
    protected abstract int getLayoutId();
}
