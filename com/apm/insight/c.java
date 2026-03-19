package com.apm.insight;

import com.apm.insight.o.k;
import com.apm.insight.runtime.n;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class c {
    public c() {
        com.apm.insight.f.a.a();
    }

    public void a(String str) {
        a(str, "EnsureNotReachHere", null);
    }

    public void a(String str, String str2, Map<String, String> map) {
        if (g.h().isEnsureEnable()) {
            com.apm.insight.f.b.a(Thread.currentThread().getStackTrace(), 5, str, str2, map);
        }
    }

    public void a(String str, Throwable th) {
        n.a(th, str);
    }

    public void a(Throwable th, String str) {
        if (a(th)) {
            com.apm.insight.f.b.a(th, str, true);
        }
    }

    public boolean a(Throwable th) {
        return g.h().isEnsureEnable() && !k.a(th);
    }
}
