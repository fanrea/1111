package com.kwad.sdk.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class f implements e {
    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.e
    public final void clearMemory() {
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.e
    public final void fV(int i) {
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.e
    public void e(Bitmap bitmap) {
        bitmap.recycle();
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.e
    public final Bitmap b(int i, int i2, Bitmap.Config config) {
        return Bitmap.createBitmap(i, i2, config);
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.e
    public final Bitmap g(int i, int i2, Bitmap.Config config) {
        return b(i, i2, config);
    }
}
