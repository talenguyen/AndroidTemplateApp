package com.tale.androidgradletemplate.views.adapters;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.tale.androidgradletemplate.R;
import com.tale.androidgradletemplate.model.pojo.GitUser;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Giang on 12/9/2014.
 */
public class GitUserAdapter extends RecyclerTypedAdapter<GitUser, GitUserAdapter.ViewHolder> {

    @Inject
    Activity activity;

    @Inject
    Picasso picasso;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View viewItem = activity.getLayoutInflater().inflate(R.layout.item_git_user, parent, false);
        return new ViewHolder(viewItem, picasso);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(getItem(position));
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @InjectView(R.id.ivAvatar)
        ImageView ivAvatar;
        @InjectView(R.id.tvLogin)
        TextView tvLogin;
        final Picasso picasso;

        public ViewHolder(View itemView, Picasso picasso) {
            super(itemView);
            this.picasso = picasso;
            ButterKnife.inject(this, itemView);
        }

        public void bind(GitUser item) {
            picasso.load(item.avatar_url).into(ivAvatar);
            tvLogin.setText(item.login);
        }
    }
}
