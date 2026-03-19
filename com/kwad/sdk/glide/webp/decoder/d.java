package com.kwad.sdk.glide.webp.decoder;

import android.content.Context;
import android.graphics.Bitmap;
import com.kwad.sdk.glide.load.engine.s;
import com.kwad.sdk.glide.webp.WebpHeaderParser;
import com.kwad.sdk.glide.webp.WebpImage;
import java.nio.ByteBuffer;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class d implements com.kwad.sdk.glide.load.g<ByteBuffer, k> {
    public static final com.kwad.sdk.glide.load.e<Boolean> bQE = com.kwad.sdk.glide.load.e.c("com.kwad.sdk.glide.webp.decoder.ByteBufferWebpDecoder.DisableAnimation", Boolean.FALSE);
    private final com.kwad.sdk.glide.load.engine.bitmap_recycle.e aLk;
    private final com.kwad.sdk.glide.load.resource.d.b caD;
    private final Context mContext;

    @Override // com.kwad.sdk.glide.load.g
    public final /* bridge */ /* synthetic */ boolean a(ByteBuffer byteBuffer, com.kwad.sdk.glide.load.f fVar) {
        return a2(byteBuffer, fVar);
    }

    public d(Context context, com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar, com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar) {
        this.mContext = context.getApplicationContext();
        this.aLk = eVar;
        this.caD = new com.kwad.sdk.glide.load.resource.d.b(eVar, bVar);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static boolean a2(ByteBuffer byteBuffer, com.kwad.sdk.glide.load.f fVar) {
        if (((Boolean) fVar.a(bQE)).booleanValue()) {
            return false;
        }
        return WebpHeaderParser.c(WebpHeaderParser.j(byteBuffer));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.glide.load.g
    public s<k> a(ByteBuffer byteBuffer, int i, int i2, com.kwad.sdk.glide.load.f fVar) {
        int iRemaining = byteBuffer.remaining();
        byte[] bArr = new byte[iRemaining];
        byteBuffer.get(bArr, 0, iRemaining);
        WebpImage webpImageCreate = WebpImage.create(bArr);
        p pVar = (p) fVar.a(o.caZ);
        if (pVar == null) {
            pVar = new p();
        }
        i iVar = new i(this.caD, webpImageCreate, byteBuffer, pVar.d(webpImageCreate.getWidth(), webpImageCreate.getHeight(), i, i2), (WebpFrameCacheStrategy) fVar.a(o.caY));
        iVar.advance();
        Bitmap bitmapAfA = iVar.afA();
        if (bitmapAfA == null) {
            return null;
        }
        return new m(new k(this.mContext, iVar, this.aLk, com.kwad.sdk.glide.load.resource.b.ahJ(), i, i2, bitmapAfA));
    }
}
