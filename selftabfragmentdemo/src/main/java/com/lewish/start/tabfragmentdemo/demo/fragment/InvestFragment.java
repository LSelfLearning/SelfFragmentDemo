package com.lewish.start.tabfragmentdemo.demo.fragment;

import android.os.Bundle;
import android.view.View;

import com.lewish.start.tabfragmentdemo.R;
import com.lewish.start.tabfragmentdemo.infrastructure.fragment.SiblingFragment;

/**
 * Created by Administrator on 2016/9/29.
 */

public class InvestFragment extends SiblingFragment {
    public static InvestFragment newInstance(){
        return new InvestFragment();
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
        return R.layout.fragment_invest;
    }
}
