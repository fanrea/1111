package com.fendasz.moku.planet.ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Display;
import android.view.WindowManager;
import com.fendasz.moku.planet.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class SuspendDialog extends Dialog {
    public SuspendDialog(Context context) {
        super(context);
    }

    public SuspendDialog(Context context, int i) {
        super(context, i);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.moku_dialog_suspend);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        setCancelable(false);
        Display defaultDisplay = getWindow().getWindowManager().getDefaultDisplay();
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        defaultDisplay.getSize(new Point());
        attributes.width = (int) (r1.x * 0.7d);
        attributes.height = dp2px(120);
        getWindow().setAttributes(attributes);
    }

    private int dp2px(int i) {
        return (int) ((i * ((int) Resources.getSystem().getDisplayMetrics().density)) + 0.5f);
    }
}
