package com.lewish.start.tabfragmentdemo.infrastructure.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;

import com.lewish.start.tabfragmentdemo.infrastructure.fragment.FlowFragment;


/**
 * Created by Administrator on 2016/9/26.
 * 流程式FragmentActivity
 */

public abstract class FlowFragmentBaseActivity extends FragmentBaseActivity {

    //布局中Fragment的ID
    protected abstract int getFragmentContentId();

    //获取第一个fragment
    protected abstract FlowFragment getFirstFragment();

    //添加fragment
    public void addFragment(FlowFragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(getFragmentContentId(), fragment, fragment.getClass().getSimpleName())
                    .addToBackStack(fragment.getClass().getSimpleName())
                    .commitAllowingStateLoss();
        }
    }

    //移除fragment
    public void removeFragment() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
            getSupportFragmentManager().popBackStack();
        } else {
            finish();
        }
    }

    //返回键返回事件
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (KeyEvent.KEYCODE_BACK == keyCode) {
            if (getSupportFragmentManager().getBackStackEntryCount() == 1) {
                finish();
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }


    //处理Intent
    protected void handleIntent(Intent intent) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //避免重复添加Fragment
        if (null == getSupportFragmentManager().getFragments()) {
            FlowFragment firstFragment = getFirstFragment();
            if (null != firstFragment) {
                addFragment(firstFragment);
            }
        }
    }

}
