package com.component.lottie;

import java.io.InputStream;
import java.util.concurrent.Callable;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class w implements Callable<bb<t>> {
    final /* synthetic */ InputStream a;
    final /* synthetic */ String b;

    w(InputStream inputStream, String str) {
        this.a = inputStream;
        this.b = str;
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public bb<t> call() {
        return u.b(this.a, this.b);
    }
}
