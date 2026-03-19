package com.component.lottie;

import java.util.concurrent.Callable;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class z implements Callable<bb<t>> {
    final /* synthetic */ com.component.lottie.f.a.c a;
    final /* synthetic */ String b;

    z(com.component.lottie.f.a.c cVar, String str) {
        this.a = cVar;
        this.b = str;
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public bb<t> call() {
        return u.b(this.a, this.b);
    }
}
