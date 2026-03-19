package com.tachikoma.lottie.e;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class d {
    private float NW;
    private float NX;

    public d(float f, float f2) {
        this.NW = f;
        this.NX = f2;
    }

    public d() {
        this(1.0f, 1.0f);
    }

    public final float getScaleX() {
        return this.NW;
    }

    public final float getScaleY() {
        return this.NX;
    }

    public final void set(float f, float f2) {
        this.NW = f;
        this.NX = f2;
    }

    public final boolean equals(float f, float f2) {
        return this.NW == 1.0f && this.NX == 1.0f;
    }

    public final String toString() {
        return getScaleX() + "x" + getScaleY();
    }
}
