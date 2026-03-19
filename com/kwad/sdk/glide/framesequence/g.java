package com.kwad.sdk.glide.framesequence;

import com.kwad.sdk.glide.load.ImageHeaderParser;
import com.kwad.sdk.glide.load.engine.s;
import com.kwad.sdk.glide.webp.WebpHeaderParser;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class g implements com.kwad.sdk.glide.load.g<InputStream, FrameSequence> {
    public static final com.kwad.sdk.glide.load.e<Boolean> bQE = com.kwad.sdk.glide.load.e.c("com.kwad.sdk.glide.framesequence.StreamFsDecoder.DisableAnimation", Boolean.FALSE);
    public static final com.kwad.sdk.glide.load.e<Boolean> bQF = com.kwad.sdk.glide.load.e.c("com.kwad.sdk.glide.framesequence.StreamFsDecoder.DisableWebp", Boolean.FALSE);
    private final List<ImageHeaderParser> bQG;
    private final com.kwad.sdk.glide.load.engine.bitmap_recycle.b bQO;

    @Override // com.kwad.sdk.glide.load.g
    public final /* synthetic */ s<FrameSequence> a(InputStream inputStream, int i, int i2, com.kwad.sdk.glide.load.f fVar) {
        return f(inputStream);
    }

    public g(List<ImageHeaderParser> list, com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar) {
        this.bQG = list;
        this.bQO = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.glide.load.g
    public boolean a(InputStream inputStream, com.kwad.sdk.glide.load.f fVar) throws IOException {
        if (((Boolean) fVar.a(bQE)).booleanValue()) {
            return false;
        }
        ImageHeaderParser.ImageType imageTypeA = com.kwad.sdk.glide.load.b.a(this.bQG, inputStream, this.bQO);
        if (imageTypeA == ImageHeaderParser.ImageType.GIF) {
            return true;
        }
        if (((Boolean) fVar.a(bQF)).booleanValue() || !(imageTypeA == ImageHeaderParser.ImageType.WEBP || imageTypeA == ImageHeaderParser.ImageType.WEBP_A)) {
            return false;
        }
        return WebpHeaderParser.c(WebpHeaderParser.b(inputStream, this.bQO));
    }

    private static s<FrameSequence> f(InputStream inputStream) {
        FrameSequence frameSequenceDecodeStream = FrameSequence.decodeStream(inputStream);
        if (frameSequenceDecodeStream == null) {
            return null;
        }
        return new b(frameSequenceDecodeStream);
    }
}
