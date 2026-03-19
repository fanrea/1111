package com.bytedance.sdk.component.b.hc.d.u;

import android.os.SystemClock;
import com.bytedance.sdk.component.b.hc.d.u.gb;
import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class h implements Closeable {
    static final ExecutorService d = new com.bytedance.sdk.component.tc.c.c(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), com.bytedance.sdk.component.b.hc.d.b.d("OkHttp Http2Connection", true));
    static final /* synthetic */ boolean rf = true;
    int an;
    final hc b;
    final tc cb;
    private int de;
    final Socket e;
    boolean gb;
    int h;
    final boolean hc;
    private final ExecutorService jh;
    boolean k;
    long mk;
    private Map<Integer, mq> sy;
    final uo tt;
    final String u;
    final k uo;
    final b w;
    final Set<Integer> yo;
    final Map<Integer, tt> c = new LinkedHashMap();
    long tc = 0;
    k mq = new k();

    public static abstract class hc {
        public static final hc an = new hc() { // from class: com.bytedance.sdk.component.b.hc.d.u.h.hc.1
            @Override // com.bytedance.sdk.component.b.hc.d.u.h.hc
            public void d(tt ttVar) throws IOException {
                ttVar.d(com.bytedance.sdk.component.b.hc.d.u.hc.REFUSED_STREAM);
            }
        };

        public void d(h hVar) {
        }

        public abstract void d(tt ttVar) throws IOException;
    }

    boolean c(int i) {
        return i != 0 && (i & 1) == 0;
    }

    h(d dVar) {
        k kVar = new k();
        this.uo = kVar;
        this.k = false;
        this.yo = new LinkedHashSet();
        this.tt = dVar.an;
        boolean z = dVar.h;
        this.hc = z;
        this.b = dVar.u;
        this.h = dVar.h ? 1 : 2;
        if (dVar.h) {
            this.h += 2;
        }
        this.de = dVar.h ? 1 : 2;
        if (dVar.h) {
            this.mq.d(7, 16777216);
        }
        String str = dVar.hc;
        this.u = str;
        this.jh = new com.bytedance.sdk.component.tc.c.c(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), com.bytedance.sdk.component.b.hc.d.b.d(com.bytedance.sdk.component.b.hc.d.b.d("OkHttp %s Push Observer", str), true));
        kVar.d(7, 65535);
        kVar.d(5, 16384);
        this.mk = kVar.c();
        this.e = dVar.d;
        this.cb = new tc(dVar.c, z);
        this.w = new b(new gb(dVar.b, z));
    }

    synchronized tt d(int i) {
        return this.c.get(Integer.valueOf(i));
    }

    synchronized tt hc(int i) {
        tt ttVarRemove;
        ttVarRemove = this.c.remove(Integer.valueOf(i));
        notifyAll();
        return ttVarRemove;
    }

    public synchronized int d() {
        return this.uo.b(Integer.MAX_VALUE);
    }

    public tt d(List<com.bytedance.sdk.component.b.hc.d.u.b> list, boolean z) throws IOException {
        return hc(0, list, z);
    }

    private tt hc(int i, List<com.bytedance.sdk.component.b.hc.d.u.b> list, boolean z) throws IOException {
        int i2;
        tt ttVar;
        boolean z2;
        boolean z3 = !z;
        synchronized (this.cb) {
            synchronized (this) {
                if (this.gb) {
                    throw new com.bytedance.sdk.component.b.hc.d.u.d();
                }
                i2 = this.h;
                this.h = i2 + 2;
                ttVar = new tt(i2, this, z3, false, list);
                z2 = !z || this.mk == 0 || ttVar.hc == 0;
                if (ttVar.hc()) {
                    this.c.put(Integer.valueOf(i2), ttVar);
                }
            }
            if (i == 0) {
                this.cb.d(z3, i2, i, list);
            } else {
                if (this.hc) {
                    throw new IllegalArgumentException("client streams shouldn't have associated stream IDs");
                }
                this.cb.d(i, i2, list);
            }
        }
        if (z2) {
            this.cb.hc();
        }
        return ttVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0030, code lost:
    
        r2 = java.lang.Math.min((int) java.lang.Math.min(r12, r4), r8.cb.b());
        r6 = r2;
        r8.mk -= r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void d(int r9, boolean r10, com.bytedance.sdk.component.b.d.b r11, long r12) throws java.io.IOException {
        /*
            r8 = this;
            r0 = 0
            int r2 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            r3 = 0
            if (r2 != 0) goto Ld
            com.bytedance.sdk.component.b.hc.d.u.tc r12 = r8.cb
            r12.d(r10, r9, r11, r3)
            return
        Ld:
            int r2 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r2 <= 0) goto L60
            monitor-enter(r8)
        L12:
            long r4 = r8.mk     // Catch: java.lang.Throwable -> L56 java.lang.InterruptedException -> L58
            int r2 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r2 > 0) goto L30
            java.util.Map<java.lang.Integer, com.bytedance.sdk.component.b.hc.d.u.tt> r2 = r8.c     // Catch: java.lang.Throwable -> L56 java.lang.InterruptedException -> L58
            java.lang.Integer r4 = java.lang.Integer.valueOf(r9)     // Catch: java.lang.Throwable -> L56 java.lang.InterruptedException -> L58
            boolean r2 = r2.containsKey(r4)     // Catch: java.lang.Throwable -> L56 java.lang.InterruptedException -> L58
            if (r2 == 0) goto L28
            r8.wait()     // Catch: java.lang.Throwable -> L56 java.lang.InterruptedException -> L58
            goto L12
        L28:
            java.io.IOException r9 = new java.io.IOException     // Catch: java.lang.Throwable -> L56 java.lang.InterruptedException -> L58
            java.lang.String r10 = "stream closed"
            r9.<init>(r10)     // Catch: java.lang.Throwable -> L56 java.lang.InterruptedException -> L58
            throw r9     // Catch: java.lang.Throwable -> L56 java.lang.InterruptedException -> L58
        L30:
            long r4 = java.lang.Math.min(r12, r4)     // Catch: java.lang.Throwable -> L56
            int r2 = (int) r4     // Catch: java.lang.Throwable -> L56
            com.bytedance.sdk.component.b.hc.d.u.tc r4 = r8.cb     // Catch: java.lang.Throwable -> L56
            int r4 = r4.b()     // Catch: java.lang.Throwable -> L56
            int r2 = java.lang.Math.min(r2, r4)     // Catch: java.lang.Throwable -> L56
            long r4 = r8.mk     // Catch: java.lang.Throwable -> L56
            long r6 = (long) r2     // Catch: java.lang.Throwable -> L56
            long r4 = r4 - r6
            r8.mk = r4     // Catch: java.lang.Throwable -> L56
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L56
            long r12 = r12 - r6
            com.bytedance.sdk.component.b.hc.d.u.tc r4 = r8.cb
            if (r10 == 0) goto L51
            int r5 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r5 != 0) goto L51
            r5 = 1
            goto L52
        L51:
            r5 = r3
        L52:
            r4.d(r5, r9, r11, r2)
            goto Ld
        L56:
            r9 = move-exception
            goto L5e
        L58:
            java.io.InterruptedIOException r9 = new java.io.InterruptedIOException     // Catch: java.lang.Throwable -> L56
            r9.<init>()     // Catch: java.lang.Throwable -> L56
            throw r9     // Catch: java.lang.Throwable -> L56
        L5e:
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L56
            throw r9
        L60:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.b.hc.d.u.h.d(int, boolean, com.bytedance.sdk.component.b.d.b, long):void");
    }

    void d(long j) {
        this.mk += j;
        if (j > 0) {
            notifyAll();
        }
    }

    void d(final int i, final com.bytedance.sdk.component.b.hc.d.u.hc hcVar) {
        try {
            d.execute(new com.bytedance.sdk.component.b.hc.d.hc("OkHttp %s stream %d", new Object[]{this.u, Integer.valueOf(i)}) { // from class: com.bytedance.sdk.component.b.hc.d.u.h.1
                @Override // com.bytedance.sdk.component.b.hc.d.hc
                public void b() {
                    try {
                        h.this.hc(i, hcVar);
                    } catch (IOException unused) {
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    void hc(int i, com.bytedance.sdk.component.b.hc.d.u.hc hcVar) throws IOException {
        this.cb.d(i, hcVar);
    }

    void d(final int i, final long j) {
        try {
            d.execute(new com.bytedance.sdk.component.b.hc.d.hc("OkHttp Window Update %s stream %d", new Object[]{this.u, Integer.valueOf(i)}) { // from class: com.bytedance.sdk.component.b.hc.d.u.h.2
                @Override // com.bytedance.sdk.component.b.hc.d.hc
                public void b() {
                    try {
                        h.this.cb.d(i, j);
                    } catch (IOException unused) {
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    void d(final boolean z, final int i, final int i2, final mq mqVar) {
        try {
            d.execute(new com.bytedance.sdk.component.b.hc.d.hc("OkHttp %s ping %08x%08x", new Object[]{this.u, Integer.valueOf(i), Integer.valueOf(i2)}) { // from class: com.bytedance.sdk.component.b.hc.d.u.h.3
                @Override // com.bytedance.sdk.component.b.hc.d.hc
                public void b() {
                    try {
                        h.this.hc(z, i, i2, mqVar);
                    } catch (IOException unused) {
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    void hc(boolean z, int i, int i2, mq mqVar) throws IOException {
        synchronized (this.cb) {
            if (mqVar != null) {
                mqVar.d();
                this.cb.d(z, i, i2);
            } else {
                this.cb.d(z, i, i2);
            }
        }
    }

    synchronized mq b(int i) {
        Map<Integer, mq> map = this.sy;
        if (map == null) {
            return null;
        }
        return map.remove(Integer.valueOf(i));
    }

    public void hc() throws IOException {
        this.cb.hc();
    }

    public void d(com.bytedance.sdk.component.b.hc.d.u.hc hcVar) throws IOException {
        synchronized (this.cb) {
            synchronized (this) {
                if (this.gb) {
                    return;
                }
                this.gb = true;
                this.cb.d(this.an, hcVar, com.bytedance.sdk.component.b.hc.d.b.d);
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        d(com.bytedance.sdk.component.b.hc.d.u.hc.NO_ERROR, com.bytedance.sdk.component.b.hc.d.u.hc.CANCEL);
    }

    void d(com.bytedance.sdk.component.b.hc.d.u.hc hcVar, com.bytedance.sdk.component.b.hc.d.u.hc hcVar2) throws IOException {
        tt[] ttVarArr;
        if (!rf && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        mq[] mqVarArr = null;
        try {
            d(hcVar);
            e = null;
        } catch (IOException e) {
            e = e;
        }
        synchronized (this) {
            if (this.c.isEmpty()) {
                ttVarArr = null;
            } else {
                ttVarArr = (tt[]) this.c.values().toArray(new tt[this.c.size()]);
                this.c.clear();
            }
            Map<Integer, mq> map = this.sy;
            if (map != null) {
                mq[] mqVarArr2 = (mq[]) map.values().toArray(new mq[this.sy.size()]);
                this.sy = null;
                mqVarArr = mqVarArr2;
            }
        }
        if (ttVarArr != null) {
            for (tt ttVar : ttVarArr) {
                try {
                    ttVar.d(hcVar2);
                } catch (IOException e2) {
                    if (e != null) {
                        e = e2;
                    }
                }
            }
        }
        if (mqVarArr != null) {
            for (mq mqVar : mqVarArr) {
                mqVar.b();
            }
        }
        try {
            this.cb.close();
        } catch (IOException e3) {
            if (e == null) {
                e = e3;
            }
        }
        try {
            this.e.close();
        } catch (IOException e4) {
            e = e4;
        }
        if (e != null) {
            throw e;
        }
    }

    public void b() throws IOException {
        d(true);
    }

    void d(boolean z) throws IOException {
        if (z) {
            this.cb.d();
            this.cb.hc(this.mq);
            if (this.mq.c() != 65535) {
                this.cb.d(0, r6 - 65535);
            }
        }
        com.bytedance.sdk.component.tc.c.b bVar = new com.bytedance.sdk.component.tc.c.b(this.w, "Http2Connection");
        bVar.setName("csj_http2_connection" + SystemClock.uptimeMillis());
        bVar.start();
    }

    public synchronized boolean c() {
        return this.gb;
    }

    public static class d {
        com.bytedance.sdk.component.b.d.u b;
        com.bytedance.sdk.component.b.d.c c;
        Socket d;
        boolean h;
        String hc;
        hc u = hc.an;
        uo an = uo.d;

        public d(boolean z) {
            this.h = z;
        }

        public d d(Socket socket, String str, com.bytedance.sdk.component.b.d.u uVar, com.bytedance.sdk.component.b.d.c cVar) {
            this.d = socket;
            this.hc = str;
            this.b = uVar;
            this.c = cVar;
            return this;
        }

        public d d(hc hcVar) {
            this.u = hcVar;
            return this;
        }

        public h d() {
            return new h(this);
        }
    }

    class b extends com.bytedance.sdk.component.b.hc.d.hc implements gb.hc {
        final gb d;

        b(gb gbVar) {
            super("OkHttp %s", h.this.u);
            this.d = gbVar;
        }

        @Override // com.bytedance.sdk.component.b.hc.d.hc
        protected void b() throws IOException {
            h hVar;
            com.bytedance.sdk.component.b.hc.d.u.hc hcVar = com.bytedance.sdk.component.b.hc.d.u.hc.INTERNAL_ERROR;
            com.bytedance.sdk.component.b.hc.d.u.hc hcVar2 = com.bytedance.sdk.component.b.hc.d.u.hc.INTERNAL_ERROR;
            try {
                try {
                    this.d.d(this);
                    while (this.d.d(false, (gb.hc) this)) {
                    }
                    hcVar = com.bytedance.sdk.component.b.hc.d.u.hc.NO_ERROR;
                    hcVar2 = com.bytedance.sdk.component.b.hc.d.u.hc.CANCEL;
                    hVar = h.this;
                } catch (IOException unused) {
                    hcVar = com.bytedance.sdk.component.b.hc.d.u.hc.PROTOCOL_ERROR;
                    hcVar2 = com.bytedance.sdk.component.b.hc.d.u.hc.PROTOCOL_ERROR;
                    hVar = h.this;
                } catch (NullPointerException unused2) {
                    hcVar2 = com.bytedance.sdk.component.b.hc.d.u.hc.PROTOCOL_ERROR;
                    hcVar = com.bytedance.sdk.component.b.hc.d.u.hc.PROTOCOL_ERROR;
                    hVar = h.this;
                }
                hVar.d(hcVar, hcVar2);
                com.bytedance.sdk.component.b.hc.d.b.d(this.d);
            } catch (Throwable th) {
                try {
                    h.this.d(hcVar, hcVar2);
                } catch (Exception unused3) {
                }
                com.bytedance.sdk.component.b.hc.d.b.d(this.d);
                throw th;
            }
        }

        @Override // com.bytedance.sdk.component.b.hc.d.u.gb.hc
        public void d(boolean z, int i, com.bytedance.sdk.component.b.d.u uVar, int i2) throws IOException {
            if (h.this.c(i)) {
                h.this.d(i, uVar, i2, z);
                return;
            }
            tt ttVarD = h.this.d(i);
            if (ttVarD == null) {
                h.this.d(i, com.bytedance.sdk.component.b.hc.d.u.hc.PROTOCOL_ERROR);
                uVar.gb(i2);
            } else {
                ttVarD.d(uVar, i2);
                if (z) {
                    ttVarD.tt();
                }
            }
        }

        @Override // com.bytedance.sdk.component.b.hc.d.u.gb.hc
        public void d(boolean z, int i, int i2, List<com.bytedance.sdk.component.b.hc.d.u.b> list) {
            if (h.this.c(i)) {
                h.this.d(i, list, z);
                return;
            }
            synchronized (h.this) {
                tt ttVarD = h.this.d(i);
                if (ttVarD == null) {
                    if (h.this.gb) {
                        return;
                    }
                    if (i <= h.this.an) {
                        return;
                    }
                    if (i % 2 == h.this.h % 2) {
                        return;
                    }
                    final tt ttVar = new tt(i, h.this, false, z, list);
                    h.this.an = i;
                    h.this.c.put(Integer.valueOf(i), ttVar);
                    try {
                        h.d.execute(new com.bytedance.sdk.component.b.hc.d.hc("OkHttp %s stream %d", new Object[]{h.this.u, Integer.valueOf(i)}) { // from class: com.bytedance.sdk.component.b.hc.d.u.h.b.1
                            @Override // com.bytedance.sdk.component.b.hc.d.hc
                            public void b() {
                                try {
                                    h.this.b.d(ttVar);
                                } catch (IOException e) {
                                    com.bytedance.sdk.component.b.hc.d.h.u.hc().d(4, "Http2Connection.Listener failure for " + h.this.u, e);
                                    try {
                                        ttVar.d(com.bytedance.sdk.component.b.hc.d.u.hc.PROTOCOL_ERROR);
                                    } catch (IOException unused) {
                                    }
                                }
                            }
                        });
                    } catch (Throwable unused) {
                    }
                    return;
                }
                ttVarD.d(list);
                if (z) {
                    ttVarD.tt();
                }
            }
        }

        @Override // com.bytedance.sdk.component.b.hc.d.u.gb.hc
        public void d(int i, com.bytedance.sdk.component.b.hc.d.u.hc hcVar) {
            if (h.this.c(i)) {
                h.this.b(i, hcVar);
                return;
            }
            tt ttVarHc = h.this.hc(i);
            if (ttVarHc != null) {
                ttVarHc.b(hcVar);
            }
        }

        @Override // com.bytedance.sdk.component.b.hc.d.u.gb.hc
        public void d(boolean z, k kVar) {
            tt[] ttVarArr;
            long j;
            int i;
            synchronized (h.this) {
                int iC = h.this.uo.c();
                if (z) {
                    h.this.uo.d();
                }
                h.this.uo.d(kVar);
                d(kVar);
                int iC2 = h.this.uo.c();
                ttVarArr = null;
                if (iC2 == -1 || iC2 == iC) {
                    j = 0;
                } else {
                    j = iC2 - iC;
                    if (!h.this.k) {
                        h.this.d(j);
                        h.this.k = true;
                    }
                    if (!h.this.c.isEmpty()) {
                        ttVarArr = (tt[]) h.this.c.values().toArray(new tt[h.this.c.size()]);
                    }
                }
                try {
                    h.d.execute(new com.bytedance.sdk.component.b.hc.d.hc("OkHttp %s settings", h.this.u) { // from class: com.bytedance.sdk.component.b.hc.d.u.h.b.2
                        @Override // com.bytedance.sdk.component.b.hc.d.hc
                        public void b() {
                            h.this.b.d(h.this);
                        }
                    });
                } catch (Throwable unused) {
                }
            }
            if (ttVarArr == null || j == 0) {
                return;
            }
            for (tt ttVar : ttVarArr) {
                synchronized (ttVar) {
                    ttVar.d(j);
                }
            }
        }

        private void d(final k kVar) {
            try {
                h.d.execute(new com.bytedance.sdk.component.b.hc.d.hc("OkHttp %s ACK Settings", new Object[]{h.this.u}) { // from class: com.bytedance.sdk.component.b.hc.d.u.h.b.3
                    @Override // com.bytedance.sdk.component.b.hc.d.hc
                    public void b() {
                        try {
                            h.this.cb.d(kVar);
                        } catch (IOException unused) {
                        }
                    }
                });
            } catch (Throwable unused) {
            }
        }

        @Override // com.bytedance.sdk.component.b.hc.d.u.gb.hc
        public void d(boolean z, int i, int i2) {
            if (z) {
                mq mqVarB = h.this.b(i);
                if (mqVarB != null) {
                    mqVarB.hc();
                    return;
                }
                return;
            }
            h.this.d(true, i, i2, (mq) null);
        }

        @Override // com.bytedance.sdk.component.b.hc.d.u.gb.hc
        public void d(int i, com.bytedance.sdk.component.b.hc.d.u.hc hcVar, com.bytedance.sdk.component.b.d.an anVar) {
            tt[] ttVarArr;
            synchronized (h.this) {
                ttVarArr = (tt[]) h.this.c.values().toArray(new tt[h.this.c.size()]);
                h.this.gb = true;
            }
            for (tt ttVar : ttVarArr) {
                if (ttVar.d() > i && ttVar.b()) {
                    ttVar.b(com.bytedance.sdk.component.b.hc.d.u.hc.REFUSED_STREAM);
                    h.this.hc(ttVar.d());
                }
            }
        }

        @Override // com.bytedance.sdk.component.b.hc.d.u.gb.hc
        public void d(int i, long j) {
            if (i == 0) {
                synchronized (h.this) {
                    h.this.mk += j;
                    h.this.notifyAll();
                }
                return;
            }
            tt ttVarD = h.this.d(i);
            if (ttVarD != null) {
                synchronized (ttVarD) {
                    ttVarD.d(j);
                }
            }
        }

        @Override // com.bytedance.sdk.component.b.hc.d.u.gb.hc
        public void d(int i, int i2, List<com.bytedance.sdk.component.b.hc.d.u.b> list) {
            h.this.d(i2, list);
        }
    }

    void d(final int i, final List<com.bytedance.sdk.component.b.hc.d.u.b> list) {
        synchronized (this) {
            if (this.yo.contains(Integer.valueOf(i))) {
                d(i, com.bytedance.sdk.component.b.hc.d.u.hc.PROTOCOL_ERROR);
            } else {
                this.yo.add(Integer.valueOf(i));
                this.jh.execute(new com.bytedance.sdk.component.b.hc.d.hc("OkHttp %s Push Request[%s]", new Object[]{this.u, Integer.valueOf(i)}) { // from class: com.bytedance.sdk.component.b.hc.d.u.h.4
                    @Override // com.bytedance.sdk.component.b.hc.d.hc
                    public void b() {
                        if (h.this.tt.d(i, list)) {
                            try {
                                h.this.cb.d(i, com.bytedance.sdk.component.b.hc.d.u.hc.CANCEL);
                                synchronized (h.this) {
                                    h.this.yo.remove(Integer.valueOf(i));
                                }
                            } catch (IOException unused) {
                            }
                        }
                    }
                });
            }
        }
    }

    void d(final int i, final List<com.bytedance.sdk.component.b.hc.d.u.b> list, final boolean z) {
        this.jh.execute(new com.bytedance.sdk.component.b.hc.d.hc("OkHttp %s Push Headers[%s]", new Object[]{this.u, Integer.valueOf(i)}) { // from class: com.bytedance.sdk.component.b.hc.d.u.h.5
            @Override // com.bytedance.sdk.component.b.hc.d.hc
            public void b() {
                boolean zD = h.this.tt.d(i, list, z);
                if (zD) {
                    try {
                        h.this.cb.d(i, com.bytedance.sdk.component.b.hc.d.u.hc.CANCEL);
                    } catch (IOException unused) {
                        return;
                    }
                }
                if (!zD && !z) {
                    return;
                }
                synchronized (h.this) {
                    h.this.yo.remove(Integer.valueOf(i));
                }
            }
        });
    }

    void d(final int i, com.bytedance.sdk.component.b.d.u uVar, final int i2, final boolean z) throws IOException {
        final com.bytedance.sdk.component.b.d.b bVar = new com.bytedance.sdk.component.b.d.b();
        long j = i2;
        uVar.d(j);
        uVar.d(bVar, j);
        if (bVar.hc() != j) {
            throw new IOException(bVar.hc() + " != " + i2);
        }
        this.jh.execute(new com.bytedance.sdk.component.b.hc.d.hc("OkHttp %s Push Data[%s]", new Object[]{this.u, Integer.valueOf(i)}) { // from class: com.bytedance.sdk.component.b.hc.d.u.h.6
            @Override // com.bytedance.sdk.component.b.hc.d.hc
            public void b() {
                try {
                    boolean zD = h.this.tt.d(i, bVar, i2, z);
                    if (zD) {
                        h.this.cb.d(i, com.bytedance.sdk.component.b.hc.d.u.hc.CANCEL);
                    }
                    if (!zD && !z) {
                        return;
                    }
                    synchronized (h.this) {
                        h.this.yo.remove(Integer.valueOf(i));
                    }
                } catch (IOException unused) {
                }
            }
        });
    }

    void b(final int i, final com.bytedance.sdk.component.b.hc.d.u.hc hcVar) {
        this.jh.execute(new com.bytedance.sdk.component.b.hc.d.hc("OkHttp %s Push Reset[%s]", new Object[]{this.u, Integer.valueOf(i)}) { // from class: com.bytedance.sdk.component.b.hc.d.u.h.7
            @Override // com.bytedance.sdk.component.b.hc.d.hc
            public void b() {
                synchronized (h.this) {
                    h.this.yo.remove(Integer.valueOf(i));
                }
            }
        });
    }
}
