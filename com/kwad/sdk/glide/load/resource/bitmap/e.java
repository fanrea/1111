package com.kwad.sdk.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public abstract class e implements com.kwad.sdk.glide.load.i<Bitmap> {
    protected abstract Bitmap transform(com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar, Bitmap bitmap, int i, int i2);

    @Override // com.kwad.sdk.glide.load.i
    public final com.kwad.sdk.glide.load.engine.s<Bitmap> transform(Context context, com.kwad.sdk.glide.load.engine.s<Bitmap> sVar, int i, int i2) {
        if (!com.kwad.sdk.glide.e.j.Y(i, i2)) {
            throw new IllegalArgumentException("Cannot apply transformation on width: " + i + " or height: " + i2 + " less than or equal to zero and not Target.SIZE_ORIGINAL");
        }
        com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVarAeZ = com.kwad.sdk.glide.c.cv(context).aeZ();
        Bitmap bitmap = sVar.get();
        if (i == Integer.MIN_VALUE) {
            i = bitmap.getWidth();
        }
        if (i2 == Integer.MIN_VALUE) {
            i2 = bitmap.getHeight();
        }
        Bitmap bitmapTransform = transform(eVarAeZ, bitmap, i, i2);
        return bitmap.equals(bitmapTransform) ? sVar : d.a(bitmapTransform, eVarAeZ);
    }
}
