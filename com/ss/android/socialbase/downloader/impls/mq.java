package com.ss.android.socialbase.downloader.impls;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class mq {
    private static volatile com.ss.android.socialbase.downloader.downloader.e d;
    private static volatile com.ss.android.socialbase.downloader.downloader.e hc;

    public static com.ss.android.socialbase.downloader.downloader.e d(boolean z) {
        if (z && com.ss.android.socialbase.downloader.downloader.b.ru()) {
            if (hc == null) {
                synchronized (mq.class) {
                    if (hc == null) {
                        hc = com.ss.android.socialbase.downloader.downloader.b.yn().hc();
                    }
                }
            }
            return hc;
        }
        if (d == null) {
            synchronized (mq.class) {
                if (d == null) {
                    d = new cb();
                }
            }
        }
        return d;
    }
}
