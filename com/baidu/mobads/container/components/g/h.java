package com.baidu.mobads.container.components.g;

import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.mobads.container.components.g.k;
import com.baidu.mobads.container.util.bq;
import com.baidu.mobads.container.util.o;
import com.just.agentweb.AgentWebPermissions;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class h implements d {
    public static final String a = h.class.getSimpleName();
    private static final int b = -1;
    private HttpURLConnection c;
    private bq d = bq.a();
    private final e e;
    private final i f;
    private boolean g;
    private com.baidu.mobads.container.components.g.a h;

    public h(e eVar, i iVar) {
        this.e = eVar;
        this.f = iVar;
    }

    @Override // com.baidu.mobads.container.components.g.d
    public i a() {
        return this.f;
    }

    @Override // com.baidu.mobads.container.components.g.d
    public k b() {
        synchronized (this) {
            if (this.g) {
                throw new IllegalStateException("Already Executed");
            }
            this.g = true;
        }
        try {
            this.e.b().a(this);
            h();
            k kVarG = g();
            int iH = kVarG.h();
            if (iH / 100 == 2) {
                return kVarG;
            }
            if (iH != 416) {
                this.c.getResponseMessage().contains("Range Not Satisfiable");
            }
            return null;
        } catch (Throwable th) {
            try {
                this.d.c(a, th);
                return null;
            } finally {
                this.e.b().b(this);
            }
        }
    }

    @Override // com.baidu.mobads.container.components.g.d
    public void d() {
        if (this.c != null) {
            this.c.disconnect();
        }
    }

    @Override // com.baidu.mobads.container.components.g.d
    public void a(com.baidu.mobads.container.components.g.a aVar) {
        synchronized (this) {
            if (this.g) {
                throw new IllegalStateException("Already Executed");
            }
            this.g = true;
        }
        this.h = aVar;
        this.e.b().a(new a());
    }

    @Override // com.baidu.mobads.container.components.g.d
    public boolean c() {
        return this.g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (!TextUtils.isEmpty(this.f.a()) && o.g(this.f.a())) {
            try {
                this.c = o.a(new URL(this.f.a()));
                this.c.setConnectTimeout(this.f.e());
                this.c.setReadTimeout(this.f.f());
                if (Integer.parseInt(Build.VERSION.SDK) < 8) {
                    System.setProperty("http.keepAlive", "false");
                }
                this.c.setRequestMethod(this.f.b());
                this.c.setUseCaches(this.f.g());
                this.c.setInstanceFollowRedirects(false);
                if (!TextUtils.isEmpty(this.f.h())) {
                    this.c.setRequestProperty("User-Agent", this.f.h());
                }
                this.c.setRequestProperty("Content-type", this.f.d());
                this.c.setRequestProperty("Connection", "keep-alive");
                this.c.setRequestProperty("Cache-Control", "no-cache");
                a(this.f.i());
                if ("POST".equals(this.f.b())) {
                    this.c.setDoInput(true);
                    this.c.setDoOutput(true);
                    if (!TextUtils.isEmpty(this.f.c())) {
                        Uri.Builder builder = new Uri.Builder();
                        builder.encodedQuery(this.f.c());
                        a(builder.build().getEncodedQuery(), this.c);
                        return;
                    }
                    return;
                }
                return;
            } catch (Throwable th) {
                if (this.h != null) {
                    this.h.a("Net Create RuntimeError: " + th.getMessage(), 0);
                    return;
                }
                return;
            }
        }
        if (this.h != null) {
            this.h.a(this.f.a(), -1);
        }
    }

    private void a(String str, HttpURLConnection httpURLConnection) throws Throwable {
        OutputStream outputStream;
        BufferedWriter bufferedWriter;
        BufferedWriter bufferedWriter2 = null;
        try {
            outputStream = httpURLConnection.getOutputStream();
            try {
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
            outputStream = null;
        }
        try {
            bufferedWriter.write(str);
            bufferedWriter.flush();
            bufferedWriter.close();
            if (outputStream != null) {
                outputStream.close();
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedWriter2 = bufferedWriter;
            if (bufferedWriter2 != null) {
                bufferedWriter2.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
            throw th;
        }
    }

    public String e() throws IOException {
        InputStream inputStream = null;
        try {
            inputStream = this.c.getInputStream();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Math.max(this.c.getContentLength(), 32));
            byte[] bArr = new byte[128];
            while (true) {
                int i = inputStream.read(bArr);
                if (i == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, i);
            }
            byteArrayOutputStream.flush();
            return byteArrayOutputStream.toString();
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    public void a(Map<String, String> map) {
        if (this.c != null && map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                this.c.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
    }

    private HttpURLConnection a(HttpURLConnection httpURLConnection) throws IOException {
        HttpURLConnection httpURLConnection2;
        Exception e;
        while (true) {
            try {
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode != 302 && responseCode != 301) {
                    return httpURLConnection;
                }
                httpURLConnection2 = (HttpURLConnection) new URL(httpURLConnection.getHeaderField(AgentWebPermissions.ACTION_LOCATION)).openConnection();
                try {
                    httpURLConnection2.setConnectTimeout(httpURLConnection2.getConnectTimeout());
                    httpURLConnection2.setInstanceFollowRedirects(false);
                    httpURLConnection2.setRequestProperty("Range", "bytes=0-");
                    httpURLConnection = httpURLConnection2;
                } catch (Exception e2) {
                    e = e2;
                    this.d.a(a, e);
                    return httpURLConnection2;
                }
            } catch (Exception e3) {
                httpURLConnection2 = httpURLConnection;
                e = e3;
            }
        }
    }

    public void f() throws IOException {
        if (this.c != null) {
            try {
                InputStream inputStream = this.c.getInputStream();
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (Exception e) {
                this.d.c(a, e.toString());
            }
        }
    }

    k g() throws IOException {
        int responseCode;
        if (this.c != null) {
            while (true) {
                URL url = this.c.getURL();
                if (a(url.toString())) {
                    throw new IllegalArgumentException(url.toString());
                }
                this.c.connect();
                responseCode = this.c.getResponseCode();
                if (responseCode == 302 || responseCode == 301) {
                    this.c = (HttpURLConnection) b(this.c).openConnection();
                    this.c.setConnectTimeout(this.f.e());
                    this.c.setReadTimeout(this.f.f());
                    this.c.setInstanceFollowRedirects(false);
                    this.c.setRequestProperty("Range", "bytes=0-");
                } else if (responseCode / 100 == 2) {
                    k.a aVarB = new k.a().a(this.c.getInputStream()).a(this.f).a(this.c.getContentLength()).a(this.c.getContentType()).b(responseCode).b(this.c.getURL().toString());
                    if (Build.VERSION.SDK_INT >= 24) {
                        aVarB.a(this.c.getContentLengthLong());
                    }
                    return aVarB.a();
                }
            }
        } else {
            responseCode = -1;
        }
        return new k.a().b(responseCode).a();
    }

    private boolean a(String str) {
        return !o.g(str);
    }

    private URL b(HttpURLConnection httpURLConnection) {
        String headerField = httpURLConnection.getHeaderField(AgentWebPermissions.ACTION_LOCATION);
        try {
            return new URL(headerField);
        } catch (Exception e) {
            this.d.a(a, e);
            URL url = httpURLConnection.getURL();
            if (headerField.startsWith("/")) {
                headerField = a(url.getProtocol(), url.getHost(), url.getPort(), headerField);
            }
            return new URL(headerField);
        }
    }

    private String a(String str, String str2, int i, String str3) {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            if (!str.endsWith("://")) {
                sb.append("://");
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            sb.append(str2);
        }
        if (i > 0) {
            sb.append(":").append(i);
        }
        if (!TextUtils.isEmpty(str3)) {
            if (!str3.startsWith("/")) {
                sb.append("/");
            }
            sb.append(str3);
        }
        return sb.toString();
    }

    class a implements Runnable {
        private volatile AtomicInteger b = new AtomicInteger(0);
        private String c = "";
        private String d;

        a() {
        }

        d a() {
            return h.this;
        }

        AtomicInteger b() {
            return this.b;
        }

        void a(a aVar) {
            this.b = aVar.b;
        }

        String c() {
            if (TextUtils.isEmpty(this.c) && h.this.f != null && !TextUtils.isEmpty(h.this.f.a())) {
                try {
                    this.c = new URL(h.this.f.a()).getHost();
                } catch (Throwable th) {
                    h.this.d.d(h.a, th);
                }
            }
            return this.c;
        }

        void a(ExecutorService executorService) {
            try {
                try {
                    executorService.execute(this);
                } catch (RejectedExecutionException e) {
                    InterruptedIOException interruptedIOException = new InterruptedIOException("executor rejected");
                    interruptedIOException.initCause(e);
                    if (h.this.h != null) {
                        h.this.h.a("Execute loader error: " + interruptedIOException.toString(), 0);
                    }
                    if (h.this.e != null) {
                        h.this.e.b().b(this);
                    }
                }
            } catch (Throwable th) {
                if (h.this.e != null) {
                    h.this.e.b().b(this);
                }
                throw th;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            String name = Thread.currentThread().getName();
            Thread.currentThread().setName(e());
            try {
                h.this.h();
                d();
            } finally {
                Thread.currentThread().setName(name);
            }
        }

        private void d() {
            try {
                try {
                } catch (IllegalArgumentException e) {
                    if (h.this.h != null) {
                        h.this.h.a(e.getMessage(), -1);
                    }
                    if (h.this.c != null) {
                        h.this.c.disconnect();
                    }
                    if (h.this.e == null) {
                        return;
                    }
                } catch (SocketTimeoutException e2) {
                    if (h.this.h != null) {
                        h.this.h.a("Net Connect Timeout: " + e2.toString(), 1);
                    }
                    if (h.this.c != null) {
                        h.this.c.disconnect();
                    }
                    if (h.this.e == null) {
                        return;
                    }
                } catch (Exception e3) {
                    if (h.this.h != null) {
                        h.this.h.a("Net Connect RuntimeError: " + e3.toString(), 0);
                    }
                    if (h.this.c != null) {
                        h.this.c.disconnect();
                    }
                    if (h.this.e == null) {
                        return;
                    }
                }
                if (h.this.c == null) {
                    if (h.this.c != null) {
                        h.this.c.disconnect();
                    }
                    if (h.this.e != null) {
                        h.this.e.b().b(this);
                        return;
                    }
                    return;
                }
                k kVarG = h.this.g();
                int iH = kVarG.h();
                if (iH / 100 == 2) {
                    if (h.this.h != null) {
                        h.this.h.a(h.this, kVarG);
                    }
                } else if (h.this.h != null) {
                    h.this.h.a(h.this.c.getResponseMessage(), iH);
                }
                if (h.this.c != null) {
                    h.this.c.disconnect();
                }
                if (h.this.e == null) {
                    return;
                }
                h.this.e.b().b(this);
            } catch (Throwable th) {
                if (h.this.c != null) {
                    h.this.c.disconnect();
                }
                if (h.this.e != null) {
                    h.this.e.b().b(this);
                }
                throw th;
            }
        }

        private String e() {
            if (TextUtils.isEmpty(this.d)) {
                this.d = "AsyncLoader " + c() + "/...";
            }
            return this.d;
        }
    }
}
