package com.lewish.start.selffragmentdemo.demo.activity;

import com.lewish.start.selffragmentdemo.R;
import com.lewish.start.selffragmentdemo.demo.fragment.RegisterFragment;
import com.lewish.start.selffragmentdemo.infrastructure.activity.FlowFragmentBaseActivity;
import com.lewish.start.selffragmentdemo.infrastructure.fragment.FlowFragment;

/**
 * Created by Administrator on 2016/9/26.
 */

public class LoginActivity extends FlowFragmentBaseActivity {
    @Override
    protected int getContentViewId() {
        return R.layout.activity_login;
    }

    @Override
    protected int getFragmentContentId() {
        return R.id.fragment_container;
    }

    @Override
    protected FlowFragment getFirstFragment() {
        return RegisterFragment.newInstance();
    }
}
