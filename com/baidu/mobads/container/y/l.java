package com.baidu.mobads.container.y;

import android.content.Context;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class l implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ k b;

    l(k kVar, Context context) {
        this.b = kVar;
        this.a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.b(this.b.a(this.a, true));
    }
}
