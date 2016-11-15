package com.lewish.start.selffragmentdemo.demo.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.lewish.start.selffragmentdemo.R;
import com.lewish.start.selffragmentdemo.demo.custome.CustomeDialog;
import com.lewish.start.selffragmentdemo.demo.custome.CustomeDialogFragment;
import com.lewish.start.selffragmentdemo.infrastructure.fragment.FlowFragment;

/**
 * Created by Administrator on 2016/9/28.
 */

public class LoginFragment extends FlowFragment {
    private ImageView headBack;

    private EditText et_userName;
    private EditText et_password;
    private Button bt_login;

    private CustomeDialog customeDialog;

    private String userName;
    private String password;
    public static LoginFragment newInstance(Bundle bundle){
        LoginFragment loginFragment = new LoginFragment();
        loginFragment.setArguments(bundle);
        return loginFragment;
    }
    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        headBack = (ImageView) view.findViewById(R.id.headBack);
        et_userName = (EditText) view.findViewById(R.id.et_userName);
        et_password = (EditText) view.findViewById(R.id.et_password);
        bt_login = (Button) view.findViewById(R.id.bt_login);

    }

    @Override
    protected void initListener() {
        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomeDialogFragment customeDialogFragment = new CustomeDialogFragment();
                customeDialogFragment.show(getFragmentManager(),"customeDialogFragment");
            }
        });
        headBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeFragment();
            }
        });
    }

    @Override
    protected void loadData() {
        Bundle bundle = getArguments();
        userName = bundle.getString("userName");
        password = bundle.getString("password");

        et_userName.setText(userName);
        et_password.setText(password);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_login;
    }
}
