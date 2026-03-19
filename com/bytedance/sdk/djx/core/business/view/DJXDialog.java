package com.bytedance.sdk.djx.core.business.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DJXDialog extends Dialog {
    protected Activity mContext;

    public DJXDialog(Activity activity) {
        super(activity);
        this.mContext = activity;
    }

    public DJXDialog(Activity activity, int i) {
        super(activity, i);
        this.mContext = activity;
    }

    protected DJXDialog(Activity activity, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        super(activity, z, onCancelListener);
        this.mContext = activity;
    }

    public boolean isViewValid() {
        return !this.mContext.isFinishing();
    }

    @Override // android.app.Dialog
    public void show() {
        if (isViewValid()) {
            super.show();
        }
    }
}
