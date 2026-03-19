package com.baidu.mobads.container.activity;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class j implements com.baidu.mobads.container.components.a.k {
    final /* synthetic */ DownloadDialogActivity a;

    j(DownloadDialogActivity downloadDialogActivity) {
        this.a = downloadDialogActivity;
    }

    @Override // com.baidu.mobads.container.components.a.k
    public void a() {
        this.a.sendDownloadDialogLog("click_button_download");
        e.a().a(7);
        this.a.sendWinUrl(102, null, 202);
        this.a.finishActivityWithAnim();
    }

    @Override // com.baidu.mobads.container.components.a.k
    public void b() {
        if (this.a.mPromoteDlDialog != null) {
            this.a.mPromoteDlDialog.dismiss();
        }
        this.a.sendWinUrl(401, null, 202);
    }

    @Override // com.baidu.mobads.container.components.a.k
    public void c() {
    }
}
