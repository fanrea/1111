package com.kwad.sdk.core.view;

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
import android.view.View;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class d extends Drawable {
    private Paint FL;
    private RectF bKw;
    private Paint bLm;
    private int bLn;
    private int bLo;
    private int bLp;
    private int bLq;
    private int bLr;
    private int[] bLs;

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    /* synthetic */ d(int i, int[] iArr, int i2, int i3, int i4, int i5, int i6, byte b) {
        this(i, iArr, i2, i3, i4, i5, i6);
    }

    private d(int i, int[] iArr, int i2, int i3, int i4, int i5, int i6) {
        this.bLo = i;
        this.bLs = iArr;
        this.bLp = i2;
        this.bLn = i4;
        this.bLq = i5;
        this.bLr = i6;
        Paint paint = new Paint();
        this.FL = paint;
        paint.setColor(0);
        this.FL.setAntiAlias(true);
        this.FL.setShadowLayer(i4, i5, i6, i3);
        this.FL.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
        Paint paint2 = new Paint();
        this.bLm = paint2;
        paint2.setAntiAlias(true);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setBounds(int i, int i2, int i3, int i4) {
        super.setBounds(i, i2, i3, i4);
        int i5 = this.bLn;
        int i6 = this.bLq;
        int i7 = this.bLr;
        this.bKw = new RectF((i + i5) - i6, (i2 + i5) - i7, (i3 - i5) - i6, (i4 - i5) - i7);
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        int[] iArr = this.bLs;
        if (iArr != null) {
            if (iArr.length == 1) {
                this.bLm.setColor(iArr[0]);
            } else {
                this.bLm.setShader(new LinearGradient(this.bKw.left, this.bKw.height() / 2.0f, this.bKw.right, this.bKw.height() / 2.0f, this.bLs, (float[]) null, Shader.TileMode.CLAMP));
            }
        }
        if (this.bLo == 1) {
            RectF rectF = this.bKw;
            int i = this.bLp;
            canvas.drawRoundRect(rectF, i, i, this.FL);
            RectF rectF2 = this.bKw;
            int i2 = this.bLp;
            canvas.drawRoundRect(rectF2, i2, i2, this.bLm);
            return;
        }
        canvas.drawCircle(this.bKw.centerX(), this.bKw.centerY(), Math.min(this.bKw.width(), this.bKw.height()) / 2.0f, this.FL);
        canvas.drawCircle(this.bKw.centerX(), this.bKw.centerY(), Math.min(this.bKw.width(), this.bKw.height()) / 2.0f, this.bLm);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        this.FL.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.FL.setColorFilter(colorFilter);
    }

    public static void a(View view, Drawable drawable) {
        view.setLayerType(1, null);
        view.setBackground(drawable);
    }

    public static void a(View view, int i, int i2, int i3, int i4, int i5, int i6) {
        d dVarAdw = new a().fN(i).fI(i2).fJ(i3).fK(i4).fL(0).fM(1).adw();
        view.setLayerType(1, null);
        view.setBackground(dVarAdw);
    }

    public static class a {
        private int bLo = 1;
        private int bLp = 12;
        private int FT = Color.parseColor("#4d000000");
        private int bLn = 18;
        private int bLq = 0;
        private int bLr = 0;
        private int[] bLs = {0};

        public final a fI(int i) {
            this.bLp = i;
            return this;
        }

        public final a fJ(int i) {
            this.FT = i;
            return this;
        }

        public final a fK(int i) {
            this.bLn = i;
            return this;
        }

        public final a fL(int i) {
            this.bLq = i;
            return this;
        }

        public final a fM(int i) {
            this.bLr = i;
            return this;
        }

        public final a fN(int i) {
            this.bLs[0] = i;
            return this;
        }

        public final d adw() {
            return new d(this.bLo, this.bLs, this.bLp, this.FT, this.bLn, this.bLq, this.bLr, (byte) 0);
        }
    }
}
