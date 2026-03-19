package com.kwad.components.core.webview.jshandler;

import android.content.Context;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bs;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class ai implements com.kwad.sdk.core.webview.c.a {
    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "getKsPlayableDeviceInfo";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        cVar.a(a.va());
    }

    public static final class a extends com.kwad.sdk.core.response.a.a {
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
        public String language;
        public String model;
        public String sdkApiVersion;
        public int sdkApiVersionCode;
        public int sdkType;

        public static a va() {
            a aVar = new a();
            aVar.SDKVersion = BuildConfig.VERSION_NAME;
            aVar.SDKVersionCode = BuildConfig.VERSION_CODE;
            aVar.sdkApiVersion = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getApiVersion();
            aVar.sdkApiVersionCode = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getApiVersionCode();
            aVar.sdkType = 2;
            Context context = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext();
            aVar.appVersion = com.kwad.sdk.utils.m.dc(context);
            aVar.appName = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getAppName();
            aVar.appId = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getAppId();
            aVar.aeY = String.valueOf(com.kwad.sdk.utils.ao.dX(context));
            aVar.aeZ = bs.aqi();
            aVar.model = bs.apY();
            aVar.NG = bs.aqa();
            aVar.afa = 1;
            aVar.afb = bs.getOsVersion();
            aVar.afc = bs.aql();
            aVar.language = bs.getLanguage();
            aVar.afd = bs.getLocale();
            aVar.Sk = bs.getScreenWidth(context);
            aVar.Sj = bs.getScreenHeight(context);
            aVar.afe = com.kwad.sdk.c.a.a.getStatusBarHeight(context);
            aVar.aff = com.kwad.sdk.c.a.a.a(context, 50.0f);
            return aVar;
        }
    }
}
