package com.bytedance.msdk.core.gb;

import com.baidu.mobstat.forbes.Config;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class gb {
    private static final String d = "TTMediationSDK_gb";
    private com.bytedance.msdk.u.d.d<h> b;
    private Map<String, h> hc;

    private gb() {
        this.b = new com.bytedance.msdk.u.d.hc(com.bytedance.msdk.core.hc.getContext());
        this.hc = new ConcurrentHashMap();
    }

    public static gb d() {
        return d.d;
    }

    private static class d {
        private static gb d = new gb();
    }

    public void d(String str) {
        if (this.b != null) {
            Map<String, h> map = this.hc;
            if (map != null) {
                map.remove(str);
            }
            this.b.delete(str);
        }
    }

    public void d(String str, String str2) {
        if (this.b != null) {
            Map<String, h> map = this.hc;
            if (map != null) {
                map.remove(str + Config.replace + str2);
            }
            this.b.delete(str, str2);
        }
    }

    public void d(h hVar) {
        h hVarHc;
        u uVar;
        if (hVar.d()) {
            hVarHc = hc(hVar.hc(), hVar.b());
        } else {
            hVarHc = hc(hVar.hc());
        }
        if (hVarHc == null) {
            if (this.b != null) {
                Map<String, h> map = this.hc;
                if (map != null) {
                    map.put(hVar.c(), hVar);
                }
                this.b.hc(hVar);
                return;
            }
            return;
        }
        HashMap map2 = new HashMap();
        for (u uVar2 : hVarHc.mk()) {
            map2.put(uVar2.b(), uVar2);
        }
        for (u uVar3 : hVar.mk()) {
            if (map2.containsKey(uVar3.b()) && (uVar = (u) map2.get(uVar3.b())) != null) {
                uVar3.d(uVar);
            }
        }
        Map<String, h> map3 = this.hc;
        if (map3 != null) {
            map3.put(hVar.c(), hVar);
        }
        hc(hVar);
    }

    public h hc(String str) {
        if (this.b != null) {
            Map<String, h> map = this.hc;
            h hVar = map != null ? map.get(str) : null;
            if (hVar != null) {
                return hVar;
            }
            h hVarQuery = this.b.query(str);
            if (hVarQuery != null) {
                Map<String, h> map2 = this.hc;
                if (map2 != null) {
                    map2.put(hVarQuery.c(), hVarQuery);
                }
                return hVarQuery;
            }
        }
        return null;
    }

    public h hc(String str, String str2) {
        if (this.b != null) {
            Map<String, h> map = this.hc;
            h hVar = map != null ? map.get(str + Config.replace + str2) : null;
            if (hVar != null) {
                return hVar;
            }
            h hVarQuery = this.b.query(str, str2);
            if (hVarQuery != null) {
                Map<String, h> map2 = this.hc;
                if (map2 != null) {
                    map2.put(hVarQuery.c(), hVarQuery);
                }
                return hVarQuery;
            }
        }
        return null;
    }

    public void hc(h hVar) {
        if (this.b != null) {
            Map<String, h> map = this.hc;
            if (map != null) {
                map.put(hVar.c(), hVar);
            }
            this.b.d(hVar);
        }
    }

    public void d(h hVar, String str, int i) {
        if (this.b != null) {
            hVar.d(str, i);
            Map<String, h> map = this.hc;
            if (map != null) {
                map.put(hVar.c(), hVar);
            }
            this.b.d(hVar);
        }
    }

    public void d(h hVar, String str, long j) {
        if (this.b != null) {
            hVar.d(str, j);
            Map<String, h> map = this.hc;
            if (map != null) {
                map.put(hVar.c(), hVar);
            }
            this.b.d(hVar);
        }
    }
}
