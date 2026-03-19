package com.qq.e.comm.plugin;

import android.content.Context;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class p50 {
    private final Context a;
    private final boolean b;
    private String c;
    private h4 d;

    public p50(Context context, String str, boolean z) {
        this.a = context;
        this.b = z;
        this.c = str;
    }

    public p50 a(h4 h4Var) {
        this.d = h4Var;
        return this;
    }

    public jm a() {
        ph phVar = new ph(this.a, this.c, this.b);
        phVar.a(this.d);
        return phVar;
    }
}
