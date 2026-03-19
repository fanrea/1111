package com.kwad.sdk.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import java.security.MessageDigest;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class m implements com.kwad.sdk.glide.load.i<Drawable> {
    private final com.kwad.sdk.glide.load.i<Bitmap> bXB;
    private final boolean bXC;

    public final com.kwad.sdk.glide.load.i<BitmapDrawable> ahO() {
        return this;
    }

    public m(com.kwad.sdk.glide.load.i<Bitmap> iVar, boolean z) {
        this.bXB = iVar;
        this.bXC = z;
    }

    @Override // com.kwad.sdk.glide.load.i
    public final com.kwad.sdk.glide.load.engine.s<Drawable> transform(Context context, com.kwad.sdk.glide.load.engine.s<Drawable> sVar, int i, int i2) {
        com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVarAeZ = com.kwad.sdk.glide.c.cv(context).aeZ();
        Drawable drawable = sVar.get();
        com.kwad.sdk.glide.load.engine.s<Bitmap> sVarA = l.a(eVarAeZ, drawable, i, i2);
        if (sVarA == null) {
            if (this.bXC) {
                throw new IllegalArgumentException("Unable to convert " + drawable + " to a Bitmap");
            }
            return sVar;
        }
        com.kwad.sdk.glide.load.engine.s<Bitmap> sVarTransform = this.bXB.transform(context, sVarA, i, i2);
        if (sVarTransform.equals(sVarA)) {
            sVarTransform.recycle();
            return sVar;
        }
        return a(context, sVarTransform);
    }

    private static com.kwad.sdk.glide.load.engine.s<Drawable> a(Context context, com.kwad.sdk.glide.load.engine.s<Bitmap> sVar) {
        return r.a(context.getResources(), sVar);
    }

    @Override // com.kwad.sdk.glide.load.c
    public final boolean equals(Object obj) {
        if (obj instanceof m) {
            return this.bXB.equals(((m) obj).bXB);
        }
        return false;
    }

    @Override // com.kwad.sdk.glide.load.c
    public final int hashCode() {
        return this.bXB.hashCode();
    }

    @Override // com.kwad.sdk.glide.load.c
    public final void updateDiskCacheKey(MessageDigest messageDigest) {
        this.bXB.updateDiskCacheKey(messageDigest);
    }
}
