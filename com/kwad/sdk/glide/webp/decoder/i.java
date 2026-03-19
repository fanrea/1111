package com.kwad.sdk.glide.webp.decoder;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.LruCache;
import com.kwad.sdk.glide.gifdecoder.a;
import com.kwad.sdk.glide.webp.WebpFrame;
import com.kwad.sdk.glide.webp.WebpImage;
import java.nio.ByteBuffer;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class i implements com.kwad.sdk.glide.gifdecoder.a {
    private ByteBuffer bRf;
    private int bRt;
    private int bRu;
    private int bRv;
    private WebpImage caG;
    private final a.InterfaceC0603a caH;
    private int caI;
    private final com.kwad.sdk.glide.webp.c[] caJ;
    private final Paint caK;
    private WebpFrameCacheStrategy caL;
    private Bitmap.Config caM;
    private final LruCache<Integer, Bitmap> caN;
    private final int[] mFrameDurations;

    public i(a.InterfaceC0603a interfaceC0603a, WebpImage webpImage, ByteBuffer byteBuffer, int i) {
        this(interfaceC0603a, webpImage, byteBuffer, i, WebpFrameCacheStrategy.caS);
    }

    public i(a.InterfaceC0603a interfaceC0603a, WebpImage webpImage, ByteBuffer byteBuffer, int i, WebpFrameCacheStrategy webpFrameCacheStrategy) {
        int iMax;
        this.caI = -1;
        this.caM = Bitmap.Config.ARGB_8888;
        this.caH = interfaceC0603a;
        this.caG = webpImage;
        this.mFrameDurations = webpImage.getFrameDurations();
        this.caJ = new com.kwad.sdk.glide.webp.c[webpImage.getFrameCount()];
        for (int i2 = 0; i2 < this.caG.getFrameCount(); i2++) {
            this.caJ[i2] = this.caG.getFrameInfo(i2);
            if (Log.isLoggable("WebpDecoder[WEBP]", 3)) {
                Log.d("WebpDecoder[WEBP]", "mFrameInfos: " + this.caJ[i2].toString());
            }
        }
        this.caL = webpFrameCacheStrategy;
        Paint paint = new Paint();
        this.caK = paint;
        paint.setColor(0);
        paint.setStyle(Paint.Style.FILL);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        if (this.caL.ajO()) {
            iMax = webpImage.getFrameCount();
        } else {
            iMax = Math.max(5, this.caL.oq());
        }
        this.caN = new LruCache<Integer, Bitmap>(iMax) { // from class: com.kwad.sdk.glide.webp.decoder.i.1
            @Override // android.util.LruCache
            protected final /* synthetic */ void entryRemoved(boolean z, Integer num, Bitmap bitmap, Bitmap bitmap2) {
                n(bitmap);
            }

            private void n(Bitmap bitmap) {
                if (bitmap != null) {
                    i.this.caH.d(bitmap);
                }
            }
        };
        new com.kwad.sdk.glide.gifdecoder.c();
        a(byteBuffer, i);
    }

    public final WebpFrameCacheStrategy ajM() {
        return this.caL;
    }

    @Override // com.kwad.sdk.glide.gifdecoder.a
    public final ByteBuffer getData() {
        return this.bRf;
    }

    @Override // com.kwad.sdk.glide.gifdecoder.a
    public final void advance() {
        this.caI = (this.caI + 1) % this.caG.getFrameCount();
    }

    private int ga(int i) {
        if (i >= 0) {
            int[] iArr = this.mFrameDurations;
            if (i < iArr.length) {
                return iArr[i];
            }
        }
        return -1;
    }

    @Override // com.kwad.sdk.glide.gifdecoder.a
    public final int afx() {
        int i;
        if (this.mFrameDurations.length == 0 || (i = this.caI) < 0) {
            return 0;
        }
        return ga(i);
    }

    @Override // com.kwad.sdk.glide.gifdecoder.a
    public final int getFrameCount() {
        return this.caG.getFrameCount();
    }

    @Override // com.kwad.sdk.glide.gifdecoder.a
    public final int afy() {
        return this.caI;
    }

    @Override // com.kwad.sdk.glide.gifdecoder.a
    public final void afz() {
        this.caI = -1;
    }

    @Override // com.kwad.sdk.glide.gifdecoder.a
    public final int getByteSize() {
        return this.caG.getSizeInBytes();
    }

    @Override // com.kwad.sdk.glide.gifdecoder.a
    public final void a(Bitmap.Config config) {
        if (config != Bitmap.Config.ARGB_8888) {
            throw new IllegalArgumentException("Unsupported format: " + config + ", must be one of " + Bitmap.Config.ARGB_8888);
        }
        this.caM = config;
    }

    @Override // com.kwad.sdk.glide.gifdecoder.a
    public final Bitmap afA() {
        Bitmap bitmap;
        int iAfy = afy();
        Bitmap bitmapA = this.caH.a(this.bRv, this.bRu, Bitmap.Config.ARGB_8888);
        bitmapA.eraseColor(0);
        if (Build.VERSION.SDK_INT >= 24) {
            bitmapA.setDensity(DisplayMetrics.DENSITY_DEVICE_STABLE);
        }
        Canvas canvas = new Canvas(bitmapA);
        canvas.drawColor(0, PorterDuff.Mode.SRC);
        if (!this.caL.noCache() && (bitmap = this.caN.get(Integer.valueOf(iAfy))) != null) {
            if (Log.isLoggable("WebpDecoder[WEBP]", 3)) {
                Log.d("WebpDecoder[WEBP]", "hit frame bitmap from memory cache, frameNumber=" + iAfy);
            }
            bitmap.setDensity(canvas.getDensity());
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
            return bitmapA;
        }
        int iB = !gv(iAfy) ? b(iAfy - 1, canvas) : iAfy;
        if (Log.isLoggable("WebpDecoder[WEBP]", 3)) {
            Log.d("WebpDecoder[WEBP]", "frameNumber=" + iAfy + ", nextIndex=" + iB);
        }
        while (iB < iAfy) {
            com.kwad.sdk.glide.webp.c cVar = this.caJ[iB];
            if (!cVar.blendPreviousFrame) {
                a(canvas, cVar);
            }
            a(iB, canvas);
            if (Log.isLoggable("WebpDecoder[WEBP]", 3)) {
                Log.d("WebpDecoder[WEBP]", "renderFrame, index=" + iB + ", blend=" + cVar.blendPreviousFrame + ", dispose=" + cVar.disposeBackgroundColor);
            }
            if (cVar.disposeBackgroundColor) {
                a(canvas, cVar);
            }
            iB++;
        }
        com.kwad.sdk.glide.webp.c cVar2 = this.caJ[iAfy];
        if (!cVar2.blendPreviousFrame) {
            a(canvas, cVar2);
        }
        a(iAfy, canvas);
        if (Log.isLoggable("WebpDecoder[WEBP]", 3)) {
            Log.d("WebpDecoder[WEBP]", "renderFrame, index=" + iAfy + ", blend=" + cVar2.blendPreviousFrame + ", dispose=" + cVar2.disposeBackgroundColor);
        }
        a(iAfy, bitmapA);
        return bitmapA;
    }

    private void a(int i, Canvas canvas) {
        com.kwad.sdk.glide.webp.c cVar = this.caJ[i];
        int i2 = cVar.width / this.bRt;
        int i3 = cVar.height / this.bRt;
        int i4 = cVar.cay / this.bRt;
        int i5 = cVar.caz / this.bRt;
        WebpFrame frame = this.caG.getFrame(i);
        try {
            Bitmap bitmapA = this.caH.a(i2, i3, this.caM);
            bitmapA.eraseColor(0);
            bitmapA.setDensity(canvas.getDensity());
            frame.renderFrame(i2, i3, bitmapA);
            canvas.drawBitmap(bitmapA, i4, i5, (Paint) null);
            this.caH.d(bitmapA);
        } catch (IllegalStateException unused) {
            Log.e("WebpDecoder[WEBP]", "Rendering of frame failed. Frame number: " + i);
        } finally {
            frame.dispose();
        }
    }

    private void a(int i, Bitmap bitmap) {
        this.caN.remove(Integer.valueOf(i));
        Bitmap bitmapA = this.caH.a(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
        bitmapA.eraseColor(0);
        bitmapA.setDensity(bitmap.getDensity());
        Canvas canvas = new Canvas(bitmapA);
        canvas.drawColor(0, PorterDuff.Mode.SRC);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        this.caN.put(Integer.valueOf(i), bitmapA);
    }

    @Override // com.kwad.sdk.glide.gifdecoder.a
    public final void clear() {
        this.caG.dispose();
        this.caG = null;
        this.caN.evictAll();
        this.bRf = null;
    }

    private void a(ByteBuffer byteBuffer, int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Sample size must be >=0, not: " + i);
        }
        int iHighestOneBit = Integer.highestOneBit(i);
        ByteBuffer byteBufferAsReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        this.bRf = byteBufferAsReadOnlyBuffer;
        byteBufferAsReadOnlyBuffer.position(0);
        this.bRt = iHighestOneBit;
        this.bRv = this.caG.getWidth() / iHighestOneBit;
        this.bRu = this.caG.getHeight() / iHighestOneBit;
    }

    private int b(int i, Canvas canvas) {
        while (i >= 0) {
            com.kwad.sdk.glide.webp.c cVar = this.caJ[i];
            if (cVar.disposeBackgroundColor && a(cVar)) {
                return i + 1;
            }
            Bitmap bitmap = this.caN.get(Integer.valueOf(i));
            if (bitmap != null && !bitmap.isRecycled()) {
                bitmap.setDensity(canvas.getDensity());
                canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
                if (cVar.disposeBackgroundColor) {
                    a(canvas, cVar);
                }
                return i + 1;
            }
            if (gv(i)) {
                return i;
            }
            i--;
        }
        return 0;
    }

    private void a(Canvas canvas, com.kwad.sdk.glide.webp.c cVar) {
        canvas.drawRect(cVar.cay / this.bRt, cVar.caz / this.bRt, (cVar.cay + cVar.width) / this.bRt, (cVar.caz + cVar.height) / this.bRt, this.caK);
    }

    private boolean gv(int i) {
        if (i == 0) {
            return true;
        }
        com.kwad.sdk.glide.webp.c[] cVarArr = this.caJ;
        com.kwad.sdk.glide.webp.c cVar = cVarArr[i];
        com.kwad.sdk.glide.webp.c cVar2 = cVarArr[i - 1];
        if (cVar.blendPreviousFrame || !a(cVar)) {
            return cVar2.disposeBackgroundColor && a(cVar2);
        }
        return true;
    }

    private boolean a(com.kwad.sdk.glide.webp.c cVar) {
        return cVar.cay == 0 && cVar.caz == 0 && cVar.width == this.caG.getWidth() && cVar.height == this.caG.getHeight();
    }
}
