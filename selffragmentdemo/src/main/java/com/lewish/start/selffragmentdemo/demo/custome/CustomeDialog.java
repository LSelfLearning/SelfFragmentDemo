package com.lewish.start.selffragmentdemo.demo.custome;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.lewish.start.selffragmentdemo.R;

/**
 * Created by Administrator on 2016/10/10 16:08.
 */

public class CustomeDialog extends Dialog {
    private Activity mActivity;
    private Button btnYes;
    private Button btnNo;
    private TextView tvTitle;
    private TextView tvMessage;
    private String strTitle,strMessage,strYes,strNo;

    private onBtnYesClickListener onBtnYesClickListener;
    private onBtnNoClickListener onBtnNoClickListener;

    public CustomeDialog(Context context) {
        super(context);
        mActivity = (Activity) context;
    }

    public CustomeDialog(Context context, int themeResId) {
        super(context, themeResId);
        mActivity = (Activity) context;
    }

    protected CustomeDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        mActivity = (Activity) context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customedialog);

        initViews();
        initData();
        initEvent();
    }

    private void initEvent() {
        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onBtnYesClickListener!=null) {
                    onBtnYesClickListener.onBtnYesClick();
                }
            }
        });

        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onBtnNoClickListener!=null) {
                    onBtnNoClickListener.onBtnNoClick();
                }
            }
        });
    }

    private void initData() {
        if(strTitle!=null) {
            tvTitle.setText(strTitle);
        }
        if(strMessage!=null) {
            tvMessage.setText(strMessage);
        }
        if(strYes!=null) {
            btnYes.setText(strYes);
        }
        if(strNo!=null) {
            btnNo.setText(strNo);
        }
    }
    /**
     * 获得屏幕高度
     */
    public static int getScreenWidth(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        return outMetrics.widthPixels;
    }

    private void initViews() {
        Window window = getWindow();
        // 将Dialog显示到屏幕的底部
        window.setGravity(Gravity.BOTTOM);
        // 去掉Dialog本身的padding
        window.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
        // 设置宽度为屏幕宽度
        layoutParams.width = getScreenWidth(mActivity);
        window.setAttributes(layoutParams);

        tvTitle = (TextView)findViewById(R.id.tvTitle);
        tvMessage = (TextView)findViewById(R.id.tvMessage);
        btnNo = (Button)findViewById(R.id.btnNo);
        btnYes = (Button)findViewById(R.id.btnYes);
    }
    public interface onBtnYesClickListener{
        public void onBtnYesClick();
    }
    public interface onBtnNoClickListener{
        public void onBtnNoClick();
    }

    public void setOnBtnYesClickListener(String strYes ,CustomeDialog.onBtnYesClickListener onBtnYesClickListener) {
        this.onBtnYesClickListener = onBtnYesClickListener;
        this.strYes = strYes;
    }

    public void setOnBtnNoClickListener(String strNo,CustomeDialog.onBtnNoClickListener onBtnNoClickListener) {
        this.onBtnNoClickListener = onBtnNoClickListener;
        this.strNo = strNo;
    }

    public void setStrTitle(String strTitle) {
        this.strTitle = strTitle;
    }

    public void setStrMessage(String strMessage) {
        this.strMessage = strMessage;
    }
}
