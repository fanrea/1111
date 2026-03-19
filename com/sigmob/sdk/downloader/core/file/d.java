package com.sigmob.sdk.downloader.core.file;

import android.net.Uri;
import android.os.StatFs;
import android.os.SystemClock;
import android.util.SparseArray;
import com.sigmob.sdk.downloader.core.breakpoint.j;
import com.sigmob.sdk.downloader.f;
import com.sigmob.sdk.downloader.g;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.LockSupport;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class d {
    private static final String n = "MultiPointOutputStream";
    private static final ExecutorService o = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), com.sigmob.sdk.downloader.core.c.a("FileDownload file io", false));
    final SparseArray<com.sigmob.sdk.downloader.core.file.a> a;
    final SparseArray<AtomicLong> b;
    final AtomicLong c;
    final AtomicLong d;
    boolean e;
    volatile Future f;
    volatile Thread g;
    final SparseArray<Thread> h;
    IOException i;
    ArrayList<Integer> j;
    List<Integer> k;
    final a l;
    a m;
    private final int p;
    private final int q;
    private final int r;
    private final com.sigmob.sdk.downloader.core.breakpoint.c s;
    private final f t;
    private final j u;
    private final boolean v;
    private final boolean w;
    private final Runnable x;
    private String y;
    private volatile boolean z;

    static class a {
        boolean a;
        List<Integer> b = new ArrayList();
        List<Integer> c = new ArrayList();

        a() {
        }

        boolean a() {
            return this.a || this.c.size() > 0;
        }
    }

    public d(f task, com.sigmob.sdk.downloader.core.breakpoint.c info, j store) {
        this(task, info, store, null);
    }

    d(final f task, com.sigmob.sdk.downloader.core.breakpoint.c info, j store, Runnable syncRunnable) {
        this.a = new SparseArray<>();
        this.b = new SparseArray<>();
        this.c = new AtomicLong();
        this.d = new AtomicLong();
        this.e = false;
        this.h = new SparseArray<>();
        this.l = new a();
        this.m = new a();
        this.z = true;
        this.t = task;
        this.p = task.p();
        this.q = task.q();
        this.r = task.r();
        this.s = info;
        this.u = store;
        this.v = g.j().e().a();
        this.w = g.j().f().b(task);
        this.j = new ArrayList<>();
        if (syncRunnable == null) {
            this.x = new Runnable() { // from class: com.sigmob.sdk.downloader.core.file.d.1
                @Override // java.lang.Runnable
                public void run() {
                    d.this.g();
                }
            };
        } else {
            this.x = syncRunnable;
        }
        File fileM = task.m();
        if (fileM != null) {
            this.y = fileM.getAbsolutePath();
        }
    }

    private void m() {
        if (this.y != null || this.t.m() == null) {
            return;
        }
        this.y = this.t.m().getAbsolutePath();
    }

    public void a() {
        o.execute(new Runnable() { // from class: com.sigmob.sdk.downloader.core.file.d.2
            @Override // java.lang.Runnable
            public void run() {
                d.this.b();
            }
        });
    }

    public synchronized void a(int blockIndex) throws IOException {
        String str;
        String str2;
        this.j.add(Integer.valueOf(blockIndex));
        try {
            IOException iOException = this.i;
            if (iOException != null) {
                throw iOException;
            }
            if (this.f == null || this.f.isDone()) {
                if (this.f == null) {
                    str = n;
                    str2 = "OutputStream done but no need to ensure sync, because the sync job not run yet. task[" + this.t.c() + "] block[" + blockIndex + "]";
                } else {
                    str = n;
                    str2 = "OutputStream done but no need to ensure sync, because the syncFuture.isDone[" + this.f.isDone() + "] task[" + this.t.c() + "] block[" + blockIndex + "]";
                }
                com.sigmob.sdk.downloader.core.c.b(str, str2);
            } else {
                AtomicLong atomicLong = this.b.get(blockIndex);
                if (atomicLong != null && atomicLong.get() > 0) {
                    a(this.l);
                    a(this.l.a, blockIndex);
                }
            }
        } finally {
            c(blockIndex);
        }
    }

    public synchronized void a(int blockIndex, byte[] bytes, int length) throws IOException {
        if (this.e) {
            return;
        }
        e(blockIndex).a(bytes, 0, length);
        long j = length;
        this.c.addAndGet(j);
        this.b.get(blockIndex).addAndGet(j);
        d();
    }

    void a(long milliseconds) {
        LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(milliseconds));
    }

    void a(StatFs statFs, long requireSpace) throws com.sigmob.sdk.downloader.core.exception.e {
        long jA = com.sigmob.sdk.downloader.core.c.a(statFs);
        if (jA < requireSpace) {
            throw new com.sigmob.sdk.downloader.core.exception.e(requireSpace, jA);
        }
    }

    void a(a state) {
        state.c.clear();
        int size = new HashSet((List) this.j.clone()).size();
        if (size != this.k.size()) {
            com.sigmob.sdk.downloader.core.c.b(n, "task[" + this.t.c() + "] current need fetching block count " + this.k.size() + " is not equal to no more stream block count " + size);
            state.a = false;
        } else {
            com.sigmob.sdk.downloader.core.c.b(n, "task[" + this.t.c() + "] current need fetching block count " + this.k.size() + " is equal to no more stream block count " + size);
            state.a = true;
        }
        SparseArray<com.sigmob.sdk.downloader.core.file.a> sparseArrayClone = this.a.clone();
        int size2 = sparseArrayClone.size();
        for (int i = 0; i < size2; i++) {
            int iKeyAt = sparseArrayClone.keyAt(i);
            if (this.j.contains(Integer.valueOf(iKeyAt)) && !state.b.contains(Integer.valueOf(iKeyAt))) {
                state.b.add(Integer.valueOf(iKeyAt));
                state.c.add(Integer.valueOf(iKeyAt));
            }
        }
    }

    void a(Thread thread) {
        LockSupport.unpark(thread);
    }

    public void a(List<Integer> requireStreamBlocks) {
        this.k = requireStreamBlocks;
    }

    void a(boolean isNoMoreStream, int blockIndex) throws ExecutionException, InterruptedException {
        if (this.f == null || this.f.isDone()) {
            return;
        }
        if (!isNoMoreStream) {
            this.h.put(blockIndex, Thread.currentThread());
        }
        if (this.g == null) {
            while (!c()) {
                a(25L);
            }
        }
        a(this.g);
        if (!isNoMoreStream) {
            e();
            return;
        }
        a(this.g);
        try {
            this.f.get();
        } catch (InterruptedException | ExecutionException unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00d4 A[Catch: all -> 0x0182, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:7:0x0007, B:12:0x000e, B:17:0x0022, B:18:0x0028, B:20:0x002e, B:21:0x0034, B:24:0x003d, B:25:0x0070, B:39:0x00c8, B:40:0x00ce, B:42:0x00d4, B:43:0x00da, B:46:0x00e3, B:47:0x0116, B:51:0x0126, B:52:0x012c, B:54:0x0132, B:55:0x0138, B:58:0x0141, B:59:0x0174, B:60:0x0181, B:14:0x0016, B:28:0x007f, B:30:0x0083, B:32:0x008b, B:35:0x00a3, B:37:0x00b6, B:38:0x00c7), top: B:64:0x0001, inners: #2, #3, #4, #5 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void b() {
        /*
            Method dump skipped, instructions count: 389
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.downloader.core.file.d.b():void");
    }

    public void b(int blockIndex) throws IOException {
        com.sigmob.sdk.downloader.core.breakpoint.a aVarB = this.s.b(blockIndex);
        if (aVarB.d() != -1 && !com.sigmob.sdk.downloader.core.c.a(aVarB.a(), aVarB.d())) {
            throw new IOException("The current offset on block-info isn't update correct, " + aVarB.a() + " != " + aVarB.d() + " on " + blockIndex);
        }
    }

    synchronized void c(int blockIndex) throws IOException {
        com.sigmob.sdk.downloader.core.file.a aVar = this.a.get(blockIndex);
        if (aVar != null) {
            aVar.a();
            synchronized (this.b) {
                this.a.remove(blockIndex);
                this.b.remove(blockIndex);
            }
            com.sigmob.sdk.downloader.core.c.b(n, "OutputStream close task[" + this.t.c() + "] block[" + blockIndex + "]");
        }
    }

    boolean c() {
        return this.g != null;
    }

    void d() throws IOException {
        IOException iOException = this.i;
        if (iOException != null) {
            throw iOException;
        }
        if (this.f == null) {
            synchronized (this.x) {
                if (this.f == null) {
                    this.f = f();
                }
            }
        }
    }

    public void d(int blockIndex) {
        this.j.add(Integer.valueOf(blockIndex));
    }

    synchronized com.sigmob.sdk.downloader.core.file.a e(int blockIndex) throws IOException {
        com.sigmob.sdk.downloader.core.file.a aVar;
        Uri uriH;
        aVar = this.a.get(blockIndex);
        if (aVar == null) {
            boolean zB = com.sigmob.sdk.downloader.core.c.b(this.t.h());
            if (zB) {
                File fileM = this.t.m();
                if (fileM == null) {
                    throw new FileNotFoundException("Filename is not ready!");
                }
                File fileL = this.t.l();
                if (!fileL.exists() && !fileL.mkdirs()) {
                    throw new IOException("Create parent folder failed!");
                }
                if (fileM.createNewFile()) {
                    com.sigmob.sdk.downloader.core.c.b(n, "Create new file: " + fileM.getName());
                }
                uriH = Uri.fromFile(fileM);
            } else {
                uriH = this.t.h();
            }
            com.sigmob.sdk.downloader.core.file.a aVarA = g.j().e().a(g.j().h(), uriH, this.p);
            if (this.v) {
                long jC = this.s.b(blockIndex).c();
                if (jC > 0) {
                    aVarA.a(jC);
                    com.sigmob.sdk.downloader.core.c.b(n, "Create output stream write from (" + this.t.c() + ") block(" + blockIndex + ") " + jC);
                }
            }
            if (this.z) {
                this.u.f(this.t.c());
            }
            if (!this.s.b() && this.z && this.w) {
                long j = this.s.j();
                if (zB) {
                    File fileM2 = this.t.m();
                    long length = j - fileM2.length();
                    if (length > 0) {
                        a(new StatFs(fileM2.getAbsolutePath()), length);
                    }
                }
                aVarA.b(j);
            }
            synchronized (this.b) {
                this.a.put(blockIndex, aVarA);
                this.b.put(blockIndex, new AtomicLong());
            }
            this.z = false;
            aVar = aVarA;
        }
        return aVar;
    }

    void e() {
        LockSupport.park();
    }

    Future f() {
        return o.submit(this.x);
    }

    void g() {
        try {
            h();
        } catch (IOException e) {
            this.i = e;
            com.sigmob.sdk.downloader.core.c.a(n, "Sync to breakpoint-store for task[" + this.t.c() + "] failed with cause: " + e);
        }
    }

    void h() throws IOException {
        com.sigmob.sdk.downloader.core.c.b(n, "OutputStream start flush looper task[" + this.t.c() + "] with syncBufferIntervalMills[" + this.r + "] syncBufferSize[" + this.q + "]");
        this.g = Thread.currentThread();
        long j = this.r;
        l();
        while (true) {
            a(j);
            a(this.m);
            if (this.m.a()) {
                com.sigmob.sdk.downloader.core.c.b(n, "runSync state change isNoMoreStream[" + this.m.a + "] newNoMoreStreamBlockList[" + this.m.c + "]");
                if (this.c.get() > 0) {
                    l();
                }
                for (Integer num : this.m.c) {
                    Thread thread = this.h.get(num.intValue());
                    this.h.remove(num.intValue());
                    if (thread != null) {
                        a(thread);
                    }
                }
                if (this.m.a) {
                    break;
                }
            } else {
                if (!i()) {
                    j = j();
                    if (j <= 0) {
                        l();
                    }
                }
                j = this.r;
            }
        }
        int size = this.h.size();
        for (int i = 0; i < size; i++) {
            Thread threadValueAt = this.h.valueAt(i);
            if (threadValueAt != null) {
                a(threadValueAt);
            }
        }
        this.h.clear();
        com.sigmob.sdk.downloader.core.c.b(n, "OutputStream stop flush looper task[" + this.t.c() + "]");
    }

    boolean i() {
        return this.c.get() < ((long) this.q);
    }

    long j() {
        return this.r - (k() - this.d.get());
    }

    long k() {
        return SystemClock.uptimeMillis();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x005d A[Catch: all -> 0x00e5, TryCatch #0 {, blocks: (B:4:0x0003, B:8:0x0014, B:10:0x002a, B:16:0x005d, B:18:0x0063, B:19:0x00d4, B:20:0x00e3, B:13:0x0040), top: B:25:0x0003, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void l() throws java.io.IOException {
        /*
            r12 = this;
            android.util.SparseArray<java.util.concurrent.atomic.AtomicLong> r0 = r12.b
            monitor-enter(r0)
            android.util.SparseArray<java.util.concurrent.atomic.AtomicLong> r1 = r12.b     // Catch: java.lang.Throwable -> Le5
            int r1 = r1.size()     // Catch: java.lang.Throwable -> Le5
            android.util.SparseArray r2 = new android.util.SparseArray     // Catch: java.lang.Throwable -> Le5
            r2.<init>(r1)     // Catch: java.lang.Throwable -> Le5
            r3 = 0
            r4 = r3
        L10:
            r5 = 0
            if (r4 >= r1) goto L5a
            android.util.SparseArray<java.util.concurrent.atomic.AtomicLong> r7 = r12.b     // Catch: java.io.IOException -> L3f java.lang.Throwable -> Le5
            int r7 = r7.keyAt(r4)     // Catch: java.io.IOException -> L3f java.lang.Throwable -> Le5
            android.util.SparseArray<java.util.concurrent.atomic.AtomicLong> r8 = r12.b     // Catch: java.io.IOException -> L3f java.lang.Throwable -> Le5
            java.lang.Object r8 = r8.get(r7)     // Catch: java.io.IOException -> L3f java.lang.Throwable -> Le5
            java.util.concurrent.atomic.AtomicLong r8 = (java.util.concurrent.atomic.AtomicLong) r8     // Catch: java.io.IOException -> L3f java.lang.Throwable -> Le5
            long r8 = r8.get()     // Catch: java.io.IOException -> L3f java.lang.Throwable -> Le5
            int r10 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1))
            if (r10 <= 0) goto L3c
            java.lang.Long r8 = java.lang.Long.valueOf(r8)     // Catch: java.io.IOException -> L3f java.lang.Throwable -> Le5
            r2.put(r7, r8)     // Catch: java.io.IOException -> L3f java.lang.Throwable -> Le5
            android.util.SparseArray<com.sigmob.sdk.downloader.core.file.a> r8 = r12.a     // Catch: java.io.IOException -> L3f java.lang.Throwable -> Le5
            java.lang.Object r7 = r8.get(r7)     // Catch: java.io.IOException -> L3f java.lang.Throwable -> Le5
            com.sigmob.sdk.downloader.core.file.a r7 = (com.sigmob.sdk.downloader.core.file.a) r7     // Catch: java.io.IOException -> L3f java.lang.Throwable -> Le5
            r7.b()     // Catch: java.io.IOException -> L3f java.lang.Throwable -> Le5
        L3c:
            int r4 = r4 + 1
            goto L10
        L3f:
            r1 = move-exception
            java.lang.String r4 = "MultiPointOutputStream"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Le5
            r7.<init>()     // Catch: java.lang.Throwable -> Le5
            java.lang.String r8 = "OutputStream flush and sync data to filesystem failed "
            java.lang.StringBuilder r7 = r7.append(r8)     // Catch: java.lang.Throwable -> Le5
            java.lang.StringBuilder r1 = r7.append(r1)     // Catch: java.lang.Throwable -> Le5
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> Le5
            com.sigmob.sdk.downloader.core.c.a(r4, r1)     // Catch: java.lang.Throwable -> Le5
            r1 = r3
            goto L5b
        L5a:
            r1 = 1
        L5b:
            if (r1 == 0) goto Le3
            int r1 = r2.size()     // Catch: java.lang.Throwable -> Le5
        L61:
            if (r3 >= r1) goto Ld4
            int r4 = r2.keyAt(r3)     // Catch: java.lang.Throwable -> Le5
            java.lang.Object r7 = r2.valueAt(r3)     // Catch: java.lang.Throwable -> Le5
            java.lang.Long r7 = (java.lang.Long) r7     // Catch: java.lang.Throwable -> Le5
            long r7 = r7.longValue()     // Catch: java.lang.Throwable -> Le5
            com.sigmob.sdk.downloader.core.breakpoint.j r9 = r12.u     // Catch: java.lang.Throwable -> Le5
            com.sigmob.sdk.downloader.core.breakpoint.c r10 = r12.s     // Catch: java.lang.Throwable -> Le5
            r9.a(r10, r4, r7)     // Catch: java.lang.Throwable -> Le5
            long r5 = r5 + r7
            android.util.SparseArray<java.util.concurrent.atomic.AtomicLong> r9 = r12.b     // Catch: java.lang.Throwable -> Le5
            java.lang.Object r9 = r9.get(r4)     // Catch: java.lang.Throwable -> Le5
            java.util.concurrent.atomic.AtomicLong r9 = (java.util.concurrent.atomic.AtomicLong) r9     // Catch: java.lang.Throwable -> Le5
            long r10 = -r7
            r9.addAndGet(r10)     // Catch: java.lang.Throwable -> Le5
            java.lang.String r9 = "MultiPointOutputStream"
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Le5
            r10.<init>()     // Catch: java.lang.Throwable -> Le5
            java.lang.String r11 = "OutputStream sync success ("
            java.lang.StringBuilder r10 = r10.append(r11)     // Catch: java.lang.Throwable -> Le5
            com.sigmob.sdk.downloader.f r11 = r12.t     // Catch: java.lang.Throwable -> Le5
            int r11 = r11.c()     // Catch: java.lang.Throwable -> Le5
            java.lang.StringBuilder r10 = r10.append(r11)     // Catch: java.lang.Throwable -> Le5
            java.lang.String r11 = ") block("
            java.lang.StringBuilder r10 = r10.append(r11)     // Catch: java.lang.Throwable -> Le5
            java.lang.StringBuilder r10 = r10.append(r4)     // Catch: java.lang.Throwable -> Le5
            java.lang.String r11 = ")  syncLength("
            java.lang.StringBuilder r10 = r10.append(r11)     // Catch: java.lang.Throwable -> Le5
            java.lang.StringBuilder r7 = r10.append(r7)     // Catch: java.lang.Throwable -> Le5
            java.lang.String r8 = ") currentOffset("
            java.lang.StringBuilder r7 = r7.append(r8)     // Catch: java.lang.Throwable -> Le5
            com.sigmob.sdk.downloader.core.breakpoint.c r8 = r12.s     // Catch: java.lang.Throwable -> Le5
            com.sigmob.sdk.downloader.core.breakpoint.a r4 = r8.b(r4)     // Catch: java.lang.Throwable -> Le5
            long r10 = r4.a()     // Catch: java.lang.Throwable -> Le5
            java.lang.StringBuilder r4 = r7.append(r10)     // Catch: java.lang.Throwable -> Le5
            java.lang.String r7 = ")"
            java.lang.StringBuilder r4 = r4.append(r7)     // Catch: java.lang.Throwable -> Le5
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> Le5
            com.sigmob.sdk.downloader.core.c.b(r9, r4)     // Catch: java.lang.Throwable -> Le5
            int r3 = r3 + 1
            goto L61
        Ld4:
            java.util.concurrent.atomic.AtomicLong r1 = r12.c     // Catch: java.lang.Throwable -> Le5
            long r2 = -r5
            r1.addAndGet(r2)     // Catch: java.lang.Throwable -> Le5
            java.util.concurrent.atomic.AtomicLong r1 = r12.d     // Catch: java.lang.Throwable -> Le5
            long r2 = android.os.SystemClock.uptimeMillis()     // Catch: java.lang.Throwable -> Le5
            r1.set(r2)     // Catch: java.lang.Throwable -> Le5
        Le3:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Le5
            return
        Le5:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Le5
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.downloader.core.file.d.l():void");
    }
}
