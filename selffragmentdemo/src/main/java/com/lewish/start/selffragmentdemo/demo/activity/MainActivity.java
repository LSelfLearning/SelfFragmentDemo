package com.lewish.start.selffragmentdemo.demo.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.lewish.start.selffragmentdemo.R;
import com.lewish.start.selffragmentdemo.infrastructure.activity.ExhibitionBaseActivity;

public class MainActivity extends ExhibitionBaseActivity {
    private ImageView headBack;
    private TextView headtitle;
    private TextView headRegist;
    private Button bt_register;
    @Override
    protected int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        bt_register = (Button)findViewById(R.id.bt_register);
        headBack = (ImageView)findViewById(R.id.headBack);
    }

    @Override
    protected void initHeadView() {
        headtitle = (TextView)findViewById(R.id.headtitle);
        headtitle.setText("银谷在线首页");
    }

    @Override
    protected void initVariables() {

    }

    @Override
    protected void initListener() {
        bt_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(LoginActivity.class);
            }
        });
        headBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    @Override
    protected void loadData() {

    }

}
