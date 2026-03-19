package com.ss.texturerender.effect.vr.director.sensordirector;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class TimeFilter {
    private static final double FILTER_COEFF = 0.949999988079071d;
    private static final int MIN_TIME_SAMPLE = 10;
    private double mFilteredTime;
    private int mSampleCount;
    private boolean mIsInit = false;
    private boolean isFilterValid = false;

    public void addSample(double d) {
        if (!this.mIsInit) {
            this.mFilteredTime = d;
            this.mIsInit = true;
            this.mSampleCount = 1;
        } else {
            this.mFilteredTime = (this.mFilteredTime * FILTER_COEFF) + (d * 0.050000011920928955d);
            int i = this.mSampleCount + 1;
            this.mSampleCount = i;
            if (i > 10) {
                this.isFilterValid = true;
            }
        }
    }

    public double getFilteredTime() {
        return this.mFilteredTime;
    }

    public boolean isFilterValid() {
        return this.isFilterValid;
    }
}
