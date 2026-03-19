package com.alliance.ssp.ad.w;

import com.alliance.ssp.ad.video.VideoController;

/* compiled from: NMInterstitialAdImpl.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class b implements VideoController.h {
    public final /* synthetic */ com.alliance.ssp.ad.impl.interstitial.a a;

    public b(com.alliance.ssp.ad.impl.interstitial.a aVar) {
        this.a = aVar;
    }

    @Override // com.alliance.ssp.ad.video.VideoController.h
    public void a(boolean z) {
        if (z) {
            com.alliance.ssp.ad.impl.interstitial.a aVar = this.a;
            aVar.o("", "", aVar.h);
        } else {
            com.alliance.ssp.ad.impl.interstitial.a aVar2 = this.a;
            aVar2.j("", "", aVar2.h);
        }
    }
}
