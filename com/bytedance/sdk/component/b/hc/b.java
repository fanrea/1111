package com.bytedance.sdk.component.b.hc;

import com.bytedance.sdk.component.b.hc.d.d.c;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class b implements Closeable, Flushable {
    final com.bytedance.sdk.component.b.hc.d.d.an d;
    final com.bytedance.sdk.component.b.hc.d.d.c hc;

    void update(j jVar, j jVar2) {
        c.d dVarD;
        hc hcVar = new hc(jVar2);
        try {
            dVarD = ((d) jVar.gb()).d.d();
            if (dVarD != null) {
                try {
                    hcVar.d(dVarD);
                    dVarD.hc();
                } catch (IOException unused) {
                    d(dVarD);
                }
            }
        } catch (IOException unused2) {
            dVarD = null;
        }
    }

    private void d(c.d dVar) {
        if (dVar != null) {
            try {
                dVar.b();
            } catch (IOException unused) {
            }
        }
    }

    public void delete() throws IOException {
        this.hc.delete();
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        this.hc.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.hc.close();
    }

    private static final class hc {
        private static final String d = com.bytedance.sdk.component.b.hc.d.h.u.hc().b() + "-Sent-Millis";
        private static final String hc = com.bytedance.sdk.component.b.hc.d.h.u.hc().b() + "-Received-Millis";
        private final np an;
        private final String b;
        private final yo c;
        private final String gb;
        private final int h;
        private final long mk;
        private final long mq;
        private final w tc;
        private final yo tt;
        private final String u;

        hc(j jVar) {
            this.b = jVar.d().d().toString();
            this.c = com.bytedance.sdk.component.b.hc.d.b.u.hc(jVar);
            this.u = jVar.d().hc();
            this.an = jVar.hc();
            this.h = jVar.b();
            this.gb = jVar.u();
            this.tt = jVar.h();
            this.tc = jVar.an();
            this.mk = jVar.uo();
            this.mq = jVar.k();
        }

        public void d(c.d dVar) throws IOException {
            com.bytedance.sdk.component.b.d.c cVarD = com.bytedance.sdk.component.b.d.mq.d(dVar.d(0));
            cVarD.hc(this.b).tt(10);
            cVarD.hc(this.u).tt(10);
            cVarD.mq(this.c.d()).tt(10);
            int iD = this.c.d();
            for (int i = 0; i < iD; i++) {
                cVarD.hc(this.c.d(i)).hc(": ").hc(this.c.hc(i)).tt(10);
            }
            cVarD.hc(new com.bytedance.sdk.component.b.hc.d.b.mk(this.an, this.h, this.gb).toString()).tt(10);
            cVarD.mq(this.tt.d() + 2).tt(10);
            int iD2 = this.tt.d();
            for (int i2 = 0; i2 < iD2; i2++) {
                cVarD.hc(this.tt.d(i2)).hc(": ").hc(this.tt.hc(i2)).tt(10);
            }
            cVarD.hc(d).hc(": ").mq(this.mk).tt(10);
            cVarD.hc(hc).hc(": ").mq(this.mq).tt(10);
            if (d()) {
                cVarD.tt(10);
                cVarD.hc(this.tc.hc().d()).tt(10);
                d(cVarD, this.tc.b());
                d(cVarD, this.tc.c());
                cVarD.hc(this.tc.d().d()).tt(10);
            }
            cVarD.close();
        }

        private boolean d() {
            return this.b.startsWith("https://");
        }

        private void d(com.bytedance.sdk.component.b.d.c cVar, List<Certificate> list) throws IOException {
            try {
                cVar.mq(list.size()).tt(10);
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    cVar.hc(com.bytedance.sdk.component.b.d.an.d(list.get(i).getEncoded()).hc()).tt(10);
                }
            } catch (CertificateEncodingException e) {
                throw new IOException(e.getMessage());
            }
        }
    }

    private static class d extends s {
        private final String b;
        private final String c;
        final c.b d;
        private final com.bytedance.sdk.component.b.d.u hc;

        @Override // com.bytedance.sdk.component.b.hc.s
        public sy d() {
            String str = this.b;
            if (str != null) {
                return sy.d(str);
            }
            return null;
        }

        @Override // com.bytedance.sdk.component.b.hc.s
        public long hc() {
            try {
                String str = this.c;
                if (str != null) {
                    return Long.parseLong(str);
                }
                return -1L;
            } catch (NumberFormatException unused) {
                return -1L;
            }
        }

        @Override // com.bytedance.sdk.component.b.hc.s
        public com.bytedance.sdk.component.b.d.u b() {
            return this.hc;
        }
    }
}
