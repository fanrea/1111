package com.bytedance.msdk.an.hc;

import com.bytedance.msdk.api.c.mk;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc {
    private static volatile hc b;
    public mk d;
    private final Map<String, com.bytedance.msdk.d.d.c> hc = new ConcurrentHashMap();

    public static hc d() {
        if (b == null) {
            synchronized (hc.class) {
                if (b == null) {
                    b = new hc();
                }
            }
        }
        return b;
    }

    private hc() {
    }

    public synchronized Map<String, com.bytedance.msdk.d.d.c> hc() {
        return this.hc;
    }

    public Collection<com.bytedance.msdk.d.d.c> b() {
        return this.hc.values();
    }

    public com.bytedance.msdk.d.d.c d(String str, mk mkVar) {
        this.d = mkVar;
        return d(str);
    }

    public synchronized com.bytedance.msdk.d.d.c d(String str) {
        com.bytedance.msdk.d.d.c cVarHc;
        cVarHc = hc(str);
        if (cVarHc == null) {
            com.bytedance.msdk.core.tc.d dVarD = com.bytedance.msdk.core.hc.hc().d(str);
            if (dVarD == null && this.d != null) {
                dVarD = new com.bytedance.msdk.core.tc.d(this.d.b(), this.d.c());
                this.d = null;
            }
            if (dVarD != null && !dVarD.c()) {
                cVarHc = b(str);
            }
            if (cVarHc != null) {
                d(str, cVarHc);
            }
        }
        return cVarHc;
    }

    private com.bytedance.msdk.d.d.c hc(String str) {
        if (str == null) {
            return null;
        }
        return this.hc.get(str);
    }

    private void d(String str, com.bytedance.msdk.d.d.c cVar) {
        if (str == null) {
            return;
        }
        this.hc.put(str, cVar);
    }

    private com.bytedance.msdk.d.d.c b(String str) {
        if ("pangle".equalsIgnoreCase(str)) {
            return new com.bytedance.msdk.d.b.d();
        }
        return new c();
    }
}
