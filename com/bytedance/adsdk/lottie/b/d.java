package com.bytedance.adsdk.lottie.b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d implements c {
    private final HttpURLConnection d;

    public d(HttpURLConnection httpURLConnection) {
        this.d = httpURLConnection;
    }

    @Override // com.bytedance.adsdk.lottie.b.c
    public boolean d() {
        try {
            return this.d.getResponseCode() / 100 == 2;
        } catch (IOException unused) {
            return false;
        }
    }

    @Override // com.bytedance.adsdk.lottie.b.c
    public InputStream hc() throws IOException {
        return this.d.getInputStream();
    }

    @Override // com.bytedance.adsdk.lottie.b.c
    public String b() {
        return this.d.getContentType();
    }

    @Override // com.bytedance.adsdk.lottie.b.c
    public String c() {
        try {
            if (d()) {
                return null;
            }
            return "Unable to fetch " + this.d.getURL() + ". Failed with " + this.d.getResponseCode() + "\n" + d(this.d);
        } catch (IOException e) {
            com.bytedance.adsdk.lottie.u.u.d("get error failed ", e);
            return e.getMessage();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.d.disconnect();
    }

    private String d(HttpURLConnection httpURLConnection) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                String line = bufferedReader.readLine();
                if (line != null) {
                    sb.append(line).append('\n');
                } else {
                    try {
                        break;
                    } catch (Exception unused) {
                    }
                }
            } finally {
                try {
                    bufferedReader.close();
                } catch (Exception unused2) {
                }
            }
        }
        return sb.toString();
    }
}
