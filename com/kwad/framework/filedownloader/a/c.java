package com.kwad.framework.filedownloader.a;

import com.kwad.framework.filedownloader.f.c;
import com.kwad.sdk.api.core.TLSConnectionUtils;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.j;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c implements com.kwad.framework.filedownloader.a.b {
    protected URLConnection beh;

    @Override // com.kwad.framework.filedownloader.a.b
    public final void No() {
    }

    public c(String str, a aVar) {
        this(new URL(str), aVar);
    }

    private c(URL url, a aVar) {
        if (aVar == null || aVar.bei == null) {
            this.beh = url.openConnection();
        } else {
            this.beh = url.openConnection(aVar.bei);
        }
        try {
            TLSConnectionUtils.wrapHttpURLConnection(this.beh);
        } catch (Throwable unused) {
        }
        if (aVar != null) {
            if (aVar.bej != null) {
                this.beh.setReadTimeout(aVar.bej.intValue());
            }
            if (aVar.bek != null) {
                this.beh.setConnectTimeout(aVar.bek.intValue());
            }
        }
    }

    @Override // com.kwad.framework.filedownloader.a.b
    public final void addHeader(String str, String str2) {
        this.beh.addRequestProperty(str, str2);
    }

    @Override // com.kwad.framework.filedownloader.a.b
    public final InputStream getInputStream() throws IOException {
        return ((j) ServiceProvider.get(j.class)).wrapInputStream(this.beh.getInputStream());
    }

    @Override // com.kwad.framework.filedownloader.a.b
    public final Map<String, List<String>> Nm() {
        return this.beh.getRequestProperties();
    }

    @Override // com.kwad.framework.filedownloader.a.b
    public final Map<String, List<String>> Nn() {
        return this.beh.getHeaderFields();
    }

    @Override // com.kwad.framework.filedownloader.a.b
    public final String cp(String str) {
        return this.beh.getHeaderField(str);
    }

    @Override // com.kwad.framework.filedownloader.a.b
    public final void execute() throws IOException {
        this.beh.connect();
    }

    @Override // com.kwad.framework.filedownloader.a.b
    public final int getResponseCode() throws IOException {
        URLConnection uRLConnection = this.beh;
        if (!(uRLConnection instanceof HttpURLConnection)) {
            return 0;
        }
        try {
            return ((HttpURLConnection) uRLConnection).getResponseCode();
        } catch (Throwable th) {
            throw new IOException(th);
        }
    }

    public static class b implements c.b {
        private final a bel;

        public b() {
            this(null);
        }

        private b(a aVar) {
            this.bel = null;
        }

        @Override // com.kwad.framework.filedownloader.f.c.b
        public final com.kwad.framework.filedownloader.a.b cq(String str) {
            return new c(str, this.bel);
        }
    }

    public static class a {
        private Proxy bei;
        private Integer bej;
        private Integer bek;
    }
}
