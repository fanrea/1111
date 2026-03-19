package com.bytedance.sdk.component.b.hc;

import com.bytedance.sdk.component.b.hc.yo;
import java.io.Closeable;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class j implements Closeable {
    final yo an;
    final int b;
    final String c;
    final he d;
    final j gb;
    final s h;
    final np hc;
    final long mk;
    final long mq;
    final j tc;
    final j tt;
    final w u;
    private volatile c uo;

    j(d dVar) {
        this.d = dVar.d;
        this.hc = dVar.hc;
        this.b = dVar.b;
        this.c = dVar.c;
        this.u = dVar.u;
        this.an = dVar.an.d();
        this.h = dVar.h;
        this.gb = dVar.gb;
        this.tt = dVar.tt;
        this.tc = dVar.tc;
        this.mk = dVar.mk;
        this.mq = dVar.mq;
    }

    public he d() {
        return this.d;
    }

    public np hc() {
        return this.hc;
    }

    public int b() {
        return this.b;
    }

    public boolean c() {
        int i = this.b;
        return i >= 200 && i < 300;
    }

    public String u() {
        return this.c;
    }

    public w an() {
        return this.u;
    }

    public String d(String str) {
        return d(str, null);
    }

    public String d(String str, String str2) {
        String strD = this.an.d(str);
        return strD != null ? strD : str2;
    }

    public yo h() {
        return this.an;
    }

    public s gb() {
        return this.h;
    }

    public d tt() {
        return new d(this);
    }

    public j tc() {
        return this.gb;
    }

    public j mk() {
        return this.tc;
    }

    public c mq() {
        c cVar = this.uo;
        if (cVar != null) {
            return cVar;
        }
        c cVarD = c.d(this.an);
        this.uo = cVarD;
        return cVarD;
    }

    public long uo() {
        return this.mk;
    }

    public long k() {
        return this.mq;
    }

    public zw e() {
        he heVar = this.d;
        if (heVar == null) {
            return null;
        }
        return heVar.an;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        s sVar = this.h;
        if (sVar == null) {
            throw new IllegalStateException("response is not eligible for a body and must not be closed");
        }
        sVar.close();
    }

    public String toString() {
        return "Response{protocol=" + this.hc + ", code=" + this.b + ", message=" + this.c + ", url=" + this.d.d() + '}';
    }

    public static class d {
        yo.d an;
        int b;
        String c;
        he d;
        j gb;
        s h;
        np hc;
        long mk;
        long mq;
        j tc;
        j tt;
        w u;

        public d() {
            this.b = -1;
            this.an = new yo.d();
        }

        d(j jVar) {
            this.b = -1;
            this.d = jVar.d;
            this.hc = jVar.hc;
            this.b = jVar.b;
            this.c = jVar.c;
            this.u = jVar.u;
            this.an = jVar.an.hc();
            this.h = jVar.h;
            this.gb = jVar.gb;
            this.tt = jVar.tt;
            this.tc = jVar.tc;
            this.mk = jVar.mk;
            this.mq = jVar.mq;
        }

        public d d(he heVar) {
            this.d = heVar;
            return this;
        }

        public d d(np npVar) {
            this.hc = npVar;
            return this;
        }

        public d d(int i) {
            this.b = i;
            return this;
        }

        public d d(String str) {
            this.c = str;
            return this;
        }

        public d d(w wVar) {
            this.u = wVar;
            return this;
        }

        public d d(String str, String str2) {
            this.an.d(str, str2);
            return this;
        }

        public d d(yo yoVar) {
            this.an = yoVar.hc();
            return this;
        }

        public d d(s sVar) {
            this.h = sVar;
            return this;
        }

        public d d(j jVar) {
            if (jVar != null) {
                d("networkResponse", jVar);
            }
            this.gb = jVar;
            return this;
        }

        public d hc(j jVar) {
            if (jVar != null) {
                d("cacheResponse", jVar);
            }
            this.tt = jVar;
            return this;
        }

        private void d(String str, j jVar) {
            if (jVar.h != null) {
                throw new IllegalArgumentException(str + ".body != null");
            }
            if (jVar.gb != null) {
                throw new IllegalArgumentException(str + ".networkResponse != null");
            }
            if (jVar.tt != null) {
                throw new IllegalArgumentException(str + ".cacheResponse != null");
            }
            if (jVar.tc != null) {
                throw new IllegalArgumentException(str + ".priorResponse != null");
            }
        }

        public d b(j jVar) {
            if (jVar != null) {
                c(jVar);
            }
            this.tc = jVar;
            return this;
        }

        private void c(j jVar) {
            if (jVar.h != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }

        public d d(long j) {
            this.mk = j;
            return this;
        }

        public d hc(long j) {
            this.mq = j;
            return this;
        }

        public j d() {
            if (this.d == null) {
                throw new IllegalStateException("request == null");
            }
            if (this.hc == null) {
                throw new IllegalStateException("protocol == null");
            }
            if (this.b < 0) {
                throw new IllegalStateException("code < 0: " + this.b);
            }
            if (this.c == null) {
                throw new IllegalStateException("message == null");
            }
            return new j(this);
        }
    }
}
