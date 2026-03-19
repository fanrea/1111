package com.kwad.components.ct.home.f;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import com.kwad.sdk.glide.c;
import com.kwad.sdk.glide.load.engine.bitmap_recycle.e;
import com.kwad.sdk.glide.load.engine.s;
import com.kwad.sdk.glide.load.i;
import com.kwad.sdk.glide.load.resource.bitmap.d;
import java.security.MessageDigest;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a implements i<Bitmap> {
    private e aLk;
    private int aLn;
    private int mRadius;
    private int aLl = 0;
    private int aLm = 1;
    private int aLo = 15;

    @Override // com.kwad.sdk.glide.load.c
    public final void updateDiskCacheKey(MessageDigest messageDigest) {
    }

    public a(Context context, int i, int i2, int i3, int i4, int i5) {
        this.aLk = c.cv(context).aeZ();
        this.mRadius = i;
        this.aLn = i4;
    }

    @Override // com.kwad.sdk.glide.load.i
    public final s<Bitmap> transform(Context context, s<Bitmap> sVar, int i, int i2) {
        Bitmap bitmap = sVar.get();
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap bitmapB = this.aLk.b(width, height, Bitmap.Config.ARGB_8888);
        if (bitmapB == null) {
            bitmapB = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        }
        Canvas canvas = new Canvas(bitmapB);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        paint.setShader(new BitmapShader(bitmap, tileMode, tileMode));
        Paint paint2 = new Paint(1);
        paint2.setColor(this.aLn);
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setStrokeWidth(this.aLm);
        a(canvas, paint, width, height, paint2);
        return d.a(bitmapB, this.aLk);
    }

    private void a(Canvas canvas, Paint paint, float f, float f2, Paint paint2) {
        int i = this.aLl;
        float f3 = f - i;
        float f4 = f2 - i;
        float f5 = this.aLm / 2;
        Path path = new Path();
        float[] fArr = new float[8];
        int i2 = this.aLo;
        for (int i3 = 3; i3 >= 0; i3--) {
            int i4 = i3 * 2;
            int i5 = i2 & 1;
            float f6 = 0.0f;
            fArr[i4 + 1] = i5 > 0 ? this.mRadius : 0.0f;
            if (i5 > 0) {
                f6 = this.mRadius;
            }
            fArr[i4] = f6;
            i2 >>= 1;
        }
        int i6 = this.aLl;
        path.addRoundRect(new RectF(i6 + f5, i6 + f5, f3 - f5, f4 - f5), fArr, Path.Direction.CW);
        canvas.drawPath(path, paint);
        canvas.drawPath(path, paint2);
    }
}
