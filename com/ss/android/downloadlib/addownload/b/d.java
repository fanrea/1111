package com.ss.android.downloadlib.addownload.b;

import com.ss.android.downloadlib.addownload.mq;
import com.ss.android.downloadlib.h.mk;
import com.ss.android.downloadlib.h.uo;
import com.ss.android.socialbase.downloader.c.rf;
import com.ss.android.socialbase.downloader.c.yo;
import com.ss.android.socialbase.downloader.downloader.h;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class d implements rf {
    private int d;

    public void d(int i) {
        this.d = i;
    }

    @Override // com.ss.android.socialbase.downloader.c.rf
    public boolean d(long j, long j2, yo yoVar) throws Throwable {
        long j3;
        com.ss.android.socialbase.downloader.uo.d dVarD = com.ss.android.socialbase.downloader.uo.d.d(this.d);
        if (!d(dVarD)) {
            return false;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        c.d().b();
        long jHc = uo.hc(0L);
        d();
        long jHc2 = uo.hc(0L);
        long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
        if (jHc2 < j2) {
            long jHc3 = hc(dVarD);
            if (jHc3 > 0) {
                jHc2 = uo.hc(0L);
            }
            j3 = jHc3;
        } else {
            j3 = 0;
        }
        mk.hc("AppDownloadDiskSpaceHandler", "cleanUpDisk, byteRequired = " + j2 + ", byteAvailableAfter = " + jHc2 + ", cleaned = " + (jHc2 - jHc), null);
        long j4 = jHc2;
        d(jHc, jHc2, j2, jCurrentTimeMillis2, j3);
        if (j4 < j2) {
            return false;
        }
        if (yoVar == null) {
            return true;
        }
        yoVar.d();
        return true;
    }

    private boolean d(com.ss.android.socialbase.downloader.uo.d dVar) {
        if (dVar.d("clear_space_use_disk_handler", 0) != 1) {
            return false;
        }
        return System.currentTimeMillis() - c.d().hc() >= dVar.d("clear_space_min_time_interval", 600000L);
    }

    private void d() throws Throwable {
        mq.cb();
        b.d();
        b.hc();
    }

    private long hc(com.ss.android.socialbase.downloader.uo.d dVar) throws InterruptedException {
        long jD = dVar.d("clear_space_sleep_time", 0L);
        if (jD <= 0) {
            return 0L;
        }
        if (jD > 5000) {
            jD = 5000;
        }
        mk.hc("AppDownloadDiskSpaceHandler", "waiting for space clear, sleepTime = ".concat(String.valueOf(jD)), null);
        try {
            Thread.sleep(jD);
        } catch (InterruptedException e) {
            com.bytedance.sdk.component.utils.mq.d(e);
        }
        mk.hc("AppDownloadDiskSpaceHandler", "waiting end!", null);
        return jD;
    }

    private void d(long j, long j2, long j3, long j4, long j5) {
        com.ss.android.socialbase.downloader.h.b bVarGb = h.hc(mq.getContext()).gb(this.d);
        if (bVarGb == null) {
            return;
        }
        try {
            com.ss.android.downloadlib.d.d().d(bVarGb, j, j2, j3, j4, j5, j2 > j3);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.mq.d(e);
        }
    }
}
