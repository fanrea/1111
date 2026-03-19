package com.kuaishou.aegon.netcheck;

import com.kuaishou.aegon.netcheck.a;
import java.util.EnumSet;
import java.util.concurrent.Executor;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
class NetcheckTaskListenerWrapper {
    private a.b a;
    private Executor b;

    void OnProgress(int i) {
        this.b.execute(b.a(this, i));
    }

    void OnFinish(long j, String str) {
        EnumSet enumSetNoneOf = EnumSet.noneOf(a.EnumC0399a.class);
        for (a.EnumC0399a enumC0399a : a.EnumC0399a.values()) {
            if (((1 << enumC0399a.a()) & j) != 0) {
                enumSetNoneOf.add(enumC0399a);
            }
        }
        this.b.execute(c.a(this, enumSetNoneOf, str));
    }
}
