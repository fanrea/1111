package com.component.lottie;

import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class ac implements ay<Throwable> {
    final /* synthetic */ String a;
    final /* synthetic */ AtomicBoolean b;

    ac(String str, AtomicBoolean atomicBoolean) {
        this.a = str;
        this.b = atomicBoolean;
    }

    @Override // com.component.lottie.ay
    public void a(Throwable th) {
        u.a.remove(this.a);
        this.b.set(true);
    }
}
