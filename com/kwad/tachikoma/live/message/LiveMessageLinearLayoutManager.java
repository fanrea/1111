package com.kwad.tachikoma.live.message;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.ad;
import android.support.v7.widget.al;
import android.util.DisplayMetrics;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public class LiveMessageLinearLayoutManager extends LinearLayoutManager {
    private float Do;
    private Context mContext;

    public LiveMessageLinearLayoutManager(Context context) {
        super(context);
        this.Do = 0.03f;
        this.mContext = context;
        it();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [android.support.v7.widget.ad, android.support.v7.widget.al$t, com.kwad.tachikoma.live.message.LiveMessageLinearLayoutManager$1] */
    public final void a(al alVar, al.u uVar, int i) {
        ?? r2 = new ad(alVar.getContext()) { // from class: com.kwad.tachikoma.live.message.LiveMessageLinearLayoutManager.1
            public final int c(int i2, int i3, int i4, int i5, int i6) {
                return i4 - i2;
            }

            public final PointF aq(int i2) {
                return LiveMessageLinearLayoutManager.this.aq(i2);
            }

            public final float a(DisplayMetrics displayMetrics) {
                return LiveMessageLinearLayoutManager.this.Do / displayMetrics.density;
            }
        };
        r2.aR(i);
        a((al.t) r2);
    }

    private void it() {
        this.Do = this.mContext.getResources().getDisplayMetrics().density * 0.3f;
    }
}
