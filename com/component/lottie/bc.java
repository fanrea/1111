package com.component.lottie;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class bc<T> {
    private final Set<ay<T>> a;
    private final Set<ay<Throwable>> b;
    private final Handler c;
    private volatile bb<T> d;

    public bc(Callable<bb<T>> callable) {
        this(callable, false);
    }

    bc(Callable<bb<T>> callable, boolean z) {
        this.a = new LinkedHashSet(1);
        this.b = new LinkedHashSet(1);
        this.c = new Handler(Looper.getMainLooper());
        this.d = null;
        if (z) {
            try {
                a((bb) callable.call());
                return;
            } catch (Throwable th) {
                a((bb) new bb<>(th));
                return;
            }
        }
        com.baidu.mobads.container.d.b.a().a(new a(callable), 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(bb<T> bbVar) {
        if (this.d != null) {
            throw new IllegalStateException("A task may only be set once.");
        }
        this.d = bbVar;
        a();
    }

    public synchronized bc<T> a(ay<T> ayVar) {
        bb<T> bbVar = this.d;
        if (bbVar != null && bbVar.a() != null) {
            ayVar.a(bbVar.a());
        }
        this.a.add(ayVar);
        return this;
    }

    public synchronized bc<T> b(ay<T> ayVar) {
        this.a.remove(ayVar);
        return this;
    }

    public synchronized bc<T> c(ay<Throwable> ayVar) {
        bb<T> bbVar = this.d;
        if (bbVar != null && bbVar.b() != null) {
            ayVar.a(bbVar.b());
        }
        this.b.add(ayVar);
        return this;
    }

    public synchronized bc<T> d(ay<Throwable> ayVar) {
        this.b.remove(ayVar);
        return this;
    }

    private void a() {
        this.c.post(new bd(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(T t) {
        Iterator it = new ArrayList(this.a).iterator();
        while (it.hasNext()) {
            ((ay) it.next()).a(t);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(Throwable th) {
        ArrayList arrayList = new ArrayList(this.b);
        if (arrayList.isEmpty()) {
            com.component.lottie.g.c.b("Lottie encountered an error but no failure listener was added:", th);
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((ay) it.next()).a(th);
        }
    }

    private class a extends FutureTask<bb<T>> {
        a(Callable<bb<T>> callable) {
            super(callable);
        }

        @Override // java.util.concurrent.FutureTask
        protected void done() {
            if (!isCancelled()) {
                try {
                    bc.this.a((bb) get());
                } catch (InterruptedException e) {
                    bc.this.a(new bb((Throwable) e));
                } catch (ExecutionException e2) {
                    bc.this.a(new bb((Throwable) e2));
                }
            }
        }
    }
}
