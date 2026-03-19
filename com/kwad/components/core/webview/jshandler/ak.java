package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import com.kwad.components.core.e.d.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class ak implements com.kwad.sdk.core.webview.c.a {
    private final Handler aeI = new Handler(Looper.getMainLooper());
    private final com.kwad.sdk.core.webview.b aen;
    private final AdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;

    public static final class a extends com.kwad.sdk.core.response.a.a {
        public int afi;
        public String afj;
        public String afk;

        @Deprecated
        public boolean afl;
        public boolean afm;
        public boolean afn;
        public String appId;
        public String appName;
        public String icon;
        public String md5;
        public String pkgName;
        public int type;
        public String uM;
        public String url;
        public String version;
        public int versionCode;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "handleAdUrl";
    }

    public ak(com.kwad.sdk.core.webview.b bVar) {
        this.aen = bVar;
        AdTemplate adTemplate = new AdTemplate();
        this.mAdTemplate = adTemplate;
        try {
            AdTemplate adTemplate2 = bVar.getAdTemplate();
            if (adTemplate2 != null) {
                if (adTemplate2.mOriginJString != null) {
                    adTemplate.parseJson(new JSONObject(adTemplate2.mOriginJString));
                } else {
                    adTemplate.parseJson(adTemplate2.toJson());
                }
            }
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        if (com.kwad.sdk.core.response.b.a.aJ(com.kwad.sdk.core.response.b.e.eP(this.mAdTemplate))) {
            if (this.mApkDownloadHelper == null) {
                this.mApkDownloadHelper = new com.kwad.components.core.e.d.c(this.mAdTemplate);
            }
            this.mApkDownloadHelper.aM(2);
        } else {
            AdInfo adInfoEP = com.kwad.sdk.core.response.b.e.eP(this.mAdTemplate);
            a aVar = new a();
            try {
                aVar.parseJson(new JSONObject(str));
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.printStackTrace(e);
            }
            a(adInfoEP, aVar);
            if (this.mApkDownloadHelper == null) {
                this.mApkDownloadHelper = new com.kwad.components.core.e.d.c(this.mAdTemplate);
            }
            this.mApkDownloadHelper.aM(1);
        }
        this.aeI.post(new com.kwad.sdk.utils.bh() { // from class: com.kwad.components.core.webview.jshandler.ak.1
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                com.kwad.components.core.e.d.a.a(new a.C0469a(ak.this.aen.Vu.getContext()).aC(ak.this.mAdTemplate).b(ak.this.mApkDownloadHelper).a(new a.b() { // from class: com.kwad.components.core.webview.jshandler.ak.1.1
                    @Override // com.kwad.components.core.e.d.a.b
                    public final void onAdClicked() {
                    }
                }));
            }
        });
        cVar.a(null);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.aeI.removeCallbacksAndMessages(null);
    }

    private static void a(AdInfo adInfo, a aVar) {
        AdInfo.AdConversionInfo adConversionInfo = adInfo.adConversionInfo;
        adConversionInfo.deeplinkUrl = aVar.afj;
        adConversionInfo.marketUrl = aVar.afk;
        adInfo.adBaseInfo.adOperationType = aVar.type;
        adInfo.adBaseInfo.appPackageName = aVar.pkgName;
        adInfo.adBaseInfo.appName = aVar.appName;
        adInfo.adBaseInfo.appVersion = aVar.version;
        adInfo.adBaseInfo.packageSize = aVar.afi;
        adInfo.adBaseInfo.appIconUrl = aVar.icon;
        adInfo.adBaseInfo.appDescription = aVar.uM;
        if (com.kwad.sdk.core.response.b.a.aJ(adInfo)) {
            adInfo.adConversionInfo.appDownloadUrl = aVar.url;
            adInfo.downloadId = com.kwad.sdk.utils.al.md5(adInfo.adConversionInfo.appDownloadUrl);
        } else {
            adInfo.adConversionInfo.h5Url = aVar.url;
        }
    }
}
