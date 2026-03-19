package com.tachikoma.lottie.model.content;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class Mask {
    private final MaskMode LF;
    private final com.tachikoma.lottie.model.a.h LG;
    private final boolean LH;
    private final com.tachikoma.lottie.model.a.d Lj;

    public enum MaskMode {
        MASK_MODE_ADD,
        MASK_MODE_SUBTRACT,
        MASK_MODE_INTERSECT
    }

    public Mask(MaskMode maskMode, com.tachikoma.lottie.model.a.h hVar, com.tachikoma.lottie.model.a.d dVar, boolean z) {
        this.LF = maskMode;
        this.LG = hVar;
        this.Lj = dVar;
        this.LH = z;
    }

    public final MaskMode lc() {
        return this.LF;
    }

    public final com.tachikoma.lottie.model.a.h ld() {
        return this.LG;
    }

    public final com.tachikoma.lottie.model.a.d kJ() {
        return this.Lj;
    }

    public final boolean le() {
        return this.LH;
    }
}
