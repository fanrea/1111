package com.sigmob.sdk.downloader.core.connection;

import com.sigmob.sdk.downloader.core.connection.a;
import com.sigmob.sdk.downloader.i;
import com.sigmob.sdk.downloader.j;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class c implements com.sigmob.sdk.downloader.core.connection.a, a.InterfaceC0732a {
    private static final String f = "DownloadUrlConnection";
    protected URLConnection b;
    private a c;
    private URL d;
    private i e;

    public static class a {
        private Proxy a;
        private Integer b;
        private Integer c;

        public a a(int readTimeout) {
            this.b = Integer.valueOf(readTimeout);
            return this;
        }

        public a a(Proxy proxy) {
            this.a = proxy;
            return this;
        }

        public a b(int connectTimeout) {
            this.c = Integer.valueOf(connectTimeout);
            return this;
        }
    }

    public static class b implements a.b {
        private final a a;

        public b() {
            this(null);
        }

        public b(a configuration) {
            this.a = configuration;
        }

        @Override // com.sigmob.sdk.downloader.core.connection.a.b
        public com.sigmob.sdk.downloader.core.connection.a a(String originUrl) throws IOException {
            return new c(originUrl, this.a);
        }

        com.sigmob.sdk.downloader.core.connection.a a(URL url) throws IOException {
            return new c(url, this.a);
        }
    }

    /* renamed from: com.sigmob.sdk.downloader.core.connection.c$c, reason: collision with other inner class name */
    static final class C0733c implements i {
        String a;

        C0733c() {
        }

        @Override // com.sigmob.sdk.downloader.i
        public String a() {
            return this.a;
        }

        @Override // com.sigmob.sdk.downloader.i
        public void a(com.sigmob.sdk.downloader.core.connection.a originalConnection, a.InterfaceC0732a originalConnected, Map<String, List<String>> headerProperties) throws IOException {
            c cVar = (c) originalConnection;
            int i = 0;
            for (int iD = originalConnected.d(); j.a(iD); iD = cVar.d()) {
                cVar.b();
                i++;
                if (i > 10) {
                    throw new ProtocolException("Too many redirect requests: " + i);
                }
                String strA = j.a(originalConnected, iD);
                this.a = strA;
                URI uriCreate = URI.create(strA);
                if (uriCreate != null && !uriCreate.isAbsolute()) {
                    try {
                        this.a = ((c) originalConnection).d.toURI().resolve(uriCreate).toString();
                    } catch (Throwable unused) {
                    }
                }
                cVar.d = new URL(this.a);
                cVar.h();
                com.sigmob.sdk.downloader.core.c.b(headerProperties, cVar);
                cVar.b.connect();
            }
        }
    }

    public c(String originUrl) throws IOException {
        this(originUrl, (a) null);
    }

    public c(String originUrl, a configuration) throws IOException {
        this(new URL(originUrl), configuration);
    }

    public c(URL url, a configuration) throws IOException {
        this(url, configuration, new C0733c());
    }

    public c(URL url, a configuration, i redirectHandler) throws IOException {
        this.c = configuration;
        this.d = url;
        this.e = redirectHandler;
        h();
    }

    c(URLConnection connection) {
        this(connection, new C0733c());
    }

    c(URLConnection connection, i redirectHandler) {
        this.b = connection;
        this.d = connection.getURL();
        this.e = redirectHandler;
    }

    @Override // com.sigmob.sdk.downloader.core.connection.a
    public a.InterfaceC0732a a() throws IOException {
        Map<String, List<String>> mapC = c();
        this.b.connect();
        this.e.a(this, this, mapC);
        return this;
    }

    @Override // com.sigmob.sdk.downloader.core.connection.a
    public void a(String name, String value) {
        this.b.addRequestProperty(name, value);
    }

    @Override // com.sigmob.sdk.downloader.core.connection.a
    public boolean a(String method) throws ProtocolException {
        URLConnection uRLConnection = this.b;
        if (!(uRLConnection instanceof HttpURLConnection)) {
            return false;
        }
        ((HttpURLConnection) uRLConnection).setRequestMethod(method);
        return true;
    }

    @Override // com.sigmob.sdk.downloader.core.connection.a
    public String b(String key) {
        return this.b.getRequestProperty(key);
    }

    @Override // com.sigmob.sdk.downloader.core.connection.a
    public void b() throws IOException {
        try {
            InputStream inputStream = this.b.getInputStream();
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (IOException | Exception unused) {
        }
    }

    @Override // com.sigmob.sdk.downloader.core.connection.a.InterfaceC0732a
    public String c(String name) {
        return this.b.getHeaderField(name);
    }

    @Override // com.sigmob.sdk.downloader.core.connection.a
    public Map<String, List<String>> c() {
        return this.b.getRequestProperties();
    }

    @Override // com.sigmob.sdk.downloader.core.connection.a.InterfaceC0732a
    public int d() throws IOException {
        URLConnection uRLConnection = this.b;
        if (uRLConnection instanceof HttpURLConnection) {
            return ((HttpURLConnection) uRLConnection).getResponseCode();
        }
        return 0;
    }

    @Override // com.sigmob.sdk.downloader.core.connection.a.InterfaceC0732a
    public InputStream e() throws IOException {
        return this.b.getInputStream();
    }

    @Override // com.sigmob.sdk.downloader.core.connection.a.InterfaceC0732a
    public Map<String, List<String>> f() {
        return this.b.getHeaderFields();
    }

    @Override // com.sigmob.sdk.downloader.core.connection.a.InterfaceC0732a
    public String g() {
        return this.e.a();
    }

    void h() throws IOException {
        com.sigmob.sdk.downloader.core.c.b(f, "config connection for " + this.d);
        a aVar = this.c;
        this.b = (aVar == null || aVar.a == null) ? this.d.openConnection() : this.d.openConnection(this.c.a);
        URLConnection uRLConnection = this.b;
        if (uRLConnection instanceof HttpURLConnection) {
            ((HttpURLConnection) uRLConnection).setInstanceFollowRedirects(false);
        }
        a aVar2 = this.c;
        if (aVar2 != null) {
            if (aVar2.b != null) {
                this.b.setReadTimeout(this.c.b.intValue());
            }
            if (this.c.c != null) {
                this.b.setConnectTimeout(this.c.c.intValue());
            }
        }
    }
}
