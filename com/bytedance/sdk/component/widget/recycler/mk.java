package com.bytedance.sdk.component.widget.recycler;

import android.view.View;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class mk extends RecyclerView.an {
    boolean gb = true;

    public abstract boolean d(RecyclerView.v vVar);

    public abstract boolean d(RecyclerView.v vVar, int i, int i2, int i3, int i4);

    public abstract boolean d(RecyclerView.v vVar, RecyclerView.v vVar2, int i, int i2, int i3, int i4);

    public abstract boolean hc(RecyclerView.v vVar);

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.an
    public boolean h(RecyclerView.v vVar) {
        return !this.gb || vVar.k();
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.an
    public boolean d(RecyclerView.v vVar, RecyclerView.an.hc hcVar, RecyclerView.an.hc hcVar2) {
        int i = hcVar.d;
        int i2 = hcVar.hc;
        View view = vVar.d;
        int left = hcVar2 == null ? view.getLeft() : hcVar2.d;
        int top = hcVar2 == null ? view.getTop() : hcVar2.hc;
        if (vVar.w() || (i == left && i2 == top)) {
            return d(vVar);
        }
        view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
        return d(vVar, i, i2, left, top);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.an
    public boolean hc(RecyclerView.v vVar, RecyclerView.an.hc hcVar, RecyclerView.an.hc hcVar2) {
        return (hcVar == null || (hcVar.d == hcVar2.d && hcVar.hc == hcVar2.hc)) ? hc(vVar) : d(vVar, hcVar.d, hcVar.hc, hcVar2.d, hcVar2.hc);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.an
    public boolean b(RecyclerView.v vVar, RecyclerView.an.hc hcVar, RecyclerView.an.hc hcVar2) {
        if (hcVar.d == hcVar2.d && hcVar.hc == hcVar2.hc) {
            tt(vVar);
            return false;
        }
        return d(vVar, hcVar.d, hcVar.hc, hcVar2.d, hcVar2.hc);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.an
    public boolean d(RecyclerView.v vVar, RecyclerView.v vVar2, RecyclerView.an.hc hcVar, RecyclerView.an.hc hcVar2) {
        int i;
        int i2;
        int i3 = hcVar.d;
        int i4 = hcVar.hc;
        if (vVar2.L_()) {
            int i5 = hcVar.d;
            i2 = hcVar.hc;
            i = i5;
        } else {
            i = hcVar2.d;
            i2 = hcVar2.hc;
        }
        return d(vVar, vVar2, i3, i4, i, i2);
    }

    public final void gb(RecyclerView.v vVar) {
        an(vVar);
    }

    public final void tt(RecyclerView.v vVar) {
        an(vVar);
    }

    public final void tc(RecyclerView.v vVar) {
        an(vVar);
    }

    public final void d(RecyclerView.v vVar, boolean z) {
        an(vVar);
    }
}
