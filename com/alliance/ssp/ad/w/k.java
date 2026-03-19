package com.alliance.ssp.ad.w;

import android.graphics.Bitmap;
import com.alliance.ssp.ad.api.interstitial.SAInterstitialAd;
import com.alliance.ssp.ad.api.interstitial.SAInterstitialAdInteractionListener;
import com.alliance.ssp.ad.api.interstitial.SAInterstitialAdVideoListener;

/* compiled from: NMInterstitialAdView.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class k extends com.alliance.ssp.ad.t.g implements SAInterstitialAd {
    public static final Object g = new Object();
    public SAInterstitialAdInteractionListener c = null;
    public SAInterstitialAdVideoListener d;
    public Bitmap e;
    public com.alliance.ssp.ad.impl.interstitial.a f;

    public k(Bitmap bitmap, com.alliance.ssp.ad.impl.interstitial.a aVar) {
        this.e = bitmap;
        this.f = aVar;
    }

    @Override // com.alliance.ssp.ad.t.g
    public String a() {
        return "1";
    }

    @Override // com.alliance.ssp.ad.api.BaseAllianceAd
    public void destroy() {
        Bitmap bitmap = this.e;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.e.recycle();
            this.e = null;
        }
        com.alliance.ssp.ad.impl.interstitial.a aVar = this.f;
        if (aVar != null) {
            com.alliance.ssp.ad.r.c.a(aVar.g1.getDeeplink());
            if (aVar.G1 != null) {
                aVar.G1 = null;
            }
            aVar.p();
            aVar.N();
            aVar.E();
            this.f = null;
        }
    }

    @Override // com.alliance.ssp.ad.api.interstitial.SAInterstitialAd
    public void setInterstitialAdInteractionListener(SAInterstitialAdInteractionListener sAInterstitialAdInteractionListener) {
        synchronized (g) {
            this.c = sAInterstitialAdInteractionListener;
        }
    }

    @Override // com.alliance.ssp.ad.api.interstitial.SAInterstitialAd
    public void setInterstitialAdVideoListener(SAInterstitialAdVideoListener sAInterstitialAdVideoListener) {
        this.d = sAInterstitialAdVideoListener;
    }
}
