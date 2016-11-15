package com.lewish.start.selffragmentdemo.infrastructure.fragment;

import com.lewish.start.selffragmentdemo.infrastructure.activity.FlowFragmentBaseActivity;

/**
 * Created by Administrator on 2016/9/26.
 */

public abstract class FlowFragment extends BaseFragment {
    /**
     * 获取宿主Activity
     * @return
     */
    protected FlowFragmentBaseActivity getHoldingActivity() {
        return (FlowFragmentBaseActivity) mActivity;
    }

    /**
     * 添加Fragment
     * @param fragment
     */
    protected void addFragment(FlowFragment fragment) {
        if (null != fragment) {
            getHoldingActivity().addFragment(fragment);
        }
    }

    /**
     * 移除Fragment
     */
    protected void removeFragment() {
        getHoldingActivity().removeFragment();
    }
}
