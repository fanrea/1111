package com.kwad.components.core.video;

import android.os.SystemClock;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class l {
    private volatile boolean acW;
    private long acX;
    private a acY = new a();

    public static class a {
        private long acZ = 0;
        private int ada = 0;

        public final void accumulate(long j) {
            this.acZ += j;
            this.ada++;
        }

        public final int uG() {
            return this.ada;
        }

        public final long uH() {
            return this.acZ;
        }

        public final void reset() {
            this.acZ = 0L;
            this.ada = 0;
        }
    }

    public final void uB() {
        if (this.acW) {
            return;
        }
        this.acW = true;
        this.acX = SystemClock.elapsedRealtime();
        com.kwad.sdk.core.video.a.b.a.fV("videoStartBlock");
    }

    public final void uC() {
        if (this.acW) {
            long jElapsedRealtime = SystemClock.elapsedRealtime() - this.acX;
            this.acY.accumulate(jElapsedRealtime);
            this.acW = false;
            com.kwad.sdk.core.video.a.b.a.fV("videoEndBlock");
            com.kwad.sdk.core.video.a.b.a.fV("videoBlockTime_" + jElapsedRealtime);
        }
    }

    public final boolean uD() {
        return this.acW;
    }

    public final a uE() {
        if (this.acW) {
            this.acY.accumulate(SystemClock.elapsedRealtime() - this.acX);
            this.acW = false;
        }
        return this.acY;
    }

    public final long uF() {
        return this.acX;
    }

    public final void reset() {
        this.acW = false;
        this.acX = 0L;
        this.acY.reset();
    }
}
