package com.baidu.mobads.container;

import android.view.View;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class aj implements Runnable {
    final /* synthetic */ com.baidu.mobads.container.util.d.a a;
    final /* synthetic */ k b;

    aj(k kVar, com.baidu.mobads.container.util.d.a aVar) {
        this.b = kVar;
        this.a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.a != null) {
            this.a.a("", "", (View) null, com.baidu.mobads.container.util.d.c.j);
        }
        this.b.mCacheAssetTimer = null;
    }
}
