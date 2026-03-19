package com.sigmob.sdk.downloader.core.dispatcher;

import android.os.SystemClock;
import com.sigmob.sdk.downloader.core.breakpoint.j;
import com.sigmob.sdk.downloader.core.c;
import com.sigmob.sdk.downloader.core.download.e;
import com.sigmob.sdk.downloader.f;
import com.sigmob.sdk.downloader.g;
import com.sigmob.sdk.downloader.l;
import java.io.File;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class b {
    private static final String b = "DownloadDispatcher";
    int a;
    private final List<e> c;
    private final List<e> d;
    private final List<e> e;
    private final List<e> f;
    private final AtomicInteger g;
    private volatile ExecutorService h;
    private final AtomicInteger i;
    private j j;

    public b() {
        this(new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList());
    }

    b(List<e> readyAsyncCalls, List<e> runningAsyncCalls, List<e> runningSyncCalls, List<e> finishingCalls) {
        this.a = 5;
        this.g = new AtomicInteger();
        this.i = new AtomicInteger();
        this.c = readyAsyncCalls;
        this.d = runningAsyncCalls;
        this.e = runningSyncCalls;
        this.f = finishingCalls;
    }

    private synchronized void a(com.sigmob.sdk.downloader.core.a task, List<e> needCallbackCalls, List<e> needCancelCalls) {
        Iterator<e> it = this.c.iterator();
        while (it.hasNext()) {
            e next = it.next();
            if (next.c == task || next.c.c() == task.c()) {
                if (!next.d() && !next.e()) {
                    it.remove();
                    needCallbackCalls.add(next);
                }
            }
        }
        for (e eVar : this.d) {
            if (eVar.c == task || eVar.c.c() == task.c()) {
                needCallbackCalls.add(eVar);
                needCancelCalls.add(eVar);
            }
        }
        for (e eVar2 : this.e) {
            if (eVar2.c == task || eVar2.c.c() == task.c()) {
                needCallbackCalls.add(eVar2);
                needCancelCalls.add(eVar2);
            }
        }
    }

    private synchronized void a(List<e> needCallbackCalls, List<e> needCancelCalls) {
        c.b(b, "handle cancel calls, cancel calls: " + needCancelCalls.size());
        if (!needCancelCalls.isEmpty()) {
            for (e eVar : needCancelCalls) {
                if (!eVar.c()) {
                    needCallbackCalls.remove(eVar);
                }
            }
        }
        c.b(b, "handle cancel calls, callback cancel event: " + needCallbackCalls.size());
        if (!needCallbackCalls.isEmpty()) {
            if (needCallbackCalls.size() <= 1) {
                g.j().b().a().a(needCallbackCalls.get(0).c, com.sigmob.sdk.downloader.core.cause.a.CANCELED, (Exception) null);
            } else {
                ArrayList arrayList = new ArrayList();
                Iterator<e> it = needCallbackCalls.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().c);
                }
                g.j().b().a(arrayList);
            }
        }
    }

    private boolean a(f task, Collection<f> sameTaskList, Collection<f> fileBusyList) {
        return a(task, this.c, sameTaskList, fileBusyList) || a(task, this.d, sameTaskList, fileBusyList) || a(task, this.e, sameTaskList, fileBusyList);
    }

    public static void b(int maxParallelRunningCount) {
        b bVarA = g.j().a();
        if (bVarA.getClass() != b.class) {
            throw new IllegalStateException("The current dispatcher is " + bVarA + " not DownloadDispatcher exactly!");
        }
        bVarA.a = Math.max(1, maxParallelRunningCount);
    }

    private synchronized void b(com.sigmob.sdk.downloader.core.a[] tasks) {
        long jUptimeMillis = SystemClock.uptimeMillis();
        c.b(b, "start cancel bunch task manually: " + tasks.length);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        try {
            for (com.sigmob.sdk.downloader.core.a aVar : tasks) {
                a(aVar, arrayList, arrayList2);
            }
        } finally {
            a(arrayList, arrayList2);
            c.b(b, "finish cancel bunch task manually: " + tasks.length + " consume " + (SystemClock.uptimeMillis() - jUptimeMillis) + "ms");
        }
    }

    private synchronized void b(f[] tasks) {
        long jUptimeMillis = SystemClock.uptimeMillis();
        c.b(b, "start enqueueLocked for bunch task: " + tasks.length);
        ArrayList<f> arrayList = new ArrayList();
        Collections.addAll(arrayList, tasks);
        if (arrayList.size() > 1) {
            Collections.sort(arrayList);
        }
        int size = this.c.size();
        try {
            g.j().g().b();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            for (f fVar : arrayList) {
                if (!a(fVar, arrayList2) && !a(fVar, (Collection<f>) arrayList3, (Collection<f>) arrayList4)) {
                    j(fVar);
                }
            }
            g.j().b().a(arrayList2, arrayList3, arrayList4);
        } catch (UnknownHostException e) {
            g.j().b().a(new ArrayList(arrayList), e);
        }
        if (size != this.c.size()) {
            Collections.sort(this.c);
        }
        c.b(b, "end enqueueLocked for bunch task: " + tasks.length + " consume " + (SystemClock.uptimeMillis() - jUptimeMillis) + "ms");
    }

    private synchronized void c() {
        if (this.i.get() > 0) {
            return;
        }
        if (d() >= this.a) {
            return;
        }
        if (this.c.isEmpty()) {
            return;
        }
        Iterator<e> it = this.c.iterator();
        while (it.hasNext()) {
            e next = it.next();
            it.remove();
            f fVar = next.c;
            if (g(fVar)) {
                g.j().b().a().a(fVar, com.sigmob.sdk.downloader.core.cause.a.FILE_BUSY, (Exception) null);
            } else {
                this.d.add(next);
                a().execute(next);
                if (d() >= this.a) {
                    return;
                }
            }
        }
    }

    private int d() {
        return this.d.size() - this.g.get();
    }

    private synchronized void i(f task) {
        c.b(b, "enqueueLocked for single task: " + task);
        if (h(task)) {
            return;
        }
        if (k(task)) {
            return;
        }
        int size = this.c.size();
        j(task);
        if (size != this.c.size()) {
            Collections.sort(this.c);
        }
    }

    private synchronized void j(f task) {
        e eVarA = e.a(task, true, this.j);
        if (d() < this.a) {
            this.d.add(eVarA);
            a().execute(eVarA);
        } else {
            this.c.add(eVarA);
        }
    }

    private boolean k(f task) {
        return a(task, (Collection<f>) null, (Collection<f>) null);
    }

    synchronized ExecutorService a() {
        if (this.h == null) {
            this.h = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), c.a("FileDownload Download", false));
        }
        return this.h;
    }

    public void a(j store) {
        this.j = store;
    }

    void a(e call) {
        call.run();
    }

    public void a(f task) {
        this.i.incrementAndGet();
        i(task);
        this.i.decrementAndGet();
    }

    public void a(com.sigmob.sdk.downloader.core.a[] tasks) {
        this.i.incrementAndGet();
        b(tasks);
        this.i.decrementAndGet();
        c();
    }

    public void a(f[] tasks) {
        this.i.incrementAndGet();
        b(tasks);
        this.i.decrementAndGet();
    }

    public boolean a(int id) {
        this.i.incrementAndGet();
        boolean zB = b(f.c(id));
        this.i.decrementAndGet();
        c();
        return zB;
    }

    public boolean a(com.sigmob.sdk.downloader.core.a task) {
        this.i.incrementAndGet();
        boolean zB = b(task);
        this.i.decrementAndGet();
        c();
        return zB;
    }

    boolean a(f task, Collection<f> completedCollection) {
        if (!task.e() || !l.c(task)) {
            return false;
        }
        if (task.d() == null && !g.j().g().a(task)) {
            return false;
        }
        g.j().g().a(task, this.j);
        if (completedCollection != null) {
            completedCollection.add(task);
            return true;
        }
        g.j().b().a().a(task, com.sigmob.sdk.downloader.core.cause.a.COMPLETED, (Exception) null);
        return true;
    }

    boolean a(f task, Collection<e> calls, Collection<f> sameTaskList, Collection<f> fileBusyList) {
        a aVarB = g.j().b();
        Iterator<e> it = calls.iterator();
        while (it.hasNext()) {
            e next = it.next();
            if (!next.d()) {
                if (next.a(task)) {
                    if (next.e()) {
                        c.b(b, "task: " + task.c() + " is finishing, move it to finishing list");
                        this.f.add(next);
                        it.remove();
                        return false;
                    }
                    if (sameTaskList != null) {
                        sameTaskList.add(task);
                    } else {
                        aVarB.a().a(task, com.sigmob.sdk.downloader.core.cause.a.SAME_TASK_BUSY, (Exception) null);
                    }
                    return true;
                }
                File fileG = next.g();
                File fileM = task.m();
                if (fileG != null && fileM != null && fileG.equals(fileM)) {
                    if (fileBusyList != null) {
                        fileBusyList.add(task);
                    } else {
                        aVarB.a().a(task, com.sigmob.sdk.downloader.core.cause.a.FILE_BUSY, (Exception) null);
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public void b() {
        this.i.incrementAndGet();
        ArrayList arrayList = new ArrayList();
        Iterator<e> it = this.c.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().c);
        }
        Iterator<e> it2 = this.d.iterator();
        while (it2.hasNext()) {
            arrayList.add(it2.next().c);
        }
        Iterator<e> it3 = this.e.iterator();
        while (it3.hasNext()) {
            arrayList.add(it3.next().c);
        }
        if (!arrayList.isEmpty()) {
            b((com.sigmob.sdk.downloader.core.a[]) arrayList.toArray(new f[arrayList.size()]));
        }
        this.i.decrementAndGet();
    }

    public synchronized void b(e call) {
        c.b(b, "flying canceled: " + call.c.c());
        if (call.d) {
            this.g.incrementAndGet();
        }
    }

    public void b(f task) {
        c.b(b, "execute: " + task);
        synchronized (this) {
            if (h(task)) {
                return;
            }
            if (k(task)) {
                return;
            }
            e eVarA = e.a(task, false, this.j);
            this.e.add(eVarA);
            a(eVarA);
        }
    }

    synchronized boolean b(com.sigmob.sdk.downloader.core.a task) {
        ArrayList arrayList;
        ArrayList arrayList2;
        c.b(b, "cancel manually: " + task.c());
        arrayList = new ArrayList();
        arrayList2 = new ArrayList();
        try {
            a(task, arrayList, arrayList2);
            a(arrayList, arrayList2);
        } catch (Throwable th) {
            a(arrayList, arrayList2);
            throw th;
        }
        return arrayList.size() > 0 || arrayList2.size() > 0;
    }

    public synchronized f c(f task) {
        c.b(b, "findSameTask: " + task.c());
        for (e eVar : this.c) {
            if (!eVar.d() && eVar.a(task)) {
                return eVar.c;
            }
        }
        for (e eVar2 : this.d) {
            if (!eVar2.d() && eVar2.a(task)) {
                return eVar2.c;
            }
        }
        for (e eVar3 : this.e) {
            if (!eVar3.d() && eVar3.a(task)) {
                return eVar3.c;
            }
        }
        return null;
    }

    public synchronized void c(e call) {
        boolean z = call.d;
        if (!(this.f.contains(call) ? this.f : z ? this.d : this.e).remove(call)) {
            throw new AssertionError("Call wasn't in-flight!");
        }
        if (z && call.d()) {
            this.g.decrementAndGet();
        }
        if (z) {
            c();
        }
    }

    public synchronized boolean d(f task) {
        c.b(b, "isRunning: " + task.c());
        for (e eVar : this.e) {
            if (!eVar.d() && eVar.a(task)) {
                return true;
            }
        }
        for (e eVar2 : this.d) {
            if (!eVar2.d() && eVar2.a(task)) {
                return true;
            }
        }
        return false;
    }

    public synchronized boolean e(f task) {
        c.b(b, "isCanceled: " + task.c());
        for (e eVar : this.e) {
            if (eVar.d() && eVar.a(task)) {
                return true;
            }
        }
        for (e eVar2 : this.d) {
            if (eVar2.d() && eVar2.a(task)) {
                return true;
            }
        }
        for (e eVar3 : this.c) {
            if (eVar3.d() && eVar3.a(task)) {
                return true;
            }
        }
        return false;
    }

    public synchronized boolean f(f task) {
        boolean z;
        c.b(b, "isPending: " + task.c());
        Iterator<e> it = this.c.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            e next = it.next();
            if (!next.d() && next.a(task)) {
                z = true;
                break;
            }
        }
        return z;
    }

    public synchronized boolean g(f task) {
        File fileM;
        File fileM2;
        c.b(b, "is file conflict after run: " + task.c());
        File fileM3 = task.m();
        if (fileM3 == null) {
            return false;
        }
        for (e eVar : this.e) {
            if (!eVar.d() && eVar.c != task && (fileM2 = eVar.c.m()) != null && fileM3.equals(fileM2)) {
                return true;
            }
        }
        for (e eVar2 : this.d) {
            if (!eVar2.d() && eVar2.c != task && (fileM = eVar2.c.m()) != null && fileM3.equals(fileM)) {
                return true;
            }
        }
        return false;
    }

    boolean h(f task) {
        return a(task, (Collection<f>) null);
    }
}
