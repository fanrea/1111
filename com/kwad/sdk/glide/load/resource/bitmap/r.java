package com.kwad.sdk.glide.load.resource.bitmap;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.kwad.sdk.utils.ax;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class r implements com.kwad.sdk.glide.load.engine.o, com.kwad.sdk.glide.load.engine.s<BitmapDrawable> {
    private final com.kwad.sdk.glide.load.engine.s<Bitmap> bXJ;
    private final Resources resources;

    public static com.kwad.sdk.glide.load.engine.s<BitmapDrawable> a(Resources resources, com.kwad.sdk.glide.load.engine.s<Bitmap> sVar) {
        if (sVar == null) {
            return null;
        }
        return new r(resources, sVar);
    }

    private r(Resources resources, com.kwad.sdk.glide.load.engine.s<Bitmap> sVar) {
        this.resources = (Resources) ax.checkNotNull(resources);
        this.bXJ = (com.kwad.sdk.glide.load.engine.s) ax.checkNotNull(sVar);
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    public final Class<BitmapDrawable> afv() {
        return BitmapDrawable.class;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.glide.load.engine.s
    /* renamed from: ahR, reason: merged with bridge method [inline-methods] */
    public BitmapDrawable get() {
        return new BitmapDrawable(this.resources, this.bXJ.get());
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    public final int getSize() {
        return this.bXJ.getSize();
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    public final void recycle() {
        this.bXJ.recycle();
    }

    @Override // com.kwad.sdk.glide.load.engine.o
    public final void initialize() {
        com.kwad.sdk.glide.load.engine.s<Bitmap> sVar = this.bXJ;
        if (sVar instanceof com.kwad.sdk.glide.load.engine.o) {
            ((com.kwad.sdk.glide.load.engine.o) sVar).initialize();
        }
    }
}
