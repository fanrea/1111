package com.kwad.sdk.core.webview.d;

import android.content.Context;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.components.d;
import com.kwad.sdk.components.h;
import com.kwad.sdk.core.webview.c.c;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.f;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.be;
import com.kwad.sdk.utils.bs;
import com.kwad.sdk.utils.m;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class a implements com.kwad.sdk.core.webview.c.a {
    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "getDeviceInfo";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, c cVar) {
        cVar.a(C0595a.adL());
    }

    /* renamed from: com.kwad.sdk.core.webview.d.a$a, reason: collision with other inner class name */
    public static final class C0595a extends com.kwad.sdk.core.response.a.a {
        public String NG;
        public String SDKVersion;
        public int SDKVersionCode;
        public int Sj;
        public int Sk;
        public String aeY;
        public String aeZ;
        public int afa;
        public String afb;
        public int afc;
        public String afd;
        public int afe;
        public int aff;
        public String appId;
        public String appName;
        public String appVersion;
        public String bAx;
        public String bAy;
        public String bFF;
        public String bGG;
        public String bGp;
        public String bGs;
        public String bGt;
        public String bMl;
        public String bMm;
        public boolean bMn;
        public String bMo;
        public String language;
        public String model;
        public String sdkApiVersion;
        public int sdkApiVersionCode;
        public int sdkType;

        public static C0595a adL() {
            C0595a c0595a = new C0595a();
            c0595a.SDKVersion = BuildConfig.VERSION_NAME;
            c0595a.SDKVersionCode = BuildConfig.VERSION_CODE;
            c0595a.bFF = "6.1.7";
            c0595a.bMo = "1.3";
            c0595a.sdkApiVersion = ((f) ServiceProvider.get(f.class)).getApiVersion();
            c0595a.sdkApiVersionCode = ((f) ServiceProvider.get(f.class)).getApiVersionCode();
            c0595a.sdkType = 2;
            Context context = ((f) ServiceProvider.get(f.class)).getContext();
            c0595a.appVersion = m.dc(context);
            c0595a.appName = ((f) ServiceProvider.get(f.class)).getAppName();
            c0595a.appId = ((f) ServiceProvider.get(f.class)).getAppId();
            c0595a.bMl = "";
            c0595a.bGt = ag.aoE();
            h hVar = (h) d.g(h.class);
            if (hVar != null) {
                c0595a.bGs = hVar.qm();
            }
            c0595a.aeY = String.valueOf(ao.dX(context));
            c0595a.aeZ = bs.aqi();
            c0595a.model = bs.apY();
            c0595a.NG = bs.aqa();
            c0595a.afa = 1;
            c0595a.afb = bs.getOsVersion();
            c0595a.afc = bs.aql();
            c0595a.language = bs.getLanguage();
            c0595a.afd = bs.getLocale();
            c0595a.bMn = ((f) ServiceProvider.get(f.class)).TQ();
            c0595a.bMm = be.getDeviceId();
            c0595a.Sk = bs.getScreenWidth(context);
            c0595a.Sj = bs.getScreenHeight(context);
            c0595a.bAx = be.eg(context);
            c0595a.bAy = be.getOaid();
            c0595a.bGp = be.eh(context);
            c0595a.bGG = be.ei(context);
            c0595a.afe = com.kwad.sdk.c.a.a.getStatusBarHeight(context);
            c0595a.aff = com.kwad.sdk.c.a.a.a(context, 50.0f);
            return c0595a;
        }
    }
}
