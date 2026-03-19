package com.kwad.sdk.glide.load.a;

import android.text.TextUtils;
import android.util.Log;
import com.just.agentweb.AgentWebPermissions;
import com.kwad.sdk.glide.Priority;
import com.kwad.sdk.glide.load.DataSource;
import com.kwad.sdk.glide.load.HttpException;
import com.kwad.sdk.glide.load.a.d;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class j implements d<InputStream> {
    static final b bRM = new a();
    private final com.kwad.sdk.glide.load.c.g bRN;
    private final int bRO;
    private final b bRP;
    private HttpURLConnection bRQ;
    private InputStream bRR;
    private volatile boolean bRS;

    interface b {
        HttpURLConnection a(URL url);
    }

    public j(com.kwad.sdk.glide.load.c.g gVar, int i) {
        this(gVar, i, bRM);
    }

    private j(com.kwad.sdk.glide.load.c.g gVar, int i, b bVar) {
        this.bRN = gVar;
        this.bRO = i;
        this.bRP = bVar;
    }

    @Override // com.kwad.sdk.glide.load.a.d
    public final void a(Priority priority, d.a<? super InputStream> aVar) {
        StringBuilder sb;
        long jAjA = com.kwad.sdk.glide.e.f.ajA();
        try {
            try {
                aVar.x(a(this.bRN.toURL(), 0, null, this.bRN.getHeaders()));
            } catch (IOException e) {
                if (Log.isLoggable("HttpUrlFetcher", 3)) {
                    Log.d("HttpUrlFetcher", "Failed to load data for url", e);
                }
                aVar.g(e);
                if (!Log.isLoggable("HttpUrlFetcher", 2)) {
                    return;
                } else {
                    sb = new StringBuilder("Finished http url fetcher fetch in ");
                }
            }
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                sb = new StringBuilder("Finished http url fetcher fetch in ");
                Log.v("HttpUrlFetcher", sb.append(com.kwad.sdk.glide.e.f.bq(jAjA)).toString());
            }
        } catch (Throwable th) {
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                Log.v("HttpUrlFetcher", "Finished http url fetcher fetch in " + com.kwad.sdk.glide.e.f.bq(jAjA));
            }
            throw th;
        }
    }

    private InputStream a(URL url, int i, URL url2, Map<String, String> map) throws IOException {
        while (i < 5) {
            if (url2 != null) {
                try {
                    if (url.toURI().equals(url2.toURI())) {
                        throw new HttpException("In re-direct loop");
                    }
                } catch (URISyntaxException unused) {
                }
            }
            this.bRQ = this.bRP.a(url);
            for (Map.Entry<String, String> entry : map.entrySet()) {
                this.bRQ.addRequestProperty(entry.getKey(), entry.getValue());
            }
            this.bRQ.setConnectTimeout(this.bRO);
            this.bRQ.setReadTimeout(this.bRO);
            this.bRQ.setUseCaches(false);
            this.bRQ.setDoInput(true);
            this.bRQ.setInstanceFollowRedirects(false);
            this.bRQ.connect();
            this.bRR = this.bRQ.getInputStream();
            if (this.bRS) {
                return null;
            }
            int responseCode = this.bRQ.getResponseCode();
            if (gb(responseCode)) {
                return f(this.bRQ);
            }
            if (!gc(responseCode)) {
                if (responseCode == -1) {
                    throw new HttpException(responseCode);
                }
                throw new HttpException(this.bRQ.getResponseMessage(), responseCode);
            }
            String headerField = this.bRQ.getHeaderField(AgentWebPermissions.ACTION_LOCATION);
            if (TextUtils.isEmpty(headerField)) {
                throw new HttpException("Received empty or null redirect url");
            }
            URL url3 = new URL(url, headerField);
            afU();
            i++;
            url2 = url;
            url = url3;
        }
        throw new HttpException("Too many (> 5) redirects!");
    }

    private static boolean gb(int i) {
        return i / 100 == 2;
    }

    private static boolean gc(int i) {
        return i / 100 == 3;
    }

    private InputStream f(HttpURLConnection httpURLConnection) {
        if (TextUtils.isEmpty(httpURLConnection.getContentEncoding())) {
            this.bRR = com.kwad.sdk.glide.e.c.a(httpURLConnection.getInputStream(), httpURLConnection.getContentLength());
        } else {
            if (Log.isLoggable("HttpUrlFetcher", 3)) {
                Log.d("HttpUrlFetcher", "Got non empty content encoding: " + httpURLConnection.getContentEncoding());
            }
            this.bRR = httpURLConnection.getInputStream();
        }
        return this.bRR;
    }

    @Override // com.kwad.sdk.glide.load.a.d
    public final void afU() {
        com.kwad.sdk.crash.utils.b.closeQuietly(this.bRR);
        com.kwad.sdk.crash.utils.b.closeQuietly(this.bRQ);
        this.bRQ = null;
    }

    @Override // com.kwad.sdk.glide.load.a.d
    public final void cancel() {
        this.bRS = true;
    }

    @Override // com.kwad.sdk.glide.load.a.d
    public final Class<InputStream> afT() {
        return InputStream.class;
    }

    @Override // com.kwad.sdk.glide.load.a.d
    public final DataSource afV() {
        return DataSource.REMOTE;
    }

    static class a implements b {
        a() {
        }

        @Override // com.kwad.sdk.glide.load.a.j.b
        public final HttpURLConnection a(URL url) {
            return (HttpURLConnection) url.openConnection();
        }
    }
}
