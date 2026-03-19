package com.kwad.sdk.glide.load.resource.e;

import android.graphics.Bitmap;
import com.kwad.sdk.glide.load.engine.s;
import java.io.ByteArrayOutputStream;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class a implements e<Bitmap, byte[]> {
    private final Bitmap.CompressFormat bYw;
    private final int quality;

    public a() {
        this(Bitmap.CompressFormat.JPEG, 100);
    }

    private a(Bitmap.CompressFormat compressFormat, int i) {
        this.bYw = compressFormat;
        this.quality = 100;
    }

    @Override // com.kwad.sdk.glide.load.resource.e.e
    public final s<byte[]> a(s<Bitmap> sVar, com.kwad.sdk.glide.load.f fVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        sVar.get().compress(this.bYw, this.quality, byteArrayOutputStream);
        sVar.recycle();
        return new com.kwad.sdk.glide.load.resource.a.b(byteArrayOutputStream.toByteArray());
    }
}
