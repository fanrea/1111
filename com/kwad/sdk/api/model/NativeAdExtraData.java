package com.kwad.sdk.api.model;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class NativeAdExtraData {
    private boolean enableRotate = true;
    private boolean enableShake;
    private int showLiveStatus;
    private int showLiveStyle;

    public NativeAdExtraData setEnableShake(boolean z) {
        this.enableShake = z;
        return this;
    }

    public NativeAdExtraData setEnableRotate(boolean z) {
        this.enableRotate = z;
        return this;
    }

    public boolean isEnableShake() {
        return this.enableShake;
    }

    public boolean isEnableRotate() {
        return this.enableRotate;
    }

    public NativeAdExtraData setShowLiveStatus(int i) {
        this.showLiveStatus = i;
        return this;
    }

    public int getShowLiveStatus() {
        return this.showLiveStatus;
    }

    public NativeAdExtraData setShowLiveStyle(int i) {
        this.showLiveStyle = i;
        return this;
    }

    public int getShowLiveStyle() {
        return this.showLiveStyle;
    }
}
