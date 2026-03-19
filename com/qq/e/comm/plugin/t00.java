package com.qq.e.comm.plugin;

import android.content.Context;
import java.util.List;
import java.util.Set;
import yaq.pro;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class t00 extends v0<r00> {
    @Override // com.qq.e.comm.plugin.v0
    void d(List<r00> list) {
        pro.getVresult(310, 0, this, list);
    }

    @Override // com.qq.e.comm.plugin.v0
    boolean e() {
        return pro.getZresult(311, 0, this);
    }

    t00(Context context) {
        super(context);
    }

    @Override // com.qq.e.comm.plugin.v0
    public List<r00> b() {
        return p00.a(this.a).a().b();
    }

    @Override // com.qq.e.comm.plugin.v0
    public void c(List<r00> list) {
        p00.a(this.a).a().a(list);
    }

    @Override // com.qq.e.comm.plugin.v0
    public void a(Set<Integer> set) {
        p00.a(this.a).a().a(set);
    }
}
