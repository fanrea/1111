package com.style.widget;

import android.app.Dialog;
import android.widget.PopupWindow;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class h implements PopupWindow.OnDismissListener {
    final /* synthetic */ Dialog a;
    final /* synthetic */ a b;

    h(a aVar, Dialog dialog) {
        this.b = aVar;
        this.a = dialog;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.a.getWindow().clearFlags(2);
    }
}
