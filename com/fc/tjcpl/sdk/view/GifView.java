package com.fc.tjcpl.sdk.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Movie;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.internal.view.SupportMenu;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class GifView extends View {
    public int a;
    public Movie b;
    public long c;
    public int d;
    public float e;
    public int f;
    public int g;
    public boolean h;
    public volatile boolean i;
    public Bitmap j;
    public Paint k;
    public Rect l;
    public boolean m;

    public GifView(Context context) {
        this(context, null);
    }

    public GifView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GifView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = 0;
        this.e = 1.0f;
        this.h = true;
        this.i = false;
        b();
    }

    public final void a() {
        if (this.h) {
            postInvalidateOnAnimation();
        }
    }

    public final void a(Canvas canvas) {
        this.b.setTime(this.d);
        canvas.save();
        float f = this.e;
        canvas.scale(f, f);
        Movie movie = this.b;
        float f2 = 0.0f / this.e;
        movie.draw(canvas, f2, f2);
        canvas.restore();
        if (this.m) {
            if (this.k == null) {
                Paint paint = new Paint();
                this.k = paint;
                paint.setAntiAlias(true);
                this.k.setFilterBitmap(false);
                this.k.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            }
            Bitmap bitmap = this.j;
            if (bitmap == null || bitmap.isRecycled()) {
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(this.f, this.g, Bitmap.Config.ARGB_8888);
                Canvas canvas2 = new Canvas(bitmapCreateBitmap);
                Paint paint2 = new Paint(1);
                paint2.setColor(SupportMenu.CATEGORY_MASK);
                paint2.setAntiAlias(true);
                canvas2.drawRoundRect(new RectF(0.0f, 0.0f, getWidth(), getHeight()), 10.0f, 10.0f, paint2);
                this.j = bitmapCreateBitmap;
            }
            if (this.l == null) {
                this.l = new Rect(0, 0, getWidth(), getHeight());
            }
            Bitmap bitmap2 = this.j;
            Rect rect = this.l;
            canvas.drawBitmap(bitmap2, rect, rect, this.k);
            canvas.restore();
        }
    }

    public final void b() {
        setLayerType(1, null);
    }

    public Movie getMovie() {
        return this.b;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.b != null) {
            if (this.i) {
                a(canvas);
                return;
            }
            long jUptimeMillis = SystemClock.uptimeMillis();
            if (this.c == 0) {
                this.c = jUptimeMillis;
            }
            int iDuration = this.b.duration();
            if (iDuration == 0) {
                iDuration = 1000;
            }
            this.d = (int) ((jUptimeMillis - this.c) % iDuration);
            a(canvas);
            a();
        }
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.h = getVisibility() == 0;
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        Movie movie = this.b;
        if (movie == null) {
            setMeasuredDimension(getSuggestedMinimumWidth(), getSuggestedMinimumHeight());
            return;
        }
        int iWidth = movie.width();
        int iHeight = this.b.height();
        View.MeasureSpec.getSize(i);
        View.MeasureSpec.getSize(i2);
        this.f = iWidth;
        this.g = iHeight;
        setMeasuredDimension(iWidth, iHeight);
    }

    @Override // android.view.View
    public void onScreenStateChanged(int i) {
        super.onScreenStateChanged(i);
        this.h = i == 1;
        a();
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        this.h = i == 0;
        a();
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.h = i == 0;
        a();
    }

    public void setIsRound(boolean z) {
        this.m = z;
    }

    public void setMovie(Movie movie) {
        this.b = movie;
        requestLayout();
    }

    public void setMovie(byte[] bArr) {
        this.b = Movie.decodeByteArray(bArr, 0, bArr.length);
        requestLayout();
    }

    public void setMovieResource(int i) {
        this.a = i;
        this.b = Movie.decodeStream(getResources().openRawResource(this.a));
        requestLayout();
    }

    public void setMovieTime(int i) {
        this.d = i;
        invalidate();
    }

    public void setPaused(boolean z) {
        this.i = z;
        if (!z) {
            this.c = SystemClock.uptimeMillis() - this.d;
        }
        invalidate();
    }
}
