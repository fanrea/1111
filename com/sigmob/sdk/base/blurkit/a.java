package com.sigmob.sdk.base.blurkit;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Build;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.view.View;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class a {
    private static final float a = 1.0f;
    private static a b;
    private static RenderScript c;

    private Bitmap a(Bitmap src, float downscaleFactor) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap((int) (src.getWidth() * downscaleFactor), (int) (src.getHeight() * downscaleFactor), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Matrix matrix = new Matrix();
        matrix.preScale(downscaleFactor, downscaleFactor);
        canvas.setMatrix(matrix);
        canvas.drawBitmap(src, 0.0f, 0.0f, (Paint) null);
        return bitmapCreateBitmap;
    }

    private Bitmap a(View src) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(src.getWidth(), src.getHeight(), Bitmap.Config.ARGB_8888);
        src.draw(new Canvas(bitmapCreateBitmap));
        return bitmapCreateBitmap;
    }

    private Bitmap a(View src, float downscaleFactor) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap((int) (src.getWidth() * downscaleFactor), (int) (src.getHeight() * downscaleFactor), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Matrix matrix = new Matrix();
        matrix.preScale(downscaleFactor, downscaleFactor);
        canvas.setMatrix(matrix);
        src.draw(canvas);
        return bitmapCreateBitmap;
    }

    public static a a() {
        a aVar = b;
        if (aVar != null) {
            return aVar;
        }
        throw new RuntimeException("BlurKit not initialized!");
    }

    public static void a(Context context) {
        if (b != null) {
            return;
        }
        b = new a();
        c = RenderScript.create(context.getApplicationContext());
    }

    public Bitmap a(Bitmap src, int radius) {
        try {
            Allocation allocationCreateFromBitmap = Allocation.createFromBitmap(c, src);
            Allocation allocationCreateTyped = Allocation.createTyped(c, allocationCreateFromBitmap.getType());
            if (Build.VERSION.SDK_INT >= 17) {
                RenderScript renderScript = c;
                ScriptIntrinsicBlur scriptIntrinsicBlurCreate = ScriptIntrinsicBlur.create(renderScript, Element.U8_4(renderScript));
                scriptIntrinsicBlurCreate.setRadius(radius);
                scriptIntrinsicBlurCreate.setInput(allocationCreateFromBitmap);
                scriptIntrinsicBlurCreate.forEach(allocationCreateTyped);
            }
            allocationCreateTyped.copyTo(src);
        } catch (Throwable unused) {
        }
        return src;
    }

    public Bitmap a(Bitmap src, int radius, float downscaleFactor) {
        return a(a(src, downscaleFactor), radius);
    }

    public Bitmap a(View src, int radius) {
        return a(a(src), radius);
    }

    public Bitmap a(View src, int radius, float downscaleFactor) {
        return a(a(src, downscaleFactor), radius);
    }
}
