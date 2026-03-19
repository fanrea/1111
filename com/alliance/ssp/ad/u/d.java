package com.alliance.ssp.ad.u;

import android.view.View;
import android.widget.TextView;
import com.alliance.ssp.ad.l.d;
import com.alliance.ssp.ad.o0.l;

/* compiled from: NMBannerAdImpl.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class d implements d.c {
    public final /* synthetic */ com.alliance.ssp.ad.impl.banner.a a;

    public d(com.alliance.ssp.ad.impl.banner.a aVar) {
        this.a = aVar;
    }

    @Override // com.alliance.ssp.ad.l.d.c
    public void a(View view) {
        ((TextView) view).setHighlightColor(0);
        com.alliance.ssp.ad.impl.banner.a aVar = this.a;
        com.alliance.ssp.ad.impl.banner.a.a(aVar, aVar.Z0.getPermissionUrl());
        int i = l.a;
    }

    @Override // com.alliance.ssp.ad.l.d.c
    public void b(View view) {
        ((TextView) view).setHighlightColor(0);
        com.alliance.ssp.ad.impl.banner.a aVar = this.a;
        com.alliance.ssp.ad.impl.banner.a.a(aVar, aVar.Z0.getPrivacyUrl());
        int i = l.a;
    }

    @Override // com.alliance.ssp.ad.l.d.c
    public void c(View view) {
        ((TextView) view).setHighlightColor(0);
        com.alliance.ssp.ad.impl.banner.a aVar = this.a;
        com.alliance.ssp.ad.impl.banner.a.a(aVar, aVar.Z0.getAppIntro());
        int i = l.a;
    }
}
