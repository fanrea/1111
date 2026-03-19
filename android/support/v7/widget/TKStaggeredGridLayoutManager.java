package android.support.v7.widget;

import android.content.Context;
import android.support.v7.widget.al;
import android.util.AttributeSet;
import java.lang.ref.WeakReference;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public class TKStaggeredGridLayoutManager extends StaggeredGridLayoutManager implements com.tk.component.listview.layoutmanager.a {
    private Runnable du;
    private com.tk.component.listview.layoutmanager.b yx;
    private boolean yy;
    private WeakReference<al> yz;

    public TKStaggeredGridLayoutManager(int i, int i2) {
        super(i, i2);
        this.yy = false;
        ae();
    }

    public TKStaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.yy = false;
        ae();
    }

    private void ae() {
        this.yx = new com.tk.component.listview.layoutmanager.b();
    }

    public final void o(al alVar) {
        this.yz = new WeakReference<>(alVar);
    }

    @Override // com.tk.component.listview.layoutmanager.a
    public final void bC(int i) {
        this.yx.bC(i);
    }

    @Override // com.tk.component.listview.layoutmanager.a
    public final void setDuration(int i) {
        this.yx.setDuration(i);
    }

    @Override // com.tk.component.listview.layoutmanager.a
    public final void gO() {
        this.yx.gO();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.support.v7.widget.al$t, com.tk.component.listview.layoutmanager.b$a] */
    public final void a(al alVar, al.u uVar, int i) {
        a((al.t) this.yx.f(alVar, i));
    }

    @Override // com.tk.component.listview.layoutmanager.a
    public final void N(int i, int i2) {
        super.N(i, i2);
    }

    public final int b(int i, al.p pVar, al.u uVar) {
        try {
            return super.b(i, pVar, uVar);
        } catch (Exception e) {
            com.tk.core.i.a.a("TKStaggeredGridLayoutManager", e.getMessage(), e);
            return 0;
        }
    }

    public final void c(al alVar, int i, int i2) {
        super.c(alVar, i, i2);
        if (i == 0) {
            try {
                if (this.du != null) {
                    alVar.removeCallbacks(this.du);
                }
                alVar.post(gP());
            } catch (Exception e) {
                com.tk.core.i.a.a("TKStaggeredGridLayoutManager", e.getMessage(), e);
            }
        }
    }

    private Runnable gP() {
        if (this.du == null) {
            this.du = new Runnable() { // from class: android.support.v7.widget.TKStaggeredGridLayoutManager.1
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        if (TKStaggeredGridLayoutManager.this.isAttachedToWindow()) {
                            TKStaggeredGridLayoutManager.this.gs();
                        }
                    } catch (Exception e) {
                        com.tk.core.i.a.a("TKStaggeredGridLayoutManager", e.getMessage(), e);
                    }
                }
            };
        }
        return this.du;
    }

    final boolean gs() {
        this.yy = true;
        boolean zGs = super.gs();
        this.yy = false;
        return zGs;
    }

    public final void aB(int i) {
        if (i == 0) {
            gs();
        }
        try {
            super.aB(i);
        } catch (Exception e) {
            com.tk.core.i.a.a("TKStaggeredGridLayoutManager", e.getMessage(), e);
        }
    }

    public final void c(al.p pVar, al.u uVar) {
        try {
            super.c(pVar, uVar);
        } catch (IndexOutOfBoundsException e) {
            com.tk.core.i.a.a("TKStaggeredGridLayoutManager", e.getMessage(), e);
        }
    }

    @Override // android.support.v7.widget.aj.i
    public final void requestLayout() {
        if (this.yy) {
            gQ();
        }
        super.requestLayout();
    }

    private void gQ() {
        WeakReference<al> weakReference = this.yz;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        try {
            this.pD.ex();
        } catch (Exception e) {
            com.tk.core.i.a.a("TKStaggeredGridLayoutManager", e.getMessage(), e);
        }
    }
}
