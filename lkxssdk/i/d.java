package lkxssdk.i;

import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.lingku.xuanshang.core.ui.webview.WebLoadErrorView;
import com.lingku.xuanshang.core.ui.webview.WebViewWrapper;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class d extends WebViewClient {
    public final /* synthetic */ WebViewWrapper a;

    public d(WebViewWrapper webViewWrapper) {
        this.a = webViewWrapper;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        lkxssdk.h0.c.b("tag", "onPageFinished url-->" + str);
        super.onPageFinished(webView, str);
        this.a.b.setVisibility(8);
        WebViewWrapper webViewWrapper = this.a;
        if (!webViewWrapper.f) {
            webViewWrapper.g = true;
            lkxssdk.j.c cVar = this.a.j;
            if (cVar != null) {
                cVar.a(true, str);
            }
            this.a.c.setVisibility(4);
            this.a.e.setVisible(8);
            return;
        }
        lkxssdk.h0.c.b("tag", "onPageFinished isError ");
        this.a.f = false;
        lkxssdk.j.c cVar2 = this.a.j;
        if (cVar2 != null) {
            cVar2.a(false, str);
        }
        this.a.c.setVisibility(0);
        WebViewWrapper webViewWrapper2 = this.a;
        WebLoadErrorView webLoadErrorView = webViewWrapper2.e;
        webLoadErrorView.a = webViewWrapper2;
        webLoadErrorView.setVisible(0);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        lkxssdk.h0.c.b("tag", "onPageStarted url-->" + str);
        super.onPageStarted(webView, str, bitmap);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        lkxssdk.h0.c.b("tag", "onReceivedError111 description-->" + str);
        super.onReceivedError(webView, i, str, str2);
        this.a.f = true;
        this.a.e.a();
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        Uri url = webResourceRequest.getUrl();
        if (url != null) {
            WebResourceResponse webResourceResponseA = WebViewWrapper.a(this.a, url.toString());
            if (webResourceResponseA != null) {
                return webResourceResponseA;
            }
        }
        return super.shouldInterceptRequest(webView, webResourceRequest);
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        WebResourceResponse webResourceResponseA = WebViewWrapper.a(this.a, str);
        return webResourceResponseA != null ? webResourceResponseA : super.shouldInterceptRequest(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        return super.shouldOverrideUrlLoading(webView, webResourceRequest);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x006e A[Catch: Exception -> 0x007f, TRY_LEAVE, TryCatch #0 {Exception -> 0x007f, blocks: (B:4:0x0023, B:7:0x0035, B:9:0x003b, B:11:0x0045, B:15:0x0056, B:17:0x0064, B:19:0x006e, B:10:0x0041, B:12:0x0049, B:14:0x0051, B:16:0x005b), top: B:38:0x0023 }] */
    @Override // android.webkit.WebViewClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean shouldOverrideUrlLoading(android.webkit.WebView r6, java.lang.String r7) throws java.net.URISyntaxException {
        /*
            r5 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "shouldOverrideUrlLoading url-->"
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r0 = r0.append(r7)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "tag"
            lkxssdk.h0.c.b(r1, r0)
            java.lang.String r0 = "http"
            boolean r0 = r7.startsWith(r0)
            java.lang.String r1 = "android.intent.action.VIEW"
            r2 = 1
            if (r0 != 0) goto L9b
            java.util.Locale r6 = java.util.Locale.getDefault()     // Catch: java.lang.Exception -> L7f
            java.lang.String r6 = r7.toLowerCase(r6)     // Catch: java.lang.Exception -> L7f
            java.lang.String r0 = "android-app://"
            boolean r0 = r6.startsWith(r0)     // Catch: java.lang.Exception -> L7f
            java.lang.String r3 = "android.intent.category.BROWSABLE"
            if (r0 == 0) goto L49
            int r6 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> L7f
            r0 = 22
            if (r6 < r0) goto L41
            r6 = 2
            android.content.Intent r6 = android.content.Intent.parseUri(r7, r6)     // Catch: java.lang.Exception -> L7f
            goto L45
        L41:
            android.content.Intent r6 = android.content.Intent.parseUri(r7, r2)     // Catch: java.lang.Exception -> L7f
        L45:
            r6.addCategory(r3)     // Catch: java.lang.Exception -> L7f
            goto L56
        L49:
            java.lang.String r0 = "intent"
            boolean r6 = r6.startsWith(r0)     // Catch: java.lang.Exception -> L7f
            if (r6 == 0) goto L5b
            android.content.Intent r6 = android.content.Intent.parseUri(r7, r2)     // Catch: java.lang.Exception -> L7f
            goto L45
        L56:
            r7 = 0
            r6.setComponent(r7)     // Catch: java.lang.Exception -> L7f
            goto L64
        L5b:
            android.content.Intent r6 = new android.content.Intent     // Catch: java.lang.Exception -> L7f
            android.net.Uri r7 = android.net.Uri.parse(r7)     // Catch: java.lang.Exception -> L7f
            r6.<init>(r1, r7)     // Catch: java.lang.Exception -> L7f
        L64:
            java.lang.String r7 = r6.getScheme()     // Catch: java.lang.Exception -> L7f
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch: java.lang.Exception -> L7f
            if (r7 != 0) goto L9a
            r7 = 268435456(0x10000000, float:2.524355E-29)
            r6.addFlags(r7)     // Catch: java.lang.Exception -> L7f
            com.lingku.xuanshang.core.ui.webview.WebViewWrapper r7 = r5.a     // Catch: java.lang.Exception -> L7f
            com.lingku.xuanshang.core.ui.base.BaseActivity r7 = r7.a     // Catch: java.lang.Exception -> L7f
            android.app.Application r7 = r7.getApplication()     // Catch: java.lang.Exception -> L7f
            r7.startActivity(r6)     // Catch: java.lang.Exception -> L7f
            goto L9a
        L7f:
            r6 = move-exception
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r0 = "shouldOverrideUrlLoading()-->"
            java.lang.StringBuilder r7 = r7.append(r0)
            java.lang.String r6 = r6.getMessage()
            java.lang.StringBuilder r6 = r7.append(r6)
            java.lang.String r6 = r6.toString()
            lkxssdk.h0.c.a(r6)
        L9a:
            return r2
        L9b:
            java.lang.String r0 = "?xsw_jump_webview"
            boolean r3 = r7.contains(r0)
            java.lang.String r4 = ""
            if (r3 == 0) goto Lc5
            java.lang.String r6 = r7.replace(r0, r4)
            android.os.Bundle r7 = new android.os.Bundle
            r7.<init>()
            java.lang.String r0 = "url"
            r7.putString(r0, r6)
            java.lang.String r6 = "showNav"
            r7.putInt(r6, r2)
            com.lingku.xuanshang.core.ui.webview.WebViewWrapper r6 = r5.a
            com.lingku.xuanshang.core.ui.base.BaseActivity r6 = r6.getAty()
            java.lang.Class<com.lingku.xuanshang.core.ui.WebActvity> r0 = com.lingku.xuanshang.core.ui.WebActvity.class
            r1 = 0
            lkxssdk.a.a.a(r6, r0, r1, r7)
            return r2
        Lc5:
            java.lang.String r0 = "?xsw_jump_outer"
            boolean r3 = r7.contains(r0)
            if (r3 == 0) goto Le7
            java.lang.String r6 = r7.replace(r0, r4)
            android.content.Intent r7 = new android.content.Intent     // Catch: java.lang.Exception -> Le2
            android.net.Uri r6 = android.net.Uri.parse(r6)     // Catch: java.lang.Exception -> Le2
            r7.<init>(r1, r6)     // Catch: java.lang.Exception -> Le2
            com.lingku.xuanshang.core.ui.webview.WebViewWrapper r6 = r5.a     // Catch: java.lang.Exception -> Le2
            com.lingku.xuanshang.core.ui.base.BaseActivity r6 = r6.a     // Catch: java.lang.Exception -> Le2
            r6.startActivity(r7)     // Catch: java.lang.Exception -> Le2
            goto Le6
        Le2:
            r6 = move-exception
            r6.printStackTrace()
        Le6:
            return r2
        Le7:
            boolean r6 = super.shouldOverrideUrlLoading(r6, r7)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: lkxssdk.i.d.shouldOverrideUrlLoading(android.webkit.WebView, java.lang.String):boolean");
    }
}
