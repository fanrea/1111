package com.bytedance.sdk.component.b.hc.d.u;

import com.bytedance.sdk.component.b.d.jh;
import com.bytedance.sdk.component.b.d.rf;
import com.bytedance.sdk.component.b.d.yo;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class tt {
    static final /* synthetic */ boolean tt = true;
    final int b;
    final h c;
    long hc;
    private List<com.bytedance.sdk.component.b.hc.d.u.b> mk;
    private boolean mq;
    private final List<com.bytedance.sdk.component.b.hc.d.u.b> tc;
    final d u;
    private final hc uo;
    long d = 0;
    final b an = new b();
    final b h = new b();
    com.bytedance.sdk.component.b.hc.d.u.hc gb = null;

    tt(int i, h hVar, boolean z, boolean z2, List<com.bytedance.sdk.component.b.hc.d.u.b> list) {
        if (hVar == null) {
            throw new NullPointerException("connection == null");
        }
        if (list == null) {
            throw new NullPointerException("requestHeaders == null");
        }
        this.b = i;
        this.c = hVar;
        this.hc = hVar.uo.c();
        hc hcVar = new hc(hVar.mq.c());
        this.uo = hcVar;
        d dVar = new d();
        this.u = dVar;
        hcVar.hc = z2;
        dVar.hc = z;
        this.tc = list;
    }

    public int d() {
        return this.b;
    }

    public synchronized boolean hc() {
        if (this.gb != null) {
            return false;
        }
        if ((this.uo.hc || this.uo.d) && (this.u.hc || this.u.d)) {
            if (this.mq) {
                return false;
            }
        }
        return true;
    }

    public boolean b() {
        return this.c.hc == ((this.b & 1) == 1);
    }

    public synchronized List<com.bytedance.sdk.component.b.hc.d.u.b> c() throws IOException {
        List<com.bytedance.sdk.component.b.hc.d.u.b> list;
        if (!b()) {
            throw new IllegalStateException("servers cannot read response headers");
        }
        this.an.d();
        while (this.mk == null && this.gb == null) {
            try {
                mq();
            } catch (Throwable th) {
                this.an.gb();
                throw th;
            }
        }
        this.an.gb();
        list = this.mk;
        if (list != null) {
            this.mk = null;
        } else {
            throw new e(this.gb);
        }
        return list;
    }

    public jh u() {
        return this.an;
    }

    public jh an() {
        return this.h;
    }

    public rf h() {
        return this.uo;
    }

    public yo gb() {
        synchronized (this) {
            if (!this.mq && !b()) {
                throw new IllegalStateException("reply before requesting the sink");
            }
        }
        return this.u;
    }

    public void d(com.bytedance.sdk.component.b.hc.d.u.hc hcVar) throws IOException {
        if (c(hcVar)) {
            this.c.hc(this.b, hcVar);
        }
    }

    public void hc(com.bytedance.sdk.component.b.hc.d.u.hc hcVar) {
        if (c(hcVar)) {
            this.c.d(this.b, hcVar);
        }
    }

    private boolean c(com.bytedance.sdk.component.b.hc.d.u.hc hcVar) {
        if (!tt && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            if (this.gb != null) {
                return false;
            }
            if (this.uo.hc && this.u.hc) {
                return false;
            }
            this.gb = hcVar;
            notifyAll();
            this.c.hc(this.b);
            return true;
        }
    }

    void d(List<com.bytedance.sdk.component.b.hc.d.u.b> list) {
        boolean zHc;
        if (!tt && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            zHc = true;
            this.mq = true;
            if (this.mk == null) {
                this.mk = list;
                zHc = hc();
                notifyAll();
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.mk);
                arrayList.add(null);
                arrayList.addAll(list);
                this.mk = arrayList;
            }
        }
        if (zHc) {
            return;
        }
        this.c.hc(this.b);
    }

    void d(com.bytedance.sdk.component.b.d.u uVar, int i) throws IOException {
        if (!tt && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        this.uo.d(uVar, i);
    }

    void tt() {
        boolean zHc;
        if (!tt && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            this.uo.hc = true;
            zHc = hc();
            notifyAll();
        }
        if (zHc) {
            return;
        }
        this.c.hc(this.b);
    }

    synchronized void b(com.bytedance.sdk.component.b.hc.d.u.hc hcVar) {
        if (this.gb == null) {
            this.gb = hcVar;
            notifyAll();
        }
    }

    private final class hc implements rf {
        static final /* synthetic */ boolean b = true;
        boolean d;
        private final long h;
        boolean hc;
        private final com.bytedance.sdk.component.b.d.b u = new com.bytedance.sdk.component.b.d.b();
        private final com.bytedance.sdk.component.b.d.b an = new com.bytedance.sdk.component.b.d.b();

        hc(long j) {
            this.h = j;
        }

        @Override // com.bytedance.sdk.component.b.d.rf
        public long d(com.bytedance.sdk.component.b.d.b bVar, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
            }
            synchronized (tt.this) {
                hc();
                b();
                if (this.an.hc() == 0) {
                    return -1L;
                }
                com.bytedance.sdk.component.b.d.b bVar2 = this.an;
                long jD = bVar2.d(bVar, Math.min(j, bVar2.hc()));
                tt.this.d += jD;
                if (tt.this.d >= tt.this.c.mq.c() / 2) {
                    tt.this.c.d(tt.this.b, tt.this.d);
                    tt.this.d = 0L;
                }
                synchronized (tt.this.c) {
                    tt.this.c.tc += jD;
                    if (tt.this.c.tc >= tt.this.c.mq.c() / 2) {
                        tt.this.c.d(0, tt.this.c.tc);
                        tt.this.c.tc = 0L;
                    }
                }
                return jD;
            }
        }

        private void hc() throws IOException {
            tt.this.an.d();
            while (this.an.hc() == 0 && !this.hc && !this.d && tt.this.gb == null) {
                try {
                    tt.this.mq();
                } finally {
                    tt.this.an.gb();
                }
            }
        }

        void d(com.bytedance.sdk.component.b.d.u uVar, long j) throws IOException {
            boolean z;
            boolean z2;
            boolean z3;
            if (!b && Thread.holdsLock(tt.this)) {
                throw new AssertionError();
            }
            while (j > 0) {
                synchronized (tt.this) {
                    z = this.hc;
                    z2 = true;
                    z3 = this.an.hc() + j > this.h;
                }
                if (z3) {
                    uVar.gb(j);
                    tt.this.hc(com.bytedance.sdk.component.b.hc.d.u.hc.FLOW_CONTROL_ERROR);
                    return;
                }
                if (z) {
                    uVar.gb(j);
                    return;
                }
                long jD = uVar.d(this.u, j);
                if (jD == -1) {
                    throw new EOFException();
                }
                j -= jD;
                synchronized (tt.this) {
                    if (this.an.hc() != 0) {
                        z2 = false;
                    }
                    this.an.d(this.u);
                    if (z2) {
                        tt.this.notifyAll();
                    }
                }
            }
        }

        @Override // com.bytedance.sdk.component.b.d.rf
        public jh d() {
            return tt.this.an;
        }

        @Override // com.bytedance.sdk.component.b.d.rf, java.lang.AutoCloseable, java.nio.channels.Channel
        public void close() throws IOException {
            synchronized (tt.this) {
                this.d = true;
                this.an.yo();
                tt.this.notifyAll();
            }
            tt.this.tc();
        }

        private void b() throws IOException {
            if (this.d) {
                throw new IOException("stream closed");
            }
            if (tt.this.gb != null) {
                throw new e(tt.this.gb);
            }
        }
    }

    void tc() throws IOException {
        boolean z;
        boolean zHc;
        if (!tt && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            z = !this.uo.hc && this.uo.d && (this.u.hc || this.u.d);
            zHc = hc();
        }
        if (z) {
            d(com.bytedance.sdk.component.b.hc.d.u.hc.CANCEL);
        } else {
            if (zHc) {
                return;
            }
            this.c.hc(this.b);
        }
    }

    final class d implements yo {
        static final /* synthetic */ boolean b = true;
        boolean d;
        boolean hc;
        private final com.bytedance.sdk.component.b.d.b u = new com.bytedance.sdk.component.b.d.b();

        d() {
        }

        @Override // com.bytedance.sdk.component.b.d.yo
        public void a_(com.bytedance.sdk.component.b.d.b bVar, long j) throws IOException {
            if (!b && Thread.holdsLock(tt.this)) {
                throw new AssertionError();
            }
            this.u.a_(bVar, j);
            while (this.u.hc() >= 16384) {
                d(false);
            }
        }

        private void d(boolean z) throws IOException {
            long jMin;
            synchronized (tt.this) {
                tt.this.h.d();
                while (tt.this.hc <= 0 && !this.hc && !this.d && tt.this.gb == null) {
                    try {
                        tt.this.mq();
                    } finally {
                    }
                }
                tt.this.h.gb();
                tt.this.mk();
                jMin = Math.min(tt.this.hc, this.u.hc());
                tt.this.hc -= jMin;
            }
            tt.this.h.d();
            try {
                tt.this.c.d(tt.this.b, z && jMin == this.u.hc(), this.u, jMin);
            } finally {
            }
        }

        @Override // com.bytedance.sdk.component.b.d.yo, java.io.Flushable
        public void flush() throws IOException {
            if (!b && Thread.holdsLock(tt.this)) {
                throw new AssertionError();
            }
            synchronized (tt.this) {
                tt.this.mk();
            }
            while (this.u.hc() > 0) {
                d(false);
                tt.this.c.hc();
            }
        }

        @Override // com.bytedance.sdk.component.b.d.yo, com.bytedance.sdk.component.b.d.rf
        public jh d() {
            return tt.this.h;
        }

        @Override // com.bytedance.sdk.component.b.d.yo, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel, com.bytedance.sdk.component.b.d.rf
        public void close() throws IOException {
            if (!b && Thread.holdsLock(tt.this)) {
                throw new AssertionError();
            }
            synchronized (tt.this) {
                if (this.d) {
                    return;
                }
                if (!tt.this.u.hc) {
                    if (this.u.hc() > 0) {
                        while (this.u.hc() > 0) {
                            d(true);
                        }
                    } else {
                        tt.this.c.d(tt.this.b, true, (com.bytedance.sdk.component.b.d.b) null, 0L);
                    }
                }
                synchronized (tt.this) {
                    this.d = true;
                }
                tt.this.c.hc();
                tt.this.tc();
            }
        }
    }

    void d(long j) {
        this.hc += j;
        if (j > 0) {
            notifyAll();
        }
    }

    void mk() throws IOException {
        if (this.u.d) {
            throw new IOException("stream closed");
        }
        if (this.u.hc) {
            throw new IOException("stream finished");
        }
        if (this.gb != null) {
            throw new e(this.gb);
        }
    }

    void mq() throws InterruptedException, InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException unused) {
            throw new InterruptedIOException();
        }
    }

    class b extends com.bytedance.sdk.component.b.d.d {
        b() {
        }

        @Override // com.bytedance.sdk.component.b.d.d
        protected void m_() {
            tt.this.hc(com.bytedance.sdk.component.b.hc.d.u.hc.CANCEL);
        }

        @Override // com.bytedance.sdk.component.b.d.d
        protected IOException hc(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        public void gb() throws IOException {
            if (hc()) {
                throw hc((IOException) null);
            }
        }
    }
}
