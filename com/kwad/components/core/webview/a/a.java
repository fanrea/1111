package com.kwad.components.core.webview.a;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.kwad.components.core.e.d.a;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.bx;
import com.kwad.sdk.utils.cd;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a {
    private com.kwad.components.core.e.d.c QQ;
    private WebView UO;
    private KsAppDownloadListener adL;
    private int adM = -100;
    private int adN = 0;
    private boolean adz;
    private com.kwad.sdk.core.webview.b gC;
    private AdTemplate mAdTemplate;

    /* renamed from: com.kwad.components.core.webview.a.a$a, reason: collision with other inner class name */
    public static final class C0489a extends com.kwad.sdk.core.response.a.a {
        public String packageName;
        public String url;
    }

    public static final class b extends com.kwad.sdk.core.response.a.a {
        public int progress;
        public int status;
    }

    public a(WebView webView, com.kwad.sdk.core.webview.b bVar) {
        this.UO = webView;
        this.mAdTemplate = bVar.getAdTemplate();
        this.gC = bVar;
    }

    private synchronized void p(String str, String str2) {
        this.QQ = new com.kwad.components.core.e.d.c(this.mAdTemplate, null, str, str2);
        if (this.adL == null) {
            KsAppDownloadListener ksAppDownloadListenerUX = uX();
            this.adL = ksAppDownloadListenerUX;
            this.QQ.b(ksAppDownloadListenerUX);
        }
    }

    @JavascriptInterface
    public final int getDownLoadStatus(String str, String str2) {
        if (q(str, str2)) {
            return 0;
        }
        if (this.QQ == null) {
            p(str, str2);
        }
        return this.QQ.pK();
    }

    @JavascriptInterface
    public final int getProgress(String str, String str2) {
        if (q(str, str2)) {
            return 0;
        }
        if (this.QQ == null) {
            p(str, str2);
        }
        return this.adN;
    }

    @JavascriptInterface
    public final void handleAdClick(final String str) {
        bx.runOnUiThread(new bh() { // from class: com.kwad.components.core.webview.a.a.1
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                a.this.aY(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aY(String str) {
        try {
            C0489a c0489a = new C0489a();
            c0489a.parseJson(new JSONObject(str));
            if (q(c0489a.url, c0489a.packageName)) {
                return;
            }
            if (this.QQ == null) {
                p(c0489a.url, c0489a.packageName);
            }
            a.C0469a c0469aAt = new a.C0469a(this.gC.UO.getContext()).aq(true).ar(false).aC(this.mAdTemplate).at(false);
            if (this.QQ.s(c0469aAt)) {
                return;
            }
            this.QQ.d(this.adL);
            this.QQ.r(c0469aAt);
        } catch (JSONException e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
    }

    private static boolean q(String str, String str2) {
        return TextUtils.isEmpty(str) || TextUtils.isEmpty(str2);
    }

    private KsAppDownloadListener uX() {
        return new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.core.webview.a.a.2
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                a.this.r(0, 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i) {
                if (i == 0) {
                    a.this.r(1, 0);
                } else {
                    a.this.r(2, i);
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                a.this.r(8, 100);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                a.this.r(0, 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                a.this.r(12, 100);
            }

            @Override // com.kwad.sdk.core.download.a.a
            public final void onPaused(int i) {
                a.this.r(4, i);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(int i, int i2) {
        this.adN = i2;
        if (this.adM != i) {
            this.adM = i;
            o("onDownLoadStatusCallback", new StringBuilder().append(i).toString());
        }
    }

    private void o(String str, String str2) {
        WebView webView;
        if (this.adz || TextUtils.isEmpty(str) || (webView = this.UO) == null) {
            return;
        }
        cd.a(webView, str, str2);
    }

    public final void destroy() {
        this.adz = true;
        com.kwad.components.core.e.d.c cVar = this.QQ;
        if (cVar != null) {
            cVar.c(this.adL);
        }
    }
}
