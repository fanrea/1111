package com.kwad.components.ct.refreshview;

import android.os.Build;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class f {
    public static boolean isFullScreen() {
        return tv();
    }

    private static boolean tv() {
        return Build.VERSION.SDK_INT >= 23;
    }
}
