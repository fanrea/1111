package com.kwad.sdk.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import java.security.MessageDigest;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class g extends e {
    private static final byte[] ID_BYTES = "com.kwad.sdk.glide.load.resource.bitmap.CenterCrop".getBytes(bRy);

    @Override // com.kwad.sdk.glide.load.c
    public final int hashCode() {
        return 298221917;
    }

    @Override // com.kwad.sdk.glide.load.resource.bitmap.e
    protected final Bitmap transform(com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar, Bitmap bitmap, int i, int i2) {
        return v.b(eVar, bitmap, i, i2);
    }

    @Override // com.kwad.sdk.glide.load.c
    public final boolean equals(Object obj) {
        return obj instanceof g;
    }

    @Override // com.kwad.sdk.glide.load.c
    public final void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(ID_BYTES);
    }
}
