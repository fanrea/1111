package com.netease.htprotect.Oo0;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.security.SecureRandom;
import java.util.HashMap;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;

/* renamed from: com.netease.htprotect.Oo0.〇Ooo, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class Ooo {
    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public static byte[] m516O8oO888(String str, HashMap map, int i) throws Throwable {
        HttpURLConnection httpURLConnection = null;
        try {
            try {
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection(Proxy.NO_PROXY);
                try {
                    if (httpURLConnection2 instanceof HttpsURLConnection) {
                        SSLContext sSLContext = SSLContext.getInstance("TLS");
                        sSLContext.init(null, null, new SecureRandom());
                        ((HttpsURLConnection) httpURLConnection2).setSSLSocketFactory(sSLContext.getSocketFactory());
                    }
                    httpURLConnection2.setRequestMethod("GET");
                    for (String str2 : map.keySet()) {
                        httpURLConnection2.setRequestProperty(str2, (String) map.get(str2));
                    }
                    httpURLConnection2.setConnectTimeout(5000);
                    if (i == 1) {
                        httpURLConnection2.setReadTimeout(5000);
                    }
                    httpURLConnection2.setUseCaches(false);
                    int responseCode = httpURLConnection2.getResponseCode();
                    if (responseCode != 200) {
                        byte[] bytes = "code:".concat(String.valueOf(responseCode)).getBytes();
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                        }
                        return bytes;
                    }
                    byte[] bArrM514O8oO888 = O8oO888.m514O8oO888(httpURLConnection2.getInputStream());
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    return bArrM514O8oO888;
                } catch (Exception e) {
                    e = e;
                    httpURLConnection = httpURLConnection2;
                    byte[] bytes2 = ("Exception:" + e.getMessage()).getBytes();
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    return bytes2;
                } catch (Throwable th) {
                    th = th;
                    httpURLConnection = httpURLConnection2;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public static byte[] m517O8oO888(byte[] bArr, String str, HashMap map, int i) throws Throwable {
        HttpURLConnection httpURLConnection = null;
        try {
            try {
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection(Proxy.NO_PROXY);
                try {
                    if (httpURLConnection2 instanceof HttpsURLConnection) {
                        SSLContext sSLContext = SSLContext.getInstance("TLS");
                        sSLContext.init(null, null, new SecureRandom());
                        ((HttpsURLConnection) httpURLConnection2).setSSLSocketFactory(sSLContext.getSocketFactory());
                    }
                    httpURLConnection2.setRequestMethod("POST");
                    for (String str2 : map.keySet()) {
                        httpURLConnection2.setRequestProperty(str2, (String) map.get(str2));
                    }
                    httpURLConnection2.setDoOutput(true);
                    httpURLConnection2.setDoInput(true);
                    httpURLConnection2.setConnectTimeout(5000);
                    if (i == 1) {
                        httpURLConnection2.setReadTimeout(5000);
                    }
                    httpURLConnection2.setUseCaches(false);
                    httpURLConnection2.setFixedLengthStreamingMode(bArr.length);
                    DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection2.getOutputStream());
                    dataOutputStream.write(bArr);
                    dataOutputStream.flush();
                    dataOutputStream.close();
                    int responseCode = httpURLConnection2.getResponseCode();
                    if (responseCode != 200) {
                        byte[] bytes = "code:".concat(String.valueOf(responseCode)).getBytes();
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                        }
                        return bytes;
                    }
                    byte[] bArrM514O8oO888 = O8oO888.m514O8oO888(httpURLConnection2.getInputStream());
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    return bArrM514O8oO888;
                } catch (Exception e) {
                    e = e;
                    httpURLConnection = httpURLConnection2;
                    byte[] bytes2 = ("Exception:" + e.getMessage()).getBytes();
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    return bytes2;
                } catch (Throwable th) {
                    th = th;
                    httpURLConnection = httpURLConnection2;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }
}
