package com.lewish.start.selffragmentdemo.infrastructure.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;

/**
 * Created by Administrator on 2016/10/10 17:06.
 */

public abstract class BaseDialogFragment extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return getDialog();
    }
    public abstract Dialog getDialog(Dialog dialog);
}
