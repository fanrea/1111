package com.sigmob.sdk.videocache;

import android.text.TextUtils;
import com.czhj.sdk.logger.SigmobLog;
import com.just.agentweb.AgentWebPermissions;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class j implements u {
    private static final int a = 5;
    private final com.sigmob.sdk.videocache.sourcestorage.c b;
    private final com.sigmob.sdk.videocache.headers.b c;
    private v d;
    private HttpURLConnection e;
    private InputStream f;

    public j(u source) {
        this.d = source.d();
        this.b = source.e();
        this.c = source.f();
    }

    public j(String url) {
        this(url, com.sigmob.sdk.videocache.sourcestorage.d.a());
    }

    public j(String url, com.sigmob.sdk.videocache.sourcestorage.c sourceInfoStorage) {
        this(url, sourceInfoStorage, new com.sigmob.sdk.videocache.headers.a());
    }

    public j(String url, com.sigmob.sdk.videocache.sourcestorage.c sourceInfoStorage, com.sigmob.sdk.videocache.headers.b headerInjector) {
        this.b = (com.sigmob.sdk.videocache.sourcestorage.c) o.a(sourceInfoStorage);
        this.c = (com.sigmob.sdk.videocache.headers.b) o.a(headerInjector);
        v vVarA = sourceInfoStorage.a(url);
        this.d = vVarA == null ? new v(url, -2147483648L, r.a(url)) : vVarA;
    }

    private long a(HttpURLConnection connection) {
        String headerField = connection.getHeaderField("Content-Length");
        if (headerField == null) {
            return -1L;
        }
        return Long.parseLong(headerField);
    }

    private long a(HttpURLConnection connection, long offset, int responseCode) throws IOException {
        long jA = a(connection);
        return responseCode == 200 ? jA : responseCode == 206 ? jA + offset : this.d.b;
    }

    private HttpURLConnection a(long offset, int timeout) throws IOException, q {
        boolean z;
        String str = this.d.a;
        HttpURLConnection httpURLConnection = this.e;
        if (httpURLConnection != null && offset > 0 && httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Throwable unused) {
            }
            this.e = null;
            r.a(this.f);
        }
        if (this.e == null) {
            int i = 0;
            do {
                SigmobLog.d("Open connection " + (offset > 0 ? " with offset " + offset : "") + " to " + str);
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
                this.e = httpURLConnection2;
                a(httpURLConnection2, str);
                if (offset > 0) {
                    this.e.setRequestProperty("Range", "bytes=" + offset + "-");
                }
                if (timeout > 0) {
                    this.e.setConnectTimeout(timeout);
                    this.e.setReadTimeout(timeout);
                }
                int responseCode = this.e.getResponseCode();
                z = responseCode == 301 || responseCode == 302 || responseCode == 303;
                if (z) {
                    String headerField = this.e.getHeaderField(AgentWebPermissions.ACTION_LOCATION);
                    URI uriCreate = URI.create(headerField);
                    if (uriCreate != null && !uriCreate.isAbsolute()) {
                        try {
                            URI uriCreate2 = URI.create(str);
                            if (uriCreate2 != null) {
                                headerField = uriCreate2.resolve(uriCreate).toString();
                            }
                        } catch (Throwable unused2) {
                        }
                    }
                    i++;
                    this.e.disconnect();
                    str = headerField;
                }
                if (i > 5) {
                    throw new q("Too many redirects: " + i);
                }
            } while (z);
        }
        return this.e;
    }

    private void a(HttpURLConnection connection, String url) {
        for (Map.Entry<String, String> entry : this.c.a(url).entrySet()) {
            connection.setRequestProperty(entry.getKey(), entry.getValue());
        }
    }

    private void h() throws q {
        SigmobLog.d("Read content info from " + this.d.a);
        try {
            HttpURLConnection httpURLConnectionA = a(0L, 3000);
            v vVar = new v(this.d.a, a(httpURLConnectionA), httpURLConnectionA.getContentType());
            this.d = vVar;
            this.b.a(vVar.a, this.d);
            SigmobLog.d("Source info fetched: " + this.d);
        } catch (IOException e) {
            SigmobLog.e("Error fetching info from " + this.d.a, e);
        }
    }

    @Override // com.sigmob.sdk.videocache.u
    public int a(byte[] buffer) throws q {
        InputStream inputStream = this.f;
        if (inputStream == null) {
            throw new q("Error reading data from " + this.d.a + ": connection is absent!");
        }
        try {
            return inputStream.read(buffer, 0, buffer.length);
        } catch (InterruptedIOException e) {
            throw new l("Reading source " + this.d.a + " is interrupted", e);
        } catch (IOException e2) {
            throw new q("Error reading data from " + this.d.a, e2);
        }
    }

    @Override // com.sigmob.sdk.videocache.u
    public synchronized long a() throws q {
        if (this.d.b == -2147483648L) {
            h();
        }
        return this.d.b;
    }

    @Override // com.sigmob.sdk.videocache.u
    public void a(long offset) throws q {
        try {
            HttpURLConnection httpURLConnectionA = a(offset, 3000);
            this.e = httpURLConnectionA;
            String contentType = httpURLConnectionA.getContentType();
            this.f = new BufferedInputStream(this.e.getInputStream(), 8192);
            HttpURLConnection httpURLConnection = this.e;
            v vVar = new v(this.d.a, a(httpURLConnection, offset, httpURLConnection.getResponseCode()), contentType);
            this.d = vVar;
            this.b.a(vVar.a, this.d);
        } catch (IOException e) {
            throw new q("Error opening connection for " + this.d.a + " with offset " + offset, e);
        }
    }

    @Override // com.sigmob.sdk.videocache.u
    public void b() throws q {
        HttpURLConnection httpURLConnection = this.e;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (ArrayIndexOutOfBoundsException e) {
                SigmobLog.e("Error closing connection correctly. Should happen only on SigmobAndroid L. Until good solution is not know, just ignore this issue :(", e);
            } catch (IllegalArgumentException e2) {
                e = e2;
                throw new RuntimeException("Wait... but why? WTF!? ", e);
            } catch (NullPointerException e3) {
                e = e3;
                throw new RuntimeException("Wait... but why? WTF!? ", e);
            }
        }
    }

    @Override // com.sigmob.sdk.videocache.u
    public synchronized String c() throws q {
        if (TextUtils.isEmpty(this.d.c)) {
            h();
        }
        return this.d.c;
    }

    @Override // com.sigmob.sdk.videocache.u
    public v d() {
        return this.d;
    }

    @Override // com.sigmob.sdk.videocache.u
    public com.sigmob.sdk.videocache.sourcestorage.c e() {
        return this.b;
    }

    @Override // com.sigmob.sdk.videocache.u
    public com.sigmob.sdk.videocache.headers.b f() {
        return this.c;
    }

    @Override // com.sigmob.sdk.videocache.u
    public String g() {
        return this.d.a;
    }

    public String toString() {
        return "HttpUrlSource{sourceInfo='" + this.d + com.alipay.sdk.m.u.i.d;
    }
}
