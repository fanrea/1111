package com.bytedance.msdk.gb.c;

import android.util.SparseArray;
import java.util.function.Function;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc {
    private static Function<SparseArray<Object>, Object> d;

    public static void d(Function<SparseArray<Object>, Object> function) {
        d = function;
    }

    public static void d(com.bytedance.msdk.u.d dVar, boolean z) {
        if (dVar != null && com.bytedance.msdk.core.d.mk().yi()) {
            hc(dVar, z);
        }
    }

    private static void hc(com.bytedance.msdk.u.d dVar, boolean z) {
        if (d != null) {
            com.bytedance.sdk.openadsdk.w.c cVarD = com.bytedance.sdk.openadsdk.w.c.d();
            if (z) {
                cVarD.d(10002).d(Void.class);
                cVarD.d(20003, dVar.b());
                d.apply(cVarD.hc());
            } else {
                cVarD.d(10002).d(Void.class);
                cVarD.d(20002, dVar.b());
                d.apply(cVarD.hc());
            }
        }
    }
}
