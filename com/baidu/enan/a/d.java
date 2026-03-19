package com.baidu.enan.a;

import android.content.Context;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
final class d implements Runnable {
    final /* synthetic */ Context a;

    d(Context context) {
        this.a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            c.d(this.a);
        } catch (Throwable th) {
            com.baidu.enan.f.a.a(th);
        }
    }
}
