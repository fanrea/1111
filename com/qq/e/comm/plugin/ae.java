package com.qq.e.comm.plugin;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class ae extends RelativeLayout {
    private fj a;

    public ae(Context context, h4 h4Var, sd sdVar) {
        super(context);
        a(h4Var, sdVar);
    }

    public mh c() {
        fj fjVar = this.a;
        if (fjVar instanceof dm) {
            return ((dm) fjVar).b();
        }
        return null;
    }

    public dm b() {
        fj fjVar = this.a;
        if (fjVar instanceof dm) {
            return (dm) fjVar;
        }
        return null;
    }

    public void a(g40 g40Var) {
        fj fjVar = this.a;
        if (fjVar instanceof dm) {
            ((dm) fjVar).a(g40Var);
        }
    }

    public Cif a() {
        return this.a.f();
    }

    private void a(h4 h4Var, sd sdVar) {
        removeAllViews();
        if (h4Var.p0() != null && h4Var.p0().F()) {
            this.a = new de(getContext(), h4Var, sdVar);
        } else if (h4Var.C1()) {
            this.a = new ee(getContext(), h4Var, sdVar);
        } else {
            this.a = new ce(getContext(), h4Var, sdVar);
        }
        View viewA = this.a.a();
        if (viewA != null) {
            addView(viewA);
        } else {
            b10.a(9411102, f5.a(h4Var), 3);
        }
    }
}
