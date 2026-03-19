package com.alliance.ssp.ad.z;

import android.view.View;
import android.widget.TextView;
import com.alliance.ssp.ad.impl.splash.NMSplashAdImpl;
import com.alliance.ssp.ad.l.d;
import com.alliance.ssp.ad.o0.l;

/* compiled from: NMSplashAdImpl.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class d implements d.c {
    public final /* synthetic */ NMSplashAdImpl a;

    public d(NMSplashAdImpl nMSplashAdImpl) {
        this.a = nMSplashAdImpl;
    }

    @Override // com.alliance.ssp.ad.l.d.c
    public void a(View view) {
        ((TextView) view).setHighlightColor(0);
        NMSplashAdImpl nMSplashAdImpl = this.a;
        NMSplashAdImpl.a(nMSplashAdImpl, nMSplashAdImpl.T0.getPermissionUrl());
        int i = l.a;
        NMSplashAdImpl.e(this.a, true);
    }

    @Override // com.alliance.ssp.ad.l.d.c
    public void b(View view) {
        ((TextView) view).setHighlightColor(0);
        NMSplashAdImpl nMSplashAdImpl = this.a;
        NMSplashAdImpl.a(nMSplashAdImpl, nMSplashAdImpl.T0.getPrivacyUrl());
        int i = l.a;
        NMSplashAdImpl.e(this.a, true);
    }

    @Override // com.alliance.ssp.ad.l.d.c
    public void c(View view) {
        ((TextView) view).setHighlightColor(0);
        NMSplashAdImpl nMSplashAdImpl = this.a;
        NMSplashAdImpl.a(nMSplashAdImpl, nMSplashAdImpl.T0.getAppIntro());
        int i = l.a;
        NMSplashAdImpl.e(this.a, true);
    }
}
