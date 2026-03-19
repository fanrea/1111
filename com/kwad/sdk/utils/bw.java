package com.kwad.sdk.utils;

import android.os.SystemClock;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class bw {
    private long auN;
    private long auO;
    private boolean auP;

    public bw() {
        reset();
    }

    public final void startTiming() {
        reset();
        this.auP = true;
        this.auO = SystemClock.elapsedRealtime();
    }

    private void reset() {
        this.auN = 0L;
        this.auO = -1L;
    }

    public final void AG() {
        if (this.auP && this.auO < 0) {
            this.auO = SystemClock.elapsedRealtime();
        }
    }

    public final void AH() {
        if (this.auP && this.auO > 0) {
            this.auN += SystemClock.elapsedRealtime() - this.auO;
            this.auO = -1L;
        }
    }

    public final long aqq() {
        if (!this.auP) {
            return 0L;
        }
        this.auP = false;
        if (this.auO > 0) {
            this.auN += SystemClock.elapsedRealtime() - this.auO;
            this.auO = -1L;
        }
        return this.auN;
    }

    public final boolean AI() {
        return this.auP;
    }

    public final long getTime() {
        if (this.auO > 0) {
            return (this.auN + SystemClock.elapsedRealtime()) - this.auO;
        }
        return this.auN;
    }
}
