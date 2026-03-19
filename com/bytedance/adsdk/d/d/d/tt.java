package com.bytedance.adsdk.d.d.d;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.adsdk.d.d.hc.an;
import com.bytedance.adsdk.d.d.hc.h;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.LockSupport;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class tt<R extends com.bytedance.adsdk.d.d.hc.an, W extends com.bytedance.adsdk.d.d.hc.h> {
    private static final String h = "tt";
    private static final Rect k = new Rect();
    protected volatile Rect an;
    protected int b;
    protected Map<Bitmap, Canvas> c;
    private final Set<Bitmap> cb;
    private final Runnable e;
    private final com.bytedance.adsdk.d.d.b.hc gb;
    private boolean jh;
    private final Set<d> mq;
    private R rf;
    private volatile hc sy;
    private int tc;
    private final Handler tt;
    protected ByteBuffer u;
    private final AtomicBoolean uo;
    private final Object w;
    private W yo;
    protected List<gb<R, W>> d = new ArrayList();
    protected int hc = -1;
    private Integer mk = null;

    public interface d {
        void d();

        void hc();

        void hc(ByteBuffer byteBuffer);
    }

    private enum hc {
        IDLE,
        RUNNING,
        INITIALIZING,
        FINISHING
    }

    private String e() {
        return "";
    }

    protected abstract R b(com.bytedance.adsdk.d.d.hc.an anVar);

    protected abstract void b();

    protected abstract W c();

    protected abstract void d(gb<R, W> gbVar);

    protected abstract int hc();

    protected abstract Rect hc(R r) throws IOException;

    protected Bitmap d(int i, int i2) {
        synchronized (this.w) {
            Iterator<Bitmap> it = this.cb.iterator();
            Bitmap bitmapCreateBitmap = null;
            while (it.hasNext()) {
                int i3 = i * i2 * 4;
                Bitmap next = it.next();
                if (Build.VERSION.SDK_INT >= 19) {
                    if (next != null && next.getAllocationByteCount() >= i3) {
                        it.remove();
                        if ((next.getWidth() != i || next.getHeight() != i2) && i > 0 && i2 > 0) {
                            next.reconfigure(i, i2, Bitmap.Config.ARGB_4444);
                        }
                        next.eraseColor(0);
                        return next;
                    }
                } else if (next != null && next.getByteCount() >= i3) {
                    if (next.getWidth() == i && next.getHeight() == i2) {
                        it.remove();
                        next.eraseColor(0);
                    }
                    return next;
                }
                bitmapCreateBitmap = next;
            }
            if (i <= 0 || i2 <= 0) {
                return null;
            }
            try {
                bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_4444);
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.mq.d(e);
            } catch (OutOfMemoryError e2) {
                com.bytedance.sdk.component.utils.mq.d(e2);
            }
            return bitmapCreateBitmap;
        }
    }

    protected void d(Bitmap bitmap) {
        synchronized (this.w) {
            if (bitmap != null) {
                this.cb.add(bitmap);
            }
        }
    }

    public tt(com.bytedance.adsdk.d.d.b.hc hcVar, d dVar) {
        HashSet hashSet = new HashSet();
        this.mq = hashSet;
        this.uo = new AtomicBoolean(true);
        this.e = new Runnable() { // from class: com.bytedance.adsdk.d.d.d.tt.1
            @Override // java.lang.Runnable
            public void run() {
                if (tt.this.uo.get()) {
                    return;
                }
                if (tt.this.w()) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    tt.this.tt.postDelayed(this, Math.max(0L, tt.this.yo() - (System.currentTimeMillis() - jCurrentTimeMillis)));
                    Iterator it = tt.this.mq.iterator();
                    while (it.hasNext()) {
                        ((d) it.next()).hc(tt.this.u);
                    }
                    return;
                }
                tt.this.tt();
            }
        };
        this.b = 1;
        this.cb = new HashSet();
        this.w = new Object();
        this.c = new WeakHashMap();
        this.yo = (W) c();
        this.rf = null;
        this.jh = false;
        this.sy = hc.IDLE;
        this.gb = hcVar;
        if (dVar != null) {
            hashSet.add(dVar);
        }
        this.tt = com.bytedance.sdk.component.tc.hc.d.d().hc();
    }

    public void d(final d dVar) {
        this.tt.post(new Runnable() { // from class: com.bytedance.adsdk.d.d.d.tt.2
            @Override // java.lang.Runnable
            public void run() {
                tt.this.mq.add(dVar);
            }
        });
    }

    public void hc(final d dVar) {
        this.tt.post(new Runnable() { // from class: com.bytedance.adsdk.d.d.d.tt.3
            @Override // java.lang.Runnable
            public void run() {
                tt.this.mq.remove(dVar);
            }
        });
    }

    public void u() {
        this.tt.post(new Runnable() { // from class: com.bytedance.adsdk.d.d.d.tt.4
            @Override // java.lang.Runnable
            public void run() {
                if (tt.this.mq.size() == 0) {
                    tt.this.tt();
                }
            }
        });
    }

    public Rect an() {
        if (this.an == null) {
            if (this.sy == hc.FINISHING) {
                com.bytedance.sdk.component.utils.mq.c(h, "In finishing,do not interrupt");
            }
            final Thread threadCurrentThread = Thread.currentThread();
            this.tt.post(new Runnable() { // from class: com.bytedance.adsdk.d.d.d.tt.5
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        try {
                            if (tt.this.an == null) {
                                if (tt.this.rf != null) {
                                    tt.this.rf.d_();
                                } else {
                                    tt ttVar = tt.this;
                                    ttVar.rf = ttVar.b(ttVar.gb.hc());
                                }
                                tt ttVar2 = tt.this;
                                ttVar2.d(ttVar2.hc((tt) ttVar2.rf));
                            }
                        } catch (Exception e) {
                            com.bytedance.sdk.component.utils.mq.d(e);
                            tt.this.an = tt.k;
                        }
                    } finally {
                        LockSupport.unpark(threadCurrentThread);
                    }
                }
            });
            LockSupport.park(threadCurrentThread);
        }
        return this.an == null ? k : this.an;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Rect rect) {
        this.an = rect;
        int iWidth = rect.width() * rect.height();
        int i = this.b;
        this.u = ByteBuffer.allocate(((iWidth / (i * i)) + 1) * 4);
        if (this.yo == null) {
            this.yo = (W) c();
        }
    }

    public int h() {
        return this.d.size();
    }

    public void gb() {
        if (this.an == k) {
            return;
        }
        if (this.sy == hc.RUNNING || this.sy == hc.INITIALIZING) {
            com.bytedance.sdk.component.utils.mq.d(h, e() + " Already started");
            return;
        }
        if (this.sy == hc.FINISHING) {
            com.bytedance.sdk.component.utils.mq.c(h, e() + " Processing,wait for finish at " + this.sy);
        }
        this.sy = hc.INITIALIZING;
        if (Looper.myLooper() == this.tt.getLooper()) {
            d();
        } else {
            this.tt.post(new Runnable() { // from class: com.bytedance.adsdk.d.d.d.tt.6
                @Override // java.lang.Runnable
                public void run() {
                    tt.this.d();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        this.uo.compareAndSet(true, false);
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            if (this.d.size() == 0) {
                try {
                    R r = this.rf;
                    if (r == null) {
                        this.rf = (R) b(this.gb.hc());
                    } else {
                        r.d_();
                    }
                    d(hc((tt<R, W>) this.rf));
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.mq.d(th);
                }
            }
            String str = h;
            com.bytedance.sdk.component.utils.mq.d(str, e() + " Set state to RUNNING,cost " + (System.currentTimeMillis() - jCurrentTimeMillis));
            this.sy = hc.RUNNING;
            if (cb() == 0 || !this.jh) {
                this.hc = -1;
                this.e.run();
                Iterator<d> it = this.mq.iterator();
                while (it.hasNext()) {
                    it.next().d();
                }
                return;
            }
            com.bytedance.sdk.component.utils.mq.d(str, e() + " No need to started");
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.mq.d(h, e() + " Set state to RUNNING,cost " + (System.currentTimeMillis() - jCurrentTimeMillis));
            this.sy = hc.RUNNING;
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        this.tt.removeCallbacks(this.e);
        this.d.clear();
        synchronized (this.w) {
            for (Bitmap bitmap : this.cb) {
                if (bitmap != null && !bitmap.isRecycled()) {
                    bitmap.recycle();
                }
            }
            this.cb.clear();
        }
        if (this.u != null) {
            this.u = null;
        }
        this.c.clear();
        try {
            if (this.rf != null) {
                this.rf = null;
            }
        } catch (IOException e) {
            com.bytedance.sdk.component.utils.mq.d(e);
        }
        b();
        this.sy = hc.IDLE;
        Iterator<d> it = this.mq.iterator();
        while (it.hasNext()) {
            it.next().hc();
        }
    }

    public void tt() {
        if (this.an == k) {
            return;
        }
        if (this.sy == hc.FINISHING || this.sy == hc.IDLE) {
            com.bytedance.sdk.component.utils.mq.d(h, e() + "No need to stop");
            return;
        }
        if (this.sy == hc.INITIALIZING) {
            com.bytedance.sdk.component.utils.mq.c(h, e() + "Processing,wait for finish at " + this.sy);
        }
        this.sy = hc.FINISHING;
        if (Looper.myLooper() == this.tt.getLooper()) {
            k();
        } else {
            this.tt.post(new Runnable() { // from class: com.bytedance.adsdk.d.d.d.tt.7
                @Override // java.lang.Runnable
                public void run() {
                    tt.this.k();
                }
            });
        }
    }

    public boolean tc() {
        return this.sy == hc.RUNNING || this.sy == hc.INITIALIZING;
    }

    public void mk() {
        this.tt.post(new Runnable() { // from class: com.bytedance.adsdk.d.d.d.tt.8
            @Override // java.lang.Runnable
            public void run() {
                tt.this.tc = 0;
                tt.this.hc = -1;
                tt.this.jh = false;
            }
        });
    }

    public int mq() {
        return this.b;
    }

    public boolean hc(int i, int i2) {
        final int iB = b(i, i2);
        if (iB == this.b) {
            return false;
        }
        final boolean zTc = tc();
        this.tt.removeCallbacks(this.e);
        this.tt.post(new Runnable() { // from class: com.bytedance.adsdk.d.d.d.tt.9
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                tt.this.k();
                try {
                    tt.this.b = iB;
                    tt ttVar = tt.this;
                    ttVar.d(ttVar.hc((tt) ttVar.b(ttVar.gb.hc())));
                    if (zTc) {
                        tt.this.d();
                    }
                } catch (IOException e) {
                    com.bytedance.sdk.component.utils.mq.d(e);
                }
            }
        });
        return true;
    }

    protected int b(int i, int i2) {
        int i3 = 1;
        if (i != 0 && i2 != 0) {
            int iMin = Math.min(an().width() / i, an().height() / i2);
            while (true) {
                int i4 = i3 * 2;
                if (i4 > iMin) {
                    break;
                }
                i3 = i4;
            }
        }
        return i3;
    }

    private int cb() {
        Integer num = this.mk;
        return num != null ? num.intValue() : hc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean w() {
        if (!tc() || this.d.size() == 0) {
            return false;
        }
        if (cb() <= 0 || this.tc < cb() - 1) {
            return true;
        }
        if (this.tc == cb() - 1 && this.hc < h() - 1) {
            return true;
        }
        this.jh = true;
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long yo() {
        int i = this.hc + 1;
        this.hc = i;
        if (i >= h()) {
            this.hc = 0;
            this.tc++;
        }
        gb<R, W> gbVarD = d(this.hc);
        if (gbVarD == null) {
            return 0L;
        }
        d(gbVarD);
        return gbVarD.mq;
    }

    public gb<R, W> d(int i) {
        if (i < 0 || i >= this.d.size()) {
            return null;
        }
        return this.d.get(i);
    }
}
