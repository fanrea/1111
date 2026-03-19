package com.qq.e.comm.plugin;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.qq.e.comm.plugin.jv;
import com.qq.e.comm.plugin.y50;
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

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public abstract class bf<R extends jv, W extends y50> {
    private static final String u = "bf";
    private static final int v = r1.d().f().a("alspaf", 500);
    private static final Rect w = new Rect();
    private final int a;
    private final mo b;
    private final Handler c;
    private int f;
    private final Set<j> h;
    private final AtomicBoolean i;
    private final Runnable j;
    protected int k;
    private final Set<Bitmap> l;
    private final Object m;
    protected Map<Bitmap, Canvas> n;
    protected ByteBuffer o;
    protected volatile Rect p;
    private W q;
    private R r;
    private boolean s;
    private volatile k t;
    protected List<xe<R, W>> d = new ArrayList();
    protected int e = -1;
    private Integer g = null;

    /* compiled from: A */
    public interface j {
        void a();

        void a(ByteBuffer byteBuffer);

        void b();
    }

    /* compiled from: A */
    private enum k {
        IDLE,
        RUNNING,
        INITIALIZING,
        FINISHING
    }

    private String c() {
        return "";
    }

    protected abstract R a(jv jvVar);

    protected abstract void a(xe<R, W> xeVar);

    protected abstract Rect b(R r) throws IOException;

    protected abstract int f();

    protected abstract W i();

    protected abstract void m();

    /* compiled from: A */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (bf.this.i.get()) {
                return;
            }
            if (bf.this.b()) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                bf.this.c.postDelayed(this, Math.max(0L, bf.this.p() - (System.currentTimeMillis() - jCurrentTimeMillis)));
                Iterator it = bf.this.h.iterator();
                while (it.hasNext()) {
                    ((j) it.next()).a(bf.this.o);
                }
                return;
            }
            bf.this.q();
        }
    }

    public bf(mo moVar, j jVar) {
        HashSet hashSet = new HashSet();
        this.h = hashSet;
        this.i = new AtomicBoolean(true);
        this.j = new a();
        this.k = 1;
        this.l = new HashSet();
        this.m = new Object();
        this.n = new WeakHashMap();
        this.q = (W) i();
        this.r = null;
        this.s = false;
        this.t = k.IDLE;
        this.b = moVar;
        if (jVar != null) {
            hashSet.add(jVar);
        }
        int iA = ze.b().a();
        this.a = iA;
        this.c = new Handler(ze.b().a(iA));
    }

    /* compiled from: A */
    class b implements Runnable {
        final /* synthetic */ j a;

        b(j jVar) {
            this.a = jVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            bf.this.h.add(this.a);
        }
    }

    /* compiled from: A */
    class c implements Runnable {
        final /* synthetic */ j a;

        c(j jVar) {
            this.a = jVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            bf.this.h.remove(this.a);
        }
    }

    /* compiled from: A */
    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (bf.this.h.size() == 0) {
                bf.this.q();
            }
        }
    }

    public void r() {
        this.c.post(new d());
    }

    /* compiled from: A */
    class e implements Runnable {
        final /* synthetic */ Thread a;

        e(Thread thread) {
            this.a = thread;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            try {
                if (bf.this.p == null) {
                    if (bf.this.r != null) {
                        bf.this.r.reset();
                    } else {
                        bf bfVar = bf.this;
                        bfVar.r = bfVar.a(bfVar.b.a());
                    }
                    bf bfVar2 = bf.this;
                    bfVar2.a(bfVar2.b((bf) bfVar2.r));
                }
            } catch (Exception e) {
                e.printStackTrace();
                bf.this.p = bf.w;
            } finally {
                LockSupport.unpark(this.a);
            }
        }
    }

    public Rect d() {
        if (this.p == null) {
            if (this.t == k.FINISHING) {
                Log.e(u, "In finishing,do not interrupt");
            }
            Thread threadCurrentThread = Thread.currentThread();
            this.c.post(new e(threadCurrentThread));
            int i2 = v;
            if (i2 > 0) {
                LockSupport.parkUntil(threadCurrentThread, i2);
            } else {
                LockSupport.park(threadCurrentThread);
            }
        }
        return this.p == null ? w : this.p;
    }

    public void o() {
        if (this.p == w) {
            return;
        }
        if (this.t != k.RUNNING) {
            k kVar = this.t;
            k kVar2 = k.INITIALIZING;
            if (kVar != kVar2) {
                if (this.t == k.FINISHING) {
                    Log.e(u, c() + " Processing,wait for finish at " + this.t);
                }
                this.t = kVar2;
                if (Looper.myLooper() == this.c.getLooper()) {
                    j();
                    return;
                } else {
                    this.c.post(new f());
                    return;
                }
            }
        }
        Log.i(u, c() + " Already started");
    }

    /* compiled from: A */
    class f implements Runnable {
        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            bf.this.j();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        this.i.compareAndSet(true, false);
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            if (e() == 0) {
                try {
                    R r = this.r;
                    if (r == null) {
                        this.r = (R) a(this.b.a());
                    } else {
                        r.reset();
                    }
                    a(b((bf<R, W>) this.r));
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            String str = u;
            Log.i(str, c() + " Set state to RUNNING,cost " + (System.currentTimeMillis() - jCurrentTimeMillis));
            this.t = k.RUNNING;
            if (g() != 0 && this.s) {
                Log.i(str, c() + " No need to started");
                return;
            }
            this.e = -1;
            this.j.run();
            Iterator<j> it = this.h.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        } catch (Throwable th2) {
            Log.i(u, c() + " Set state to RUNNING,cost " + (System.currentTimeMillis() - jCurrentTimeMillis));
            this.t = k.RUNNING;
            throw th2;
        }
    }

    public int e() {
        return this.d.size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        this.c.removeCallbacks(this.j);
        this.d.clear();
        synchronized (this.m) {
            for (Bitmap bitmap : this.l) {
                if (bitmap != null && !bitmap.isRecycled()) {
                    bitmap.recycle();
                }
            }
            this.l.clear();
        }
        if (this.o != null) {
            this.o = null;
        }
        this.n.clear();
        try {
            R r = this.r;
            if (r != null) {
                r.close();
                this.r = null;
            }
            W w2 = this.q;
            if (w2 != null) {
                w2.close();
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        m();
        this.t = k.IDLE;
        Iterator<j> it = this.h.iterator();
        while (it.hasNext()) {
            it.next().b();
        }
    }

    public void q() {
        if (this.p == w) {
            return;
        }
        k kVar = this.t;
        k kVar2 = k.FINISHING;
        if (kVar != kVar2 && this.t != k.IDLE) {
            if (this.t == k.INITIALIZING) {
                Log.e(u, c() + "Processing,wait for finish at " + this.t);
            }
            this.t = kVar2;
            if (Looper.myLooper() == this.c.getLooper()) {
                k();
                return;
            } else {
                this.c.post(new g());
                return;
            }
        }
        Log.i(u, c() + "No need to stop");
    }

    /* compiled from: A */
    class g implements Runnable {
        g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            bf.this.k();
        }
    }

    public void a(j jVar) {
        this.c.post(new b(jVar));
    }

    public boolean l() {
        return this.t == k.RUNNING || this.t == k.INITIALIZING;
    }

    /* compiled from: A */
    class h implements Runnable {
        h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            bf.this.f = 0;
            bf bfVar = bf.this;
            bfVar.e = -1;
            bfVar.s = false;
        }
    }

    public void n() {
        this.c.post(new h());
    }

    /* compiled from: A */
    class i implements Runnable {
        final /* synthetic */ int a;
        final /* synthetic */ boolean b;

        i(int i, boolean z) {
            this.a = i;
            this.b = z;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            bf.this.k();
            try {
                bf bfVar = bf.this;
                bfVar.k = this.a;
                bfVar.a(bfVar.b((bf) bfVar.a(bfVar.b.a())));
                if (this.b) {
                    bf.this.j();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public int h() {
        return this.k;
    }

    public int c(int i2, int i3) {
        int iA = a(i2, i3);
        if (iA != h()) {
            boolean zL = l();
            this.c.removeCallbacks(this.j);
            this.c.post(new i(iA, zL));
        }
        return iA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long p() {
        int i2 = this.e + 1;
        this.e = i2;
        if (i2 >= e()) {
            this.e = 0;
            this.f++;
        }
        xe<R, W> xeVarA = a(this.e);
        if (xeVarA == null) {
            return 0L;
        }
        a(xeVarA);
        return xeVarA.f;
    }

    private int g() {
        Integer num = this.g;
        return num != null ? num.intValue() : f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b() {
        if (!l() || e() == 0) {
            return false;
        }
        if (g() <= 0 || this.f < g() - 1) {
            return true;
        }
        if (this.f == g() - 1 && this.e < e() - 1) {
            return true;
        }
        this.s = true;
        return false;
    }

    protected Bitmap b(int i2, int i3) {
        synchronized (this.m) {
            Iterator<Bitmap> it = this.l.iterator();
            Bitmap bitmapCreateBitmap = null;
            while (it.hasNext()) {
                int i4 = i2 * i3 * 4;
                Bitmap next = it.next();
                if (Build.VERSION.SDK_INT >= 19) {
                    if (next != null && next.getAllocationByteCount() >= i4) {
                        it.remove();
                        if ((next.getWidth() != i2 || next.getHeight() != i3) && i2 > 0 && i3 > 0) {
                            next.reconfigure(i2, i3, Bitmap.Config.ARGB_8888);
                        }
                        next.eraseColor(0);
                        return next;
                    }
                } else if (next != null && next.getByteCount() >= i4) {
                    if (next.getWidth() == i2 && next.getHeight() == i3) {
                        it.remove();
                        next.eraseColor(0);
                    }
                    return next;
                }
                bitmapCreateBitmap = next;
            }
            if (i2 <= 0 || i3 <= 0) {
                return null;
            }
            try {
                bitmapCreateBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
            } catch (Exception e2) {
                e2.printStackTrace();
            } catch (OutOfMemoryError e3) {
                e3.printStackTrace();
            }
            return bitmapCreateBitmap;
        }
    }

    protected int a(int i2, int i3) {
        int i4 = 1;
        if (i2 != 0 && i3 != 0) {
            int iMin = Math.min(d().width() / i2, d().height() / i3);
            while (true) {
                int i5 = i4 * 2;
                if (i5 > iMin) {
                    break;
                }
                i4 = i5;
            }
        }
        return i4;
    }

    public void b(j jVar) {
        this.c.post(new c(jVar));
    }

    public void b(int i2) {
        this.g = Integer.valueOf(i2);
    }

    public xe<R, W> a(int i2) {
        if (i2 < 0 || i2 >= this.d.size()) {
            return null;
        }
        return this.d.get(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Rect rect) {
        this.p = rect;
        this.o = ByteBuffer.allocate((((rect.width() * rect.height()) / (h() * h())) + 1) * 4);
        if (this.q == null) {
            this.q = (W) i();
        }
    }

    protected void a(Bitmap bitmap) {
        synchronized (this.m) {
            if (bitmap != null) {
                this.l.add(bitmap);
            }
        }
    }
}
