package com.kwad.tachikoma.t;

import android.content.Context;
import android.support.v7.widget.al;
import android.view.View;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class e {
    public static int a(Context context, float f) {
        return (int) (context == null ? f * 2.0f : (f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static boolean b(al alVar, boolean z) {
        if (alVar.getChildCount() == 0) {
            return true;
        }
        View childAt = alVar.getChildAt(alVar.getChildCount() - 1);
        return (childAt.getBottom() <= alVar.getHeight() - alVar.getPaddingBottom()) && al.X(childAt) == alVar.getAdapter().getItemCount() - 1;
    }
}
