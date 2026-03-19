package com.kwad.sdk.core.webview.a;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import com.just.agentweb.DefaultWebClient;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.KsAdWebView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class c extends com.kwad.sdk.core.webview.a.a {
    private a Oa;

    public final void T(String str) {
        this.mUniqueId = str;
    }

    @Override // android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        return (Build.VERSION.SDK_INT >= 26 && renderProcessGoneDetail != null && renderProcessGoneDetail.didCrash()) || super.onRenderProcessGone(webView, renderProcessGoneDetail);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        com.kwad.sdk.core.d.c.d("KsAdWebViewClient", "onReceivedError " + i);
        a aVar = this.Oa;
        if (aVar != null && aVar.jy() != null) {
            this.Oa.jy().onReceivedHttpError(i, str, str2);
        }
        com.kwad.sdk.core.webview.b.c.b.an(str2, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        com.kwad.sdk.core.webview.b.c.b.al(this.mUniqueId, "onPageStart");
        a aVar = this.Oa;
        if (aVar == null || aVar.jy() == null) {
            return;
        }
        this.Oa.jy().onPageStart();
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        com.kwad.sdk.core.webview.b.c.b.al(this.mUniqueId, "onPageFinished");
        a aVar = this.Oa;
        if (aVar == null || aVar.jy() == null) {
            return;
        }
        this.Oa.jy().onPageFinished();
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        com.kwad.sdk.core.d.c.w("KsAdWebViewClient", "shouldOverrideUrlLoading url=" + str);
        com.kwad.sdk.core.webview.b.c.b.al(this.mUniqueId, "shouldOverrideUrlLoading");
        a aVar = this.Oa;
        if (aVar == null || !aVar.adE() || ((this.Oa.ady() != null && this.Oa.ady().shouldOverrideUrlLoading(webView, str)) || gl(str))) {
            return true;
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }

    private boolean gl(String str) {
        try {
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
        if (!str.startsWith(com.alipay.sdk.m.l.a.r) && !str.startsWith("https")) {
            if (!str.startsWith("tel:") && !str.startsWith(DefaultWebClient.SCHEME_SMS)) {
                a aVar = this.Oa;
                if (aVar != null) {
                    if (aVar.adA()) {
                        a(this.Oa, str);
                        return true;
                    }
                    if (gm(str)) {
                        return true;
                    }
                }
                return false;
            }
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            a aVar2 = this.Oa;
            if (aVar2 != null) {
                aVar2.getContext().startActivity(intent);
            }
            return true;
        }
        return false;
    }

    public static int a(a aVar, String str) {
        int iQ = com.kwad.sdk.core.download.a.b.Q(aVar.getContext(), str);
        if (iQ == 1) {
            if (aVar.nO() != null) {
                aVar.nO().onSuccess();
            }
            com.kwad.sdk.core.adlog.c.a(aVar.getAdTemplate(), "", 2, (com.kwad.sdk.core.adlog.c.a) null);
        } else {
            if (aVar.nO() != null) {
                aVar.nO().onFailed();
            }
            if (iQ == -1) {
                com.kwad.sdk.core.adlog.c.b(aVar.getAdTemplate(), "", 2, (com.kwad.sdk.core.adlog.c.a) null);
            }
        }
        return iQ;
    }

    private static boolean gm(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("hwfastapp://") || str.startsWith("hap://app") || str.startsWith("intent://hapjs.org/") || str.startsWith(DefaultWebClient.INTENT_SCHEME);
    }

    public final void setClientConfig(a aVar) {
        this.Oa = aVar;
        setNeedHybridLoad(aVar.adB());
    }

    public final a getClientConfig() {
        return this.Oa;
    }

    public final void destroy() {
        a aVar = this.Oa;
        if (aVar != null) {
            aVar.release();
            this.Oa = null;
        }
    }

    public static class a {
        private int Vc;
        private KsAdWebView.c Vz;
        private KsAdWebView.b ahR;
        private KsAdWebView.e bLI;
        private KsAdWebView.d bLJ;
        private boolean bLK;
        private boolean bLN;
        private AdTemplate mAdTemplate;
        private Context mContext;
        private boolean bLL = true;
        private boolean bLM = true;
        private boolean bLH = true;
        private boolean bLO = false;
        private long bLP = 600;
        private long bLQ = 0;

        public a(Context context) {
            this.mContext = context;
        }

        public final void release() {
            this.ahR = null;
            this.bLJ = null;
            this.Vz = null;
            this.bLI = null;
            this.mContext = null;
            this.mAdTemplate = null;
        }

        public final a fj(AdTemplate adTemplate) {
            this.mAdTemplate = adTemplate;
            return this;
        }

        public final AdTemplate getAdTemplate() {
            return this.mAdTemplate;
        }

        public final Context getContext() {
            return this.mContext;
        }

        public final KsAdWebView.e jy() {
            return this.bLI;
        }

        public final KsAdWebView.d ady() {
            return this.bLJ;
        }

        public final a b(KsAdWebView.e eVar) {
            this.bLI = eVar;
            return this;
        }

        public final a a(KsAdWebView.d dVar) {
            this.bLJ = dVar;
            return this;
        }

        public final KsAdWebView.b nO() {
            return this.ahR;
        }

        public final a a(KsAdWebView.b bVar) {
            this.ahR = bVar;
            return this;
        }

        private boolean adz() {
            return this.bLO;
        }

        public final a cG(boolean z) {
            this.bLO = true;
            return this;
        }

        public final com.kwad.sdk.core.adlog.c.a pz() {
            return com.kwad.sdk.core.adlog.c.a.Xs().eN(this.Vc).eO(this.bLK ? 1 : 0);
        }

        public final a cH(boolean z) {
            this.bLK = true;
            return this;
        }

        public final a fO(int i) {
            this.Vc = i;
            return this;
        }

        public final boolean adA() {
            return this.bLM;
        }

        public final a cI(boolean z) {
            this.bLM = z;
            return this;
        }

        public final boolean adB() {
            return this.bLH;
        }

        public final boolean adC() {
            return this.bLL;
        }

        public final a cJ(boolean z) {
            this.bLL = z;
            return this;
        }

        public final KsAdWebView.c rA() {
            return this.Vz;
        }

        public final a c(KsAdWebView.c cVar) {
            this.Vz = cVar;
            return this;
        }

        public final boolean adD() {
            return this.bLN;
        }

        public final a cK(boolean z) {
            this.bLN = true;
            return this;
        }

        public final void bl(long j) {
            this.bLQ = j;
        }

        public final boolean adE() {
            if (!adz()) {
                return true;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j = this.bLQ;
            return j > 0 && jCurrentTimeMillis - j <= this.bLP;
        }

        public final boolean adF() {
            AdTemplate adTemplate = this.mAdTemplate;
            if (adTemplate == null) {
                return false;
            }
            return com.kwad.sdk.core.response.b.a.dK(e.eP(adTemplate));
        }

        public final boolean adG() {
            AdTemplate adTemplate = this.mAdTemplate;
            if (adTemplate == null) {
                return false;
            }
            return com.kwad.sdk.core.response.b.a.dL(e.eP(adTemplate));
        }
    }
}
