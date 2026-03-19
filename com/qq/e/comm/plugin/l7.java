package com.qq.e.comm.plugin;

import com.bykv.vk.component.ttvideo.ILivePlayer;
import java.lang.ref.WeakReference;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class l7 {
    private static WeakReference<mn> a;

    public static void c() {
        d();
        h2.a().post(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d() {
        mn mnVar = new mn(Thread.getDefaultUncaughtExceptionHandler());
        Thread.setDefaultUncaughtExceptionHandler(mnVar);
        a = new WeakReference<>(mnVar);
    }

    /* compiled from: A */
    private static class b implements Runnable {
        private long a;
        private long b;

        @Override // java.lang.Runnable
        public void run() {
            if (l7.a.get() == null) {
                l7.d();
            }
            if (this.b >= 0) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (jCurrentTimeMillis > this.b) {
                    long[] jArrG = g2.g();
                    int length = jArrG.length - 1;
                    int i = 0;
                    while (true) {
                        if (i > length) {
                            break;
                        }
                        if (i == length) {
                            this.b = -1L;
                            this.a = jArrG[length];
                            break;
                        }
                        long j = jArrG[i];
                        if (j > jCurrentTimeMillis) {
                            this.b = j;
                            this.a = jArrG[i + 1];
                            break;
                        }
                        i += 2;
                    }
                }
            }
            if (this.a <= 0) {
                this.a = ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;
                this.b = -1L;
            }
            h2.a().postDelayed(this, this.a);
        }

        private b() {
        }
    }
}
