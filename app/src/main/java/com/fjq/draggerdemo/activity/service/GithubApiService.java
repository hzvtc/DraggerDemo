package com.fjq.draggerdemo.activity.service;

import com.fjq.draggerdemo.activity.bean.Repo;

import java.util.ArrayList;

import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;

/**
 * Created by 2 on 2017/4/11.
 */
public interface GithubApiService {
    @GET("/users/{user}/repos")
    Observable<ArrayList<Repo>> getRepoData(@Path("user") String user);
}
