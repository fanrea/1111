package com.baidu.mobads.container.activity;

import android.app.Dialog;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class h implements Runnable {
    final /* synthetic */ f a;

    h(f fVar) {
        this.a = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.a.mDlKeepDialog = new Dialog(this.a.a.activity);
        this.a.a.initDialog(this.a.a.activity, 201, this.a.a.adInfo.getAppName(), this.a.a.mDlKeepDialogEventListener, this.a.a.mDlKeepDialog);
        this.a.a.mApkLinkDialogShow = true;
    }
}
