package com.bytedance.sdk.component.gb.hc.b;

import com.bytedance.sdk.component.gb.d.c;
import com.bytedance.sdk.component.gb.d.u;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc {
    public static void d(AtomicLong atomicLong, int i, u uVar) {
        c cVarC = uVar.c();
        if (cVarC == null || !cVarC.b() || atomicLong == null) {
            return;
        }
        atomicLong.getAndAdd(i);
    }
}
