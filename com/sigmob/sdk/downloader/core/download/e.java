package com.sigmob.sdk.downloader.core.download;

import android.os.SystemClock;
import com.sigmob.sdk.downloader.core.breakpoint.j;
import com.sigmob.sdk.downloader.f;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class e extends com.sigmob.sdk.downloader.core.b implements Comparable<e> {
    static final int b = 3;
    private static final ExecutorService j = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), com.sigmob.sdk.downloader.core.c.a("FileDownload Block", false));
    private static final String k = "DownloadCall";
    public final com.sigmob.sdk.downloader.f c;
    public final boolean d;
    final ArrayList<f> e;
    volatile d f;
    volatile boolean g;
    volatile boolean h;
    volatile Thread i;
    private final j l;

    private e(com.sigmob.sdk.downloader.f task, boolean asyncExecuted, j store) {
        this(task, asyncExecuted, new ArrayList(), store);
    }

    e(com.sigmob.sdk.downloader.f task, boolean asyncExecuted, ArrayList<f> runningBlockList, j store) {
        super("download call: " + task.c());
        this.c = task;
        this.d = asyncExecuted;
        this.e = runningBlockList;
        this.l = store;
    }

    public static e a(com.sigmob.sdk.downloader.f task, boolean asyncExecuted, j store) {
        return new e(task, asyncExecuted, store);
    }

    private void a(d cache, com.sigmob.sdk.downloader.core.cause.a cause, Exception realCause) {
        if (cause == com.sigmob.sdk.downloader.core.cause.a.CANCELED) {
            throw new IllegalAccessError("can't recognize cancelled on here");
        }
        synchronized (this) {
            if (this.g) {
                return;
            }
            this.h = true;
            this.l.a(this.c.c(), cause, realCause);
            if (cause == com.sigmob.sdk.downloader.core.cause.a.COMPLETED) {
                this.l.g(this.c.c());
                com.sigmob.sdk.downloader.g.j().f().a(cache.a(), this.c);
            }
            com.sigmob.sdk.downloader.g.j().b().a().a(this.c, cause, realCause);
        }
    }

    private void h() {
        this.l.d(this.c.c());
        com.sigmob.sdk.downloader.g.j().b().a().a_(this.c);
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(e o) {
        return o.f() - f();
    }

    a a(com.sigmob.sdk.downloader.core.breakpoint.c info, long responseInstanceLength) {
        return new a(this.c, info, responseInstanceLength);
    }

    d a(com.sigmob.sdk.downloader.core.breakpoint.c info) {
        return new d(com.sigmob.sdk.downloader.g.j().f().a(this.c, info, this.l));
    }

    Future<?> a(f chain) {
        return j.submit(chain);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x016e A[EDGE_INSN: B:82:0x016e->B:50:0x016e BREAK  A[LOOP:0: B:3:0x0013->B:86:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x016e A[EDGE_INSN: B:83:0x016e->B:50:0x016e BREAK  A[LOOP:0: B:3:0x0013->B:86:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:86:? A[LOOP:0: B:3:0x0013->B:86:?, LOOP_END, SYNTHETIC] */
    @Override // com.sigmob.sdk.downloader.core.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a() throws java.lang.InterruptedException {
        /*
            Method dump skipped, instructions count: 433
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.downloader.core.download.e.a():void");
    }

    void a(com.sigmob.sdk.downloader.core.breakpoint.c info, b remoteCheck, com.sigmob.sdk.downloader.core.cause.b failedCause) {
        com.sigmob.sdk.downloader.core.c.a(this.c, info, remoteCheck.e(), remoteCheck.d());
        com.sigmob.sdk.downloader.g.j().b().a().a(this.c, info, failedCause);
    }

    void a(final d cache, com.sigmob.sdk.downloader.core.breakpoint.c info) throws InterruptedException {
        int iG = info.g();
        ArrayList arrayList = new ArrayList(info.g());
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < iG; i++) {
            com.sigmob.sdk.downloader.core.breakpoint.a aVarB = info.b(i);
            if (!com.sigmob.sdk.downloader.core.c.a(aVarB.a(), aVarB.d())) {
                com.sigmob.sdk.downloader.core.c.a(aVarB);
                f fVarA = f.a(i, this.c, info, cache, this.l);
                arrayList.add(fVarA);
                arrayList2.add(Integer.valueOf(fVarA.e()));
            }
        }
        if (this.g) {
            return;
        }
        cache.a().a(arrayList2);
        a(arrayList);
    }

    @Override // com.sigmob.sdk.downloader.core.b
    protected void a(InterruptedException e) {
    }

    void a(List<f> tasks) throws InterruptedException {
        ArrayList arrayList = new ArrayList(tasks.size());
        try {
            Iterator<f> it = tasks.iterator();
            while (it.hasNext()) {
                arrayList.add(a(it.next()));
            }
            this.e.addAll(tasks);
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                Future future = (Future) it2.next();
                if (!future.isDone()) {
                    try {
                        future.get();
                    } catch (CancellationException | ExecutionException unused) {
                    }
                }
            }
        } finally {
        }
    }

    public boolean a(com.sigmob.sdk.downloader.f task) {
        return this.c.equals(task);
    }

    b b(com.sigmob.sdk.downloader.core.breakpoint.c info) {
        return new b(this.c, info);
    }

    @Override // com.sigmob.sdk.downloader.core.b
    protected void b() {
        com.sigmob.sdk.downloader.g.j().a().c(this);
        com.sigmob.sdk.downloader.core.c.b(k, "call is finished " + this.c.c());
    }

    void c(com.sigmob.sdk.downloader.core.breakpoint.c info) {
        f.c.a(this.c, info);
    }

    public boolean c() {
        synchronized (this) {
            if (this.g) {
                return true;
            }
            if (this.h) {
                return false;
            }
            this.g = true;
            long jUptimeMillis = SystemClock.uptimeMillis();
            com.sigmob.sdk.downloader.g.j().a().b(this);
            d dVar = this.f;
            if (dVar != null) {
                dVar.l();
            }
            Object[] array = this.e.toArray();
            if (array != null && array.length != 0) {
                for (Object obj : array) {
                    if (obj instanceof f) {
                        ((f) obj).b();
                    }
                }
            } else if (this.i != null) {
                com.sigmob.sdk.downloader.core.c.b(k, "interrupt thread with cancel operation because of chains are not running " + this.c.c());
                this.i.interrupt();
            }
            if (dVar != null) {
                dVar.a().a();
            }
            com.sigmob.sdk.downloader.core.c.b(k, "cancel task " + this.c.c() + " consume: " + (SystemClock.uptimeMillis() - jUptimeMillis) + "ms");
            return true;
        }
    }

    public boolean d() {
        return this.g;
    }

    public boolean e() {
        return this.h;
    }

    int f() {
        return this.c.G();
    }

    public File g() {
        return this.c.m();
    }
}
