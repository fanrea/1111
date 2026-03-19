package com.bytedance.sdk.component.mk.h;

import com.bytedance.sdk.component.mk.c.c;
import com.bytedance.sdk.component.mk.d.d.b;
import com.bytedance.sdk.component.mk.d.hc;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d {
    private static volatile d hc;
    private Map<String, com.bytedance.sdk.component.mk.d.d.d> d = new HashMap();

    private d() {
    }

    public static d d() {
        if (hc != null) {
            return hc;
        }
        synchronized (d.class) {
            if (hc != null) {
                return hc;
            }
            d dVar = new d();
            hc = dVar;
            return dVar;
        }
    }

    public void d(String str, com.bytedance.sdk.component.mk.d.d.d dVar) {
        this.d.put(str, dVar);
    }

    public void d(String str, com.bytedance.sdk.component.mk.d.d dVar, com.bytedance.sdk.component.mk.c.d dVar2) {
        com.bytedance.sdk.component.mk.d.d.d dVarD = this.d.get(str);
        if (dVarD == null || dVar == null) {
            return;
        }
        Map<String, Object> mapD = dVar.d();
        c cVarU = dVar.u();
        if (cVarU instanceof hc) {
            Map<String, Object> mapD2 = com.bytedance.sdk.component.mk.u.d.d().d(String.valueOf(cVarU.hashCode()));
            mapD.putAll(mapD2);
            mapD2.clear();
            com.bytedance.sdk.component.mk.an.d dVarD2 = com.bytedance.sdk.component.mk.an.d.d();
            dVarD = dVarD2.d(dVarD);
            HashMap map = new HashMap();
            map.putAll(dVar.hc());
            map.putAll(mapD);
            dVarD2.d(dVarD, map);
        }
        if (dVarD instanceof b) {
            ((b) dVarD).d(dVar.hc(), dVar.d(), dVar);
        } else if (dVarD instanceof com.bytedance.sdk.component.mk.d.d.hc) {
            ((com.bytedance.sdk.component.mk.d.d.hc) dVarD).d(dVar.hc(), dVar.d(), dVar);
        }
    }
}
