package com.kwad.lottie.e;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class d {
    private final float bpZ;
    private final float bqa;

    public d(float f, float f2) {
        this.bpZ = f;
        this.bqa = f2;
    }

    public d() {
        this(1.0f, 1.0f);
    }

    public final float getScaleX() {
        return this.bpZ;
    }

    public final float getScaleY() {
        return this.bqa;
    }

    public final String toString() {
        return getScaleX() + "x" + getScaleY();
    }
}
