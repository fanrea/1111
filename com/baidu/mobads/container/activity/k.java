package com.baidu.mobads.container.activity;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class k implements Runnable {
    final /* synthetic */ DownloadDialogActivity a;

    k(DownloadDialogActivity downloadDialogActivity) {
        this.a = downloadDialogActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.mPromoteDlDialogShow = true;
        com.baidu.mobads.container.util.h.a(new l(this));
    }
}
