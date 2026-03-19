package com.sigmob.sdk.base;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.webkit.CookieSyncManager;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.czhj.sdk.common.utils.FileUtil;
import com.czhj.sdk.logger.SigmobLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.CookieManager;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class l extends WebViewClient {
    static final String a = "Set-Cookie";
    static final String b = "Referer";
    private static final String c = "mraid.js";
    private static final String d = "mraid2.js";
    private boolean e = false;
    private boolean f = false;
    private String g;

    public static WebResourceResponse a(Uri url) {
        String scheme;
        if (url != null && (scheme = url.getScheme()) != null && scheme.startsWith(n.z)) {
            String path = url.getPath();
            if (com.sigmob.sdk.base.utils.m.a((CharSequence) path)) {
                return null;
            }
            try {
                File file = new File(path);
                if (file.exists()) {
                    return new WebResourceResponse("text/html", "utf-8", new FileInputStream(file));
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return null;
    }

    private static File a(WebResourceResponse webResourceResponse, String url) {
        String lastPathSegment;
        try {
            Uri uri = Uri.parse(url);
            if (d.a(url) || (lastPathSegment = uri.getLastPathSegment()) == null) {
                return null;
            }
            File file = new File(com.sigmob.sdk.base.utils.i.c(), lastPathSegment);
            FileUtil.writeToCache(webResourceResponse.getData(), file.getAbsolutePath());
            return file;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void a(HttpURLConnection conn, CookieManager cookieManager) {
        if (cookieManager == null || conn == null) {
            return;
        }
        Map<String, List<String>> headerFields = conn.getHeaderFields();
        SigmobLog.d("headerFields : " + headerFields.toString());
        List<String> list = headerFields.get(a);
        if (list == null) {
            return;
        }
        for (String str : list) {
            try {
                List<HttpCookie> list2 = HttpCookie.parse(str);
                if (!com.sigmob.sdk.base.utils.e.a(list2)) {
                    SigmobLog.d("{0} -- Reading Cookies from the response :" + conn.getURL().toString());
                    SigmobLog.d("{0} -- Reading Cookies from the response :" + list2.get(0));
                    for (HttpCookie httpCookie : list2) {
                        SigmobLog.d(httpCookie.toString());
                        android.webkit.CookieManager.getInstance().setCookie(conn.getURL().toString(), httpCookie.getName() + "=" + httpCookie.getValue());
                    }
                }
            } catch (NullPointerException unused) {
                SigmobLog.e(MessageFormat.format("{0} -- Null header for the cookie : {1}", conn.getURL().toString(), str));
            }
        }
        if (Build.VERSION.SDK_INT >= 21) {
            android.webkit.CookieManager.getInstance().flush();
        } else {
            CookieSyncManager.getInstance().sync();
        }
    }

    protected static boolean a(final String url) {
        Uri uri = Uri.parse(url.toLowerCase(Locale.US));
        return c.equals(uri.getLastPathSegment()) || d.equals(uri.getLastPathSegment());
    }

    private WebResourceResponse c(String url) {
        Uri uri;
        String host;
        String lastPathSegment;
        try {
            uri = Uri.parse(url);
            host = uri.getHost();
            lastPathSegment = uri.getLastPathSegment();
        } catch (Throwable th) {
            SigmobLog.e("useWebResourceCache ", th);
        }
        if (host != null && !a(url) && uri.getScheme().startsWith(com.alipay.sdk.m.l.a.r) && !host.equals("127.0.0.1") && com.sigmob.sdk.base.utils.m.a((CharSequence) uri.getQueryParameter("no-cache")) && (lastPathSegment.endsWith(".js") || lastPathSegment.endsWith(".css"))) {
            File file = new File(com.sigmob.sdk.base.utils.i.c(), lastPathSegment);
            String str = lastPathSegment.endsWith(".js") ? "text/javascript" : lastPathSegment.endsWith(".css") ? "text/css" : null;
            if (file.exists()) {
                WebResourceResponse webResourceResponse = new WebResourceResponse(str, "UTF-8", new FileInputStream(file));
                HashMap map = new HashMap();
                map.put("Cache-Control", "no-store");
                if (Build.VERSION.SDK_INT >= 21) {
                    webResourceResponse.setResponseHeaders(map);
                }
                return webResourceResponse;
            }
            return null;
        }
        return null;
    }

    public void a(boolean useCache) {
        this.f = useCache;
    }

    public void b(String url) {
        try {
            Uri uri = Uri.parse(url);
            this.g = uri.getScheme() + "://" + uri.getHost() + "/" + uri.getPath();
        } catch (Throwable unused) {
        }
    }

    public void b(boolean isDisable) {
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
        super.onReceivedError(view, errorCode, description, failingUrl);
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
        WebResourceResponse webResourceResponseA;
        File fileA;
        try {
            webResourceResponseA = a(request.getUrl());
            if (webResourceResponseA != null) {
                return webResourceResponseA;
            }
        } catch (Throwable unused) {
            webResourceResponseA = null;
        }
        if (this.f && (webResourceResponseA = c(request.getUrl().toString())) != null) {
            return webResourceResponseA;
        }
        if ((this.e || (this.f && !d.a(request.getUrl().toString()))) && !a(request.getUrl().toString())) {
            webResourceResponseA = d.a(request.getUrl().toString(), request.getMethod(), request.getRequestHeaders());
        }
        if (webResourceResponseA == null) {
            webResourceResponseA = super.shouldInterceptRequest(view, request);
        }
        if (this.f && webResourceResponseA != null && (fileA = a(webResourceResponseA, request.getUrl().toString())) != null && fileA.exists()) {
            try {
                return new WebResourceResponse(webResourceResponseA.getMimeType(), webResourceResponseA.getEncoding(), new FileInputStream(fileA));
            } catch (FileNotFoundException unused2) {
            }
        }
        return webResourceResponseA;
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView view, String url) {
        WebResourceResponse webResourceResponseA;
        File fileA;
        try {
            webResourceResponseA = a(Uri.parse(url));
            if (webResourceResponseA != null) {
                return webResourceResponseA;
            }
        } catch (Throwable unused) {
            webResourceResponseA = null;
        }
        if (this.f && (webResourceResponseA = c(url)) != null) {
            return webResourceResponseA;
        }
        if ((this.e || (this.f && !d.a(url))) && !a(url)) {
            webResourceResponseA = d.a(url, "GET", null);
        }
        if (webResourceResponseA == null) {
            webResourceResponseA = super.shouldInterceptRequest(view, url);
        }
        if (this.f && webResourceResponseA != null && (fileA = a(webResourceResponseA, url)) != null && fileA.exists()) {
            try {
                return new WebResourceResponse(webResourceResponseA.getMimeType(), webResourceResponseA.getEncoding(), new FileInputStream(fileA));
            } catch (FileNotFoundException unused2) {
            }
        }
        return webResourceResponseA;
    }
}
