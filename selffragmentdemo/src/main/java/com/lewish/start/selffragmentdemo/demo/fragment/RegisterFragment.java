package com.lewish.start.selffragmentdemo.demo.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.lewish.start.selffragmentdemo.R;
import com.lewish.start.selffragmentdemo.infrastructure.fragment.FlowFragment;


public class RegisterFragment extends FlowFragment{
    private ImageView headBack;
    private Button next_button;
    private TextView tv_login;
    private EditText et_userName;
    private EditText et_password;
    public static RegisterFragment newInstance(){
        return new RegisterFragment();
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        headBack = (ImageView) view.findViewById(R.id.headBack);

        next_button = (Button) view.findViewById(R.id.next_button);
        tv_login = (TextView) view.findViewById(R.id.tv_login);

        et_userName = (EditText) view.findViewById(R.id.et_userName);
        et_password = (EditText) view.findViewById(R.id.et_password);

    }

    @Override
    protected void initListener() {
        next_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("userName",et_userName.getText().toString().trim());
                bundle.putString("password",et_password.getText().toString().trim());
                addFragment(LoginFragment.newInstance(bundle));
            }
        });

        tv_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("userName",et_userName.getText().toString().trim());
                bundle.putString("password",et_password.getText().toString().trim());
                addFragment(LoginFragment.newInstance(bundle));
            }
        });

        headBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeFragment();
            }
        });
    }

    @Override    protected void loadData() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_register;
    }
}
