package com.hao.simplest.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TabHost;

import com.hao.simplest.R;
import com.hao.simplest.fragments.EditorFragment;
import com.hao.simplest.fragments.HomeFragment;
import com.hao.simplest.fragments.RefreshFragment;

/**
 * Created by Hao on 2017/11/1.
 */

public class HomePageActivity extends BaseActivity {

    private FrameLayout frameLayout;
    private FragmentTabHost fragmentTabHost;
    private RadioGroup radioGroup;
    private RadioButton choose;
    private RadioButton editor;
    private RadioButton refresh;
    private Class fragment[];

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragment = new Class[]{HomeFragment.class, EditorFragment.class, RefreshFragment.class};
        initialize();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_homepage;
    }
    private void initialize(){
        frameLayout = (FrameLayout)findViewById(R.id.flContainer);
        fragmentTabHost = (FragmentTabHost)findViewById(R.id.tbHost);
        radioGroup = (RadioGroup) findViewById(R.id.rgTab);
        choose = (RadioButton)findViewById(R.id.choose);
        editor = (RadioButton)findViewById(R.id.editor);
        refresh = (RadioButton)findViewById(R.id.refresh);
        fragmentTabHost.setup(getApplicationContext(),getSupportFragmentManager(),R.id.flContainer);
        for (int i = 0;i<fragment.length;i++){
            TabHost.TabSpec tabSpec = fragmentTabHost.newTabSpec(String.valueOf(i)).setIndicator(String.valueOf(i));
            fragmentTabHost.addTab(tabSpec,fragment[i],null);
        }
        fragmentTabHost.setCurrentTab(0);
    }
}
