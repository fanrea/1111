package com.alliance.ssp.ad.u;

import android.graphics.Bitmap;
import android.view.View;
import com.alliance.ssp.ad.api.banner.SABannerAd;
import com.alliance.ssp.ad.api.banner.SABannerAdInteractionListener;
import com.alliance.ssp.ad.t.g;

/* compiled from: NMBannerAdView.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class f extends g implements SABannerAd {
    public static final Object g = new Object();
    public SABannerAdInteractionListener c = null;
    public View d = null;
    public Bitmap e;
    public com.alliance.ssp.ad.impl.banner.a f;

    public f(Bitmap bitmap, com.alliance.ssp.ad.impl.banner.a aVar) {
        this.e = bitmap;
        this.f = aVar;
    }

    @Override // com.alliance.ssp.ad.t.g
    public String a() {
        return "1";
    }

    @Override // com.alliance.ssp.ad.api.BaseAllianceAd
    public void destroy() {
        if (this.d != null) {
            this.d = null;
        }
        Bitmap bitmap = this.e;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.e.recycle();
            this.e = null;
        }
        com.alliance.ssp.ad.impl.banner.a aVar = this.f;
        if (aVar != null) {
            aVar.p();
            aVar.I();
            this.f = null;
        }
    }

    @Override // com.alliance.ssp.ad.api.banner.SABannerAd
    public void setBannerAdInteractionListener(SABannerAdInteractionListener sABannerAdInteractionListener) {
        synchronized (g) {
            this.c = sABannerAdInteractionListener;
        }
    }
}
