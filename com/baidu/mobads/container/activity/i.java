package com.baidu.mobads.container.activity;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class i implements com.baidu.mobads.container.components.a.k {
    final /* synthetic */ DownloadDialogActivity a;

    i(DownloadDialogActivity downloadDialogActivity) {
        this.a = downloadDialogActivity;
    }

    @Override // com.baidu.mobads.container.components.a.k
    public void a() {
        this.a.sendDownloadDialogLog("click_button_download");
        e.a().a(7);
        this.a.sendWinUrl(102, null, 201);
        this.a.finishActivityWithAnim();
    }

    @Override // com.baidu.mobads.container.components.a.k
    public void b() {
        this.a.sendDownloadDialogLog("click_button_close");
        this.a.sendWinUrl(401, null, 201);
        this.a.finishActivityWithAnim();
    }

    @Override // com.baidu.mobads.container.components.a.k
    public void c() {
    }
}
