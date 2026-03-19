package com.qq.e.comm.plugin;

import android.text.TextUtils;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class ry implements oj {
    private String a;
    private h4 b;

    @Override // com.qq.e.comm.plugin.oj
    public boolean a(l6 l6Var) {
        h4 h4Var = l6Var.B;
        this.b = h4Var;
        l3 l3VarO = h4Var.o();
        if (l6Var.h && l3VarO != null) {
            String strE = l3VarO.e();
            this.a = strE;
            if (!TextUtils.isEmpty(strE)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.qq.e.comm.plugin.oj
    public boolean a(l6 l6Var, qs qsVar) {
        int iB = com.qq.e.comm.plugin.apkmanager.l.e().b(this.a);
        boolean z = n6.a(l6Var.C) || l6Var.F;
        this.b.a(z);
        l6Var.G = n6.a(this.b, z, iB);
        return false;
    }
}
