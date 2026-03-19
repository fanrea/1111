package com.bytedance.sdk.component.widget.recycler;

import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class mq extends RecyclerView.mq {
    private final RecyclerView.k b = new RecyclerView.k() { // from class: com.bytedance.sdk.component.widget.recycler.mq.1
        boolean d = false;

        @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.k
        public void d(RecyclerView recyclerView, int i) {
            super.d(recyclerView, i);
            if (i == 0 && this.d) {
                this.d = false;
                mq.this.d();
            }
        }

        @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.k
        public void d(RecyclerView recyclerView, int i, int i2) {
            if (i == 0 && i2 == 0) {
                return;
            }
            this.d = true;
        }
    };
    RecyclerView d;
    private Scroller hc;

    public abstract int d(RecyclerView.tt ttVar, int i, int i2);

    public abstract View d(RecyclerView.tt ttVar);

    public abstract int[] d(RecyclerView.tt ttVar, View view);

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.mq
    public boolean d(int i, int i2) {
        RecyclerView.tt layoutManager = this.d.getLayoutManager();
        if (layoutManager == null || this.d.getAdapter() == null) {
            return false;
        }
        int minFlingVelocity = this.d.getMinFlingVelocity();
        return (Math.abs(i2) > minFlingVelocity || Math.abs(i) > minFlingVelocity) && hc(layoutManager, i, i2);
    }

    public void d(RecyclerView recyclerView) throws IllegalStateException {
        RecyclerView recyclerView2 = this.d;
        if (recyclerView2 != recyclerView) {
            if (recyclerView2 != null) {
                b();
            }
            this.d = recyclerView;
            if (recyclerView != null) {
                hc();
                this.hc = new Scroller(this.d.getContext(), new DecelerateInterpolator());
                d();
            }
        }
    }

    private void hc() throws IllegalStateException {
        if (this.d.getOnFlingListener() != null) {
            throw new IllegalStateException("An instance of OnFlingListener already set.");
        }
        this.d.d(this.b);
        this.d.setOnFlingListener(this);
    }

    private void b() {
        this.d.hc(this.b);
        this.d.setOnFlingListener(null);
    }

    private boolean hc(RecyclerView.tt ttVar, int i, int i2) {
        RecyclerView.rf rfVarB;
        int iD;
        if (!(ttVar instanceof RecyclerView.rf.hc) || (rfVarB = b(ttVar)) == null || (iD = d(ttVar, i, i2)) == -1) {
            return false;
        }
        rfVarB.b(iD);
        ttVar.d(rfVarB);
        return true;
    }

    void d() {
        RecyclerView.tt layoutManager;
        View viewD;
        RecyclerView recyclerView = this.d;
        if (recyclerView == null || (layoutManager = recyclerView.getLayoutManager()) == null || (viewD = d(layoutManager)) == null) {
            return;
        }
        int[] iArrD = d(layoutManager, viewD);
        int i = iArrD[0];
        if (i == 0 && iArrD[1] == 0) {
            return;
        }
        this.d.d(i, iArrD[1]);
    }

    protected RecyclerView.rf b(RecyclerView.tt ttVar) {
        return hc(ttVar);
    }

    @Deprecated
    protected an hc(RecyclerView.tt ttVar) {
        if (ttVar instanceof RecyclerView.rf.hc) {
            return new an(this.d.getContext()) { // from class: com.bytedance.sdk.component.widget.recycler.mq.2
                @Override // com.bytedance.sdk.component.widget.recycler.an, com.bytedance.sdk.component.widget.recycler.RecyclerView.rf
                protected void d(View view, RecyclerView.jh jhVar, RecyclerView.rf.d dVar) {
                    if (mq.this.d != null) {
                        mq mqVar = mq.this;
                        int[] iArrD = mqVar.d(mqVar.d.getLayoutManager(), view);
                        int i = iArrD[0];
                        int i2 = iArrD[1];
                        int iD = d(Math.max(Math.abs(i), Math.abs(i2)));
                        if (iD > 0) {
                            dVar.update(i, i2, iD, this.hc);
                        }
                    }
                }

                @Override // com.bytedance.sdk.component.widget.recycler.an
                protected float d(DisplayMetrics displayMetrics) {
                    return 100.0f / displayMetrics.densityDpi;
                }
            };
        }
        return null;
    }
}
