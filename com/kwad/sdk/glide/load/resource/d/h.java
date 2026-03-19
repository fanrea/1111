package com.kwad.sdk.glide.load.resource.d;

import android.graphics.Bitmap;
import com.kwad.sdk.glide.load.engine.s;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class h implements com.kwad.sdk.glide.load.g<com.kwad.sdk.glide.gifdecoder.a, Bitmap> {
    private final com.kwad.sdk.glide.load.engine.bitmap_recycle.e bPy;

    @Override // com.kwad.sdk.glide.load.g
    public final /* bridge */ /* synthetic */ boolean a(com.kwad.sdk.glide.gifdecoder.a aVar, com.kwad.sdk.glide.load.f fVar) {
        return true;
    }

    @Override // com.kwad.sdk.glide.load.g
    public final /* bridge */ /* synthetic */ s<Bitmap> a(com.kwad.sdk.glide.gifdecoder.a aVar, int i, int i2, com.kwad.sdk.glide.load.f fVar) {
        return a(aVar);
    }

    public h(com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar) {
        this.bPy = eVar;
    }

    private s<Bitmap> a(com.kwad.sdk.glide.gifdecoder.a aVar) {
        return com.kwad.sdk.glide.load.resource.bitmap.d.a(aVar.afA(), this.bPy);
    }
}
