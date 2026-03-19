package com.lingku.xuanshang.xutils.image;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Movie;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import com.lingku.xuanshang.xutils.common.util.LogUtil;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class GifDrawable extends Drawable implements Runnable, Animatable {
    public int a;
    public volatile boolean c;
    public final Movie d;
    public final int e;
    public int b = 100;
    public final long f = SystemClock.uptimeMillis();

    public GifDrawable(Movie movie, int i) {
        this.d = movie;
        this.a = i;
        this.e = movie.duration();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        try {
            this.d.setTime(this.e > 0 ? ((int) (SystemClock.uptimeMillis() - this.f)) % this.e : 0);
            this.d.draw(canvas, 0.0f, 0.0f);
            start();
        } catch (Throwable th) {
            LogUtil.e(th.getMessage(), th);
        }
    }

    public int getByteCount() {
        if (this.a == 0) {
            this.a = this.d.width() * this.d.height() * 3 * 5;
        }
        return this.a;
    }

    public int getDuration() {
        return this.e;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.d.height();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.d.width();
    }

    public Movie getMovie() {
        return this.d;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.d.isOpaque() ? -1 : -3;
    }

    public int getRate() {
        return this.b;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.c && this.e > 0;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.e > 0) {
            invalidateSelf();
            scheduleSelf(this, SystemClock.uptimeMillis() + this.b);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    public void setRate(int i) {
        this.b = i;
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (isRunning()) {
            return;
        }
        this.c = true;
        run();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (isRunning()) {
            this.c = false;
            unscheduleSelf(this);
        }
    }
}
