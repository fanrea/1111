package com.tk.core.component.e;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.al;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class b extends al.a {
    private boolean aeA;
    private boolean aeB;
    private boolean aeC;
    private final a aep;
    private final a aeq;
    private final al.c aer;
    private al.c aes;
    private al.c aet;
    private al.a aeu;
    private al.a aev;
    private int aew;
    private int aex;
    private boolean aey;
    private int aez;
    private al.a sN;

    private static int dR(int i) {
        return i + 2048;
    }

    private static int dS(int i) {
        return i + 1024;
    }

    public b(al.a aVar) {
        this(aVar, null, null);
    }

    private b(al.a aVar, List<View> list, List<View> list2) {
        this.aew = -2048;
        this.aex = -1024;
        this.aez = -1;
        this.aeA = false;
        this.aeB = true;
        this.sN = aVar;
        this.aep = new a(null);
        this.aeq = new a(null);
        this.aer = new al.c() { // from class: com.tk.core.component.e.b.1
            @Override // android.support.v7.widget.al.c
            public final void onChanged() {
                if (!b.this.aeA) {
                    if (b.this.aeC) {
                        dT(b.this.sN.getItemCount());
                        return;
                    }
                    int itemCount = b.this.sN.getItemCount();
                    try {
                        if (b.this.aez == -1 || (itemCount != 0 && itemCount == b.this.aez)) {
                            b.this.Z(b.this.re(), itemCount);
                        } else {
                            b.this.notifyDataSetChanged();
                        }
                    } catch (Exception unused) {
                    }
                    b.this.aez = itemCount;
                    return;
                }
                b.this.notifyDataSetChanged();
            }

            private void dT(int i) {
                try {
                    int i2 = b.this.aez;
                    int iRe = b.this.re();
                    if (i2 == -1) {
                        b.this.notifyDataSetChanged();
                    } else if (i == i2) {
                        b.this.Z(iRe, i);
                    } else if (i > i2) {
                        b.this.Z(iRe, i2);
                        b.this.ab(iRe + i2, i - i2);
                    } else {
                        b.this.Z(iRe, i);
                        b.this.ac(iRe + i, i2 - i);
                    }
                } catch (Exception unused) {
                }
                b.this.aez = i;
            }

            @Override // android.support.v7.widget.al.c
            public final void ad(int i, int i2) {
                b bVar = b.this;
                bVar.aez = bVar.sN.getItemCount();
                try {
                    b bVar2 = b.this;
                    bVar2.Z(i + bVar2.re(), i2);
                } catch (Exception unused) {
                }
            }

            @Override // android.support.v7.widget.al.c
            public final void e(int i, int i2, Object obj) {
                b bVar = b.this;
                bVar.aez = bVar.sN.getItemCount();
                try {
                    b bVar2 = b.this;
                    bVar2.d(i + bVar2.re(), i2, obj);
                } catch (Exception unused) {
                }
            }

            @Override // android.support.v7.widget.al.c
            public final void ae(int i, int i2) {
                b bVar = b.this;
                bVar.aez = bVar.sN.getItemCount();
                try {
                    b bVar2 = b.this;
                    bVar2.ab(i + bVar2.re(), i2);
                } catch (Exception unused) {
                }
            }

            @Override // android.support.v7.widget.al.c
            public final void af(int i, int i2) {
                try {
                    b bVar = b.this;
                    bVar.ac(i + bVar.re(), i2);
                } catch (Exception unused) {
                }
            }

            @Override // android.support.v7.widget.al.c
            public final void e(int i, int i2, int i3) {
                try {
                    b bVar = b.this;
                    bVar.aa(i + bVar.re(), i2 + b.this.re());
                } catch (Exception unused) {
                }
            }
        };
        al.c cVar = this.aer;
        this.aes = cVar;
        this.aet = cVar;
        this.sN.a(cVar);
    }

    @Override // android.support.v7.widget.al.a
    public final al.x b(ViewGroup viewGroup, int i) {
        if (dP(i)) {
            int iDS = dS(i);
            al.a aVar = this.aeu;
            if (aVar == null) {
                View viewDU = this.aep.dU(iDS);
                if (viewDU != null && (viewDU.getParent() instanceof ViewGroup)) {
                    ((ViewGroup) viewDU.getParent()).removeView(viewDU);
                }
                return bc(viewDU);
            }
            return aVar.b(viewGroup, iDS);
        }
        if (dQ(i)) {
            int iDR = dR(i);
            al.a aVar2 = this.aev;
            if (aVar2 == null) {
                View viewDU2 = this.aeq.dU(iDR);
                if (viewDU2 != null && (viewDU2.getParent() instanceof ViewGroup)) {
                    ((ViewGroup) viewDU2.getParent()).removeView(viewDU2);
                }
                return bc(viewDU2);
            }
            return aVar2.b(viewGroup, iDR);
        }
        return this.sN.b(viewGroup, i);
    }

    @Override // android.support.v7.widget.al.a
    public final void b(al.x xVar, int i) {
        al.a aVar;
        al.a aVar2;
        if (i < re() || i >= re() + this.sN.getItemCount()) {
            if (i < re() && (aVar2 = this.aeu) != null) {
                aVar2.b((al.a) xVar, i);
                return;
            } else {
                if (i < re() + this.sN.getItemCount() || (aVar = this.aev) == null) {
                    return;
                }
                aVar.b((al.a) xVar, (i - re()) - this.sN.getItemCount());
                return;
            }
        }
        this.sN.b((al.a) xVar, i - re());
    }

    @Override // android.support.v7.widget.al.a
    public final void a(al.x xVar, int i, List list) {
        al.a aVar;
        al.a aVar2;
        if (list.isEmpty()) {
            b(xVar, i);
            return;
        }
        if (i < re() || i >= re() + this.sN.getItemCount()) {
            if (i < re() && (aVar2 = this.aeu) != null) {
                aVar2.a(xVar, i, list);
                return;
            } else {
                if (i < re() + this.sN.getItemCount() || (aVar = this.aev) == null) {
                    return;
                }
                aVar.a(xVar, (i - re()) - this.sN.getItemCount(), list);
                return;
            }
        }
        this.sN.a(xVar, i - re(), list);
    }

    @Override // android.support.v7.widget.al.a
    public final long getItemId(int i) {
        if (dN(i)) {
            al.a aVar = this.aeu;
            if (aVar != null) {
                return aVar.getItemId(i);
            }
            return getItemViewType(i);
        }
        if (dO(i)) {
            if (this.aev != null) {
                return this.aev.getItemId((i - re()) - this.sN.getItemCount());
            }
            return getItemViewType(i);
        }
        return this.sN.getItemId(i - re());
    }

    @Override // android.support.v7.widget.al.a
    public final int getItemViewType(int i) {
        int iDV;
        int iDV2;
        if (dN(i)) {
            al.a aVar = this.aeu;
            if (aVar != null) {
                iDV2 = aVar.getItemViewType(i);
            } else {
                iDV2 = this.aep.dV(i);
            }
            int i2 = iDV2 - 1024;
            this.aex = Math.max(i2, this.aex);
            return i2;
        }
        if (dO(i)) {
            int itemCount = (i - this.sN.getItemCount()) - re();
            al.a aVar2 = this.aev;
            if (aVar2 != null) {
                iDV = aVar2.getItemViewType(itemCount);
            } else {
                iDV = this.aeq.dV(itemCount);
            }
            int i3 = iDV - 2048;
            this.aew = Math.max(i3, this.aew);
            return i3;
        }
        return this.sN.getItemViewType(i - re());
    }

    @Override // android.support.v7.widget.al.a
    public final int getItemCount() {
        return rf() + re() + this.sN.getItemCount();
    }

    public final int re() {
        al.a aVar = this.aeu;
        return aVar != null ? aVar.getItemCount() : this.aep.rg();
    }

    public final int rf() {
        al.a aVar = this.aev;
        return aVar != null ? aVar.getItemCount() : this.aeq.rg();
    }

    public final boolean dN(int i) {
        return i < re();
    }

    public final boolean dO(int i) {
        return i >= re() + this.sN.getItemCount();
    }

    public final boolean removeHeaderView(View view) {
        boolean zBf = this.aep.bf(view);
        if (zBf) {
            try {
                aF(0);
            } catch (Exception unused) {
            }
        }
        return zBf;
    }

    public final boolean removeFooterView(View view) {
        boolean zBf = this.aeq.bf(view);
        if (zBf) {
            try {
                aF(getItemCount());
            } catch (Exception unused) {
            }
        }
        return zBf;
    }

    public final void a(View view, ViewGroup.LayoutParams layoutParams) {
        if (view == null) {
            throw new IllegalArgumentException("the view to add must not be null");
        }
        view.setLayoutParams(layoutParams);
        if (this.aep.be(view)) {
            try {
                aE(0);
            } catch (Exception unused) {
            }
        }
    }

    public final void b(View view, ViewGroup.LayoutParams layoutParams) {
        if (view == null) {
            throw new IllegalArgumentException("the view to add must not be null!");
        }
        if ((view.getParent() instanceof ViewGroup) && view.getParent() != this.aeq) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        view.setLayoutParams(layoutParams);
        if (this.aeq.be(view)) {
            try {
                aE(getItemCount() - 1);
            } catch (Exception unused) {
            }
        }
    }

    private boolean dP(int i) {
        return i >= -1024 && i <= this.aex;
    }

    private boolean dQ(int i) {
        return i >= -2048 && i <= this.aew;
    }

    private al.x bc(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        int i = layoutParams == null ? -1 : layoutParams.width;
        int i2 = layoutParams == null ? -2 : layoutParams.height;
        if (this.aeB) {
            if (this.aey) {
                StaggeredGridLayoutManager.b bVar = new StaggeredGridLayoutManager.b(i, i2);
                bVar.G(true);
                view.setLayoutParams(bVar);
            } else {
                view.setLayoutParams(new al.j(i, i2));
            }
        }
        if (view instanceof com.tk.core.p.a.a) {
            com.tk.core.p.a.a aVar = (com.tk.core.p.a.a) view;
            return new com.tk.core.component.e.a(view, aVar.getYogaNode().getWidth(), aVar.getYogaNode().getHeight());
        }
        return new al.x(view) { // from class: com.tk.core.component.e.b.2
        };
    }

    public final void t(al alVar) {
        a(alVar, (GridLayoutManager.c) null);
    }

    private void a(al alVar, GridLayoutManager.c cVar) {
        if (alVar.getLayoutManager() instanceof GridLayoutManager) {
            final GridLayoutManager gridLayoutManager = (GridLayoutManager) alVar.getLayoutManager();
            final GridLayoutManager.c cVar2 = null;
            gridLayoutManager.a(new GridLayoutManager.c() { // from class: com.tk.core.component.e.b.3
                public final int am(int i) {
                    if (b.this.dN(i) || b.this.dO(i)) {
                        return gridLayoutManager.dg();
                    }
                    GridLayoutManager.c cVar3 = cVar2;
                    if (cVar3 != null) {
                        return cVar3.am(i);
                    }
                    return 1;
                }
            });
        }
        if (alVar.getLayoutManager() instanceof StaggeredGridLayoutManager) {
            this.aey = true;
        }
    }

    public final void at(boolean z) {
        this.aey = z;
    }

    @Override // android.support.v7.widget.al.a
    public final void a(al.c cVar) {
        super.a(cVar);
    }

    @Override // android.support.v7.widget.al.a
    public final void m(al.x xVar) {
        super.m(xVar);
        int iFy = xVar.fy();
        if (dP(iFy)) {
            al.a aVar = this.aeu;
            if (aVar != null) {
                aVar.m(xVar);
                return;
            } else {
                c(xVar, true);
                return;
            }
        }
        if (dQ(iFy)) {
            al.a aVar2 = this.aev;
            if (aVar2 != null) {
                aVar2.m(xVar);
                return;
            } else {
                c(xVar, true);
                return;
            }
        }
        this.sN.m(xVar);
        c(xVar, false);
    }

    private static void c(al.x xVar, boolean z) {
        ViewGroup.LayoutParams layoutParams = xVar.vu.getLayoutParams();
        if (layoutParams instanceof StaggeredGridLayoutManager.b) {
            ((StaggeredGridLayoutManager.b) layoutParams).G(z);
        }
    }

    private void u(al alVar) {
        Object layoutManager = alVar.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            final GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            gridLayoutManager.a(new GridLayoutManager.c() { // from class: com.tk.core.component.e.b.4
                public final int am(int i) {
                    if (b.this.dN(i) || b.this.dO(i)) {
                        return gridLayoutManager.dg();
                    }
                    return 1;
                }
            });
        }
    }

    @Override // android.support.v7.widget.al.a
    public final void b(al.c cVar) {
        super.b(cVar);
    }

    @Override // android.support.v7.widget.al.a
    public final void e(al alVar) {
        super.e(alVar);
        if (this.sN.hasObservers()) {
            this.sN.b(this.aer);
        }
        this.sN.a(this.aer);
        this.sN.e(alVar);
        al.a aVar = this.aeu;
        if (aVar != null) {
            aVar.e(alVar);
            this.aeu.b(this.aes);
            this.aeu.a(this.aes);
        }
        al.a aVar2 = this.aev;
        if (aVar2 != null) {
            aVar2.e(alVar);
            this.aev.b(this.aet);
            this.aev.a(this.aet);
        }
        u(alVar);
    }

    @Override // android.support.v7.widget.al.a
    public final void f(al alVar) {
        super.f(alVar);
        if (this.sN.hasObservers()) {
            this.sN.b(this.aer);
        }
        this.sN.f(alVar);
        al.a aVar = this.aeu;
        if (aVar != null) {
            aVar.f(alVar);
            this.aeu.b(this.aes);
        }
        al.a aVar2 = this.aev;
        if (aVar2 != null) {
            aVar2.f(alVar);
            this.aev.b(this.aet);
        }
    }

    public final String toString() {
        return "RecyclerHeaderFooterAdapter{mAdapter=" + this.sN + ", mHeaderAdapter=" + this.aeu + ", mFooterAdapter=" + this.aev + '}';
    }

    public static class a {
        public final SparseArray<View> aeH;
        public int bR;

        a() {
            this(null);
        }

        a(List<View> list) {
            this.aeH = new SparseArray<>();
            this.bR = 0;
            if (list != null) {
                for (View view : list) {
                    SparseArray<View> sparseArray = this.aeH;
                    int i = this.bR;
                    this.bR = i + 1;
                    sparseArray.put(i, view);
                }
            }
        }

        private boolean bd(View view) {
            return this.aeH.indexOfValue(view) >= 0;
        }

        final boolean be(View view) {
            if (bd(view)) {
                return false;
            }
            SparseArray<View> sparseArray = this.aeH;
            int i = this.bR;
            this.bR = i + 1;
            sparseArray.put(i, view);
            return true;
        }

        final boolean bf(View view) {
            int iIndexOfValue = this.aeH.indexOfValue(view);
            if (iIndexOfValue < 0) {
                return false;
            }
            this.aeH.removeAt(iIndexOfValue);
            return true;
        }

        final View dU(int i) {
            return this.aeH.get(i);
        }

        final int dV(int i) {
            if (i < 0 || i >= this.aeH.size()) {
                return -1;
            }
            return this.aeH.keyAt(i);
        }

        final int rg() {
            return this.aeH.size();
        }
    }
}
