package com.kwad.sdk.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import java.security.MessageDigest;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class i extends e {
    private static final byte[] ID_BYTES = "com.kwad.sdk.glide.load.resource.bitmap.CircleCrop.1".getBytes(bRy);

    @Override // com.kwad.sdk.glide.load.c
    public int hashCode() {
        return 768609307;
    }

    @Override // com.kwad.sdk.glide.load.resource.bitmap.e
    protected Bitmap transform(com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar, Bitmap bitmap, int i, int i2) {
        return v.a(eVar, bitmap, i, i2);
    }

    @Override // com.kwad.sdk.glide.load.c
    public boolean equals(Object obj) {
        return obj instanceof i;
    }

    @Override // com.kwad.sdk.glide.load.c
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(ID_BYTES);
    }
}
