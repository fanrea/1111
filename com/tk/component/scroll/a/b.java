package com.tk.component.scroll.a;

import android.view.ViewGroup;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class b {
    private com.tk.component.b.b VT;
    private com.tk.component.b.a VU;
    private long VV;
    private long VW;
    private int VX = -1;
    private int VY = -1;

    public final void b(com.tk.component.b.b bVar) {
        this.VT = bVar;
    }

    public final void b(com.tk.component.b.a aVar) {
        this.VU = aVar;
    }

    public final void aD(int i, int i2) {
        if (this.VT == null) {
            return;
        }
        if (this.VX == i && this.VY == i2) {
            return;
        }
        this.VX = i;
        this.VY = i2;
        this.VT.aD(i, i2);
    }

    public final void a(ViewGroup viewGroup, int i, int i2) {
        com.tk.component.b.b bVar = this.VT;
        if (bVar != null) {
            bVar.f(viewGroup.getScrollX(), viewGroup.getScrollY(), i, i2);
        }
    }

    public final void b(ViewGroup viewGroup, int i, int i2) {
        com.tk.component.b.b bVar = this.VT;
        if (bVar != null) {
            bVar.g(viewGroup.getScrollX(), viewGroup.getScrollY(), i, i2);
        }
    }

    public final void c(ViewGroup viewGroup, int i, int i2) {
        if (this.VT != null) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - this.VV > 50) {
                this.VV = jCurrentTimeMillis;
                this.VT.j(viewGroup.getScrollX(), viewGroup.getScrollY(), i, i2);
            }
        }
    }

    public final void d(ViewGroup viewGroup, int i, int i2) {
        if (this.VT != null) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - this.VW > 50) {
                this.VW = jCurrentTimeMillis;
                this.VT.k(viewGroup.getScrollX(), viewGroup.getScrollY(), i, i2);
            }
        }
    }

    public final void e(ViewGroup viewGroup, int i, int i2) {
        com.tk.component.b.b bVar = this.VT;
        if (bVar != null) {
            bVar.h(viewGroup.getScrollX(), viewGroup.getScrollY(), i, i2);
        }
    }

    public final void f(ViewGroup viewGroup, int i, int i2) {
        com.tk.component.b.b bVar = this.VT;
        if (bVar != null) {
            bVar.i(viewGroup.getScrollX(), viewGroup.getScrollY(), i, i2);
        }
    }

    public final void aC(int i, int i2) {
        com.tk.component.b.a aVar = this.VU;
        if (aVar != null) {
            aVar.aC(i, i2);
        }
    }

    public final void aB(int i) {
        com.tk.component.b.b bVar = this.VT;
        if (bVar != null) {
            bVar.aB(i);
        }
    }

    public final void onDestroy() {
        this.VT = null;
        this.VU = null;
    }
}
