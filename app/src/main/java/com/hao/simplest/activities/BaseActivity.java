package com.hao.simplest.activities;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hao.simplest.R;

public abstract class BaseActivity extends AppCompatActivity {
    private RelativeLayout rlContent;
    private Toolbar toolbar;
    private ToolbarX mToolbarX;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        initialize();
        View v = getLayoutInflater().inflate(getLayoutId(),rlContent,false);
        rlContent.addView(v);
        mToolbarX = new ToolbarX(toolbar,this);
    }

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        overridePendingTransition(R.anim.anim_in_right_left,R.anim.anim_out_right_left);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.anim_in_left_right,R.anim.anim_out_left_right);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        overridePendingTransition(R.anim.anim_in_right_left,R.anim.anim_out_right_left);
    }
    //初始化控件
    private void initialize(){
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        rlContent = (RelativeLayout)findViewById(R.id.rlContent) ;

    }
    public abstract int getLayoutId();

    public ToolbarX getmToolbar(){
        if (null == mToolbarX){
            return  new ToolbarX(toolbar,this);
        }
        return mToolbarX;
    }
}
