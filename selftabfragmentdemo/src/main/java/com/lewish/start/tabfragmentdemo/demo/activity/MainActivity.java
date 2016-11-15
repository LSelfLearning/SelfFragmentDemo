package com.lewish.start.tabfragmentdemo.demo.activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.RadioGroup;

import com.lewish.start.tabfragmentdemo.R;
import com.lewish.start.tabfragmentdemo.demo.fragment.HomeFragment;
import com.lewish.start.tabfragmentdemo.demo.fragment.InvestFragment;
import com.lewish.start.tabfragmentdemo.demo.fragment.PersonalFragment;
import com.lewish.start.tabfragmentdemo.infrastructure.activity.SiblingFragmentBaseActivity;
import com.lewish.start.tabfragmentdemo.infrastructure.fragment.SiblingFragment;

public class MainActivity extends SiblingFragmentBaseActivity {
    private RadioGroup main_tab_group;
    /**
     * 首页
     */
    private HomeFragment homeFragment;
    /**
     * 投资
     */
    private InvestFragment inverstFragment;
    /**
     * 我的
     */
    public PersonalFragment personalFragment;
    @Override
    protected int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected int getFragmentContentId() {
        return R.id.fl_content;
    }

    @Override
    protected SiblingFragment getDefaultFragment() {
        if(homeFragment==null) {
            homeFragment = HomeFragment.newInstance();
        }
        return homeFragment;
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        main_tab_group = (RadioGroup)findViewById(R.id.main_tab_group);
    }


    @Override
    protected void initListener() {
        main_tab_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.tab_home :
                        switchContent(homeFragment);
                        break;
                    case R.id.tab_invest :
                        if(inverstFragment==null) {
                            inverstFragment = InvestFragment.newInstance();
                        }
                        switchContent(inverstFragment);
                        break;
                    case R.id.tab_personal:
                        if(personalFragment==null) {
                            personalFragment = PersonalFragment.newInstance();
                        }
                        switchContent(personalFragment);
                        break;
                }
                Log.d("111111111111111111", getSupportFragmentManager().getFragments().size()+"");
            }
        });
    }

    @Override
    protected void initVariables() {

    }

}
