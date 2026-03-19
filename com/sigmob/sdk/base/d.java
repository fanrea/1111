package com.sigmob.sdk.base;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import android.webkit.WebResourceResponse;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class d {
    static e a;

    static {
        try {
            if (o.a().ac()) {
                a = new f();
            }
        } catch (Throwable unused) {
        }
        if (a == null) {
            a = new e();
        }
    }

    public static WebResourceResponse a(Uri url) {
        return null;
    }

    static WebResourceResponse a(String url, String method, Map<String, String> map) {
        e eVar;
        if ((!URLUtil.isHttpUrl(url) && !URLUtil.isHttpsUrl(url)) || method.equals("POST") || (eVar = a) == null) {
            return null;
        }
        try {
            return eVar.a(url, method, map);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean a(String url) {
        try {
            Uri uri = Uri.parse(url);
            String host = uri.getHost();
            String lastPathSegment = uri.getLastPathSegment();
            if (host == null || l.a(url) || !uri.getScheme().startsWith(com.alipay.sdk.m.l.a.r) || host.equals("localhost") || host.equals("127.0.0.1") || !TextUtils.isEmpty(uri.getQueryParameter("no-cache"))) {
                return true;
            }
            if (lastPathSegment.endsWith(".js")) {
                return false;
            }
            return !lastPathSegment.endsWith(".css");
        } catch (Throwable unused) {
            return false;
        }
    }
}
