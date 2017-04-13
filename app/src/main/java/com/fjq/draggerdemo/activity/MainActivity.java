package com.fjq.draggerdemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.fjq.draggerdemo.R;
import com.fjq.draggerdemo.activity.common.IView;
import com.fjq.draggerdemo.activity.component.AppComponent;
import com.fjq.draggerdemo.activity.component.DaggerActivityComponent;
import com.fjq.draggerdemo.activity.module.MyModule;
import com.fjq.draggerdemo.activity.presenter.MyPresenter;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.OnClick;
import dagger.Lazy;

public class MainActivity extends BaseActivity implements IView {


    @Bind(R.id.textView)
    TextView textView;

    @Inject
    Lazy<MyPresenter> lazyMyPresenter; //获取依赖的对象


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerActivityComponent.builder()
                .myModule(new MyModule(this))
                .build()
                .inject(this); //注入
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_repos_list;
    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {

    }

    @Override
    public void updateUi(String data) {
        textView.setText(data);
    }


    @OnClick({R.id.update_ui, R.id.showInfoBtn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.update_ui:
                lazyMyPresenter.get().loadData();
                break;
            case R.id.showInfoBtn:
                startActivity(new Intent(this, ReposListActivity.class));
                break;
        }
    }
}
