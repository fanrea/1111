package com.qq.e.comm.plugin;

import android.content.Context;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class s8 extends e0 {
    private final String m;

    @Override // com.qq.e.comm.plugin.e0
    protected void d() {
    }

    public s8(Context context, h4 h4Var, rs rsVar) {
        super(context, h4Var, rsVar);
        String strE = h4Var.o().e();
        this.m = strE;
        j3.a(strE).g = 9;
        f9 f9VarA = q8.a().a(this.a, this.b, this.d ? 2 : 1);
        this.e = f9VarA;
        if (f9VarA != null) {
            this.f = f9VarA.l();
            this.g = f5.a(h4Var, this.e.h());
        }
    }

    @Override // com.qq.e.comm.plugin.e0
    protected void e() {
        t3.a(this.m, 1100957, this.g);
    }

    @Override // com.qq.e.comm.plugin.e0
    protected void c() {
        t3.a(this.m, 1100958, this.g);
    }

    @Override // com.qq.e.comm.plugin.e0
    protected void b() {
        t3.a(this.m, 1100959, this.g);
    }
}
