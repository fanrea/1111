package com.qq.e.comm.plugin;

import com.kuaishou.android.live.network.ApiStatus;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class wc implements sj {
    private final int a;
    private final sj b;
    private gj c;

    public wc(String str, sj sjVar) {
        this.b = sjVar;
        this.a = r1.d().f().a("skasss", str, 0);
        b();
    }

    @Override // com.qq.e.comm.plugin.sj
    public w2 a() {
        w2 w2VarA = this.b.a();
        int i = this.a;
        if (i <= 0) {
            i = ApiStatus.SC_RESTRICT_FREQ_BY_KEY_CONFIG;
        }
        w2VarA.K0 = String.valueOf(i);
        w2VarA.L0 = this.c.a();
        return w2VarA;
    }

    private void b() {
        this.c = new da();
    }
}
