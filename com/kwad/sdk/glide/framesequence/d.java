package com.kwad.sdk.glide.framesequence;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class d extends com.kwad.sdk.glide.load.resource.b.b<FrameSequenceDrawable> {
    public d(FrameSequenceDrawable frameSequenceDrawable) {
        super(frameSequenceDrawable);
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    public final Class<FrameSequenceDrawable> afv() {
        return FrameSequenceDrawable.class;
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    public final int getSize() {
        return ((FrameSequenceDrawable) this.bXV).getSize();
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    public final void recycle() {
        ((FrameSequenceDrawable) this.bXV).stop();
        ((FrameSequenceDrawable) this.bXV).destroy();
    }
}
