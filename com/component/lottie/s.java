package com.component.lottie;

import com.component.lottie.k;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class s implements Runnable {
    final /* synthetic */ k.b a;
    final /* synthetic */ String b;
    final /* synthetic */ k c;

    s(k kVar, k.b bVar, String str) {
        this.c = kVar;
        this.a = bVar;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.a(this.c.e, this.b);
    }
}
