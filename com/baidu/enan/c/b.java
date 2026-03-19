package com.baidu.enan.c;

import android.accounts.NetworkErrorException;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.enan.f.d;
import com.bytedance.sdk.djx.net.req.MediaTypeUtils;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Locale;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.conn.ssl.SSLSocketFactory;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class b {
    private Context b;
    private HttpURLConnection c;
    private String d;
    private String e;
    private String f;
    byte[] a = new byte[1024];
    private boolean g = false;

    public b(Context context) {
        this.b = context.getApplicationContext();
    }

    private String a(InputStream inputStream) throws IOException {
        byte[] bArrB;
        if (inputStream == null || (bArrB = b(inputStream)) == null) {
            return null;
        }
        if (this.g) {
            bArrB = d.b(bArrB);
        }
        if (bArrB == null) {
            return null;
        }
        return new String(bArrB);
    }

    private void a(String str, String str2) {
        this.d = str2;
        this.e = str;
    }

    private void a(HttpsURLConnection httpsURLConnection, String str) {
        try {
            httpsURLConnection.setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
        } catch (Throwable th) {
            com.baidu.enan.f.a.a(th);
        }
    }

    private HttpURLConnection a(Map<String, String> map, String str) throws ProtocolException {
        if (TextUtils.isEmpty(this.d)) {
            return null;
        }
        URL url = new URL(this.d);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        if ("https".equals(url.getProtocol())) {
            a((HttpsURLConnection) httpURLConnection, str);
        }
        httpURLConnection.setRequestMethod(this.e);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setDoOutput(true);
        String strA = com.baidu.enan.b.c.a(com.baidu.enan.f.c.a(this.b));
        this.f = strA;
        httpURLConnection.setRequestProperty("x-device-id", strA);
        String str2 = "enan/" + com.baidu.enan.f.b.a(this.b) + "/" + com.baidu.ad.magic.flute.a.f;
        httpURLConnection.setRequestProperty("x-device-abi", com.baidu.enan.f.b.c(this.b));
        httpURLConnection.setRequestProperty("User-Agent", str2);
        httpURLConnection.setRequestProperty("Pragma", "no-cache");
        httpURLConnection.setRequestProperty("Accept", "*/*");
        httpURLConnection.setRequestProperty("Content-Type", MediaTypeUtils.APPLICATION_FORM);
        httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
        httpURLConnection.setRequestProperty("Accept-Language", Locale.getDefault().getLanguage());
        if (map != null) {
            for (String str3 : map.keySet()) {
                httpURLConnection.setRequestProperty(str3, map.get(str3));
            }
        }
        return httpURLConnection;
    }

    public String a(String str, String str2, byte[] bArr) throws Throwable {
        InputStream inputStreamA;
        a("POST", str);
        try {
            inputStreamA = a(bArr, str2);
            if (inputStreamA == null) {
                if (inputStreamA != null) {
                    inputStreamA.close();
                }
                HttpURLConnection httpURLConnection = this.c;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                    this.c = null;
                }
                return null;
            }
            try {
                String strA = a(inputStreamA);
                if (inputStreamA != null) {
                    inputStreamA.close();
                }
                HttpURLConnection httpURLConnection2 = this.c;
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                    this.c = null;
                }
                return strA;
            } catch (Throwable th) {
                th = th;
                if (inputStreamA != null) {
                    inputStreamA.close();
                }
                HttpURLConnection httpURLConnection3 = this.c;
                if (httpURLConnection3 != null) {
                    httpURLConnection3.disconnect();
                    this.c = null;
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            inputStreamA = null;
        }
    }

    private InputStream a(byte[] bArr, String str) throws Exception {
        if (!"0".equals(com.baidu.enan.a.c.a())) {
            HttpURLConnection httpURLConnectionA = a((Map<String, String>) null, str);
            this.c = httpURLConnectionA;
            if (httpURLConnectionA == null) {
                return null;
            }
            if (bArr == null) {
                if ("gzip".equalsIgnoreCase(httpURLConnectionA.getContentEncoding())) {
                    this.g = true;
                } else {
                    this.g = false;
                }
                return this.c.getInputStream();
            }
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(this.c.getOutputStream());
            bufferedOutputStream.write(bArr);
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
            int responseCode = this.c.getResponseCode();
            if ("gzip".equalsIgnoreCase(this.c.getContentEncoding())) {
                this.g = true;
            } else {
                this.g = false;
            }
            if (responseCode == 200) {
                return this.c.getInputStream();
            }
            throw new Exception("rc not 200");
        }
        throw new NetworkErrorException("requestFromServerStreamByte no network");
    }

    private byte[] b(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int i = inputStream.read(this.a);
            if (i != -1) {
                byteArrayOutputStream.write(this.a, 0, i);
            } else {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return byteArray;
            }
        }
    }
}
