package com.alliance.ssp.ad.u;

import android.view.ViewTreeObserver;

/* compiled from: NMBannerAdImpl.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class e implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ com.alliance.ssp.ad.impl.banner.a a;

    public e(com.alliance.ssp.ad.impl.banner.a aVar) {
        this.a = aVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        com.alliance.ssp.ad.impl.banner.a aVar = this.a;
        aVar.a(aVar.b1);
    }
}
