package com.bytedance.sdk.component.b.hc.d.c;

import android.support.v4.media.session.PlaybackStateCompat;
import com.alipay.sdk.m.u.i;
import com.bytedance.sdk.component.b.d.jh;
import com.bytedance.sdk.component.b.d.mq;
import com.bytedance.sdk.component.b.d.rf;
import com.bytedance.sdk.component.b.d.yo;
import com.bytedance.sdk.component.b.hc.d.b.gb;
import com.bytedance.sdk.component.b.hc.d.b.mk;
import com.bytedance.sdk.component.b.hc.d.b.tt;
import com.bytedance.sdk.component.b.hc.d.hc.h;
import com.bytedance.sdk.component.b.hc.he;
import com.bytedance.sdk.component.b.hc.j;
import com.bytedance.sdk.component.b.hc.s;
import com.bytedance.sdk.component.b.hc.v;
import com.bytedance.sdk.component.b.hc.yo;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class d implements com.bytedance.sdk.component.b.hc.d.b.b {
    final com.bytedance.sdk.component.b.d.u b;
    final com.bytedance.sdk.component.b.d.c c;
    final v d;
    final h hc;
    int u = 0;
    private long an = PlaybackStateCompat.ACTION_SET_REPEAT_MODE;

    public d(v vVar, h hVar, com.bytedance.sdk.component.b.d.u uVar, com.bytedance.sdk.component.b.d.c cVar) {
        this.d = vVar;
        this.hc = hVar;
        this.b = uVar;
        this.c = cVar;
    }

    @Override // com.bytedance.sdk.component.b.hc.d.b.b
    public yo d(he heVar, long j) {
        if ("chunked".equalsIgnoreCase(heVar.d("Transfer-Encoding"))) {
            return u();
        }
        if (j != -1) {
            return d(j);
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    @Override // com.bytedance.sdk.component.b.hc.d.b.b
    public void b() throws IOException {
        com.bytedance.sdk.component.b.hc.d.hc.b bVarHc = this.hc.hc();
        if (bVarHc != null) {
            bVarHc.hc();
        }
    }

    @Override // com.bytedance.sdk.component.b.hc.d.b.b
    public void d(he heVar) throws IOException {
        d(heVar.b(), tt.d(heVar, this.hc.hc().d().hc().type()));
    }

    @Override // com.bytedance.sdk.component.b.hc.d.b.b
    public s d(j jVar) throws IOException {
        String strD = jVar.d("Content-Type");
        if (!com.bytedance.sdk.component.b.hc.d.b.u.b(jVar)) {
            return new gb(strD, 0L, mq.d(hc(0L)));
        }
        if ("chunked".equalsIgnoreCase(jVar.d("Transfer-Encoding"))) {
            return new gb(strD, -1L, mq.d(d(jVar.d().d())));
        }
        long jD = com.bytedance.sdk.component.b.hc.d.b.u.d(jVar);
        if (jD != -1) {
            return new gb(strD, jD, mq.d(hc(jD)));
        }
        return new gb(strD, -1L, mq.d(an()));
    }

    @Override // com.bytedance.sdk.component.b.hc.d.b.b
    public void d() throws IOException {
        this.c.flush();
    }

    @Override // com.bytedance.sdk.component.b.hc.d.b.b
    public void hc() throws IOException {
        this.c.flush();
    }

    public void d(com.bytedance.sdk.component.b.hc.yo yoVar, String str) throws IOException {
        if (this.u != 0) {
            throw new IllegalStateException("state: " + this.u);
        }
        this.c.hc(str).hc("\r\n");
        int iD = yoVar.d();
        for (int i = 0; i < iD; i++) {
            this.c.hc(yoVar.d(i)).hc(": ").hc(yoVar.hc(i)).hc("\r\n");
        }
        this.c.hc("\r\n");
        this.u = 1;
    }

    @Override // com.bytedance.sdk.component.b.hc.d.b.b
    public j.d d(boolean z) throws NumberFormatException, IOException {
        int i = this.u;
        if (i != 1 && i != 3) {
            throw new IllegalStateException("state: " + this.u);
        }
        try {
            mk mkVarD = mk.d(h());
            j.d dVarD = new j.d().d(mkVarD.d).d(mkVarD.hc).d(mkVarD.b).d(c());
            if (z && mkVarD.hc == 100) {
                return null;
            }
            this.u = 4;
            return dVarD;
        } catch (EOFException e) {
            IOException iOException = new IOException("unexpected end of stream on " + this.hc);
            iOException.initCause(e);
            throw iOException;
        }
    }

    private String h() throws IOException {
        String strU = this.b.u(this.an);
        this.an -= strU.length();
        return strU;
    }

    public com.bytedance.sdk.component.b.hc.yo c() throws IOException {
        yo.d dVar = new yo.d();
        while (true) {
            String strH = h();
            if (strH.length() != 0) {
                com.bytedance.sdk.component.b.hc.d.d.d.d(dVar, strH);
            } else {
                return dVar.d();
            }
        }
    }

    public com.bytedance.sdk.component.b.d.yo u() {
        if (this.u != 1) {
            throw new IllegalStateException("state: " + this.u);
        }
        this.u = 2;
        return new hc();
    }

    public com.bytedance.sdk.component.b.d.yo d(long j) {
        if (this.u != 1) {
            throw new IllegalStateException("state: " + this.u);
        }
        this.u = 2;
        return new c(j);
    }

    public rf hc(long j) throws IOException {
        if (this.u != 4) {
            throw new IllegalStateException("state: " + this.u);
        }
        this.u = 5;
        return new u(j);
    }

    public rf d(com.bytedance.sdk.component.b.hc.rf rfVar) throws IOException {
        if (this.u != 4) {
            throw new IllegalStateException("state: " + this.u);
        }
        this.u = 5;
        return new b(rfVar);
    }

    public rf an() throws IOException {
        if (this.u != 4) {
            throw new IllegalStateException("state: " + this.u);
        }
        h hVar = this.hc;
        if (hVar == null) {
            throw new IllegalStateException("streamAllocation == null");
        }
        this.u = 5;
        hVar.c();
        return new an();
    }

    void d(com.bytedance.sdk.component.b.d.tt ttVar) {
        jh jhVarD = ttVar.d();
        ttVar.d(jh.b);
        jhVarD.an();
        jhVarD.u();
    }

    private final class c implements com.bytedance.sdk.component.b.d.yo {
        private boolean b;
        private long c;
        private final com.bytedance.sdk.component.b.d.tt hc;

        c(long j) {
            this.hc = new com.bytedance.sdk.component.b.d.tt(d.this.c.d());
            this.c = j;
        }

        @Override // com.bytedance.sdk.component.b.d.yo, com.bytedance.sdk.component.b.d.rf
        public jh d() {
            return this.hc;
        }

        @Override // com.bytedance.sdk.component.b.d.yo
        public void a_(com.bytedance.sdk.component.b.d.b bVar, long j) throws IOException {
            if (this.b) {
                throw new IllegalStateException("closed");
            }
            com.bytedance.sdk.component.b.hc.d.b.d(bVar.hc(), 0L, j);
            if (j > this.c) {
                throw new ProtocolException("expected " + this.c + " bytes but received " + j);
            }
            d.this.c.a_(bVar, j);
            this.c -= j;
        }

        @Override // com.bytedance.sdk.component.b.d.yo, java.io.Flushable
        public void flush() throws IOException {
            if (this.b) {
                return;
            }
            d.this.c.flush();
        }

        @Override // com.bytedance.sdk.component.b.d.yo, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel, com.bytedance.sdk.component.b.d.rf
        public void close() throws IOException {
            if (this.b) {
                return;
            }
            this.b = true;
            if (this.c > 0) {
                throw new ProtocolException("unexpected end of stream");
            }
            d.this.d(this.hc);
            d.this.u = 3;
        }
    }

    private final class hc implements com.bytedance.sdk.component.b.d.yo {
        private boolean b;
        private final com.bytedance.sdk.component.b.d.tt hc;

        hc() {
            this.hc = new com.bytedance.sdk.component.b.d.tt(d.this.c.d());
        }

        @Override // com.bytedance.sdk.component.b.d.yo, com.bytedance.sdk.component.b.d.rf
        public jh d() {
            return this.hc;
        }

        @Override // com.bytedance.sdk.component.b.d.yo
        public void a_(com.bytedance.sdk.component.b.d.b bVar, long j) throws IOException {
            if (this.b) {
                throw new IllegalStateException("closed");
            }
            if (j == 0) {
                return;
            }
            d.this.c.mk(j);
            d.this.c.hc("\r\n");
            d.this.c.a_(bVar, j);
            d.this.c.hc("\r\n");
        }

        @Override // com.bytedance.sdk.component.b.d.yo, java.io.Flushable
        public synchronized void flush() throws IOException {
            if (this.b) {
                return;
            }
            d.this.c.flush();
        }

        @Override // com.bytedance.sdk.component.b.d.yo, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel, com.bytedance.sdk.component.b.d.rf
        public synchronized void close() throws IOException {
            if (this.b) {
                return;
            }
            this.b = true;
            d.this.c.hc("0\r\n\r\n");
            d.this.d(this.hc);
            d.this.u = 3;
        }
    }

    /* renamed from: com.bytedance.sdk.component.b.hc.d.c.d$d, reason: collision with other inner class name */
    private abstract class AbstractC0273d implements rf {
        protected long b;
        protected final com.bytedance.sdk.component.b.d.tt d;
        protected boolean hc;

        private AbstractC0273d() {
            this.d = new com.bytedance.sdk.component.b.d.tt(d.this.b.d());
            this.b = 0L;
        }

        @Override // com.bytedance.sdk.component.b.d.rf
        public jh d() {
            return this.d;
        }

        @Override // com.bytedance.sdk.component.b.d.rf
        public long d(com.bytedance.sdk.component.b.d.b bVar, long j) throws IOException {
            try {
                long jD = d.this.b.d(bVar, j);
                if (jD > 0) {
                    this.b += jD;
                }
                return jD;
            } catch (IOException e) {
                d(false, e);
                throw e;
            }
        }

        protected final void d(boolean z, IOException iOException) throws IOException {
            if (d.this.u == 6) {
                return;
            }
            if (d.this.u != 5) {
                throw new IllegalStateException("state: " + d.this.u);
            }
            d.this.d(this.d);
            d.this.u = 6;
            if (d.this.hc != null) {
                d.this.hc.d(!z, d.this, this.b, iOException);
            }
        }
    }

    private class u extends AbstractC0273d {
        private long an;

        u(long j) throws IOException {
            super();
            this.an = j;
            if (j == 0) {
                d(true, (IOException) null);
            }
        }

        @Override // com.bytedance.sdk.component.b.hc.d.c.d.AbstractC0273d, com.bytedance.sdk.component.b.d.rf
        public long d(com.bytedance.sdk.component.b.d.b bVar, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
            }
            if (this.hc) {
                throw new IllegalStateException("closed");
            }
            long j2 = this.an;
            if (j2 == 0) {
                return -1L;
            }
            long jD = super.d(bVar, Math.min(j2, j));
            if (jD == -1) {
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                d(false, (IOException) protocolException);
                throw protocolException;
            }
            long j3 = this.an - jD;
            this.an = j3;
            if (j3 == 0) {
                d(true, (IOException) null);
            }
            return jD;
        }

        @Override // com.bytedance.sdk.component.b.d.rf, java.lang.AutoCloseable, java.nio.channels.Channel
        public void close() throws IOException {
            if (this.hc) {
                return;
            }
            if (this.an != 0 && !com.bytedance.sdk.component.b.hc.d.b.d(this, 100, TimeUnit.MILLISECONDS)) {
                d(false, (IOException) null);
            }
            this.hc = true;
        }
    }

    private class b extends AbstractC0273d {
        private final com.bytedance.sdk.component.b.hc.rf an;
        private boolean gb;
        private long h;

        b(com.bytedance.sdk.component.b.hc.rf rfVar) {
            super();
            this.h = -1L;
            this.gb = true;
            this.an = rfVar;
        }

        @Override // com.bytedance.sdk.component.b.hc.d.c.d.AbstractC0273d, com.bytedance.sdk.component.b.d.rf
        public long d(com.bytedance.sdk.component.b.d.b bVar, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
            }
            if (this.hc) {
                throw new IllegalStateException("closed");
            }
            if (!this.gb) {
                return -1L;
            }
            long j2 = this.h;
            if (j2 == 0 || j2 == -1) {
                hc();
                if (!this.gb) {
                    return -1L;
                }
            }
            long jD = super.d(bVar, Math.min(j, this.h));
            if (jD == -1) {
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                d(false, (IOException) protocolException);
                throw protocolException;
            }
            this.h -= jD;
            return jD;
        }

        private void hc() throws IOException {
            if (this.h != -1) {
                d.this.b.cb();
            }
            try {
                this.h = d.this.b.uo();
                String strTrim = d.this.b.cb().trim();
                if (this.h < 0 || !(strTrim.isEmpty() || strTrim.startsWith(i.b))) {
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.h + strTrim + "\"");
                }
                if (this.h == 0) {
                    this.gb = false;
                    com.bytedance.sdk.component.b.hc.d.b.u.d(d.this.d.an(), this.an, d.this.c());
                    d(true, (IOException) null);
                }
            } catch (NumberFormatException e) {
                throw new ProtocolException(e.getMessage());
            }
        }

        @Override // com.bytedance.sdk.component.b.d.rf, java.lang.AutoCloseable, java.nio.channels.Channel
        public void close() throws IOException {
            if (this.hc) {
                return;
            }
            if (this.gb && !com.bytedance.sdk.component.b.hc.d.b.d(this, 100, TimeUnit.MILLISECONDS)) {
                d(false, (IOException) null);
            }
            this.hc = true;
        }
    }

    private class an extends AbstractC0273d {
        private boolean an;

        an() {
            super();
        }

        @Override // com.bytedance.sdk.component.b.hc.d.c.d.AbstractC0273d, com.bytedance.sdk.component.b.d.rf
        public long d(com.bytedance.sdk.component.b.d.b bVar, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
            }
            if (this.hc) {
                throw new IllegalStateException("closed");
            }
            if (this.an) {
                return -1L;
            }
            long jD = super.d(bVar, j);
            if (jD != -1) {
                return jD;
            }
            this.an = true;
            d(true, (IOException) null);
            return -1L;
        }

        @Override // com.bytedance.sdk.component.b.d.rf, java.lang.AutoCloseable, java.nio.channels.Channel
        public void close() throws IOException {
            if (this.hc) {
                return;
            }
            if (!this.an) {
                d(false, (IOException) null);
            }
            this.hc = true;
        }
    }
}
