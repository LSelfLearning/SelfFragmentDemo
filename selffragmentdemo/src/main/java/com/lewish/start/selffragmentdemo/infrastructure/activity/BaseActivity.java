package com.lewish.start.selffragmentdemo.infrastructure.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by sundong on 2016/9/26.
 */

public abstract class BaseActivity extends AppCompatActivity {
    //布局文件ID
    protected abstract int getContentViewId();
    //处理Intent
    protected void handleIntent(Intent intent) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewId());
        if (null != getIntent()) {
            handleIntent(getIntent());
        }
    }

    /**
     * 带参启动Activity
     * @param cls
     * @param bundle
     */
    protected void openActivity(Class<?> cls, Bundle bundle) {
        Intent intent = new Intent(this, cls);
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

    /**
     * 带回调的启动Activity（传参）
     * @param cls
     * @param bundle
     * @param requestCode
     */
    public void openActivityForResult(Class<?> cls, Bundle bundle, int requestCode) {
        Intent intent = new Intent(this, cls);
        if (bundle != null)
            intent.putExtras(bundle);
        startActivityForResult(intent, requestCode);
    }

    /**
     * 带回调的启动Activity（不传参）
     * @param cls
     * @param requestCode
     */
    public void openActivityForResult(Class<?> cls, int requestCode) {
        openActivityForResult(cls, null, requestCode);
    }
}
