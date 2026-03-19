package com.sigmob.sdk.downloader.core.connection;

import com.sigmob.sdk.downloader.core.connection.a;
import com.sigmob.sdk.downloader.j;
import java.io.IOException;
import java.io.InputStream;
import java.net.ProtocolException;
import java.util.List;
import java.util.Map;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class b implements com.sigmob.sdk.downloader.core.connection.a, a.InterfaceC0732a {
    final OkHttpClient b;
    Response c;
    private final Request.Builder d;
    private Request e;

    public static class a implements a.b {
        private OkHttpClient.Builder a;
        private volatile OkHttpClient b;

        @Override // com.sigmob.sdk.downloader.core.connection.a.b
        public com.sigmob.sdk.downloader.core.connection.a a(String url) throws IOException {
            if (this.b == null) {
                synchronized (a.class) {
                    if (this.b == null) {
                        OkHttpClient.Builder builder = this.a;
                        this.b = builder != null ? builder.build() : new OkHttpClient();
                        this.a = null;
                    }
                }
            }
            return new b(this.b, url);
        }

        public a a(OkHttpClient.Builder builder) {
            this.a = builder;
            return this;
        }

        public OkHttpClient.Builder a() {
            if (this.a == null) {
                this.a = new OkHttpClient.Builder();
            }
            return this.a;
        }
    }

    b(OkHttpClient client, String url) {
        this(client, new Request.Builder().url(url));
    }

    b(OkHttpClient client, Request.Builder requestBuilder) {
        this.b = client;
        this.d = requestBuilder;
    }

    @Override // com.sigmob.sdk.downloader.core.connection.a
    public a.InterfaceC0732a a() throws IOException {
        Request requestBuild = this.d.build();
        this.e = requestBuild;
        this.c = this.b.newCall(requestBuild).execute();
        return this;
    }

    @Override // com.sigmob.sdk.downloader.core.connection.a
    public void a(String name, String value) {
        this.d.addHeader(name, value);
    }

    @Override // com.sigmob.sdk.downloader.core.connection.a
    public boolean a(String method) throws ProtocolException {
        this.d.method(method, null);
        return true;
    }

    @Override // com.sigmob.sdk.downloader.core.connection.a
    public String b(String key) {
        Request request = this.e;
        return request != null ? request.header(key) : this.d.build().header(key);
    }

    @Override // com.sigmob.sdk.downloader.core.connection.a
    public void b() throws IOException {
        this.e = null;
        Response response = this.c;
        if (response != null) {
            response.close();
        }
        this.c = null;
    }

    @Override // com.sigmob.sdk.downloader.core.connection.a.InterfaceC0732a
    public String c(String name) {
        Response response = this.c;
        if (response == null) {
            return null;
        }
        return response.header(name);
    }

    @Override // com.sigmob.sdk.downloader.core.connection.a
    public Map<String, List<String>> c() {
        Request requestBuild = this.e;
        if (requestBuild == null) {
            requestBuild = this.d.build();
        }
        return requestBuild.headers().toMultimap();
    }

    @Override // com.sigmob.sdk.downloader.core.connection.a.InterfaceC0732a
    public int d() throws IOException {
        Response response = this.c;
        if (response != null) {
            return response.code();
        }
        throw new IOException("Please invoke execute first!");
    }

    @Override // com.sigmob.sdk.downloader.core.connection.a.InterfaceC0732a
    public InputStream e() throws IOException {
        Response response = this.c;
        if (response == null) {
            throw new IOException("Please invoke execute first!");
        }
        ResponseBody responseBodyBody = response.body();
        if (responseBodyBody != null) {
            return responseBodyBody.byteStream();
        }
        throw new IOException("no body found on response!");
    }

    @Override // com.sigmob.sdk.downloader.core.connection.a.InterfaceC0732a
    public Map<String, List<String>> f() {
        Response response = this.c;
        if (response == null) {
            return null;
        }
        return response.headers().toMultimap();
    }

    @Override // com.sigmob.sdk.downloader.core.connection.a.InterfaceC0732a
    public String g() {
        Response responsePriorResponse = this.c.priorResponse();
        if (responsePriorResponse != null && this.c.isSuccessful() && j.a(responsePriorResponse.code())) {
            return this.c.request().url().getUrl();
        }
        return null;
    }
}
