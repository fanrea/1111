package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ImageDecoder;
import android.graphics.Movie;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.SystemClock;
import android.view.View;
import android.widget.ImageView;
import com.bytedance.sdk.component.adexpress.c.u;
import com.bytedance.sdk.component.tc.tt;
import com.bytedance.sdk.component.utils.an;
import com.bytedance.sdk.component.utils.jh;
import com.bytedance.sdk.component.utils.mq;
import java.io.File;
import java.io.FileOutputStream;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class GifView extends ImageView {
    private boolean an;
    private long b;
    private int c;
    private int d;
    private boolean e;
    private float gb;
    private boolean h;
    private Movie hc;
    private boolean k;
    private int mk;
    private int mq;
    private float tc;
    private float tt;
    private AnimatedImageDrawable u;
    private volatile boolean uo;

    interface d {
        void d(Drawable drawable);
    }

    public GifView(Context context) {
        super(context);
        this.an = Build.VERSION.SDK_INT >= 28;
        this.h = false;
        this.k = true;
        this.e = true;
        d();
    }

    void d() {
        if (this.an) {
            return;
        }
        setLayerType(1, null);
    }

    public void d(int i, boolean z) {
        this.uo = z;
        this.d = i;
        if (i == -1) {
            return;
        }
        if (!this.an) {
            this.hc = d(i);
        } else {
            d(i, new d() { // from class: com.bytedance.sdk.component.adexpress.widget.GifView.1
                @Override // com.bytedance.sdk.component.adexpress.widget.GifView.d
                public void d(final Drawable drawable) {
                    GifView.this.post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.GifView.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            GifView.this.setDrawable(drawable);
                        }
                    });
                }
            });
        }
    }

    public void d(byte[] bArr, boolean z) {
        this.uo = z;
        if (bArr == null) {
            return;
        }
        if (!this.an) {
            this.hc = d(bArr);
        } else {
            d(bArr, new d() { // from class: com.bytedance.sdk.component.adexpress.widget.GifView.2
                @Override // com.bytedance.sdk.component.adexpress.widget.GifView.d
                public void d(final Drawable drawable) {
                    GifView.this.post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.GifView.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            GifView.this.setDrawable(drawable);
                        }
                    });
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDrawable(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        setImageDrawable(drawable);
        if (Build.VERSION.SDK_INT >= 28 && (drawable instanceof AnimatedImageDrawable)) {
            AnimatedImageDrawable animatedImageDrawable = (AnimatedImageDrawable) drawable;
            this.u = animatedImageDrawable;
            if (!this.uo) {
                animatedImageDrawable.start();
            }
            if (!this.e) {
                animatedImageDrawable.setRepeatCount(0);
            }
        }
        b();
    }

    public void setRepeatConfig(boolean z) {
        AnimatedImageDrawable animatedImageDrawable;
        this.e = z;
        if (z) {
            return;
        }
        try {
            if (Build.VERSION.SDK_INT < 28 || (animatedImageDrawable = this.u) == null) {
                return;
            }
            animatedImageDrawable.setRepeatCount(0);
        } catch (Exception e) {
            mq.b("GifView", "setRepeatConfig error", e);
        }
    }

    private Movie d(int i) {
        try {
            return Movie.decodeStream(jh.d(getContext()).openRawResource(i));
        } catch (Throwable unused) {
            return null;
        }
    }

    private Movie d(byte[] bArr) {
        try {
            return Movie.decodeByteArray(bArr, 0, bArr.length);
        } catch (Throwable unused) {
            return null;
        }
    }

    private void d(final int i, final d dVar) {
        if (i == -1) {
            return;
        }
        u.d(new tt("createGifApi28WithByteArrayBySafely") { // from class: com.bytedance.sdk.component.adexpress.widget.GifView.3
            @Override // java.lang.Runnable
            public void run() {
                d dVar2 = dVar;
                if (dVar2 != null) {
                    GifView gifView = GifView.this;
                    dVar2.d(gifView.d(gifView.hc(i)));
                }
            }
        }, 5);
    }

    private void d(final byte[] bArr, final d dVar) {
        if (bArr == null) {
            return;
        }
        u.d(new tt("createGifApi28WithByteArrayBySafely") { // from class: com.bytedance.sdk.component.adexpress.widget.GifView.4
            @Override // java.lang.Runnable
            public void run() {
                d dVar2 = dVar;
                if (dVar2 != null) {
                    GifView gifView = GifView.this;
                    dVar2.d(gifView.d(gifView.hc(bArr)));
                }
            }
        }, 5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImageDecoder.Source hc(byte[] bArr) {
        FileOutputStream fileOutputStream;
        File fileD;
        try {
            fileD = d(getContext(), com.bytedance.sdk.component.adexpress.d.d.d.d().b().mq() ? "GIF_AD_CACHE/" : "/GIF_CACHE/", "TT_GIF_FILE");
            fileOutputStream = new FileOutputStream(fileD);
        } catch (Throwable th) {
            th = th;
            fileOutputStream = null;
        }
        try {
            fileOutputStream.write(bArr, 0, bArr.length);
            if (Build.VERSION.SDK_INT >= 28) {
                ImageDecoder.Source sourceCreateSource = ImageDecoder.createSource(fileD);
                try {
                    fileOutputStream.close();
                } catch (Throwable unused) {
                }
                return sourceCreateSource;
            }
        } catch (Throwable th2) {
            th = th2;
            try {
                mq.b("GifView", "GifView  getSourceByFile fail : ", th);
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                return null;
            } catch (Throwable th3) {
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Throwable unused2) {
                    }
                }
                throw th3;
            }
        }
        try {
            fileOutputStream.close();
        } catch (Throwable unused3) {
        }
        return null;
    }

    public static File d(Context context, String str, String str2) {
        int iMk = com.bytedance.sdk.component.adexpress.d.d.d.d().b().mk();
        boolean zMq = com.bytedance.sdk.component.adexpress.d.d.d.d().b().mq();
        if (iMk == 1) {
            mq.c("splashLoadAd", "视频存储使用内部存储");
            return an.hc(context, zMq, str, str2);
        }
        mq.c("splashLoadAd", "视频存储使用外存储");
        return an.d(context, zMq, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImageDecoder.Source hc(int i) {
        if (Build.VERSION.SDK_INT >= 28) {
            return ImageDecoder.createSource(jh.d(getContext()), i);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Drawable d(ImageDecoder.Source source) {
        try {
            if (Build.VERSION.SDK_INT < 28) {
                return null;
            }
            return ImageDecoder.decodeDrawable(source);
        } catch (Throwable unused) {
            return null;
        }
    }

    public void hc() {
        if (this.hc == null || !this.uo) {
            return;
        }
        this.uo = false;
        if (!this.an) {
            this.b = SystemClock.uptimeMillis() - this.c;
            invalidate();
            return;
        }
        AnimatedImageDrawable animatedImageDrawable = this.u;
        if (animatedImageDrawable == null || animatedImageDrawable.isRunning()) {
            return;
        }
        this.u.start();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        Movie movie;
        int size;
        int size2;
        super.onMeasure(i, i2);
        if (this.an || (movie = this.hc) == null) {
            return;
        }
        int iWidth = movie.width();
        int iHeight = this.hc.height();
        float fMax = 1.0f / Math.max((View.MeasureSpec.getMode(i) == 0 || iWidth <= (size2 = View.MeasureSpec.getSize(i))) ? 1.0f : iWidth / size2, (View.MeasureSpec.getMode(i2) == 0 || iHeight <= (size = View.MeasureSpec.getSize(i2))) ? 1.0f : iHeight / size);
        this.tc = fMax;
        int i3 = (int) (iWidth * fMax);
        this.mk = i3;
        int i4 = (int) (iHeight * fMax);
        this.mq = i4;
        setMeasuredDimension(i3, i4);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.hc != null && !this.an) {
            this.gb = (getWidth() - this.mk) / 2.0f;
            this.tt = (getHeight() - this.mq) / 2.0f;
        }
        this.k = getVisibility() == 0;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.hc != null && !this.an) {
            try {
                if (!this.uo) {
                    c();
                    d(canvas);
                    b();
                    return;
                }
                d(canvas);
                return;
            } catch (Throwable th) {
                mq.b("GifView", "onDraw->Throwable->", th);
                return;
            }
        }
        super.onDraw(canvas);
    }

    private void b() {
        if (this.hc == null || this.an || !this.k) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            postInvalidateOnAnimation();
        } else {
            invalidate();
        }
    }

    private void c() {
        if (this.hc == null) {
            return;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        if (this.b == 0) {
            this.b = jUptimeMillis;
        }
        int iDuration = this.hc.duration();
        if (iDuration == 0) {
            iDuration = 1000;
        }
        if (!this.e && Math.abs(iDuration - this.c) < 60) {
            this.c = iDuration;
            this.uo = true;
        } else {
            this.c = (int) ((jUptimeMillis - this.b) % iDuration);
        }
    }

    private void d(Canvas canvas) {
        Movie movie = this.hc;
        if (movie == null) {
            return;
        }
        movie.setTime(this.c);
        float f = this.tc;
        if (f == 0.0f) {
            canvas.scale(1.0f, 1.0f);
            this.hc.draw(canvas, 0.0f, 0.0f);
        } else {
            canvas.scale(f, f);
            Movie movie2 = this.hc;
            float f2 = this.gb;
            float f3 = this.tc;
            movie2.draw(canvas, f2 / f3, this.tt / f3);
        }
        canvas.restore();
    }

    @Override // android.view.View
    public void onScreenStateChanged(int i) {
        super.onScreenStateChanged(i);
        if (this.hc != null) {
            this.k = i == 1;
            b();
        }
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (this.hc != null) {
            this.k = i == 0;
            b();
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.hc != null) {
            this.k = i == 0;
            b();
        }
    }
}
