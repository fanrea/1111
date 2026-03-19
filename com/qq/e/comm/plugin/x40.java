package com.qq.e.comm.plugin;

import android.text.TextUtils;
import com.qq.e.comm.plugin.w40;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class x40 implements w40.d {
    private final y40 a;
    private gk b;

    x40(y40 y40Var) {
        this.a = y40Var;
    }

    @Override // com.qq.e.comm.plugin.gk
    public void c(w40 w40Var, h8 h8Var) {
        gk gkVar = this.b;
        if (gkVar == null) {
            return;
        }
        gkVar.c(w40Var, h8Var);
    }

    @Override // com.qq.e.comm.plugin.gk
    public boolean b(w40 w40Var, h8 h8Var) {
        gk gkVar = this.b;
        boolean z = gkVar != null && gkVar.b(w40Var, h8Var);
        this.a.a(w40Var, h8Var.e, h8Var.f, h8Var.g);
        return z;
    }

    @Override // com.qq.e.comm.plugin.gk
    public void a(w40 w40Var, h8 h8Var) {
        gk gkVar = this.b;
        if (gkVar == null) {
            return;
        }
        gkVar.a(w40Var, h8Var);
    }

    @Override // com.qq.e.comm.plugin.gk
    public void a(w40 w40Var, h8 h8Var, float f) {
        y7 y7VarA;
        gk gkVar = this.b;
        if (gkVar == null) {
            return;
        }
        gkVar.a(w40Var, h8Var, f);
        if (!TextUtils.isEmpty(h8Var.i) && (y7VarA = this.a.a().a(h8Var.i)) != null) {
            y7VarA.a(f);
        }
        if (h8Var.j != null) {
            this.a.a(h8Var.c);
        }
    }

    void a(gk gkVar) {
        this.b = gkVar;
    }
}
