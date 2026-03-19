package com.tachikoma.lottie;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class m<T> {
    public static Executor Im = Executors.newCachedThreadPool();
    private m<T>.a In;
    private final Set<i<T>> Io;
    private final Set<i<Throwable>> Ip;
    private volatile l<T> Iq;
    private final Handler handler;

    public m(Callable<l<T>> callable) {
        this(callable, false);
    }

    private m(Callable<l<T>> callable, boolean z) {
        this.Io = new LinkedHashSet(1);
        this.Ip = new LinkedHashSet(1);
        this.handler = new Handler(Looper.getMainLooper());
        this.Iq = null;
        this.In = new a(callable);
        Im.execute(this.In);
    }

    public final void R(boolean z) {
        m<T>.a aVar = this.In;
        if (aVar != null) {
            aVar.cancel(z);
        }
    }

    public final synchronized void removeAllListeners() {
        this.Io.clear();
        this.Ip.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(l<T> lVar) {
        if (this.Iq != null) {
            throw new IllegalStateException("A task may only be set once.");
        }
        this.Iq = lVar;
        jN();
    }

    public final synchronized m<T> a(i<T> iVar) {
        if (this.Iq != null && this.Iq.getValue() != null) {
            iVar.onResult(this.Iq.getValue());
        }
        this.Io.add(iVar);
        return this;
    }

    public final synchronized m<T> b(i<T> iVar) {
        this.Io.remove(iVar);
        return this;
    }

    public final synchronized m<T> c(i<Throwable> iVar) {
        if (this.Iq != null && this.Iq.getException() != null) {
            iVar.onResult(this.Iq.getException());
        }
        this.Ip.add(iVar);
        return this;
    }

    public final synchronized m<T> d(i<Throwable> iVar) {
        this.Ip.remove(iVar);
        return this;
    }

    private void jN() {
        this.handler.post(new Runnable() { // from class: com.tachikoma.lottie.m.1
            @Override // java.lang.Runnable
            public final void run() {
                if (m.this.Iq == null) {
                    return;
                }
                l lVar = m.this.Iq;
                if (lVar.getValue() != null) {
                    m.this.v(lVar.getValue());
                } else {
                    m.this.c(lVar.getException());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void v(T t) {
        Iterator it = new ArrayList(this.Io).iterator();
        while (it.hasNext()) {
            ((i) it.next()).onResult(t);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void c(Throwable th) {
        ArrayList arrayList = new ArrayList(this.Ip);
        if (arrayList.isEmpty()) {
            Log.w(com.component.lottie.c.b, "Lottie encountered an error but no failure listener was added.", th);
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((i) it.next()).onResult(th);
        }
    }

    class a extends FutureTask<l<T>> {
        a(Callable<l<T>> callable) {
            super(callable);
        }

        @Override // java.util.concurrent.FutureTask
        protected final void done() {
            if (isCancelled()) {
                return;
            }
            try {
                m.this.a(get());
            } catch (InterruptedException | ExecutionException e) {
                m.this.a(new l(e));
            }
        }
    }
}
