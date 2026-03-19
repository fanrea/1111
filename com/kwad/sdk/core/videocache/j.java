package com.kwad.sdk.core.videocache;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.just.agentweb.AgentWebPermissions;
import com.kwad.sdk.utils.ax;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import okhttp3.ConnectionSpec;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class j extends p {
    private final com.kwad.sdk.core.videocache.d.c bIW;
    private final com.kwad.sdk.core.videocache.b.b bIX;
    private OkHttpClient bJB = new OkHttpClient();
    private n bJu;
    private InputStream bJw;

    public j(String str, com.kwad.sdk.core.videocache.d.c cVar, com.kwad.sdk.core.videocache.b.b bVar) {
        this.bIW = (com.kwad.sdk.core.videocache.d.c) ax.checkNotNull(cVar);
        this.bIX = (com.kwad.sdk.core.videocache.b.b) ax.checkNotNull(bVar);
        n nVarGk = cVar.gk(str);
        this.bJu = nVarGk == null ? new n(str, -2147483648L, l.gh(str)) : nVarGk;
    }

    public j(j jVar) {
        this.bJu = jVar.bJu;
        this.bIW = jVar.bIW;
        this.bIX = jVar.bIX;
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

    private void adf() {
        n nVarGk;
        com.kwad.sdk.core.videocache.d.c cVar = this.bIW;
        if (cVar == null || !(cVar instanceof com.kwad.sdk.core.videocache.d.b) || (nVarGk = cVar.gk(getUrl())) == null || TextUtils.isEmpty(nVarGk.bJL) || nVarGk.bJK == -2147483648L) {
            return;
        }
        this.bJu = nVarGk;
    }

    @Override // com.kwad.sdk.core.videocache.m
    public final void bj(long j) throws ProxyCacheException {
        try {
            Response responseH = h(j, -1);
            String mediaType = responseH.body().get$contentType().getMediaType();
            long jA = a(responseH, j);
            this.bJw = new BufferedInputStream(responseH.body().byteStream(), 1024);
            n nVar = new n(this.bJu.url, jA, mediaType);
            this.bJu = nVar;
            this.bIW.a(nVar.url, this.bJu);
        } catch (IOException e) {
            throw new ProxyCacheException("Error opening connection for " + getUrl() + " with offset " + j, e);
        }
    }

    private long a(Response response, long j) {
        int iCode = response.code();
        long contentLength = response.body().getContentLength();
        return iCode == 200 ? contentLength : iCode == 206 ? contentLength + j : this.bJu.bJK;
    }

    @Override // com.kwad.sdk.core.videocache.m
    public final void close() {
        com.kwad.sdk.crash.utils.b.closeQuietly(this.bJw);
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

    private void add() {
        Response responseFF = null;
        try {
            try {
                responseFF = fF(10000);
            } catch (IOException unused) {
                com.kwad.sdk.core.d.c.e("HttpUrlSource", "Error fetching info from " + this.bJu.url);
                if (0 == 0 || responseFF.body() == null) {
                    return;
                }
            }
            if (responseFF == null || !responseFF.isSuccessful()) {
                throw new ProxyCacheException("Fail to fetchContentInfo: " + getUrl());
            }
            n nVar = new n(this.bJu.url, c(responseFF), responseFF.header("Content-Type"));
            this.bJu = nVar;
            this.bIW.a(nVar.url, this.bJu);
            com.kwad.sdk.core.d.c.d("HttpUrlSource", "Source info fetched: " + this.bJu);
            if (responseFF == null || responseFF.body() == null) {
                return;
            }
            com.kwad.sdk.crash.utils.b.closeQuietly(responseFF.body());
        } catch (Throwable th) {
            if (0 != 0 && responseFF.body() != null) {
                com.kwad.sdk.crash.utils.b.closeQuietly(responseFF.body());
            }
            throw th;
        }
    }

    private static long c(Response response) {
        String strHeader = response.header("Content-Length");
        if (strHeader == null) {
            return -1L;
        }
        return Long.parseLong(strHeader);
    }

    private Response h(long j, int i) throws IOException, ProxyCacheException {
        Response responseExecute;
        OkHttpClient.Builder builderNewBuilder = this.bJB.newBuilder();
        int i2 = 0;
        builderNewBuilder.connectionSpecs(Arrays.asList(ConnectionSpec.MODERN_TLS, ConnectionSpec.COMPATIBLE_TLS, ConnectionSpec.CLEARTEXT));
        try {
            builderNewBuilder.dns(new com.kwad.sdk.core.network.a.d());
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTrace(th);
        }
        this.bJB = builderNewBuilder.build();
        String url = getUrl();
        boolean zIsRedirect = false;
        do {
            Request.Builder builder = new Request.Builder();
            builder.get();
            builder.url(url);
            if (j > 0) {
                builder.addHeader("Range", "bytes=" + j + "-");
            }
            responseExecute = this.bJB.newCall(builder.build()).execute();
            if (responseExecute.isRedirect()) {
                url = responseExecute.header(AgentWebPermissions.ACTION_LOCATION);
                zIsRedirect = responseExecute.isRedirect();
                i2++;
            }
            if (i2 > 5) {
                throw new ProxyCacheException("Too many redirects: " + i2);
            }
        } while (zIsRedirect);
        return responseExecute;
    }

    private Response fF(int i) throws IOException, ProxyCacheException {
        Response responseExecute;
        OkHttpClient.Builder builderNewBuilder = new OkHttpClient().newBuilder();
        builderNewBuilder.connectTimeout(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, TimeUnit.MILLISECONDS);
        builderNewBuilder.readTimeout(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, TimeUnit.MILLISECONDS);
        builderNewBuilder.writeTimeout(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, TimeUnit.MILLISECONDS);
        int i2 = 0;
        builderNewBuilder.connectionSpecs(Arrays.asList(ConnectionSpec.MODERN_TLS, ConnectionSpec.COMPATIBLE_TLS, ConnectionSpec.CLEARTEXT));
        try {
            builderNewBuilder.dns(new com.kwad.sdk.core.network.a.d());
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTrace(th);
        }
        this.bJB = builderNewBuilder.build();
        String url = getUrl();
        boolean zIsRedirect = false;
        do {
            Request.Builder builder = new Request.Builder();
            builder.head();
            builder.url(url);
            responseExecute = this.bJB.newCall(builder.build()).execute();
            if (responseExecute.isRedirect()) {
                url = responseExecute.header(AgentWebPermissions.ACTION_LOCATION);
                zIsRedirect = responseExecute.isRedirect();
                i2++;
            }
            if (i2 > 5) {
                throw new ProxyCacheException("Too many redirects: " + i2);
            }
        } while (zIsRedirect);
        return responseExecute;
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

    @Override // com.kwad.sdk.core.videocache.p
    public final String toString() {
        return "HttpUrlSource{sourceInfo='" + this.bJu + com.alipay.sdk.m.u.i.d;
    }
}
