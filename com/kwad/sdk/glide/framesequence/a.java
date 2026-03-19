package com.kwad.sdk.glide.framesequence;

import com.kwad.sdk.glide.load.ImageHeaderParser;
import com.kwad.sdk.glide.load.engine.s;
import com.kwad.sdk.glide.webp.WebpHeaderParser;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class a implements com.kwad.sdk.glide.load.g<ByteBuffer, FrameSequence> {
    public static final com.kwad.sdk.glide.load.e<Boolean> bQE = com.kwad.sdk.glide.load.e.c("com.kwad.sdk.glide.framesequence.ByteBufferFsDecoder.DisableAnimation", Boolean.FALSE);
    public static final com.kwad.sdk.glide.load.e<Boolean> bQF = com.kwad.sdk.glide.load.e.c("com.kwad.sdk.glide.framesequence.framesequence.ByteBufferFsDecoder.DisableWebp", Boolean.FALSE);
    private final List<ImageHeaderParser> bQG;

    @Override // com.kwad.sdk.glide.load.g
    public final /* bridge */ /* synthetic */ s<FrameSequence> a(ByteBuffer byteBuffer, int i, int i2, com.kwad.sdk.glide.load.f fVar) {
        return a(byteBuffer);
    }

    public a(List<ImageHeaderParser> list) {
        this.bQG = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.glide.load.g
    public boolean a(ByteBuffer byteBuffer, com.kwad.sdk.glide.load.f fVar) {
        if (((Boolean) fVar.a(bQE)).booleanValue()) {
            return false;
        }
        byteBuffer.mark();
        ImageHeaderParser.ImageType imageTypeA = com.kwad.sdk.glide.load.b.a(this.bQG, byteBuffer);
        byteBuffer.reset();
        if (imageTypeA == ImageHeaderParser.ImageType.GIF) {
            return true;
        }
        if (((Boolean) fVar.a(bQF)).booleanValue() || !(imageTypeA == ImageHeaderParser.ImageType.WEBP || imageTypeA == ImageHeaderParser.ImageType.WEBP_A)) {
            return false;
        }
        return WebpHeaderParser.c(WebpHeaderParser.j(byteBuffer));
    }

    private static s<FrameSequence> a(ByteBuffer byteBuffer) {
        int iRemaining = byteBuffer.remaining();
        byte[] bArr = new byte[iRemaining];
        byteBuffer.get(bArr, 0, iRemaining);
        FrameSequence frameSequenceDecodeByteArray = FrameSequence.decodeByteArray(bArr);
        if (frameSequenceDecodeByteArray == null) {
            return null;
        }
        return new b(frameSequenceDecodeByteArray);
    }
}
