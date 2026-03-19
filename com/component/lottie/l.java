package com.component.lottie;

import com.component.lottie.k;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class l implements Runnable {
    final /* synthetic */ k.b a;
    final /* synthetic */ k b;

    l(k kVar, k.b bVar) {
        this.b = kVar;
        this.a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.a(this.a, "Lottie load time out.");
    }
}
