package com.qq.e.comm.plugin;

import com.just.agentweb.AgentWebPermissions;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class wu {
    static void a(byte[] bArr, long j, int i) throws vu {
        lu.a(bArr, "Buffer must be not null!");
        lu.a(j >= 0, "Data offset must be positive!");
        lu.a(i >= 0 && i <= bArr.length, "Length must be in range [0..buffer.length]");
    }

    static String b(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Error encoding url", e);
        }
    }

    static String a(String str) {
        try {
            return URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Error decoding url", e);
        }
    }

    static HttpURLConnection a(String str, int i) throws IOException, vu {
        HttpURLConnection httpURLConnection;
        boolean z;
        int i2 = 0;
        do {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            if (i > 0) {
                httpURLConnection.setConnectTimeout(i);
                httpURLConnection.setReadTimeout(i);
            }
            int responseCode = httpURLConnection.getResponseCode();
            z = responseCode == 301 || responseCode == 302 || responseCode == 303;
            if (z) {
                str = httpURLConnection.getHeaderField(AgentWebPermissions.ACTION_LOCATION);
                i2++;
                httpURLConnection.disconnect();
            }
            if (i2 > 5) {
                throw new vu("Too many redirects: " + i2);
            }
        } while (z);
        return httpURLConnection;
    }
}
