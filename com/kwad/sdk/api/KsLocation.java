package com.kwad.sdk.api;

import com.kwad.sdk.api.core.KsAdSdkApi;

@KsAdSdkApi
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class KsLocation {
    private double mLatitude;
    private double mLongitude;
    private double mAltitude = 0.0d;
    private float mSpeed = 0.0f;
    private float mBearing = 0.0f;

    public KsLocation(double d, double d2) {
        this.mLatitude = d;
        this.mLongitude = d2;
    }

    public double getLatitude() {
        return this.mLatitude;
    }

    public void setLatitude(double d) {
        this.mLatitude = d;
    }

    public double getLongitude() {
        return this.mLongitude;
    }

    public void setLongitude(double d) {
        this.mLongitude = d;
    }

    public double getAltitude() {
        return this.mAltitude;
    }

    public void setAltitude(double d) {
        this.mAltitude = d;
    }

    public float getSpeed() {
        return this.mSpeed;
    }

    public void setSpeed(float f) {
        this.mSpeed = f;
    }

    public float getBearing() {
        return this.mBearing;
    }

    public void setBearing(float f) {
        this.mBearing = f;
    }
}
