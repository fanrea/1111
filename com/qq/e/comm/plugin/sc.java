package com.qq.e.comm.plugin;

import android.os.Looper;
import android.os.SystemClock;
import com.qq.e.comm.plugin.uo;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class sc implements Runnable, uo.d {
    private boolean c;
    private volatile long f;
    private volatile long g;
    private ScheduledFuture<?> h;
    private int d = 700;
    private int e = 100;
    private final uo a = uo.a(Looper.getMainLooper());
    private final m00 b = new m00();

    sc() {
    }

    public void c() {
        this.a.a(this);
        ScheduledExecutorService scheduledExecutorService = qg.f;
        long j = this.e;
        this.h = scheduledExecutorService.scheduleWithFixedDelay(this, j, j, TimeUnit.MILLISECONDS);
    }

    public void d() {
        this.a.b(this);
        this.a.a();
        ScheduledFuture<?> scheduledFuture = this.h;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
    }

    @Override // com.qq.e.comm.plugin.uo.d
    public void b() {
        if (this.c) {
            return;
        }
        this.f = SystemClock.uptimeMillis();
        this.c = true;
    }

    @Override // java.lang.Runnable
    public void run() throws JSONException {
        long j = this.f;
        if (j <= 0 || SystemClock.uptimeMillis() - j < this.d) {
            return;
        }
        if (this.g != j) {
            this.b.a(Looper.getMainLooper().getThread());
        }
        this.g = j;
    }

    @Override // com.qq.e.comm.plugin.uo.d
    public void a() {
        if (this.c) {
            this.f = 0L;
            this.c = false;
        }
    }

    public sc a(boolean z) {
        this.b.a(z);
        return this;
    }

    public sc a(int i, int i2) {
        this.d = i;
        this.e = i2;
        return this;
    }
}
