package com.baidu.mobads.container.util;

import android.content.Context;
import android.net.Uri;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class l {
    private static final String a = "https://mobads-logs.baidu.com/brwhis.log";

    public static void a(Context context, String str, String str2, HashMap<String, String> map) {
        com.baidu.mobads.container.d.b.a().a(new m(context, str, str2, map));
    }

    private static String a(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Context context, String str, String str2, HashMap<String, String> map) {
        Uri.Builder builder = new Uri.Builder();
        try {
            builder.appendQueryParameter("type", "404").appendQueryParameter("subtype", str2).appendQueryParameter("p_ver", com.baidu.mobads.container.config.b.a().j()).appendQueryParameter("appsid", DeviceUtils.getInstance().l(context)).appendQueryParameter("v", "android_9.40_4.1.30").appendQueryParameter("pack", context != null ? context.getPackageName() : "").appendQueryParameter("sn", DeviceUtils.getInstance().f(context)).appendQueryParameter("cuid", DeviceUtils.getInstance().c(context)).appendQueryParameter("os", "android").appendQueryParameter("osv", x.a(context).c()).appendQueryParameter(com.baidu.mobads.container.adrequest.g.aj, DeviceUtils.getInstance().d()).appendQueryParameter(com.baidu.mobads.container.adrequest.g.ak, DeviceUtils.getInstance().e()).appendQueryParameter("bdr", "" + x.a(context).a()).appendQueryParameter(com.baidu.mobads.container.adrequest.g.T, "" + a(x.a(context).e()));
            if (str != null && str.length() > 128) {
                int iIndexOf = str.indexOf(10);
                if (iIndexOf <= 0) {
                    iIndexOf = 127;
                }
                str = str.substring(0, iIndexOf);
            }
            builder.appendQueryParameter("reason", str);
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    builder.appendQueryParameter(entry.getKey(), entry.getValue());
                }
            }
        } catch (Throwable th) {
        }
        com.baidu.mobads.container.components.g.f fVar = new com.baidu.mobads.container.components.g.f(1, a, "POST");
        fVar.a(builder);
        fVar.a();
    }
}
