package com.kwad.sdk.glide.webp.decoder;

import com.kwad.sdk.glide.load.engine.s;
import com.kwad.sdk.glide.webp.WebpHeaderParser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class g implements com.kwad.sdk.glide.load.g<InputStream, k> {
    public static final com.kwad.sdk.glide.load.e<Boolean> bQE = com.kwad.sdk.glide.load.e.c("com.kwad.sdk.glide.webp.decoder.StreamWebpDecoder.DisableAnimation", Boolean.FALSE);
    private final com.kwad.sdk.glide.load.engine.bitmap_recycle.b bQO;
    private final com.kwad.sdk.glide.load.g<ByteBuffer, k> bYv;

    public g(com.kwad.sdk.glide.load.g<ByteBuffer, k> gVar, com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar) {
        this.bYv = gVar;
        this.bQO = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.glide.load.g
    public boolean a(InputStream inputStream, com.kwad.sdk.glide.load.f fVar) {
        if (((Boolean) fVar.a(bQE)).booleanValue()) {
            return false;
        }
        return WebpHeaderParser.c(WebpHeaderParser.b(inputStream, this.bQO));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.glide.load.g
    public s<k> a(InputStream inputStream, int i, int i2, com.kwad.sdk.glide.load.f fVar) throws IOException {
        byte[] bArrK = h.k(inputStream);
        if (bArrK == null) {
            return null;
        }
        return this.bYv.a(ByteBuffer.wrap(bArrK), i, i2, fVar);
    }
}
