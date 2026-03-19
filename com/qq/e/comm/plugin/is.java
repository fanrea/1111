package com.qq.e.comm.plugin;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class is extends sw {
    public is(l20 l20Var, h4 h4Var) {
        super(l20Var, h4Var);
    }

    @Override // com.qq.e.comm.plugin.sw, com.qq.e.comm.plugin.r6
    protected void d() {
        if (this.a.getVisibility() != 0) {
            this.a.setVisibility(0);
        }
        this.a.a(null, String.valueOf(a() / 1000), String.format("秒后获得%s", this.d));
    }
}
