package com.qq.e.comm.plugin;

import java.util.Locale;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class sw extends r6 {
    protected final String d;

    @Override // com.qq.e.comm.plugin.r6
    public int a() {
        return ke.b();
    }

    public sw(l20 l20Var, h4 h4Var) {
        super(l20Var);
        this.d = (String) dx.d(h4Var).first;
    }

    @Override // com.qq.e.comm.plugin.r6
    protected void c() {
        if (this.a.getVisibility() != 0) {
            this.a.setVisibility(0);
        }
        this.a.a(String.format("恭喜获得%s", this.d));
    }

    @Override // com.qq.e.comm.plugin.r6
    protected void d() {
        if (this.a.getVisibility() != 0) {
            this.a.setVisibility(0);
        }
        this.a.a(String.format(Locale.getDefault(), "%s将于", this.d), String.valueOf(a() / 1000), "秒后发放");
    }
}
