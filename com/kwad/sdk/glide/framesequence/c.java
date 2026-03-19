package com.kwad.sdk.glide.framesequence;

import android.graphics.Bitmap;
import com.kwad.sdk.glide.framesequence.FrameSequenceDrawable;
import com.kwad.sdk.glide.load.engine.s;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class c<DataType> implements com.kwad.sdk.glide.load.g<DataType, FrameSequenceDrawable> {
    private final com.kwad.sdk.glide.load.g<DataType, FrameSequence> bQJ;
    private final FrameSequenceDrawable.a bQK;

    public c(final com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar, com.kwad.sdk.glide.load.g<DataType, FrameSequence> gVar) {
        this.bQJ = gVar;
        this.bQK = new FrameSequenceDrawable.a() { // from class: com.kwad.sdk.glide.framesequence.c.1
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

    @Override // com.kwad.sdk.glide.load.g
    public final boolean a(DataType datatype, com.kwad.sdk.glide.load.f fVar) {
        return this.bQJ.a(datatype, fVar);
    }

    @Override // com.kwad.sdk.glide.load.g
    public final s<FrameSequenceDrawable> a(DataType datatype, int i, int i2, com.kwad.sdk.glide.load.f fVar) {
        s<FrameSequence> sVarA = this.bQJ.a(datatype, i, i2, fVar);
        if (sVarA == null) {
            return null;
        }
        return new d(new FrameSequenceDrawable(sVarA.get(), this.bQK));
    }
}
