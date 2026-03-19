package com.qq.e.comm.plugin;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public abstract class f20 {
    private final long a;
    private final long b;
    private long c;
    private long d;
    private boolean e = false;
    private boolean f = false;
    private Handler g = new a(Looper.getMainLooper());

    /* compiled from: A */
    public interface b {
        void a(long j);

        void f();
    }

    public abstract void a(long j);

    public abstract void d();

    public f20(long j, long j2) {
        this.a = j;
        this.b = j2;
    }

    public final synchronized void g() {
        c(this.a);
    }

    public final synchronized void h() {
        this.e = true;
        this.g.removeMessages(1);
    }

    public final synchronized void e() {
        if (!this.e && !this.f) {
            this.f = true;
            this.d = this.c - SystemClock.elapsedRealtime();
            this.g.removeMessages(1);
        }
    }

    public final synchronized void f() {
        if (!this.e && this.f) {
            this.f = false;
            c(this.d);
        }
    }

    public long c() {
        return this.d;
    }

    public long b() {
        return this.a;
    }

    public final synchronized long a() {
        long jElapsedRealtime;
        if (this.f) {
            jElapsedRealtime = this.d;
        } else {
            jElapsedRealtime = this.c - SystemClock.elapsedRealtime();
        }
        if (jElapsedRealtime <= 0) {
            return this.a;
        }
        return this.a - jElapsedRealtime;
    }

    /* compiled from: A */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            synchronized (f20.this) {
                if (!f20.this.e && !f20.this.f) {
                    long jElapsedRealtime = f20.this.c - SystemClock.elapsedRealtime();
                    if (jElapsedRealtime <= 0) {
                        f20.this.d();
                    } else {
                        long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                        f20.this.a(jElapsedRealtime);
                        long jElapsedRealtime3 = (jElapsedRealtime2 + f20.this.b) - SystemClock.elapsedRealtime();
                        while (jElapsedRealtime3 < 0) {
                            jElapsedRealtime3 += f20.this.b;
                        }
                        sendMessageDelayed(obtainMessage(1), jElapsedRealtime3);
                    }
                }
            }
        }
    }

    private synchronized f20 c(long j) {
        this.e = false;
        if (j <= 0) {
            d();
            return this;
        }
        this.c = SystemClock.elapsedRealtime() + j;
        Handler handler = this.g;
        handler.sendMessage(handler.obtainMessage(1));
        return this;
    }

    /* compiled from: A */
    public static class c extends f20 {
        private b h;

        public c(long j, long j2) {
            super(j, j2);
        }

        @Override // com.qq.e.comm.plugin.f20
        public void a(long j) {
            b bVar = this.h;
            if (bVar != null) {
                bVar.a(j);
            }
        }

        @Override // com.qq.e.comm.plugin.f20
        public void d() {
            b bVar = this.h;
            if (bVar != null) {
                bVar.f();
            }
        }

        public void a(b bVar) {
            this.h = bVar;
        }
    }

    public void b(long j) {
        this.d = j;
    }
}
