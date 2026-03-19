package com.ss.texturerender.effect.vr.director.sensordirector;

import com.ss.texturerender.math.Vector3d;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class LowPassFilter {
    private static final double MAX_TIME_STEP = 1.0d;
    private static final double MIN_TIME_STEP = 0.001d;
    private static final double NANOS_TO_SECONDS = 1.0E-9d;
    private long mLastTimestampNs;
    private int mNumSamples;
    private final double mTimeConstantSecs;
    private final Vector3d filteredData = new Vector3d();
    private final Vector3d temp = new Vector3d();
    private boolean mIsInit = false;

    public LowPassFilter(double d) {
        this.mTimeConstantSecs = MAX_TIME_STEP / (d * 6.283185307179586d);
    }

    public int getNumSamples() {
        return this.mNumSamples;
    }

    public void addSample(Vector3d vector3d, long j) {
        addWeightedSample(vector3d, j, MAX_TIME_STEP);
    }

    public void addWeightedSample(Vector3d vector3d, long j, double d) {
        this.mNumSamples++;
        if (!this.mIsInit) {
            this.filteredData.set(vector3d);
            this.mLastTimestampNs = j;
            this.mIsInit = true;
            return;
        }
        if (j < this.mLastTimestampNs) {
            this.mLastTimestampNs = j;
            return;
        }
        double d2 = d * (j - r0) * NANOS_TO_SECONDS;
        if (d2 < MIN_TIME_STEP || d2 > MAX_TIME_STEP) {
            this.mLastTimestampNs = j;
            return;
        }
        double d3 = d2 / (this.mTimeConstantSecs + d2);
        this.filteredData.scale(MAX_TIME_STEP - d3);
        this.temp.set(vector3d);
        this.temp.scale(d3);
        Vector3d vector3d2 = this.temp;
        Vector3d vector3d3 = this.filteredData;
        Vector3d.add(vector3d2, vector3d3, vector3d3);
        this.mLastTimestampNs = j;
    }

    public long getRecentTime() {
        return this.mLastTimestampNs;
    }

    public boolean isIsInit() {
        return this.mIsInit;
    }

    public Vector3d getFilteredData() {
        return this.filteredData;
    }
}
