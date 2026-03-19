package com.tk.core.e.b;

import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class f extends com.tk.core.e.a.c {
    public HashMap<String, Float> ahS = new HashMap<>();

    @Override // com.tk.core.e.a.c, com.tk.core.e.a.b
    public final void n(HashMap<String, Object> map) {
        super.n(map);
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            this.ahS.put(entry.getKey(), Float.valueOf(((Number) entry.getValue()).floatValue()));
        }
    }

    public final void p(HashMap<String, Float> map) {
        this.ahS = map;
    }
}
