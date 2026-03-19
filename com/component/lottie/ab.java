package com.component.lottie;

import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class ab implements ay<t> {
    final /* synthetic */ String a;
    final /* synthetic */ AtomicBoolean b;

    ab(String str, AtomicBoolean atomicBoolean) {
        this.a = str;
        this.b = atomicBoolean;
    }

    @Override // com.component.lottie.ay
    public void a(t tVar) {
        u.a.remove(this.a);
        this.b.set(true);
    }
}
