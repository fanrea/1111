package com.kwad.sdk.glide.webp;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.kwad.sdk.glide.Registry;
import com.kwad.sdk.glide.webp.decoder.f;
import com.kwad.sdk.glide.webp.decoder.g;
import com.kwad.sdk.glide.webp.decoder.j;
import com.kwad.sdk.glide.webp.decoder.k;
import com.kwad.sdk.glide.webp.decoder.l;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class d extends com.kwad.sdk.glide.b.b {
    @Override // com.kwad.sdk.glide.b.b
    public final void a(Context context, com.kwad.sdk.glide.c cVar, Registry registry) {
        Resources resources = context.getResources();
        com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVarAeZ = cVar.aeZ();
        com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVarAfa = cVar.afa();
        j jVar = new j(registry.afj(), resources.getDisplayMetrics(), eVarAeZ, bVarAfa);
        com.kwad.sdk.glide.webp.decoder.a aVar = new com.kwad.sdk.glide.webp.decoder.a(bVarAfa, eVarAeZ);
        com.kwad.sdk.glide.webp.decoder.c cVar2 = new com.kwad.sdk.glide.webp.decoder.c(jVar);
        f fVar = new f(jVar, bVarAfa);
        com.kwad.sdk.glide.webp.decoder.d dVar = new com.kwad.sdk.glide.webp.decoder.d(context, bVarAfa, eVarAeZ);
        registry.b(com.bumptech.glide.Registry.BUCKET_BITMAP, ByteBuffer.class, Bitmap.class, cVar2).b(com.bumptech.glide.Registry.BUCKET_BITMAP, InputStream.class, Bitmap.class, fVar).b(com.bumptech.glide.Registry.BUCKET_BITMAP_DRAWABLE, ByteBuffer.class, BitmapDrawable.class, new com.kwad.sdk.glide.load.resource.bitmap.a(resources, cVar2)).b(com.bumptech.glide.Registry.BUCKET_BITMAP_DRAWABLE, InputStream.class, BitmapDrawable.class, new com.kwad.sdk.glide.load.resource.bitmap.a(resources, fVar)).b(com.bumptech.glide.Registry.BUCKET_BITMAP, ByteBuffer.class, Bitmap.class, new com.kwad.sdk.glide.webp.decoder.b(aVar)).b(com.bumptech.glide.Registry.BUCKET_BITMAP, InputStream.class, Bitmap.class, new com.kwad.sdk.glide.webp.decoder.e(aVar)).b(ByteBuffer.class, k.class, dVar).b(InputStream.class, k.class, new g(dVar, bVarAfa)).b(k.class, new l());
    }
}
