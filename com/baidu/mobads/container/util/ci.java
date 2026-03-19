package com.baidu.mobads.container.util;

import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class ci implements Handler.Callback, View.OnAttachStateChangeListener {
    private static final int a = 1;
    private static final int b = 2;
    private static final int c = 300;
    private static final int d = 50;
    private static final int e = 3000;
    private static final int f = -1;
    private static final int g = 0;
    private static final int h = 1;
    private static final int i = 2;
    private static final int j = 3;
    private static final int k = 4;
    private static ci l;
    private HandlerThread n;
    private volatile Handler q;
    private Handler r;
    private final CopyOnWriteArrayList<c> m = new CopyOnWriteArrayList<>();
    private int o = 30000;
    private final AtomicLong p = new AtomicLong();
    private int s = -3;

    public interface a extends b {
        void a(View view);
    }

    public interface b {
        void a(View view, boolean z);
    }

    private ci() {
    }

    public static ci a() {
        if (l == null) {
            synchronized (ci.class) {
                if (l == null) {
                    l = new ci();
                    l.d();
                }
            }
        }
        return l;
    }

    public static boolean a(View view) {
        if (view != null) {
            try {
                if (view.isShown()) {
                    if (!view.getGlobalVisibleRect(new Rect())) {
                        return false;
                    }
                    long height = view.getHeight() * view.getWidth();
                    return height > 0 && (r1.height() * r1.width()) * 100 >= height * 50;
                }
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        }
        return false;
    }

    private int a(c cVar) {
        try {
            View viewA = cVar.a();
            if (viewA != null && viewA.isShown()) {
                if (cVar.d && !viewA.hasWindowFocus()) {
                    return 1;
                }
                if (!viewA.getGlobalVisibleRect(new Rect())) {
                    return 1;
                }
                long jHeight = r2.height() * r2.width();
                long height = viewA.getHeight() * viewA.getWidth();
                if (height <= 0) {
                    return 1;
                }
                if (jHeight * 100 < cVar.e * height) {
                    return 1;
                }
                return 2;
            }
            return 1;
        } catch (Throwable th) {
            th.printStackTrace();
            return 1;
        }
    }

    public void a(View view, b bVar, JSONObject jSONObject) {
        if (view != null && bVar != null) {
            c();
            c cVarC = c(view);
            if (cVarC == null) {
                cVarC = new c(view);
                b(cVarC);
            }
            cVarC.a(bVar);
            cVarC.a(jSONObject);
            if (this.q != null) {
                this.q.sendEmptyMessage(1);
            }
        }
    }

    public void a(View view, b bVar) {
        a(view, bVar, null);
    }

    public void b(View view) {
        if (view != null) {
            c();
            c cVarC = c(view);
            if (cVarC != null) {
                cVarC.a(4);
            }
            if (this.q != null) {
                this.q.sendEmptyMessage(1);
            }
        }
    }

    public void b() {
        this.m.clear();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        a(c(view), 0);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        c cVarC = c(view);
        if (cVarC != null) {
            a(cVarC, 3);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 1) {
            f();
            h();
            i();
            if (this.m.size() > 0) {
                if (this.q != null) {
                    this.q.sendEmptyMessageDelayed(1, 300L);
                    return false;
                }
                return false;
            }
            if (this.q != null) {
                this.q.sendEmptyMessageDelayed(2, this.o);
                return false;
            }
            return false;
        }
        if (message.what == 2) {
            g();
            return false;
        }
        return false;
    }

    private void c() {
        e();
        if (this.q != null) {
            this.q.removeCallbacksAndMessages(null);
        }
    }

    private void d() {
        if (this.r == null) {
            this.r = new Handler(Looper.getMainLooper());
        }
    }

    private void e() {
        synchronized (ci.class) {
            f();
            if (this.q == null) {
                if (com.baidu.mobads.container.h.a.a().r()) {
                    this.q = new Handler(Looper.getMainLooper(), this);
                } else {
                    this.n = new HandlerThread("mobads-msg-thread");
                    if (!this.n.isAlive()) {
                        this.n.start();
                    }
                    this.q = new Handler(this.n.getLooper(), this);
                }
            }
        }
    }

    private void f() {
        this.p.set(System.currentTimeMillis() + this.o);
    }

    private void g() {
        synchronized (ci.class) {
            if (System.currentTimeMillis() > this.p.get()) {
                this.q = null;
                this.p.set(0L);
                if (this.n != null && this.n.isAlive()) {
                    if (Build.VERSION.SDK_INT >= 18) {
                        this.n.quitSafely();
                    } else {
                        this.n.quit();
                    }
                    this.n = null;
                }
            }
        }
    }

    private void b(c cVar) {
        View viewA = cVar.a();
        if (viewA != null) {
            viewA.addOnAttachStateChangeListener(this);
            this.m.add(cVar);
        }
    }

    private void c(c cVar) {
        View viewA = cVar.a();
        if (viewA != null) {
            viewA.removeOnAttachStateChangeListener(this);
        }
        this.m.remove(cVar);
    }

    private c c(View view) {
        Iterator<c> it = this.m.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next.a(view)) {
                return next;
            }
        }
        return null;
    }

    private void h() {
        Iterator<c> it = this.m.iterator();
        while (it.hasNext()) {
            c next = it.next();
            int iC = next.c();
            if (iC != 4 && (iC != 2 || System.currentTimeMillis() - next.g() >= 800)) {
                int iA = a(next);
                if (iC != 3) {
                    a(next, iA);
                } else if (2 == iA) {
                    a(next, iA);
                } else if (next.d() || System.currentTimeMillis() > next.e() + com.alipay.sdk.m.u.b.a) {
                    next.a(4);
                }
            }
        }
    }

    private void i() {
        int i2 = 0;
        while (i2 < this.m.size()) {
            c cVar = this.m.get(i2);
            if (cVar.c() == 4) {
                c(cVar);
            } else {
                i2++;
            }
        }
    }

    private void a(c cVar, int i2) {
        if (cVar != null) {
            int iC = cVar.c();
            if (iC != 4 && iC != i2) {
                cVar.a(i2);
                if (2 == iC || 2 == i2) {
                    a(cVar, i2 == 2);
                }
                if (3 == i2) {
                    d(cVar);
                }
            }
            cVar.f();
        }
    }

    private void a(c cVar, boolean z) {
        if (cVar != null && cVar.b() != null) {
            a(new cj(this, cVar, z));
        }
    }

    private void d(c cVar) {
        if (cVar != null && (cVar.b() instanceof a)) {
            a(new ck(this, cVar));
        }
    }

    private void a(Runnable runnable) {
        if (this.r != null) {
            this.r.post(runnable);
        }
    }

    public static class c {
        private final WeakReference<View> a;
        private WeakReference<b> b;
        private final AtomicInteger c = new AtomicInteger(-1);
        private boolean d = false;
        private int e = 50;
        private volatile long f = 0;
        private volatile long g = 0;
        private boolean h = false;

        public c(View view) {
            this.a = new WeakReference<>(view);
        }

        public void a(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.d = jSONObject.optBoolean("window_focus", false);
                this.e = jSONObject.optInt("visible_percent", 50);
            }
        }

        public void a(b bVar) {
            if (this.b != null) {
                this.b.clear();
            }
            this.b = new WeakReference<>(bVar);
            this.d = false;
            this.e = 50;
            this.f = System.currentTimeMillis();
            this.g = System.currentTimeMillis();
            this.c.set(-1);
        }

        public View a() {
            View view = this.a.get();
            if (view == null) {
                this.c.set(4);
            }
            return view;
        }

        public b b() {
            if (this.b != null) {
                b bVar = this.b.get();
                if (bVar == null) {
                    this.c.set(4);
                }
                return bVar;
            }
            return null;
        }

        public boolean a(View view) {
            return view != null && view == this.a.get();
        }

        public int c() {
            return this.c.get();
        }

        public void a(int i) {
            if (this.c.getAndSet(i) != i) {
                this.f = System.currentTimeMillis();
            } else if (2 == i) {
                this.h = true;
            }
        }

        public boolean d() {
            return this.h;
        }

        public long e() {
            return this.f;
        }

        public void f() {
            this.g = System.currentTimeMillis();
        }

        public long g() {
            return this.g;
        }
    }
}
