package com.kwad.sdk.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.kwad.sdk.utils.ax;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class d implements com.kwad.sdk.glide.load.engine.o, com.kwad.sdk.glide.load.engine.s<Bitmap> {
    private final com.kwad.sdk.glide.load.engine.bitmap_recycle.e bPy;
    private final Bitmap bkw;

    public static d a(Bitmap bitmap, com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar) {
        if (bitmap == null) {
            return null;
        }
        return new d(bitmap, eVar);
    }

    public d(Bitmap bitmap, com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar) {
        this.bkw = (Bitmap) ax.f(bitmap, "Bitmap must not be null");
        this.bPy = (com.kwad.sdk.glide.load.engine.bitmap_recycle.e) ax.f(eVar, "BitmapPool must not be null");
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    public final Class<Bitmap> afv() {
        return Bitmap.class;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.glide.load.engine.s
    /* renamed from: ahK, reason: merged with bridge method [inline-methods] */
    public Bitmap get() {
        return this.bkw;
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    public final int getSize() {
        return com.kwad.sdk.glide.e.j.m(this.bkw);
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    public final void recycle() {
        this.bPy.e(this.bkw);
    }

    @Override // com.kwad.sdk.glide.load.engine.o
    public final void initialize() {
        this.bkw.prepareToDraw();
    }
}
