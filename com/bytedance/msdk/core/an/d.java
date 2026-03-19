package com.bytedance.msdk.core.an;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.msdk.d.u.c;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d {
    private final Map<String, com.bytedance.msdk.api.c.d.hc.an.d> d = new ConcurrentHashMap();

    public Map<String, com.bytedance.msdk.api.c.d.hc.an.d> d() {
        return this.d;
    }

    public void d(String str, com.bytedance.msdk.api.c.d.hc.an.d dVar) {
        this.d.put(str, dVar);
    }

    public com.bytedance.msdk.api.c.d.hc.an.d d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.d.get(str);
    }

    public String d(Context context, Map<String, Object> map, String str) {
        c.d(context);
        com.bytedance.msdk.api.c.d.hc.an.d dVarD = d(str);
        if (dVarD != null) {
            return dVarD.d(null, null);
        }
        com.bytedance.msdk.d.d.c cVarHc = hc(str);
        if (cVarHc == null) {
            return null;
        }
        return cVarHc.d(context, map);
    }

    public Map<String, Object> hc(Context context, Map<String, Object> map, String str) {
        c.d(context);
        com.bytedance.msdk.api.c.d.hc.an.d dVarD = d(str);
        if (dVarD != null) {
            HashMap map2 = new HashMap();
            map2.put("buyerId", dVarD.d(context, map));
            map2.put(com.alipay.sdk.m.x.d.D, dVarD.hc(context, map));
            return map2;
        }
        com.bytedance.msdk.d.d.c cVarHc = hc(str);
        if (cVarHc == null) {
            return null;
        }
        return cVarHc.hc(context, map);
    }

    public com.bytedance.msdk.d.d.c hc(String str) {
        return com.bytedance.msdk.an.hc.hc.d().d(str);
    }
}
