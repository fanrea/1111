package com.kwad.sdk.utils;

import android.content.Context;
import android.os.Build;
import android.os.PowerManager;
import android.os.SystemClock;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class aw {
    private static volatile aw cmI = new aw();
    private volatile boolean cmJ;
    private volatile long cmK = 0;
    private volatile PowerManager cmL;

    public static aw apm() {
        return cmI;
    }

    public final boolean ed(Context context) {
        if (this.cmK > 0 && SystemClock.elapsedRealtime() - this.cmK < 600) {
            return this.cmJ;
        }
        boolean zIsScreenOn = false;
        if (this.cmL == null && context != null) {
            synchronized (this) {
                if (this.cmL == null) {
                    this.cmL = (PowerManager) context.getApplicationContext().getSystemService("power");
                }
            }
        }
        if (this.cmL != null) {
            if (Build.VERSION.SDK_INT >= 20) {
                zIsScreenOn = this.cmL.isInteractive();
            } else {
                zIsScreenOn = this.cmL.isScreenOn();
            }
        }
        this.cmJ = zIsScreenOn;
        this.cmK = SystemClock.elapsedRealtime();
        return this.cmJ;
    }
}
