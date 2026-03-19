package com.tk.component.scroll.b.b;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.al;
import android.view.View;
import android.view.ViewGroup;
import com.tk.component.scroll.b.b.h;
import java.util.Locale;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class g extends al.n {
    private final LinearLayoutManager FE;
    private final h Wd;
    private h.e Wk;
    private int Wl;
    private a Wm = new a();
    private int Wn;
    private int Wo;
    private boolean Wp;
    private boolean Wq;
    private boolean Wr;
    private boolean Ws;
    private final al pD;
    private int tp;

    g(h hVar) {
        this.Wd = hVar;
        this.pD = this.Wd.pD;
        this.FE = (LinearLayoutManager) this.pD.getLayoutManager();
        oj();
    }

    private void oj() {
        this.Wl = 0;
        this.tp = 0;
        this.Wm.reset();
        this.Wn = -1;
        this.Wo = -1;
        this.Wp = false;
        this.Wq = false;
        this.Ws = false;
        this.Wr = false;
    }

    @Override // android.support.v7.widget.al.n
    public final void c(al alVar, int i) {
        boolean z = true;
        if ((this.Wl != 1 || this.tp != 1) && i == 1) {
            al(false);
            return;
        }
        if (op() && i == 2) {
            if (this.Wq) {
                dk(2);
                this.Wp = true;
                return;
            }
            return;
        }
        if (op() && i == 0) {
            ok();
            if (!this.Wq) {
                if (this.Wm.rk != -1) {
                    b(this.Wm.rk, 0.0f, 0);
                }
            } else if (this.Wm.Wt != 0) {
                z = false;
            } else if (this.Wn != this.Wm.rk) {
                dl(this.Wm.rk);
            }
            if (z) {
                dk(0);
                oj();
            }
        }
        if (this.Wl == 2 && i == 0 && this.Wr) {
            ok();
            if (this.Wm.Wt == 0) {
                if (this.Wo != this.Wm.rk) {
                    dl(this.Wm.rk == -1 ? 0 : this.Wm.rk);
                }
                dk(0);
                oj();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x003d  */
    @Override // android.support.v7.widget.al.n
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(android.support.v7.widget.al r4, int r5, int r6) {
        /*
            r3 = this;
            r4 = 1
            r3.Wq = r4
            r3.ok()
            boolean r0 = r3.Wp
            r1 = -1
            r2 = 0
            if (r0 == 0) goto L41
            r3.Wp = r2
            if (r6 > 0) goto L22
            if (r6 != 0) goto L20
            if (r5 >= 0) goto L16
            r5 = 1
            goto L17
        L16:
            r5 = 0
        L17:
            com.tk.component.scroll.b.b.h r6 = r3.Wd
            boolean r6 = r6.ov()
            if (r5 != r6) goto L20
            goto L22
        L20:
            r5 = 0
            goto L23
        L22:
            r5 = 1
        L23:
            if (r5 == 0) goto L31
            com.tk.component.scroll.b.b.g$a r5 = r3.Wm
            int r5 = r5.Wt
            if (r5 == 0) goto L31
            com.tk.component.scroll.b.b.g$a r5 = r3.Wm
            int r5 = r5.rk
            int r5 = r5 + r4
            goto L35
        L31:
            com.tk.component.scroll.b.b.g$a r5 = r3.Wm
            int r5 = r5.rk
        L35:
            r3.Wo = r5
            int r5 = r3.Wn
            int r6 = r3.Wo
            if (r5 == r6) goto L4f
            r3.dl(r6)
            goto L4f
        L41:
            int r5 = r3.Wl
            if (r5 != 0) goto L4f
            com.tk.component.scroll.b.b.g$a r5 = r3.Wm
            int r5 = r5.rk
            if (r5 != r1) goto L4c
            r5 = 0
        L4c:
            r3.dl(r5)
        L4f:
            com.tk.component.scroll.b.b.g$a r5 = r3.Wm
            int r5 = r5.rk
            if (r5 != r1) goto L57
            r5 = 0
            goto L5b
        L57:
            com.tk.component.scroll.b.b.g$a r5 = r3.Wm
            int r5 = r5.rk
        L5b:
            com.tk.component.scroll.b.b.g$a r6 = r3.Wm
            float r6 = r6.TH
            com.tk.component.scroll.b.b.g$a r0 = r3.Wm
            int r0 = r0.Wt
            r3.b(r5, r6, r0)
            com.tk.component.scroll.b.b.g$a r5 = r3.Wm
            int r5 = r5.rk
            int r6 = r3.Wo
            if (r5 == r6) goto L70
            if (r6 != r1) goto L80
        L70:
            com.tk.component.scroll.b.b.g$a r5 = r3.Wm
            int r5 = r5.Wt
            if (r5 != 0) goto L80
            int r5 = r3.tp
            if (r5 == r4) goto L80
            r3.dk(r2)
            r3.oj()
        L80:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.component.scroll.b.b.g.a(android.support.v7.widget.al, int, int):void");
    }

    private void ok() {
        int top;
        a aVar = this.Wm;
        aVar.rk = this.FE.dx();
        if (aVar.rk == -1) {
            aVar.reset();
            return;
        }
        View viewAp = this.FE.ap(aVar.rk);
        if (viewAp == null) {
            aVar.reset();
            return;
        }
        int iAn = LinearLayoutManager.an(viewAp);
        int iAo = LinearLayoutManager.ao(viewAp);
        int iAl = LinearLayoutManager.al(viewAp);
        int iAm = LinearLayoutManager.am(viewAp);
        ViewGroup.LayoutParams layoutParams = viewAp.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            iAn += marginLayoutParams.leftMargin;
            iAo += marginLayoutParams.rightMargin;
            iAl += marginLayoutParams.topMargin;
            iAm += marginLayoutParams.bottomMargin;
        }
        int height = viewAp.getHeight() + iAl + iAm;
        int width = iAo + viewAp.getWidth() + iAn;
        if (this.FE.getOrientation() == 0) {
            top = (viewAp.getLeft() - iAn) - this.pD.getPaddingLeft();
            if (this.Wd.ov()) {
                top = -top;
            }
        } else {
            top = (viewAp.getTop() - iAl) - this.pD.getPaddingTop();
            width = height;
        }
        aVar.Wt = -top;
        if (aVar.Wt < 0) {
            if (new com.tk.component.scroll.b.b.a(this.FE).ob()) {
                throw new IllegalStateException("Page(s) contain a ViewGroup with a LayoutTransition (or animateLayoutChanges=\"true\"), which interferes with the scrolling animation. Make sure to call getLayoutTransition().setAnimateParentHierarchy(false) on all ViewGroups with a LayoutTransition before an animation is started.");
            }
            throw new IllegalStateException(String.format(Locale.US, "Page can only be offset by a positive amount, not by %d", Integer.valueOf(aVar.Wt)));
        }
        aVar.TH = width == 0 ? 0.0f : aVar.Wt / width;
    }

    private void al(boolean z) {
        this.Ws = z;
        this.Wl = z ? 4 : 1;
        int i = this.Wo;
        if (i != -1) {
            this.Wn = i;
            this.Wo = -1;
        } else if (this.Wn == -1) {
            this.Wn = getPosition();
        }
        dk(1);
    }

    final void ol() {
        this.Wr = true;
    }

    final void g(int i, boolean z) {
        this.Wl = z ? 2 : 3;
        this.Ws = false;
        boolean z2 = this.Wo != i;
        this.Wo = i;
        dk(2);
        if (z2) {
            dl(i);
        }
    }

    final void om() {
        this.Wl = 4;
        al(true);
    }

    final void on() {
        if (!oo() || this.Ws) {
            this.Ws = false;
            ok();
            if (this.Wm.Wt == 0) {
                if (this.Wm.rk != this.Wn) {
                    dl(this.Wm.rk);
                }
                dk(0);
                oj();
                return;
            }
            dk(2);
        }
    }

    final void b(h.e eVar) {
        this.Wk = eVar;
    }

    final int getScrollState() {
        return this.tp;
    }

    final boolean isIdle() {
        return this.tp == 0;
    }

    final boolean oo() {
        return this.tp == 1;
    }

    final boolean oe() {
        return this.Ws;
    }

    private boolean op() {
        int i = this.Wl;
        return i == 1 || i == 4;
    }

    final double oq() {
        ok();
        double d = this.Wm.rk;
        double d2 = this.Wm.TH;
        Double.isNaN(d);
        Double.isNaN(d2);
        return d + d2;
    }

    private void dk(int i) {
        if ((this.Wl == 3 && this.tp == 0) || this.tp == i) {
            return;
        }
        this.tp = i;
        h.e eVar = this.Wk;
        if (eVar != null) {
            eVar.dj(i);
        }
    }

    private void dl(int i) {
        h.e eVar = this.Wk;
        if (eVar != null) {
            eVar.di(i);
        }
    }

    private void b(int i, float f, int i2) {
        h.e eVar = this.Wk;
        if (eVar != null) {
            eVar.a(i, f, i2);
        }
    }

    private int getPosition() {
        return this.FE.dx();
    }

    static final class a {
        float TH;
        int Wt;
        int rk;

        a() {
        }

        final void reset() {
            this.rk = -1;
            this.TH = 0.0f;
            this.Wt = 0;
        }
    }
}
