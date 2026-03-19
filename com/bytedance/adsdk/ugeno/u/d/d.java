package com.bytedance.adsdk.ugeno.u.d;

import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d {
    private volatile Map<String, b> d = new HashMap();

    public b d(String str) {
        if (this.d.containsKey(str) && this.d.get(str) != null) {
            return this.d.get(str);
        }
        hc hcVar = new hc();
        this.d.put(str, hcVar);
        return hcVar;
    }

    public void d(String str, b bVar) {
        if (!this.d.containsKey(str) || this.d.get(str) == null) {
            this.d.put(str, bVar);
        }
    }
}
