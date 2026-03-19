package com.bytedance.adsdk.ugeno.widget.image;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.widget.ImageView;
import com.bytedance.sdk.component.utils.mq;
import java.util.HashSet;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d extends Drawable {
    private final int an;
    private final RectF b;
    private final Bitmap c;
    private final boolean[] cb;
    private float e;
    private final RectF gb;
    private final int h;
    private ImageView.ScaleType jh;
    private boolean k;
    private final RectF mk;
    private Shader.TileMode mq;
    private ColorStateList rf;
    private final Matrix tc;
    private final Paint tt;
    private final Paint u;
    private Shader.TileMode uo;
    private boolean w;
    private float yo;
    private final RectF d = new RectF();
    private final RectF hc = new RectF();

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public d(Bitmap bitmap) {
        RectF rectF = new RectF();
        this.b = rectF;
        this.gb = new RectF();
        this.tc = new Matrix();
        this.mk = new RectF();
        this.mq = Shader.TileMode.CLAMP;
        this.uo = Shader.TileMode.CLAMP;
        this.k = true;
        this.e = 0.0f;
        this.cb = new boolean[]{true, true, true, true};
        this.w = false;
        this.yo = 0.0f;
        this.rf = ColorStateList.valueOf(-16777216);
        this.jh = ImageView.ScaleType.FIT_CENTER;
        this.c = bitmap;
        int width = bitmap.getWidth();
        this.an = width;
        int height = bitmap.getHeight();
        this.h = height;
        rectF.set(0.0f, 0.0f, width, height);
        Paint paint = new Paint();
        this.u = paint;
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.tt = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setAntiAlias(true);
        paint2.setColor(this.rf.getColorForState(getState(), -16777216));
        paint2.setStrokeWidth(this.yo);
    }

    public static d d(Bitmap bitmap) {
        if (bitmap != null) {
            return new d(bitmap);
        }
        return null;
    }

    public static Drawable d(Drawable drawable) {
        if (drawable != null) {
            if (drawable instanceof d) {
                return drawable;
            }
            if (Build.VERSION.SDK_INT >= 28 && (drawable instanceof AnimatedImageDrawable)) {
                return drawable;
            }
            if (drawable instanceof LayerDrawable) {
                Drawable.ConstantState constantState = drawable.mutate().getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                int numberOfLayers = layerDrawable.getNumberOfLayers();
                for (int i = 0; i < numberOfLayers; i++) {
                    layerDrawable.setDrawableByLayerId(layerDrawable.getId(i), d(layerDrawable.getDrawable(i)));
                }
                return layerDrawable;
            }
        }
        Bitmap bitmapHc = hc(drawable);
        return bitmapHc != null ? new d(bitmapHc) : drawable;
    }

    public static Bitmap hc(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(Math.max(drawable.getIntrinsicWidth(), 2), Math.max(drawable.getIntrinsicHeight(), 2), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return bitmapCreateBitmap;
        } catch (Throwable th) {
            mq.d(th);
            mq.hc("RoundedDrawable", "Failed to create bitmap from drawable!");
            return null;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.rf.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        int colorForState = this.rf.getColorForState(iArr, 0);
        if (this.tt.getColor() != colorForState) {
            this.tt.setColor(colorForState);
            return true;
        }
        return super.onStateChange(iArr);
    }

    /* renamed from: com.bytedance.adsdk.ugeno.widget.image.d$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] d;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            d = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                d[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                d[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                d[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                d[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                d[ImageView.ScaleType.FIT_START.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                d[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    private void d() {
        float fWidth;
        float fHeight;
        int i = AnonymousClass1.d[this.jh.ordinal()];
        if (i == 1) {
            this.gb.set(this.d);
            RectF rectF = this.gb;
            float f = this.yo;
            rectF.inset(f / 2.0f, f / 2.0f);
            this.tc.reset();
            this.tc.setTranslate((int) (((this.gb.width() - this.an) * 0.5f) + 0.5f), (int) (((this.gb.height() - this.h) * 0.5f) + 0.5f));
        } else if (i == 2) {
            this.gb.set(this.d);
            RectF rectF2 = this.gb;
            float f2 = this.yo;
            rectF2.inset(f2 / 2.0f, f2 / 2.0f);
            this.tc.reset();
            float fWidth2 = 0.0f;
            if (this.an * this.gb.height() > this.gb.width() * this.h) {
                fWidth = this.gb.height() / this.h;
                fHeight = 0.0f;
                fWidth2 = (this.gb.width() - (this.an * fWidth)) * 0.5f;
            } else {
                fWidth = this.gb.width() / this.an;
                fHeight = (this.gb.height() - (this.h * fWidth)) * 0.5f;
            }
            this.tc.setScale(fWidth, fWidth);
            Matrix matrix = this.tc;
            float f3 = this.yo;
            matrix.postTranslate(((int) (fWidth2 + 0.5f)) + (f3 / 2.0f), ((int) (fHeight + 0.5f)) + (f3 / 2.0f));
        } else if (i == 3) {
            this.tc.reset();
            float fMin = (((float) this.an) > this.d.width() || ((float) this.h) > this.d.height()) ? Math.min(this.d.width() / this.an, this.d.height() / this.h) : 1.0f;
            float fWidth3 = (int) (((this.d.width() - (this.an * fMin)) * 0.5f) + 0.5f);
            float fHeight2 = (int) (((this.d.height() - (this.h * fMin)) * 0.5f) + 0.5f);
            this.tc.setScale(fMin, fMin);
            this.tc.postTranslate(fWidth3, fHeight2);
            this.gb.set(this.b);
            this.tc.mapRect(this.gb);
            RectF rectF3 = this.gb;
            float f4 = this.yo;
            rectF3.inset(f4 / 2.0f, f4 / 2.0f);
            this.tc.setRectToRect(this.b, this.gb, Matrix.ScaleToFit.FILL);
        } else if (i == 5) {
            this.gb.set(this.b);
            this.tc.setRectToRect(this.b, this.d, Matrix.ScaleToFit.END);
            this.tc.mapRect(this.gb);
            RectF rectF4 = this.gb;
            float f5 = this.yo;
            rectF4.inset(f5 / 2.0f, f5 / 2.0f);
            this.tc.setRectToRect(this.b, this.gb, Matrix.ScaleToFit.FILL);
        } else if (i == 6) {
            this.gb.set(this.b);
            this.tc.setRectToRect(this.b, this.d, Matrix.ScaleToFit.START);
            this.tc.mapRect(this.gb);
            RectF rectF5 = this.gb;
            float f6 = this.yo;
            rectF5.inset(f6 / 2.0f, f6 / 2.0f);
            this.tc.setRectToRect(this.b, this.gb, Matrix.ScaleToFit.FILL);
        } else if (i != 7) {
            this.gb.set(this.b);
            this.tc.setRectToRect(this.b, this.d, Matrix.ScaleToFit.CENTER);
            this.tc.mapRect(this.gb);
            RectF rectF6 = this.gb;
            float f7 = this.yo;
            rectF6.inset(f7 / 2.0f, f7 / 2.0f);
            this.tc.setRectToRect(this.b, this.gb, Matrix.ScaleToFit.FILL);
        } else {
            this.gb.set(this.d);
            RectF rectF7 = this.gb;
            float f8 = this.yo;
            rectF7.inset(f8 / 2.0f, f8 / 2.0f);
            this.tc.reset();
            this.tc.setRectToRect(this.b, this.gb, Matrix.ScaleToFit.FILL);
        }
        this.hc.set(this.gb);
        this.k = true;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.d.set(rect);
        d();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.k) {
            BitmapShader bitmapShader = new BitmapShader(this.c, this.mq, this.uo);
            if (this.mq == Shader.TileMode.CLAMP && this.uo == Shader.TileMode.CLAMP) {
                bitmapShader.setLocalMatrix(this.tc);
            }
            this.u.setShader(bitmapShader);
            this.k = false;
        }
        if (this.w) {
            if (this.yo > 0.0f) {
                canvas.drawOval(this.hc, this.u);
                canvas.drawOval(this.gb, this.tt);
                return;
            } else {
                canvas.drawOval(this.hc, this.u);
                return;
            }
        }
        if (d(this.cb)) {
            float f = this.e;
            if (this.yo > 0.0f) {
                canvas.drawRoundRect(this.hc, f, f, this.u);
                canvas.drawRoundRect(this.gb, f, f, this.tt);
                d(canvas);
                hc(canvas);
                return;
            }
            canvas.drawRoundRect(this.hc, f, f, this.u);
            d(canvas);
            return;
        }
        canvas.drawRect(this.hc, this.u);
        if (this.yo > 0.0f) {
            canvas.drawRect(this.gb, this.tt);
        }
    }

    private void d(Canvas canvas) {
        if (hc(this.cb) || this.e == 0.0f) {
            return;
        }
        float f = this.hc.left;
        float f2 = this.hc.top;
        float fWidth = this.hc.width() + f;
        float fHeight = this.hc.height() + f2;
        float f3 = this.e;
        if (!this.cb[0]) {
            this.mk.set(f, f2, f + f3, f2 + f3);
            canvas.drawRect(this.mk, this.u);
        }
        if (!this.cb[1]) {
            this.mk.set(fWidth - f3, f2, fWidth, f3);
            canvas.drawRect(this.mk, this.u);
        }
        if (!this.cb[2]) {
            this.mk.set(fWidth - f3, fHeight - f3, fWidth, fHeight);
            canvas.drawRect(this.mk, this.u);
        }
        if (this.cb[3]) {
            return;
        }
        this.mk.set(f, fHeight - f3, f3 + f, fHeight);
        canvas.drawRect(this.mk, this.u);
    }

    private void hc(Canvas canvas) {
        if (hc(this.cb) || this.e == 0.0f) {
            return;
        }
        float f = this.hc.left;
        float f2 = this.hc.top;
        float fWidth = f + this.hc.width();
        float fHeight = f2 + this.hc.height();
        float f3 = this.e;
        float f4 = this.yo / 2.0f;
        if (!this.cb[0]) {
            canvas.drawLine(f - f4, f2, f + f3, f2, this.tt);
            canvas.drawLine(f, f2 - f4, f, f2 + f3, this.tt);
        }
        if (!this.cb[1]) {
            canvas.drawLine((fWidth - f3) - f4, f2, fWidth, f2, this.tt);
            canvas.drawLine(fWidth, f2 - f4, fWidth, f2 + f3, this.tt);
        }
        if (!this.cb[2]) {
            canvas.drawLine((fWidth - f3) - f4, fHeight, fWidth + f4, fHeight, this.tt);
            canvas.drawLine(fWidth, fHeight - f3, fWidth, fHeight, this.tt);
        }
        if (this.cb[3]) {
            return;
        }
        canvas.drawLine(f - f4, fHeight, f + f3, fHeight, this.tt);
        canvas.drawLine(f, fHeight - f3, f, fHeight, this.tt);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.u.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.u.setAlpha(i);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.u.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.u.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        this.u.setDither(z);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.u.setFilterBitmap(z);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.an;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.h;
    }

    public d d(float f, float f2, float f3, float f4) {
        HashSet hashSet = new HashSet(4);
        hashSet.add(Float.valueOf(f));
        hashSet.add(Float.valueOf(f2));
        hashSet.add(Float.valueOf(f3));
        hashSet.add(Float.valueOf(f4));
        hashSet.remove(Float.valueOf(0.0f));
        if (hashSet.size() > 1) {
            throw new IllegalArgumentException("Multiple nonzero corner radii not yet supported.");
        }
        if (!hashSet.isEmpty()) {
            float fFloatValue = ((Float) hashSet.iterator().next()).floatValue();
            if (Float.isInfinite(fFloatValue) || Float.isNaN(fFloatValue) || fFloatValue < 0.0f) {
                throw new IllegalArgumentException("Invalid radius value: ".concat(String.valueOf(fFloatValue)));
            }
            this.e = fFloatValue;
        } else {
            this.e = 0.0f;
        }
        boolean[] zArr = this.cb;
        zArr[0] = f > 0.0f;
        zArr[1] = f2 > 0.0f;
        zArr[2] = f3 > 0.0f;
        zArr[3] = f4 > 0.0f;
        return this;
    }

    public d d(float f) {
        this.yo = f;
        this.tt.setStrokeWidth(f);
        return this;
    }

    public d d(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.rf = colorStateList;
        this.tt.setColor(colorStateList.getColorForState(getState(), -16777216));
        return this;
    }

    public d d(boolean z) {
        this.w = z;
        return this;
    }

    public d d(ImageView.ScaleType scaleType) {
        if (scaleType == null) {
            scaleType = ImageView.ScaleType.FIT_CENTER;
        }
        if (this.jh != scaleType) {
            this.jh = scaleType;
            d();
        }
        return this;
    }

    public d d(Shader.TileMode tileMode) {
        if (this.mq != tileMode) {
            this.mq = tileMode;
            this.k = true;
            invalidateSelf();
        }
        return this;
    }

    public d hc(Shader.TileMode tileMode) {
        if (this.uo != tileMode) {
            this.uo = tileMode;
            this.k = true;
            invalidateSelf();
        }
        return this;
    }

    private static boolean d(boolean[] zArr) {
        for (boolean z : zArr) {
            if (z) {
                return true;
            }
        }
        return false;
    }

    private static boolean hc(boolean[] zArr) {
        for (boolean z : zArr) {
            if (z) {
                return false;
            }
        }
        return true;
    }
}
