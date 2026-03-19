package okhttp3.internal.http2;

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
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.http2.f;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class e implements Closeable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final ExecutorService executor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), okhttp3.internal.c.a("OkHttp Http2Connection", true));
    final boolean BZ;
    final b Ca;
    int Cc;
    int Cd;
    boolean Ce;
    private final ExecutorService Cf;
    private Map<Integer, j> Cg;
    final k Ch;
    private int Ci;
    long Ck;
    final h Co;
    final c Cp;
    final String hostname;
    final Socket socket;
    final Map<Integer, g> Cb = new LinkedHashMap();
    long Cj = 0;
    l Cl = new l();
    final l Cm = new l();
    boolean Cn = false;
    final Set<Integer> Cq = new LinkedHashSet();

    public static abstract class b {
        public static final b CB = new b() { // from class: okhttp3.internal.http2.e.b.1
            @Override // okhttp3.internal.http2.e.b
            public final void a(g gVar) {
                gVar.b(ErrorCode.REFUSED_STREAM);
            }
        };

        public void a(e eVar) {
        }

        public abstract void a(g gVar);
    }

    static boolean bF(int i) {
        return i != 0 && (i & 1) == 0;
    }

    e(a aVar) {
        this.Ch = aVar.Ch;
        this.BZ = aVar.BZ;
        this.Ca = aVar.Ca;
        this.Cd = aVar.BZ ? 1 : 2;
        if (aVar.BZ) {
            this.Cd += 2;
        }
        this.Ci = aVar.BZ ? 1 : 2;
        if (aVar.BZ) {
            this.Cl.Y(7, 16777216);
        }
        this.hostname = aVar.hostname;
        this.Cf = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), okhttp3.internal.c.a(okhttp3.internal.c.format("OkHttp %s Push Observer", this.hostname), true));
        this.Cm.Y(7, 65535);
        this.Cm.Y(5, 16384);
        this.Ck = this.Cm.hh();
        this.socket = aVar.socket;
        this.Co = new h(aVar.AD, this.BZ);
        this.Cp = new c(new f(aVar.source, this.BZ));
    }

    final synchronized g bC(int i) {
        return this.Cb.get(Integer.valueOf(i));
    }

    final synchronized g bD(int i) {
        g gVarRemove;
        gVarRemove = this.Cb.remove(Integer.valueOf(i));
        notifyAll();
        return gVarRemove;
    }

    public final synchronized int gR() {
        return this.Cm.bG(Integer.MAX_VALUE);
    }

    public final g a(List<okhttp3.internal.http2.a> list, boolean z) {
        return a(0, list, z);
    }

    private g a(int i, List<okhttp3.internal.http2.a> list, boolean z) {
        int i2;
        g gVar;
        boolean z2;
        boolean z3 = !z;
        synchronized (this.Co) {
            synchronized (this) {
                if (this.Ce) {
                    throw new ConnectionShutdownException();
                }
                i2 = this.Cd;
                this.Cd += 2;
                gVar = new g(i2, this, z3, false, list);
                z2 = !z || this.Ck == 0 || gVar.Ck == 0;
                if (gVar.isOpen()) {
                    this.Cb.put(Integer.valueOf(i2), gVar);
                }
            }
            this.Co.b(z3, i2, list);
        }
        if (z2) {
            this.Co.flush();
        }
        return gVar;
    }

    final void m(long j) {
        this.Ck += j;
        if (j > 0) {
            notifyAll();
        }
    }

    final void a(final int i, final ErrorCode errorCode) {
        executor.execute(new okhttp3.internal.b("OkHttp %s stream %d", new Object[]{this.hostname, Integer.valueOf(i)}) { // from class: okhttp3.internal.http2.e.1
            @Override // okhttp3.internal.b
            public final void execute() {
                try {
                    e.this.b(i, errorCode);
                } catch (IOException unused) {
                }
            }
        });
    }

    final void b(int i, ErrorCode errorCode) {
        this.Co.d(i, errorCode);
    }

    final void a(boolean z, final int i, final int i2, j jVar) {
        final boolean z2 = true;
        final j jVar2 = null;
        executor.execute(new okhttp3.internal.b("OkHttp %s ping %08x%08x", new Object[]{this.hostname, Integer.valueOf(i), Integer.valueOf(i2)}) { // from class: okhttp3.internal.http2.e.2
            @Override // okhttp3.internal.b
            public final void execute() {
                try {
                    e.this.b(z2, i, i2, jVar2);
                } catch (IOException unused) {
                }
            }
        });
    }

    final void b(boolean z, int i, int i2, j jVar) {
        synchronized (this.Co) {
            if (jVar != null) {
                jVar.send();
                this.Co.b(z, i, i2);
            } else {
                this.Co.b(z, i, i2);
            }
        }
    }

    final synchronized j bE(int i) {
        if (this.Cg == null) {
            return null;
        }
        return this.Cg.remove(Integer.valueOf(i));
    }

    public final void flush() {
        this.Co.flush();
    }

    private void a(ErrorCode errorCode) {
        synchronized (this.Co) {
            synchronized (this) {
                if (this.Ce) {
                    return;
                }
                this.Ce = true;
                this.Co.a(this.Cc, errorCode, okhttp3.internal.c.zt);
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        a(ErrorCode.NO_ERROR, ErrorCode.CANCEL);
    }

    final void a(ErrorCode errorCode, ErrorCode errorCode2) throws IOException {
        g[] gVarArr;
        j[] jVarArr = null;
        try {
            a(errorCode);
            e = null;
        } catch (IOException e) {
            e = e;
        }
        synchronized (this) {
            if (this.Cb.isEmpty()) {
                gVarArr = null;
            } else {
                gVarArr = (g[]) this.Cb.values().toArray(new g[this.Cb.size()]);
                this.Cb.clear();
            }
            if (this.Cg != null) {
                j[] jVarArr2 = (j[]) this.Cg.values().toArray(new j[this.Cg.size()]);
                this.Cg = null;
                jVarArr = jVarArr2;
            }
        }
        if (gVarArr != null) {
            IOException iOException = e;
            for (g gVar : gVarArr) {
                try {
                    gVar.b(errorCode2);
                } catch (IOException e2) {
                    if (iOException != null) {
                        iOException = e2;
                    }
                }
            }
            e = iOException;
        }
        if (jVarArr != null) {
            for (j jVar : jVarArr) {
                jVar.cancel();
            }
        }
        try {
            this.Co.close();
        } catch (IOException e3) {
            if (e == null) {
                e = e3;
            }
        }
        try {
            this.socket.close();
        } catch (IOException e4) {
            e = e4;
        }
        if (e != null) {
            throw e;
        }
    }

    public final void start() {
        start(true);
    }

    private void start(boolean z) {
        this.Co.hc();
        this.Co.b(this.Cl);
        if (this.Cl.hh() != 65535) {
            this.Co.c(0, r6 - 65535);
        }
        new Thread(this.Cp).start();
    }

    public final synchronized boolean isShutdown() {
        return this.Ce;
    }

    public static class a {
        BufferedSink AD;
        String hostname;
        Socket socket;
        BufferedSource source;
        b Ca = b.CB;
        k Ch = k.Dk;
        boolean BZ = true;

        public a(boolean z) {
        }

        public final a a(Socket socket, String str, BufferedSource bufferedSource, BufferedSink bufferedSink) {
            this.socket = socket;
            this.hostname = str;
            this.source = bufferedSource;
            this.AD = bufferedSink;
            return this;
        }

        public final a a(b bVar) {
            this.Ca = bVar;
            return this;
        }

        public final e gS() {
            return new e(this);
        }
    }

    class c extends okhttp3.internal.b implements f.b {
        final f CC;

        c(f fVar) {
            super("OkHttp %s", e.this.hostname);
            this.CC = fVar;
        }

        @Override // okhttp3.internal.b
        public final void execute() {
            e eVar;
            ErrorCode errorCode = ErrorCode.INTERNAL_ERROR;
            ErrorCode errorCode2 = ErrorCode.INTERNAL_ERROR;
            try {
                try {
                    this.CC.a(this);
                    while (this.CC.a(false, (f.b) this)) {
                    }
                    errorCode = ErrorCode.NO_ERROR;
                    errorCode2 = ErrorCode.CANCEL;
                    eVar = e.this;
                } catch (IOException unused) {
                    errorCode = ErrorCode.PROTOCOL_ERROR;
                    errorCode2 = ErrorCode.PROTOCOL_ERROR;
                    eVar = e.this;
                }
                eVar.a(errorCode, errorCode2);
                okhttp3.internal.c.closeQuietly(this.CC);
            } catch (Throwable th) {
                try {
                    e.this.a(errorCode, errorCode2);
                } catch (IOException unused2) {
                }
                okhttp3.internal.c.closeQuietly(this.CC);
                throw th;
            }
        }

        @Override // okhttp3.internal.http2.f.b
        public final void a(boolean z, int i, BufferedSource bufferedSource, int i2) throws IOException {
            if (e.bF(i)) {
                e.this.a(i, bufferedSource, i2, z);
                return;
            }
            g gVarBC = e.this.bC(i);
            if (gVarBC == null) {
                e.this.a(i, ErrorCode.PROTOCOL_ERROR);
                bufferedSource.skip(i2);
            } else {
                gVarBC.a(bufferedSource, i2);
                if (z) {
                    gVarBC.gZ();
                }
            }
        }

        @Override // okhttp3.internal.http2.f.b
        public final void a(boolean z, int i, List<okhttp3.internal.http2.a> list) {
            if (e.bF(i)) {
                e.this.b(i, list, z);
                return;
            }
            synchronized (e.this) {
                if (e.this.Ce) {
                    return;
                }
                g gVarBC = e.this.bC(i);
                if (gVarBC == null) {
                    if (i <= e.this.Cc) {
                        return;
                    }
                    if (i % 2 == e.this.Cd % 2) {
                        return;
                    }
                    final g gVar = new g(i, e.this, false, z, list);
                    e.this.Cc = i;
                    e.this.Cb.put(Integer.valueOf(i), gVar);
                    e.executor.execute(new okhttp3.internal.b("OkHttp %s stream %d", new Object[]{e.this.hostname, Integer.valueOf(i)}) { // from class: okhttp3.internal.http2.e.c.1
                        @Override // okhttp3.internal.b
                        public final void execute() {
                            try {
                                e.this.Ca.a(gVar);
                            } catch (IOException e) {
                                okhttp3.internal.e.e.hl().a(4, "Http2Connection.Listener failure for " + e.this.hostname, e);
                                try {
                                    gVar.b(ErrorCode.PROTOCOL_ERROR);
                                } catch (IOException unused) {
                                }
                            }
                        }
                    });
                    return;
                }
                gVarBC.k(list);
                if (z) {
                    gVarBC.gZ();
                }
            }
        }

        @Override // okhttp3.internal.http2.f.b
        public final void d(int i, ErrorCode errorCode) {
            if (e.bF(i)) {
                e.this.c(i, errorCode);
                return;
            }
            g gVarBD = e.this.bD(i);
            if (gVarBD != null) {
                gVarBD.e(errorCode);
            }
        }

        @Override // okhttp3.internal.http2.f.b
        public final void a(boolean z, l lVar) {
            g[] gVarArr;
            long j;
            int i;
            synchronized (e.this) {
                int iHh = e.this.Cm.hh();
                e.this.Cm.c(lVar);
                a(lVar);
                int iHh2 = e.this.Cm.hh();
                gVarArr = null;
                if (iHh2 == -1 || iHh2 == iHh) {
                    j = 0;
                } else {
                    j = iHh2 - iHh;
                    if (!e.this.Cn) {
                        e.this.m(j);
                        e.this.Cn = true;
                    }
                    if (!e.this.Cb.isEmpty()) {
                        gVarArr = (g[]) e.this.Cb.values().toArray(new g[e.this.Cb.size()]);
                    }
                }
                e.executor.execute(new okhttp3.internal.b("OkHttp %s settings", e.this.hostname) { // from class: okhttp3.internal.http2.e.c.2
                    @Override // okhttp3.internal.b
                    public final void execute() {
                        e.this.Ca.a(e.this);
                    }
                });
            }
            if (gVarArr == null || j == 0) {
                return;
            }
            for (g gVar : gVarArr) {
                synchronized (gVar) {
                    gVar.m(j);
                }
            }
        }

        private void a(final l lVar) {
            e.executor.execute(new okhttp3.internal.b("OkHttp %s ACK Settings", new Object[]{e.this.hostname}) { // from class: okhttp3.internal.http2.e.c.3
                @Override // okhttp3.internal.b
                public final void execute() {
                    try {
                        e.this.Co.a(lVar);
                    } catch (IOException unused) {
                    }
                }
            });
        }

        @Override // okhttp3.internal.http2.f.b
        public final void b(boolean z, int i, int i2) {
            if (z) {
                j jVarBE = e.this.bE(i);
                if (jVarBE != null) {
                    jVarBE.hf();
                    return;
                }
                return;
            }
            e.this.a(true, i, i2, (j) null);
        }

        @Override // okhttp3.internal.http2.f.b
        public final void a(int i, ByteString byteString) {
            g[] gVarArr;
            byteString.size();
            synchronized (e.this) {
                gVarArr = (g[]) e.this.Cb.values().toArray(new g[e.this.Cb.size()]);
                e.this.Ce = true;
            }
            for (g gVar : gVarArr) {
                if (gVar.getId() > i && gVar.gT()) {
                    gVar.e(ErrorCode.REFUSED_STREAM);
                    e.this.bD(gVar.getId());
                }
            }
        }

        @Override // okhttp3.internal.http2.f.b
        public final void c(int i, long j) {
            if (i == 0) {
                synchronized (e.this) {
                    e.this.Ck += j;
                    e.this.notifyAll();
                }
                return;
            }
            g gVarBC = e.this.bC(i);
            if (gVarBC != null) {
                synchronized (gVarBC) {
                    gVarBC.m(j);
                }
            }
        }

        @Override // okhttp3.internal.http2.f.b
        public final void b(int i, List<okhttp3.internal.http2.a> list) {
            e.this.a(i, list);
        }
    }

    final void a(final int i, final List<okhttp3.internal.http2.a> list) {
        synchronized (this) {
            if (this.Cq.contains(Integer.valueOf(i))) {
                a(i, ErrorCode.PROTOCOL_ERROR);
            } else {
                this.Cq.add(Integer.valueOf(i));
                this.Cf.execute(new okhttp3.internal.b("OkHttp %s Push Request[%s]", new Object[]{this.hostname, Integer.valueOf(i)}) { // from class: okhttp3.internal.http2.e.3
                    @Override // okhttp3.internal.b
                    public final void execute() {
                        try {
                            e.this.Co.d(i, ErrorCode.CANCEL);
                            synchronized (e.this) {
                                e.this.Cq.remove(Integer.valueOf(i));
                            }
                        } catch (IOException unused) {
                        }
                    }
                });
            }
        }
    }

    final void b(final int i, final List<okhttp3.internal.http2.a> list, final boolean z) {
        this.Cf.execute(new okhttp3.internal.b("OkHttp %s Push Headers[%s]", new Object[]{this.hostname, Integer.valueOf(i)}) { // from class: okhttp3.internal.http2.e.4
            @Override // okhttp3.internal.b
            public final void execute() {
                try {
                    e.this.Co.d(i, ErrorCode.CANCEL);
                    synchronized (e.this) {
                        e.this.Cq.remove(Integer.valueOf(i));
                    }
                } catch (IOException unused) {
                }
            }
        });
    }

    final void a(final int i, BufferedSource bufferedSource, final int i2, final boolean z) throws IOException {
        final Buffer buffer = new Buffer();
        long j = i2;
        bufferedSource.require(j);
        bufferedSource.read(buffer, j);
        if (buffer.size() != j) {
            throw new IOException(buffer.size() + " != " + i2);
        }
        this.Cf.execute(new okhttp3.internal.b("OkHttp %s Push Data[%s]", new Object[]{this.hostname, Integer.valueOf(i)}) { // from class: okhttp3.internal.http2.e.5
            @Override // okhttp3.internal.b
            public final void execute() {
                try {
                    e.this.Ch.b(buffer, i2);
                    e.this.Co.d(i, ErrorCode.CANCEL);
                    synchronized (e.this) {
                        e.this.Cq.remove(Integer.valueOf(i));
                    }
                } catch (IOException unused) {
                }
            }
        });
    }

    final void c(final int i, final ErrorCode errorCode) {
        this.Cf.execute(new okhttp3.internal.b("OkHttp %s Push Reset[%s]", new Object[]{this.hostname, Integer.valueOf(i)}) { // from class: okhttp3.internal.http2.e.6
            @Override // okhttp3.internal.b
            public final void execute() {
                synchronized (e.this) {
                    e.this.Cq.remove(Integer.valueOf(i));
                }
            }
        });
    }
}
