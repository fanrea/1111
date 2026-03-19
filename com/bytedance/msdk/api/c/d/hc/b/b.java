package com.bytedance.msdk.api.c.d.hc.b;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.w.c;
import java.util.HashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class b {
    private final int b;
    private final int c;
    private final String d;
    private final String hc;
    private final String u;

    public b(String str, String str2, int i, int i2, String str3) {
        this.d = str;
        this.hc = str2;
        this.b = i;
        this.c = i2;
        this.u = str3;
    }

    public SparseArray<Object> d() {
        c cVarD = c.d();
        cVarD.d(8003, this.d);
        cVarD.d(2, this.hc);
        cVarD.d(8008, Integer.valueOf(this.b));
        cVarD.d(8094, Integer.valueOf(this.c));
        cVarD.d(8547, this.u);
        if (com.bytedance.msdk.core.d.mk().q() != null) {
            HashMap map = new HashMap();
            map.put("live_ad_custom_config", com.bytedance.msdk.core.d.mk().q());
            cVarD.d(8075, map);
        }
        return cVarD.hc();
    }

    public int hc() {
        return this.b;
    }
}
