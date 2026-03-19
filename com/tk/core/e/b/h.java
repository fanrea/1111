package com.tk.core.e.b;

import java.util.HashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class h extends com.tk.core.e.a.c {
    public float Hj;

    public final void setScale(float f) {
        this.Hj = f;
    }

    @Override // com.tk.core.e.a.c, com.tk.core.e.a.b
    public final void n(HashMap<String, Object> map) {
        super.n(map);
        this.Hj = ((Number) map.get("scale")).floatValue();
    }
}
