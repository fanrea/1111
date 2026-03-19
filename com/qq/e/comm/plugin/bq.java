package com.qq.e.comm.plugin;

import android.graphics.Canvas;
import android.graphics.Movie;
import android.os.Build;
import android.os.SystemClock;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class bq {
    private final p4 a;
    private final sq b;
    private final Movie c;
    private final int d;
    private final int e;
    private final int f;
    private int g;
    private long h;
    private int i = -1;
    private float j = -1.0f;
    private float k = 0.0f;

    public bq(p4 p4Var, sq sqVar, Movie movie) {
        this.a = p4Var;
        this.b = sqVar;
        this.c = movie;
        int iDuration = movie.duration();
        this.d = iDuration == 0 ? 1000 : iDuration;
        if (Build.VERSION.SDK_INT >= 11) {
            sqVar.setLayerType(1, null);
        }
        this.e = movie.width();
        this.f = movie.height();
        sqVar.invalidate();
    }

    private void a(Canvas canvas, int i) {
        if (i == this.i) {
            return;
        }
        this.c.setTime(i);
        if (this.j < 0.0f) {
            int width = this.b.getWidth();
            int height = this.b.getHeight();
            if (width != 0 && height != 0) {
                float f = height;
                float f2 = width;
                float f3 = f / f2;
                float f4 = this.f;
                float f5 = this.e;
                if (f3 < f4 / f5) {
                    this.j = f2 / f5;
                } else {
                    this.j = f / f4;
                    p4 p4Var = this.a;
                    if (p4Var != null && p4Var.P() == 3) {
                        float f6 = this.e;
                        float f7 = this.j;
                        this.k = (-(((f6 * f7) - f2) / 2.0f)) / f7;
                    }
                }
            } else {
                this.j = 0.0f;
            }
        }
        float f8 = this.j;
        canvas.scale(f8, f8);
        this.c.draw(canvas, this.k, 0.0f);
        this.i = i;
    }

    public void a(Canvas canvas) {
        long jUptimeMillis = SystemClock.uptimeMillis();
        if (this.h == 0) {
            this.h = jUptimeMillis;
        }
        if (this.g == 0) {
            int iN = this.a.N();
            if (iN <= 0) {
                this.g = -1;
            } else {
                this.g = ((iN * (this.d + this.a.O())) - this.a.O()) + this.a.Q();
            }
        }
        int i = (int) (jUptimeMillis - this.h);
        int i2 = this.g;
        if (i2 > 0 && i >= i2) {
            a(canvas, this.d);
            p4 p4Var = this.a;
            r2 r2Var = p4Var.L;
            if (r2Var != null) {
                r2Var.a(p4Var.J);
                return;
            }
            return;
        }
        int iQ = this.a.Q();
        if (i >= iQ) {
            int iO = (i - iQ) % (this.d + this.a.O());
            int i3 = this.d;
            if (iO > i3) {
                iO = i3;
            }
            a(canvas, iO);
        }
        this.b.invalidate();
    }
}
