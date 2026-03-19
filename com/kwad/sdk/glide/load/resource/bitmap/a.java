package com.kwad.sdk.glide.load.resource.bitmap;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.kwad.sdk.utils.ax;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class a<DataType> implements com.kwad.sdk.glide.load.g<DataType, BitmapDrawable> {
    private final com.kwad.sdk.glide.load.g<DataType, Bitmap> bQJ;
    private final Resources resources;

    public a(Resources resources, com.kwad.sdk.glide.load.g<DataType, Bitmap> gVar) {
        this.resources = (Resources) ax.checkNotNull(resources);
        this.bQJ = (com.kwad.sdk.glide.load.g) ax.checkNotNull(gVar);
    }

    @Override // com.kwad.sdk.glide.load.g
    public final boolean a(DataType datatype, com.kwad.sdk.glide.load.f fVar) {
        return this.bQJ.a(datatype, fVar);
    }

    @Override // com.kwad.sdk.glide.load.g
    public final com.kwad.sdk.glide.load.engine.s<BitmapDrawable> a(DataType datatype, int i, int i2, com.kwad.sdk.glide.load.f fVar) {
        return r.a(this.resources, this.bQJ.a(datatype, i, i2, fVar));
    }
}
