package com.kwad.sdk.glide.webp.decoder;

import android.graphics.Bitmap;
import com.kwad.sdk.glide.load.engine.s;
import java.nio.ByteBuffer;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class c implements com.kwad.sdk.glide.load.g<ByteBuffer, Bitmap> {
    private final j caF;

    public c(j jVar) {
        this.caF = jVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.glide.load.g
    public boolean a(ByteBuffer byteBuffer, com.kwad.sdk.glide.load.f fVar) {
        return j.a(byteBuffer, fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.glide.load.g
    public s<Bitmap> a(ByteBuffer byteBuffer, int i, int i2, com.kwad.sdk.glide.load.f fVar) {
        return this.caF.a(com.kwad.sdk.glide.e.a.h(byteBuffer), i, i2, fVar);
    }
}
