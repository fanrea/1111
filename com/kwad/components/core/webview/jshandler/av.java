package com.kwad.components.core.webview.jshandler;

import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class av implements com.kwad.sdk.core.webview.c.a {
    private KsAppDownloadListener adL;
    private com.kwad.sdk.core.webview.c.c aeb;
    private final com.kwad.sdk.core.webview.b gC;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;

    public static final class a extends com.kwad.sdk.core.response.a.a {
        public double afL;
        public double afM;
        public long soFarBytes;
        public int status;
        public long totalBytes;
    }

    public static final class b extends com.kwad.sdk.core.response.a.a {
        public long afT;
        public String appName;
        public String icon;
        public String md5;
        public String pkgName;
        public String uM;
        public String url;
        public String version;
        public int versionCode;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "registerApkStatusListener";
    }

    public av(com.kwad.sdk.core.webview.b bVar) {
        this.gC = bVar;
        try {
            this.mAdTemplate = new AdTemplate();
            AdTemplate adTemplate = bVar.getAdTemplate();
            if (adTemplate != null) {
                if (adTemplate.mOriginJString != null) {
                    this.mAdTemplate.parseJson(new JSONObject(adTemplate.mOriginJString));
                } else {
                    this.mAdTemplate.parseJson(adTemplate.toJson());
                }
            }
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate == null) {
            cVar.onError(-1, "native photo is null");
            return;
        }
        if (com.kwad.sdk.core.response.b.a.aJ(com.kwad.sdk.core.response.b.e.eP(adTemplate))) {
            if (this.mApkDownloadHelper == null) {
                this.mApkDownloadHelper = new com.kwad.components.core.e.d.c(this.mAdTemplate);
            }
            this.mApkDownloadHelper.aM(2);
        } else {
            AdInfo adInfoEP = com.kwad.sdk.core.response.b.e.eP(this.mAdTemplate);
            b bVar = new b();
            try {
                bVar.parseJson(new JSONObject(str));
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.printStackTrace(e);
            }
            a(adInfoEP, bVar);
            if (this.mApkDownloadHelper == null) {
                this.mApkDownloadHelper = new com.kwad.components.core.e.d.c(this.mAdTemplate);
            }
            this.mApkDownloadHelper.aM(1);
        }
        this.aeb = cVar;
        KsAppDownloadListener ksAppDownloadListener = this.adL;
        if (ksAppDownloadListener == null) {
            KsAppDownloadListener ksAppDownloadListenerUX = uX();
            this.adL = ksAppDownloadListenerUX;
            this.mApkDownloadHelper.b(ksAppDownloadListenerUX);
            return;
        }
        this.mApkDownloadHelper.d(ksAppDownloadListener);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        KsAppDownloadListener ksAppDownloadListener;
        this.aeb = null;
        com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
        if (cVar == null || (ksAppDownloadListener = this.adL) == null) {
            return;
        }
        cVar.c(ksAppDownloadListener);
        this.adL = null;
    }

    private static void a(AdInfo adInfo, b bVar) {
        adInfo.adBaseInfo.adOperationType = 1;
        adInfo.adBaseInfo.appPackageName = bVar.pkgName;
        adInfo.adBaseInfo.appName = bVar.appName;
        adInfo.adBaseInfo.appVersion = bVar.version;
        adInfo.adBaseInfo.packageSize = bVar.afT;
        adInfo.adBaseInfo.appIconUrl = bVar.icon;
        adInfo.adBaseInfo.appDescription = bVar.uM;
        adInfo.adConversionInfo.appDownloadUrl = bVar.url;
        adInfo.downloadId = com.kwad.sdk.utils.al.md5(adInfo.adConversionInfo.appDownloadUrl);
    }

    private KsAppDownloadListener uX() {
        return new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.core.webview.jshandler.av.1
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                av.this.a(1, 0.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i) {
                av.this.a(2, (i * 1.0f) / 100.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                av.this.a(5, 1.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                av.this.a(1, 0.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                av.this.a(6, 1.0f);
            }

            @Override // com.kwad.sdk.core.download.a.a
            public final void onPaused(int i) {
                av.this.a(3, (i * 1.0f) / 100.0f);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, float f) {
        if (this.aeb != null) {
            a aVar = new a();
            aVar.afL = f;
            aVar.status = i;
            AdTemplate adTemplate = this.mAdTemplate;
            if (adTemplate != null) {
                aVar.totalBytes = com.kwad.sdk.core.response.b.e.eP(adTemplate).totalBytes;
                aVar.soFarBytes = com.kwad.sdk.core.response.b.e.eP(this.mAdTemplate).soFarBytes;
                if (aVar.totalBytes > 0) {
                    aVar.afM = (aVar.soFarBytes * 1.0d) / aVar.totalBytes;
                } else {
                    aVar.afM = 0.0d;
                }
            }
            this.aeb.a(aVar);
        }
    }
}
