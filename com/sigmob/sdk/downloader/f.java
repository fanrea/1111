package com.sigmob.sdk.downloader;

import android.net.Uri;
import android.util.SparseArray;
import com.sigmob.sdk.base.common.ai;
import com.sigmob.sdk.downloader.core.download.g;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class f extends com.sigmob.sdk.downloader.core.a implements Comparable<f> {
    private static final int a = 3;
    private final File A;
    private final File B;
    private File C;
    private String D;
    private File E;
    private int F;
    private final int b;
    private volatile long c;
    private final String d;
    private final Uri e;
    private final Map<String, List<String>> h;
    private com.sigmob.sdk.downloader.core.breakpoint.c i;
    private final int j;
    private final int k;
    private final int l;
    private final int m;
    private final int n;
    private final Integer o;
    private final Boolean p;
    private final boolean q;
    private final boolean r;
    private final int s;
    private volatile com.sigmob.sdk.downloader.c t;
    private volatile SparseArray<Object> u;
    private Object v;
    private final boolean w;
    private final AtomicLong x = new AtomicLong();
    private final boolean y;
    private final g.a z;

    public static class a {
        public static final int c = 4096;
        public static final int d = 16384;
        public static final int e = 65536;
        public static final int f = 2000;
        public static final boolean g = true;
        public static final int h = 1000;
        public static final boolean i = true;
        public static final boolean j = false;
        final String a;
        final Uri b;
        private volatile Map<String, List<String>> k;
        private int l;
        private int m;
        private int n;
        private int o;
        private int p;
        private boolean q;
        private int r;
        private String s;
        private boolean t;
        private boolean u;
        private Boolean v;
        private Integer w;
        private Boolean x;

        public a(String url, Uri uri) {
            this.m = 4096;
            this.n = 16384;
            this.o = 65536;
            this.p = 2000;
            this.q = true;
            this.r = 1000;
            this.t = true;
            this.u = false;
            this.a = url;
            this.b = uri;
        }

        public a(String url, File file) {
            this.m = 4096;
            this.n = 16384;
            this.o = 65536;
            this.p = 2000;
            this.q = true;
            this.r = 1000;
            this.t = true;
            this.u = false;
            this.a = url;
            this.b = Uri.fromFile(file);
        }

        public a(String url, String parentPath, String filename) {
            this(url, Uri.fromFile(new File(parentPath)));
            if (com.sigmob.sdk.downloader.core.c.a((CharSequence) filename)) {
                this.v = true;
            } else {
                this.s = filename;
            }
        }

        public a a(int connectionCount) {
            this.w = Integer.valueOf(connectionCount);
            return this;
        }

        public a a(Boolean filenameFromResponse) {
            if (!com.sigmob.sdk.downloader.core.c.b(this.b)) {
                throw new IllegalArgumentException("Uri isn't file scheme we can't let filename from response");
            }
            this.v = filenameFromResponse;
            return this;
        }

        public a a(String filename) {
            this.s = filename;
            return this;
        }

        public a a(Map<String, List<String>> headerMapFields) {
            this.k = headerMapFields;
            return this;
        }

        public a a(boolean preAllocateLength) {
            this.x = Boolean.valueOf(preAllocateLength);
            return this;
        }

        public f a() {
            return new f(this.a, this.b, this.l, this.m, this.n, this.o, this.p, this.q, this.r, this.k, this.s, this.t, this.u, this.v, this.w, this.x);
        }

        public synchronized void a(String key, String value) {
            if (this.k == null) {
                this.k = new HashMap();
            }
            List<String> arrayList = this.k.get(key);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.k.put(key, arrayList);
            }
            arrayList.add(value);
        }

        public a b(int minIntervalMillisCallbackProcess) {
            this.r = minIntervalMillisCallbackProcess;
            return this;
        }

        public a b(boolean autoCallbackToUIThread) {
            this.q = autoCallbackToUIThread;
            return this;
        }

        public a c(int priority) {
            this.l = priority;
            return this;
        }

        public a c(boolean passIfAlreadyCompleted) {
            this.t = passIfAlreadyCompleted;
            return this;
        }

        public a d(int readBufferSize) {
            if (readBufferSize < 0) {
                throw new IllegalArgumentException("Value must be positive!");
            }
            this.m = readBufferSize;
            return this;
        }

        public a d(boolean wifiRequired) {
            this.u = wifiRequired;
            return this;
        }

        public a e(int flushBufferSize) {
            if (flushBufferSize < 0) {
                throw new IllegalArgumentException("Value must be positive!");
            }
            this.n = flushBufferSize;
            return this;
        }

        public a f(int syncBufferSize) {
            if (syncBufferSize < 0) {
                throw new IllegalArgumentException("Value must be positive!");
            }
            this.o = syncBufferSize;
            return this;
        }

        public a g(int syncBufferIntervalMillis) {
            if (syncBufferIntervalMillis < 0) {
                throw new IllegalArgumentException("Value must be positive!");
            }
            this.p = syncBufferIntervalMillis;
            return this;
        }
    }

    public static class b extends com.sigmob.sdk.downloader.core.a {
        final int a;
        final String b;
        final File c;
        final String d;
        final File e;

        public b(int id) {
            this.a = id;
            this.b = "";
            this.c = g;
            this.d = null;
            this.e = g;
        }

        public b(int id, f task) {
            this.a = id;
            this.b = task.d;
            this.e = task.l();
            this.c = task.A;
            this.d = task.d();
        }

        @Override // com.sigmob.sdk.downloader.core.a
        public int c() {
            return this.a;
        }

        @Override // com.sigmob.sdk.downloader.core.a
        public String d() {
            return this.d;
        }

        @Override // com.sigmob.sdk.downloader.core.a
        public String i() {
            return this.b;
        }

        @Override // com.sigmob.sdk.downloader.core.a
        protected File k() {
            return this.c;
        }

        @Override // com.sigmob.sdk.downloader.core.a
        public File l() {
            return this.e;
        }
    }

    public static class c {
        public static long a(f task) {
            return task.z();
        }

        public static void a(f task, long lastCallbackProcessTimestamp) {
            task.a(lastCallbackProcessTimestamp);
        }

        public static void a(f task, com.sigmob.sdk.downloader.core.breakpoint.c info) {
            task.a(info);
        }
    }

    public f(String url, Uri uri, int priority, int readBufferSize, int flushBufferSize, int syncBufferSize, int syncBufferIntervalMills, boolean autoCallbackToUIThread, int minIntervalMillisCallbackProcess, Map<String, List<String>> headerMapFields, String filename, boolean passIfAlreadyCompleted, boolean wifiRequired, Boolean filenameFromResponse, Integer connectionCount, Boolean isPreAllocateLength) {
        Boolean bool;
        String name = filename;
        this.d = url;
        this.e = uri;
        this.j = priority;
        this.k = readBufferSize;
        this.l = flushBufferSize;
        this.m = syncBufferSize;
        this.n = syncBufferIntervalMills;
        this.r = autoCallbackToUIThread;
        this.s = minIntervalMillisCallbackProcess;
        this.h = headerMapFields;
        this.q = passIfAlreadyCompleted;
        this.w = wifiRequired;
        this.o = connectionCount;
        this.p = isPreAllocateLength;
        if (com.sigmob.sdk.downloader.core.c.b(uri)) {
            File file = new File(uri.getPath());
            if (filenameFromResponse != null) {
                if (filenameFromResponse.booleanValue()) {
                    if (file.exists() && file.isFile()) {
                        throw new IllegalArgumentException("If you want filename from response please make sure you provide path is directory " + file.getPath());
                    }
                    if (!com.sigmob.sdk.downloader.core.c.a((CharSequence) filename)) {
                        com.sigmob.sdk.downloader.core.c.a("DownloadTask", "Discard filename[" + name + "] because you set filenameFromResponse=true");
                        name = null;
                    }
                } else {
                    if (file.exists() && file.isDirectory() && com.sigmob.sdk.downloader.core.c.a((CharSequence) filename)) {
                        throw new IllegalArgumentException("If you don't want filename from response please make sure you have already provided valid filename or not directory path " + file.getPath());
                    }
                    if (com.sigmob.sdk.downloader.core.c.a((CharSequence) filename)) {
                        name = file.getName();
                        this.B = com.sigmob.sdk.downloader.core.c.a(file);
                    }
                    bool = filenameFromResponse;
                }
                this.B = file;
                bool = filenameFromResponse;
            } else {
                if (file.exists() && file.isDirectory()) {
                    bool = true;
                } else {
                    bool = false;
                    if (file.exists()) {
                        if (!com.sigmob.sdk.downloader.core.c.a((CharSequence) filename) && !file.getName().equals(name)) {
                            throw new IllegalArgumentException("Uri already provided filename!");
                        }
                    } else if (com.sigmob.sdk.downloader.core.c.a((CharSequence) filename)) {
                    }
                    name = file.getName();
                    file = com.sigmob.sdk.downloader.core.c.a(file);
                }
                this.B = file;
            }
            this.y = bool.booleanValue();
        } else {
            this.y = false;
            this.B = new File(uri.getPath());
        }
        if (com.sigmob.sdk.downloader.core.c.a((CharSequence) name)) {
            this.z = new g.a();
            this.A = this.B;
        } else {
            this.z = new g.a(name);
            File file2 = new File(this.B, name);
            this.C = file2;
            this.A = file2;
        }
        this.b = g.j().c().b(this);
    }

    public static void a(f[] tasks) {
        g.j().a().a((com.sigmob.sdk.downloader.core.a[]) tasks);
    }

    public static void a(f[] tasks, com.sigmob.sdk.downloader.c listener) {
        for (f fVar : tasks) {
            fVar.t = listener;
        }
        g.j().a().a(tasks);
    }

    public static b c(int id) {
        return new b(id);
    }

    public synchronized void A() {
        this.v = null;
    }

    public void B() {
        if (System.currentTimeMillis() - this.c < 500) {
            ai.a(com.sigmob.sdk.b.e(), "操作太频繁", 0).show();
        } else {
            this.c = System.currentTimeMillis();
            g.j().a().a(this);
        }
    }

    public boolean C() {
        int i = this.F;
        this.F = i + 1;
        if (i >= 3) {
            return false;
        }
        g.j().a().a(this);
        return true;
    }

    public void D() {
        g.j().a().b(this);
    }

    public void E() {
        if (System.currentTimeMillis() - this.c < 500) {
            ai.a(com.sigmob.sdk.b.e(), "操作太频繁", 0).show();
        } else {
            this.c = System.currentTimeMillis();
            g.j().a().a((com.sigmob.sdk.downloader.core.a) this);
        }
    }

    public com.sigmob.sdk.downloader.c F() {
        return this.t;
    }

    public int G() {
        return this.j;
    }

    public a H() {
        return a(this.d, this.e);
    }

    public a a(String anotherUrl, Uri anotherUri) {
        a aVarC = new a(anotherUrl, anotherUri).c(this.j).d(this.k).e(this.l).f(this.m).g(this.n).b(this.r).b(this.s).a(this.h).c(this.q);
        if (com.sigmob.sdk.downloader.core.c.b(anotherUri) && !new File(anotherUri.getPath()).isFile() && com.sigmob.sdk.downloader.core.c.b(this.e) && this.z.a() != null && !new File(this.e.getPath()).getName().equals(this.z.a())) {
            aVarC.a(this.z.a());
        }
        return aVarC;
    }

    public synchronized f a(int key, Object value) {
        if (this.u == null) {
            synchronized (this) {
                if (this.u == null) {
                    this.u = new SparseArray<>();
                }
            }
        }
        this.u.put(key, value);
        return this;
    }

    public Object a(int key) {
        if (this.u == null) {
            return null;
        }
        return this.u.get(key);
    }

    void a(long lastCallbackProcessTimestamp) {
        this.x.set(lastCallbackProcessTimestamp);
    }

    public void a(com.sigmob.sdk.downloader.c listener) {
        this.t = listener;
    }

    void a(com.sigmob.sdk.downloader.core.breakpoint.c info) {
        this.i = info;
    }

    public void a(f oldTask) {
        this.v = oldTask.v;
        this.u = oldTask.u;
    }

    public void a(Object tag) {
        this.v = tag;
    }

    public void a(String redirectUrl) {
        this.D = redirectUrl;
    }

    public boolean a() {
        return this.y;
    }

    @Override // java.lang.Comparable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public int compareTo(f o) {
        return o.G() - G();
    }

    public Map<String, List<String>> b() {
        return this.h;
    }

    public synchronized void b(int key) {
        if (this.u != null) {
            this.u.remove(key);
        }
    }

    public void b(com.sigmob.sdk.downloader.c listener) {
        this.t = listener;
        g.j().a().a(this);
    }

    @Override // com.sigmob.sdk.downloader.core.a
    public int c() {
        return this.b;
    }

    public void c(com.sigmob.sdk.downloader.c listener) {
        this.t = listener;
        g.j().a().b(this);
    }

    public b d(int id) {
        return new b(id, this);
    }

    @Override // com.sigmob.sdk.downloader.core.a
    public String d() {
        return this.z.a() + ".tmp";
    }

    public boolean e() {
        return this.q;
    }

    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        if (fVar.b == this.b) {
            return true;
        }
        return a((com.sigmob.sdk.downloader.core.a) fVar);
    }

    public boolean f() {
        return this.w;
    }

    public g.a g() {
        return this.z;
    }

    public Uri h() {
        return this.e;
    }

    public int hashCode() {
        return (this.d + this.A.toString() + this.z.a()).hashCode();
    }

    @Override // com.sigmob.sdk.downloader.core.a
    public String i() {
        return this.d;
    }

    public String j() {
        return this.D;
    }

    @Override // com.sigmob.sdk.downloader.core.a
    protected File k() {
        return this.A;
    }

    @Override // com.sigmob.sdk.downloader.core.a
    public File l() {
        return this.B;
    }

    public File m() {
        String str = this.z.a() + ".tmp";
        if (str == null) {
            return null;
        }
        if (this.E == null) {
            this.E = new File(this.B, str);
        }
        return this.E;
    }

    public File n() {
        String strA = this.z.a();
        if (strA == null) {
            return null;
        }
        if (this.C == null) {
            this.C = new File(this.B, strA);
        }
        return this.C;
    }

    public int o() {
        return this.k;
    }

    public int p() {
        return this.l;
    }

    public int q() {
        return this.m;
    }

    public int r() {
        return this.n;
    }

    public boolean s() {
        return this.r;
    }

    public int t() {
        return this.s;
    }

    public String toString() {
        return super.toString() + "@" + this.b + "@" + this.d + "@" + this.B.toString() + "/" + this.z.a();
    }

    public Integer u() {
        return this.o;
    }

    public Boolean v() {
        return this.p;
    }

    public int w() {
        com.sigmob.sdk.downloader.core.breakpoint.c cVar = this.i;
        if (cVar == null) {
            return 0;
        }
        return cVar.g();
    }

    public Object x() {
        return this.v;
    }

    public com.sigmob.sdk.downloader.core.breakpoint.c y() {
        if (this.i == null) {
            this.i = g.j().c().a(this.b);
        }
        return this.i;
    }

    long z() {
        return this.x.get();
    }
}
