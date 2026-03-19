package com.bytedance.msdk.gb.c;

import java.util.Map;
import java.util.function.Function;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class u {
    public static void d(com.bytedance.sdk.gromore.d.hc.d dVar) {
        if (dVar == null) {
            return;
        }
        Function functionYi = dVar.yi();
        if (functionYi != null) {
            Object objApply = functionYi.apply(com.bytedance.sdk.openadsdk.w.c.d().d(10001).d(Boolean.class).hc());
            if (objApply instanceof Boolean) {
                d.d(((Boolean) objApply).booleanValue());
            }
        }
        if (dVar.vv() != null) {
            Object objApply2 = functionYi.apply(com.bytedance.sdk.openadsdk.w.c.d().d(10003).d(Map.class).hc());
            if (objApply2 instanceof Map) {
                System.out.println("onetap " + objApply2.toString());
                b.d((Map) objApply2);
            }
        }
        hc.d(dVar.he());
        c.d(dVar.zw());
    }
}
