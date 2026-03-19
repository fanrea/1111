package com.sigmob.sdk.base.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.czhj.sdk.common.utils.Dips;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class at extends View {
    private Paint a;
    private Path b;
    private int c;
    private RectF d;
    private RectF e;
    private RectF f;
    private int g;
    private int h;

    public at(Context context) {
        super(context);
    }

    public at(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public at(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void a() {
        this.a = new Paint();
        this.b = new Path();
        int width = getWidth();
        int height = getHeight();
        int iDipsToIntPixels = Dips.dipsToIntPixels(1.0f, getContext());
        float f = iDipsToIntPixels;
        this.a.setStrokeWidth(f);
        float f2 = width;
        float f3 = f2 / (100.0f * f);
        this.g = (int) (15.0f * f3);
        this.h = (int) (6.0f * f3);
        this.c = Math.max((int) (f3 * f * 3.0f), iDipsToIntPixels * 2);
        float f4 = height;
        float f5 = 0.4f * f4;
        float f6 = (10.0f * f5) / 16.0f;
        float f7 = (f2 - f6) / 2.0f;
        float f8 = (f4 - f5) / 2.0f;
        this.f = new RectF(f7, f8, f6 + f7, f5 + f8);
        this.e = new RectF(this.f.left + this.c, this.f.top + this.c, this.f.right - this.c, this.f.bottom - (this.c * 3));
        this.d = new RectF(this.f.left + ((this.f.width() - (this.c * 2)) / 2.2f), this.f.bottom - (this.c * 2), this.f.right - ((this.f.width() - (this.c * 2)) / 2.2f), this.f.bottom - this.c);
    }

    private void a(Canvas canvas) {
        this.b.reset();
        this.a.setColor(-1);
        this.a.setStyle(Paint.Style.FILL);
        Path path = this.b;
        RectF rectF = this.f;
        int i = this.g;
        path.addRoundRect(rectF, i, i, Path.Direction.CW);
        Path path2 = this.b;
        RectF rectF2 = this.e;
        int i2 = this.h;
        path2.addRoundRect(rectF2, i2, i2, Path.Direction.CCW);
        Path path3 = this.b;
        RectF rectF3 = this.d;
        int i3 = this.h;
        path3.addRoundRect(rectF3, i3, i3, Path.Direction.CCW);
        this.b.close();
        canvas.drawPath(this.b, this.a);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        a(canvas);
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        a();
    }
}
