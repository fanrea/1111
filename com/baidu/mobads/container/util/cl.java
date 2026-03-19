package com.baidu.mobads.container.util;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import com.baidu.mobads.container.components.g.i;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class cl {
    public static final String a = "com.baidu.searchbox";

    public static boolean a(Context context) throws PackageManager.NameNotFoundException {
        try {
            context.getApplicationContext().getPackageManager().getApplicationInfo("com.baidu.searchbox", 0);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        } catch (Exception e2) {
            return false;
        }
    }

    public static boolean a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (!str.contains("l_f_b")) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    public static WebResourceResponse a(Context context, WebResourceRequest webResourceRequest) {
        Uri url;
        try {
            if (x.a(context).a() < 21 || (url = webResourceRequest.getUrl()) == null || !url.toString().startsWith(com.alipay.sdk.m.l.a.r) || url.getHost().contains(".baidu.") || !webResourceRequest.getMethod().equals("GET")) {
                return null;
            }
            String string = webResourceRequest.getUrl().toString();
            String strN = o.n(string);
            String str = webResourceRequest.getRequestHeaders().get("Accept");
            if (!strN.startsWith("image") && !str.startsWith("image/")) {
                return null;
            }
            com.baidu.mobads.container.components.g.k kVarB = com.baidu.mobads.container.components.g.e.a().a(new i.a().a(string).a().b()).b();
            return new WebResourceResponse(b(kVarB.g()), c(kVarB.g()), kVarB.f());
        } catch (Throwable th) {
            return null;
        }
    }

    public static String b(String str) {
        if (str == null) {
            return null;
        }
        if (!str.contains(com.alipay.sdk.m.u.i.b)) {
            return str;
        }
        String[] strArrSplit = str.split(com.alipay.sdk.m.u.i.b);
        if (strArrSplit.length <= 1) {
            return str;
        }
        return strArrSplit[0];
    }

    public static String c(String str) {
        if (str == null) {
            return null;
        }
        String[] strArrSplit = str.split(com.alipay.sdk.m.u.i.b);
        if (strArrSplit.length <= 1) {
            return null;
        }
        String str2 = strArrSplit[1];
        if (!str2.contains("=")) {
            return null;
        }
        return str2.substring(str2.indexOf("=") + 1);
    }
}
