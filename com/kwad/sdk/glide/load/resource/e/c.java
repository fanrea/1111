package com.kwad.sdk.glide.load.resource.e;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.kwad.sdk.glide.load.engine.s;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class c implements e<Drawable, byte[]> {
    private final com.kwad.sdk.glide.load.engine.bitmap_recycle.e bPy;
    private final e<Bitmap, byte[]> bYx;
    private final e<com.kwad.sdk.glide.load.resource.d.c, byte[]> bYy;

    /* JADX WARN: Multi-variable type inference failed */
    private static s<com.kwad.sdk.glide.load.resource.d.c> k(s<Drawable> sVar) {
        return sVar;
    }

    public c(com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar, e<Bitmap, byte[]> eVar2, e<com.kwad.sdk.glide.load.resource.d.c, byte[]> eVar3) {
        this.bPy = eVar;
        this.bYx = eVar2;
        this.bYy = eVar3;
    }

    @Override // com.kwad.sdk.glide.load.resource.e.e
    public final s<byte[]> a(s<Drawable> sVar, com.kwad.sdk.glide.load.f fVar) {
        Drawable drawable = sVar.get();
        if (drawable instanceof BitmapDrawable) {
            return this.bYx.a(com.kwad.sdk.glide.load.resource.bitmap.d.a(((BitmapDrawable) drawable).getBitmap(), this.bPy), fVar);
        }
        if (drawable instanceof com.kwad.sdk.glide.load.resource.d.c) {
            return this.bYy.a(k(sVar), fVar);
        }
        return null;
    }
}
