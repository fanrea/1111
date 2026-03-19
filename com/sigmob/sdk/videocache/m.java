package com.sigmob.sdk.videocache;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.czhj.sdk.logger.SigmobLog;
import com.just.agentweb.AgentWebPermissions;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class m implements u {
    private static final int c = 5;
    private static OkHttpClient d;
    protected volatile long a;
    protected volatile String b;
    private InputStream e;
    private v f;
    private final com.sigmob.sdk.videocache.sourcestorage.c g;
    private final com.sigmob.sdk.videocache.headers.b h;
    private Response i;

    public m(u source) {
        this.a = -2147483648L;
        this.b = "video/mp4";
        this.f = source.d();
        this.g = source.e();
        this.h = source.f();
    }

    public m(String url) {
        this(url, com.sigmob.sdk.videocache.sourcestorage.d.a());
    }

    public m(String url, com.sigmob.sdk.videocache.sourcestorage.c sourceInfoStorage) {
        this(url, sourceInfoStorage, new com.sigmob.sdk.videocache.headers.a());
    }

    public m(String url, com.sigmob.sdk.videocache.sourcestorage.c sourceInfoStorage, com.sigmob.sdk.videocache.headers.b headerInjector) {
        this.a = -2147483648L;
        this.b = "video/mp4";
        this.g = (com.sigmob.sdk.videocache.sourcestorage.c) o.a(sourceInfoStorage);
        this.h = (com.sigmob.sdk.videocache.headers.b) o.a(headerInjector);
        v vVarA = sourceInfoStorage.a(url);
        this.f = vVarA == null ? new v(url, -2147483648L, r.a(url)) : vVarA;
    }

    private long a(Response response, long offset) throws IOException {
        int iCode = response.code();
        int iContentLength = (int) response.body().getContentLength();
        return iCode == 200 ? iContentLength : iCode == 206 ? iContentLength + offset : this.a;
    }

    private Response a(long offset, int timeout) throws IOException, q {
        if (d == null) {
            d = new OkHttpClient().newBuilder().connectionPool(new ConnectionPool()).connectTimeout(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, TimeUnit.MILLISECONDS).readTimeout(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, TimeUnit.MILLISECONDS).writeTimeout(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, TimeUnit.MILLISECONDS).build();
        }
        String strHeader = this.f.a;
        Response response = this.i;
        if (response != null && offset > 0) {
            try {
                response.close();
            } catch (Throwable unused) {
            }
            this.i = null;
            r.a(this.e);
        }
        if (this.i == null) {
            int i = 0;
            boolean zIsRedirect = false;
            do {
                Request.Builder builder = new Request.Builder();
                builder.get();
                builder.url(strHeader);
                a(builder, strHeader);
                if (offset > 0) {
                    builder.addHeader("Range", "bytes=" + offset + "-");
                }
                Response responseExecute = d.newCall(builder.build()).execute();
                this.i = responseExecute;
                if (responseExecute.isRedirect()) {
                    strHeader = this.i.header(AgentWebPermissions.ACTION_LOCATION);
                    zIsRedirect = this.i.isRedirect();
                    i++;
                }
                if (i > 5) {
                    throw new q("Too many redirects: " + i);
                }
            } while (zIsRedirect);
        }
        return this.i;
    }

    private void a(Request.Builder requestBuilder, String url) {
        for (Map.Entry<String, String> entry : this.h.a(url).entrySet()) {
            requestBuilder.addHeader(entry.getKey(), entry.getValue());
        }
    }

    private void h() throws q {
        try {
            SigmobLog.d("Read content info from " + this.f.a);
            Response responseA = a(0L, 10000);
            if (responseA == null || !responseA.isSuccessful()) {
                throw new q("Fail to fetchContentInfo: " + this.f.a);
            }
            ResponseBody responseBodyBody = responseA.body();
            if (responseBodyBody != null) {
                this.a = (int) responseBodyBody.getContentLength();
                if (responseBodyBody.get$contentType() != null) {
                    this.b = responseBodyBody.get$contentType().getMediaType();
                }
            }
            v vVar = new v(this.f.a, this.a, this.b);
            this.f = vVar;
            this.g.a(vVar.a, this.f);
        } catch (IOException e) {
            SigmobLog.e("Error fetching info from " + this.f.a, e);
        }
    }

    @Override // com.sigmob.sdk.videocache.u
    public int a(byte[] buffer) throws q {
        InputStream inputStream = this.e;
        if (inputStream == null) {
            throw new q("Error reading data from " + this.f.a + ": connection is absent!");
        }
        try {
            return inputStream.read(buffer, 0, buffer.length);
        } catch (InterruptedIOException e) {
            throw new l("Reading source " + this.f.a + " is interrupted", e);
        } catch (IOException e2) {
            throw new q("Error reading data from " + this.f.a, e2);
        }
    }

    @Override // com.sigmob.sdk.videocache.u
    public long a() throws q {
        if (this.a == -2147483648L) {
            h();
        }
        return this.a;
    }

    @Override // com.sigmob.sdk.videocache.u
    public void a(long offset) throws q {
        try {
            Response responseA = a(offset, -1);
            this.i = responseA;
            ResponseBody responseBodyBody = responseA.body();
            if (responseBodyBody != null && responseBodyBody.get$contentType() != null) {
                this.b = responseBodyBody.get$contentType().getMediaType();
            }
            this.a = a(this.i, offset);
            this.e = new BufferedInputStream(responseBodyBody.byteStream(), 8192);
            v vVar = new v(this.f.a, this.a, this.b);
            this.f = vVar;
            this.g.a(vVar.a, this.f);
        } catch (IOException e) {
            throw new q("Error opening connection for " + this.f.a + " with offset " + offset, e);
        }
    }

    @Override // com.sigmob.sdk.videocache.u
    public void b() throws IOException, q {
        try {
            r.a(this.e);
        } catch (ArrayIndexOutOfBoundsException e) {
            SigmobLog.e("Error closing connection correctly. Should happen only on SigmobAndroid L. Until good solution is not know, just ignore this issue :(", e);
        } catch (IllegalArgumentException e2) {
            e = e2;
            throw new RuntimeException("Wait... but why? WTF!? If you read it on your device log, please", e);
        } catch (NullPointerException e3) {
            e = e3;
            throw new RuntimeException("Wait... but why? WTF!? If you read it on your device log, please", e);
        }
    }

    @Override // com.sigmob.sdk.videocache.u
    public synchronized String c() throws q {
        if (TextUtils.isEmpty(this.f.c)) {
            h();
        }
        return this.f.c;
    }

    @Override // com.sigmob.sdk.videocache.u
    public v d() {
        return this.f;
    }

    @Override // com.sigmob.sdk.videocache.u
    public com.sigmob.sdk.videocache.sourcestorage.c e() {
        return this.g;
    }

    @Override // com.sigmob.sdk.videocache.u
    public com.sigmob.sdk.videocache.headers.b f() {
        return this.h;
    }

    @Override // com.sigmob.sdk.videocache.u
    public String g() {
        return this.f.a;
    }

    public String toString() {
        return "HttpUrlSource{sourceInfo='" + this.f + com.alipay.sdk.m.u.i.d;
    }
}
