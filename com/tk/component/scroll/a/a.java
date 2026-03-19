package com.tk.component.scroll.a;

import android.os.SystemClock;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class a {
    private int VQ = Integer.MIN_VALUE;
    private int VR = Integer.MIN_VALUE;
    private long VS = -11;

    public final boolean aO(int i, int i2) {
        long jUptimeMillis = SystemClock.uptimeMillis();
        boolean z = (jUptimeMillis - this.VS <= 10 && this.VQ == i && this.VR == i2) ? false : true;
        this.VS = jUptimeMillis;
        this.VQ = i;
        this.VR = i2;
        return z;
    }
}
