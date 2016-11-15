package com.lewish.start.tabfragmentdemo.demo.fragment;

import android.os.Bundle;
import android.view.View;

import com.lewish.start.tabfragmentdemo.R;
import com.lewish.start.tabfragmentdemo.infrastructure.fragment.SiblingFragment;

/**
 * Created by Administrator on 2016/9/29.
 */

public class HomeFragment extends SiblingFragment {
    public static HomeFragment newInstance(){
        return new HomeFragment();
    }
    @Override
    protected void initView(View view, Bundle savedInstanceState) {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void loadData() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }
}
