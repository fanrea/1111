package com.kwad.lottie.model.content;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class Mask {
    private final MaskMode bnQ;
    private final com.kwad.lottie.model.a.h bnR;
    private final com.kwad.lottie.model.a.d bnx;

    public enum MaskMode {
        MaskModeAdd,
        MaskModeSubtract,
        MaskModeIntersect
    }

    public Mask(MaskMode maskMode, com.kwad.lottie.model.a.h hVar, com.kwad.lottie.model.a.d dVar) {
        this.bnQ = maskMode;
        this.bnR = hVar;
        this.bnx = dVar;
    }

    public final MaskMode RG() {
        return this.bnQ;
    }

    public final com.kwad.lottie.model.a.h RH() {
        return this.bnR;
    }

    public final com.kwad.lottie.model.a.d Rp() {
        return this.bnx;
    }
}
