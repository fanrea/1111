package com.sigmob.sdk.base.views;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class ab extends Drawable {
    private static final int i = 1;
    private final Paint a;
    private final int b;
    private final int c;
    private final int d;
    private final int e;
    private final int f;
    private final int[] g;
    private RectF h;

    public static class a {
        private int a = 1;
        private int b = 12;
        private int c = Color.parseColor("#4d000000");
        private int d = 18;
        private int e = 0;
        private int f = 0;
        private int[] g = {0};

        a() {
        }

        a a(int mShape) {
            this.a = mShape;
            return this;
        }

        a a(int[] BgColor) {
            this.g = BgColor;
            return this;
        }

        ab a() {
            return new ab(this.a, this.g, this.b, this.c, this.d, this.e, this.f);
        }

        a b(int ShapeRadius) {
            this.b = ShapeRadius;
            return this;
        }

        a c(int shadowColor) {
            this.c = shadowColor;
            return this;
        }

        a d(int shadowRadius) {
            this.d = shadowRadius;
            return this;
        }

        a e(int OffsetX) {
            this.e = OffsetX;
            return this;
        }

        a f(int OffsetY) {
            this.f = OffsetY;
            return this;
        }

        a g(int BgColor) {
            this.g[0] = BgColor;
            return this;
        }
    }

    private ab(int shape, int[] bgColor, int shapeRadius, int shadowColor, int shadowRadius, int offsetX, int offsetY) {
        this.c = shape;
        this.g = bgColor;
        this.d = shapeRadius;
        this.b = shadowRadius;
        this.e = offsetX;
        this.f = offsetY;
        Paint paint = new Paint();
        this.a = paint;
        paint.setColor(0);
        paint.setAntiAlias(true);
        paint.setShadowLayer(shadowRadius, offsetX, offsetY, shadowColor);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
    }

    public static void a(View view, int bgColor, int shapeRadius, int shadowColor, int shadowRadius, int offsetX, int offsetY) {
        ab abVarA = new a().g(bgColor).b(shapeRadius).c(shadowColor).d(shadowRadius).e(offsetX).f(offsetY).a();
        view.setLayerType(1, null);
        if (Build.VERSION.SDK_INT >= 16) {
            view.setBackground(abVarA);
        } else {
            view.setBackgroundDrawable(abVarA);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Paint paint = new Paint();
        int[] iArr = this.g;
        if (iArr != null) {
            if (iArr.length == 1) {
                paint.setColor(iArr[0]);
            } else {
                paint.setShader(new LinearGradient(this.h.left, this.h.height() / 2.0f, this.h.right, this.h.height() / 2.0f, this.g, (float[]) null, Shader.TileMode.CLAMP));
            }
        }
        paint.setAntiAlias(true);
        if (this.c != 1) {
            canvas.drawCircle(this.h.centerX(), this.h.centerY(), Math.min(this.h.width(), this.h.height()) / 2.0f, this.a);
            canvas.drawCircle(this.h.centerX(), this.h.centerY(), Math.min(this.h.width(), this.h.height()) / 2.0f, paint);
            return;
        }
        RectF rectF = this.h;
        int i2 = this.d;
        canvas.drawRoundRect(rectF, i2, i2, this.a);
        RectF rectF2 = this.h;
        int i3 = this.d;
        canvas.drawRoundRect(rectF2, i3, i3, paint);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        this.a.setAlpha(alpha);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int left, int top, int right, int bottom) {
        super.setBounds(left, top, right, bottom);
        int i2 = this.b;
        int i3 = this.e;
        int i4 = this.f;
        this.h = new RectF((left + i2) - i3, (top + i2) - i4, (right - i2) - i3, (bottom - i2) - i4);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.a.setColorFilter(colorFilter);
    }
}
