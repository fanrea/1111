package com.tencent.turingfd.sdk.ams.au;

import com.just.agentweb.AgentWebPermissions;
import com.tencent.turingfd.sdk.ams.au.Berry;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class Andromeda {
    public static Berry a(Banana banana, URL url, Map<String, String> map) throws Throwable {
        HttpURLConnection httpURLConnection;
        BufferedInputStream bufferedInputStream = null;
        try {
            httpURLConnection = (HttpURLConnection) url.openConnection();
            try {
                httpURLConnection.setRequestProperty("User-Agent", "Turing");
                httpURLConnection.setRequestProperty("Accept-Charset", "utf-8");
                if (!map.isEmpty()) {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                    }
                }
                httpURLConnection.setRequestMethod(banana.c);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setConnectTimeout(banana.e);
                httpURLConnection.setReadTimeout(banana.f);
                httpURLConnection.setInstanceFollowRedirects(banana.g);
                Berry.Cdo cdo = new Berry.Cdo();
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode != 200) {
                    if (responseCode != 305) {
                        switch (responseCode) {
                            case 300:
                            case 301:
                            case 302:
                            case 303:
                                break;
                            default:
                                cdo.a = responseCode;
                                Berry berry = new Berry(cdo);
                                try {
                                    httpURLConnection.disconnect();
                                } catch (Throwable unused) {
                                }
                                return berry;
                        }
                    }
                    cdo.a = responseCode;
                    cdo.d = true;
                    cdo.c = httpURLConnection.getHeaderField(AgentWebPermissions.ACTION_LOCATION);
                    Berry berry2 = new Berry(cdo);
                    try {
                        httpURLConnection.disconnect();
                    } catch (Throwable unused2) {
                    }
                    return berry2;
                }
                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(httpURLConnection.getInputStream());
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    Auriga.a(bufferedInputStream2, byteArrayOutputStream);
                    URL url2 = httpURLConnection.getURL();
                    if (!url.getHost().equals(url2.getHost())) {
                        cdo.d = true;
                        cdo.c = url2.toString();
                    }
                    cdo.b = byteArrayOutputStream.toByteArray();
                    Berry berry3 = new Berry(cdo);
                    Auriga.a(bufferedInputStream2);
                    try {
                        httpURLConnection.disconnect();
                    } catch (Throwable unused3) {
                    }
                    return berry3;
                } catch (Throwable th) {
                    th = th;
                    bufferedInputStream = bufferedInputStream2;
                    Auriga.a(bufferedInputStream);
                    if (httpURLConnection != null) {
                        try {
                            httpURLConnection.disconnect();
                        } catch (Throwable unused4) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            httpURLConnection = null;
        }
    }
}
