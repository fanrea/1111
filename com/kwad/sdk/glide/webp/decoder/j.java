package com.kwad.sdk.glide.webp.decoder;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import com.kwad.sdk.glide.load.DecodeFormat;
import com.kwad.sdk.glide.load.ImageHeaderParser;
import com.kwad.sdk.glide.load.engine.s;
import com.kwad.sdk.glide.load.resource.bitmap.DownsampleStrategy;
import com.kwad.sdk.glide.load.resource.bitmap.k;
import com.kwad.sdk.glide.load.resource.bitmap.v;
import com.kwad.sdk.glide.webp.WebpHeaderParser;
import com.kwad.sdk.utils.ax;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Queue;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class j {
    private final com.kwad.sdk.glide.load.engine.bitmap_recycle.e bPy;
    private final List<ImageHeaderParser> bQG;
    private final com.kwad.sdk.glide.load.engine.bitmap_recycle.b bQO;
    private final DisplayMetrics bVD;
    public static final com.kwad.sdk.glide.load.e<Boolean> caP = com.kwad.sdk.glide.load.e.c("com.kwad.sdk.glide.webp.decoder.WebpDownsampler.DisableDecoder", Boolean.FALSE);
    private static final k.a bXw = new k.a() { // from class: com.kwad.sdk.glide.webp.decoder.j.1
        @Override // com.kwad.sdk.glide.load.resource.bitmap.k.a
        public final void ahN() {
        }

        @Override // com.kwad.sdk.glide.load.resource.bitmap.k.a
        public final void b(com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar, Bitmap bitmap) {
        }
    };
    private static final Queue<BitmapFactory.Options> bXy = com.kwad.sdk.glide.e.j.gt(0);

    private static int s(double d) {
        return (int) (d + 0.5d);
    }

    public j(List<ImageHeaderParser> list, DisplayMetrics displayMetrics, com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar, com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar) {
        this.bQG = list;
        this.bVD = (DisplayMetrics) ax.checkNotNull(displayMetrics);
        this.bPy = (com.kwad.sdk.glide.load.engine.bitmap_recycle.e) ax.checkNotNull(eVar);
        this.bQO = (com.kwad.sdk.glide.load.engine.bitmap_recycle.b) ax.checkNotNull(bVar);
    }

    public final boolean a(InputStream inputStream, com.kwad.sdk.glide.load.f fVar) throws IOException {
        if (!((Boolean) fVar.a(caP)).booleanValue() && !WebpHeaderParser.caA) {
            WebpHeaderParser.WebpImageType webpImageTypeB = WebpHeaderParser.b(inputStream, this.bQO);
            if (WebpHeaderParser.a(webpImageTypeB) && webpImageTypeB != WebpHeaderParser.WebpImageType.WEBP_SIMPLE) {
                return true;
            }
        }
        return false;
    }

    public static boolean a(ByteBuffer byteBuffer, com.kwad.sdk.glide.load.f fVar) {
        if (!((Boolean) fVar.a(caP)).booleanValue() && !WebpHeaderParser.caA) {
            WebpHeaderParser.WebpImageType webpImageTypeJ = WebpHeaderParser.j(byteBuffer);
            if (WebpHeaderParser.a(webpImageTypeJ) && webpImageTypeJ != WebpHeaderParser.WebpImageType.WEBP_SIMPLE) {
                return true;
            }
        }
        return false;
    }

    public final s<Bitmap> a(InputStream inputStream, int i, int i2, com.kwad.sdk.glide.load.f fVar) {
        return a(inputStream, i, i2, fVar, bXw);
    }

    private s<Bitmap> a(InputStream inputStream, int i, int i2, com.kwad.sdk.glide.load.f fVar, k.a aVar) {
        ax.checkArgument(inputStream.markSupported(), "You must provide an InputStream that supports mark()");
        byte[] bArr = (byte[]) this.bQO.a(65536, byte[].class);
        BitmapFactory.Options optionsAhM = ahM();
        optionsAhM.inTempStorage = bArr;
        DecodeFormat decodeFormat = (DecodeFormat) fVar.a(com.kwad.sdk.glide.load.resource.bitmap.k.bXr);
        try {
            return com.kwad.sdk.glide.load.resource.bitmap.d.a(a(inputStream, optionsAhM, (DownsampleStrategy) fVar.a(com.kwad.sdk.glide.load.resource.bitmap.k.bXs), decodeFormat, fVar.a(com.kwad.sdk.glide.load.resource.bitmap.k.bXu) != null && ((Boolean) fVar.a(com.kwad.sdk.glide.load.resource.bitmap.k.bXu)).booleanValue(), i, i2, ((Boolean) fVar.a(com.kwad.sdk.glide.load.resource.bitmap.k.bXt)).booleanValue(), aVar), this.bPy);
        } finally {
            c(optionsAhM);
            this.bQO.B(bArr);
        }
    }

    private Bitmap a(InputStream inputStream, BitmapFactory.Options options, DownsampleStrategy downsampleStrategy, DecodeFormat decodeFormat, boolean z, int i, int i2, boolean z2, k.a aVar) throws IOException {
        int i3;
        int iRound;
        int iRound2;
        long jAjA = com.kwad.sdk.glide.e.f.ajA();
        int[] iArrA = a(inputStream, options, aVar, this.bPy);
        int i4 = iArrA[0];
        int i5 = iArrA[1];
        String str = options.outMimeType;
        int iB = com.kwad.sdk.glide.load.b.b(this.bQG, inputStream, this.bQO);
        int iGn = v.gn(iB);
        v.go(iB);
        int i6 = i == Integer.MIN_VALUE ? i4 : i;
        int i7 = i2 == Integer.MIN_VALUE ? i5 : i2;
        a(com.kwad.sdk.glide.load.b.a(this.bQG, inputStream, this.bQO), inputStream, aVar, this.bPy, downsampleStrategy, iGn, i4, i5, i6, i7, options);
        a(inputStream, decodeFormat, options);
        boolean z3 = Build.VERSION.SDK_INT >= 19;
        if ((options.inSampleSize == 1 || z3) && ajN()) {
            if (z2 && z3) {
                iRound = i6;
                iRound2 = i7;
                i3 = i4;
            } else {
                float f = a(options) ? options.inTargetDensity / options.inDensity : 1.0f;
                int i8 = options.inSampleSize;
                i3 = i4;
                float f2 = i8;
                int iCeil = (int) Math.ceil(i3 / f2);
                int iCeil2 = (int) Math.ceil(i5 / f2);
                iRound = Math.round(iCeil * f);
                iRound2 = Math.round(iCeil2 * f);
                if (Log.isLoggable("WebpDownsampler", 2)) {
                    Log.v("WebpDownsampler", "Calculated target [" + iRound + "x" + iRound2 + "] for source [" + i3 + "x" + i5 + "], sampleSize: " + i8 + ", targetDensity: " + options.inTargetDensity + ", density: " + options.inDensity + ", density multiplier: " + f);
                }
            }
            if (iRound > 0 && iRound2 > 0) {
                a(options, this.bPy, iRound, iRound2);
            }
        } else {
            i3 = i4;
        }
        Bitmap bitmapB = b(inputStream, options, aVar, this.bPy);
        aVar.b(this.bPy, bitmapB);
        if (Log.isLoggable("WebpDownsampler", 2)) {
            a(i3, i5, str, options, bitmapB, i, i2, jAjA);
        }
        Bitmap bitmapA = null;
        if (bitmapB != null) {
            bitmapB.setDensity(this.bVD.densityDpi);
            bitmapA = v.a(this.bPy, bitmapB, iB);
            if (!bitmapB.equals(bitmapA)) {
                this.bPy.e(bitmapB);
            }
        }
        return bitmapA;
    }

    private static void a(ImageHeaderParser.ImageType imageType, InputStream inputStream, k.a aVar, com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar, DownsampleStrategy downsampleStrategy, int i, int i2, int i3, int i4, int i5, BitmapFactory.Options options) throws IOException {
        float fC;
        int iMin;
        int iFloor;
        double dFloor;
        int iRound;
        if (i2 <= 0 || i3 <= 0) {
            return;
        }
        if (i == 90 || i == 270) {
            fC = downsampleStrategy.c(i3, i2, i4, i5);
        } else {
            fC = downsampleStrategy.c(i2, i3, i4, i5);
        }
        if (fC <= 0.0f) {
            throw new IllegalArgumentException("Cannot scale with factor: " + fC + " from: " + downsampleStrategy + ", source: [" + i2 + "x" + i3 + "], target: [" + i4 + "x" + i5 + "]");
        }
        DownsampleStrategy.SampleSizeRounding sampleSizeRoundingAhL = downsampleStrategy.ahL();
        if (sampleSizeRoundingAhL == null) {
            throw new IllegalArgumentException("Cannot round with null rounding");
        }
        float f = i2;
        float f2 = i3;
        int iS = i2 / s(fC * f);
        int iS2 = i3 / s(fC * f2);
        if (sampleSizeRoundingAhL == DownsampleStrategy.SampleSizeRounding.MEMORY) {
            iMin = Math.max(iS, iS2);
        } else {
            iMin = Math.min(iS, iS2);
        }
        int iMax = Math.max(1, Integer.highestOneBit(iMin));
        if (sampleSizeRoundingAhL == DownsampleStrategy.SampleSizeRounding.MEMORY && iMax < 1.0f / fC) {
            iMax <<= 1;
        }
        options.inSampleSize = iMax;
        if (imageType == ImageHeaderParser.ImageType.JPEG) {
            float fMin = Math.min(iMax, 8);
            iFloor = (int) Math.ceil(f / fMin);
            iRound = (int) Math.ceil(f2 / fMin);
            int i6 = iMax / 8;
            if (i6 > 0) {
                iFloor /= i6;
                iRound /= i6;
            }
        } else {
            if (imageType == ImageHeaderParser.ImageType.PNG || imageType == ImageHeaderParser.ImageType.PNG_A) {
                float f3 = iMax;
                iFloor = (int) Math.floor(f / f3);
                dFloor = Math.floor(f2 / f3);
            } else if (imageType == ImageHeaderParser.ImageType.WEBP || imageType == ImageHeaderParser.ImageType.WEBP_A) {
                if (Build.VERSION.SDK_INT >= 24) {
                    float f4 = iMax;
                    iFloor = Math.round(f / f4);
                    iRound = Math.round(f2 / f4);
                } else {
                    float f5 = iMax;
                    iFloor = (int) Math.floor(f / f5);
                    dFloor = Math.floor(f2 / f5);
                }
            } else if (i2 % iMax != 0 || i3 % iMax != 0) {
                int[] iArrA = a(inputStream, options, aVar, eVar);
                iFloor = iArrA[0];
                iRound = iArrA[1];
            } else {
                iFloor = i2 / iMax;
                iRound = i3 / iMax;
            }
            iRound = (int) dFloor;
        }
        double dC = downsampleStrategy.c(iFloor, iRound, i4, i5);
        if (Build.VERSION.SDK_INT >= 19) {
            options.inTargetDensity = q(dC);
            options.inDensity = 1000000000;
        }
        if (a(options)) {
            options.inScaled = true;
        } else {
            options.inTargetDensity = 0;
            options.inDensity = 0;
        }
        if (Log.isLoggable("WebpDownsampler", 2)) {
            Log.v("WebpDownsampler", "Calculate scaling, source: [" + i2 + "x" + i3 + "], target: [" + i4 + "x" + i5 + "], power of two scaled: [" + iFloor + "x" + iRound + "], exact scale factor: " + fC + ", power of 2 sample size: " + iMax + ", adjusted scale factor: " + dC + ", target density: " + options.inTargetDensity + ", density: " + options.inDensity);
        }
    }

    private static int q(double d) {
        return s((d / (r0 / 1.0E9f)) * s(1.0E9d * d));
    }

    private static boolean ajN() {
        return Build.VERSION.SDK_INT >= 19;
    }

    private void a(InputStream inputStream, DecodeFormat decodeFormat, BitmapFactory.Options options) {
        if (decodeFormat == DecodeFormat.PREFER_ARGB_8888 || Build.VERSION.SDK_INT == 16) {
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            return;
        }
        boolean zHasAlpha = false;
        try {
            zHasAlpha = com.kwad.sdk.glide.load.b.a(this.bQG, inputStream, this.bQO).hasAlpha();
        } catch (IOException e) {
            if (Log.isLoggable("WebpDownsampler", 3)) {
                Log.d("WebpDownsampler", "Cannot determine whether the image has alpha or not from header, format " + decodeFormat, e);
            }
        }
        options.inPreferredConfig = zHasAlpha ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
        if (options.inPreferredConfig == Bitmap.Config.RGB_565 || options.inPreferredConfig == Bitmap.Config.ARGB_4444 || options.inPreferredConfig == Bitmap.Config.ALPHA_8) {
            options.inDither = true;
        }
    }

    private static int[] a(InputStream inputStream, BitmapFactory.Options options, k.a aVar, com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar) throws IOException {
        options.inJustDecodeBounds = true;
        b(inputStream, options, aVar, eVar);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:?, code lost:
    
        throw r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.graphics.Bitmap b(java.io.InputStream r6, android.graphics.BitmapFactory.Options r7, com.kwad.sdk.glide.load.resource.bitmap.k.a r8, com.kwad.sdk.glide.load.engine.bitmap_recycle.e r9) throws java.io.IOException {
        /*
            java.lang.String r0 = "WebpDownsampler"
            boolean r1 = r7.inJustDecodeBounds
            if (r1 == 0) goto Lc
            r1 = 10485760(0xa00000, float:1.469368E-38)
            r6.mark(r1)
            goto Lf
        Lc:
            r8.ahN()
        Lf:
            int r1 = r7.outWidth
            int r2 = r7.outHeight
            java.lang.String r3 = r7.outMimeType
            java.util.concurrent.locks.Lock r4 = com.kwad.sdk.glide.load.resource.bitmap.v.ahU()
            r4.lock()
            r4 = 0
            android.graphics.Bitmap r8 = com.kwad.sdk.glide.webp.WebpBitmapFactory.decodeStream(r6, r4, r7)     // Catch: java.lang.Throwable -> L30 java.lang.IllegalArgumentException -> L32
            java.util.concurrent.locks.Lock r9 = com.kwad.sdk.glide.load.resource.bitmap.v.ahU()
            r9.unlock()
            boolean r7 = r7.inJustDecodeBounds
            if (r7 == 0) goto L2f
            r6.reset()
        L2f:
            return r8
        L30:
            r6 = move-exception
            goto L5f
        L32:
            r5 = move-exception
            java.io.IOException r1 = a(r5, r1, r2, r3, r7)     // Catch: java.lang.Throwable -> L30
            r2 = 3
            boolean r2 = android.util.Log.isLoggable(r0, r2)     // Catch: java.lang.Throwable -> L30
            if (r2 == 0) goto L43
            java.lang.String r2 = "Failed to decode with inBitmap, trying again without Bitmap re-use"
            android.util.Log.d(r0, r2, r1)     // Catch: java.lang.Throwable -> L30
        L43:
            android.graphics.Bitmap r0 = r7.inBitmap     // Catch: java.lang.Throwable -> L30
            if (r0 == 0) goto L5e
            r6.reset()     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L5d
            android.graphics.Bitmap r0 = r7.inBitmap     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L5d
            r9.e(r0)     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L5d
            r7.inBitmap = r4     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L5d
            android.graphics.Bitmap r6 = b(r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L5d
            java.util.concurrent.locks.Lock r7 = com.kwad.sdk.glide.load.resource.bitmap.v.ahU()
            r7.unlock()
            return r6
        L5d:
            throw r1     // Catch: java.lang.Throwable -> L30
        L5e:
            throw r1     // Catch: java.lang.Throwable -> L30
        L5f:
            java.util.concurrent.locks.Lock r7 = com.kwad.sdk.glide.load.resource.bitmap.v.ahU()
            r7.unlock()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.glide.webp.decoder.j.b(java.io.InputStream, android.graphics.BitmapFactory$Options, com.kwad.sdk.glide.load.resource.bitmap.k$a, com.kwad.sdk.glide.load.engine.bitmap_recycle.e):android.graphics.Bitmap");
    }

    private static boolean a(BitmapFactory.Options options) {
        return options.inTargetDensity > 0 && options.inDensity > 0 && options.inTargetDensity != options.inDensity;
    }

    private static void a(int i, int i2, String str, BitmapFactory.Options options, Bitmap bitmap, int i3, int i4, long j) {
        Log.v("WebpDownsampler", "Decoded " + h(bitmap) + " from [" + i + "x" + i2 + "] " + str + " with inBitmap " + b(options) + " for [" + i3 + "x" + i4 + "], sample size: " + options.inSampleSize + ", density: " + options.inDensity + ", target density: " + options.inTargetDensity + ", thread: " + Thread.currentThread().getName() + ", duration: " + com.kwad.sdk.glide.e.f.bq(j));
    }

    private static String b(BitmapFactory.Options options) {
        return h(options.inBitmap);
    }

    private static String h(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        return "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig() + (Build.VERSION.SDK_INT >= 19 ? " (" + bitmap.getAllocationByteCount() + ")" : "");
    }

    private static IOException a(IllegalArgumentException illegalArgumentException, int i, int i2, String str, BitmapFactory.Options options) {
        return new IOException("Exception decoding bitmap, outWidth: " + i + ", outHeight: " + i2 + ", outMimeType: " + str + ", inBitmap: " + b(options), illegalArgumentException);
    }

    private static void a(BitmapFactory.Options options, com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar, int i, int i2) {
        if (Build.VERSION.SDK_INT < 26 || options.inPreferredConfig != Bitmap.Config.HARDWARE) {
            options.inBitmap = eVar.g(i, i2, options.inPreferredConfig);
        }
    }

    private static synchronized BitmapFactory.Options ahM() {
        BitmapFactory.Options optionsPoll;
        Queue<BitmapFactory.Options> queue = bXy;
        synchronized (queue) {
            optionsPoll = queue.poll();
        }
        if (optionsPoll == null) {
            optionsPoll = new BitmapFactory.Options();
            d(optionsPoll);
        }
        return optionsPoll;
    }

    private static void c(BitmapFactory.Options options) {
        d(options);
        Queue<BitmapFactory.Options> queue = bXy;
        synchronized (queue) {
            queue.offer(options);
        }
    }

    private static void d(BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.inDensity = 0;
        options.inTargetDensity = 0;
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }
}
