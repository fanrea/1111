package com.bytedance.d.hc.gb;

import android.app.ActivityManager;
import android.os.Build;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class h {
    static final d d;

    private static class d {
        public long d(ActivityManager.MemoryInfo memoryInfo) {
            return 0L;
        }

        private d() {
        }
    }

    private static class hc extends d {
        private hc() {
            super();
        }

        @Override // com.bytedance.d.hc.gb.h.d
        public long d(ActivityManager.MemoryInfo memoryInfo) {
            return memoryInfo.totalMem;
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 16) {
            d = new hc();
        } else {
            d = new d();
        }
    }

    public static long d(ActivityManager.MemoryInfo memoryInfo) {
        return d.d(memoryInfo);
    }
}
