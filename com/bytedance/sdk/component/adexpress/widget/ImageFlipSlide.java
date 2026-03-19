package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.view.View;
import com.bytedance.sdk.component.adexpress.c.hc;
import com.bytedance.sdk.component.an.cb;
import com.bytedance.sdk.component.an.gb;
import com.bytedance.sdk.component.an.mk;
import com.bytedance.sdk.component.an.tc;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class ImageFlipSlide extends View {
    private final Rect an;
    private Bitmap b;
    private List<String> c;
    Paint d;
    private final boolean gb;
    private final Rect h;
    private float hc;
    private Path u;

    public ImageFlipSlide(Context context, boolean z) {
        super(context);
        this.hc = 0.1f;
        this.an = new Rect();
        this.h = new Rect();
        this.gb = z;
    }

    public void d(String str, String str2, List<String> list) {
        final tc tcVarHc = com.bytedance.sdk.component.adexpress.d.d.d.d().u().d(str).hc(str2);
        this.c = list;
        tcVarHc.d(Bitmap.Config.ARGB_4444).b(2);
        if (getBlurPx() != 0) {
            tcVarHc.d(new gb() { // from class: com.bytedance.sdk.component.adexpress.widget.ImageFlipSlide.1
                @Override // com.bytedance.sdk.component.an.gb
                @ATSMethod(1)
                public Bitmap d(Bitmap bitmap) {
                    try {
                        return hc.d(ImageFlipSlide.this.getContext(), bitmap, ImageFlipSlide.this.getBlurPx());
                    } catch (Exception unused) {
                        return bitmap;
                    }
                }
            });
        }
        post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.ImageFlipSlide.2
            @Override // java.lang.Runnable
            public void run() {
                tcVarHc.d(new cb<Bitmap>() { // from class: com.bytedance.sdk.component.adexpress.widget.ImageFlipSlide.2.1
                    @Override // com.bytedance.sdk.component.an.cb
                    @ATSMethod(2)
                    public void d(int i, String str3, Throwable th) {
                    }

                    @Override // com.bytedance.sdk.component.an.cb
                    @ATSMethod(1)
                    public void d(mk<Bitmap> mkVar) {
                        try {
                            ImageFlipSlide.this.b = ImageFlipSlide.this.d(mkVar.b(), ImageFlipSlide.this.getWidth(), ImageFlipSlide.this.getHeight());
                        } catch (Exception unused) {
                        }
                        ImageFlipSlide.this.invalidate();
                    }
                });
            }
        });
        Paint paint = new Paint();
        this.d = paint;
        paint.setAntiAlias(true);
        this.d.setDither(true);
        if (this.gb) {
            this.d.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        }
        List<String> list2 = this.c;
        if (list2 == null || list2.size() <= 0) {
            return;
        }
        ColorMatrix colorMatrix = new ColorMatrix();
        for (int i = 0; i < this.c.size(); i++) {
            d(colorMatrix, this.c.get(i));
        }
        this.d.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
    }

    private void d(ColorMatrix colorMatrix, String str) {
        try {
            ColorMatrix colorMatrix2 = new ColorMatrix();
            if (str.startsWith("hue-rotate")) {
                colorMatrix2.setRotate(0, Integer.parseInt(str.split("\\(")[1].split("deg")[0]));
            } else if (str.startsWith("grayscale") || str.startsWith("contrast")) {
                colorMatrix2.setSaturation(Integer.parseInt(str.split("\\(")[1].split("%")[0]) / 100.0f);
            } else if (str.startsWith("invert")) {
                float f = (Integer.parseInt(str.split("\\(")[1].split("%")[0]) / 100.0f) * 255.0f;
                colorMatrix2.set(new float[]{-1.0f, 0.0f, 0.0f, 0.0f, f, 0.0f, -1.0f, 0.0f, 0.0f, f, 0.0f, 0.0f, -1.0f, 0.0f, f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f});
            } else if (str.startsWith("sepia")) {
                float f2 = Integer.parseInt(str.split("\\(")[1].split("%")[0]) / 100.0f;
                colorMatrix2.setScale(f2, f2, 1.0f, 1.0f);
            } else if (str.startsWith("brightness")) {
                float f3 = Integer.parseInt(str.split("\\(")[1].split("%")[0]) / 100.0f;
                colorMatrix2.setScale(f3, f3, f3, 1.0f);
            }
            colorMatrix.postConcat(colorMatrix2);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getBlurPx() {
        if (this.c == null) {
            return 0;
        }
        for (int i = 0; i < this.c.size(); i++) {
            if (this.c.get(i).contains("blur")) {
                return Integer.parseInt(this.c.get(i).split("\\(")[1].split("px")[0]);
            }
        }
        return 0;
    }

    public void d(float f) {
        this.hc = f;
        invalidate();
    }

    public void d(Path path) {
        this.u = path;
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.b == null) {
            return;
        }
        if (this.gb) {
            this.an.left = (int) (r0.getWidth() * (1.0f - this.hc));
            this.an.right = this.b.getWidth();
            this.an.top = 0;
            this.an.bottom = this.b.getHeight();
            this.h.left = (int) (getWidth() * (1.0f - this.hc));
            this.h.right = getWidth();
            this.h.top = 0;
            this.h.bottom = getHeight();
            canvas.drawBitmap(this.b, this.an, this.h, this.d);
            return;
        }
        canvas.clipPath(this.u);
        canvas.drawBitmap(this.b, 0.0f, 0.0f, this.d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap d(Bitmap bitmap, int i, int i2) {
        int i3;
        int i4;
        int i5;
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float f = i;
        float f2 = (width * 1.0f) / f;
        float f3 = i2;
        float f4 = (height * 1.0f) / f3;
        Matrix matrix = new Matrix();
        int i6 = 0;
        if (f4 > f2) {
            int i7 = (int) (f3 * f2);
            float f5 = 1.0f / f2;
            matrix.setScale(f5, f5);
            i4 = i7;
            i3 = width;
            i5 = (height / 2) - (i7 / 2);
        } else {
            int i8 = (int) (f * f4);
            float f6 = 1.0f / f4;
            matrix.setScale(f6, f6);
            i3 = i8;
            i4 = height;
            i5 = 0;
            i6 = (width / 2) - (i8 / 2);
        }
        return Bitmap.createBitmap(bitmap, i6, i5, i3, i4, matrix, false);
    }
}
