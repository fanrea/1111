package com.bytedance.sdk.component.hc.d.d.hc;

import com.bytedance.sdk.component.hc.d.d.hc.d;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class c extends com.bytedance.sdk.component.hc.d.c {
    private ExecutorService d;
    private final Deque<d.C0279d> hc = new ArrayDeque();
    private final Deque<d.C0279d> b = new ArrayDeque();
    private final Deque<d> c = new ArrayDeque();
    private AtomicInteger u = new AtomicInteger(64);

    @Override // com.bytedance.sdk.component.hc.d.c
    public void hc(int i) {
    }

    public c() {
        if (this.d == null) {
            this.d = new com.bytedance.sdk.component.tc.c.c(0, Integer.MAX_VALUE, 20L, TimeUnit.SECONDS, new SynchronousQueue(), new ThreadFactory() { // from class: com.bytedance.sdk.component.hc.d.d.hc.c.1
                @Override // java.util.concurrent.ThreadFactory
                public Thread newThread(Runnable runnable) {
                    com.bytedance.sdk.component.tc.c.b bVar = new com.bytedance.sdk.component.tc.c.b(runnable, "systemHttp Dispatcher");
                    bVar.setDaemon(false);
                    bVar.setPriority(10);
                    return bVar;
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.hc.d.c
    public ExecutorService hc() {
        return this.d;
    }

    @Override // com.bytedance.sdk.component.hc.d.c
    public void d(int i) {
        this.u.set(i);
    }

    @Override // com.bytedance.sdk.component.hc.d.c
    public int d() {
        return this.u.get();
    }

    public synchronized void d(d.C0279d c0279d) {
        try {
            if (this.b.size() < d()) {
                this.b.add(c0279d);
                if (c0279d != null) {
                    c0279d.d();
                }
                hc().submit(c0279d);
                return;
            }
            this.hc.add(c0279d);
        } catch (Throwable unused) {
        }
    }

    synchronized void d(d dVar) {
        this.c.add(dVar);
    }

    void hc(d.C0279d c0279d) {
        d(this.b, c0279d, true);
    }

    void hc(d dVar) {
        d(this.c, dVar, false);
    }

    private <T> void d(Deque<T> deque, T t, boolean z) {
        synchronized (this) {
            deque.remove(t);
            if (z) {
                b();
            }
        }
    }

    private void b() {
        if (this.b.size() < d() && !this.hc.isEmpty()) {
            Iterator<d.C0279d> it = this.hc.iterator();
            while (it.hasNext()) {
                d.C0279d next = it.next();
                it.remove();
                this.b.add(next);
                if (next != null) {
                    next.d();
                }
                hc().submit(next);
                if (this.b.size() >= d()) {
                    return;
                }
            }
        }
    }
}
