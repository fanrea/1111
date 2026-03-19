package com.sigmob.sdk.base;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.CookieSyncManager;
import android.webkit.WebResourceResponse;
import com.just.agentweb.AgentWebPermissions;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.CookieManager;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class e {
    static final String a = "Set-Cookie";
    public static final String b = "Cookie";
    private static final String c = "e";
    private static final CookieManager d = new CookieManager();

    private static InputStream a(InputStream inputStream, String str) throws IOException {
        byte[] bArr = new byte[1024];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int i = inputStream.read(bArr);
            if (i == -1) {
                break;
            }
            byteArrayOutputStream.write(bArr, 0, i);
        }
        String str2 = new String(byteArrayOutputStream.toByteArray());
        if (str == null) {
            str = Charset.defaultCharset().displayName();
        }
        return new ByteArrayInputStream(str2.getBytes(str));
    }

    public static Map<String, String> a(Map<String, List<String>> maps) {
        StringBuilder sb = new StringBuilder();
        HashMap map = new HashMap();
        for (Map.Entry<String, List<String>> entry : maps.entrySet()) {
            List<String> value = entry.getValue();
            sb.delete(0, sb.length());
            if (value != null && value.size() > 0) {
                Iterator<String> it = value.iterator();
                while (it.hasNext()) {
                    sb.append(it.next());
                    sb.append(com.alipay.sdk.m.u.i.b);
                }
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            map.put(entry.getKey(), sb.toString());
        }
        return map;
    }

    public static void a(HttpURLConnection conn, CookieManager cookieManager) {
        if (cookieManager == null || conn == null) {
            return;
        }
        Map<String, List<String>> headerFields = conn.getHeaderFields();
        Log.d(c, "headerFields : " + headerFields.toString());
        List<String> list = headerFields.get(a);
        if (list == null) {
            return;
        }
        for (String str : list) {
            try {
                List<HttpCookie> list2 = HttpCookie.parse(str);
                if (list2 != null && !list2.isEmpty()) {
                    String str2 = c;
                    Log.d(str2, "{0} -- Reading Cookies from the response :" + conn.getURL().toString());
                    Log.d(str2, "{0} -- Reading Cookies from the response :" + list2.get(0));
                    for (HttpCookie httpCookie : list2) {
                        Log.d(c, httpCookie.toString());
                        android.webkit.CookieManager.getInstance().setCookie(conn.getURL().toString(), httpCookie.getName() + "=" + httpCookie.getValue());
                    }
                }
            } catch (NullPointerException unused) {
                Log.e(c, MessageFormat.format("{0} -- Null header for the cookie : {1}", conn.getURL().toString(), str));
            }
        }
        if (Build.VERSION.SDK_INT >= 21) {
            android.webkit.CookieManager.getInstance().flush();
        } else {
            CookieSyncManager.getInstance().sync();
        }
    }

    public WebResourceResponse a(String str, String method, Map<String, String> map) throws IOException {
        List<String> list;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setRequestMethod(method);
            if (map != null && map.size() > 0) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                }
            }
            String cookie = android.webkit.CookieManager.getInstance().getCookie(str);
            if (!TextUtils.isEmpty(cookie)) {
                for (String str2 : cookie.split(com.alipay.sdk.m.u.i.b)) {
                    httpURLConnection.addRequestProperty(b.toLowerCase(), str2.replace(" ", ""));
                }
            }
            httpURLConnection.connect();
            int responseCode = httpURLConnection.getResponseCode();
            String contentType = httpURLConnection.getContentType();
            String contentEncoding = httpURLConnection.getContentEncoding();
            InputStream inputStream = httpURLConnection.getInputStream();
            a(httpURLConnection, d);
            Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
            if ((responseCode == 301 || responseCode == 302) && (list = headerFields.get(AgentWebPermissions.ACTION_LOCATION)) != null && list.size() > 0) {
                return a(list.get(0), "GET", null);
            }
            if (contentType != null) {
                contentType = contentType.split(com.alipay.sdk.m.u.i.b)[0];
                if (contentType.contains("text") || contentType.contains("javascript")) {
                    if (contentType.contains("text/plain")) {
                        contentType = "text/html";
                    }
                    inputStream = a(inputStream, "UTF-8");
                    contentEncoding = "UTF-8";
                }
            } else {
                inputStream = null;
            }
            WebResourceResponse webResourceResponse = new WebResourceResponse(contentType, contentEncoding, inputStream);
            if (Build.VERSION.SDK_INT >= 21) {
                webResourceResponse.setResponseHeaders(a(headerFields));
            }
            return webResourceResponse;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
