package com.kwad.framework.filedownloader;

import android.os.SystemClock;
import com.kwad.framework.filedownloader.s;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b implements s.a, s.b {
    private int anV;
    private long bcK;
    private long bcL;
    private long bcM;
    private int bcN = 1000;
    private long mStartTime;

    @Override // com.kwad.framework.filedownloader.s.b
    public final void start(long j) {
        this.mStartTime = SystemClock.uptimeMillis();
        this.bcM = j;
    }

    @Override // com.kwad.framework.filedownloader.s.b
    public final void end(long j) {
        if (this.mStartTime <= 0) {
            return;
        }
        long j2 = j - this.bcM;
        this.bcK = 0L;
        long jUptimeMillis = SystemClock.uptimeMillis() - this.mStartTime;
        if (jUptimeMillis <= 0) {
            this.anV = (int) j2;
        } else {
            this.anV = (int) (j2 / jUptimeMillis);
        }
    }

    @Override // com.kwad.framework.filedownloader.s.b
    public final void as(long j) {
        if (this.bcN <= 0) {
            return;
        }
        boolean z = true;
        if (this.bcK != 0) {
            long jUptimeMillis = SystemClock.uptimeMillis() - this.bcK;
            if (jUptimeMillis >= this.bcN || (this.anV == 0 && jUptimeMillis > 0)) {
                int i = (int) ((j - this.bcL) / jUptimeMillis);
                this.anV = i;
                this.anV = Math.max(0, i);
            } else {
                z = false;
            }
        }
        if (z) {
            this.bcL = j;
            this.bcK = SystemClock.uptimeMillis();
        }
    }

    @Override // com.kwad.framework.filedownloader.s.b
    public final void reset() {
        this.anV = 0;
        this.bcK = 0L;
    }

    @Override // com.kwad.framework.filedownloader.s.a
    public final int getSpeed() {
        return this.anV;
    }
}
