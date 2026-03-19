package com.bytedance.sdk.component.adexpress.c;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class u {
    public static void d(com.bytedance.sdk.component.tc.tt ttVar, int i) {
        if (ttVar == null) {
            return;
        }
        com.bytedance.sdk.component.adexpress.d.d.b bVarB = com.bytedance.sdk.component.adexpress.d.d.d.d().b();
        ExecutorService executorServiceK = bVarB != null ? bVarB.k() : null;
        if (executorServiceK != null) {
            ttVar.setPriority(i);
            executorServiceK.execute(ttVar);
        } else {
            com.bytedance.sdk.component.tc.h.d(ttVar, i);
        }
    }

    public static void hc(com.bytedance.sdk.component.tc.tt ttVar, int i) {
        if (ttVar == null) {
            return;
        }
        com.bytedance.sdk.component.adexpress.d.d.b bVarB = com.bytedance.sdk.component.adexpress.d.d.d.d().b();
        ExecutorService executorServiceUo = bVarB != null ? bVarB.uo() : null;
        if (executorServiceUo != null) {
            ttVar.setPriority(i);
            executorServiceUo.execute(ttVar);
        } else {
            com.bytedance.sdk.component.tc.h.d(ttVar);
        }
    }

    public static ScheduledFuture d(Runnable runnable, long j, TimeUnit timeUnit) {
        return com.bytedance.sdk.component.tc.h.c().schedule(runnable, j, timeUnit);
    }
}
