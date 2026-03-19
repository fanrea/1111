package com.kwad.sdk.glide.framesequence;

import android.graphics.Bitmap;
import com.kwad.sdk.glide.framesequence.FrameSequenceDrawable;
import com.kwad.sdk.glide.load.engine.s;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class e implements com.kwad.sdk.glide.load.resource.e.e<FrameSequence, FrameSequenceDrawable> {
    private final FrameSequenceDrawable.a bQK;

    public e(final com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar) {
        this.bQK = new FrameSequenceDrawable.a() { // from class: com.kwad.sdk.glide.framesequence.e.1
            @Override // com.kwad.sdk.glide.framesequence.FrameSequenceDrawable.a
            public final Bitmap P(int i, int i2) {
                return eVar.b(i, i2, Bitmap.Config.ARGB_8888);
            }

            @Override // com.kwad.sdk.glide.framesequence.FrameSequenceDrawable.a
            public final void c(Bitmap bitmap) {
                eVar.e(bitmap);
            }
        };
    }

    @Override // com.kwad.sdk.glide.load.resource.e.e
    public final s<FrameSequenceDrawable> a(s<FrameSequence> sVar, com.kwad.sdk.glide.load.f fVar) {
        return new d(new FrameSequenceDrawable(sVar.get(), this.bQK));
    }
}
