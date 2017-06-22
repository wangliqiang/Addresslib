package com.app.addresslib.widget;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import com.app.addresslib.R;

/**
 * Created by 王立强 on 2017/6/21.
 */

public class BottomDialog extends Dialog {
    private AddressSelector selector;

    public BottomDialog(@NonNull Context context) {
        super(context, R.style.bottom_dialog);
        init(context);
    }

    public BottomDialog(@NonNull Context context, @StyleRes int themeResId) {
        super(context, themeResId);
        init(context);
    }

    protected BottomDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        init(context);
    }

    private void init(Context context) {
        selector = new AddressSelector(context);
        setContentView(selector.getView());

        Window window = getWindow();
        WindowManager.LayoutParams params = window.getAttributes();
        params.width = WindowManager.LayoutParams.MATCH_PARENT;
        params.height = dp2px(context, 256);
        window.setAttributes(params);

        window.setGravity(Gravity.BOTTOM);
    }

    public void setOnAddressSelectedListener(OnAddressSelectedListener listener) {
        this.selector.setOnAddressSelectedListener(listener);
    }

    public static BottomDialog show(Context context) {
        return show(context, null);
    }

    public static BottomDialog show(Context context, OnAddressSelectedListener listener) {
        BottomDialog dialog = new BottomDialog(context, R.style.bottom_dialog);
        dialog.selector.setOnAddressSelectedListener(listener);
        dialog.show();

        return dialog;
    }

    public static int dp2px(Context context, float dp) {
        return (int) Math.ceil(context.getResources().getDisplayMetrics().density * dp);
    }

}
