package com.qq.e.comm.plugin;

import android.content.Context;
import java.util.List;
import java.util.Set;
import yaq.pro;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class x00 extends v0<v00> {
    @Override // com.qq.e.comm.plugin.v0
    void d(List<v00> list) {
        pro.getVresult(399, 0, this, list);
    }

    @Override // com.qq.e.comm.plugin.v0
    boolean e() {
        return pro.getZresult(400, 0, this);
    }

    x00(Context context) {
        super(context);
    }

    @Override // com.qq.e.comm.plugin.v0
    public List<v00> b() {
        return p00.a(this.a).b().b();
    }

    @Override // com.qq.e.comm.plugin.v0
    public void c(List<v00> list) {
        p00.a(this.a).b().a(list);
    }

    @Override // com.qq.e.comm.plugin.v0
    public void a(Set<Integer> set) {
        p00.a(this.a).b().a(set);
    }
}
