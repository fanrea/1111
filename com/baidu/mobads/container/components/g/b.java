package com.baidu.mobads.container.components.g;

import android.text.TextUtils;
import com.baidu.mobads.container.components.g.h;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public final class b {
    static final /* synthetic */ boolean a = true;
    private final Deque<h.a> b = new ArrayDeque();
    private final Deque<h.a> c = new ArrayDeque();
    private final Deque<h> d = new ArrayDeque();
    private int e = 64;
    private int f = 5;
    private Runnable g;
    private ExecutorService h;

    public b(ExecutorService executorService) {
        this.h = executorService;
    }

    public b() {
    }

    public synchronized ExecutorService a() {
        if (this.h == null) {
            this.h = new ThreadPoolExecutor(5, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), a("MobAds URL Dispatcher", false));
        }
        return this.h;
    }

    private ThreadFactory a(String str, boolean z) {
        return new c(this, str, z);
    }

    public synchronized int b() {
        return this.e;
    }

    public void a(int i) {
        if (i < 1) {
            throw new IllegalArgumentException("max < 1: " + i);
        }
        synchronized (this) {
            this.e = i;
        }
        h();
    }

    public synchronized int c() {
        return this.f;
    }

    public void b(int i) {
        if (i < 1) {
            throw new IllegalArgumentException("max < 1: " + i);
        }
        synchronized (this) {
            this.f = i;
        }
        h();
    }

    public synchronized void a(Runnable runnable) {
        this.g = runnable;
    }

    void a(h.a aVar) {
        synchronized (this) {
            this.b.add(aVar);
            h.a aVarA = a(aVar.c());
            if (aVarA != null) {
                aVar.a(aVarA);
            }
        }
        h();
    }

    private h.a a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (h.a aVar : this.c) {
            if (str.equals(aVar.c())) {
                return aVar;
            }
        }
        for (h.a aVar2 : this.b) {
            if (str.equals(aVar2.c())) {
                return aVar2;
            }
        }
        return null;
    }

    private boolean h() {
        int i;
        boolean z;
        if (!a && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            Iterator<h.a> it = this.b.iterator();
            while (it.hasNext()) {
                h.a next = it.next();
                if (this.c.size() >= this.e) {
                    break;
                }
                if (next.b().get() < this.f) {
                    it.remove();
                    next.b().incrementAndGet();
                    arrayList.add(next);
                    this.c.add(next);
                }
            }
            z = g() > 0;
        }
        int size = arrayList.size();
        for (i = 0; i < size; i++) {
            ((h.a) arrayList.get(i)).a(a());
        }
        return z;
    }

    synchronized void a(h hVar) {
        this.d.add(hVar);
    }

    void b(h.a aVar) {
        aVar.b().decrementAndGet();
        a((Deque<Deque<h.a>>) this.c, (Deque<h.a>) aVar);
    }

    void b(h hVar) {
        a((Deque<Deque<h>>) this.d, (Deque<h>) hVar);
    }

    private <T> void a(Deque<T> deque, T t) {
        Runnable runnable;
        synchronized (this) {
            if (!deque.remove(t)) {
                throw new AssertionError("Call wasn't in-flight!");
            }
            runnable = this.g;
        }
        if (!h() && runnable != null) {
            runnable.run();
        }
    }

    public synchronized List<d> d() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator<h.a> it = this.b.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().a());
        }
        return Collections.unmodifiableList(arrayList);
    }

    public synchronized List<d> e() {
        ArrayList arrayList;
        arrayList = new ArrayList(this.d);
        Iterator<h.a> it = this.c.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().a());
        }
        return Collections.unmodifiableList(arrayList);
    }

    public synchronized int f() {
        return this.b.size();
    }

    public synchronized int g() {
        return this.c.size() + this.d.size();
    }
}
