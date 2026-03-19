package com.qq.e.comm.plugin;

import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class h20 {
    private final int a;
    private long b;
    private final Map<String, Long> c = new LinkedHashMap();

    h20(int i) {
        this.a = i;
    }

    public void b(String str, int i, f5 f5Var) {
        if (!this.c.containsKey(str) && this.b > 0) {
            long jCurrentTimeMillis = System.currentTimeMillis() - this.b;
            this.c.put(str, Long.valueOf(jCurrentTimeMillis));
            wt wtVar = new wt(i);
            wtVar.b(jCurrentTimeMillis).a(f5Var);
            b10.a(wtVar);
        }
    }

    public void a(String str, int i, f5 f5Var) {
        b(str, i, f5Var);
    }

    public void a() {
        this.c.clear();
        this.b = System.currentTimeMillis();
    }
}
