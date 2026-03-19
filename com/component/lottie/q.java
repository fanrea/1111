package com.component.lottie;

import com.component.lottie.k;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class q implements Runnable {
    final /* synthetic */ k.b a;
    final /* synthetic */ k b;

    q(k kVar, k.b bVar) {
        this.b = kVar;
        this.a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.i.removeCallbacksAndMessages(null);
        this.a.a(this.b.e, this.b.k);
    }
}
