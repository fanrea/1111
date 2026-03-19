package com.alliance.ssp.ad.o0;

import android.app.Application;
import android.os.Build;
import android.os.SystemClock;
import java.util.HashMap;
import java.util.Map;

/* compiled from: DemoApplicationLifeCycle.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class g {
    public Application a;
    public long b = 0;
    public long c = a();
    public final Map<Integer, Long> d = new HashMap();

    /* compiled from: DemoApplicationLifeCycle.java */
    public interface a {
        void a(long j);
    }

    public static long a() {
        if (Build.VERSION.SDK_INT >= 17) {
            return SystemClock.elapsedRealtimeNanos() / 1000000;
        }
        return 0L;
    }
}
