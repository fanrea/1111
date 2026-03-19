package com.bytedance.d.hc.gb;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class cb {
    public static Thread d(Runnable runnable, String str) {
        com.bytedance.sdk.component.tc.c.b bVar;
        if (runnable == null) {
            return null;
        }
        if (str == null) {
            bVar = new com.bytedance.sdk.component.tc.c.b(runnable, "hreadExecutor");
        } else {
            bVar = new com.bytedance.sdk.component.tc.c.b(runnable, str);
        }
        bVar.start();
        return bVar;
    }

    public static Thread d(Runnable runnable) {
        return d(runnable, null);
    }
}
