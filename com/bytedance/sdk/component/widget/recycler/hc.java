package com.bytedance.sdk.component.widget.recycler;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class hc {
    final InterfaceC0290hc d;
    final d hc = new d();
    final List<View> b = new ArrayList();

    /* renamed from: com.bytedance.sdk.component.widget.recycler.hc$hc, reason: collision with other inner class name */
    interface InterfaceC0290hc {
        void b(int i);

        void b(View view);

        void c(View view);

        int d();

        int d(View view);

        void d(int i);

        void d(View view, int i);

        void d(View view, int i, ViewGroup.LayoutParams layoutParams);

        View hc(int i);

        RecyclerView.v hc(View view);

        void hc();
    }

    hc(InterfaceC0290hc interfaceC0290hc) {
        this.d = interfaceC0290hc;
    }

    private void h(View view) {
        this.b.add(view);
        this.d.b(view);
    }

    private boolean gb(View view) {
        if (!this.b.remove(view)) {
            return false;
        }
        this.d.c(view);
        return true;
    }

    void d(View view, boolean z) {
        d(view, -1, z);
    }

    void d(View view, int i, boolean z) {
        int iAn;
        if (i < 0) {
            iAn = this.d.d();
        } else {
            iAn = an(i);
        }
        this.hc.insert(iAn, z);
        if (z) {
            h(view);
        }
        this.d.d(view, iAn);
    }

    private int an(int i) {
        if (i < 0) {
            return -1;
        }
        int iD = this.d.d();
        int i2 = i;
        while (i2 < iD) {
            int iU = i - (i2 - this.hc.u(i2));
            if (iU == 0) {
                while (this.hc.b(i2)) {
                    i2++;
                }
                return i2;
            }
            i2 += iU;
        }
        return -1;
    }

    void d(View view) {
        int iD = this.d.d(view);
        if (iD >= 0) {
            if (this.hc.c(iD)) {
                gb(view);
            }
            this.d.d(iD);
        }
    }

    void d(int i) {
        int iAn = an(i);
        View viewHc = this.d.hc(iAn);
        if (viewHc != null) {
            if (this.hc.c(iAn)) {
                gb(viewHc);
            }
            this.d.d(iAn);
        }
    }

    View hc(int i) {
        return this.d.hc(an(i));
    }

    void d() {
        this.hc.d();
        for (int size = this.b.size() - 1; size >= 0; size--) {
            this.d.c(this.b.get(size));
            this.b.remove(size);
        }
        this.d.hc();
    }

    View b(int i) {
        int size = this.b.size();
        for (int i2 = 0; i2 < size; i2++) {
            View view = this.b.get(i2);
            RecyclerView.v vVarHc = this.d.hc(view);
            if (vVarHc.c() == i && !vVarHc.k() && !vVarHc.w()) {
                return view;
            }
        }
        return null;
    }

    void d(View view, int i, ViewGroup.LayoutParams layoutParams, boolean z) {
        int iAn;
        if (i < 0) {
            iAn = this.d.d();
        } else {
            iAn = an(i);
        }
        this.hc.insert(iAn, z);
        if (z) {
            h(view);
        }
        this.d.d(view, iAn, layoutParams);
    }

    int hc() {
        return this.d.d() - this.b.size();
    }

    int b() {
        return this.d.d();
    }

    View c(int i) {
        return this.d.hc(i);
    }

    void u(int i) {
        int iAn = an(i);
        this.hc.c(iAn);
        this.d.b(iAn);
    }

    int hc(View view) {
        int iD = this.d.d(view);
        if (iD == -1 || this.hc.b(iD)) {
            return -1;
        }
        return iD - this.hc.u(iD);
    }

    boolean b(View view) {
        return this.b.contains(view);
    }

    void c(View view) {
        int iD = this.d.d(view);
        if (iD < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide ".concat(String.valueOf(view)));
        }
        this.hc.d(iD);
        h(view);
    }

    void u(View view) {
        int iD = this.d.d(view);
        if (iD < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide ".concat(String.valueOf(view)));
        }
        if (!this.hc.b(iD)) {
            throw new RuntimeException("trying to unhide a view that was not hidden".concat(String.valueOf(view)));
        }
        this.hc.hc(iD);
        gb(view);
    }

    public String toString() {
        return this.hc.toString() + ", hidden list:" + this.b.size();
    }

    boolean an(View view) {
        int iD = this.d.d(view);
        if (iD == -1) {
            gb(view);
            return true;
        }
        if (!this.hc.b(iD)) {
            return false;
        }
        this.hc.c(iD);
        gb(view);
        this.d.d(iD);
        return true;
    }

    static class d {
        long d = 0;
        d hc;

        d() {
        }

        void d(int i) {
            if (i >= 64) {
                hc();
                this.hc.d(i - 64);
            } else {
                this.d |= 1 << i;
            }
        }

        private void hc() {
            if (this.hc == null) {
                this.hc = new d();
            }
        }

        void hc(int i) {
            if (i >= 64) {
                d dVar = this.hc;
                if (dVar != null) {
                    dVar.hc(i - 64);
                    return;
                }
                return;
            }
            this.d &= ~(1 << i);
        }

        boolean b(int i) {
            if (i < 64) {
                return (this.d & (1 << i)) != 0;
            }
            hc();
            return this.hc.b(i - 64);
        }

        void d() {
            this.d = 0L;
            d dVar = this.hc;
            if (dVar != null) {
                dVar.d();
            }
        }

        void insert(int i, boolean z) {
            if (i >= 64) {
                hc();
                this.hc.insert(i - 64, z);
                return;
            }
            long j = this.d;
            boolean z2 = (Long.MIN_VALUE & j) != 0;
            long j2 = (1 << i) - 1;
            this.d = ((j & (~j2)) << 1) | (j & j2);
            if (z) {
                d(i);
            } else {
                hc(i);
            }
            if (z2 || this.hc != null) {
                hc();
                this.hc.insert(0, z2);
            }
        }

        boolean c(int i) {
            if (i >= 64) {
                hc();
                return this.hc.c(i - 64);
            }
            long j = 1 << i;
            long j2 = this.d;
            boolean z = (j2 & j) != 0;
            long j3 = j2 & (~j);
            this.d = j3;
            long j4 = j - 1;
            this.d = (j3 & j4) | Long.rotateRight((~j4) & j3, 1);
            d dVar = this.hc;
            if (dVar != null) {
                if (dVar.b(0)) {
                    d(63);
                }
                this.hc.c(0);
            }
            return z;
        }

        int u(int i) {
            d dVar = this.hc;
            return dVar == null ? i >= 64 ? Long.bitCount(this.d) : Long.bitCount(this.d & ((1 << i) - 1)) : i < 64 ? Long.bitCount(this.d & ((1 << i) - 1)) : dVar.u(i - 64) + Long.bitCount(this.d);
        }

        public String toString() {
            return this.hc == null ? Long.toBinaryString(this.d) : this.hc.toString() + "xx" + Long.toBinaryString(this.d);
        }
    }
}
