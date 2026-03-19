package com.kwad.sdk.core.webview;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.accessibility.AccessibilityManager;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.kwad.sdk.core.webview.a.c;
import com.kwad.sdk.p.m;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ca;
import com.kwad.sdk.utils.cc;
import com.kwad.sdk.utils.z;
import com.sigmob.sdk.base.mta.PointCategory;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class KsAdWebView extends KSApiWebView {
    private long If;
    private c.a Oa;
    private com.kwad.sdk.core.webview.a.c bLB;
    private String bLC;
    private com.kwad.sdk.core.webview.c bLD;
    private String mUniqueId;

    public interface b {
        void onFailed();

        void onSuccess();
    }

    public interface c {
        void rB();
    }

    public interface d {
        boolean shouldOverrideUrlLoading(WebView webView, String str);
    }

    public interface e {
        void onPageFinished();

        void onPageStart();

        void onReceivedHttpError(int i, String str, String str2);
    }

    public KsAdWebView(Context context) {
        super(context);
        init(context);
    }

    public KsAdWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public KsAdWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    public KsAdWebView(Context context, AttributeSet attributeSet, int i, boolean z) {
        super(context, attributeSet, i, z);
        init(context);
    }

    public void setClientConfig(c.a aVar) {
        this.bLB.setClientConfig(aVar);
        c.a aVar2 = this.Oa;
        if (aVar2 == null || !aVar2.adD()) {
            return;
        }
        this.bLD = new com.kwad.sdk.core.webview.c();
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        c.a aVar;
        if (motionEvent.getAction() == 1 && (aVar = this.Oa) != null) {
            aVar.bl(System.currentTimeMillis());
        }
        return super.onTouchEvent(motionEvent);
    }

    public String getUniqueId() {
        return this.mUniqueId;
    }

    public String getLoadUrl() {
        return this.bLC;
    }

    public long getLoadTime() {
        return this.If;
    }

    public c.a getClientConfig() {
        return this.Oa;
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        a(getContext(), getSettings());
        com.kwad.sdk.core.webview.b.c.b.gx(this.mUniqueId);
        this.bLC = str;
        this.If = System.currentTimeMillis();
        super.loadUrl(str);
    }

    private void init(Context context) {
        com.kwad.sdk.core.d.c.i("KsAdWebView", PointCategory.INIT);
        setAccessibilityStateDisable(context);
        WebSettings webSettingsA = cc.a(this);
        webSettingsA.setUseWideViewPort(true);
        webSettingsA.setDomStorageEnabled(true);
        setVerticalScrollBarEnabled(false);
        com.kwad.sdk.core.webview.a.c cVar = new com.kwad.sdk.core.webview.a.c() { // from class: com.kwad.sdk.core.webview.KsAdWebView.1
            @Override // com.kwad.sdk.core.webview.a.c, android.webkit.WebViewClient
            public final void onReceivedError(WebView webView, int i, String str, String str2) {
                super.onReceivedError(webView, i, str, str2);
                if (KsAdWebView.this.bLD != null) {
                    com.kwad.sdk.core.webview.c unused = KsAdWebView.this.bLD;
                    com.kwad.sdk.core.webview.c.d(KsAdWebView.this.Oa);
                }
            }

            @Override // com.kwad.sdk.core.webview.a.c, android.webkit.WebViewClient
            public final void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                if (KsAdWebView.this.bLD != null) {
                    KsAdWebView.this.bLD.c(KsAdWebView.this.Oa);
                }
            }
        };
        this.bLB = cVar;
        cVar.T(this.mUniqueId);
        setWebViewClient(this.bLB);
        setWebChromeClient(new com.kwad.sdk.core.webview.a.b());
        setDownloadListener(new a(this, (byte) 0));
        this.Oa = new c.a(getContext());
    }

    private void a(Context context, WebSettings webSettings) {
        boolean zAdG;
        String userAgentString = webSettings.getUserAgentString();
        c.a aVar = this.Oa;
        boolean zAdF = false;
        if (aVar != null) {
            zAdF = aVar.adF();
            zAdG = this.Oa.adG();
        } else {
            zAdG = false;
        }
        com.kwad.sdk.core.i.c cVarR = com.kwad.sdk.core.i.a.r(zAdF, zAdG);
        com.kwad.sdk.core.d.c.d("KsAdWebView", "setWebViewUserAgent: uaGetter：" + cVarR);
        String str = userAgentString + cVarR.bZ(context);
        com.kwad.sdk.core.d.c.d("KsAdWebView", "setWebViewUserAgent: " + str);
        webSettings.setUserAgentString(str);
    }

    private void setAccessibilityStateDisable(Context context) {
        if (Build.VERSION.SDK_INT != 17 || context == null) {
            return;
        }
        try {
            AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
            if (accessibilityManager != null && accessibilityManager.isEnabled()) {
                z.callMethod(accessibilityManager, "setState", 0);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.webkit.WebView
    public void setWebViewClient(WebViewClient webViewClient) {
        if (com.kwad.framework.a.a.qr.booleanValue() && !(webViewClient instanceof com.kwad.sdk.core.webview.a.a)) {
            throw new IllegalArgumentException("Not supported set webViewClient, please check it");
        }
        super.setWebViewClient(webViewClient);
    }

    @Override // android.webkit.WebView
    public void setWebChromeClient(WebChromeClient webChromeClient) {
        if (com.kwad.framework.a.a.qr.booleanValue() && !(webChromeClient instanceof com.kwad.sdk.core.webview.a.b)) {
            throw new IllegalArgumentException("client is not instanceof KSWebChromeClient");
        }
        super.setWebChromeClient(webChromeClient);
    }

    @Override // com.kwad.sdk.core.webview.KSApiWebView, android.webkit.WebView
    public void destroy() {
        super.destroy();
        c.a aVar = this.Oa;
        if (aVar != null) {
            aVar.release();
            this.Oa = null;
        }
        com.kwad.sdk.core.webview.a.c cVar = this.bLB;
        if (cVar != null) {
            cVar.destroy();
            this.bLB = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c.a getReadyClientConfig() {
        com.kwad.sdk.core.webview.a.c cVar = this.bLB;
        if (cVar == null || cVar.getClientConfig() == null) {
            return null;
        }
        return this.bLB.getClientConfig();
    }

    public final void onActivityCreate() {
        com.kwad.sdk.core.webview.c cVar = this.bLD;
        if (cVar != null) {
            cVar.a(this.Oa);
        }
    }

    public final void onActivityDestroy() {
        release();
        com.kwad.sdk.core.webview.c cVar = this.bLD;
        if (cVar != null) {
            cVar.b(this.Oa);
        }
    }

    class a implements DownloadListener {
        private a() {
        }

        /* synthetic */ a(KsAdWebView ksAdWebView, byte b) {
            this();
        }

        @Override // android.webkit.DownloadListener
        public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            boolean zV = ca.v(KsAdWebView.this, 100);
            com.kwad.sdk.core.d.c.d("KsAdWebView", "onDownloadStart: currentVisible " + zV);
            if (zV) {
                if (KsAdWebView.this.Oa == null || KsAdWebView.this.Oa.adE()) {
                    if (KsAdWebView.this.Oa != null && KsAdWebView.this.Oa.getAdTemplate() != null && KsAdWebView.this.Oa.adC()) {
                        com.kwad.sdk.core.response.b.e.eP(KsAdWebView.this.Oa.getAdTemplate()).adConversionInfo.appDownloadUrl = str;
                        KsAdWebView.this.Oa.getAdTemplate().isWebViewDownload = true;
                        c.a readyClientConfig = KsAdWebView.this.getReadyClientConfig();
                        if (readyClientConfig != null) {
                            readyClientConfig.fj(KsAdWebView.this.Oa.getAdTemplate());
                        }
                        ((com.kwad.sdk.service.a.a) ServiceProvider.get(com.kwad.sdk.service.a.a.class)).h(m.wrapContextIfNeed(KsAdWebView.this.getContext()), KsAdWebView.this.Oa.getAdTemplate());
                        return;
                    }
                    try {
                        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                        intent.setFlags(268435456);
                        KsAdWebView.this.getContext().startActivity(intent);
                    } catch (Exception e) {
                        com.kwad.sdk.core.d.c.printStackTrace(e);
                    }
                }
            }
        }
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        c.a aVar = this.Oa;
        if (aVar == null || aVar.rA() == null) {
            return;
        }
        this.Oa.rA().rB();
    }
}
