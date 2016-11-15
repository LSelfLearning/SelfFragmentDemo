package com.lewish.start.selffragmentdemo.infrastructure.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import com.lewish.start.selffragmentdemo.infrastructure.fragment.FlowFragment;

/**
 * Created by Administrator on 2016/9/26.
 * 同級式FragmentActicity
 */

public abstract class SiblingFragmentBaseActivity extends FragmentBaseActivity{
    //布局文件ID
    protected abstract int getContentViewId();
    //布局中Fragment的ID
    protected abstract int getFragmentContentId();
    //得到默认显示的第一个Fragment
    protected abstract FlowFragment getFirstFragment();

    private Fragment mContent;//当前Fragment页面

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewId());
        mContent = getFirstFragment();
    }

    /**
     * 修改显示的内容,不会重新加载
     **/
    private void switchContent(Fragment to) {
        if (mContent != to) {
            FragmentTransaction transaction = getSupportFragmentManager()
                    .beginTransaction();
            if (!to.isAdded()) { // 先判断是否被add过
                transaction.hide(mContent).add(getFragmentContentId(), to).commitAllowingStateLoss(); // 隐藏当前的fragment，add下一个到Activity中
            } else {
                transaction.hide(mContent).show(to).commitAllowingStateLoss(); // 隐藏当前的fragment，显示下一个
            }
            mContent = to;
        }
    }
}
