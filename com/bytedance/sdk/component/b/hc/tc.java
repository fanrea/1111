package com.bytedance.sdk.component.b.hc;

import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.sdk.component.b.hc.d.hc.h;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class tc {
    static final /* synthetic */ boolean b = true;
    private static final Executor c = new com.bytedance.sdk.component.tc.c.c(0, Integer.MAX_VALUE, 20, TimeUnit.SECONDS, new SynchronousQueue(), com.bytedance.sdk.component.b.hc.d.b.d("OkHttp ConnectionPool", true));
    private long an;
    final com.bytedance.sdk.component.b.hc.d.hc.c d;
    private long gb;
    private List<String> h;
    boolean hc;
    private final Deque<com.bytedance.sdk.component.b.hc.d.hc.b> tc;
    private final Runnable tt;
    private int u;

    public tc() {
        this(5, 5L, TimeUnit.MINUTES);
    }

    public tc(int i, long j, TimeUnit timeUnit) {
        this.tt = new Runnable() { // from class: com.bytedance.sdk.component.b.hc.tc.1
            @Override // java.lang.Runnable
            public void run() throws IOException {
                while (true) {
                    long jD = tc.this.d(System.nanoTime());
                    if (jD == -1) {
                        return;
                    }
                    if (jD > 0) {
                        long j2 = jD / 1000000;
                        long j3 = jD - (1000000 * j2);
                        synchronized (tc.this) {
                            try {
                                tc.this.wait(j2, (int) j3);
                            } catch (InterruptedException unused) {
                            }
                        }
                    }
                }
            }
        };
        this.tc = new ArrayDeque();
        this.d = new com.bytedance.sdk.component.b.hc.d.hc.c();
        this.u = i;
        this.an = timeUnit.toNanos(j);
        if (j <= 0) {
            throw new IllegalArgumentException("keepAliveDuration <= 0: ".concat(String.valueOf(j)));
        }
    }

    public void d(Bundle bundle) {
        if (bundle != null) {
            try {
                if (bundle.containsKey("max_idle_cnt")) {
                    int i = bundle.getInt("max_idle_cnt");
                    if (i <= 5) {
                        i = this.u;
                    }
                    this.u = i;
                }
                if (bundle.containsKey("max_idle_time")) {
                    long j = bundle.getLong("max_idle_time");
                    this.an = j > 5 ? TimeUnit.MINUTES.toNanos(j) : this.an;
                }
                if (bundle.containsKey("white_hosts") && bundle.containsKey("white_extra_idle_time")) {
                    this.h = bundle.getStringArrayList("white_hosts");
                    long j2 = bundle.getLong("white_extra_idle_time");
                    this.gb = j2 > 0 ? TimeUnit.MINUTES.toNanos(j2) : 0L;
                }
            } catch (Throwable unused) {
            }
        }
    }

    com.bytedance.sdk.component.b.hc.d.hc.b d(d dVar, com.bytedance.sdk.component.b.hc.d.hc.h hVar, us usVar) {
        if (!b && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        for (com.bytedance.sdk.component.b.hc.d.hc.b bVar : this.tc) {
            if (bVar.d(dVar, usVar)) {
                if (hVar != null) {
                    hVar.d(bVar, true);
                }
                return bVar;
            }
        }
        return null;
    }

    Socket d(d dVar, com.bytedance.sdk.component.b.hc.d.hc.h hVar) {
        if (!b && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        for (com.bytedance.sdk.component.b.hc.d.hc.b bVar : this.tc) {
            if (bVar.d(dVar, null) && bVar.u() && bVar != hVar.hc()) {
                return hVar.d(bVar);
            }
        }
        return null;
    }

    void d(com.bytedance.sdk.component.b.hc.d.hc.b bVar) {
        if (!b && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        if (!this.hc) {
            this.hc = true;
            c.execute(this.tt);
        }
        this.tc.add(bVar);
    }

    boolean hc(com.bytedance.sdk.component.b.hc.d.hc.b bVar) {
        if (!b && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        if (bVar.d || this.u == 0) {
            this.tc.remove(bVar);
            return true;
        }
        notifyAll();
        return false;
    }

    long d(long j) throws IOException {
        try {
            synchronized (this) {
                com.bytedance.sdk.component.b.hc.d.hc.b bVar = null;
                long j2 = Long.MIN_VALUE;
                int i = 0;
                int i2 = 0;
                for (com.bytedance.sdk.component.b.hc.d.hc.b bVar2 : this.tc) {
                    if (d(bVar2, j) > 0) {
                        i2++;
                    } else {
                        i++;
                        long j3 = j - bVar2.u;
                        com.bytedance.sdk.component.b.hc.d.hc.b bVar3 = bVar;
                        if (this.gb > 0 && b(bVar2)) {
                            j3 -= this.gb;
                        }
                        if (j3 > j2) {
                            bVar = bVar2;
                            j2 = j3;
                        } else {
                            bVar = bVar3;
                        }
                    }
                }
                com.bytedance.sdk.component.b.hc.d.hc.b bVar4 = bVar;
                long j4 = this.an;
                if (j2 < j4 && i <= this.u) {
                    if (i > 0) {
                        return j4 - j2;
                    }
                    if (i2 > 0) {
                        return j4;
                    }
                    this.hc = false;
                    com.bytedance.sdk.component.utils.mq.d("ConnectionPool", "cleanup: ");
                    return -1L;
                }
                this.tc.remove(bVar4);
                com.bytedance.sdk.component.b.hc.d.b.d(bVar4.b());
                return 0L;
            }
        } catch (OutOfMemoryError unused) {
            return this.an;
        }
    }

    private int d(com.bytedance.sdk.component.b.hc.d.hc.b bVar, long j) {
        List<Reference<com.bytedance.sdk.component.b.hc.d.hc.h>> list = bVar.c;
        int i = 0;
        while (i < list.size()) {
            Reference<com.bytedance.sdk.component.b.hc.d.hc.h> reference = list.get(i);
            if (reference.get() != null) {
                i++;
            } else {
                com.bytedance.sdk.component.b.hc.d.h.u.hc().d("A connection to " + bVar.d().d().d() + " was leaked. Did you forget to close a response body?", ((h.d) reference).d);
                list.remove(i);
                bVar.d = true;
                if (list.isEmpty()) {
                    bVar.u = j - this.an;
                    return 0;
                }
            }
        }
        return list.size();
    }

    private boolean b(com.bytedance.sdk.component.b.hc.d.hc.b bVar) {
        try {
            List<String> list = this.h;
            if (list != null && !list.isEmpty() && bVar.d() != null && bVar.d().d() != null && bVar.d().d().d() != null && bVar.d().d().d().h() != null) {
                String strH = bVar.d().d().d().h();
                if (!TextUtils.isEmpty(strH)) {
                    if (this.h.contains(strH)) {
                        return true;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }
}
