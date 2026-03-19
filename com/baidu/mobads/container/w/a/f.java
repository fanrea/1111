package com.baidu.mobads.container.w.a;

import android.os.Handler;
import android.os.Looper;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class f extends Thread {
    private static final int a = 5000;
    private a b;
    private final Handler c;
    private final int d;
    private volatile long e;
    private volatile boolean f;
    private final Runnable g;

    public interface a {
        void a(long j);
    }

    public f() {
        this(5000);
    }

    public f(int i) {
        this.c = new Handler(Looper.getMainLooper());
        this.e = 0L;
        this.f = false;
        this.g = new g(this);
        this.d = i;
    }

    public f a(a aVar) {
        this.b = aVar;
        return this;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() throws InterruptedException {
        setName("Mobads_ANR_WatchDog");
        long j = this.d;
        while (!isInterrupted()) {
            boolean z = this.e == 0;
            this.e += j;
            if (z) {
                this.c.post(this.g);
            }
            try {
                Thread.sleep(j);
                if (this.e != 0 && !this.f) {
                    if (this.b != null) {
                        this.b.a(this.e);
                    }
                    j = this.d;
                    this.f = true;
                }
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
