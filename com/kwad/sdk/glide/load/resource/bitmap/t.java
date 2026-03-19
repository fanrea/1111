package com.kwad.sdk.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.kwad.sdk.utils.ax;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class t extends e {
    private static final byte[] ID_BYTES = "com.kwad.sdk.glide.load.resource.bitmap.RoundedCorners".getBytes(bRy);
    private final int bXL;

    public t(int i) {
        ax.checkArgument(i > 0, "roundingRadius must be greater than 0.");
        this.bXL = i;
    }

    @Override // com.kwad.sdk.glide.load.resource.bitmap.e
    protected final Bitmap transform(com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar, Bitmap bitmap, int i, int i2) {
        return v.b(eVar, bitmap, this.bXL);
    }

    @Override // com.kwad.sdk.glide.load.c
    public final boolean equals(Object obj) {
        return (obj instanceof t) && this.bXL == ((t) obj).bXL;
    }

    @Override // com.kwad.sdk.glide.load.c
    public final int hashCode() {
        return com.kwad.sdk.glide.e.j.hashCode(1437040169, com.kwad.sdk.glide.e.j.hashCode(this.bXL));
    }

    @Override // com.kwad.sdk.glide.load.c
    public final void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(ID_BYTES);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.bXL).array());
    }
}
