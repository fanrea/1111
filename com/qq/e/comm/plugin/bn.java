package com.qq.e.comm.plugin;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class bn extends r6 {
    @Override // com.qq.e.comm.plugin.r6
    public int a() {
        return ke.a();
    }

    public bn(l20 l20Var, h4 h4Var) {
        super(l20Var);
    }

    @Override // com.qq.e.comm.plugin.r6
    protected void c() {
        this.a.setVisibility(8);
    }

    @Override // com.qq.e.comm.plugin.r6
    protected void d() {
        if (this.a.getVisibility() != 0) {
            this.a.setVisibility(0);
        }
        this.a.a("", String.valueOf(a() / 1000), "秒后可关闭");
    }
}
