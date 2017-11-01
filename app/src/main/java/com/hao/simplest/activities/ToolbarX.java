package com.hao.simplest.activities;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

/**
 * Created by Hao on 2017/11/1.
 */

public class ToolbarX {
    private Toolbar mToolbar;
    private AppCompatActivity mActivity;
    private ActionBar mActionBar;

    public ToolbarX(Toolbar toolbar,AppCompatActivity activity){
        mToolbar = toolbar;
        mActivity = activity;
        mActivity.setSupportActionBar(mToolbar);
        mActionBar = mActivity.getSupportActionBar();
        mActionBar.setDisplayHomeAsUpEnabled(true);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mActivity.finish();
            }
        });
    }
    public void setTitle(String text){
        mActionBar.setTitle(text);
    }
    public void setSubTitle(String text){
        mActionBar.setSubtitle(text);
    }
    public void setTitle(int text){
        mActionBar.setTitle(text);
    }
    public void setSubTitle(int text){
        mActionBar.setSubtitle(text);
    }
}
