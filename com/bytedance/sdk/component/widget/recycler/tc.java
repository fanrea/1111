package com.bytedance.sdk.component.widget.recycler;

import android.view.View;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class tc {
    static int d(RecyclerView.jh jhVar, gb gbVar, View view, View view2, RecyclerView.tt ttVar, boolean z, boolean z2) {
        if (ttVar.rf() == 0 || jhVar.c() == 0 || view == null || view2 == null) {
            return 0;
        }
        int iMax = z2 ? Math.max(0, (jhVar.c() - Math.max(ttVar.c(view), ttVar.c(view2))) - 1) : Math.max(0, Math.min(ttVar.c(view), ttVar.c(view2)));
        if (z) {
            return Math.round((iMax * (Math.abs(gbVar.hc(view2) - gbVar.d(view)) / (Math.abs(ttVar.c(view) - ttVar.c(view2)) + 1))) + (gbVar.b() - gbVar.d(view)));
        }
        return iMax;
    }

    static int d(RecyclerView.jh jhVar, gb gbVar, View view, View view2, RecyclerView.tt ttVar, boolean z) {
        if (ttVar.rf() == 0 || jhVar.c() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return Math.abs(ttVar.c(view) - ttVar.c(view2)) + 1;
        }
        return Math.min(gbVar.an(), gbVar.hc(view2) - gbVar.d(view));
    }

    static int hc(RecyclerView.jh jhVar, gb gbVar, View view, View view2, RecyclerView.tt ttVar, boolean z) {
        if (ttVar.rf() == 0 || jhVar.c() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return jhVar.c();
        }
        return (int) (((gbVar.hc(view2) - gbVar.d(view)) / (Math.abs(ttVar.c(view) - ttVar.c(view2)) + 1)) * jhVar.c());
    }
}
