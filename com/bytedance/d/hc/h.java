package com.bytedance.d.hc;

import android.app.Application;
import android.content.Context;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class h {
    private static boolean b = false;
    private static boolean c = false;
    private static boolean d = false;
    private static boolean hc = false;

    public static synchronized void d(Context context, u uVar, boolean z, boolean z2) {
        d(context, uVar, z, false, z2);
    }

    public static synchronized void d(Context context, u uVar, boolean z, boolean z2, boolean z3) {
        d(context, uVar, z, z, z2, z3);
    }

    public static synchronized void d(final Context context, u uVar, boolean z, boolean z2, boolean z3, final boolean z4) {
        if (d) {
            return;
        }
        if (context == null) {
            throw new IllegalArgumentException("context must be not null.");
        }
        if (uVar == null) {
            throw new IllegalArgumentException("params must be not null.");
        }
        if (!(context instanceof Application)) {
            context = context.getApplicationContext();
        }
        if (com.bytedance.d.hc.gb.d.b(context)) {
            return;
        }
        gb.d(context, uVar);
        com.bytedance.d.hc.u.d.u.d(context);
        if (z || z2) {
            com.bytedance.d.hc.c.d dVarD = com.bytedance.d.hc.c.d.d();
            if (z) {
                dVarD.d(new com.bytedance.d.hc.c.b(context));
            }
            hc = true;
        }
        c = z3;
        d = true;
        b = z4;
        com.bytedance.d.hc.u.h.hc().post(new Runnable() { // from class: com.bytedance.d.hc.h.1
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.d.hc.hc.d.d().d(context);
                com.bytedance.d.hc.h.c.d(context);
                if (z4) {
                    com.bytedance.d.hc.d.an.d(context).d();
                }
            }
        });
    }

    @Deprecated
    public static void d(String str) {
        if (gb.u().d()) {
            com.bytedance.d.hc.c.d.d(str);
        }
    }

    public static void d(an anVar) {
        gb.hc().d(anVar);
    }

    public static void d(Map<? extends String, ? extends String> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        gb.hc().d(map);
    }

    public static void d(final com.bytedance.d.d.hc hcVar) {
        com.bytedance.d.hc.u.h.hc().post(new Runnable() { // from class: com.bytedance.d.hc.h.2
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.d.d.d.d(hcVar);
            }
        });
    }
}
