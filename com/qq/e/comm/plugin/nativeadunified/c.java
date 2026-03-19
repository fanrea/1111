package com.qq.e.comm.plugin.nativeadunified;

import android.content.Context;
import android.view.View;
import com.qq.e.comm.plugin.ap;
import com.qq.e.comm.plugin.apkmanager.l;
import com.qq.e.comm.plugin.callback.biz.ClickCallback;
import com.qq.e.comm.plugin.cz;
import com.qq.e.comm.plugin.f5;
import com.qq.e.comm.plugin.fr;
import com.qq.e.comm.plugin.h10;
import com.qq.e.comm.plugin.i6;
import com.qq.e.comm.plugin.j6;
import com.qq.e.comm.plugin.kr;
import com.qq.e.comm.plugin.l6;
import com.qq.e.comm.plugin.n6;
import com.qq.e.comm.plugin.qs;
import com.qq.e.comm.plugin.r1;
import com.qq.e.comm.plugin.r5;
import com.qq.e.comm.plugin.u2;
import com.qq.e.comm.plugin.x5;
import com.qq.e.comm.plugin.zv;
import com.qq.e.comm.util.GDTLogger;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class c implements View.OnClickListener {
    private final fr a;
    private final e b;
    private final qs c;
    private final f5 d;
    private final boolean e;

    private void c() {
        if (this.b.a0 > 0) {
            i.b(this.d, System.currentTimeMillis() - this.b.a0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        e eVar = this.b;
        if (!eVar.a(eVar.e, view)) {
            GDTLogger.e("点击失败，点击的view不在NativeAdContainer中");
            return;
        }
        c();
        if (this.b.H()) {
            e eVar2 = this.b;
            if (eVar2.C) {
                if (view != eVar2.i && view != eVar2.Q) {
                    a(this.e, view);
                    return;
                } else if (eVar2.e()) {
                    this.b.f();
                    return;
                } else {
                    a(view);
                    return;
                }
            }
        }
        a(this.e, view);
    }

    public c(e eVar, fr frVar, Context context, f5 f5Var) {
        this(eVar, frVar, context, f5Var, false);
    }

    public c(e eVar, fr frVar, Context context, f5 f5Var, boolean z) {
        this.b = eVar;
        this.a = frVar;
        cz czVar = new cz(context, eVar);
        czVar.a(frVar);
        this.c = czVar;
        this.d = f5Var;
        this.e = z;
    }

    void b(boolean z, View view, i6 i6Var) {
        i6Var.b = this.b.a(i6Var);
        a(z, view, i6Var);
    }

    private void a(boolean z, View view, i6 i6Var) {
        boolean z2;
        boolean z3;
        boolean z4;
        if (z && this.a.k1()) {
            int iB = l.e().b(this.a.R1());
            if (r1.d().f().a("nuaico", this.a.y0(), 0) == 1 && n6.c(this.a, iB)) {
                z4 = false;
                z3 = true;
            } else {
                z4 = true;
                z3 = false;
            }
            z2 = z4 && !((this.a.y1() && h10.f(iB)) || (this.a.z1() && ap.a(this.a.m0(), this.a.M0())));
        } else {
            z2 = false;
            z3 = false;
        }
        j6.a(new l6.b(this.a).a(!z2).f(z3).a(i6Var.b).a(i6Var).a(), this.c);
        zv.a(this.b.e, this.a, i6Var.b, view, new kr());
        this.b.b(105, view);
        if (this.b.H()) {
            this.b.f(true);
        }
        ((ClickCallback) x5.b(this.a.s0(), ClickCallback.class)).O().a();
    }

    public void a(String str) {
        u2.a().a(this.b.e, this.a, str);
        b(false, this.b.e, new i6(this.a));
        i.c(this.d);
        c();
    }

    public void a(i6 i6Var) {
        r5 r5VarD = u2.a().d(this.b.e);
        if (r5VarD != null) {
            r5VarD.a(i6Var);
        }
        i6Var.b = u2.a().a(this.b.e);
        a(false, this.b.e, i6Var);
        i.a(this.d, i6Var.c);
    }

    public void a() {
        this.b.d();
    }

    private void a(boolean z, View view) {
        b(z, view, new i6(this.a));
        i.b(this.d);
    }

    void a(View view) {
        b(false, view, new i6(this.a));
        i.f(this.d);
    }

    void b(i6 i6Var) {
        i6Var.h = 2;
        b(this.e, this.b.e, i6Var);
        i.e(this.d);
    }

    void b() {
        a(false, this.b.e);
    }
}
