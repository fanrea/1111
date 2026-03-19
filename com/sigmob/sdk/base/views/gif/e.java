package com.sigmob.sdk.base.views.gif;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.ImageView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class e extends ImageView implements Runnable {
    private static final String a = "GifDecoderView";
    private boolean b;
    private a c;
    private b d;
    private Thread e;
    private c f;
    private long g;
    private com.sigmob.sdk.base.views.gif.a h;
    private final Handler i;
    private boolean j;
    private boolean k;
    private Bitmap l;
    private final Runnable m;
    private final Runnable n;

    public interface a {
        void a();
    }

    public interface b {
        void a();
    }

    public interface c {
        Bitmap onFrameAvailable(Bitmap bitmap);
    }

    public e(final Context context) {
        super(context);
        this.c = null;
        this.d = null;
        this.f = null;
        this.g = -1L;
        this.i = new Handler(Looper.getMainLooper());
        this.m = new Runnable() { // from class: com.sigmob.sdk.base.views.gif.e.1
            @Override // java.lang.Runnable
            public void run() {
                e.this.l = null;
                e.this.h = null;
                e.this.e = null;
                e.this.k = false;
            }
        };
        this.n = new Runnable() { // from class: com.sigmob.sdk.base.views.gif.e.2
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.l == null || e.this.l.isRecycled()) {
                    return;
                }
                e eVar = e.this;
                eVar.setImageBitmap(eVar.l);
            }
        };
    }

    public e(final Context context, final AttributeSet attrs) {
        super(context, attrs);
        this.c = null;
        this.d = null;
        this.f = null;
        this.g = -1L;
        this.i = new Handler(Looper.getMainLooper());
        this.m = new Runnable() { // from class: com.sigmob.sdk.base.views.gif.e.1
            @Override // java.lang.Runnable
            public void run() {
                e.this.l = null;
                e.this.h = null;
                e.this.e = null;
                e.this.k = false;
            }
        };
        this.n = new Runnable() { // from class: com.sigmob.sdk.base.views.gif.e.2
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.l == null || e.this.l.isRecycled()) {
                    return;
                }
                e eVar = e.this;
                eVar.setImageBitmap(eVar.l);
            }
        };
    }

    private boolean f() {
        return (this.b || this.j) && this.h != null && this.e == null;
    }

    private void g() {
        if (f()) {
            Thread thread = new Thread(this);
            this.e = thread;
            thread.start();
        }
    }

    public void a() {
        this.b = false;
        this.j = false;
        this.k = true;
        e();
        this.i.post(this.m);
    }

    public void a(int frame) {
        if (this.h.d() == frame || !this.h.b(frame - 1) || this.b) {
            return;
        }
        this.j = true;
        g();
    }

    public boolean b() {
        return this.b;
    }

    public void c() {
        this.h.o();
        a(0);
    }

    public void d() {
        this.b = true;
        g();
    }

    public void e() {
        this.b = false;
        Thread thread = this.e;
        if (thread != null) {
            thread.interrupt();
            this.e = null;
        }
    }

    public int getFrameCount() {
        return this.h.f();
    }

    public long getFramesDisplayDuration() {
        return this.g;
    }

    public int getGifHeight() {
        return this.h.g();
    }

    public int getGifWidth() {
        return this.h.m();
    }

    public b getOnAnimationStop() {
        return this.d;
    }

    public c getOnFrameAvailable() {
        return this.f;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a();
    }

    @Override // java.lang.Runnable
    public void run() throws InterruptedException {
        long jNanoTime;
        a aVar = this.c;
        if (aVar != null) {
            aVar.a();
        }
        do {
            if (!this.b && !this.j) {
                break;
            }
            boolean zA = this.h.a();
            try {
                long jNanoTime2 = System.nanoTime();
                Bitmap bitmapK = this.h.k();
                this.l = bitmapK;
                c cVar = this.f;
                if (cVar != null) {
                    this.l = cVar.onFrameAvailable(bitmapK);
                }
                jNanoTime = (System.nanoTime() - jNanoTime2) / 1000000;
                try {
                    this.i.post(this.n);
                } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException unused) {
                }
            } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException unused2) {
                jNanoTime = 0;
            }
            this.j = false;
            if (!this.b || !zA) {
                this.b = false;
                break;
            }
            try {
                int iJ = (int) (this.h.j() - jNanoTime);
                if (iJ > 0) {
                    long j = this.g;
                    if (j <= 0) {
                        j = iJ;
                    }
                    Thread.sleep(j);
                }
            } catch (InterruptedException unused3) {
            }
        } while (this.b);
        if (this.k) {
            this.i.post(this.m);
        }
        this.e = null;
        b bVar = this.d;
        if (bVar != null) {
            bVar.a();
        }
    }

    public void setBytes(final byte[] bytes) {
        com.sigmob.sdk.base.views.gif.a aVar = new com.sigmob.sdk.base.views.gif.a();
        this.h = aVar;
        try {
            aVar.a(bytes);
            if (this.b) {
                g();
            } else {
                a(0);
            }
        } catch (Exception unused) {
            this.h = null;
        }
    }

    public void setFramesDisplayDuration(long framesDisplayDuration) {
        this.g = framesDisplayDuration;
    }

    public void setOnAnimationStart(a animationStart) {
        this.c = animationStart;
    }

    public void setOnAnimationStop(b animationStop) {
        this.d = animationStop;
    }

    public void setOnFrameAvailable(c frameProcessor) {
        this.f = frameProcessor;
    }
}
