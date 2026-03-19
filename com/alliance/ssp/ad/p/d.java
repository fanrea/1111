package com.alliance.ssp.ad.p;

import android.content.Context;
import android.content.pm.PackageManager;
import android.webkit.WebSettings;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SAHttpRequestUtils.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class d {
    public Runnable a;
    public HttpURLConnection b = null;
    public e c;
    public String d;
    public int e;
    public int f;
    public String g;
    public String h;

    /* compiled from: SAHttpRequestUtils.java */
    public class a implements HostnameVerifier {
        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            return true;
        }
    }

    /* compiled from: SAHttpRequestUtils.java */
    public static class b implements X509TrustManager {
        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }
    }

    public d(String str, int i, int i2, String str2, Context context, String str3, e eVar) {
        this.c = eVar;
        this.d = str;
        this.e = i;
        this.f = i2;
        this.g = str2;
        this.h = str3;
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        HttpURLConnection httpURLConnection;
        String[] strArrB = com.alliance.ssp.ad.o.e.b(this.d);
        try {
            try {
                try {
                    URL url = new URL(("https://de.ad.gameley.com/" + this.h).trim());
                    if (url.getProtocol().equalsIgnoreCase("https")) {
                        c();
                        this.b = (HttpsURLConnection) url.openConnection();
                    } else {
                        this.b = (HttpURLConnection) url.openConnection();
                    }
                    this.b.setConnectTimeout(this.e);
                    this.b.setReadTimeout(this.f);
                    this.b.setRequestProperty("User-Agent", WebSettings.getDefaultUserAgent(com.alliance.ssp.ad.d0.b.b().a()));
                    boolean z = true;
                    this.b.setDoOutput(true);
                    this.b.setDoInput(true);
                    this.b.setUseCaches(false);
                    this.b.setRequestMethod(this.g);
                    this.b.setRequestProperty("Content-Type", "application/json");
                    this.b.setRequestProperty("Connection", "Keep-Alive");
                    this.b.setRequestProperty("Charset", "UTF-8");
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("cipher", strArrB[0]);
                    jSONObject.put("encryptParams", strArrB[1]);
                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(this.b.getOutputStream());
                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(bufferedOutputStream, "UTF-8");
                    outputStreamWriter.write(jSONObject.toString());
                    outputStreamWriter.flush();
                    outputStreamWriter.close();
                    bufferedOutputStream.close();
                    int responseCode = this.b.getResponseCode();
                    this.b.getResponseMessage();
                    if (200 == responseCode) {
                        StringBuilder sb = new StringBuilder();
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.b.getInputStream()));
                        while (true) {
                            String line = bufferedReader.readLine();
                            if (line == null) {
                                break;
                            } else {
                                sb.append(line).append("\n");
                            }
                        }
                        bufferedReader.close();
                        if (200 != responseCode) {
                            z = false;
                        }
                        if (z) {
                            ((com.alliance.ssp.ad.y.d) this.c).a(a(sb.toString()));
                        } else {
                            ((com.alliance.ssp.ad.y.d) this.c).a(responseCode, "响应失败");
                        }
                    } else {
                        ((com.alliance.ssp.ad.y.d) this.c).a(responseCode, "连接失败");
                    }
                    httpURLConnection = this.b;
                    if (httpURLConnection == null) {
                        return;
                    }
                } catch (SocketTimeoutException unused) {
                    com.alliance.ssp.ad.y.d dVar = (com.alliance.ssp.ad.y.d) this.c;
                    com.alliance.ssp.ad.impl.reward.a aVar = dVar.a;
                    aVar.getClass();
                    new com.alliance.ssp.ad.d0.f().a(3, 4, aVar.h, aVar.w, "", 0);
                    com.alliance.ssp.ad.impl.reward.a aVar2 = dVar.a;
                    aVar2.a(5, com.alliance.ssp.ad.impl.reward.a.a(aVar2, (String) null));
                    httpURLConnection = this.b;
                    if (httpURLConnection == null) {
                        return;
                    }
                } catch (UnknownHostException unused2) {
                    httpURLConnection = this.b;
                    if (httpURLConnection == null) {
                        return;
                    }
                }
            } catch (Exception e) {
                a(e, "001");
                httpURLConnection = this.b;
                if (httpURLConnection == null) {
                    return;
                }
            }
            httpURLConnection.disconnect();
        } catch (Throwable th) {
            HttpURLConnection httpURLConnection2 = this.b;
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
            throw th;
        }
    }

    public static void c() throws NoSuchAlgorithmException, KeyManagementException {
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, new TrustManager[]{new b()}, new SecureRandom());
            HttpsURLConnection.setDefaultHostnameVerifier(new a());
            HttpsURLConnection.setDefaultSSLSocketFactory(sSLContext.getSocketFactory());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void b() {
        this.a = new Runnable() { // from class: com.alliance.ssp.ad.p.d$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a();
            }
        };
    }

    public final void a(Exception exc, String str) throws JSONException, PackageManager.NameNotFoundException, IOException {
        new com.alliance.ssp.ad.d0.f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(exc, new StringBuilder().append("SAHttpRequestUtils_").append(str).append(" : ")), exc);
    }

    public final String a(String str) throws JSONException, PackageManager.NameNotFoundException, IOException {
        if (str != null && !str.isEmpty()) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("cipher") && jSONObject.has("encryptParams")) {
                    return com.alliance.ssp.ad.o.e.a(jSONObject.getString("cipher"), jSONObject.getString("encryptParams"));
                }
                return null;
            } catch (Exception e) {
                a(e, "002");
            }
        }
        return null;
    }
}
