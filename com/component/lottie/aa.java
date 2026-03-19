package com.component.lottie;

import java.util.concurrent.Callable;
import java.util.zip.ZipInputStream;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class aa implements Callable<bb<t>> {
    final /* synthetic */ ZipInputStream a;
    final /* synthetic */ String b;

    aa(ZipInputStream zipInputStream, String str) {
        this.a = zipInputStream;
        this.b = str;
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public bb<t> call() {
        return u.b(this.a, this.b);
    }
}
