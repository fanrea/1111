package com.baidu.mobads.container.util.b;

import com.component.lottie.bb;
import com.component.lottie.t;
import java.util.concurrent.Callable;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class c implements Callable<bb<t>> {
    final /* synthetic */ t a;
    final /* synthetic */ a b;

    c(a aVar, t tVar) {
        this.b = aVar;
        this.a = tVar;
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public bb<t> call() {
        return new bb<>(this.a);
    }
}
