package com.tk.core.e.b;

import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class l extends com.tk.core.e.a.c {
    public HashMap<String, Float> ahR = new HashMap<>();

    public final void o(HashMap<String, Float> map) {
        this.ahR = map;
    }

    @Override // com.tk.core.e.a.c, com.tk.core.e.a.b
    public final void n(HashMap<String, Object> map) {
        super.n(map);
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            this.ahR.put(entry.getKey(), Float.valueOf(((Number) entry.getValue()).floatValue()));
        }
    }
}
