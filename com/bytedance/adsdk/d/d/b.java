package com.bytedance.adsdk.d.d;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DrawFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.adsdk.d.d.d.tt;
import com.bytedance.sdk.component.utils.mq;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class b<Decoder extends tt<?, ?>> extends Drawable implements tt.d, hc {
    private static final String d = "b";
    private final Set<Object> an;
    private final Decoder b;
    private final DrawFilter c;
    private final Handler gb;
    private Bitmap h;
    private final Paint hc;
    private final Set<WeakReference<Drawable.Callback>> mk;
    private boolean mq;
    private boolean tc;
    private final Runnable tt;
    private final Matrix u;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    protected abstract Decoder hc(com.bytedance.adsdk.d.d.b.hc hcVar, tt.d dVar);

    public b(com.bytedance.adsdk.d.d.b.hc hcVar) {
        Paint paint = new Paint();
        this.hc = paint;
        this.c = new PaintFlagsDrawFilter(0, 3);
        this.u = new Matrix();
        this.an = new HashSet();
        this.gb = new Handler(Looper.getMainLooper()) { // from class: com.bytedance.adsdk.d.d.b.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i = message.what;
                if (i == 1) {
                    Iterator it = new ArrayList(b.this.an).iterator();
                    while (it.hasNext()) {
                        it.next();
                    }
                } else {
                    if (i != 2) {
                        return;
                    }
                    Iterator it2 = new ArrayList(b.this.an).iterator();
                    while (it2.hasNext()) {
                        it2.next();
                    }
                }
            }
        };
        this.tt = new Runnable() { // from class: com.bytedance.adsdk.d.d.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.invalidateSelf();
            }
        };
        this.tc = true;
        this.mk = new HashSet();
        this.mq = false;
        paint.setAntiAlias(true);
        this.b = (Decoder) hc(hcVar, this);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (this.b.tc()) {
            this.b.tt();
        }
        this.b.mk();
        b();
    }

    private void b() {
        this.b.d(this);
        if (this.tc) {
            this.b.gb();
        } else {
            if (this.b.tc()) {
                return;
            }
            this.b.gb();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        c();
    }

    private void c() {
        this.b.hc(this);
        if (this.tc) {
            this.b.tt();
        } else {
            this.b.u();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.b.tc();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Bitmap bitmap = this.h;
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        canvas.setDrawFilter(this.c);
        canvas.drawBitmap(this.h, this.u, this.hc);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i, int i2, int i3, int i4) {
        super.setBounds(i, i2, i3, i4);
        boolean zHc = this.b.hc(getBounds().width(), getBounds().height());
        this.u.setScale(((getBounds().width() * 1.0f) * this.b.mq()) / this.b.an().width(), ((getBounds().height() * 1.0f) * this.b.mq()) / this.b.an().height());
        if (zHc) {
            this.h = Bitmap.createBitmap(this.b.an().width() / this.b.mq(), this.b.an().height() / this.b.mq(), Bitmap.Config.ARGB_4444);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.hc.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.hc.setColorFilter(colorFilter);
    }

    @Override // com.bytedance.adsdk.d.d.d.tt.d
    public void d() {
        Message.obtain(this.gb, 1).sendToTarget();
    }

    @Override // com.bytedance.adsdk.d.d.d.tt.d
    public void hc(ByteBuffer byteBuffer) {
        if (isRunning()) {
            Bitmap bitmap = this.h;
            if (bitmap == null || bitmap.isRecycled()) {
                this.h = Bitmap.createBitmap(this.b.an().width() / this.b.mq(), this.b.an().height() / this.b.mq(), Bitmap.Config.ARGB_4444);
            }
            byteBuffer.rewind();
            if (byteBuffer.remaining() < this.h.getByteCount()) {
                mq.c(d, "onRender:Buffer not large enough for pixels");
            } else {
                this.h.copyPixelsFromBuffer(byteBuffer);
                this.gb.post(this.tt);
            }
        }
    }

    @Override // com.bytedance.adsdk.d.d.d.tt.d
    public void hc() {
        Message.obtain(this.gb, 2).sendToTarget();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        u();
        if (this.tc) {
            if (z) {
                if (!isRunning()) {
                    b();
                }
            } else if (isRunning()) {
                c();
            }
        }
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.mq) {
            return -1;
        }
        try {
            return this.b.an().width();
        } catch (Exception unused) {
            return 0;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.mq) {
            return -1;
        }
        try {
            return this.b.an().height();
        } catch (Exception unused) {
            return 0;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.Callback getCallback() {
        return super.getCallback();
    }

    private void u() {
        ArrayList arrayList = new ArrayList();
        Drawable.Callback callback = getCallback();
        boolean z = false;
        for (WeakReference weakReference : new HashSet(this.mk)) {
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
            this.mk.remove((WeakReference) it.next());
        }
        if (z) {
            return;
        }
        this.mk.add(new WeakReference<>(callback));
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        super.invalidateSelf();
        Iterator it = new HashSet(this.mk).iterator();
        while (it.hasNext()) {
            Drawable.Callback callback = (Drawable.Callback) ((WeakReference) it.next()).get();
            if (callback != null && callback != getCallback()) {
                callback.invalidateDrawable(this);
            }
        }
    }
}
