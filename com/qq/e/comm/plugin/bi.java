package com.qq.e.comm.plugin;

import android.util.Pair;
import com.qq.e.comm.plugin.i50;
import com.qq.e.comm.plugin.on;
import yaq.pro;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class bi extends o0 {
    private boolean d = false;

    private void a(int i, l6 l6Var) {
        pro.getVresult(687, 0, this, Integer.valueOf(i), l6Var);
    }

    private void a(Pair<Integer, Boolean> pair, l6 l6Var) {
        pro.getVresult(688, 0, this, pair, l6Var);
    }

    private void a(Boolean bool, Integer num, l6 l6Var) {
        pro.getVresult(689, 0, this, bool, num, l6Var);
    }

    private void b(l6 l6Var) {
        pro.getVresult(690, 0, this, l6Var);
    }

    private boolean f() {
        return pro.getZresult(691, 0, this);
    }

    @Override // com.qq.e.comm.plugin.o0
    protected boolean b() {
        return pro.getZresult(692, 0, this);
    }

    @Override // com.qq.e.comm.plugin.o0
    protected boolean c() {
        return pro.getZresult(693, 0, this);
    }

    @Override // com.qq.e.comm.plugin.o0
    protected boolean d() {
        return pro.getZresult(694, 0, this);
    }

    bi() {
    }

    /* compiled from: A */
    class a implements i50.a {
        final /* synthetic */ l6 a;

        a(l6 l6Var) {
            this.a = l6Var;
        }

        @Override // com.qq.e.comm.plugin.i50.a
        public void a() {
            on.a(new on.b(this.a.j.booleanValue() ? 8 : 7, this.a.x));
        }
    }
}
