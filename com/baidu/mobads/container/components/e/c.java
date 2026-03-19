package com.baidu.mobads.container.components.e;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.mobads.container.components.command.i;
import com.baidu.mobads.container.components.e.b;
import com.baidu.mobads.container.util.ab;
import com.baidu.mobads.container.util.ap;
import com.baidu.mobads.container.util.bq;
import com.baidu.mobads.container.util.bw;
import com.baidu.mobads.container.util.o;
import com.baidu.mobads.container.util.x;
import com.bytedance.sdk.djx.core.log.ILogConst;
import com.just.agentweb.AgentWebPermissions;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Observable;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class c extends Observable implements b, Runnable {
    protected static final int o = 102400;
    protected static final int p = 102400;
    protected static final int q = 5120000;
    private static final String r = "Downloader";
    protected Context a;
    protected URL b;
    protected URL c;
    protected String d;
    protected int e;
    protected String g;
    protected long h;
    protected volatile b.a i;
    protected volatile long j;
    protected int k;
    protected ArrayList<a> m;
    private String s;
    private String t;
    private com.baidu.mobads.container.components.command.i v;
    private volatile int w;
    private volatile String y;
    protected Boolean f = true;
    private int u = 4;
    private boolean x = false;
    private boolean z = false;
    h n = null;
    private boolean A = false;

    public c(Context context, URL url, String str, String str2, int i, String str3) {
        this.a = context;
        this.b = url;
        this.d = str;
        this.e = i;
        if (str2 != null && str2.trim().length() > 0) {
            this.g = str2;
        } else {
            String file = url.getFile();
            this.g = file.substring(file.lastIndexOf(47) + 1);
        }
        this.h = -1L;
        this.i = b.a.NONE;
        this.j = 0L;
        this.k = 0;
        this.t = str3;
        this.m = new ArrayList<>();
    }

    @Override // com.baidu.mobads.container.components.e.b
    public void a(boolean z) {
        if (this.v == null && z) {
            this.v = new com.baidu.mobads.container.components.command.i();
            this.v.a((i.a) new d(this));
        }
        this.x = z;
    }

    @Override // com.baidu.mobads.container.components.e.b
    public void d() {
        bq.a().a(r, "execute Start; state = " + this.i);
        if (this.i == b.a.NONE) {
            a(b.a.INITING);
            b(true);
            com.baidu.mobads.container.d.b.a().a(this, 3);
        }
    }

    @Override // com.baidu.mobads.container.components.e.b
    public void a(int i) {
        try {
            bq.a().a(r, "execute Pause; state = " + this.i);
            if (this.i == b.a.DOWNLOADING || this.i == b.a.ERROR || this.i == b.a.NONE) {
                if (this.m != null) {
                    for (int i2 = 0; i2 < this.m.size(); i2++) {
                        if (!this.m.get(i2).c()) {
                            this.m.get(i2).a_();
                        }
                    }
                }
                this.u = i;
                a(b.a.PAUSED);
                j();
            }
        } catch (Exception e) {
            bq.a().a(r, "pause exception");
        }
    }

    @Override // com.baidu.mobads.container.components.e.b
    public void c() {
        try {
            bq.a().a(r, "execute Resume; state = " + this.i);
            if (this.i == b.a.PAUSED || this.i == b.a.ERROR || this.i == b.a.CANCELLED) {
                a(b.a.INITING);
                b(true);
                com.baidu.mobads.container.d.b.a().a(this, 3);
            }
        } catch (Exception e) {
            bq.a().a(r, "resume exception");
        }
    }

    @Override // com.baidu.mobads.container.components.e.b
    public void b() {
        try {
            b.a aVarI = i();
            a(b.a.CANCELLED);
            bq.a().a(r, "execute Cancel; state = " + aVarI);
            if (aVarI == b.a.INITING || aVarI == b.a.DOWNLOADING || aVarI == b.a.PAUSED) {
                if (this.m != null) {
                    for (int i = 0; i < this.m.size(); i++) {
                        if (!this.m.get(i).d()) {
                            this.m.get(i).a_();
                        }
                    }
                }
                j();
            }
            com.baidu.mobads.container.d.b.a().a(new e(this), 2);
        } catch (Exception e) {
            bq.a().a(r, "cancel exception");
        }
    }

    @Override // com.baidu.mobads.container.components.e.b
    public String e() {
        return this.b.toString();
    }

    @Override // com.baidu.mobads.container.components.e.b
    public String t() {
        if (this.c == null) {
            return null;
        }
        return this.c.toString();
    }

    @Override // com.baidu.mobads.container.components.e.b
    public boolean v() {
        return this.z;
    }

    @Override // com.baidu.mobads.container.components.e.b
    public void c(boolean z) {
        this.z = z;
    }

    @Override // com.baidu.mobads.container.components.e.b
    public int f() {
        if (this.h > 2147483647L) {
            return -1;
        }
        return (int) this.h;
    }

    @Override // com.baidu.mobads.container.components.e.b
    public long g() {
        return this.h;
    }

    @Override // com.baidu.mobads.container.components.e.b
    public float h() {
        float fAbs = Math.abs((this.j / this.h) * 100.0f);
        if (this.x && this.v != null) {
            return this.v.a(fAbs);
        }
        return fAbs;
    }

    @Override // com.baidu.mobads.container.components.e.b
    public void s() {
        deleteObservers();
    }

    @Override // com.baidu.mobads.container.components.e.b
    public String r() {
        return this.t;
    }

    @Override // com.baidu.mobads.container.components.e.b
    public b.a i() {
        return this.i;
    }

    @Override // com.baidu.mobads.container.components.e.b
    public String l() {
        return this.d + this.g;
    }

    @Override // com.baidu.mobads.container.components.e.b
    public String m() {
        return this.d;
    }

    @Override // com.baidu.mobads.container.components.e.b
    public String n() {
        return this.g;
    }

    protected void a(b.a aVar) {
        this.i = aVar;
        k();
    }

    @Override // com.baidu.mobads.container.components.e.b
    public boolean u() {
        return this.A;
    }

    @Override // com.baidu.mobads.container.components.e.b
    public void b(boolean z) {
        this.A = z;
    }

    protected synchronized void b(int i) {
        this.j += i;
        int iH = (int) h();
        if (this.k < iH) {
            this.k = iH;
            k();
        }
    }

    protected void a() {
        if (this.x && this.v != null) {
            this.v.b(this.w);
        }
    }

    protected void j() {
        if (this.v != null) {
            this.v.a_();
        }
    }

    protected synchronized void c(int i) {
        if (this.w < i) {
            this.w = i;
            if (this.x) {
                k();
            }
        }
    }

    protected void a(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
        } catch (Throwable th) {
            bq.a().a(r, th);
        }
    }

    protected void k() {
        setChanged();
        notifyObservers();
    }

    protected synchronized void q() {
        this.i = b.a.ERROR;
        for (int i = 0; i < this.m.size(); i++) {
            if (!this.m.get(i).c()) {
                this.m.get(i).a_();
            }
        }
        j();
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0257  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0285  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x028d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void a(java.net.HttpURLConnection r35) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1040
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.container.components.e.c.a(java.net.HttpURLConnection):void");
    }

    @Override // java.lang.Runnable
    public void run() {
        HttpURLConnection httpURLConnectionA = null;
        if (this.c != null && this.h >= 1) {
            try {
                a((HttpURLConnection) null);
                return;
            } catch (Exception e) {
                a(e);
                a(b.a.ERROR);
                bq.a().a(r, e);
                return;
            }
        }
        try {
            try {
            } catch (Exception e2) {
                a(e2);
                a(b.a.ERROR);
                if (0 == 0) {
                    return;
                }
            }
            if (o.g(this.b.toString())) {
                httpURLConnectionA = o.a(this.b);
                httpURLConnectionA.setRequestProperty("Range", "bytes=0-");
                if ("m.baidu.com".equals(this.b.getHost())) {
                    httpURLConnectionA.setRequestProperty("X-Requested-With2", com.baidu.mobads.container.config.b.a().i());
                }
                httpURLConnectionA.setConnectTimeout(10000);
                httpURLConnectionA.setInstanceFollowRedirects(true);
                httpURLConnectionA.connect();
                int responseCode = httpURLConnectionA.getResponseCode();
                if (responseCode == 302 || responseCode == 301) {
                    httpURLConnectionA.setInstanceFollowRedirects(false);
                    httpURLConnectionA = b(httpURLConnectionA);
                    responseCode = httpURLConnectionA.getResponseCode();
                }
                if (responseCode / 100 != 2) {
                    b("response code error: " + responseCode);
                    a(b.a.ERROR);
                    if (httpURLConnectionA != null) {
                        httpURLConnectionA.disconnect();
                        return;
                    }
                    return;
                }
                String contentType = httpURLConnectionA.getContentType();
                if (contentType.equals("text/html")) {
                    b("content type error: " + contentType);
                    a(b.a.ERROR);
                    if (httpURLConnectionA != null) {
                        httpURLConnectionA.disconnect();
                        return;
                    }
                    return;
                }
                long contentLengthLong = x.a(this.a).a() >= 24 ? httpURLConnectionA.getContentLengthLong() : httpURLConnectionA.getContentLength();
                if (contentLengthLong < 1) {
                    b("content length is " + contentLengthLong);
                    a(b.a.ERROR);
                    if (httpURLConnectionA != null) {
                        httpURLConnectionA.disconnect();
                        return;
                    }
                    return;
                }
                if (contentLengthLong < 5120000) {
                    this.e = 1;
                }
                this.c = httpURLConnectionA.getURL();
                if (!com.component.c.c.a()) {
                    b("external storage state error: " + com.component.c.c.b());
                    a(b.a.ERROR);
                    if (httpURLConnectionA != null) {
                        httpURLConnectionA.disconnect();
                        return;
                    }
                    return;
                }
                String strI = bw.i(this.a);
                String str = ap.a(this.c.toString()) + ".apk";
                this.d = strI;
                this.g = str;
                File file = new File(strI + str);
                if (file.exists() && file.length() > 0) {
                    a(b.a.COMPLETED);
                    if (httpURLConnectionA != null) {
                        httpURLConnectionA.disconnect();
                        return;
                    }
                    return;
                }
                if (httpURLConnectionA.getHeaderField("Content-Range") == null && (httpURLConnectionA.getHeaderField("Accept-Ranges") == null || httpURLConnectionA.getHeaderField("Accept-Ranges").equalsIgnoreCase("none"))) {
                    this.f = false;
                    this.e = 1;
                }
                if (this.h == -1) {
                    this.h = contentLengthLong;
                }
                a(httpURLConnectionA);
                if (httpURLConnectionA == null) {
                    return;
                }
                httpURLConnectionA.disconnect();
            }
        } catch (Throwable th) {
            if (0 != 0) {
                httpURLConnectionA.disconnect();
            }
            throw th;
        }
    }

    protected void a(ArrayList<a> arrayList) {
        ab.a(this.d + this.g + ".tmp", this.d + this.g);
    }

    protected class a extends com.baidu.mobads.container.d.a {
        public static final String a = "DownloadThread";
        protected int b;
        protected URL c;
        protected String d;
        protected long e;
        protected long f;
        protected long g;
        private volatile boolean n;
        private HttpURLConnection o;
        private volatile boolean j = false;
        private volatile int k = 0;
        private final Object m = new Object();
        protected boolean h = false;

        public a(int i, URL url, String str, long j, long j2, long j3) {
            this.b = i;
            this.c = url;
            this.d = str;
            this.e = j;
            this.f = j2;
            this.g = j3;
        }

        public boolean c() {
            return this.h;
        }

        public boolean d() {
            return this.n;
        }

        public synchronized void e() {
            this.j = false;
            this.n = true;
            com.baidu.mobads.container.d.b.a().a((com.baidu.mobads.container.d.a) this, 3);
        }

        @Override // com.baidu.mobads.container.d.a
        public synchronized void a_() {
            this.j = true;
            this.k++;
        }

        public void a(HttpURLConnection httpURLConnection) {
            this.o = httpURLConnection;
        }

        public void f() {
            synchronized (this.m) {
                while (this.n && !i()) {
                    this.m.wait(10L);
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:71:0x020b, code lost:
        
            r7 = r17;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:123:0x02da A[Catch: all -> 0x0354, TRY_LEAVE, TryCatch #15 {all -> 0x0354, blocks: (B:121:0x02c9, B:123:0x02da), top: B:169:0x02c9 }] */
        /* JADX WARN: Removed duplicated region for block: B:153:0x03c3  */
        /* JADX WARN: Removed duplicated region for block: B:157:0x03a8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:163:0x038d A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:167:0x031a A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:171:0x0335 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:92:0x028a A[PHI: r7
  0x028a: PHI (r7v8 java.net.HttpURLConnection) = (r7v7 java.net.HttpURLConnection), (r7v26 java.net.HttpURLConnection) binds: [B:135:0x034e, B:91:0x0288] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Type inference failed for: r8v4 */
        @Override // com.baidu.mobads.container.d.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.Object a() throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 971
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.container.components.e.c.a.a():java.lang.Object");
        }
    }

    private HttpURLConnection b(HttpURLConnection httpURLConnection) throws IOException {
        while (true) {
            try {
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode != 302 && responseCode != 301) {
                    return httpURLConnection;
                }
                this.b = new URL(httpURLConnection.getHeaderField(AgentWebPermissions.ACTION_LOCATION));
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) this.b.openConnection();
                try {
                    httpURLConnection2.setConnectTimeout(10000);
                    httpURLConnection2.setInstanceFollowRedirects(false);
                    httpURLConnection2.setRequestProperty("Range", "bytes=0-");
                    httpURLConnection = httpURLConnection2;
                } catch (Exception e) {
                    return httpURLConnection2;
                }
            } catch (Exception e2) {
                return httpURLConnection;
            }
        }
    }

    @Override // com.baidu.mobads.container.components.e.b
    public String o() {
        return this.y;
    }

    @Override // com.baidu.mobads.container.components.e.b
    public int p() {
        return this.u;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Throwable th) {
        try {
            String stackTraceString = Log.getStackTraceString(th);
            if (TextUtils.isEmpty(stackTraceString)) {
                stackTraceString = ILogConst.CACHE_PLAY_REASON_NULL;
            }
            this.y = "exception: " + stackTraceString.substring(0, Math.min(stackTraceString.length(), 256));
        } catch (Throwable th2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        if (TextUtils.isEmpty(this.y)) {
            this.y = str;
        }
    }
}
