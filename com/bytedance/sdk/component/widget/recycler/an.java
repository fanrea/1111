package com.bytedance.sdk.component.widget.recycler;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class an extends RecyclerView.rf {
    private final float an;
    protected PointF b;
    protected final LinearInterpolator d = new LinearInterpolator();
    protected final DecelerateInterpolator hc = new DecelerateInterpolator();
    protected int c = 0;
    protected int u = 0;

    private int hc(int i, int i2) {
        int i3 = i - i2;
        if (i * i3 <= 0) {
            return 0;
        }
        return i3;
    }

    public an(Context context) {
        this.an = d(context.getResources().getDisplayMetrics());
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.rf
    protected void d(View view, RecyclerView.jh jhVar, RecyclerView.rf.d dVar) {
        int iHc = hc(view, hc());
        int iD = d(view, b());
        int iD2 = d((int) Math.sqrt((iHc * iHc) + (iD * iD)));
        if (iD2 > 0) {
            dVar.update(-iHc, -iD, iD2, this.hc);
        }
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.rf
    protected void d(int i, int i2, RecyclerView.jh jhVar, RecyclerView.rf.d dVar) {
        if (tt() == 0) {
            u();
            return;
        }
        this.c = hc(this.c, i);
        int iHc = hc(this.u, i2);
        this.u = iHc;
        if (this.c == 0 && iHc == 0) {
            d(dVar);
        }
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.rf
    protected void d() {
        this.u = 0;
        this.c = 0;
        this.b = null;
    }

    protected float d(DisplayMetrics displayMetrics) {
        return 25.0f / displayMetrics.densityDpi;
    }

    protected int d(int i) {
        return (int) Math.ceil(hc(i) / 0.3356d);
    }

    protected int hc(int i) {
        return (int) Math.ceil(Math.abs(i) * this.an);
    }

    protected int hc() {
        PointF pointF = this.b;
        if (pointF == null || pointF.x == 0.0f) {
            return 0;
        }
        return this.b.x > 0.0f ? 1 : -1;
    }

    protected int b() {
        PointF pointF = this.b;
        if (pointF == null || pointF.y == 0.0f) {
            return 0;
        }
        return this.b.y > 0.0f ? 1 : -1;
    }

    protected void d(RecyclerView.rf.d dVar) {
        PointF pointFC = c(gb());
        if (pointFC != null && (pointFC.x != 0.0f || pointFC.y != 0.0f)) {
            d(pointFC);
            this.b = pointFC;
            this.c = (int) (pointFC.x * 10000.0f);
            this.u = (int) (pointFC.y * 10000.0f);
            dVar.update((int) (this.c * 1.2f), (int) (this.u * 1.2f), (int) (hc(10000) * 1.2f), this.d);
            return;
        }
        dVar.d(gb());
        u();
    }

    public int d(int i, int i2, int i3, int i4, int i5) {
        if (i5 == -1) {
            return i3 - i;
        }
        if (i5 != 0) {
            if (i5 == 1) {
                return i4 - i2;
            }
            throw new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
        }
        int i6 = i3 - i;
        if (i6 > 0) {
            return i6;
        }
        int i7 = i4 - i2;
        if (i7 < 0) {
            return i7;
        }
        return 0;
    }

    public int d(View view, int i) {
        RecyclerView.tt ttVarC = c();
        if (ttVarC == null || !ttVarC.c()) {
            return 0;
        }
        RecyclerView.tc tcVar = (RecyclerView.tc) view.getLayoutParams();
        return d(ttVarC.gb(view) - tcVar.topMargin, ttVarC.tc(view) + tcVar.bottomMargin, ttVarC.yi(), ttVarC.v() - ttVarC.vv(), i);
    }

    public int hc(View view, int i) {
        RecyclerView.tt ttVarC = c();
        if (ttVarC == null || !ttVarC.b()) {
            return 0;
        }
        RecyclerView.tc tcVar = (RecyclerView.tc) view.getLayoutParams();
        return d(ttVarC.h(view) - tcVar.leftMargin, ttVarC.tt(view) + tcVar.rightMargin, ttVarC.np(), ttVarC.de() - ttVarC.he(), i);
    }
}
