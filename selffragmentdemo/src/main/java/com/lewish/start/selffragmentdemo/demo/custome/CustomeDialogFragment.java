package com.lewish.start.selffragmentdemo.demo.custome;

import android.app.Dialog;
import android.widget.Toast;

import com.lewish.start.selffragmentdemo.R;
import com.lewish.start.selffragmentdemo.infrastructure.fragment.BaseDialogFragment;

/**
 * Created by Administrator on 2016/10/10 16:50.
 */

public class CustomeDialogFragment extends BaseDialogFragment {

    @Override
    public Dialog getDialog(Dialog dialog) {
        final CustomeDialog customeDialog = new CustomeDialog(getActivity(), R.style.MyDialog);
        customeDialog.setStrTitle("自定义对话框");
        customeDialog.setStrMessage("我是自定义对话框");
        customeDialog.setOnBtnYesClickListener("Yes", new CustomeDialog.onBtnYesClickListener() {
            @Override
            public void onBtnYesClick() {
                Toast.makeText(getActivity(), "Yes", Toast.LENGTH_SHORT).show();
            }
        });
        customeDialog.setOnBtnNoClickListener("No", new CustomeDialog.onBtnNoClickListener() {
            @Override
            public void onBtnNoClick() {
                Toast.makeText(getActivity(), "No", Toast.LENGTH_SHORT).show();
                customeDialog.dismiss();
            }
        });
        return customeDialog;
    }
}