package com.ss.android.socialbase.downloader.tt;

import android.net.TrafficStats;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class hc {
    public static volatile boolean d = false;
    private static volatile hc gb = null;
    private static long h = -1;
    private static final String hc = "hc";
    private long an;
    private final mq b = mq.d();
    private final AtomicInteger c = new AtomicInteger();
    private final d u = new d(com.ss.android.socialbase.downloader.k.u.d());

    public static hc d() {
        if (gb == null) {
            synchronized (hc.class) {
                if (gb == null) {
                    gb = new hc();
                }
            }
        }
        return gb;
    }

    private hc() {
    }

    public void hc() {
        try {
            com.ss.android.socialbase.downloader.an.d.b(hc, "startSampling: mSamplingCounter = " + this.c);
            if (this.c.getAndIncrement() == 0) {
                this.u.d();
                this.an = SystemClock.uptimeMillis();
            }
        } catch (Throwable unused) {
        }
    }

    public void b() {
        try {
            com.ss.android.socialbase.downloader.an.d.b(hc, "stopSampling: mSamplingCounter = " + this.c);
            if (this.c.decrementAndGet() == 0) {
                this.u.hc();
                h();
            }
        } catch (Throwable unused) {
        }
    }

    public static long c() {
        return TrafficStats.getTotalRxBytes() - TrafficStats.getMobileRxBytes();
    }

    public static void u() {
        d = com.ss.android.socialbase.downloader.e.an.hc(com.ss.android.socialbase.downloader.downloader.b.tr());
    }

    protected void an() {
        long mobileRxBytes;
        try {
            u();
            if (d) {
                mobileRxBytes = c();
            } else {
                mobileRxBytes = TrafficStats.getMobileRxBytes();
            }
            long j = h;
            long j2 = mobileRxBytes - j;
            if (j >= 0) {
                synchronized (this) {
                    long jUptimeMillis = SystemClock.uptimeMillis();
                    this.b.d(j2, jUptimeMillis - this.an);
                    this.an = jUptimeMillis;
                }
            }
            h = mobileRxBytes;
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.mq.d(e);
        }
    }

    protected void h() {
        an();
        h = -1L;
    }

    private class d extends Handler {
        public d(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                return;
            }
            hc.this.an();
            sendEmptyMessageDelayed(1, 1000L);
        }

        public void d() {
            sendEmptyMessage(1);
        }

        public void hc() {
            removeMessages(1);
        }
    }
}
