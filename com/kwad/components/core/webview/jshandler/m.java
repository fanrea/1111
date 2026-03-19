package com.kwad.components.core.webview.jshandler;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.components.core.e.d.a;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class m implements com.kwad.sdk.core.webview.c.a {
    private com.kwad.components.core.e.d.c QQ;
    private KsAppDownloadListener adL;
    private AdTemplate mAdTemplate;
    private Context mContext;
    private com.kwad.sdk.core.webview.c.c sd;

    public static class a extends com.kwad.sdk.core.response.a.a {
        public String ael;
        public String packageName;
    }

    public static class b extends com.kwad.sdk.core.response.a.a {
        public int aem;
        public int progress;
        public long soFarBytes;
        public int status;
        public long totalBytes;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "installAppForDownload";
    }

    public m(Context context, AdTemplate adTemplate) {
        this.mContext = context;
        this.mAdTemplate = adTemplate;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        this.sd = cVar;
        a aVar = new a();
        try {
            aVar.parseJson(new JSONObject(str));
            if (q(aVar.ael, aVar.packageName)) {
                cVar.onError(-1, "param is empty");
                return;
            }
            if (this.QQ == null) {
                p(aVar.ael, aVar.packageName);
            }
            a.C0469a c0469aAt = new a.C0469a(this.mContext).aq(true).ar(false).aC(this.mAdTemplate).at(false);
            if (this.QQ.s(c0469aAt)) {
                return;
            }
            this.QQ.d(this.adL);
            this.QQ.r(c0469aAt);
        } catch (Exception unused) {
            cVar.onError(-1, "data parse error");
        }
    }

    private static boolean q(String str, String str2) {
        return TextUtils.isEmpty(str) || TextUtils.isEmpty(str2);
    }

    private synchronized void p(String str, String str2) {
        this.QQ = new com.kwad.components.core.e.d.c(this.mAdTemplate, null, str, str2);
        if (this.adL == null) {
            KsAppDownloadListener ksAppDownloadListenerUX = uX();
            this.adL = ksAppDownloadListenerUX;
            this.QQ.b(ksAppDownloadListenerUX);
        }
    }

    private KsAppDownloadListener uX() {
        return new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.core.webview.jshandler.m.1
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                m.this.r(0, 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i) {
                if (i == 0) {
                    m.this.r(1, 0);
                } else {
                    m.this.r(2, i);
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                m.this.r(8, 100);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                m.this.r(0, 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                m.this.r(12, 100);
            }

            @Override // com.kwad.sdk.core.download.a.a
            public final void onPaused(int i) {
                m.this.r(4, i);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(int i, int i2) {
        if (this.sd != null) {
            b bVar = new b();
            bVar.status = i;
            bVar.progress = i2;
            AdTemplate adTemplate = this.mAdTemplate;
            if (adTemplate != null) {
                bVar.totalBytes = com.kwad.sdk.core.response.b.e.eP(adTemplate).totalBytes;
                bVar.soFarBytes = com.kwad.sdk.core.response.b.e.eP(this.mAdTemplate).soFarBytes;
                if (bVar.totalBytes > 0) {
                    bVar.aem = (int) ((bVar.soFarBytes * 100.0f) / bVar.totalBytes);
                } else {
                    bVar.aem = 0;
                }
            }
            this.sd.a(bVar);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.sd = null;
    }
}
