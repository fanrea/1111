package com.qq.e.comm.plugin;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public abstract class u0 implements hw {
    private final HttpURLConnection a;
    private int b;

    public u0(HttpURLConnection httpURLConnection) throws IOException {
        this.b = 0;
        if (httpURLConnection != null) {
            this.a = httpURLConnection;
            this.b = httpURLConnection.getResponseCode();
            return;
        }
        throw new IOException("AbstractResponse parameter is null");
    }

    @Override // com.qq.e.comm.plugin.hw
    public InputStream b() throws IllegalStateException, IOException {
        return this.a.getInputStream();
    }

    @Override // com.qq.e.comm.plugin.hw
    public void close() throws IllegalStateException, IOException {
        b().close();
        this.a.disconnect();
    }

    public byte[] d() throws IllegalStateException, IOException {
        if (200 != a()) {
            return null;
        }
        InputStream inputStreamB = b();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int i = inputStreamB.read(bArr);
                if (i > 0) {
                    byteArrayOutputStream.write(bArr, 0, i);
                } else {
                    inputStreamB.close();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (Throwable th) {
            inputStreamB.close();
            throw th;
        }
    }

    @Override // com.qq.e.comm.plugin.hw
    public String c() throws IllegalStateException, IOException {
        byte[] bArrD = d();
        String contentEncoding = null;
        if (bArrD == null) {
            return null;
        }
        if (bArrD.length == 0) {
            return "";
        }
        try {
            contentEncoding = this.a.getContentEncoding();
        } catch (Throwable unused) {
        }
        if (contentEncoding == null) {
            contentEncoding = "UTF-8";
        }
        return new String(bArrD, contentEncoding);
    }

    @Override // com.qq.e.comm.plugin.hw
    public String a(String str) {
        return this.a.getHeaderField(str);
    }

    @Override // com.qq.e.comm.plugin.hw
    public int a() {
        return this.b;
    }
}
