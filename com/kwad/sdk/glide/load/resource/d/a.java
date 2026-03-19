package com.kwad.sdk.glide.load.resource.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import com.kwad.sdk.glide.gifdecoder.a;
import com.kwad.sdk.glide.load.DecodeFormat;
import com.kwad.sdk.glide.load.ImageHeaderParser;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Queue;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class a implements com.kwad.sdk.glide.load.g<ByteBuffer, c> {
    private static final C0613a bXW = new C0613a();
    private static final b bXX = new b();
    private final List<ImageHeaderParser> bQG;
    private final b bXY;
    private final C0613a bXZ;
    private final com.kwad.sdk.glide.load.resource.d.b bYa;
    private final Context dR;

    public a(Context context, List<ImageHeaderParser> list, com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar, com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar) {
        this(context, list, eVar, bVar, bXX, bXW);
    }

    private a(Context context, List<ImageHeaderParser> list, com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar, com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar, b bVar2, C0613a c0613a) {
        this.dR = context.getApplicationContext();
        this.bQG = list;
        this.bXZ = c0613a;
        this.bYa = new com.kwad.sdk.glide.load.resource.d.b(eVar, bVar);
        this.bXY = bVar2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.glide.load.g
    public boolean a(ByteBuffer byteBuffer, com.kwad.sdk.glide.load.f fVar) {
        return !((Boolean) fVar.a(i.bQE)).booleanValue() && com.kwad.sdk.glide.load.b.a(this.bQG, byteBuffer) == ImageHeaderParser.ImageType.GIF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.glide.load.g
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public e a(ByteBuffer byteBuffer, int i, int i2, com.kwad.sdk.glide.load.f fVar) {
        com.kwad.sdk.glide.gifdecoder.d dVarF = this.bXY.f(byteBuffer);
        try {
            return a(byteBuffer, i, i2, dVarF, fVar);
        } finally {
            this.bXY.a(dVarF);
        }
    }

    private e a(ByteBuffer byteBuffer, int i, int i2, com.kwad.sdk.glide.gifdecoder.d dVar, com.kwad.sdk.glide.load.f fVar) {
        long jAjA = com.kwad.sdk.glide.e.f.ajA();
        try {
            com.kwad.sdk.glide.gifdecoder.c cVarAfC = dVar.afC();
            if (cVarAfC.afB() > 0 && cVarAfC.getStatus() == 0) {
                Bitmap.Config config = fVar.a(i.bXr) == DecodeFormat.PREFER_RGB_565 ? Bitmap.Config.RGB_565 : Bitmap.Config.ARGB_8888;
                com.kwad.sdk.glide.gifdecoder.a aVarA = C0613a.a(this.bYa, cVarAfC, byteBuffer, a(cVarAfC, i, i2));
                aVarA.a(config);
                aVarA.advance();
                Bitmap bitmapAfA = aVarA.afA();
                if (bitmapAfA == null) {
                    return null;
                }
                e eVar = new e(new c(this.dR, aVarA, com.kwad.sdk.glide.load.resource.b.ahJ(), i, i2, bitmapAfA));
                if (Log.isLoggable("BufferGifDecoder", 2)) {
                    Log.v("BufferGifDecoder", "Decoded GIF from stream in " + com.kwad.sdk.glide.e.f.bq(jAjA));
                }
                return eVar;
            }
            if (Log.isLoggable("BufferGifDecoder", 2)) {
                Log.v("BufferGifDecoder", "Decoded GIF from stream in " + com.kwad.sdk.glide.e.f.bq(jAjA));
            }
            return null;
        } finally {
            if (Log.isLoggable("BufferGifDecoder", 2)) {
                Log.v("BufferGifDecoder", "Decoded GIF from stream in " + com.kwad.sdk.glide.e.f.bq(jAjA));
            }
        }
    }

    private static int a(com.kwad.sdk.glide.gifdecoder.c cVar, int i, int i2) {
        int iMin = Math.min(cVar.getHeight() / i2, cVar.getWidth() / i);
        int iMax = Math.max(1, iMin == 0 ? 0 : Integer.highestOneBit(iMin));
        if (Log.isLoggable("BufferGifDecoder", 2) && iMax > 1) {
            Log.v("BufferGifDecoder", "Downsampling GIF, sampleSize: " + iMax + ", target dimens: [" + i + "x" + i2 + "], actual dimens: [" + cVar.getWidth() + "x" + cVar.getHeight() + "]");
        }
        return iMax;
    }

    /* renamed from: com.kwad.sdk.glide.load.resource.d.a$a, reason: collision with other inner class name */
    static class C0613a {
        C0613a() {
        }

        static com.kwad.sdk.glide.gifdecoder.a a(a.InterfaceC0603a interfaceC0603a, com.kwad.sdk.glide.gifdecoder.c cVar, ByteBuffer byteBuffer, int i) {
            return new com.kwad.sdk.glide.gifdecoder.e(interfaceC0603a, cVar, byteBuffer, i);
        }
    }

    static class b {
        private final Queue<com.kwad.sdk.glide.gifdecoder.d> bVl = com.kwad.sdk.glide.e.j.gt(0);

        b() {
        }

        final synchronized com.kwad.sdk.glide.gifdecoder.d f(ByteBuffer byteBuffer) {
            com.kwad.sdk.glide.gifdecoder.d dVarPoll;
            dVarPoll = this.bVl.poll();
            if (dVarPoll == null) {
                dVarPoll = new com.kwad.sdk.glide.gifdecoder.d();
            }
            return dVarPoll.b(byteBuffer);
        }

        final synchronized void a(com.kwad.sdk.glide.gifdecoder.d dVar) {
            dVar.clear();
            this.bVl.offer(dVar);
        }
    }
}
