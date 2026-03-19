package com.qq.e.comm.plugin;

import com.qq.e.comm.plugin.i50;
import com.qq.e.comm.plugin.on;
import yaq.pro;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class ft extends o0 {
    private boolean d;

    private void a(int i, l6 l6Var) {
        pro.getVresult(42, 0, this, Integer.valueOf(i), l6Var);
    }

    private boolean b(l6 l6Var) {
        return pro.getZresult(43, 0, this, l6Var);
    }

    private boolean f() {
        return pro.getZresult(44, 0, this);
    }

    @Override // com.qq.e.comm.plugin.o0
    protected boolean b() {
        return pro.getZresult(45, 0, this);
    }

    @Override // com.qq.e.comm.plugin.o0
    protected boolean c() {
        return pro.getZresult(46, 0, this);
    }

    @Override // com.qq.e.comm.plugin.o0
    protected boolean d() {
        return pro.getZresult(47, 0, this);
    }

    ft() {
    }

    /* compiled from: A */
    class a implements i50.a {
        final /* synthetic */ l6 a;

        @Override // com.qq.e.comm.plugin.i50.a
        public void a() {
            on.a(new on.b(6, this.a.x));
        }

        a(l6 l6Var) {
            this.a = l6Var;
        }
    }
}
