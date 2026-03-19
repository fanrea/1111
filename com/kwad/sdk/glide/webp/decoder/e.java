package com.kwad.sdk.glide.webp.decoder;

import android.graphics.Bitmap;
import com.kwad.sdk.glide.load.engine.s;
import java.io.InputStream;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class e implements com.kwad.sdk.glide.load.g<InputStream, Bitmap> {
    private final a caE;

    public e(a aVar) {
        this.caE = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.glide.load.g
    public boolean a(InputStream inputStream, com.kwad.sdk.glide.load.f fVar) {
        return this.caE.a(inputStream, fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.glide.load.g
    public s<Bitmap> a(InputStream inputStream, int i, int i2, com.kwad.sdk.glide.load.f fVar) {
        return this.caE.a(inputStream, i, i2, fVar);
    }
}
