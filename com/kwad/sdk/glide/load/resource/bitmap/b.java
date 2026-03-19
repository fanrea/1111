package com.kwad.sdk.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.kwad.sdk.glide.load.EncodeStrategy;
import java.io.File;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class b implements com.kwad.sdk.glide.load.h<BitmapDrawable> {
    private final com.kwad.sdk.glide.load.engine.bitmap_recycle.e bPy;
    private final com.kwad.sdk.glide.load.h<Bitmap> bTg;

    public b(com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar, com.kwad.sdk.glide.load.h<Bitmap> hVar) {
        this.bPy = eVar;
        this.bTg = hVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.glide.load.a
    public boolean a(com.kwad.sdk.glide.load.engine.s<BitmapDrawable> sVar, File file, com.kwad.sdk.glide.load.f fVar) {
        return this.bTg.a(new d(sVar.get().getBitmap(), this.bPy), file, fVar);
    }

    @Override // com.kwad.sdk.glide.load.h
    public final EncodeStrategy b(com.kwad.sdk.glide.load.f fVar) {
        return this.bTg.b(fVar);
    }
}
