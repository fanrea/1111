package com.qq.e.comm.plugin;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class gy extends u40<jy> {
    private final LinearLayoutManager l;

    @Override // com.qq.e.comm.plugin.v40
    protected void a() {
    }

    @Override // com.qq.e.comm.plugin.u40
    public ViewGroup.LayoutParams j() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    public gy(w40 w40Var, jy jyVar) {
        super(w40Var, jyVar);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(jyVar.getContext(), 0, false);
        this.l = linearLayoutManager;
        jyVar.setLayoutManager(linearLayoutManager);
    }

    void c(int i) {
        this.l.setOrientation(i);
    }

    int p() {
        return this.l.getOrientation();
    }

    int l() {
        return this.l.findFirstCompletelyVisibleItemPosition();
    }

    int n() {
        return this.l.findLastCompletelyVisibleItemPosition();
    }

    int m() {
        return this.l.findFirstVisibleItemPosition();
    }

    int o() {
        return this.l.findLastVisibleItemPosition();
    }

    @Override // com.qq.e.comm.plugin.u40
    protected void a(w40 w40Var, View view) {
        view.setLayoutParams(a(w40Var.w()));
    }

    @Override // com.qq.e.comm.plugin.v40
    public rk a(View view) {
        return new t8();
    }

    @Override // com.qq.e.comm.plugin.u40
    public ViewGroup.LayoutParams a(rk rkVar) {
        return new RecyclerView.LayoutParams((ViewGroup.MarginLayoutParams) new tq(rkVar));
    }

    int k() {
        boolean z = this.l.getOrientation() == 1;
        int height = (z ? ((jy) this.b).getHeight() : ((jy) this.b).getWidth()) / 2;
        int childCount = ((jy) this.b).getChildCount();
        int i = childCount / 2;
        while (i >= 0 && i < childCount) {
            View childAt = ((jy) this.b).getChildAt(i);
            ViewGroup.MarginLayoutParams marginLayoutParams = childAt.getLayoutParams() instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) childAt.getLayoutParams() : null;
            if (z) {
                int top = childAt.getTop();
                if (marginLayoutParams != null) {
                    top -= marginLayoutParams.topMargin;
                }
                if (top > height) {
                    i--;
                } else {
                    int bottom = childAt.getBottom();
                    if (marginLayoutParams != null) {
                        bottom += marginLayoutParams.bottomMargin;
                    }
                    if (bottom >= height) {
                        return i;
                    }
                    i++;
                }
            } else {
                int left = childAt.getLeft();
                if (marginLayoutParams != null) {
                    left -= marginLayoutParams.leftMargin;
                }
                if (left > height) {
                    i--;
                } else {
                    int right = childAt.getRight();
                    if (marginLayoutParams != null) {
                        right += marginLayoutParams.rightMargin;
                    }
                    if (right >= height) {
                        return i;
                    }
                    i++;
                }
            }
        }
        return -1;
    }
}
