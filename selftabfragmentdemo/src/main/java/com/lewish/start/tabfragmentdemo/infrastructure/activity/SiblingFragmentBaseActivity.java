package com.lewish.start.tabfragmentdemo.infrastructure.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;

import com.lewish.start.tabfragmentdemo.infrastructure.fragment.SiblingFragment;


/**
 * Created by Administrator on 2016/9/26.
 * 同級式FragmentActicity
 */

public abstract class SiblingFragmentBaseActivity extends FragmentBaseActivity{
    //布局中Fragment的ID
    protected abstract int getFragmentContentId();
    //得到默认显示的Fragment
    protected abstract SiblingFragment getDefaultFragment();

    protected abstract void initViews(Bundle savedInstanceState);

    protected abstract void initListener();

    protected abstract void initVariables();

    private SiblingFragment mContent;//当前Fragment页面

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewId());
        initViews(savedInstanceState);
        switchContent(getDefaultFragment());
        initListener();
        initVariables();
    }

    /**
     * 修改显示的内容,不会重新加载
     **/
    protected void switchContent(SiblingFragment to) {
        if (mContent != to) {
            FragmentTransaction transaction = getSupportFragmentManager()
                    .beginTransaction();
            if (!to.isAdded()) { // 先判断是否被add过
                if(getSupportFragmentManager().getFragments()==null) {//未被添加过且是第一次添加
                    transaction.add(getFragmentContentId(),to).commitAllowingStateLoss();
                }else {//未添加过但不是第一次添加
                    transaction.hide(mContent).add(getFragmentContentId(), to).commitAllowingStateLoss(); // 隐藏当前的fragment，add下一个到Activity中
                }
            } else {
                //已添加过
                transaction.hide(mContent).show(to).commitAllowingStateLoss(); // 隐藏当前的fragment，显示下一个
            }
            mContent = to;
        }
    }
}
