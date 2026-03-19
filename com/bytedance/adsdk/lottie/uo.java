package com.bytedance.adsdk.lottie;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class uo<T> {
    public static Executor d = com.bytedance.sdk.component.tc.b.hc(new com.bytedance.sdk.component.tc.tc("ie/LottieTask"));
    private final Set<tc<Throwable>> b;
    private final Handler c;
    private final Set<tc<T>> hc;
    private volatile mq<T> u;

    public uo(Callable<mq<T>> callable) {
        this(callable, false);
    }

    uo(Callable<mq<T>> callable, boolean z) {
        this.hc = new LinkedHashSet(1);
        this.b = new LinkedHashSet(1);
        this.c = new Handler(Looper.getMainLooper());
        this.u = null;
        if (z) {
            try {
                setResult(callable.call());
                return;
            } catch (Throwable th) {
                setResult(new mq<>(th));
                return;
            }
        }
        d.execute(new d(callable));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setResult(mq<T> mqVar) {
        if (this.u != null) {
            throw new IllegalStateException("A task may only be set once.");
        }
        this.u = mqVar;
        d();
    }

    public synchronized uo<T> d(tc<T> tcVar) {
        mq<T> mqVar = this.u;
        if (mqVar != null && mqVar.d() != null) {
            tcVar.d(mqVar.d());
        }
        this.hc.add(tcVar);
        return this;
    }

    public synchronized uo<T> hc(tc<T> tcVar) {
        this.hc.remove(tcVar);
        return this;
    }

    public synchronized uo<T> b(tc<Throwable> tcVar) {
        mq<T> mqVar = this.u;
        if (mqVar != null && mqVar.hc() != null) {
            tcVar.d(mqVar.hc());
        }
        this.b.add(tcVar);
        return this;
    }

    public synchronized uo<T> c(tc<Throwable> tcVar) {
        this.b.remove(tcVar);
        return this;
    }

    private void d() {
        this.c.post(new Runnable() { // from class: com.bytedance.adsdk.lottie.uo.1
            @Override // java.lang.Runnable
            public void run() {
                mq mqVar = uo.this.u;
                if (mqVar == null) {
                    return;
                }
                if (mqVar.d() != null) {
                    uo.this.d((uo) mqVar.d());
                } else {
                    uo.this.d(mqVar.hc());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void d(T t) {
        Iterator it = new ArrayList(this.hc).iterator();
        while (it.hasNext()) {
            ((tc) it.next()).d(t);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void d(Throwable th) {
        ArrayList arrayList = new ArrayList(this.b);
        if (arrayList.isEmpty()) {
            com.bytedance.adsdk.lottie.u.u.d("Lottie encountered an error but no failure listener was added:", th);
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((tc) it.next()).d(th);
        }
    }

    private class d extends FutureTask<mq<T>> {
        d(Callable<mq<T>> callable) {
            super(callable);
        }

        @Override // java.util.concurrent.FutureTask
        protected void done() {
            if (isCancelled()) {
                return;
            }
            try {
                uo.this.setResult(get());
            } catch (InterruptedException | ExecutionException e) {
                uo.this.setResult(new mq(e));
            }
        }
    }
}
