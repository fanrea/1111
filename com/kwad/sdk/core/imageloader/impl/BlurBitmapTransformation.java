package com.kwad.sdk.core.imageloader.impl;

import android.graphics.Bitmap;
import com.kwad.sdk.core.imageloader.utils.BlurUtils;
import com.kwad.sdk.glide.e.j;
import com.kwad.sdk.glide.load.resource.bitmap.e;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.MessageDigest;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class BlurBitmapTransformation extends e {
    private static final String ID = "com.kwad.sdk.core.imageloader.impl.BlurBitmapTransformation";
    private static final byte[] ID_BYTES = ID.getBytes(Charset.forName("UTF-8"));
    private final int mRadius;

    public BlurBitmapTransformation(int i) {
        this.mRadius = i;
    }

    @Override // com.kwad.sdk.glide.load.resource.bitmap.e
    public Bitmap transform(com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar, Bitmap bitmap, int i, int i2) {
        return BlurUtils.stackBlur(bitmap, this.mRadius, false);
    }

    @Override // com.kwad.sdk.glide.load.c
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(ID_BYTES);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.mRadius).array());
    }

    @Override // com.kwad.sdk.glide.load.c
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.mRadius == ((BlurBitmapTransformation) obj).mRadius;
    }

    @Override // com.kwad.sdk.glide.load.c
    public int hashCode() {
        return j.hashCode(j.hashCode(-844489340), this.mRadius);
    }
}
