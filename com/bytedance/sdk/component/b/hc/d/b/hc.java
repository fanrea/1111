package com.bytedance.sdk.component.b.hc.d.b;

import com.bytedance.sdk.component.b.d.yo;
import com.bytedance.sdk.component.b.hc.he;
import com.bytedance.sdk.component.b.hc.j;
import com.bytedance.sdk.component.b.hc.jh;
import java.io.IOException;
import java.net.ProtocolException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class hc implements jh {
    private final boolean d;

    public hc(boolean z) {
        this.d = z;
    }

    @Override // com.bytedance.sdk.component.b.hc.jh
    public j d(jh.d dVar) throws IOException {
        j jVarD;
        h hVar = (h) dVar;
        b bVarH = hVar.h();
        com.bytedance.sdk.component.b.hc.d.hc.h hVarAn = hVar.an();
        com.bytedance.sdk.component.b.hc.d.hc.b bVar = (com.bytedance.sdk.component.b.hc.d.hc.b) hVar.u();
        he heVarD = hVar.d();
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (heVarD != null && heVarD.an != null) {
            heVarD.an.d(jCurrentTimeMillis);
        }
        hVar.call();
        bVarH.d(heVarD);
        hVar.call();
        j.d dVarD = null;
        if (an.b(heVarD.hc()) && heVarD.c() != null) {
            if ("100-continue".equalsIgnoreCase(heVarD.d("Expect"))) {
                bVarH.d();
                hVar.call();
                dVarD = bVarH.d(true);
            }
            if (dVarD == null) {
                hVar.call();
                com.bytedance.sdk.component.b.d.c cVarD = com.bytedance.sdk.component.b.d.mq.d(new d(bVarH.d(heVarD, heVarD.c().hc())));
                heVarD.c().d(cVarD);
                cVarD.close();
                hVar.call();
            } else if (!bVar.u()) {
                hVarAn.c();
            }
        }
        bVarH.hc();
        if (dVarD == null) {
            hVar.call();
            dVarD = bVarH.d(false);
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        if (heVarD.an != null) {
            heVarD.an.hc(jCurrentTimeMillis2);
        }
        j jVarD2 = dVarD.d(heVarD).d(hVarAn.hc().c()).d(jCurrentTimeMillis).hc(jCurrentTimeMillis2).d();
        hVar.call();
        int iB = jVarD2.b();
        if (this.d && iB == 101) {
            jVarD = jVarD2.tt().d(com.bytedance.sdk.component.b.hc.d.b.b).d();
        } else {
            jVarD = jVarD2.tt().d(bVarH.d(jVarD2)).d();
        }
        if ("close".equalsIgnoreCase(jVarD.d().d("Connection")) || "close".equalsIgnoreCase(jVarD.d("Connection"))) {
            hVarAn.c();
        }
        if ((iB == 204 || iB == 205) && jVarD.gb().hc() > 0) {
            throw new ProtocolException("HTTP " + iB + " had non-zero Content-Length: " + jVarD.gb().hc());
        }
        return jVarD;
    }

    static final class d extends com.bytedance.sdk.component.b.d.h {
        long d;

        d(yo yoVar) {
            super(yoVar);
        }

        @Override // com.bytedance.sdk.component.b.d.h, com.bytedance.sdk.component.b.d.yo
        public void a_(com.bytedance.sdk.component.b.d.b bVar, long j) throws IOException {
            super.a_(bVar, j);
            this.d += j;
        }
    }
}
