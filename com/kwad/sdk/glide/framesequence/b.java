package com.kwad.sdk.glide.framesequence;

import com.kwad.sdk.glide.load.engine.s;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class b implements s<FrameSequence> {
    private final FrameSequence bQI;

    @Override // com.kwad.sdk.glide.load.engine.s
    public final void recycle() {
    }

    public b(FrameSequence frameSequence) {
        this.bQI = frameSequence;
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    public final Class<FrameSequence> afv() {
        return FrameSequence.class;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.glide.load.engine.s
    /* renamed from: afw, reason: merged with bridge method [inline-methods] */
    public FrameSequence get() {
        return this.bQI;
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    public final int getSize() {
        return this.bQI.getWidth() * this.bQI.getHeight() * 4;
    }
}
