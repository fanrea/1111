package com.component.lottie;

import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.concurrent.Callable;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class v implements Callable<bb<t>> {
    final /* synthetic */ WeakReference a;
    final /* synthetic */ Context b;
    final /* synthetic */ int c;
    final /* synthetic */ String d;

    v(WeakReference weakReference, Context context, int i, String str) {
        this.a = weakReference;
        this.b = context;
        this.c = i;
        this.d = str;
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public bb<t> call() {
        Context context = (Context) this.a.get();
        if (context == null) {
            context = this.b;
        }
        return u.b(context, this.c, this.d);
    }
}
