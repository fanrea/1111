package com.alliance.ssp.ad.w;

import android.view.View;
import android.widget.TextView;
import com.alliance.ssp.ad.l.d;

/* compiled from: NMInterstitialAdImpl.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class c implements d.c {
    public final /* synthetic */ com.alliance.ssp.ad.impl.interstitial.a a;

    public c(com.alliance.ssp.ad.impl.interstitial.a aVar) {
        this.a = aVar;
    }

    @Override // com.alliance.ssp.ad.l.d.c
    public void a(View view) {
        ((TextView) view).setHighlightColor(0);
        com.alliance.ssp.ad.impl.interstitial.a aVar = this.a;
        com.alliance.ssp.ad.impl.interstitial.a.a(aVar, aVar.g1.getPermissionUrl());
        int i = com.alliance.ssp.ad.o0.l.a;
    }

    @Override // com.alliance.ssp.ad.l.d.c
    public void b(View view) {
        ((TextView) view).setHighlightColor(0);
        com.alliance.ssp.ad.impl.interstitial.a aVar = this.a;
        com.alliance.ssp.ad.impl.interstitial.a.a(aVar, aVar.g1.getPrivacyUrl());
        int i = com.alliance.ssp.ad.o0.l.a;
    }

    @Override // com.alliance.ssp.ad.l.d.c
    public void c(View view) {
        ((TextView) view).setHighlightColor(0);
        com.alliance.ssp.ad.impl.interstitial.a aVar = this.a;
        com.alliance.ssp.ad.impl.interstitial.a.a(aVar, aVar.g1.getAppIntro());
        int i = com.alliance.ssp.ad.o0.l.a;
    }
}
