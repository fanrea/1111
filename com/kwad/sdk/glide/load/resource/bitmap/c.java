package com.kwad.sdk.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.kwad.sdk.glide.load.EncodeStrategy;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class c implements com.kwad.sdk.glide.load.h<Bitmap> {
    public static final com.kwad.sdk.glide.load.e<Integer> bXd = com.kwad.sdk.glide.load.e.c("com.kwad.sdk.glide.load.resource.bitmap.BitmapEncoder.CompressionQuality", 90);
    public static final com.kwad.sdk.glide.load.e<Bitmap.CompressFormat> bXe = com.kwad.sdk.glide.load.e.hi("com.kwad.sdk.glide.load.resource.bitmap.BitmapEncoder.CompressionFormat");
    private final com.kwad.sdk.glide.load.engine.bitmap_recycle.b bPD;

    public c(com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar) {
        this.bPD = bVar;
    }

    @Deprecated
    public c() {
        this.bPD = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0064 A[Catch: all -> 0x00b5, TryCatch #1 {, blocks: (B:3:0x001a, B:13:0x0043, B:28:0x005e, B:30:0x0064, B:32:0x00b1, B:33:0x00b4), top: B:36:0x001a }] */
    @Override // com.kwad.sdk.glide.load.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(com.kwad.sdk.glide.load.engine.s<android.graphics.Bitmap> r9, java.io.File r10, com.kwad.sdk.glide.load.f r11) {
        /*
            r8 = this;
            java.lang.String r0 = "BitmapEncoder"
            java.lang.Object r9 = r9.get()
            android.graphics.Bitmap r9 = (android.graphics.Bitmap) r9
            android.graphics.Bitmap$CompressFormat r1 = a(r9, r11)
            int r2 = r9.getWidth()
            java.lang.Integer.valueOf(r2)
            int r2 = r9.getHeight()
            java.lang.Integer.valueOf(r2)
            long r2 = com.kwad.sdk.glide.e.f.ajA()     // Catch: java.lang.Throwable -> Lb5
            com.kwad.sdk.glide.load.e<java.lang.Integer> r4 = com.kwad.sdk.glide.load.resource.bitmap.c.bXd     // Catch: java.lang.Throwable -> Lb5
            java.lang.Object r4 = r11.a(r4)     // Catch: java.lang.Throwable -> Lb5
            java.lang.Integer r4 = (java.lang.Integer) r4     // Catch: java.lang.Throwable -> Lb5
            int r4 = r4.intValue()     // Catch: java.lang.Throwable -> Lb5
            r5 = 0
            r6 = 0
            java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L4d java.io.IOException -> L4f
            r7.<init>(r10)     // Catch: java.lang.Throwable -> L4d java.io.IOException -> L4f
            com.kwad.sdk.glide.load.engine.bitmap_recycle.b r10 = r8.bPD     // Catch: java.lang.Throwable -> L47 java.io.IOException -> L4a
            if (r10 == 0) goto L3e
            com.kwad.sdk.glide.load.a.c r10 = new com.kwad.sdk.glide.load.a.c     // Catch: java.lang.Throwable -> L47 java.io.IOException -> L4a
            com.kwad.sdk.glide.load.engine.bitmap_recycle.b r6 = r8.bPD     // Catch: java.lang.Throwable -> L47 java.io.IOException -> L4a
            r10.<init>(r7, r6)     // Catch: java.lang.Throwable -> L47 java.io.IOException -> L4a
            r6 = r10
            goto L3f
        L3e:
            r6 = r7
        L3f:
            r9.compress(r1, r4, r6)     // Catch: java.lang.Throwable -> L4d java.io.IOException -> L4f
            r5 = 1
        L43:
            com.kwad.sdk.crash.utils.b.closeQuietly(r6)     // Catch: java.lang.Throwable -> Lb5
            goto L5d
        L47:
            r9 = move-exception
            r6 = r7
            goto Lb1
        L4a:
            r10 = move-exception
            r6 = r7
            goto L50
        L4d:
            r9 = move-exception
            goto Lb1
        L4f:
            r10 = move-exception
        L50:
            r4 = 3
            boolean r4 = android.util.Log.isLoggable(r0, r4)     // Catch: java.lang.Throwable -> L4d
            if (r4 == 0) goto L43
            java.lang.String r4 = "Failed to encode Bitmap"
            android.util.Log.d(r0, r4, r10)     // Catch: java.lang.Throwable -> L4d
            goto L43
        L5d:
            r10 = 2
            boolean r10 = android.util.Log.isLoggable(r0, r10)     // Catch: java.lang.Throwable -> Lb5
            if (r10 == 0) goto Lb0
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lb5
            java.lang.String r4 = "Compressed with type: "
            r10.<init>(r4)     // Catch: java.lang.Throwable -> Lb5
            java.lang.StringBuilder r10 = r10.append(r1)     // Catch: java.lang.Throwable -> Lb5
            java.lang.String r1 = " of size "
            java.lang.StringBuilder r10 = r10.append(r1)     // Catch: java.lang.Throwable -> Lb5
            int r1 = com.kwad.sdk.glide.e.j.m(r9)     // Catch: java.lang.Throwable -> Lb5
            java.lang.StringBuilder r10 = r10.append(r1)     // Catch: java.lang.Throwable -> Lb5
            java.lang.String r1 = " in "
            java.lang.StringBuilder r10 = r10.append(r1)     // Catch: java.lang.Throwable -> Lb5
            double r1 = com.kwad.sdk.glide.e.f.bq(r2)     // Catch: java.lang.Throwable -> Lb5
            java.lang.StringBuilder r10 = r10.append(r1)     // Catch: java.lang.Throwable -> Lb5
            java.lang.String r1 = ", options format: "
            java.lang.StringBuilder r10 = r10.append(r1)     // Catch: java.lang.Throwable -> Lb5
            com.kwad.sdk.glide.load.e<android.graphics.Bitmap$CompressFormat> r1 = com.kwad.sdk.glide.load.resource.bitmap.c.bXe     // Catch: java.lang.Throwable -> Lb5
            java.lang.Object r11 = r11.a(r1)     // Catch: java.lang.Throwable -> Lb5
            java.lang.StringBuilder r10 = r10.append(r11)     // Catch: java.lang.Throwable -> Lb5
            java.lang.String r11 = ", hasAlpha: "
            java.lang.StringBuilder r10 = r10.append(r11)     // Catch: java.lang.Throwable -> Lb5
            boolean r9 = r9.hasAlpha()     // Catch: java.lang.Throwable -> Lb5
            java.lang.StringBuilder r9 = r10.append(r9)     // Catch: java.lang.Throwable -> Lb5
            java.lang.String r9 = r9.toString()     // Catch: java.lang.Throwable -> Lb5
            android.util.Log.v(r0, r9)     // Catch: java.lang.Throwable -> Lb5
        Lb0:
            return r5
        Lb1:
            com.kwad.sdk.crash.utils.b.closeQuietly(r6)     // Catch: java.lang.Throwable -> Lb5
            throw r9     // Catch: java.lang.Throwable -> Lb5
        Lb5:
            r9 = move-exception
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.glide.load.resource.bitmap.c.a(com.kwad.sdk.glide.load.engine.s, java.io.File, com.kwad.sdk.glide.load.f):boolean");
    }

    private static Bitmap.CompressFormat a(Bitmap bitmap, com.kwad.sdk.glide.load.f fVar) {
        Bitmap.CompressFormat compressFormat = (Bitmap.CompressFormat) fVar.a(bXe);
        if (compressFormat != null) {
            return compressFormat;
        }
        if (bitmap.hasAlpha()) {
            return Bitmap.CompressFormat.PNG;
        }
        return Bitmap.CompressFormat.JPEG;
    }

    @Override // com.kwad.sdk.glide.load.h
    public final EncodeStrategy b(com.kwad.sdk.glide.load.f fVar) {
        return EncodeStrategy.TRANSFORMED;
    }
}
