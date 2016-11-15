package com.lewish.start.selffragmentdemo.infrastructure.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lewish.start.selffragmentdemo.infrastructure.activity.BaseActivity;
import com.lewish.start.selffragmentdemo.infrastructure.activity.FragmentBaseActivity;

/**
 * Created by Administrator on 2016/9/26.
 */

public abstract class BaseFragment extends Fragment {

    protected FragmentBaseActivity mActivity;

    protected abstract void initView(View view, Bundle savedInstanceState);

    protected abstract void initListener();

    protected abstract void loadData();

    //获取fragment布局文件ID
    protected abstract int getLayoutId();

    /**
     * 获取宿主Activity
     * @return
     */
    protected BaseActivity getHoldingActivity() {
        return mActivity;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mActivity = (FragmentBaseActivity) activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        initView(view, savedInstanceState);
        initListener();
        loadData();
        return view;
    }

    /**
     * 带参启动Activity
     * @param cls
     * @param bundle
     */
    protected void openActivity(Class<?> cls, Bundle bundle) {
        Intent intent = new Intent(getContext(), cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    /**
     * 不带参启动Activity
     * @param cls
     */
    protected void openActivity(Class<?> cls) {
        openActivity(cls, null);
    }
}
