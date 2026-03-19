package com.bytedance.sdk.component.hc.d.d.hc;

import android.text.TextUtils;
import com.bytedance.sdk.component.b.hc.zw;
import com.bytedance.sdk.component.hc.d.cb;
import com.bytedance.sdk.component.hc.d.e;
import com.bytedance.sdk.component.hc.d.k;
import com.bytedance.sdk.component.hc.d.tt;
import com.bytedance.sdk.component.utils.mq;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d implements com.bytedance.sdk.component.hc.d.hc {
    private volatile boolean an;
    k d;
    c hc;
    private AtomicBoolean u = new AtomicBoolean(false);
    final String b = com.bytedance.sdk.component.hc.d.hc.c.d(UUID.randomUUID().toString()).d();
    zw c = new zw();

    d(k kVar, c cVar) {
        this.d = kVar;
        this.hc = cVar;
    }

    @Override // com.bytedance.sdk.component.hc.d.hc
    public void d(com.bytedance.sdk.component.hc.d.b bVar) {
        try {
            synchronized (this) {
                if (this.an) {
                    throw new IllegalStateException("Already Executed");
                }
                this.an = true;
            }
            this.hc.d(new C0279d(bVar, this));
        } catch (Throwable th) {
            if (bVar != null) {
                bVar.onFailure(this, new IOException(th.getMessage()));
            }
        }
    }

    @Override // com.bytedance.sdk.component.hc.d.hc
    public cb d() throws IOException {
        synchronized (this) {
            if (this.an) {
                throw new IllegalStateException("Already Executed");
            }
            this.an = true;
        }
        try {
            this.hc.d(this);
            return c();
        } finally {
            this.hc.hc(this);
        }
    }

    public cb c() {
        if (this.u.get()) {
            return null;
        }
        try {
            if (this.d.d != null && this.d.d.d != null && this.d.d.d.size() > 0) {
                ArrayList arrayList = new ArrayList(this.d.d.d);
                arrayList.add(new tt() { // from class: com.bytedance.sdk.component.hc.d.d.hc.d.1
                    @Override // com.bytedance.sdk.component.hc.d.tt
                    public cb d(tt.d dVar) throws IOException {
                        return d.this.d(dVar.d());
                    }
                });
                return ((tt) arrayList.get(0)).d(new hc(arrayList, this.d));
            }
            return d(this.d);
        } catch (Throwable unused) {
            return null;
        }
    }

    public cb d(k kVar) throws IOException {
        try {
            zw zwVar = this.c;
            if (zwVar != null) {
                zwVar.hc();
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(kVar.hc().d().toString()).openConnection();
            if (kVar.c() != null && kVar.c().size() > 0) {
                for (Map.Entry<String, List<String>> entry : kVar.c().entrySet()) {
                    Iterator<String> it = entry.getValue().iterator();
                    while (it.hasNext()) {
                        httpURLConnection.addRequestProperty(entry.getKey(), it.next());
                    }
                }
            }
            if (kVar.d != null) {
                if (kVar.d.b != null) {
                    httpURLConnection.setConnectTimeout((int) kVar.d.b.toMillis(kVar.d.hc));
                }
                if (kVar.d.u != null) {
                    httpURLConnection.setReadTimeout((int) kVar.d.u.toMillis(kVar.d.c));
                }
            }
            if (kVar.an() == null) {
                httpURLConnection.setRequestMethod("GET");
            } else {
                if (!an() && kVar.an().b != null) {
                    httpURLConnection.addRequestProperty("Content-Type", kVar.an().b.toString());
                }
                httpURLConnection.setRequestMethod(kVar.b());
                if (d(kVar.an())) {
                    d(httpURLConnection);
                }
                if ("POST".equalsIgnoreCase(kVar.b())) {
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    if (b(kVar.an())) {
                        outputStream.write(kVar.an().c.getBytes());
                    } else if (d(kVar.an())) {
                        d(kVar.an().u, outputStream, kVar.an().hc(), kVar.an().d());
                    } else if (hc(kVar.an())) {
                        outputStream.write(kVar.an().u);
                    }
                    outputStream.flush();
                    outputStream.close();
                }
            }
            httpURLConnection.connect();
            long jCurrentTimeMillis = System.currentTimeMillis();
            zw zwVar2 = this.c;
            if (zwVar2 != null) {
                zwVar2.b();
                this.c.d(jCurrentTimeMillis);
            }
            httpURLConnection.getResponseCode();
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            if (this.u.get()) {
                httpURLConnection.disconnect();
                return null;
            }
            an anVar = new an(httpURLConnection, kVar);
            anVar.c = jCurrentTimeMillis;
            anVar.b = jCurrentTimeMillis2;
            zw zwVar3 = this.c;
            if (zwVar3 != null) {
                zwVar3.hc(jCurrentTimeMillis2);
            }
            anVar.u = this.c;
            return anVar;
        } catch (Exception e) {
            throw new IOException(e);
        }
    }

    private void d(HttpURLConnection httpURLConnection) {
        if (httpURLConnection == null) {
            return;
        }
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + this.b);
    }

    private void d(byte[] bArr, OutputStream outputStream, String str, String str2) throws IOException {
        if (bArr == null || outputStream == null) {
            return;
        }
        PrintWriter printWriter = new PrintWriter((Writer) new OutputStreamWriter(outputStream, "UTF-8"), true);
        printWriter.append((CharSequence) ("--" + this.b)).append((CharSequence) "\r\n");
        printWriter.append((CharSequence) ("Content-Disposition: form-data; name=\"" + str + "\"; filename=\"" + str2 + "\"")).append((CharSequence) "\r\n");
        printWriter.append((CharSequence) "Content-Type: multipart/form-data").append((CharSequence) "\r\n");
        printWriter.append((CharSequence) ("Content-Length: " + bArr.length)).append((CharSequence) "\r\n");
        printWriter.append((CharSequence) "\r\n");
        printWriter.flush();
        outputStream.write(bArr);
        printWriter.append((CharSequence) "\r\n");
        printWriter.append((CharSequence) ("--" + this.b + "--")).append((CharSequence) "\r\n");
        printWriter.flush();
        printWriter.close();
    }

    private boolean d(e eVar) {
        k kVar;
        return eVar != null && (kVar = this.d) != null && "POST".equalsIgnoreCase(kVar.b()) && eVar.an == e.d.FILE_TYPE && eVar.u != null && eVar.u.length > 0;
    }

    private boolean hc(e eVar) {
        k kVar;
        return eVar != null && (kVar = this.d) != null && "POST".equalsIgnoreCase(kVar.b()) && eVar.an == e.d.BYTE_ARRAY_TYPE && eVar.u != null && eVar.u.length > 0;
    }

    private boolean b(e eVar) {
        k kVar;
        return (eVar == null || (kVar = this.d) == null || !"POST".equalsIgnoreCase(kVar.b()) || eVar.an != e.d.STRING_TYPE || TextUtils.isEmpty(eVar.c)) ? false : true;
    }

    private boolean an() {
        if (this.d.c() == null) {
            return false;
        }
        return this.d.c().containsKey("Content-Type");
    }

    @Override // com.bytedance.sdk.component.hc.d.hc
    public void hc() {
        this.u.set(true);
    }

    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public com.bytedance.sdk.component.hc.d.hc clone() {
        return new d(this.d, this.hc);
    }

    @Override // com.bytedance.sdk.component.hc.d.hc
    public boolean b() {
        return this.u.get();
    }

    /* renamed from: com.bytedance.sdk.component.hc.d.d.hc.d$d, reason: collision with other inner class name */
    final class C0279d extends com.bytedance.sdk.component.hc.d.hc.u {
        private final com.bytedance.sdk.component.hc.d.b b;
        private final d c;

        C0279d(com.bytedance.sdk.component.hc.d.b bVar, d dVar) {
            super("net-async-call", new Object[0]);
            this.b = bVar;
            this.c = dVar;
        }

        public void d() {
            d dVar = this.c;
            if (dVar == null || dVar.c == null) {
                return;
            }
            this.c.c.mk();
        }

        @Override // com.bytedance.sdk.component.hc.d.hc.u
        protected void hc() {
            try {
                d dVar = this.c;
                if (dVar != null && dVar.c != null) {
                    this.c.c.d();
                }
                cb cbVarC = d.this.c();
                if (cbVarC == null) {
                    this.b.onFailure(d.this, new IOException("response is null"));
                } else {
                    this.b.onResponse(d.this, cbVarC);
                }
            } catch (Throwable th) {
                try {
                    if (th instanceof IOException) {
                        this.b.onFailure(d.this, th);
                    } else {
                        this.b.onFailure(d.this, new IOException(th));
                    }
                    try {
                        this.c.hc.hc(this);
                    } catch (Throwable th2) {
                        mq.d(th2);
                    }
                } finally {
                    try {
                        this.c.hc.hc(this);
                    } catch (Throwable th3) {
                        mq.d(th3);
                    }
                }
            }
        }
    }
}
