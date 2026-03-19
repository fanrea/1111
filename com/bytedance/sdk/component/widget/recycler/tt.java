package com.bytedance.sdk.component.widget.recycler;

import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class tt extends mq {
    private gb b;
    private gb hc;

    @Override // com.bytedance.sdk.component.widget.recycler.mq
    public int[] d(RecyclerView.tt ttVar, View view) {
        int[] iArr = new int[2];
        if (ttVar.b()) {
            iArr[0] = d(ttVar, view, u(ttVar));
        } else {
            iArr[0] = 0;
        }
        if (ttVar.c()) {
            iArr[1] = d(ttVar, view, c(ttVar));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.mq
    public View d(RecyclerView.tt ttVar) {
        if (ttVar.c()) {
            return d(ttVar, c(ttVar));
        }
        if (ttVar.b()) {
            return d(ttVar, u(ttVar));
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.sdk.component.widget.recycler.mq
    public int d(RecyclerView.tt ttVar, int i, int i2) {
        int iC;
        PointF pointFB;
        int iJ = ttVar.j();
        if (iJ == 0) {
            return -1;
        }
        View viewHc = null;
        if (ttVar.c()) {
            viewHc = hc(ttVar, c(ttVar));
        } else if (ttVar.b()) {
            viewHc = hc(ttVar, u(ttVar));
        }
        if (viewHc == null || (iC = ttVar.c(viewHc)) == -1) {
            return -1;
        }
        boolean z = false;
        boolean z2 = !ttVar.b() ? i2 <= 0 : i <= 0;
        if ((ttVar instanceof RecyclerView.rf.hc) && (pointFB = ((RecyclerView.rf.hc) ttVar).b(iJ - 1)) != null && (pointFB.x < 0.0f || pointFB.y < 0.0f)) {
            z = true;
        }
        return z ? z2 ? iC - 1 : iC : z2 ? iC + 1 : iC;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.mq
    protected an hc(RecyclerView.tt ttVar) {
        if (ttVar instanceof RecyclerView.rf.hc) {
            return new an(this.d.getContext()) { // from class: com.bytedance.sdk.component.widget.recycler.tt.1
                @Override // com.bytedance.sdk.component.widget.recycler.an, com.bytedance.sdk.component.widget.recycler.RecyclerView.rf
                protected void d(View view, RecyclerView.jh jhVar, RecyclerView.rf.d dVar) {
                    tt ttVar2 = tt.this;
                    int[] iArrD = ttVar2.d(ttVar2.d.getLayoutManager(), view);
                    int i = iArrD[0];
                    int i2 = iArrD[1];
                    int iD = d(Math.max(Math.abs(i), Math.abs(i2)));
                    if (iD > 0) {
                        dVar.update(i, i2, iD, this.hc);
                    }
                }

                @Override // com.bytedance.sdk.component.widget.recycler.an
                protected float d(DisplayMetrics displayMetrics) {
                    return 100.0f / displayMetrics.densityDpi;
                }

                @Override // com.bytedance.sdk.component.widget.recycler.an
                protected int hc(int i) {
                    return Math.min(100, super.hc(i));
                }
            };
        }
        return null;
    }

    private int d(RecyclerView.tt ttVar, View view, gb gbVar) {
        int iU;
        int iD = gbVar.d(view) + (gbVar.u(view) / 2);
        if (ttVar.e()) {
            iU = gbVar.b() + (gbVar.an() / 2);
        } else {
            iU = gbVar.u() / 2;
        }
        return iD - iU;
    }

    private View d(RecyclerView.tt ttVar, gb gbVar) {
        int iU;
        int iRf = ttVar.rf();
        View view = null;
        if (iRf == 0) {
            return null;
        }
        if (ttVar.e()) {
            iU = gbVar.b() + (gbVar.an() / 2);
        } else {
            iU = gbVar.u() / 2;
        }
        int i = Integer.MAX_VALUE;
        for (int i2 = 0; i2 < iRf; i2++) {
            View viewGb = ttVar.gb(i2);
            int iAbs = Math.abs((gbVar.d(viewGb) + (gbVar.u(viewGb) / 2)) - iU);
            if (iAbs < i) {
                view = viewGb;
                i = iAbs;
            }
        }
        return view;
    }

    private View hc(RecyclerView.tt ttVar, gb gbVar) {
        int iRf = ttVar.rf();
        View view = null;
        if (iRf == 0) {
            return null;
        }
        int i = Integer.MAX_VALUE;
        for (int i2 = 0; i2 < iRf; i2++) {
            View viewGb = ttVar.gb(i2);
            int iD = gbVar.d(viewGb);
            if (iD < i) {
                view = viewGb;
                i = iD;
            }
        }
        return view;
    }

    private gb c(RecyclerView.tt ttVar) {
        gb gbVar = this.hc;
        if (gbVar == null || gbVar.d != ttVar) {
            this.hc = gb.hc(ttVar);
        }
        return this.hc;
    }

    private gb u(RecyclerView.tt ttVar) {
        gb gbVar = this.b;
        if (gbVar == null || gbVar.d != ttVar) {
            this.b = gb.d(ttVar);
        }
        return this.b;
    }
}
