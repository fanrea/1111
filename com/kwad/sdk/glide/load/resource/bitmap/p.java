package com.kwad.sdk.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;
import java.security.MessageDigest;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class p extends e {
    private final String ID = "GlideCircleBorderTransform";
    private int aLn;
    private Paint bXD;
    private float bXE;

    @Override // com.kwad.sdk.glide.load.c
    public final int hashCode() {
        return 787397419;
    }

    public p(float f, int i) {
        this.bXE = f;
        this.aLn = i;
        Paint paint = new Paint();
        this.bXD = paint;
        paint.setColor(this.aLn);
        this.bXD.setStyle(Paint.Style.STROKE);
        this.bXD.setAntiAlias(true);
        this.bXD.setStrokeWidth(f);
        this.bXD.setDither(true);
    }

    private Bitmap c(com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar, Bitmap bitmap) {
        int iMin = Math.min(bitmap.getWidth(), bitmap.getHeight());
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, (bitmap.getWidth() - iMin) / 2, (bitmap.getHeight() - iMin) / 2, iMin, iMin);
        Bitmap bitmapB = eVar.b(iMin, iMin, Bitmap.Config.ARGB_8888);
        if (bitmapB == null) {
            bitmapB = Bitmap.createBitmap(iMin, iMin, Bitmap.Config.ARGB_8888);
        }
        Canvas canvas = new Canvas(bitmapB);
        Paint paint = new Paint();
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        paint.setShader(new BitmapShader(bitmapCreateBitmap, tileMode, tileMode));
        paint.setAntiAlias(true);
        float f = iMin / 2.0f;
        canvas.drawCircle(f, f, f, paint);
        canvas.drawCircle(f, f, f - (this.bXE / 2.0f), this.bXD);
        return bitmapB;
    }

    @Override // com.kwad.sdk.glide.load.c
    public final void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update("GlideCircleBorderTransform".getBytes(bRy));
    }

    @Override // com.kwad.sdk.glide.load.c
    public final boolean equals(Object obj) {
        return obj instanceof p;
    }

    @Override // com.kwad.sdk.glide.load.resource.bitmap.e
    protected final Bitmap transform(com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar, Bitmap bitmap, int i, int i2) {
        return c(eVar, bitmap);
    }
}
