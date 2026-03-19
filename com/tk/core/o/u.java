package com.tk.core.o;

import android.content.res.Resources;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class u {
    private static final int aju = Resources.getSystem().getDisplayMetrics().widthPixels;

    public static int S(float f) {
        return (int) (f * (aju / 750.0f));
    }
}
