package com.alliance.ssp.ad.l;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: TimingDecorator.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class l {
    public long a;
    public long b;
    public a c;
    public long e;
    public ScheduledFuture g;
    public boolean h = false;
    public ScheduledExecutorService f = Executors.newSingleThreadScheduledExecutor();
    public long d = 0;

    /* compiled from: TimingDecorator.java */
    public interface a {
        void a(double d, double d2);
    }

    public l(long j, long j2, a aVar) {
        this.a = j;
        this.b = j2;
        this.c = aVar;
        this.e = j;
    }

    public static l a(long j, long j2, a aVar) {
        if (j <= 0 || j2 <= 0 || aVar == null) {
            return null;
        }
        return new l(j, j2, aVar);
    }

    public void b() {
        try {
            if (this.h) {
                int i = com.alliance.ssp.ad.o0.l.a;
                this.h = false;
                ScheduledFuture scheduledFuture = this.g;
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(true);
                }
            }
        } catch (Exception unused) {
        }
    }

    public void c() {
        try {
            if (this.h) {
                return;
            }
            int i = com.alliance.ssp.ad.o0.l.a;
            this.h = true;
            ScheduledExecutorService scheduledExecutorService = this.f;
            Runnable runnable = new Runnable() { // from class: com.alliance.ssp.ad.l.l$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.a();
                }
            };
            long j = this.b;
            this.g = scheduledExecutorService.scheduleAtFixedRate(runnable, j, j, TimeUnit.MILLISECONDS);
        } catch (Exception unused) {
        }
    }

    public void d() {
        try {
            int i = com.alliance.ssp.ad.o0.l.a;
            ScheduledFuture scheduledFuture = this.g;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(true);
            }
            this.d = 0L;
            this.e = this.a;
            this.h = false;
        } catch (Exception unused) {
        }
    }

    public final void a() {
        try {
            if (this.h) {
                long j = this.d;
                long j2 = this.b;
                long j3 = j + j2;
                this.d = j3;
                this.e -= j2;
                a aVar = this.c;
                if (aVar != null) {
                    aVar.a(a(j3), a(this.e));
                    if (this.d >= this.a || this.e <= 0) {
                        d();
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    public final double a(long j) {
        try {
            return Math.round((j / 1000.0d) * 10.0d) / 10.0d;
        } catch (Exception unused) {
            return 0.0d;
        }
    }
}
