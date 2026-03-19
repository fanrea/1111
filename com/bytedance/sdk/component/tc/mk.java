package com.bytedance.sdk.component.tc;

import com.kuaishou.weapon.p0.t;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class mk {
    public static final int d = h.d;
    public static final mk hc = new mk();
    private int de;
    private volatile boolean he;
    private volatile ScheduledExecutorService jh;
    private com.bytedance.sdk.component.tc.d.hc np;
    private volatile ThreadPoolExecutor rf;
    private volatile boolean tt;
    private volatile boolean vv;
    private com.bytedance.sdk.component.tc.d.u w;
    private boolean yi;
    private volatile ThreadPoolExecutor yo;
    public volatile boolean b = true;
    private long an = 5000;
    private long h = 20000;
    private volatile boolean gb = true;
    private boolean tc = true;
    private long mk = 100;
    private long mq = 50;
    private long uo = 1000;
    private long k = com.alipay.sdk.m.u.b.a;
    private boolean e = false;
    private volatile boolean cb = true;
    private boolean sy = true;
    private boolean v = true;
    private volatile boolean zw = true;
    private volatile boolean j = true;
    private int c = Math.min(d, 4);
    private int u = 50;

    private mk() {
    }

    public void d(int i) {
        this.de = i;
    }

    public boolean hc(int i) {
        return (this.de & i) == i;
    }

    public boolean d() {
        return this.tc;
    }

    public void d(boolean z) {
        this.tc = z;
    }

    public boolean hc() {
        return this.sy;
    }

    public void hc(boolean z) {
        this.sy = z;
    }

    public com.bytedance.sdk.component.tc.d.hc b() {
        return this.np;
    }

    public void d(com.bytedance.sdk.component.tc.d.hc hcVar) {
        this.np = hcVar;
    }

    public long c() {
        return this.mk;
    }

    public boolean u() {
        return this.b;
    }

    public void b(boolean z) {
        this.b = z;
    }

    public boolean an() {
        return this.yi;
    }

    public void c(boolean z) {
        this.yi = z;
    }

    public com.bytedance.sdk.component.tc.d.u h() {
        if (this.w == null) {
            this.w = new com.bytedance.sdk.component.tc.d.u();
        }
        return this.w;
    }

    public int gb() {
        return this.c;
    }

    public void b(int i) {
        this.c = i;
        tt().setCorePoolSize(i);
        tc().setCorePoolSize(i);
    }

    public ThreadPoolExecutor tt() {
        if (this.yo == null) {
            synchronized (this) {
                if (this.yo == null) {
                    this.yo = new com.bytedance.sdk.component.tc.b.c(this.c, this.u, this.h, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new tc(10, "a") { // from class: com.bytedance.sdk.component.tc.mk.1
                        @Override // com.bytedance.sdk.component.tc.tc
                        protected Thread d(ThreadGroup threadGroup, Runnable runnable, String str) {
                            return new Thread(threadGroup, runnable, str);
                        }
                    });
                }
            }
        }
        return this.yo;
    }

    public ThreadPoolExecutor tc() {
        if (this.rf == null) {
            synchronized (this) {
                if (this.rf == null) {
                    this.rf = new com.bytedance.sdk.component.tc.b.hc(this.c, this.u, this.an, TimeUnit.MILLISECONDS, new tc(10, t.l) { // from class: com.bytedance.sdk.component.tc.mk.2
                        @Override // com.bytedance.sdk.component.tc.tc
                        protected Thread d(ThreadGroup threadGroup, Runnable runnable, String str) {
                            return new Thread(threadGroup, runnable, str);
                        }
                    });
                    if (this.j) {
                        try {
                            this.rf.allowCoreThreadTimeOut(true);
                        } catch (Throwable unused) {
                        }
                    }
                }
            }
        }
        return this.rf;
    }

    public void d(ThreadPoolExecutor threadPoolExecutor) {
        if (threadPoolExecutor == null) {
            return;
        }
        ThreadPoolExecutor threadPoolExecutor2 = this.rf;
        this.rf = threadPoolExecutor;
        if (threadPoolExecutor2 == null || threadPoolExecutor2 == threadPoolExecutor) {
            return;
        }
        u.d(threadPoolExecutor, threadPoolExecutor2);
    }

    public void hc(ThreadPoolExecutor threadPoolExecutor) {
        if (threadPoolExecutor == null) {
            return;
        }
        ThreadPoolExecutor threadPoolExecutor2 = this.yo;
        this.yo = threadPoolExecutor;
        if (threadPoolExecutor2 == null || threadPoolExecutor2 == threadPoolExecutor) {
            return;
        }
        ((com.bytedance.sdk.component.tc.b.c) threadPoolExecutor2).b();
        u.d(threadPoolExecutor, threadPoolExecutor2);
    }

    public void c(int i) {
        this.u = i;
        tt().setMaximumPoolSize(i);
        tc().setMaximumPoolSize(i);
    }

    public int mk() {
        return this.u;
    }

    public void u(boolean z) {
        this.tt = z;
    }

    public ScheduledExecutorService mq() {
        if (this.jh == null) {
            synchronized (this) {
                if (this.jh == null) {
                    this.jh = new ScheduledThreadPoolExecutor(1, new ThreadFactory() { // from class: com.bytedance.sdk.component.tc.mk.3
                        @Override // java.util.concurrent.ThreadFactory
                        public Thread newThread(Runnable runnable) {
                            return new Thread(runnable, mk.this.yi ? "csj-p-wp" : "csj-wp");
                        }
                    }, com.bytedance.sdk.component.tc.c.d.d);
                }
            }
        }
        return this.jh;
    }

    public void d(ScheduledExecutorService scheduledExecutorService) {
        if (scheduledExecutorService == null) {
            return;
        }
        final ScheduledExecutorService scheduledExecutorService2 = this.jh;
        this.jh = scheduledExecutorService;
        if (scheduledExecutorService2 == null || scheduledExecutorService2 == scheduledExecutorService) {
            return;
        }
        this.jh.schedule(new Runnable() { // from class: com.bytedance.sdk.component.tc.mk.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    scheduledExecutorService2.shutdown();
                } catch (Exception e) {
                    com.bytedance.sdk.component.utils.mq.b("ThreadCenter", e);
                }
            }
        }, 5000L, TimeUnit.MILLISECONDS);
    }

    public ThreadPoolExecutor uo() {
        if (this.tt) {
            return tc();
        }
        return tt();
    }

    public void d(long j) {
        this.an = j;
        tc().setKeepAliveTime(j, TimeUnit.MILLISECONDS);
    }

    public void an(boolean z) {
        this.gb = z;
    }

    public boolean k() {
        return this.he;
    }

    public void h(boolean z) {
        if (z) {
            gb(false);
            h.d(false);
        }
        this.he = z;
    }

    public boolean e() {
        return this.vv;
    }

    public boolean cb() {
        return this.zw && h.u();
    }

    public void gb(boolean z) {
        if (this.he) {
            return;
        }
        if (this.rf != null) {
            this.rf.allowCoreThreadTimeOut(z);
        }
        this.j = z;
    }

    public long w() {
        return this.mq;
    }

    public void hc(long j) {
        this.mq = j;
    }

    public long yo() {
        return this.uo;
    }

    public void b(long j) {
        this.uo = j;
    }

    public long rf() {
        return this.k;
    }

    public void c(long j) {
        this.k = j;
    }

    public boolean jh() {
        return this.e;
    }

    public void tt(boolean z) {
        this.e = z;
    }
}
