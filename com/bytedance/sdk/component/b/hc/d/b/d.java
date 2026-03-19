package com.bytedance.sdk.component.b.hc.d.b;

import com.alipay.sdk.m.n.a;
import com.bytedance.sdk.component.b.hc.he;
import com.bytedance.sdk.component.b.hc.j;
import com.bytedance.sdk.component.b.hc.jh;
import com.bytedance.sdk.component.b.hc.sy;
import com.bytedance.sdk.component.b.hc.uo;
import com.bytedance.sdk.component.b.hc.vv;
import com.sigmob.sdk.base.e;
import java.io.IOException;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class d implements jh {
    private final uo d;

    public d(uo uoVar) {
        this.d = uoVar;
    }

    @Override // com.bytedance.sdk.component.b.hc.jh
    public j d(jh.d dVar) throws IOException {
        he heVarD = dVar.d();
        he.d dVarAn = heVarD.an();
        vv vvVarC = heVarD.c();
        if (vvVarC != null) {
            sy syVarD = vvVarC.d();
            if (syVarD != null) {
                dVarAn.d("Content-Type", syVarD.toString());
            }
            long jHc = vvVarC.hc();
            if (jHc != -1) {
                dVarAn.d("Content-Length", Long.toString(jHc));
                dVarAn.hc("Transfer-Encoding");
            } else {
                dVarAn.d("Transfer-Encoding", "chunked");
                dVarAn.hc("Content-Length");
            }
        }
        boolean z = false;
        if (heVarD.d("Host") == null) {
            dVarAn.d("Host", com.bytedance.sdk.component.b.hc.d.b.d(heVarD.d(), false));
        }
        if (heVarD.d("Connection") == null) {
            dVarAn.d("Connection", "Keep-Alive");
        }
        if (heVarD.d("Accept-Encoding") == null && heVarD.d("Range") == null) {
            z = true;
            dVarAn.d("Accept-Encoding", "gzip");
        }
        List<com.bytedance.sdk.component.b.hc.mq> listD = this.d.d(heVarD.d());
        if (!listD.isEmpty()) {
            dVarAn.d(e.b, d(listD));
        }
        if (heVarD.d("User-Agent") == null) {
            dVarAn.d("User-Agent", com.bytedance.sdk.component.b.hc.d.c.d());
        }
        j jVarD = dVar.d(dVarAn.d());
        u.d(this.d, heVarD.d(), jVarD.h());
        j.d dVarD = jVarD.tt().d(heVarD);
        if (z && "gzip".equalsIgnoreCase(jVarD.d("Content-Encoding")) && u.b(jVarD)) {
            com.bytedance.sdk.component.b.d.tc tcVar = new com.bytedance.sdk.component.b.d.tc(jVarD.gb().b());
            dVarD.d(jVarD.h().hc().hc("Content-Encoding").hc("Content-Length").d());
            dVarD.d(new gb(jVarD.d("Content-Type"), -1L, com.bytedance.sdk.component.b.d.mq.d(tcVar)));
        }
        return dVarD.d();
    }

    private String d(List<com.bytedance.sdk.component.b.hc.mq> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append("; ");
            }
            com.bytedance.sdk.component.b.hc.mq mqVar = list.get(i);
            sb.append(mqVar.d()).append(a.h).append(mqVar.hc());
        }
        return sb.toString();
    }
}
