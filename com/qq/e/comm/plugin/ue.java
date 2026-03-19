package com.qq.e.comm.plugin;

import android.view.View;
import android.view.ViewGroup;
import com.qq.e.comm.plugin.h60;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class ue extends u40<oq> {
    private ve l;

    private com.qq.e.lib.yoga.a b(View view) {
        com.qq.e.lib.yoga.a aVarA = n60.a();
        aVarA.a(view);
        aVarA.a((k60) new h60.a());
        return aVarA;
    }

    @Override // com.qq.e.comm.plugin.u40
    public ViewGroup.LayoutParams j() {
        return new ViewGroup.MarginLayoutParams(-1, -1);
    }

    public ue(w40 w40Var, oq oqVar) {
        super(w40Var, oqVar);
    }

    @Override // com.qq.e.comm.plugin.u40
    protected void a(w40 w40Var, View view) {
        com.qq.e.lib.yoga.a aVarS;
        oq oqVar = (oq) this.a.A();
        if (oqVar == null) {
            return;
        }
        rk rkVarW = w40Var.w();
        if ((rkVarW instanceof i8) && (aVarS = ((i8) rkVarW).s()) != null) {
            if (w40Var.x().b() != 1) {
                oqVar.a(view, aVarS);
            } else {
                oqVar.a(view, aVarS, a(oqVar, w40Var.u()));
            }
        }
    }

    @Override // com.qq.e.comm.plugin.u40
    public ViewGroup.LayoutParams a(rk rkVar) {
        if (this.l == null) {
            this.l = new ve((i8) rkVar);
        }
        return this.l;
    }

    @Override // com.qq.e.comm.plugin.v40
    public rk a(View view) {
        i8 i8Var = new i8();
        i8Var.a(b(view));
        return i8Var;
    }
}
