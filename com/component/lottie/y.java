package com.component.lottie;

import java.util.concurrent.Callable;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class y implements Callable<bb<t>> {
    final /* synthetic */ String a;
    final /* synthetic */ String b;

    y(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public bb<t> call() {
        return u.b(this.a, this.b);
    }
}
