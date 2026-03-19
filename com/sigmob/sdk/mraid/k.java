package com.sigmob.sdk.mraid;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public enum k {
    PORTRAIT(1),
    LANDSCAPE(0),
    NONE(-1);

    private final int d;

    k(final int activityInfoOrientation) {
        this.d = activityInfoOrientation;
    }

    public int a() {
        return this.d;
    }
}
