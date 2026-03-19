package com.kwad.sdk.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import java.nio.ByteBuffer;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class f implements com.kwad.sdk.glide.load.g<ByteBuffer, Bitmap> {
    private final k bXf;

    private boolean d(ByteBuffer byteBuffer) {
        return true;
    }

    @Override // com.kwad.sdk.glide.load.g
    public final /* synthetic */ boolean a(ByteBuffer byteBuffer, com.kwad.sdk.glide.load.f fVar) {
        return d(byteBuffer);
    }

    public f(k kVar) {
        this.bXf = kVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.glide.load.g
    public com.kwad.sdk.glide.load.engine.s<Bitmap> a(ByteBuffer byteBuffer, int i, int i2, com.kwad.sdk.glide.load.f fVar) {
        return this.bXf.a(com.kwad.sdk.glide.e.a.h(byteBuffer), i, i2, fVar);
    }
}
