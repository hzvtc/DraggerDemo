package com.fjq.draggerdemo.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.fjq.draggerdemo.R;
import com.fjq.draggerdemo.activity.adapter.ListAdapter;
import com.fjq.draggerdemo.activity.bean.Repo;
import com.fjq.draggerdemo.activity.component.AppComponent;
import com.fjq.draggerdemo.activity.service.GithubApiService;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.Bind;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ReposListActivity extends BaseActivity {

    @Bind(R.id.repos_rv_list)
    RecyclerView mRvList;
    @Bind(R.id.pbLoading)
    ProgressBar pbLoading;

    @Inject
    GithubApiService githubApiService;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initView();
    }

    private void initView(){
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mRvList.setLayoutManager(manager);

        ListAdapter adapter = new ListAdapter();
        mRvList.setAdapter(adapter);
        loadData(adapter);
    }

    private void loadData(final ListAdapter adapter){
        showLoading(true);
        githubApiService.getRepoData(getUser())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SimpleObserver<ArrayList<Repo>>() {
                    @Override
                    public void onNext(ArrayList<Repo> repos) {
                        showLoading(false);
                        adapter.setRepos(repos);
                    }
                    @Override
                    public void onError(Throwable e){
                        showLoading(false);
                    }
                });
    }

    private String getUser(){
        return "bird1015";
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_repos_list2;
    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
        appComponent.inject(this);
    }

    public void showLoading(boolean loading) {
        Log.i("info",loading + " Repos");
        pbLoading.setVisibility(loading ? View.VISIBLE : View.GONE);
    }
}
