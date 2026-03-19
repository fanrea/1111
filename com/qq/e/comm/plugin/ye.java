package com.qq.e.comm.plugin;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DrawFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.qq.e.comm.plugin.bf;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public abstract class ye<Decoder extends bf<?, ?>> extends Drawable implements Animatable, bf.j {
    private static final String m = "ye";
    private final Paint a;
    private final Decoder b;
    private final DrawFilter c;
    private final Matrix d;
    private Bitmap e;
    private final Handler f;
    private final Runnable g;
    private boolean h;
    private final Set<WeakReference<Drawable.Callback>> i;
    private boolean j;

    protected abstract Decoder a(mo moVar, bf.j jVar);

    @Override // com.qq.e.comm.plugin.bf.j
    public void a() {
    }

    @Override // com.qq.e.comm.plugin.bf.j
    public void b() {
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    /* compiled from: A */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ye.this.invalidateSelf();
        }
    }

    public ye(mo moVar) {
        Paint paint = new Paint();
        this.a = paint;
        this.c = new PaintFlagsDrawFilter(0, 3);
        this.d = new Matrix();
        this.f = new Handler(Looper.getMainLooper());
        this.g = new a();
        this.h = true;
        this.i = new HashSet();
        this.j = false;
        paint.setAntiAlias(true);
        this.b = (Decoder) a(moVar, this);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (this.b.l()) {
            this.b.q();
        }
        this.b.n();
        e();
    }

    private void e() {
        this.b.a(this);
        if (this.h) {
            this.b.o();
        } else {
            if (this.b.l()) {
                return;
            }
            this.b.o();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        f();
    }

    private void f() {
        this.b.b(this);
        if (this.h) {
            this.b.q();
        } else {
            this.b.r();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.b.l();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Bitmap bitmap = this.e;
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        canvas.setDrawFilter(this.c);
        canvas.drawBitmap(this.e, this.d, this.a);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i, int i2, int i3, int i4) {
        super.setBounds(i, i2, i3, i4);
        int iH = this.b.h();
        int iC = this.b.c(getBounds().width(), getBounds().height());
        float f = iC;
        this.d.setScale(((getBounds().width() * 1.0f) * f) / this.b.d().width(), ((getBounds().height() * 1.0f) * f) / this.b.d().height());
        if (iC != iH) {
            this.e = Bitmap.createBitmap(this.b.d().width() / iC, this.b.d().height() / iC, Bitmap.Config.ARGB_8888);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.a.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.a.setColorFilter(colorFilter);
    }

    @Override // com.qq.e.comm.plugin.bf.j
    public void a(ByteBuffer byteBuffer) {
        if (isRunning()) {
            Bitmap bitmap = this.e;
            if (bitmap == null || bitmap.isRecycled()) {
                this.e = Bitmap.createBitmap(this.b.d().width() / this.b.h(), this.b.d().height() / this.b.h(), Bitmap.Config.ARGB_8888);
            }
            byteBuffer.rewind();
            if (byteBuffer.remaining() < this.e.getByteCount()) {
                Log.e(m, "onRender:Buffer not large enough for pixels");
            } else {
                this.e.copyPixelsFromBuffer(byteBuffer);
                this.f.post(this.g);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        d();
        if (this.h) {
            if (z) {
                if (!isRunning()) {
                    e();
                }
            } else if (isRunning()) {
                f();
            }
        }
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.j) {
            return -1;
        }
        try {
            return this.b.d().width();
        } catch (Exception unused) {
            return 0;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.j) {
            return -1;
        }
        try {
            return this.b.d().height();
        } catch (Exception unused) {
            return 0;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.Callback getCallback() {
        return super.getCallback();
    }

    private void d() {
        ArrayList arrayList = new ArrayList();
        Drawable.Callback callback = getCallback();
        boolean z = false;
        for (WeakReference weakReference : new HashSet(this.i)) {
            Drawable.Callback callback2 = (Drawable.Callback) weakReference.get();
            if (callback2 == null) {
                arrayList.add(weakReference);
            } else if (callback2 == callback) {
                z = true;
            } else {
                callback2.invalidateDrawable(this);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.i.remove((WeakReference) it.next());
        }
        if (z) {
            return;
        }
        this.i.add(new WeakReference<>(callback));
    }

    public void a(int i) {
        this.b.b(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        super.invalidateSelf();
        Iterator it = new HashSet(this.i).iterator();
        while (it.hasNext()) {
            Drawable.Callback callback = (Drawable.Callback) ((WeakReference) it.next()).get();
            if (callback != null && callback != getCallback()) {
                callback.invalidateDrawable(this);
            }
        }
    }

    public Decoder c() {
        return this.b;
    }
}
