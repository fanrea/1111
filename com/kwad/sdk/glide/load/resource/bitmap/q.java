package com.kwad.sdk.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Log;
import java.io.File;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
final class q {
    private static final File bXF = new File("/proc/self/fd");
    private static volatile q bXI;
    private volatile int bXG;
    private volatile boolean bXH = true;

    static q ahP() {
        if (bXI == null) {
            synchronized (q.class) {
                if (bXI == null) {
                    bXI = new q();
                }
            }
        }
        return bXI;
    }

    private q() {
    }

    final boolean a(int i, int i2, BitmapFactory.Options options, boolean z, boolean z2) {
        if (!z || Build.VERSION.SDK_INT < 26 || z2) {
            return false;
        }
        boolean z3 = i >= 128 && i2 >= 128 && ahQ();
        if (z3) {
            options.inPreferredConfig = Bitmap.Config.HARDWARE;
            options.inMutable = false;
        }
        return z3;
    }

    private synchronized boolean ahQ() {
        boolean z = true;
        int i = this.bXG + 1;
        this.bXG = i;
        if (i >= 50) {
            this.bXG = 0;
            int length = bXF.list().length;
            if (length >= 700) {
                z = false;
            }
            this.bXH = z;
            if (!this.bXH && Log.isLoggable("Downsampler", 5)) {
                Log.w("Downsampler", "Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors " + length + ", limit 700");
            }
        }
        return this.bXH;
    }
}
