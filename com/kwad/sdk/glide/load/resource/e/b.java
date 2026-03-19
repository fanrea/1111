package com.kwad.sdk.glide.load.resource.e;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.kwad.sdk.glide.load.engine.s;
import com.kwad.sdk.glide.load.resource.bitmap.r;
import com.kwad.sdk.utils.ax;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class b implements e<Bitmap, BitmapDrawable> {
    private final Resources resources;

    public b(Resources resources) {
        this.resources = (Resources) ax.checkNotNull(resources);
    }

    @Override // com.kwad.sdk.glide.load.resource.e.e
    public final s<BitmapDrawable> a(s<Bitmap> sVar, com.kwad.sdk.glide.load.f fVar) {
        return r.a(this.resources, sVar);
    }
}
