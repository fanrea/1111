package com.alliance.ssp.ad.impl.splash;

import android.graphics.Bitmap;
import com.alliance.ssp.ad.api.splash.SASplashAd;
import com.alliance.ssp.ad.api.splash.SASplashAdInteractionListener;
import com.alliance.ssp.ad.impl.splash.NMSplashAdImpl;
import com.alliance.ssp.ad.t.g;

/* compiled from: NMSplashAdView.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class c extends g implements SASplashAd {
    public static final Object f = new Object();
    public SASplashAdInteractionListener c = null;
    public Bitmap d;
    public NMSplashAdImpl e;

    public c(Bitmap bitmap, NMSplashAdImpl nMSplashAdImpl) {
        this.d = bitmap;
        this.e = nMSplashAdImpl;
    }

    @Override // com.alliance.ssp.ad.t.g
    public String a() {
        return "1";
    }

    @Override // com.alliance.ssp.ad.api.BaseAllianceAd
    public void destroy() {
        Bitmap bitmap = this.d;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.d.recycle();
            this.d = null;
        }
        NMSplashAdImpl nMSplashAdImpl = this.e;
        if (nMSplashAdImpl != null) {
            nMSplashAdImpl.E();
            nMSplashAdImpl.p();
            nMSplashAdImpl.M();
            nMSplashAdImpl.x1 = NMSplashAdImpl.SPLASH_STATE.DESTROY;
            this.e = null;
        }
    }

    @Override // com.alliance.ssp.ad.api.splash.SASplashAd
    public void setSplashAdInteractionListener(SASplashAdInteractionListener sASplashAdInteractionListener) {
        synchronized (f) {
            this.c = sASplashAdInteractionListener;
        }
    }
}
