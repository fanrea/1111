package com.component.feed;

import java.util.Locale;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class w implements Runnable {
    final /* synthetic */ m a;

    w(m mVar) {
        this.a = mVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.a.x == null || this.a.ak == null || this.a.al == null) {
            return;
        }
        int iG = this.a.x.g() / 1000;
        this.a.ak.setText(String.format(Locale.getDefault(), "%02d:%02d", Integer.valueOf(iG / 60), Integer.valueOf(iG % 60)));
        this.a.al.setProgress(this.a.x.g());
        this.a.postDelayed(this, 500L);
    }
}
