package com.bytedance.sdk.component.b.hc.d.u;

import com.bytedance.sdk.component.b.d.rf;
import com.bytedance.sdk.component.b.d.yo;
import com.bytedance.sdk.component.b.hc.he;
import com.bytedance.sdk.component.b.hc.j;
import com.bytedance.sdk.component.b.hc.jh;
import com.bytedance.sdk.component.b.hc.np;
import com.bytedance.sdk.component.b.hc.s;
import com.bytedance.sdk.component.b.hc.v;
import com.bytedance.sdk.component.b.hc.yo;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class an implements com.bytedance.sdk.component.b.hc.d.b.b {
    private static final com.bytedance.sdk.component.b.d.an an;
    private static final com.bytedance.sdk.component.b.d.an b;
    private static final com.bytedance.sdk.component.b.d.an c;
    private static final com.bytedance.sdk.component.b.d.an gb;
    private static final com.bytedance.sdk.component.b.d.an h;
    private static final com.bytedance.sdk.component.b.d.an hc;
    private static final List<com.bytedance.sdk.component.b.d.an> mk;
    private static final List<com.bytedance.sdk.component.b.d.an> tc;
    private static final com.bytedance.sdk.component.b.d.an tt;
    private static final com.bytedance.sdk.component.b.d.an u;
    final com.bytedance.sdk.component.b.hc.d.hc.h d;
    private tt e;
    private final h k;
    private final v mq;
    private final jh.d uo;

    static {
        com.bytedance.sdk.component.b.d.an anVarD = com.bytedance.sdk.component.b.d.an.d("connection");
        hc = anVarD;
        com.bytedance.sdk.component.b.d.an anVarD2 = com.bytedance.sdk.component.b.d.an.d("host");
        b = anVarD2;
        com.bytedance.sdk.component.b.d.an anVarD3 = com.bytedance.sdk.component.b.d.an.d("keep-alive");
        c = anVarD3;
        com.bytedance.sdk.component.b.d.an anVarD4 = com.bytedance.sdk.component.b.d.an.d("proxy-connection");
        u = anVarD4;
        com.bytedance.sdk.component.b.d.an anVarD5 = com.bytedance.sdk.component.b.d.an.d("transfer-encoding");
        an = anVarD5;
        com.bytedance.sdk.component.b.d.an anVarD6 = com.bytedance.sdk.component.b.d.an.d("te");
        h = anVarD6;
        com.bytedance.sdk.component.b.d.an anVarD7 = com.bytedance.sdk.component.b.d.an.d("encoding");
        gb = anVarD7;
        com.bytedance.sdk.component.b.d.an anVarD8 = com.bytedance.sdk.component.b.d.an.d("upgrade");
        tt = anVarD8;
        tc = com.bytedance.sdk.component.b.hc.d.b.d(anVarD, anVarD2, anVarD3, anVarD4, anVarD6, anVarD5, anVarD7, anVarD8, b.b, b.c, b.u, b.an);
        mk = com.bytedance.sdk.component.b.hc.d.b.d(anVarD, anVarD2, anVarD3, anVarD4, anVarD6, anVarD5, anVarD7, anVarD8);
    }

    public an(v vVar, jh.d dVar, com.bytedance.sdk.component.b.hc.d.hc.h hVar, h hVar2) {
        this.mq = vVar;
        this.uo = dVar;
        this.d = hVar;
        this.k = hVar2;
    }

    @Override // com.bytedance.sdk.component.b.hc.d.b.b
    public yo d(he heVar, long j) {
        return this.e.gb();
    }

    @Override // com.bytedance.sdk.component.b.hc.d.b.b
    public void d(he heVar) throws IOException {
        if (this.e != null) {
            return;
        }
        tt ttVarD = this.k.d(hc(heVar), heVar.c() != null);
        this.e = ttVarD;
        ttVarD.u().d(this.uo.b(), TimeUnit.MILLISECONDS);
        this.e.an().d(this.uo.c(), TimeUnit.MILLISECONDS);
    }

    @Override // com.bytedance.sdk.component.b.hc.d.b.b
    public void d() throws IOException {
        this.k.hc();
    }

    @Override // com.bytedance.sdk.component.b.hc.d.b.b
    public void hc() throws IOException {
        this.e.gb().close();
    }

    @Override // com.bytedance.sdk.component.b.hc.d.b.b
    public j.d d(boolean z) throws NumberFormatException, IOException {
        j.d dVarD = d(this.e.c());
        if (z && com.bytedance.sdk.component.b.hc.d.d.d.d(dVarD) == 100) {
            return null;
        }
        return dVarD;
    }

    public static List<b> hc(he heVar) {
        com.bytedance.sdk.component.b.hc.yo yoVarB = heVar.b();
        ArrayList arrayList = new ArrayList(yoVarB.d() + 4);
        arrayList.add(new b(b.b, heVar.hc()));
        arrayList.add(new b(b.c, com.bytedance.sdk.component.b.hc.d.b.tt.d(heVar.d())));
        String strD = heVar.d("Host");
        if (strD != null) {
            arrayList.add(new b(b.an, strD));
        }
        arrayList.add(new b(b.u, heVar.d().b()));
        int iD = yoVarB.d();
        for (int i = 0; i < iD; i++) {
            com.bytedance.sdk.component.b.d.an anVarD = com.bytedance.sdk.component.b.d.an.d(yoVarB.d(i).toLowerCase(Locale.US));
            if (!tc.contains(anVarD)) {
                arrayList.add(new b(anVarD, yoVarB.hc(i)));
            }
        }
        return arrayList;
    }

    public static j.d d(List<b> list) throws NumberFormatException, IOException {
        yo.d dVar = new yo.d();
        int size = list.size();
        com.bytedance.sdk.component.b.hc.d.b.mk mkVarD = null;
        for (int i = 0; i < size; i++) {
            b bVar = list.get(i);
            if (bVar == null) {
                if (mkVarD != null && mkVarD.hc == 100) {
                    dVar = new yo.d();
                    mkVarD = null;
                }
            } else {
                com.bytedance.sdk.component.b.d.an anVar = bVar.h;
                String strD = bVar.gb.d();
                if (anVar.equals(b.hc)) {
                    mkVarD = com.bytedance.sdk.component.b.hc.d.b.mk.d("HTTP/1.1 ".concat(String.valueOf(strD)));
                } else if (!mk.contains(anVar)) {
                    com.bytedance.sdk.component.b.hc.d.d.d.d(dVar, anVar.d(), strD);
                }
            }
        }
        if (mkVarD == null) {
            throw new ProtocolException("Expected ':status' header not present");
        }
        return new j.d().d(np.HTTP_2).d(mkVarD.hc).d(mkVarD.b).d(dVar.d());
    }

    @Override // com.bytedance.sdk.component.b.hc.d.b.b
    public s d(j jVar) throws IOException {
        return new com.bytedance.sdk.component.b.hc.d.b.gb(jVar.d("Content-Type"), com.bytedance.sdk.component.b.hc.d.b.u.d(jVar), com.bytedance.sdk.component.b.d.mq.d(new d(this.e.h())));
    }

    @Override // com.bytedance.sdk.component.b.hc.d.b.b
    public void b() {
        tt ttVar = this.e;
        if (ttVar != null) {
            ttVar.hc(hc.CANCEL);
        }
    }

    class d extends com.bytedance.sdk.component.b.d.gb {
        boolean d;
        long hc;

        d(rf rfVar) {
            super(rfVar);
            this.d = false;
            this.hc = 0L;
        }

        @Override // com.bytedance.sdk.component.b.d.gb, com.bytedance.sdk.component.b.d.rf
        public long d(com.bytedance.sdk.component.b.d.b bVar, long j) throws IOException {
            try {
                long jD = hc().d(bVar, j);
                if (jD > 0) {
                    this.hc += jD;
                }
                return jD;
            } catch (IOException e) {
                d(e);
                throw e;
            }
        }

        @Override // com.bytedance.sdk.component.b.d.gb, com.bytedance.sdk.component.b.d.rf, java.lang.AutoCloseable, java.nio.channels.Channel
        public void close() throws IOException {
            super.close();
            d(null);
        }

        private void d(IOException iOException) throws IOException {
            if (this.d) {
                return;
            }
            this.d = true;
            an.this.d.d(false, (com.bytedance.sdk.component.b.hc.d.b.b) an.this, this.hc, iOException);
        }
    }
}
