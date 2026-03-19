package com.kwad.sdk.message;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.ad;
import android.support.v7.widget.aj;
import android.util.DisplayMetrics;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class LiveMessageLinearLayoutManager extends LinearLayoutManager {
    private float MILLISECONDS_PER_INCH;
    private Context mContext;

    public LiveMessageLinearLayoutManager(Context context) {
        super(context);
        this.MILLISECONDS_PER_INCH = 0.03f;
        this.mContext = context;
        setSpeedSlow();
    }

    @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.aj.i
    public void smoothScrollToPosition(aj ajVar, aj.u uVar, int i) {
        ad adVar = new ad(ajVar.getContext()) { // from class: com.kwad.sdk.message.LiveMessageLinearLayoutManager.1
            @Override // android.support.v7.widget.ad
            public int calculateDtToFit(int i2, int i3, int i4, int i5, int i6) {
                return i4 - i2;
            }

            @Override // android.support.v7.widget.aj.t
            public PointF computeScrollVectorForPosition(int i2) {
                return LiveMessageLinearLayoutManager.this.computeScrollVectorForPosition(i2);
            }

            @Override // android.support.v7.widget.ad
            public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                return LiveMessageLinearLayoutManager.this.MILLISECONDS_PER_INCH / displayMetrics.density;
            }
        };
        adVar.setTargetPosition(i);
        startSmoothScroll(adVar);
    }

    public void setSpeedSlow() {
        this.MILLISECONDS_PER_INCH = this.mContext.getResources().getDisplayMetrics().density * 0.3f;
    }

    public void setSpeedFast() {
        this.MILLISECONDS_PER_INCH = this.mContext.getResources().getDisplayMetrics().density * 0.03f;
    }
}
