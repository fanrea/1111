package com.qq.e.comm.plugin;

import java.util.Random;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class zx {
    private static final Random a = new Random(System.currentTimeMillis());
    private static volatile Boolean b = null;

    public static boolean b() {
        vx vxVarF = r1.d().f();
        if (vxVarF != null) {
            return a(vxVarF.a("securityVulnerabilityReport", 10), 10000);
        }
        return false;
    }

    public static boolean a(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return false;
        }
        return i >= i2 || a.nextInt(i2) < i;
    }

    public static void a() {
        b = null;
    }
}
