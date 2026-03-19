package com.baidu.mobads.container.x.a;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class b implements Runnable {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (a.g && this.a.c != null && this.a.mProgressView != null) {
                int iG = this.a.c.g();
                int iH = this.a.c.h();
                this.a.mProgressView.a(iH, iH - iG);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.a.h.postDelayed(this, 200L);
    }
}
