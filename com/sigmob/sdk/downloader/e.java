package com.sigmob.sdk.downloader;

import com.sigmob.sdk.downloader.core.listener.f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class e extends com.sigmob.sdk.downloader.core.listener.b implements Runnable {
    static final int e = 0;
    private static final Executor g = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 30, TimeUnit.SECONDS, new SynchronousQueue(), com.sigmob.sdk.downloader.core.c.a("FileDownload DynamicSerial", false));
    private static final String i = "DownloadSerialQueue";
    volatile boolean a;
    volatile boolean b;
    volatile boolean c;
    volatile f d;
    com.sigmob.sdk.downloader.core.listener.f f;
    private final ArrayList<f> h;

    public e() {
        this(null);
    }

    public e(c listener) {
        this(listener, new ArrayList());
    }

    e(c listener, ArrayList<f> taskList) {
        this.a = false;
        this.b = false;
        this.c = false;
        this.f = new f.a().a(this).a(listener).a();
        this.h = taskList;
    }

    public synchronized void a() {
        if (this.c) {
            com.sigmob.sdk.downloader.core.c.a(i, "require pause this queue(remain " + this.h.size() + "), butit has already been paused");
            return;
        }
        this.c = true;
        if (this.d != null) {
            this.d.E();
            this.h.add(0, this.d);
            this.d = null;
        }
    }

    public void a(c listener) {
        this.f = new f.a().a(this).a(listener).a();
    }

    @Override // com.sigmob.sdk.downloader.c
    public synchronized void a(f task, com.sigmob.sdk.downloader.core.cause.a cause, Exception realCause) {
        if (cause != com.sigmob.sdk.downloader.core.cause.a.CANCELED && task == this.d) {
            this.d = null;
        }
    }

    @Override // com.sigmob.sdk.downloader.c
    public void a_(f task) {
        this.d = task;
    }

    public synchronized void b() {
        if (!this.c) {
            com.sigmob.sdk.downloader.core.c.a(i, "require resume this queue(remain " + this.h.size() + "), but it is still running");
            return;
        }
        this.c = false;
        if (!this.h.isEmpty() && !this.b) {
            this.b = true;
            f();
        }
    }

    public synchronized void b(f task) {
        this.h.add(task);
        Collections.sort(this.h);
        if (!this.c && !this.b) {
            this.b = true;
            f();
        }
    }

    public int c() {
        if (this.d != null) {
            return this.d.c();
        }
        return 0;
    }

    public int d() {
        return this.h.size();
    }

    public synchronized f[] e() {
        f[] fVarArr;
        this.a = true;
        if (this.d != null) {
            this.d.E();
        }
        fVarArr = new f[this.h.size()];
        this.h.toArray(fVarArr);
        this.h.clear();
        return fVarArr;
    }

    void f() {
        g.execute(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        f fVarRemove;
        while (!this.a) {
            synchronized (this) {
                if (!this.h.isEmpty() && !this.c) {
                    fVarRemove = this.h.remove(0);
                }
                this.d = null;
                this.b = false;
                return;
            }
            fVarRemove.c(this.f);
        }
    }
}
