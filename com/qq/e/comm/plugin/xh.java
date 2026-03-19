package com.qq.e.comm.plugin;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Movie;
import android.os.SystemClock;
import android.widget.ImageView;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class xh extends ImageView implements nk {
    protected Movie a;
    protected int b;
    protected int c;
    private long d;
    private float e;
    protected int f;
    protected int g;

    public xh(Context context) {
        super(context);
        this.e = -1.0f;
        setLayerType(1, null);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.a == null) {
            super.onDraw(canvas);
        } else {
            if (a(canvas)) {
                return;
            }
            invalidate();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.a != null) {
            setMeasuredDimension(this.c, this.b);
        }
    }

    private boolean a(Canvas canvas) {
        long jUptimeMillis = SystemClock.uptimeMillis();
        if (this.d == 0) {
            this.d = jUptimeMillis;
        }
        int iDuration = this.a.duration();
        if (iDuration == 0) {
            iDuration = 1000;
        }
        this.a.setTime((int) ((jUptimeMillis - this.d) % iDuration));
        if (this.e < 0.0f) {
            float f = this.b;
            float f2 = this.c;
            float f3 = f / f2;
            float f4 = this.g;
            float f5 = this.f;
            if (f3 < f4 / f5) {
                this.e = f2 / f5;
            } else {
                this.e = f / f4;
            }
        }
        float f6 = this.e;
        canvas.scale(f6, f6);
        this.a.draw(canvas, 0.0f, 0.0f);
        invalidate();
        return false;
    }

    public void a(Movie movie) {
        this.a = movie;
        if (movie != null) {
            this.f = movie.width();
            int iHeight = this.a.height();
            this.g = iHeight;
            this.c = this.f;
            this.b = iHeight;
            invalidate();
        }
    }
}
