package com.qq.e.comm.plugin;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class ga implements ow {
    private int a;
    private int b;

    @Override // com.qq.e.comm.plugin.ow
    public long a() {
        return com.alipay.sdk.m.u.b.a;
    }

    public ga(int i) {
        this.b = i;
    }

    @Override // com.qq.e.comm.plugin.ow
    public boolean a(int i) {
        int i2 = this.a + 1;
        this.a = i2;
        return i2 < 30 && mc.d(i) && !mc.e(i) && !mc.a(i);
    }

    @Override // com.qq.e.comm.plugin.ow
    public int c() {
        return this.a;
    }

    @Override // com.qq.e.comm.plugin.ow
    public boolean b() {
        return this.b != 0 && as.i() && this.b < r1.d().c().p().b();
    }
}
