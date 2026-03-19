package com.bytedance.sdk.component.hc.d.d.d;

import android.text.TextUtils;
import com.bytedance.sdk.component.b.hc.c;
import com.bytedance.sdk.component.b.hc.de;
import com.bytedance.sdk.component.b.hc.he;
import com.bytedance.sdk.component.b.hc.sy;
import com.bytedance.sdk.component.b.hc.v;
import com.bytedance.sdk.component.b.hc.vv;
import com.bytedance.sdk.component.hc.d.e;
import com.bytedance.sdk.component.hc.d.k;
import com.bytedance.sdk.component.hc.d.mq;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class an extends mq {
    com.bytedance.sdk.component.hc.d.c k;
    v uo;

    public an(v.d dVar) {
        super(dVar);
        this.uo = dVar.d();
        this.k = new h(this.uo);
    }

    @Override // com.bytedance.sdk.component.hc.d.mq
    public com.bytedance.sdk.component.hc.d.c d() {
        return this.k;
    }

    @Override // com.bytedance.sdk.component.hc.d.mq
    public com.bytedance.sdk.component.hc.d.hc d(k kVar) {
        if (kVar == null) {
            return null;
        }
        he.d dVar = new he.d();
        dVar.d(kVar.d());
        if (kVar.hc() != null) {
            dVar.d(kVar.hc().d());
        }
        if (kVar.an() != null) {
            if (b(kVar.an())) {
                dVar.d(kVar.b(), vv.d(sy.d(kVar.an().b.toString()), kVar.an().c));
            } else if (d(kVar.an())) {
                dVar.d(kVar.b(), new de.d().d(de.u).d(kVar.an().hc(), kVar.an().d(), vv.d(sy.d("multipart/form-data"), kVar.an().u)).d());
            } else if (hc(kVar.an())) {
                dVar.d(kVar.b(), vv.d(sy.d(kVar.an().b.toString()), kVar.an().u));
            }
        }
        if (kVar.u() != null && kVar.u().d) {
            dVar.d(new c.d().d().b());
        }
        if (kVar.c() != null && kVar.c().size() > 0) {
            for (Map.Entry<String, List<String>> entry : kVar.c().entrySet()) {
                Iterator<String> it = entry.getValue().iterator();
                while (it.hasNext()) {
                    dVar.d(entry.getKey(), it.next());
                }
            }
        }
        return new c(this.uo.d(dVar.d()));
    }

    private boolean d(e eVar) {
        return eVar != null && eVar.an == e.d.FILE_TYPE && eVar.u != null && eVar.u.length > 0;
    }

    private boolean hc(e eVar) {
        return eVar != null && eVar.an == e.d.BYTE_ARRAY_TYPE && eVar.u != null && eVar.u.length > 0;
    }

    private boolean b(e eVar) {
        return (eVar == null || eVar.an != e.d.STRING_TYPE || TextUtils.isEmpty(eVar.c)) ? false : true;
    }
}
