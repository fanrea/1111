package com.sigmob.sdk.base.views;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Movie;
import android.os.Build;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.czhj.sdk.logger.SigmobLog;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class u extends ImageView {
    private static final int a = 1000;
    private int b;
    private Movie c;
    private long d;
    private int e;
    private float f;
    private float g;
    private float h;
    private float i;
    private int j;
    private int k;
    private boolean l;
    private volatile boolean m;

    public u(Context context) {
        this(context, null);
    }

    public u(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public u(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.e = 0;
        this.l = true;
        this.m = false;
        if (Build.VERSION.SDK_INT >= 11) {
            setLayerType(1, null);
        }
    }

    private void a(Canvas canvas) {
        this.c.setTime(this.e);
        canvas.save();
        canvas.scale(this.h, this.i);
        this.c.draw(canvas, this.f / this.h, this.g / this.i);
        canvas.restore();
    }

    private void b() {
        if (this.l) {
            if (Build.VERSION.SDK_INT >= 16) {
                postInvalidateOnAnimation();
            } else {
                invalidate();
            }
        }
    }

    private void c() {
        long jUptimeMillis = SystemClock.uptimeMillis();
        if (this.d == 0) {
            this.d = jUptimeMillis;
        }
        int iDuration = this.c.duration();
        if (iDuration == 0) {
            iDuration = 1000;
        }
        this.e = (int) ((jUptimeMillis - this.d) % iDuration);
    }

    private byte[] getGiftBytes() throws Resources.NotFoundException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        InputStream inputStreamOpenRawResource = getResources().openRawResource(this.b);
        byte[] bArr = new byte[1024];
        while (true) {
            try {
                try {
                    int i = inputStreamOpenRawResource.read(bArr, 0, 1024);
                    if (i == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, i);
                } catch (Throwable th) {
                    try {
                        SigmobLog.e(th.getMessage());
                        inputStreamOpenRawResource.close();
                    } catch (Throwable th2) {
                        try {
                            inputStreamOpenRawResource.close();
                        } catch (Throwable th3) {
                            SigmobLog.e(th3.getMessage());
                        }
                        throw th2;
                    }
                }
            } catch (Throwable th4) {
                SigmobLog.e(th4.getMessage());
            }
        }
        byteArrayOutputStream.flush();
        inputStreamOpenRawResource.close();
        return byteArrayOutputStream.toByteArray();
    }

    public boolean a() {
        return this.m;
    }

    public Movie getMovie() {
        return this.c;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.c == null) {
            super.onDraw(canvas);
            return;
        }
        c();
        a(canvas);
        b();
    }

    @Override // android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        this.f = (getWidth() - this.j) / 2.0f;
        this.g = (getHeight() - this.k) / 2.0f;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Movie movie = this.c;
        if (movie == null) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            return;
        }
        int iWidth = movie.width();
        int iHeight = this.c.height();
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        this.h = 1.0f / (iWidth / size);
        this.i = 1.0f / (iHeight / View.MeasureSpec.getSize(heightMeasureSpec));
        this.j = size;
        int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
        this.k = size2;
        setMeasuredDimension(this.j, size2);
    }

    @Override // android.view.View
    public void onScreenStateChanged(int screenState) {
        super.onScreenStateChanged(screenState);
        this.l = screenState == 1;
        b();
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View changedView, int visibility) {
        super.onVisibilityChanged(changedView, visibility);
        this.l = visibility == 0;
        b();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int visibility) {
        super.onWindowVisibilityChanged(visibility);
        this.l = visibility == 0;
        b();
    }

    public void setMovie(Movie movie) {
        this.c = movie;
        requestLayout();
    }

    public void setMovieResource(int giftResId) throws Resources.NotFoundException {
        this.b = giftResId;
        byte[] giftBytes = getGiftBytes();
        this.c = Movie.decodeByteArray(giftBytes, 0, giftBytes.length);
        requestLayout();
    }

    public void setMovieTime(int time) {
        this.e = time;
        invalidate();
    }

    public void setPaused(boolean paused) {
        this.m = paused;
        if (!paused) {
            this.d = SystemClock.uptimeMillis() - this.e;
        }
        invalidate();
    }
}
