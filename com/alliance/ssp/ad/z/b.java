package com.alliance.ssp.ad.z;

import android.content.Context;
import android.view.ViewTreeObserver;
import com.alliance.ssp.ad.impl.splash.NMSplashAdImpl;
import com.alliance.ssp.ad.o0.h;

/* compiled from: NMSplashAdImpl.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class b implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ Context a;
    public final /* synthetic */ NMSplashAdImpl b;

    public b(NMSplashAdImpl nMSplashAdImpl, Context context) {
        this.b = nMSplashAdImpl;
        this.a = context;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        int[] iArr = new int[2];
        this.b.G0.getLocationInWindow(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        this.b.f0 = com.alliance.ssp.ad.a.f.a("", i);
        this.b.g0 = com.alliance.ssp.ad.a.f.a("", i2);
        this.b.h0 = com.alliance.ssp.ad.a.b.a("").append(h.a(this.a, 320.0f)).toString();
        this.b.i0 = com.alliance.ssp.ad.a.b.a("").append(h.a(this.a, 78.0f)).toString();
    }
}
