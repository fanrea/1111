package okhttp3.internal.http2;

import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import okio.AsyncTimeout;
import okio.Buffer;
import okio.BufferedSource;
import okio.Sink;
import okio.Source;
import okio.Timeout;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class g {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    final e BW;
    private final List<okhttp3.internal.http2.a> CL;
    private List<okhttp3.internal.http2.a> CM;
    private boolean CN;
    private final b CO;
    final a CP;
    long Ck;
    final int id;
    long Cj = 0;
    final c CQ = new c();
    final c CR = new c();
    ErrorCode errorCode = null;

    g(int i, e eVar, boolean z, boolean z2, List<okhttp3.internal.http2.a> list) {
        if (eVar == null) {
            throw new NullPointerException("connection == null");
        }
        if (list == null) {
            throw new NullPointerException("requestHeaders == null");
        }
        this.id = i;
        this.BW = eVar;
        this.Ck = eVar.Cm.hh();
        this.CO = new b(eVar.Cl.hh());
        this.CP = new a();
        this.CO.finished = z2;
        this.CP.finished = z;
        this.CL = list;
    }

    public final int getId() {
        return this.id;
    }

    public final synchronized boolean isOpen() {
        if (this.errorCode != null) {
            return false;
        }
        if ((this.CO.finished || this.CO.closed) && (this.CP.finished || this.CP.closed)) {
            if (this.CN) {
                return false;
            }
        }
        return true;
    }

    public final boolean gT() {
        return this.BW.BZ == ((this.id & 1) == 1);
    }

    public final synchronized List<okhttp3.internal.http2.a> gU() {
        List<okhttp3.internal.http2.a> list;
        if (!gT()) {
            throw new IllegalStateException("servers cannot read response headers");
        }
        this.CQ.enter();
        while (this.CM == null && this.errorCode == null) {
            try {
                ha();
            } catch (Throwable th) {
                this.CQ.hb();
                throw th;
            }
        }
        this.CQ.hb();
        list = this.CM;
        if (list != null) {
            this.CM = null;
        } else {
            throw new StreamResetException(this.errorCode);
        }
        return list;
    }

    public final Timeout gV() {
        return this.CQ;
    }

    public final Timeout gW() {
        return this.CR;
    }

    public final Source gX() {
        return this.CO;
    }

    public final Sink gY() {
        synchronized (this) {
            if (!this.CN && !gT()) {
                throw new IllegalStateException("reply before requesting the sink");
            }
        }
        return this.CP;
    }

    public final void b(ErrorCode errorCode) {
        if (d(errorCode)) {
            this.BW.b(this.id, errorCode);
        }
    }

    public final void c(ErrorCode errorCode) {
        if (d(errorCode)) {
            this.BW.a(this.id, errorCode);
        }
    }

    private boolean d(ErrorCode errorCode) {
        synchronized (this) {
            if (this.errorCode != null) {
                return false;
            }
            if (this.CO.finished && this.CP.finished) {
                return false;
            }
            this.errorCode = errorCode;
            notifyAll();
            this.BW.bD(this.id);
            return true;
        }
    }

    final void k(List<okhttp3.internal.http2.a> list) {
        boolean zIsOpen;
        synchronized (this) {
            zIsOpen = true;
            this.CN = true;
            if (this.CM == null) {
                this.CM = list;
                zIsOpen = isOpen();
                notifyAll();
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.CM);
                arrayList.add(null);
                arrayList.addAll(list);
                this.CM = arrayList;
            }
        }
        if (zIsOpen) {
            return;
        }
        this.BW.bD(this.id);
    }

    final void a(BufferedSource bufferedSource, int i) throws IOException {
        this.CO.a(bufferedSource, i);
    }

    final void gZ() {
        boolean zIsOpen;
        synchronized (this) {
            this.CO.finished = true;
            zIsOpen = isOpen();
            notifyAll();
        }
        if (zIsOpen) {
            return;
        }
        this.BW.bD(this.id);
    }

    final synchronized void e(ErrorCode errorCode) {
        if (this.errorCode == null) {
            this.errorCode = errorCode;
            notifyAll();
        }
    }

    final class b implements Source {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final Buffer CU = new Buffer();
        private final Buffer CV = new Buffer();
        private final long CW;
        boolean closed;
        boolean finished;

        b(long j) {
            this.CW = j;
        }

        final void a(BufferedSource bufferedSource, long j) throws IOException {
            boolean z;
            boolean z2;
            boolean z3;
            while (j > 0) {
                synchronized (g.this) {
                    z = this.finished;
                    z2 = true;
                    z3 = this.CV.size() + j > this.CW;
                }
                if (z3) {
                    bufferedSource.skip(j);
                    g.this.c(ErrorCode.FLOW_CONTROL_ERROR);
                    return;
                }
                if (z) {
                    bufferedSource.skip(j);
                    return;
                }
                long j2 = bufferedSource.read(this.CU, j);
                if (j2 == -1) {
                    throw new EOFException();
                }
                j -= j2;
                synchronized (g.this) {
                    if (this.CV.size() != 0) {
                        z2 = false;
                    }
                    this.CV.writeAll(this.CU);
                    if (z2) {
                        g.this.notifyAll();
                    }
                }
            }
        }
    }

    final class a implements Sink {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final Buffer CS = new Buffer();
        boolean closed;
        boolean finished;

        a() {
        }
    }

    final void m(long j) {
        this.Ck += j;
        if (j > 0) {
            notifyAll();
        }
    }

    private void ha() throws InterruptedException, InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException unused) {
            throw new InterruptedIOException();
        }
    }

    class c extends AsyncTimeout {
        c() {
        }

        private static IOException c(IOException iOException) {
            return new SocketTimeoutException("timeout");
        }

        public final void hb() throws IOException {
            if (exit()) {
                throw c(null);
            }
        }
    }
}
