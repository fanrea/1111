package com.kwad.sdk.glide.webp.decoder;

import android.content.Context;
import android.graphics.Bitmap;
import com.kwad.sdk.glide.load.engine.s;
import com.kwad.sdk.utils.ax;
import java.security.MessageDigest;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class n implements com.kwad.sdk.glide.load.i<k> {
    private final com.kwad.sdk.glide.load.i<Bitmap> bXB;

    public n(com.kwad.sdk.glide.load.i<Bitmap> iVar) {
        this.bXB = (com.kwad.sdk.glide.load.i) ax.checkNotNull(iVar);
    }

    @Override // com.kwad.sdk.glide.load.i
    public final s<k> transform(Context context, s<k> sVar, int i, int i2) {
        k kVar = sVar.get();
        s<Bitmap> dVar = new com.kwad.sdk.glide.load.resource.bitmap.d(kVar.ahZ(), com.kwad.sdk.glide.c.cv(context).aeZ());
        s<Bitmap> sVarTransform = this.bXB.transform(context, dVar, i, i2);
        if (!dVar.equals(sVarTransform)) {
            dVar.recycle();
        }
        kVar.a(this.bXB, sVarTransform.get());
        return sVar;
    }

    @Override // com.kwad.sdk.glide.load.c
    public final boolean equals(Object obj) {
        if (obj instanceof n) {
            return this.bXB.equals(((n) obj).bXB);
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
