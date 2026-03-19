package com.permissionx.guolindev.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public abstract class RationaleDialog extends Dialog {
    public abstract View getNegativeButton();

    public abstract List<String> getPermissionsToRequest();

    public abstract View getPositiveButton();

    public RationaleDialog(Context context) {
        super(context);
    }

    public RationaleDialog(Context context, int i) {
        super(context, i);
    }

    protected RationaleDialog(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z, onCancelListener);
    }
}
