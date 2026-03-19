package com.ss.android.socialbase.downloader.k;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class h {
    private d b;
    private Handler c;
    private Object d = new Object();
    private Queue<hc> hc = new ConcurrentLinkedQueue();

    public h(String str) {
        this.b = new d(str);
    }

    public void d() {
        this.b.start();
    }

    public void d(Runnable runnable) {
        d(runnable, 0L);
    }

    public void d(Runnable runnable, long j) {
        if (this.c == null) {
            synchronized (this.d) {
                if (this.c == null) {
                    this.hc.add(new hc(runnable, j));
                    return;
                }
            }
        }
        this.c.postDelayed(runnable, j);
    }

    public void hc() {
        this.b.quit();
    }

    private class d extends HandlerThread {
        d(String str) {
            super(str);
        }

        @Override // android.os.HandlerThread
        protected void onLooperPrepared() {
            super.onLooperPrepared();
            Looper looper = getLooper();
            synchronized (h.this.d) {
                h.this.c = new Handler(looper);
            }
            while (!h.this.hc.isEmpty()) {
                hc hcVar = (hc) h.this.hc.poll();
                if (hcVar != null) {
                    h.this.c.postDelayed(hcVar.d, hcVar.hc);
                }
            }
        }
    }

    private class hc {
        public Runnable d;
        public long hc;

        public hc(Runnable runnable, long j) {
            this.d = runnable;
            this.hc = j;
        }
    }
}
