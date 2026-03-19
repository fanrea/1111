package com.qq.e.comm.plugin;

import android.text.TextUtils;
import com.qq.e.comm.plugin.cr;
import com.qq.e.comm.plugin.dp;
import com.qq.e.comm.plugin.hy;
import com.qq.e.comm.plugin.nq;
import com.qq.e.comm.plugin.pq;
import com.qq.e.comm.plugin.rq;
import com.qq.e.comm.plugin.uq;
import com.qq.e.comm.plugin.v8;
import com.qq.e.comm.plugin.w40;
import java.util.HashMap;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class t40 {
    private final HashMap<String, w40.e> a = new HashMap<>();

    public t40() {
        a("1", new pq.a());
        a("2", new uq.a());
        a("3", new cr.a());
        a("4", new rq.a());
        a("5", new hy.b());
        a("6", new nq.a());
        a("7", new dp.a());
    }

    public w40 a(im imVar, z10 z10Var) {
        return a(imVar, z10Var, null, -1);
    }

    public w40 a(im imVar, z10 z10Var, zn znVar, int i) {
        w40.e eVar = this.a.get(z10Var.a);
        w40 w40VarA = eVar == null ? null : eVar.a();
        if (w40VarA == null) {
            return null;
        }
        int i2 = 0;
        boolean z = znVar != null;
        if (z) {
            znVar.d(w40VarA);
        }
        w40VarA.a(this);
        w40VarA.j(i);
        w40VarA.a(imVar);
        w40VarA.b(z10Var);
        if (z6.a) {
            a7 a7Var = z10Var.i;
            w40VarA.b(a7Var);
            if (a7Var != null) {
                w40VarA.a(a7Var);
            } else if (z) {
                w40VarA.a(znVar.q());
            }
        }
        if (z10Var.b != null && (w40VarA instanceof zn)) {
            zn znVar2 = (zn) w40VarA;
            if (!znVar2.N()) {
                while (true) {
                    z10[] z10VarArr = z10Var.b;
                    if (i2 >= z10VarArr.length) {
                        break;
                    }
                    a(imVar, z10VarArr[i2], znVar2, i2);
                    i2++;
                }
            }
        }
        return w40VarA;
    }

    public im a(a9 a9Var, f5 f5Var) {
        z10 z10Var;
        if (a9Var != null && (z10Var = a9Var.b) != null && !TextUtils.isEmpty(a9Var.a)) {
            v8.a aVarB = v8.b();
            aVarB.c = a50.d;
            y40 y40Var = new y40();
            y40Var.a(a9Var.e);
            y40Var.c(z10Var.l);
            w40 w40VarA = a(y40Var, z10Var);
            if (w40VarA != null) {
                y40Var.a(w40VarA);
                v8.b(2230102, aVarB, f5Var);
                return y40Var;
            }
        }
        return null;
    }

    public void a(String str, w40.e eVar) {
        this.a.put(str, eVar);
    }
}
