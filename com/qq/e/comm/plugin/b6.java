package com.qq.e.comm.plugin;

import com.qq.e.comm.plugin.an;
import java.util.List;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class b6 implements an.a {
    private final int a;
    private final List<an> b;
    private final aw c;

    public b6(int i, List<an> list, aw awVar) {
        this.a = i;
        this.b = list;
        this.c = awVar;
    }

    @Override // com.qq.e.comm.plugin.an.a
    public hw a(aw awVar) throws Exception {
        if (this.a >= this.b.size()) {
            return null;
        }
        return this.b.get(this.a).a(new b6(this.a + 1, this.b, awVar));
    }

    @Override // com.qq.e.comm.plugin.an.a
    public aw a() {
        return this.c;
    }
}
