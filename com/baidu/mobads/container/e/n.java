package com.baidu.mobads.container.e;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class n implements Runnable {
    final /* synthetic */ l a;

    n(l lVar) {
        this.a = lVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.a.mAdLogger.a("remote Interstitial.removeAd");
            com.baidu.mobads.container.components.h.c.f.a(this.a.mAppContext).a(this.a.mAdInstanceInfo.getUniqueId());
            if (this.a.ab) {
                if (this.a.T != null) {
                    this.a.T.c();
                }
            } else if (this.a.d != null) {
                this.a.d.a();
                this.a.d = null;
                this.a.e = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
