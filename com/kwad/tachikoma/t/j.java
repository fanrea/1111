package com.kwad.tachikoma.t;

import android.content.Context;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class j {
    public static float q(Context context) {
        if (context == null) {
            return 2.0f;
        }
        return context.getResources().getDisplayMetrics().density;
    }

    public static int b(Context context, float f) {
        return (int) (context == null ? f / 2.0f : (f / context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
