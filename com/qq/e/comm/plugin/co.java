package com.qq.e.comm.plugin;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class co extends u40<vq> {
    private boolean l;

    @Override // com.qq.e.comm.plugin.u40
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout.LayoutParams a(rk rkVar) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((ViewGroup.MarginLayoutParams) new tq(rkVar));
        layoutParams.gravity = rkVar.n();
        return layoutParams;
    }

    @Override // com.qq.e.comm.plugin.u40
    public ViewGroup.LayoutParams j() {
        return new LinearLayout.LayoutParams(-2, -2);
    }

    @Override // com.qq.e.comm.plugin.v40
    public rk a(View view) {
        return new t8();
    }

    public co(w40 w40Var, vq vqVar) {
        super(w40Var, vqVar);
        this.l = false;
    }

    void d(int i) {
        if (i == 0) {
            this.l = false;
            ((vq) this.b).setOrientation(0);
            return;
        }
        if (i == 1) {
            this.l = false;
            ((vq) this.b).setOrientation(1);
        } else if (i == 2) {
            this.l = true;
            ((vq) this.b).setOrientation(0);
        } else {
            if (i != 3) {
                return;
            }
            this.l = true;
            ((vq) this.b).setOrientation(1);
        }
    }

    void c(int i) {
        ((vq) this.b).setGravity(i);
    }

    public boolean k() {
        return this.l;
    }
}
