package com.baidu.mobads.container.e;

import android.animation.ObjectAnimator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class bl implements Runnable {
    final /* synthetic */ l a;

    bl(l lVar) {
        this.a = lVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.a.bm != null) {
            this.a.bq = ObjectAnimator.ofFloat(this.a.bm, "alpha", 1.0f, 0.0f);
            this.a.bq.setDuration(200L);
            this.a.bq.addListener(new bm(this));
            this.a.bq.start();
        }
    }
}
