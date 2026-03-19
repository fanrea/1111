package com.tk.component.listview.c;

import android.support.v7.widget.ae;
import android.support.v7.widget.aj;
import android.support.v7.widget.al;
import android.view.View;
import com.tk.component.listview.c.a.d;
import com.tk.core.o.o;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class c extends ae implements a {
    public static final int Tz = o.eb(3);
    private final int SF;
    private boolean TA;
    private b TB;
    private final com.tk.component.listview.c.a.a TC;
    private boolean TD;
    private al pD;
    private aj rG;
    private aj rH;
    private int TE = -1000;
    private boolean TF = true;
    private float TG = 0.5f;
    private float TH = 0.0f;
    private final al.n tF = new al.n() { // from class: com.tk.component.listview.c.c.1
        private int TI;
        private boolean TJ;

        @Override // android.support.v7.widget.al.n
        public final void c(final al alVar, int i) {
            super.c(alVar, i);
            if (!c.this.TD && i == 1) {
                c.this.TD = true;
            }
            if (i == 0) {
                this.TI = 0;
                if (c.this.TD) {
                    c.this.TD = false;
                    alVar.post(new Runnable() { // from class: com.tk.component.listview.c.c.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            if (c.this.TA) {
                                return;
                            }
                            c.this.r(alVar);
                        }
                    });
                }
            }
        }

        @Override // android.support.v7.widget.al.n
        public final void a(al alVar, int i, int i2) {
            super.a(alVar, i, i2);
            if (c.this.TD) {
                if (i2 != 0) {
                    i = i2;
                }
                boolean z = i > 0;
                if (this.TJ != z) {
                    this.TI = i;
                } else {
                    this.TI += i;
                }
                this.TJ = z;
                if (c.this.TF == z || Math.abs(this.TI) <= c.Tz) {
                    return;
                }
                c.this.TF = z;
            }
        }
    };

    public c(int i) {
        this.SF = i;
        int i2 = this.SF;
        if (i2 == 2) {
            this.TC = new d();
        } else if (i2 == 3) {
            this.TC = new com.tk.component.listview.c.a.c();
        } else {
            this.TC = new com.tk.component.listview.c.a.b();
        }
    }

    public final void a(al alVar) {
        if (this.pD == alVar) {
            return;
        }
        super.a(alVar);
        al alVar2 = this.pD;
        if (alVar2 != null) {
            alVar2.b(this.tF);
        }
        this.pD = alVar;
        al alVar3 = this.pD;
        if (alVar3 != null) {
            alVar3.a(this.tF);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(al alVar) {
        al.i layoutManager;
        aj ajVarI;
        View viewD;
        int iX;
        if (this.TB == null || (layoutManager = alVar.getLayoutManager()) == null || (ajVarI = i(layoutManager)) == null || (viewD = d(layoutManager, ajVarI)) == null || (iX = al.X(viewD)) < 0 || iX >= layoutManager.getItemCount() || this.TE == iX) {
            return;
        }
        this.TE = iX;
        this.TB.cW(iX);
    }

    public final View a(al.i iVar) {
        return d(iVar, i(iVar));
    }

    public final int[] a(al.i iVar, View view) {
        int[] iArr = new int[2];
        if (iVar.dm()) {
            iArr[0] = b(iVar, view, c(iVar));
        } else {
            iArr[0] = 0;
        }
        if (iVar.dn()) {
            iArr[1] = b(iVar, view, b(iVar));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    private int b(al.i iVar, View view, aj ajVar) {
        return this.TC.a(iVar, view, ajVar, this.TH);
    }

    private View d(al.i iVar, aj ajVar) {
        int childCount;
        int iA;
        int iAbs;
        if (ajVar == null || (childCount = iVar.getChildCount()) == 0) {
            return null;
        }
        int iA2 = this.TC.a(iVar, ajVar, this.TH);
        View view = null;
        int i = Integer.MAX_VALUE;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = iVar.getChildAt(i2);
            if (childAt != null && (iAbs = Math.abs(this.TC.a(iVar, childAt, ajVar, iA2))) < i) {
                view = childAt;
                i = iAbs;
            }
        }
        if (view == null) {
            return null;
        }
        if (this.TG == 0.5f) {
            return view;
        }
        int iP = ajVar.P(view) - b(iVar, view);
        return (iP == 0 || (iA = this.TC.a(iVar, view, ajVar, iA2)) == 0) ? view : this.TF ? (iA <= 0 && Math.abs(((float) iA) / ((float) iP)) > this.TG) ? a(iVar, ajVar, view) : view : (iA >= 0 && Math.abs((float) iA) / ((float) iP) > this.TG) ? b(iVar, ajVar, view) : view;
    }

    private static int b(al.i iVar, View view) {
        int iAm;
        int iAl;
        if (iVar.dm()) {
            iAm = al.i.ao(view);
            iAl = al.i.an(view);
        } else {
            iAm = al.i.am(view);
            iAl = al.i.al(view);
        }
        return iAm + iAl;
    }

    private View a(al.i iVar, aj ajVar, View view) {
        int iC;
        int iC2 = this.TC.c(iVar, ajVar, view);
        View view2 = view;
        int i = Integer.MAX_VALUE;
        for (int i2 = 0; i2 < iVar.getChildCount(); i2++) {
            View childAt = iVar.getChildAt(i2);
            if (childAt != null && childAt != view && iC2 < (iC = this.TC.c(iVar, ajVar, childAt)) && iC < i) {
                view2 = childAt;
                i = iC;
            }
        }
        return view2;
    }

    private View b(al.i iVar, aj ajVar, View view) {
        int iC;
        int iC2 = this.TC.c(iVar, ajVar, view);
        View view2 = view;
        int i = Integer.MIN_VALUE;
        for (int i2 = 0; i2 < iVar.getChildCount(); i2++) {
            View childAt = iVar.getChildAt(i2);
            if (childAt != null && childAt != view && iC2 > (iC = this.TC.c(iVar, ajVar, childAt)) && iC > i) {
                view2 = childAt;
                i = iC;
            }
        }
        return view2;
    }

    private aj i(al.i iVar) {
        if (iVar.dn()) {
            return b(iVar);
        }
        if (iVar.dm()) {
            return c(iVar);
        }
        return null;
    }

    private aj b(al.i iVar) {
        Object field = com.tk.core.o.a.a.getField(this.rG, "mLayoutManager");
        if (this.rG == null || field != iVar) {
            this.rG = aj.e(iVar);
        }
        return this.rG;
    }

    private aj c(al.i iVar) {
        Object field = com.tk.core.o.a.a.getField(this.rH, "mLayoutManager");
        if (this.rH == null || field != iVar) {
            this.rH = aj.d(iVar);
        }
        return this.rH;
    }

    @Override // com.tk.component.listview.c.a
    public final void a(b bVar) {
        this.TB = bVar;
    }

    @Override // com.tk.component.listview.c.a
    public final void q(float f) {
        this.TG = f;
    }

    @Override // com.tk.component.listview.c.a
    public final void r(float f) {
        this.TH = f;
    }

    @Override // com.tk.component.listview.c.a
    public final void onDestroy() {
        this.TA = true;
        a((b) null);
        a((al) null);
        this.pD = null;
    }
}
