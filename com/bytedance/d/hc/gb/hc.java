package com.bytedance.d.hc.gb;

import android.os.Build;
import android.os.Debug;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc {
    static final d d;

    private static class d {
        public int b(Debug.MemoryInfo memoryInfo) {
            return -1;
        }

        public int d(Debug.MemoryInfo memoryInfo) {
            return -1;
        }

        public int hc(Debug.MemoryInfo memoryInfo) {
            return -1;
        }

        private d() {
        }
    }

    /* renamed from: com.bytedance.d.hc.gb.hc$hc, reason: collision with other inner class name */
    private static class C0188hc extends d {
        private C0188hc() {
            super();
        }

        @Override // com.bytedance.d.hc.gb.hc.d
        public int d(Debug.MemoryInfo memoryInfo) {
            return memoryInfo.getTotalPrivateClean();
        }

        @Override // com.bytedance.d.hc.gb.hc.d
        public int hc(Debug.MemoryInfo memoryInfo) {
            return memoryInfo.getTotalSharedClean();
        }

        @Override // com.bytedance.d.hc.gb.hc.d
        public int b(Debug.MemoryInfo memoryInfo) {
            return memoryInfo.getTotalSwappablePss();
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 19) {
            d = new C0188hc();
        } else {
            d = new d();
        }
    }

    public static int d(Debug.MemoryInfo memoryInfo) {
        return d.d(memoryInfo);
    }

    public static int hc(Debug.MemoryInfo memoryInfo) {
        return d.hc(memoryInfo);
    }

    public static int b(Debug.MemoryInfo memoryInfo) {
        return d.b(memoryInfo);
    }
}
