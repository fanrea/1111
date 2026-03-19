package com.kwai.player.vr;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class FpsStatistic {
    private static final int FPS_CALCULATE_TIME_MS = 1000;
    private volatile boolean mFpsStar;
    private volatile long mFpsStartTimeMs;
    private volatile int mFpsCounter = 0;
    private volatile int mFps = -1;

    public void onFrame() {
        if (this.mFpsStar) {
            if (this.mFpsStartTimeMs <= 0) {
                this.mFpsStartTimeMs = System.currentTimeMillis();
            }
            int iCurrentTimeMillis = (int) (System.currentTimeMillis() - this.mFpsStartTimeMs);
            if (this.mFpsStartTimeMs <= 0 || iCurrentTimeMillis <= 0) {
                return;
            }
            this.mFpsCounter++;
            if (iCurrentTimeMillis > 1000) {
                this.mFps = this.mFpsCounter;
                resetFpsTimeAndCounter();
                return;
            }
            return;
        }
        resetFpsTimeAndCounter();
    }

    public void startFps() {
        this.mFpsStar = true;
    }

    public void stopFps() {
        this.mFpsStar = false;
        resetFpsTimeAndCounter();
    }

    public int getFps() {
        return this.mFps;
    }

    public void resetFps() {
        this.mFps = -1;
        resetFpsTimeAndCounter();
    }

    private void resetFpsTimeAndCounter() {
        this.mFpsStartTimeMs = 0L;
        this.mFpsCounter = 0;
    }
}
