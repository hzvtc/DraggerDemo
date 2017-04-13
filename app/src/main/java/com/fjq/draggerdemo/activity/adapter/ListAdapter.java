package com.fjq.draggerdemo.activity.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fjq.draggerdemo.R;
import com.fjq.draggerdemo.activity.bean.Repo;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 2 on 2017/4/12.
 */
public class ListAdapter extends RecyclerView.Adapter<ListAdapter.RepoViewHolder> {
    private ArrayList<Repo> mRepos;

    public ListAdapter() {
        mRepos = new ArrayList<>();
    }

    public void setRepos(ArrayList<Repo> repos) {
        mRepos = repos;
        notifyItemInserted(mRepos.size() - 1);
    }
    @Override
    public int getItemCount() {
        return mRepos.size();
    }

    @Override
    public ListAdapter.RepoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_repo, parent, false);
        return new RepoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ListAdapter.RepoViewHolder holder, int position) {
        holder.bindTo(mRepos.get(position));
    }


    static class RepoViewHolder  extends RecyclerView.ViewHolder{
        @Bind(R.id.item_iv_repo_name)
        TextView itemIvRepoName;
        @Bind(R.id.item_iv_repo_detail)
        TextView itemIvRepoDetail;

        RepoViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bindTo(Repo repo) {
            itemIvRepoName.setText(repo.name );
            itemIvRepoDetail.setText(String.valueOf(repo.description + "(" + repo.language + ")"));
        }
    }
}
