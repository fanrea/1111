package com.kwad.sdk.core.videocache;

import android.text.TextUtils;
import com.just.agentweb.AgentWebPermissions;
import com.kwad.sdk.core.network.r;
import com.kwad.sdk.utils.ax;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class h extends p {
    private final com.kwad.sdk.core.videocache.d.c bIW;
    private final com.kwad.sdk.core.videocache.b.b bIX;
    private n bJu;
    private HttpURLConnection bJv;
    private InputStream bJw;

    public h(String str, com.kwad.sdk.core.videocache.d.c cVar, com.kwad.sdk.core.videocache.b.b bVar) {
        this.bIW = (com.kwad.sdk.core.videocache.d.c) ax.checkNotNull(cVar);
        this.bIX = (com.kwad.sdk.core.videocache.b.b) ax.checkNotNull(bVar);
        n nVarGk = cVar.gk(str);
        this.bJu = nVarGk == null ? new n(str, -2147483648L, l.gh(str)) : nVarGk;
    }

    public h(h hVar) {
        this.bJu = hVar.bJu;
        this.bIW = hVar.bIW;
        this.bIX = hVar.bIX;
    }

    @Override // com.kwad.sdk.core.videocache.m
    public final synchronized long length() {
        if (this.bJu.bJK == -2147483648L) {
            adf();
        }
        if (this.bJu.bJK == -2147483648L) {
            add();
        }
        return this.bJu.bJK;
    }

    @Override // com.kwad.sdk.core.videocache.m
    public final void bj(long j) throws NoSuchAlgorithmException, ProxyCacheException, KeyManagementException {
        try {
            HttpURLConnection httpURLConnectionG = g(j, -1);
            this.bJv = httpURLConnectionG;
            String contentType = httpURLConnectionG.getContentType();
            this.bJw = new BufferedInputStream(this.bJv.getInputStream(), 1024);
            HttpURLConnection httpURLConnection = this.bJv;
            n nVar = new n(this.bJu.url, a(httpURLConnection, j, httpURLConnection.getResponseCode()), contentType);
            this.bJu = nVar;
            this.bIW.a(nVar.url, this.bJu);
        } catch (IOException e) {
            throw new ProxyCacheException("Error opening connection for " + this.bJu.url + " with offset " + j, e);
        }
    }

    private long a(HttpURLConnection httpURLConnection, long j, int i) {
        long jE = e(httpURLConnection);
        return i == 200 ? jE : i == 206 ? jE + j : this.bJu.bJK;
    }

    private static long e(HttpURLConnection httpURLConnection) {
        String headerField = httpURLConnection.getHeaderField("Content-Length");
        if (headerField == null) {
            return -1L;
        }
        return Long.parseLong(headerField);
    }

    @Override // com.kwad.sdk.core.videocache.m
    public final void close() {
        HttpURLConnection httpURLConnection = this.bJv;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (ArrayIndexOutOfBoundsException unused) {
                com.kwad.sdk.core.d.c.e("HttpUrlSource", "Error closing connection correctly. Should happen only on Android L. If anybody know how to fix it, please visit https://github.com/danikula/AndroidVideoCache/issues/88. Until good solution is not know, just ignore this issue.");
            } catch (IllegalArgumentException e) {
                e = e;
                throw new RuntimeException("Wait... but why? WTF!? Really shouldn't happen any more after fixing https://github.com/danikula/AndroidVideoCache/issues/43. If you read it on your device log, please, notify me danikula@gmail.com or create issue here https://github.com/danikula/AndroidVideoCache/issues.", e);
            } catch (NullPointerException e2) {
                e = e2;
                throw new RuntimeException("Wait... but why? WTF!? Really shouldn't happen any more after fixing https://github.com/danikula/AndroidVideoCache/issues/43. If you read it on your device log, please, notify me danikula@gmail.com or create issue here https://github.com/danikula/AndroidVideoCache/issues.", e);
            }
        }
    }

    @Override // com.kwad.sdk.core.videocache.m
    public final int read(byte[] bArr) throws ProxyCacheException {
        InputStream inputStream = this.bJw;
        if (inputStream == null) {
            throw new ProxyCacheException("Error reading data from " + this.bJu.url + ": connection is absent!");
        }
        try {
            return inputStream.read(bArr, 0, 1024);
        } catch (InterruptedIOException e) {
            throw new InterruptedProxyCacheException("Reading source " + this.bJu.url + " is interrupted", e);
        } catch (IOException e2) {
            throw new ProxyCacheException("Error reading data from " + this.bJu.url, e2);
        }
    }

    private void add() throws Throwable {
        HttpURLConnection httpURLConnectionG;
        com.kwad.sdk.core.d.c.d("HttpUrlSource", "Read content info from " + this.bJu.url);
        InputStream inputStream = null;
        try {
            httpURLConnectionG = g(0L, 10000);
        } catch (IOException unused) {
            httpURLConnectionG = null;
        } catch (Throwable th) {
            th = th;
            httpURLConnectionG = null;
            com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
            com.kwad.sdk.crash.utils.b.closeQuietly(httpURLConnectionG);
            throw th;
        }
        try {
            try {
                long jE = e(httpURLConnectionG);
                String contentType = httpURLConnectionG.getContentType();
                inputStream = httpURLConnectionG.getInputStream();
                n nVar = new n(this.bJu.url, jE, contentType);
                this.bJu = nVar;
                this.bIW.a(nVar.url, this.bJu);
                com.kwad.sdk.core.d.c.d("HttpUrlSource", "Source info fetched: " + this.bJu);
            } catch (Throwable th2) {
                th = th2;
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                com.kwad.sdk.crash.utils.b.closeQuietly(httpURLConnectionG);
                throw th;
            }
        } catch (IOException unused2) {
            com.kwad.sdk.core.d.c.e("HttpUrlSource", "Error fetching info from " + this.bJu.url);
            com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
            com.kwad.sdk.crash.utils.b.closeQuietly(httpURLConnectionG);
        }
        com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
        com.kwad.sdk.crash.utils.b.closeQuietly(httpURLConnectionG);
    }

    private HttpURLConnection g(long j, int i) throws NoSuchAlgorithmException, IOException, ProxyCacheException, KeyManagementException {
        HttpURLConnection httpURLConnection;
        boolean z;
        String headerField = this.bJu.url;
        int i2 = 0;
        do {
            com.kwad.sdk.core.d.c.d("HttpUrlSource", "Open connection " + (j > 0 ? " with offset " + j : "") + " to " + headerField);
            httpURLConnection = (HttpURLConnection) new URL(headerField).openConnection();
            r.wrapHttpURLConnection(httpURLConnection);
            a(httpURLConnection, headerField);
            if (j > 0) {
                httpURLConnection.setRequestProperty("Range", "bytes=" + j + "-");
            }
            if (i > 0) {
                httpURLConnection.setConnectTimeout(i);
                httpURLConnection.setReadTimeout(i);
            }
            com.kwad.sdk.core.network.p.c(httpURLConnection);
            int responseCode = httpURLConnection.getResponseCode();
            z = responseCode == 301 || responseCode == 302 || responseCode == 303;
            if (z) {
                headerField = httpURLConnection.getHeaderField(AgentWebPermissions.ACTION_LOCATION);
                i2++;
                httpURLConnection.disconnect();
            }
            if (i2 > 5) {
                throw new ProxyCacheException("Too many redirects: " + i2);
            }
        } while (z);
        return httpURLConnection;
    }

    private void a(HttpURLConnection httpURLConnection, String str) {
        for (Map.Entry<String, String> entry : this.bIX.adm().entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
    }

    @Override // com.kwad.sdk.core.videocache.p
    public final synchronized String ade() {
        if (TextUtils.isEmpty(this.bJu.bJL)) {
            adf();
        }
        if (TextUtils.isEmpty(this.bJu.bJL)) {
            add();
        }
        return this.bJu.bJL;
    }

    @Override // com.kwad.sdk.core.videocache.p
    public final String getUrl() {
        return this.bJu.url;
    }

    private void adf() {
        n nVarGk;
        com.kwad.sdk.core.videocache.d.c cVar = this.bIW;
        if (cVar == null || !(cVar instanceof com.kwad.sdk.core.videocache.d.b) || (nVarGk = cVar.gk(getUrl())) == null || TextUtils.isEmpty(nVarGk.bJL) || nVarGk.bJK == -2147483648L) {
            return;
        }
        this.bJu = nVarGk;
    }

    @Override // com.kwad.sdk.core.videocache.p
    public final String toString() {
        return "HttpUrlSource{sourceInfo='" + this.bJu + com.alipay.sdk.m.u.i.d;
    }
}
