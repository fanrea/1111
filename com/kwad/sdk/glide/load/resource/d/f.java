package com.kwad.sdk.glide.load.resource.d;

import android.content.Context;
import android.graphics.Bitmap;
import com.kwad.sdk.glide.load.engine.s;
import com.kwad.sdk.utils.ax;
import java.security.MessageDigest;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class f implements com.kwad.sdk.glide.load.i<c> {
    private final com.kwad.sdk.glide.load.i<Bitmap> bXB;

    public f(com.kwad.sdk.glide.load.i<Bitmap> iVar) {
        this.bXB = (com.kwad.sdk.glide.load.i) ax.checkNotNull(iVar);
    }

    @Override // com.kwad.sdk.glide.load.i
    public final s<c> transform(Context context, s<c> sVar, int i, int i2) {
        c cVar = sVar.get();
        s<Bitmap> dVar = new com.kwad.sdk.glide.load.resource.bitmap.d(cVar.ahZ(), com.kwad.sdk.glide.c.cv(context).aeZ());
        s<Bitmap> sVarTransform = this.bXB.transform(context, dVar, i, i2);
        if (!dVar.equals(sVarTransform)) {
            dVar.recycle();
        }
        cVar.a(this.bXB, sVarTransform.get());
        return sVar;
    }

    @Override // com.kwad.sdk.glide.load.c
    public final boolean equals(Object obj) {
        if (obj instanceof f) {
            return this.bXB.equals(((f) obj).bXB);
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
