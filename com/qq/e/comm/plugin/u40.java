package com.qq.e.comm.plugin;

import android.view.View;
import android.view.ViewGroup;
import com.qq.e.comm.plugin.el;
import java.util.List;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public abstract class u40<V extends ViewGroup & el> extends v40<V> {
    public abstract ViewGroup.LayoutParams a(rk rkVar);

    public abstract ViewGroup.LayoutParams j();

    /* JADX WARN: Multi-variable type inference failed */
    public u40(w40<v40<V>, V> w40Var, V v) {
        super(w40Var, v);
    }

    protected void a(w40 w40Var, View view) {
        ViewGroup viewGroup = (ViewGroup) this.a.A();
        if (w40Var.x().b() != 1) {
            viewGroup.addView(view, a(w40Var.w()));
        } else {
            viewGroup.addView(view, a(viewGroup, w40Var.u()), a(w40Var.w()));
        }
    }

    void c(boolean z) {
        V v = this.b;
        if (v != 0) {
            ((ViewGroup) v).setClipChildren(z);
        }
    }

    public void a(w40 w40Var) {
        View viewA;
        if (w40Var == null || !w40Var.K() || !this.a.K() || (viewA = w40Var.A()) == null) {
            return;
        }
        a(w40Var, viewA);
    }

    protected int a(ViewGroup viewGroup, int i) {
        w40 w40Var;
        List<w40> listP = ((zn) this.a).P();
        do {
            i++;
            if (i >= listP.size()) {
                return -1;
            }
            w40Var = listP.get(i);
        } while (!w40Var.K());
        return viewGroup.indexOfChild(w40Var.A());
    }
}
