package com.kwad.lottie;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class k<T> {
    public static Executor bkV = GlobalThreadPools.ace();
    private Thread bkW;
    private final Set<h<T>> bkX;
    private final Set<h<Throwable>> bkY;
    private final FutureTask<j<T>> bkZ;
    private volatile j<T> bla;
    private final Handler handler;

    public k(Callable<j<T>> callable) {
        this(callable, false);
    }

    private k(Callable<j<T>> callable, boolean z) {
        this.bkX = new LinkedHashSet(1);
        this.bkY = new LinkedHashSet(1);
        this.handler = new Handler(Looper.getMainLooper());
        this.bla = null;
        FutureTask<j<T>> futureTask = new FutureTask<>(callable);
        this.bkZ = futureTask;
        bkV.execute(futureTask);
        Qw();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(j<T> jVar) {
        if (this.bla != null) {
            throw new IllegalStateException("A task may only be set once.");
        }
        this.bla = jVar;
        kL();
    }

    public final synchronized k<T> a(h<T> hVar) {
        if (this.bla != null && this.bla.getValue() != null) {
            hVar.onResult(this.bla.getValue());
        }
        this.bkX.add(hVar);
        Qw();
        return this;
    }

    public final synchronized k<T> b(h<T> hVar) {
        this.bkX.remove(hVar);
        Qx();
        return this;
    }

    public final synchronized k<T> c(h<Throwable> hVar) {
        if (this.bla != null && this.bla.getException() != null) {
            hVar.onResult(this.bla.getException());
        }
        this.bkY.add(hVar);
        Qw();
        return this;
    }

    public final synchronized k<T> d(h<Throwable> hVar) {
        this.bkY.remove(hVar);
        Qx();
        return this;
    }

    private void kL() {
        this.handler.post(new Runnable() { // from class: com.kwad.lottie.k.1
            @Override // java.lang.Runnable
            public final void run() {
                if (k.this.bla == null || k.this.bkZ.isCancelled()) {
                    return;
                }
                j jVar = k.this.bla;
                if (jVar.getValue() != null) {
                    k.this.l(jVar.getValue());
                } else {
                    k.this.o(jVar.getException());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(T t) {
        Iterator it = new ArrayList(this.bkX).iterator();
        while (it.hasNext()) {
            ((h) it.next()).onResult(t);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(Throwable th) {
        ArrayList arrayList = new ArrayList(this.bkY);
        if (arrayList.isEmpty()) {
            Log.w(com.component.lottie.c.b, "Lottie encountered an error but no failure listener was added.", th);
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((h) it.next()).onResult(th);
        }
    }

    private synchronized void Qw() {
        if (!Qy() && this.bla == null) {
            Thread thread = new Thread("LottieTaskObserver") { // from class: com.kwad.lottie.k.2
                private boolean blc = false;

                @Override // java.lang.Thread, java.lang.Runnable
                public final void run() {
                    while (!isInterrupted() && !this.blc) {
                        if (k.this.bkZ.isDone()) {
                            try {
                                k kVar = k.this;
                                kVar.a((j) kVar.bkZ.get());
                            } catch (InterruptedException | ExecutionException e) {
                                k.this.a(new j(e));
                            }
                            this.blc = true;
                            k.this.Qx();
                        }
                    }
                }
            };
            this.bkW = thread;
            thread.start();
            c.de("Starting TaskObserver thread");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void Qx() {
        if (Qy()) {
            if (this.bkX.isEmpty() || this.bla != null) {
                this.bkW.interrupt();
                this.bkW = null;
                c.de("Stopping TaskObserver thread");
            }
        }
    }

    private boolean Qy() {
        Thread thread = this.bkW;
        return thread != null && thread.isAlive();
    }
}
