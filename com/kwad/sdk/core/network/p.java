package com.kwad.sdk.core.network;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.WebSettings;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ag;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URLEncoder;

@Deprecated
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class p {
    private static String bDr = "";
    private static String bDs = "";

    public static String aaq() {
        try {
            if (!TextUtils.isEmpty(bDr)) {
                return bDr;
            }
            String property = System.getProperty("http.agent");
            bDr = property;
            if (TextUtils.isEmpty(property)) {
                return bDr;
            }
            StringBuffer stringBuffer = new StringBuffer();
            int length = bDr.length();
            for (int i = 0; i < length; i++) {
                char cCharAt = bDr.charAt(i);
                if (cCharAt <= 31 || cCharAt >= 127) {
                    stringBuffer.append(String.format("\\u%04x", Integer.valueOf(cCharAt)));
                } else {
                    stringBuffer.append(cCharAt);
                }
            }
            String string = stringBuffer.toString();
            bDr = string;
            return string;
        } catch (Throwable unused) {
            return "";
        }
    }

    private static String getDefaultUserAgent() {
        return aaq() + "-ksad-android-4.6.30.1";
    }

    public static String getUserAgent() {
        String userAgent = ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).getUserAgent();
        return TextUtils.isEmpty(userAgent) ? getDefaultUserAgent() : userAgent;
    }

    public static String aar() throws UnsupportedEncodingException {
        String strDS;
        if (!TextUtils.isEmpty(bDs)) {
            return bDs;
        }
        Context context = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext();
        if (context == null) {
            return "";
        }
        try {
            strDS = ag.dS(context);
            bDs = strDS;
        } catch (Exception unused) {
        }
        if (!TextUtils.isEmpty(strDS)) {
            return bDs;
        }
        if (Build.VERSION.SDK_INT >= 17) {
            bDs = WebSettings.getDefaultUserAgent(context);
        } else {
            bDs = System.getProperty("http.agent");
        }
        String strEncode = URLEncoder.encode(bDs, "UTF-8");
        bDs = strEncode;
        ag.aA(context, strEncode);
        return bDs;
    }

    public static void c(HttpURLConnection httpURLConnection) {
        httpURLConnection.setRequestProperty("User-Agent", getUserAgent());
        httpURLConnection.setRequestProperty("BrowserUa", aar());
        httpURLConnection.setRequestProperty("SystemUa", aaq());
    }
}
