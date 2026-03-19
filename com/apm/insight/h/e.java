package com.apm.insight.h;

import com.apm.insight.g;
import com.apm.insight.o.r;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class e {
    public static boolean a(long j) {
        if (r.a(2)) {
            return true;
        }
        if (r.a(1024)) {
            return false;
        }
        return (com.apm.insight.runtime.a.b.c() == -1 || j - com.apm.insight.runtime.a.b.c() <= g.h().getLaunchCrashInterval()) && !(g.l() && g.n() == 0);
    }
}
