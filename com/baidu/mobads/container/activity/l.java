package com.baidu.mobads.container.activity;

import android.app.Dialog;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class l implements Runnable {
    final /* synthetic */ k a;

    l(k kVar) {
        this.a = kVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.a.a.mApkLinkDialogShow) {
            this.a.a.sendWinUrl(404, "dlKeepDialogShow", 202);
            return;
        }
        this.a.a.mPromoteDlDialog = new Dialog(this.a.a.activity);
        this.a.a.initDialog(this.a.a.activity, 202, this.a.a.adInfo.getAppName(), this.a.a.mPromoteDlDialogEventListener, this.a.a.mPromoteDlDialog);
        this.a.a.mApkLinkDialogShow = true;
    }
}
