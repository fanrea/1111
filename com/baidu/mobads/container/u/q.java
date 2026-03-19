package com.baidu.mobads.container.u;

import android.graphics.Bitmap;
import android.view.View;
import com.baidu.mobads.container.k;
import com.baidu.mobads.container.util.bk;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class q extends k.a {
    final /* synthetic */ com.baidu.mobads.container.adrequest.j b;
    final /* synthetic */ p c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    q(p pVar, com.baidu.mobads.container.adrequest.j jVar) {
        super();
        this.c = pVar;
        this.b = jVar;
    }

    @Override // com.baidu.mobads.container.k.a, com.baidu.mobads.container.util.d.a, com.baidu.mobads.container.util.d.d.InterfaceC0136d
    public void a(String str, String str2, View view, com.baidu.mobads.container.util.d.c cVar) {
        if (this.c.mCacheAssetTimeRunning.getAndSet(false)) {
            this.c.disposeCacheAssetTimer();
            bk.a(this.c.mAppContext, this.c.mAdContainerCxt, bk.L, 6);
            this.c.processAdError(com.baidu.mobads.container.c.a.MCACHE_FETCH_FAILED, cVar.b(), com.baidu.mobads.container.components.k.b.L);
        }
        super.a(str, str2, view, cVar);
        com.baidu.mobads.container.components.h.c.f.a(this.c.mAppContext).a(this.b.getUniqueId());
    }

    @Override // com.baidu.mobads.container.k.a, com.baidu.mobads.container.util.d.a, com.baidu.mobads.container.util.d.d.InterfaceC0136d
    public void a(String str, String str2, View view, Bitmap bitmap) {
        if (this.c.mCacheAssetTimeRunning.getAndSet(false)) {
            this.c.disposeCacheAssetTimer();
            this.c.start();
        }
        super.a(str, str2, view, bitmap);
    }
}
