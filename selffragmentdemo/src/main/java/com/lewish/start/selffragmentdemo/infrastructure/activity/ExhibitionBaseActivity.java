package com.lewish.start.selffragmentdemo.infrastructure.activity;

import android.os.Bundle;

/**
 * Created by Administrator on 2016/9/26.
 * 仅用于视图展示的Activity
 */

public abstract class ExhibitionBaseActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
        initHeadView();
        initViews(savedInstanceState);
        initVariables();
        initListener();
        loadData();
    }

    protected abstract void initViews(Bundle savedInstanceState);

    protected abstract void initHeadView();

    protected abstract void initVariables();

    protected abstract void initListener();

    protected abstract void loadData();
}
