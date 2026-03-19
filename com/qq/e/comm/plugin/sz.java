package com.qq.e.comm.plugin;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Movie;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.ImageView;
import java.io.File;
import java.io.IOException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class sz extends ImageView implements nk {
    private int a;
    private int b;
    private int c;
    private int d;
    private int e;
    private Movie f;
    private int g;
    private long h;
    private float i;
    private float j;
    private Bitmap m;

    public sz(Context context) {
        super(context);
        this.h = -1L;
        this.i = -1.0f;
        this.j = 0.0f;
        setId(1);
    }

    @Override // com.qq.e.comm.plugin.nk
    public void a(Movie movie) {
        if (movie == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 11) {
            setLayerType(1, null);
        }
        this.f = movie;
        int iDuration = movie.duration();
        this.g = iDuration;
        if (iDuration == 0) {
            this.g = 2500;
        }
        this.b = movie.width();
        this.a = movie.height();
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        if (bitmap != null) {
            this.a = bitmap.getHeight();
            this.b = bitmap.getWidth();
            this.m = bitmap;
            super.setImageBitmap(bitmap);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap bitmap = this.m;
        if (bitmap == null || !bitmap.isRecycled()) {
            this.d = getHeight();
            int width = getWidth();
            this.e = width;
            if (width != 0 && this.b != 0) {
                if (this.f != null) {
                    a(canvas);
                    super.onDraw(canvas);
                    return;
                }
                if (getScaleType() != ImageView.ScaleType.FIT_CENTER) {
                    int i = this.d;
                    double d = i;
                    int i2 = this.e;
                    double d2 = i2;
                    Double.isNaN(d);
                    Double.isNaN(d2);
                    double d3 = d / d2;
                    int i3 = this.a;
                    double d4 = i3;
                    int i4 = this.b;
                    double d5 = i4;
                    Double.isNaN(d4);
                    Double.isNaN(d5);
                    if (d3 < d4 / d5) {
                        this.c = (i3 * i2) / i4;
                        getDrawable().setBounds(0, 0, this.e, this.c);
                    } else {
                        this.c = (((i4 * i) / i3) - i2) / 2;
                        Drawable drawable = getDrawable();
                        int i5 = this.c;
                        drawable.setBounds(-i5, 0, this.e + i5, this.d);
                    }
                }
                super.onDraw(canvas);
                return;
            }
            super.onDraw(canvas);
        }
    }

    public void a(File file) throws IOException {
        Movie movieB = e5.b(file);
        if (movieB != null) {
            a(movieB);
        } else {
            setImageBitmap(e5.b(file, this));
        }
        if (this.b >= this.a) {
            setScaleType(ImageView.ScaleType.FIT_CENTER);
        } else {
            setScaleType(ImageView.ScaleType.FIT_XY);
        }
    }

    private void a(Canvas canvas) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (this.h < 0) {
            this.h = jCurrentTimeMillis;
        }
        this.f.setTime(((int) (jCurrentTimeMillis - this.h)) % this.g);
        if (this.i < 0.0f) {
            int i = this.d;
            double d = i;
            int i2 = this.e;
            double d2 = i2;
            Double.isNaN(d);
            Double.isNaN(d2);
            double d3 = d / d2;
            int i3 = this.a;
            double d4 = i3;
            int i4 = this.b;
            double d5 = i4;
            Double.isNaN(d4);
            Double.isNaN(d5);
            if (d3 < d4 / d5) {
                this.i = i2 / i4;
            } else {
                float f = i / i3;
                this.i = f;
                this.j = (-(((i4 * f) - i2) / 2.0f)) / f;
            }
        }
        float f2 = this.i;
        canvas.scale(f2, f2);
        this.f.draw(canvas, this.j, 0.0f);
        invalidate();
    }
}
