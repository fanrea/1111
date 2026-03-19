package com.kwad.sdk.glide.webp.decoder;

import android.graphics.Bitmap;
import com.kwad.sdk.glide.load.engine.s;
import com.kwad.sdk.glide.webp.WebpHeaderParser;
import com.kwad.sdk.glide.webp.WebpImage;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class a {
    public static final com.kwad.sdk.glide.load.e<Boolean> caB = com.kwad.sdk.glide.load.e.c("com.kwad.sdk.glide.webp.decoder.AnimatedWebpBitmapDecoder.DisableBitmap", Boolean.FALSE);
    private final com.kwad.sdk.glide.load.engine.bitmap_recycle.e aLk;
    private final com.kwad.sdk.glide.load.engine.bitmap_recycle.b caC;
    private final com.kwad.sdk.glide.load.resource.d.b caD;

    public a(com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar, com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar) {
        this.caC = bVar;
        this.aLk = eVar;
        this.caD = new com.kwad.sdk.glide.load.resource.d.b(eVar, bVar);
    }

    public final boolean a(InputStream inputStream, com.kwad.sdk.glide.load.f fVar) {
        if (((Boolean) fVar.a(caB)).booleanValue()) {
            return false;
        }
        return WebpHeaderParser.c(WebpHeaderParser.b(inputStream, this.caC));
    }

    public static boolean a(ByteBuffer byteBuffer, com.kwad.sdk.glide.load.f fVar) {
        if (((Boolean) fVar.a(caB)).booleanValue()) {
            return false;
        }
        return WebpHeaderParser.c(WebpHeaderParser.j(byteBuffer));
    }

    public final s<Bitmap> a(InputStream inputStream, int i, int i2, com.kwad.sdk.glide.load.f fVar) throws IOException {
        byte[] bArrK = h.k(inputStream);
        if (bArrK == null) {
            return null;
        }
        return a(ByteBuffer.wrap(bArrK), i, i2, fVar);
    }

    public final s<Bitmap> a(ByteBuffer byteBuffer, int i, int i2, com.kwad.sdk.glide.load.f fVar) {
        int iRemaining = byteBuffer.remaining();
        byte[] bArr = new byte[iRemaining];
        byteBuffer.get(bArr, 0, iRemaining);
        WebpImage webpImageCreate = WebpImage.create(bArr);
        p pVar = (p) fVar.a(o.caZ);
        if (pVar == null) {
            pVar = new p();
        }
        i iVar = new i(this.caD, webpImageCreate, byteBuffer, pVar.d(webpImageCreate.getWidth(), webpImageCreate.getHeight(), i, i2));
        try {
            iVar.advance();
            Bitmap bitmapAfA = iVar.afA();
            if (bitmapAfA != null) {
                return com.kwad.sdk.glide.load.resource.bitmap.d.a(bitmapAfA, this.aLk);
            }
            iVar.clear();
            return null;
        } finally {
            iVar.clear();
        }
    }
}
