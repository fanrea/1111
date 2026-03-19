package com.baidu.mobads.container.activity;

import android.content.DialogInterface;
import android.view.KeyEvent;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class n implements DialogInterface.OnKeyListener {
    final /* synthetic */ DownloadDialogActivity a;

    n(DownloadDialogActivity downloadDialogActivity) {
        this.a = downloadDialogActivity;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i == 4) {
            return true;
        }
        return false;
    }
}
