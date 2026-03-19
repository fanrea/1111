package com.baidu.mobads.container.d;

import com.baidu.mobads.container.util.bq;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class b {
    private static final String a = "TaskScheduler";
    private static volatile b g;
    private ThreadPoolExecutor b;
    private ThreadPoolExecutor c;
    private ThreadPoolExecutor d;
    private ThreadPoolExecutor e;
    private ScheduledThreadPoolExecutor f;

    public interface a {
        public static final int a = 1;
        public static final int b = 2;
        public static final int c = 3;
        public static final int d = 4;
    }

    private b() {
        b();
    }

    public static b a() {
        if (g == null) {
            synchronized (b.class) {
                if (g == null) {
                    g = new b();
                }
            }
        }
        return g;
    }

    private void b() {
        this.b = c.a(1);
        this.c = c.a(3, false);
        this.d = c.a(6, true);
        this.f = c.b(3);
    }

    public void a(Runnable runnable) {
        a(runnable, 1);
    }

    public void a(Runnable runnable, int i) {
        if (runnable != null) {
            try {
                switch (i) {
                    case 1:
                        this.b.submit(runnable);
                        break;
                    case 2:
                        this.c.submit(runnable);
                        break;
                    case 3:
                        this.d.submit(runnable);
                        break;
                    case 4:
                        if (this.e == null) {
                            this.e = c.a(1, true);
                        }
                        this.e.submit(runnable);
                        break;
                    default:
                        this.c.submit(runnable);
                        break;
                }
            } catch (Throwable th) {
                bq.a().a(th.getMessage());
            }
        }
    }

    public void a(com.baidu.mobads.container.d.a aVar, int i) {
        FutureTask futureTaskA;
        if (aVar != null) {
            try {
                aVar.b(System.currentTimeMillis());
                switch (i) {
                    case 1:
                        futureTaskA = a(this.b, aVar);
                        break;
                    case 2:
                        futureTaskA = a(this.c, aVar);
                        break;
                    case 3:
                        futureTaskA = a(this.d, aVar);
                        break;
                    case 4:
                        if (this.e == null) {
                            this.e = c.a(1, true);
                        }
                        futureTaskA = a(this.e, aVar);
                        break;
                    default:
                        futureTaskA = a(this.c, aVar);
                        break;
                }
                aVar.a((Future) futureTaskA);
            } catch (Throwable th) {
            }
        }
    }

    public void a(com.baidu.mobads.container.d.a aVar, long j, TimeUnit timeUnit) {
        if (aVar != null && this.f != null && !this.f.isShutdown()) {
            try {
                aVar.b(System.currentTimeMillis());
                aVar.a((Future) this.f.schedule(aVar, j, timeUnit));
            } catch (Throwable th) {
            }
        }
    }

    public void a(com.baidu.mobads.container.d.a aVar, long j, long j2, TimeUnit timeUnit) {
        if (aVar != null && this.f != null && !this.f.isShutdown()) {
            try {
                aVar.b(System.currentTimeMillis());
                aVar.a((Future) this.f.scheduleAtFixedRate(aVar, j, j2, timeUnit));
            } catch (Throwable th) {
            }
        }
    }

    private FutureTask a(ThreadPoolExecutor threadPoolExecutor, com.baidu.mobads.container.d.a aVar) {
        if (threadPoolExecutor != null && !threadPoolExecutor.isShutdown()) {
            return (FutureTask) threadPoolExecutor.submit(aVar);
        }
        return null;
    }
}
