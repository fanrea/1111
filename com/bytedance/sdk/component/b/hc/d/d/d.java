package com.bytedance.sdk.component.b.hc.d.d;

import com.bytedance.sdk.component.b.d.mq;
import com.bytedance.sdk.component.b.d.rf;
import com.bytedance.sdk.component.b.d.yo;
import com.bytedance.sdk.component.b.hc.d.b.gb;
import com.bytedance.sdk.component.b.hc.d.d.b;
import com.bytedance.sdk.component.b.hc.he;
import com.bytedance.sdk.component.b.hc.j;
import com.bytedance.sdk.component.b.hc.jh;
import com.bytedance.sdk.component.b.hc.np;
import com.bytedance.sdk.component.b.hc.s;
import com.bytedance.sdk.component.b.hc.yo;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class d implements jh {
    final an d;

    public d(an anVar) {
        this.d = anVar;
    }

    @Override // com.bytedance.sdk.component.b.hc.jh
    public j d(jh.d dVar) throws IOException {
        an anVar = this.d;
        j jVarD = anVar != null ? anVar.d(dVar.d()) : null;
        b bVarD = new b.d(System.currentTimeMillis(), dVar.d(), jVarD).d();
        he heVar = bVarD.d;
        j jVar = bVarD.hc;
        if (jVarD != null && jVar == null) {
            com.bytedance.sdk.component.b.hc.d.b.d(jVarD.gb());
        }
        if (heVar == null && jVar == null) {
            return new j.d().d(dVar.d()).d(np.HTTP_1_1).d(504).d("Unsatisfiable Request (only-if-cached)").d(com.bytedance.sdk.component.b.hc.d.b.b).d(-1L).hc(System.currentTimeMillis()).d();
        }
        if (heVar == null) {
            return jVar.tt().hc(d(jVar)).d();
        }
        try {
            j jVarD2 = dVar.d(heVar);
            if (jVarD2 == null && jVarD != null) {
            }
            if (jVar != null) {
                if (jVarD2.b() == 304) {
                    j jVarD3 = jVar.tt().d(d(jVar.h(), jVarD2.h())).d(jVarD2.uo()).hc(jVarD2.k()).hc(d(jVar)).d(d(jVarD2)).d();
                    jVarD2.gb().close();
                    this.d.update(jVar, jVarD3);
                    return jVarD3;
                }
                com.bytedance.sdk.component.b.hc.d.b.d(jVar.gb());
            }
            j jVarD4 = jVarD2.tt().hc(d(jVar)).d(d(jVarD2)).d();
            if (this.d != null) {
                if (com.bytedance.sdk.component.b.hc.d.b.u.b(jVarD4) && b.d(jVarD4, heVar)) {
                    return d(this.d.d(jVarD4), jVarD4);
                }
                com.bytedance.sdk.component.b.hc.d.b.an.d(heVar.hc());
            }
            return jVarD4;
        } finally {
            if (jVarD != null) {
                com.bytedance.sdk.component.b.hc.d.b.d(jVarD.gb());
            }
        }
    }

    private static j d(j jVar) {
        return (jVar == null || jVar.gb() == null) ? jVar : jVar.tt().d((s) null).d();
    }

    private j d(final hc hcVar, j jVar) throws IOException {
        yo yoVarD;
        if (hcVar == null || (yoVarD = hcVar.d()) == null) {
            return jVar;
        }
        final com.bytedance.sdk.component.b.d.u uVarB = jVar.gb().b();
        final com.bytedance.sdk.component.b.d.c cVarD = mq.d(yoVarD);
        return jVar.tt().d(new gb(jVar.d("Content-Type"), jVar.gb().hc(), mq.d(new rf() { // from class: com.bytedance.sdk.component.b.hc.d.d.d.1
            boolean d;

            @Override // com.bytedance.sdk.component.b.d.rf
            public long d(com.bytedance.sdk.component.b.d.b bVar, long j) throws IOException {
                try {
                    long jD = uVarB.d(bVar, j);
                    if (jD == -1) {
                        if (!this.d) {
                            this.d = true;
                            cVarD.close();
                        }
                        return -1L;
                    }
                    bVar.d(cVarD.b(), bVar.hc() - jD, jD);
                    cVarD.sy();
                    return jD;
                } catch (IOException e) {
                    if (!this.d) {
                        this.d = true;
                    }
                    throw e;
                }
            }

            @Override // com.bytedance.sdk.component.b.d.rf
            public com.bytedance.sdk.component.b.d.jh d() {
                return uVarB.d();
            }

            @Override // com.bytedance.sdk.component.b.d.rf, java.lang.AutoCloseable, java.nio.channels.Channel
            public void close() throws IOException {
                if (!this.d && !com.bytedance.sdk.component.b.hc.d.b.d(this, 100, TimeUnit.MILLISECONDS)) {
                    this.d = true;
                }
                uVarB.close();
            }
        }))).d();
    }

    private static com.bytedance.sdk.component.b.hc.yo d(com.bytedance.sdk.component.b.hc.yo yoVar, com.bytedance.sdk.component.b.hc.yo yoVar2) {
        yo.d dVar = new yo.d();
        int iD = yoVar.d();
        for (int i = 0; i < iD; i++) {
            String strD = yoVar.d(i);
            String strHc = yoVar.hc(i);
            if ((!"Warning".equalsIgnoreCase(strD) || !strHc.startsWith("1")) && (!d(strD) || yoVar2.d(strD) == null)) {
                com.bytedance.sdk.component.b.hc.d.d.d.d(dVar, strD, strHc);
            }
        }
        int iD2 = yoVar2.d();
        for (int i2 = 0; i2 < iD2; i2++) {
            String strD2 = yoVar2.d(i2);
            if (!"Content-Length".equalsIgnoreCase(strD2) && d(strD2)) {
                com.bytedance.sdk.component.b.hc.d.d.d.d(dVar, strD2, yoVar2.hc(i2));
            }
        }
        return dVar.d();
    }

    static boolean d(String str) {
        return ("Connection".equalsIgnoreCase(str) || "Keep-Alive".equalsIgnoreCase(str) || "Proxy-Authenticate".equalsIgnoreCase(str) || "Proxy-Authorization".equalsIgnoreCase(str) || "TE".equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || "Transfer-Encoding".equalsIgnoreCase(str) || "Upgrade".equalsIgnoreCase(str)) ? false : true;
    }
}
