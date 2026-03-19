package com.fc.tjcpl.sdk.n;

import com.fc.tjcpl.sdk.view.ViewDownloadBtn;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class f0 implements Runnable {
    public final /* synthetic */ ViewDownloadBtn a;

    public f0(ViewDownloadBtn viewDownloadBtn) {
        this.a = viewDownloadBtn;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.b.performClick();
    }
}
