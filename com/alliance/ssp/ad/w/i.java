package com.alliance.ssp.ad.w;

import android.view.View;
import android.view.ViewTreeObserver;

/* compiled from: NMInterstitialAdImpl.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class i implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ View a;
    public final /* synthetic */ com.alliance.ssp.ad.impl.interstitial.a b;

    public i(com.alliance.ssp.ad.impl.interstitial.a aVar, View view) {
        this.b = aVar;
        this.a = view;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        int[] iArr = new int[2];
        this.a.getLocationInWindow(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        this.b.X = com.alliance.ssp.ad.a.f.a("", i);
        this.b.Y = com.alliance.ssp.ad.a.f.a("", i2);
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.b.G = "" + jCurrentTimeMillis;
        this.b.H = String.valueOf((int) (jCurrentTimeMillis / 1000));
        com.alliance.ssp.ad.impl.interstitial.a aVar = this.b;
        String str = aVar.X;
        String str2 = aVar.Y;
        int i3 = com.alliance.ssp.ad.o0.l.a;
    }
}
