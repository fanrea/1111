package com.bytedance.sdk.component.b.hc;

import com.bytedance.sdk.component.b.hc.yi;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class k {
    private Runnable b;
    private String c;
    private ExecutorService u;
    private int d = 64;
    private int hc = 5;
    private final Deque<yi.d> an = new ArrayDeque();
    private final Deque<yi.d> h = new ArrayDeque();
    private final Deque<yi> gb = new ArrayDeque();

    public k() {
    }

    public k(String str) {
        this.c = str;
    }

    public synchronized ExecutorService d() {
        if (this.u == null) {
            String str = this.c;
            this.u = new com.bytedance.sdk.component.tc.c.c(0, Integer.MAX_VALUE, 20L, TimeUnit.SECONDS, new SynchronousQueue(), com.bytedance.sdk.component.b.hc.d.b.d((str == null || str.length() == 0) ? "net" : this.c, false));
        }
        return this.u;
    }

    public synchronized void d(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("max < 1: ".concat(String.valueOf(i)));
        }
        this.d = i;
        b();
    }

    public synchronized void hc(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("max < 1: ".concat(String.valueOf(i)));
        }
        this.hc = i;
        b();
    }

    synchronized void d(yi.d dVar) {
        try {
            if (this.h.size() < this.d && b(dVar) < this.hc) {
                this.h.add(dVar);
                if (dVar != null) {
                    dVar.hc();
                }
                d().execute(dVar);
                return;
            }
            this.an.add(dVar);
        } catch (Throwable unused) {
        }
    }

    private void b() {
        if (this.h.size() < this.d && !this.an.isEmpty()) {
            Iterator<yi.d> it = this.an.iterator();
            while (it.hasNext()) {
                yi.d next = it.next();
                if (b(next) < this.hc) {
                    it.remove();
                    this.h.add(next);
                    if (next != null) {
                        next.hc();
                    }
                    d().execute(next);
                }
                if (this.h.size() >= this.d) {
                    return;
                }
            }
        }
    }

    private int b(yi.d dVar) {
        Iterator<yi.d> it = this.h.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (it.next().d().equals(dVar.d())) {
                i++;
            }
        }
        return i;
    }

    synchronized void d(yi yiVar) {
        this.gb.add(yiVar);
    }

    void hc(yi.d dVar) {
        d(this.h, dVar, true);
    }

    void hc(yi yiVar) {
        d(this.gb, yiVar, false);
    }

    private <T> void d(Deque<T> deque, T t, boolean z) {
        int iHc;
        Runnable runnable;
        synchronized (this) {
            if (!deque.remove(t)) {
                throw new AssertionError("Call wasn't in-flight!");
            }
            if (z) {
                b();
            }
            iHc = hc();
            runnable = this.b;
        }
        if (iHc != 0 || runnable == null) {
            return;
        }
        runnable.run();
    }

    public synchronized int hc() {
        return this.h.size() + this.gb.size();
    }
}
