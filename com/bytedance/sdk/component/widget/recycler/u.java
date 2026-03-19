package com.bytedance.sdk.component.widget.recycler;

import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class u extends RecyclerView.tt implements RecyclerView.rf.hc {
    c an;
    boolean b;
    int c;
    int d;
    private boolean de;
    final d h;
    gb hc;
    private boolean jh;
    private final hc np;
    private boolean rf;
    private boolean sy;
    int u;
    private boolean v;
    private int yi;
    private b yo;

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.tt
    public boolean d() {
        return true;
    }

    public u(Context context) {
        this(context, 1, false);
    }

    public u(Context context, int i, boolean z) {
        this.d = 1;
        this.jh = false;
        this.b = false;
        this.sy = false;
        this.de = true;
        this.c = -1;
        this.u = Integer.MIN_VALUE;
        this.an = null;
        this.h = new d();
        this.np = new hc();
        this.yi = 2;
        d(i);
        d(z);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.tt
    public RecyclerView.tc hc() {
        return new RecyclerView.tc(-2, -2);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.tt
    public void d(RecyclerView recyclerView, RecyclerView.cb cbVar) {
        super.d(recyclerView, cbVar);
        if (this.v) {
            b(cbVar);
            cbVar.d();
        }
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.tt
    public boolean b() {
        return this.d == 0;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.tt
    public boolean c() {
        return this.d == 1;
    }

    public void d(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException("invalid orientation:".concat(String.valueOf(i)));
        }
        d((String) null);
        if (i != this.d || this.hc == null) {
            gb gbVarD = gb.d(this, i);
            this.hc = gbVarD;
            this.h.d = gbVarD;
            this.d = i;
            uo();
        }
    }

    private void ba() {
        if (this.d != 1 && u()) {
            this.b = !this.jh;
        } else {
            this.b = this.jh;
        }
    }

    public void d(boolean z) {
        d((String) null);
        if (z != this.jh) {
            this.jh = z;
            uo();
        }
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.tt
    public View hc(int i) {
        int iRf = rf();
        if (iRf == 0) {
            return null;
        }
        int iC = i - c(gb(0));
        if (iC >= 0 && iC < iRf) {
            View viewGb = gb(iC);
            if (c(viewGb) == i) {
                return viewGb;
            }
        }
        return super.hc(i);
    }

    protected int d(RecyclerView.jh jhVar) {
        if (jhVar.b()) {
            return this.hc.an();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.tt
    public void d(RecyclerView recyclerView, RecyclerView.jh jhVar, int i) {
        an anVar = new an(recyclerView.getContext());
        anVar.b(i);
        d(anVar);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.rf.hc
    public PointF b(int i) {
        if (rf() == 0) {
            return null;
        }
        int i2 = (i < c(gb(0))) != this.b ? -1 : 1;
        return this.d == 0 ? new PointF(i2, 0.0f) : new PointF(0.0f, i2);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.tt
    public void d(RecyclerView.cb cbVar, RecyclerView.jh jhVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int iD;
        int i6;
        View viewHc;
        int iD2;
        int iC;
        if ((this.an != null || this.c != -1) && jhVar.c() == 0) {
            b(cbVar);
            return;
        }
        c cVar = this.an;
        if (cVar != null && cVar.d()) {
            this.c = this.an.d;
        }
        an();
        this.yo.d = false;
        ba();
        View viewZw = zw();
        if (this.h.u && this.c == -1 && this.an == null) {
            if (viewZw != null && (this.hc.d(viewZw) >= this.hc.c() || this.hc.hc(viewZw) <= this.hc.b())) {
                this.h.d(viewZw, c(viewZw));
            }
        } else {
            this.h.d();
            this.h.c = this.b ^ this.sy;
            d(cbVar, jhVar, this.h);
            this.h.u = true;
        }
        int iD3 = d(jhVar);
        if (this.yo.tc >= 0) {
            i = iD3;
            iD3 = 0;
        } else {
            i = 0;
        }
        int iB = iD3 + this.hc.b();
        int iH = i + this.hc.h();
        if (jhVar.d() && (i6 = this.c) != -1 && this.u != Integer.MIN_VALUE && (viewHc = hc(i6)) != null) {
            if (this.b) {
                iC = this.hc.c() - this.hc.hc(viewHc);
                iD2 = this.u;
            } else {
                iD2 = this.hc.d(viewHc) - this.hc.b();
                iC = this.u;
            }
            int i7 = iC - iD2;
            if (i7 > 0) {
                iB += i7;
            } else {
                iH -= i7;
            }
        }
        d(cbVar);
        this.yo.mq = gb();
        this.yo.tt = jhVar.d();
        if (this.h.c) {
            hc(this.h);
            this.yo.gb = iB;
            d(cbVar, this.yo, jhVar, false);
            i3 = this.yo.hc;
            int i8 = this.yo.c;
            if (this.yo.b > 0) {
                iH += this.yo.b;
            }
            d(this.h);
            this.yo.gb = iH;
            this.yo.c += this.yo.u;
            d(cbVar, this.yo, jhVar, false);
            i2 = this.yo.hc;
            if (this.yo.b > 0) {
                int i9 = this.yo.b;
                h(i8, i3);
                this.yo.gb = i9;
                d(cbVar, this.yo, jhVar, false);
                i3 = this.yo.hc;
            }
        } else {
            d(this.h);
            this.yo.gb = iH;
            d(cbVar, this.yo, jhVar, false);
            i2 = this.yo.hc;
            int i10 = this.yo.c;
            if (this.yo.b > 0) {
                iB += this.yo.b;
            }
            hc(this.h);
            this.yo.gb = iB;
            this.yo.c += this.yo.u;
            d(cbVar, this.yo, jhVar, false);
            i3 = this.yo.hc;
            if (this.yo.b > 0) {
                int i11 = this.yo.b;
                an(i10, i2);
                this.yo.gb = i11;
                d(cbVar, this.yo, jhVar, false);
                i2 = this.yo.hc;
            }
        }
        if (rf() > 0) {
            if (this.b ^ this.sy) {
                int iD4 = d(i2, cbVar, jhVar, true);
                i4 = i3 + iD4;
                i5 = i2 + iD4;
                iD = hc(i4, cbVar, jhVar, false);
            } else {
                int iHc = hc(i3, cbVar, jhVar, true);
                i4 = i3 + iHc;
                i5 = i2 + iHc;
                iD = d(i5, cbVar, jhVar, false);
            }
            i3 = i4 + iD;
            i2 = i5 + iD;
        }
        hc(cbVar, jhVar, i3, i2);
        if (!jhVar.d()) {
            this.hc.d();
        } else {
            this.h.d();
        }
        this.rf = this.sy;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.tt
    public void hc(RecyclerView.jh jhVar) {
        super.hc(jhVar);
        this.an = null;
        this.c = -1;
        this.u = Integer.MIN_VALUE;
        this.h.d();
    }

    private void hc(RecyclerView.cb cbVar, RecyclerView.jh jhVar, int i, int i2) {
        if (!jhVar.hc() || rf() == 0 || jhVar.d() || !mq()) {
            return;
        }
        List<RecyclerView.v> listB = cbVar.b();
        int size = listB.size();
        int iC = c(gb(0));
        int iU = 0;
        int iU2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            RecyclerView.v vVar = listB.get(i3);
            if (!vVar.w()) {
                if (((vVar.c() < iC) != this.b ? (char) 65535 : (char) 1) == 65535) {
                    iU += this.hc.u(vVar.d);
                } else {
                    iU2 += this.hc.u(vVar.d);
                }
            }
        }
        this.yo.mk = listB;
        if (iU > 0) {
            h(c(mt()), i);
            this.yo.gb = iU;
            this.yo.b = 0;
            this.yo.d();
            d(cbVar, this.yo, jhVar, false);
        }
        if (iU2 > 0) {
            an(c(r()), i2);
            this.yo.gb = iU2;
            this.yo.b = 0;
            this.yo.d();
            d(cbVar, this.yo, jhVar, false);
        }
        this.yo.mk = null;
    }

    private void d(RecyclerView.cb cbVar, RecyclerView.jh jhVar, d dVar) {
        if (d(jhVar, dVar) || hc(cbVar, jhVar, dVar)) {
            return;
        }
        dVar.hc();
        dVar.hc = this.sy ? jhVar.c() - 1 : 0;
    }

    private boolean hc(RecyclerView.cb cbVar, RecyclerView.jh jhVar, d dVar) {
        if (rf() == 0) {
            return false;
        }
        View viewZw = zw();
        if (viewZw != null && dVar.d(viewZw, jhVar)) {
            dVar.d(viewZw, c(viewZw));
            return true;
        }
        if (this.rf != this.sy) {
            return false;
        }
        View viewHc = dVar.c ? hc(cbVar, jhVar) : b(cbVar, jhVar);
        if (viewHc == null) {
            return false;
        }
        dVar.hc(viewHc, c(viewHc));
        if (!jhVar.d() && mq()) {
            if (this.hc.d(viewHc) >= this.hc.c() || this.hc.hc(viewHc) < this.hc.b()) {
                dVar.b = dVar.c ? this.hc.c() : this.hc.b();
            }
        }
        return true;
    }

    private boolean d(RecyclerView.jh jhVar, d dVar) {
        int i;
        if (!jhVar.d() && (i = this.c) != -1) {
            if (i >= 0 && i < jhVar.c()) {
                dVar.hc = this.c;
                c cVar = this.an;
                if (cVar != null && cVar.d()) {
                    dVar.c = this.an.b;
                    if (dVar.c) {
                        dVar.b = this.hc.c() - this.an.hc;
                    } else {
                        dVar.b = this.hc.b() + this.an.hc;
                    }
                    return true;
                }
                if (this.u == Integer.MIN_VALUE) {
                    View viewHc = hc(this.c);
                    if (viewHc != null) {
                        if (this.hc.u(viewHc) > this.hc.an()) {
                            dVar.hc();
                            return true;
                        }
                        if (this.hc.d(viewHc) - this.hc.b() < 0) {
                            dVar.b = this.hc.b();
                            dVar.c = false;
                            return true;
                        }
                        if (this.hc.c() - this.hc.hc(viewHc) < 0) {
                            dVar.b = this.hc.c();
                            dVar.c = true;
                            return true;
                        }
                        dVar.b = dVar.c ? this.hc.hc(viewHc) + this.hc.hc() : this.hc.d(viewHc);
                    } else {
                        if (rf() > 0) {
                            dVar.c = (this.c < c(gb(0))) == this.b;
                        }
                        dVar.hc();
                    }
                    return true;
                }
                dVar.c = this.b;
                if (this.b) {
                    dVar.b = this.hc.c() - this.u;
                } else {
                    dVar.b = this.hc.b() + this.u;
                }
                return true;
            }
            this.c = -1;
            this.u = Integer.MIN_VALUE;
        }
        return false;
    }

    private int d(int i, RecyclerView.cb cbVar, RecyclerView.jh jhVar, boolean z) {
        int iC;
        int iC2 = this.hc.c() - i;
        if (iC2 <= 0) {
            return 0;
        }
        int i2 = -b(-iC2, cbVar, jhVar);
        int i3 = i + i2;
        if (!z || (iC = this.hc.c() - i3) <= 0) {
            return i2;
        }
        this.hc.d(iC);
        return iC + i2;
    }

    private int hc(int i, RecyclerView.cb cbVar, RecyclerView.jh jhVar, boolean z) {
        int iB;
        int iB2 = i - this.hc.b();
        if (iB2 <= 0) {
            return 0;
        }
        int i2 = -b(iB2, cbVar, jhVar);
        int i3 = i + i2;
        if (!z || (iB = i3 - this.hc.b()) <= 0) {
            return i2;
        }
        this.hc.d(-iB);
        return i2 - iB;
    }

    private void d(d dVar) {
        an(dVar.hc, dVar.b);
    }

    private void an(int i, int i2) {
        this.yo.b = this.hc.c() - i2;
        this.yo.u = this.b ? -1 : 1;
        this.yo.c = i;
        this.yo.an = 1;
        this.yo.hc = i2;
        this.yo.h = Integer.MIN_VALUE;
    }

    private void hc(d dVar) {
        h(dVar.hc, dVar.b);
    }

    private void h(int i, int i2) {
        this.yo.b = i2 - this.hc.b();
        this.yo.c = i;
        this.yo.u = this.b ? 1 : -1;
        this.yo.an = -1;
        this.yo.hc = i2;
        this.yo.h = Integer.MIN_VALUE;
    }

    protected boolean u() {
        return w() == 1;
    }

    void an() {
        if (this.yo == null) {
            this.yo = h();
        }
    }

    b h() {
        return new b();
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.tt
    public void c(int i) {
        this.c = i;
        this.u = Integer.MIN_VALUE;
        c cVar = this.an;
        if (cVar != null) {
            cVar.hc();
        }
        uo();
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.tt
    public int d(int i, RecyclerView.cb cbVar, RecyclerView.jh jhVar) {
        if (this.d == 1) {
            return 0;
        }
        return b(i, cbVar, jhVar);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.tt
    public int hc(int i, RecyclerView.cb cbVar, RecyclerView.jh jhVar) {
        if (this.d == 0) {
            return 0;
        }
        return b(i, cbVar, jhVar);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.tt
    public int b(RecyclerView.jh jhVar) {
        return tt(jhVar);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.tt
    public int c(RecyclerView.jh jhVar) {
        return tt(jhVar);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.tt
    public int u(RecyclerView.jh jhVar) {
        return tc(jhVar);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.tt
    public int an(RecyclerView.jh jhVar) {
        return tc(jhVar);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.tt
    public int h(RecyclerView.jh jhVar) {
        return mk(jhVar);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.tt
    public int gb(RecyclerView.jh jhVar) {
        return mk(jhVar);
    }

    private int tt(RecyclerView.jh jhVar) {
        if (rf() == 0) {
            return 0;
        }
        an();
        return tc.d(jhVar, this.hc, d(!this.de, true), hc(!this.de, true), this, this.de, this.b);
    }

    private int tc(RecyclerView.jh jhVar) {
        if (rf() == 0) {
            return 0;
        }
        an();
        return tc.d(jhVar, this.hc, d(!this.de, true), hc(!this.de, true), this, this.de);
    }

    private int mk(RecyclerView.jh jhVar) {
        if (rf() == 0) {
            return 0;
        }
        an();
        return tc.hc(jhVar, this.hc, d(!this.de, true), hc(!this.de, true), this, this.de);
    }

    private void d(int i, int i2, boolean z, RecyclerView.jh jhVar) {
        int iB;
        this.yo.mq = gb();
        this.yo.gb = d(jhVar);
        this.yo.an = i;
        if (i == 1) {
            this.yo.gb += this.hc.h();
            View viewR = r();
            this.yo.u = this.b ? -1 : 1;
            this.yo.c = c(viewR) + this.yo.u;
            this.yo.hc = this.hc.hc(viewR);
            iB = this.hc.hc(viewR) - this.hc.c();
        } else {
            View viewMt = mt();
            this.yo.gb += this.hc.b();
            this.yo.u = this.b ? 1 : -1;
            this.yo.c = c(viewMt) + this.yo.u;
            this.yo.hc = this.hc.d(viewMt);
            iB = (-this.hc.d(viewMt)) + this.hc.b();
        }
        this.yo.b = i2;
        if (z) {
            this.yo.b -= iB;
        }
        this.yo.h = iB;
    }

    boolean gb() {
        return this.hc.gb() == 0 && this.hc.u() == 0;
    }

    void d(RecyclerView.jh jhVar, b bVar, RecyclerView.tt.d dVar) {
        int i = bVar.c;
        if (i < 0 || i >= jhVar.c()) {
            return;
        }
        dVar.hc(i, Math.max(0, bVar.h));
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.tt
    public void d(int i, RecyclerView.tt.d dVar) {
        boolean z;
        int i2;
        c cVar = this.an;
        if (cVar != null && cVar.d()) {
            z = this.an.b;
            i2 = this.an.d;
        } else {
            ba();
            z = this.b;
            i2 = this.c;
            if (i2 == -1) {
                i2 = z ? i - 1 : 0;
            }
        }
        int i3 = z ? -1 : 1;
        for (int i4 = 0; i4 < this.yi && i2 >= 0 && i2 < i; i4++) {
            dVar.hc(i2, 0);
            i2 += i3;
        }
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.tt
    public void d(int i, int i2, RecyclerView.jh jhVar, RecyclerView.tt.d dVar) {
        if (this.d != 0) {
            i = i2;
        }
        if (rf() == 0 || i == 0) {
            return;
        }
        an();
        d(i > 0 ? 1 : -1, Math.abs(i), true, jhVar);
        d(jhVar, this.yo, dVar);
    }

    int b(int i, RecyclerView.cb cbVar, RecyclerView.jh jhVar) {
        if (rf() == 0 || i == 0) {
            return 0;
        }
        this.yo.d = true;
        an();
        int i2 = i > 0 ? 1 : -1;
        int iAbs = Math.abs(i);
        d(i2, iAbs, true, jhVar);
        int iD = this.yo.h + d(cbVar, this.yo, jhVar, false);
        if (iD < 0) {
            return 0;
        }
        if (iAbs > iD) {
            i = i2 * iD;
        }
        this.hc.d(-i);
        this.yo.tc = i;
        return i;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.tt
    public void d(String str) {
        if (this.an == null) {
            super.d(str);
        }
    }

    private void d(RecyclerView.cb cbVar, int i, int i2) {
        if (i != i2) {
            if (i2 <= i) {
                while (i > i2) {
                    d(i, cbVar);
                    i--;
                }
            } else {
                for (int i3 = i2 - 1; i3 >= i; i3--) {
                    d(i3, cbVar);
                }
            }
        }
    }

    private void d(RecyclerView.cb cbVar, int i) {
        if (i >= 0) {
            int iRf = rf();
            if (!this.b) {
                for (int i2 = 0; i2 < iRf; i2++) {
                    View viewGb = gb(i2);
                    if (this.hc.hc(viewGb) > i || this.hc.b(viewGb) > i) {
                        d(cbVar, 0, i2);
                        return;
                    }
                }
                return;
            }
            int i3 = iRf - 1;
            for (int i4 = i3; i4 >= 0; i4--) {
                View viewGb2 = gb(i4);
                if (this.hc.hc(viewGb2) > i || this.hc.b(viewGb2) > i) {
                    d(cbVar, i3, i4);
                    return;
                }
            }
        }
    }

    private void hc(RecyclerView.cb cbVar, int i) {
        int iRf = rf();
        if (i >= 0) {
            int iU = this.hc.u() - i;
            if (this.b) {
                for (int i2 = 0; i2 < iRf; i2++) {
                    View viewGb = gb(i2);
                    if (this.hc.d(viewGb) < iU || this.hc.c(viewGb) < iU) {
                        d(cbVar, 0, i2);
                        return;
                    }
                }
                return;
            }
            int i3 = iRf - 1;
            for (int i4 = i3; i4 >= 0; i4--) {
                View viewGb2 = gb(i4);
                if (this.hc.d(viewGb2) < iU || this.hc.c(viewGb2) < iU) {
                    d(cbVar, i3, i4);
                    return;
                }
            }
        }
    }

    private void d(RecyclerView.cb cbVar, b bVar) {
        if (!bVar.d || bVar.mq) {
            return;
        }
        if (bVar.an == -1) {
            hc(cbVar, bVar.h);
        } else {
            d(cbVar, bVar.h);
        }
    }

    int d(RecyclerView.cb cbVar, b bVar, RecyclerView.jh jhVar, boolean z) {
        int i = bVar.b;
        if (bVar.h != Integer.MIN_VALUE) {
            if (bVar.b < 0) {
                bVar.h += bVar.b;
            }
            d(cbVar, bVar);
        }
        int i2 = bVar.b + bVar.gb;
        hc hcVar = this.np;
        while (true) {
            if ((!bVar.mq && i2 <= 0) || !bVar.d(jhVar)) {
                break;
            }
            hcVar.d();
            d(cbVar, jhVar, bVar, hcVar);
            if (!hcVar.hc) {
                bVar.hc += hcVar.d * bVar.an;
                if (!hcVar.b || this.yo.mk != null || !jhVar.d()) {
                    bVar.b -= hcVar.d;
                    i2 -= hcVar.d;
                }
                if (bVar.h != Integer.MIN_VALUE) {
                    bVar.h += hcVar.d;
                    if (bVar.b < 0) {
                        bVar.h += bVar.b;
                    }
                    d(cbVar, bVar);
                }
                if (z && hcVar.c) {
                    break;
                }
            } else {
                break;
            }
        }
        return i - bVar.b;
    }

    void d(RecyclerView.cb cbVar, RecyclerView.jh jhVar, b bVar, hc hcVar) {
        int i;
        int i2;
        int i3;
        int iNp;
        int iAn;
        View viewD = bVar.d(cbVar);
        if (viewD == null) {
            hcVar.hc = true;
            return;
        }
        RecyclerView.tc tcVar = (RecyclerView.tc) viewD.getLayoutParams();
        if (bVar.mk == null) {
            if (this.b == (bVar.an == -1)) {
                hc(viewD);
            } else {
                hc(viewD, 0);
            }
        } else {
            if (this.b == (bVar.an == -1)) {
                d(viewD);
            } else {
                d(viewD, 0);
            }
        }
        d(viewD, 0, 0);
        hcVar.d = this.hc.u(viewD);
        if (this.d == 1) {
            if (u()) {
                iAn = de() - he();
                iNp = iAn - this.hc.an(viewD);
            } else {
                iNp = np();
                iAn = this.hc.an(viewD) + iNp;
            }
            if (bVar.an == -1) {
                int i4 = bVar.hc;
                i2 = bVar.hc - hcVar.d;
                i = iAn;
                i3 = i4;
            } else {
                int i5 = bVar.hc;
                i3 = bVar.hc + hcVar.d;
                i = iAn;
                i2 = i5;
            }
        } else {
            int iYi = yi();
            int iAn2 = this.hc.an(viewD) + iYi;
            if (bVar.an == -1) {
                i2 = iYi;
                i = bVar.hc;
                i3 = iAn2;
                iNp = bVar.hc - hcVar.d;
            } else {
                int i6 = bVar.hc;
                i = bVar.hc + hcVar.d;
                i2 = iYi;
                i3 = iAn2;
                iNp = i6;
            }
        }
        d(viewD, iNp, i2, i, i3);
        if (tcVar.hc() || tcVar.b()) {
            hcVar.b = true;
        }
        hcVar.c = viewD.hasFocusable();
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.tt
    boolean tt() {
        return (sy() == 1073741824 || jh() == 1073741824 || !fs()) ? false : true;
    }

    int u(int i) {
        return i != 1 ? i != 2 ? i != 17 ? i != 33 ? i != 66 ? (i == 130 && this.d == 1) ? 1 : Integer.MIN_VALUE : this.d == 0 ? 1 : Integer.MIN_VALUE : this.d == 1 ? -1 : Integer.MIN_VALUE : this.d == 0 ? -1 : Integer.MIN_VALUE : (this.d != 1 && u()) ? -1 : 1 : (this.d != 1 && u()) ? 1 : -1;
    }

    private View mt() {
        return gb(this.b ? rf() - 1 : 0);
    }

    private View r() {
        return gb(this.b ? 0 : rf() - 1);
    }

    private View d(boolean z, boolean z2) {
        int iRf;
        int iRf2;
        if (this.b) {
            iRf = rf() - 1;
            iRf2 = -1;
        } else {
            iRf = 0;
            iRf2 = rf();
        }
        return d(iRf, iRf2, z, z2);
    }

    private View hc(boolean z, boolean z2) {
        int iRf;
        int iRf2;
        if (this.b) {
            iRf = 0;
            iRf2 = rf();
        } else {
            iRf = rf() - 1;
            iRf2 = -1;
        }
        return d(iRf, iRf2, z, z2);
    }

    private View hc(RecyclerView.cb cbVar, RecyclerView.jh jhVar) {
        return this.b ? c(cbVar, jhVar) : u(cbVar, jhVar);
    }

    private View b(RecyclerView.cb cbVar, RecyclerView.jh jhVar) {
        return this.b ? u(cbVar, jhVar) : c(cbVar, jhVar);
    }

    private View c(RecyclerView.cb cbVar, RecyclerView.jh jhVar) {
        return d(cbVar, jhVar, 0, rf(), jhVar.c());
    }

    private View u(RecyclerView.cb cbVar, RecyclerView.jh jhVar) {
        return d(cbVar, jhVar, rf() - 1, -1, jhVar.c());
    }

    View d(RecyclerView.cb cbVar, RecyclerView.jh jhVar, int i, int i2, int i3) {
        an();
        int iB = this.hc.b();
        int iC = this.hc.c();
        int i4 = i2 > i ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i != i2) {
            View viewGb = gb(i);
            int iC2 = c(viewGb);
            if (iC2 >= 0 && iC2 < i3) {
                if (((RecyclerView.tc) viewGb.getLayoutParams()).hc()) {
                    if (view2 == null) {
                        view2 = viewGb;
                    }
                } else {
                    if (this.hc.d(viewGb) < iC && this.hc.hc(viewGb) >= iB) {
                        return viewGb;
                    }
                    if (view == null) {
                        view = viewGb;
                    }
                }
            }
            i += i4;
        }
        return view != null ? view : view2;
    }

    private View an(RecyclerView.cb cbVar, RecyclerView.jh jhVar) {
        return this.b ? gb(cbVar, jhVar) : tt(cbVar, jhVar);
    }

    private View h(RecyclerView.cb cbVar, RecyclerView.jh jhVar) {
        return this.b ? tt(cbVar, jhVar) : gb(cbVar, jhVar);
    }

    private View gb(RecyclerView.cb cbVar, RecyclerView.jh jhVar) {
        return d(0, rf());
    }

    private View tt(RecyclerView.cb cbVar, RecyclerView.jh jhVar) {
        return d(rf() - 1, -1);
    }

    public int tc() {
        View viewD = d(0, rf(), false, true);
        if (viewD == null) {
            return -1;
        }
        return c(viewD);
    }

    public int mk() {
        View viewD = d(rf() - 1, -1, false, true);
        if (viewD == null) {
            return -1;
        }
        return c(viewD);
    }

    View d(int i, int i2, boolean z, boolean z2) {
        an();
        return (this.d == 0 ? this.tc : this.mk).d(i, i2, z ? 24579 : 320, z2 ? 320 : 0);
    }

    View d(int i, int i2) {
        int i3;
        int i4;
        an();
        if ((i2 > i ? (char) 1 : i2 < i ? (char) 65535 : (char) 0) == 0) {
            return gb(i);
        }
        if (this.hc.d(gb(i)) < this.hc.b()) {
            i3 = 16644;
            i4 = 16388;
        } else {
            i3 = 4161;
            i4 = FragmentTransaction.TRANSIT_FRAGMENT_OPEN;
        }
        return (this.d == 0 ? this.tc : this.mk).d(i, i2, i3, i4);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.tt
    public View d(View view, int i, RecyclerView.cb cbVar, RecyclerView.jh jhVar) {
        int iU;
        View viewAn;
        View viewR;
        ba();
        if (rf() == 0 || (iU = u(i)) == Integer.MIN_VALUE) {
            return null;
        }
        an();
        an();
        d(iU, (int) (this.hc.an() * 0.33333334f), false, jhVar);
        this.yo.h = Integer.MIN_VALUE;
        this.yo.d = false;
        d(cbVar, this.yo, jhVar, true);
        if (iU == -1) {
            viewAn = h(cbVar, jhVar);
        } else {
            viewAn = an(cbVar, jhVar);
        }
        if (iU == -1) {
            viewR = mt();
        } else {
            viewR = r();
        }
        if (!viewR.hasFocusable()) {
            return viewAn;
        }
        if (viewAn == null) {
            return null;
        }
        return viewR;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.tt
    public boolean mq() {
        return this.an == null && this.rf == this.sy;
    }

    protected static class hc {
        public boolean b;
        public boolean c;
        public int d;
        public boolean hc;

        protected hc() {
        }

        void d() {
            this.d = 0;
            this.hc = false;
            this.b = false;
            this.c = false;
        }
    }

    static class d {
        int b;
        boolean c;
        gb d;
        int hc;
        boolean u;

        d() {
            d();
        }

        void d() {
            this.hc = -1;
            this.b = Integer.MIN_VALUE;
            this.c = false;
            this.u = false;
        }

        void hc() {
            this.b = this.c ? this.d.c() : this.d.b();
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.hc + ", mCoordinate=" + this.b + ", mLayoutFromEnd=" + this.c + ", mValid=" + this.u + '}';
        }

        boolean d(View view, RecyclerView.jh jhVar) {
            RecyclerView.tc tcVar = (RecyclerView.tc) view.getLayoutParams();
            return !tcVar.hc() && tcVar.c() >= 0 && tcVar.c() < jhVar.c();
        }

        public void d(View view, int i) {
            int iHc = this.d.hc();
            if (iHc >= 0) {
                hc(view, i);
                return;
            }
            this.hc = i;
            if (this.c) {
                int iC = (this.d.c() - iHc) - this.d.hc(view);
                this.b = this.d.c() - iC;
                if (iC > 0) {
                    int iU = this.b - this.d.u(view);
                    int iB = this.d.b();
                    int iMin = iU - (iB + Math.min(this.d.d(view) - iB, 0));
                    if (iMin < 0) {
                        this.b += Math.min(iC, -iMin);
                        return;
                    }
                    return;
                }
                return;
            }
            int iD = this.d.d(view);
            int iB2 = iD - this.d.b();
            this.b = iD;
            if (iB2 > 0) {
                int iC2 = (this.d.c() - Math.min(0, (this.d.c() - iHc) - this.d.hc(view))) - (iD + this.d.u(view));
                if (iC2 < 0) {
                    this.b -= Math.min(iB2, -iC2);
                }
            }
        }

        public void hc(View view, int i) {
            if (this.c) {
                this.b = this.d.hc(view) + this.d.hc();
            } else {
                this.b = this.d.d(view);
            }
            this.hc = i;
        }
    }

    public static class c implements Parcelable {
        public static final Parcelable.Creator<c> CREATOR = new Parcelable.Creator<c>() { // from class: com.bytedance.sdk.component.widget.recycler.u.c.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: d, reason: merged with bridge method [inline-methods] */
            public c createFromParcel(Parcel parcel) {
                return new c(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: d, reason: merged with bridge method [inline-methods] */
            public c[] newArray(int i) {
                return new c[i];
            }
        };
        boolean b;
        int d;
        int hc;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public c() {
        }

        c(Parcel parcel) {
            this.d = parcel.readInt();
            this.hc = parcel.readInt();
            this.b = parcel.readInt() == 1;
        }

        boolean d() {
            return this.d >= 0;
        }

        void hc() {
            this.d = -1;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.d);
            parcel.writeInt(this.hc);
            parcel.writeInt(this.b ? 1 : 0);
        }
    }

    static class b {
        int an;
        int b;
        int c;
        int h;
        int hc;
        boolean mq;
        int tc;
        int u;
        boolean d = true;
        int gb = 0;
        boolean tt = false;
        List<RecyclerView.v> mk = null;

        b() {
        }

        boolean d(RecyclerView.jh jhVar) {
            int i = this.c;
            return i >= 0 && i < jhVar.c();
        }

        View d(RecyclerView.cb cbVar) {
            if (this.mk != null) {
                return hc();
            }
            View viewHc = cbVar.hc(this.c);
            this.c += this.u;
            return viewHc;
        }

        private View hc() {
            int size = this.mk.size();
            for (int i = 0; i < size; i++) {
                View view = this.mk.get(i).d;
                RecyclerView.tc tcVar = (RecyclerView.tc) view.getLayoutParams();
                if (!tcVar.hc() && this.c == tcVar.c()) {
                    d(view);
                    return view;
                }
            }
            return null;
        }

        public void d() {
            d((View) null);
        }

        public void d(View view) {
            View viewHc = hc(view);
            if (viewHc == null) {
                this.c = -1;
            } else {
                this.c = ((RecyclerView.tc) viewHc.getLayoutParams()).c();
            }
        }

        public View hc(View view) {
            int iC;
            int size = this.mk.size();
            View view2 = null;
            int i = Integer.MAX_VALUE;
            for (int i2 = 0; i2 < size; i2++) {
                View view3 = this.mk.get(i2).d;
                RecyclerView.tc tcVar = (RecyclerView.tc) view3.getLayoutParams();
                if (view3 != view && !tcVar.hc() && (iC = (tcVar.c() - this.c) * this.u) >= 0 && iC < i) {
                    view2 = view3;
                    if (iC == 0) {
                        break;
                    }
                    i = iC;
                }
            }
            return view2;
        }
    }
}
