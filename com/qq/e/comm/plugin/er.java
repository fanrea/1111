package com.qq.e.comm.plugin;

import android.util.Pair;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class er extends v40<dr> {
    @Override // com.qq.e.comm.plugin.v40
    protected Pair<Integer, Integer> a(int i, int i2, Pair<Integer, Integer> pair, int i3, int i4, rk rkVar) {
        return pair;
    }

    @Override // com.qq.e.comm.plugin.v40
    protected Pair<Integer, Integer> a(rk rkVar, int i, int i2) {
        return new Pair<>(Integer.valueOf(i), Integer.valueOf(i2));
    }

    er(w40 w40Var, dr drVar) {
        super(w40Var, drVar);
    }

    @Override // com.qq.e.comm.plugin.v40
    public void h() {
        rk rkVarW = this.a.w();
        if (rkVarW.f()) {
            int iP = rkVarW.p();
            if (iP > 0) {
                ((dr) this.b).setMaxWidth(iP);
            }
            int iC = rkVarW.c();
            if (iC > 0) {
                ((dr) this.b).setMinWidth(iC);
            }
            int iB = rkVarW.b();
            if (iB > 0) {
                ((dr) this.b).setMinHeight(iB);
            }
            int iJ = rkVarW.j();
            if (iJ > 0) {
                ((dr) this.b).setMaxHeight(iJ);
            }
        }
        super.h();
    }
}
