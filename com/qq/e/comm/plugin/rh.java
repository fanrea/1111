package com.qq.e.comm.plugin;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Build;
import android.util.Pair;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.qq.e.comm.plugin.a30;
import com.qq.e.comm.plugin.sh;
import java.io.InputStream;
import java.util.HashMap;
import org.json.JSONException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class rh extends WebViewClient {
    private static int f;
    private static int g = r1.d().f().a("wvpgit", 2);
    private static boolean h;
    private boolean a;
    private final s50 b = new s50();
    private sh c;
    private bm d;
    private jm e;

    static {
        h = r1.d().f().a("wvpgrt", 0) == 1;
    }

    @Override // android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        if (h) {
            return true;
        }
        if (Build.VERSION.SDK_INT < 26 || renderProcessGoneDetail == null || !renderProcessGoneDetail.didCrash()) {
            b10.a(9130001, null, 3, Integer.valueOf(f), null);
        } else {
            f++;
            b10.a(9130001, null, 2, Integer.valueOf(f), null);
            if (f <= g) {
                return true;
            }
        }
        return super.onRenderProcessGone(webView, renderProcessGoneDetail);
    }

    rh() {
    }

    public void a(h4 h4Var) {
        this.b.a(h4Var);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        boolean zB = this.b.b(str);
        sh shVar = this.c;
        if (shVar != null) {
            if (zB) {
                shVar.c();
            }
            this.c.d(str);
        }
        bm bmVar = this.d;
        if (bmVar != null) {
            bmVar.b(str);
        }
        return zB;
    }

    @Override // android.webkit.WebViewClient
    public void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
        super.doUpdateVisitedHistory(webView, str, z);
        this.b.a(this.e, str, z);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) throws JSONException {
        if (sslErrorHandler != null) {
            sslErrorHandler.cancel();
        }
        if (sslError == null || !zx.b()) {
            return;
        }
        ja jaVar = new ja();
        jaVar.a("sslError", sslError.toString());
        b10.b(90032, null, 0, jaVar);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        sh shVar = this.c;
        if (shVar != null) {
            shVar.a(str, bitmap);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        sh shVar = this.c;
        if (shVar != null) {
            shVar.c(str);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        sh shVar = this.c;
        if (shVar != null) {
            shVar.a(i, str, str2);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        sh shVar = this.c;
        if (shVar == null || !(shVar instanceof sh.a)) {
            return;
        }
        ((sh.a) shVar).a(webView, webResourceRequest, webResourceResponse);
    }

    public void b(boolean z) {
        this.a = z;
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        InputStream inputStream;
        Pair<? extends InputStream, a30.a> pairA = this.b.a(this.a, webResourceRequest.getUrl());
        if (pairA != null && (inputStream = (InputStream) pairA.first) != null) {
            WebResourceResponse webResourceResponse = new WebResourceResponse(((a30.a) pairA.second).b(), "UTF-8", inputStream);
            String str = webResourceRequest.getRequestHeaders().get("Origin");
            if (q50.e().c(str)) {
                HashMap map = new HashMap();
                map.put("Access-Control-Allow-Origin", str);
                webResourceResponse.setResponseHeaders(map);
            }
            return webResourceResponse;
        }
        return super.shouldInterceptRequest(webView, webResourceRequest);
    }

    public void a(boolean z) {
        this.b.a(z);
    }

    public void a(int i) {
        this.b.a(i);
    }

    public void a(bm bmVar) {
        this.d = bmVar;
    }

    public void a(jm jmVar) {
        this.e = jmVar;
    }

    public void a(sh shVar) {
        this.c = shVar;
    }
}
