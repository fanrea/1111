package com.bytedance.sdk.component.gb.hc.hc;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.sdk.component.gb.d.c;
import com.bytedance.sdk.component.gb.d.tt;
import com.bytedance.sdk.component.gb.d.u;
import com.bytedance.sdk.component.gb.hc.hc.b.b;
import com.bytedance.sdk.component.utils.mq;
import java.util.Comparator;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc implements tt {
    private volatile Handler an;
    private u h;
    private volatile b u;
    public static final com.bytedance.sdk.component.gb.hc.hc.d.d d = new com.bytedance.sdk.component.gb.hc.hc.d.d();
    public static final long b = System.currentTimeMillis();
    public static long c = 0;
    public volatile int hc = 0;
    private final Comparator<com.bytedance.sdk.component.gb.d.hc> gb = new Comparator<com.bytedance.sdk.component.gb.d.hc>() { // from class: com.bytedance.sdk.component.gb.hc.hc.hc.1
        @Override // java.util.Comparator
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public int compare(com.bytedance.sdk.component.gb.d.hc hcVar, com.bytedance.sdk.component.gb.d.hc hcVar2) {
            return hc.this.d(hcVar, hcVar2);
        }
    };

    public hc(u uVar) {
        this.h = uVar;
    }

    public void d(int i) {
        this.hc = i;
    }

    public boolean b() {
        return this.hc == 1;
    }

    public boolean c() {
        return this.hc == 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int d(com.bytedance.sdk.component.gb.d.hc hcVar, com.bytedance.sdk.component.gb.d.hc hcVar2) {
        long jD;
        long jHc;
        long jHc2;
        long jD2;
        if (hcVar == null) {
            return hcVar2 == null ? 0 : -1;
        }
        if (hcVar2 == null) {
            return 1;
        }
        if (hcVar.u() == hcVar2.u()) {
            if (hcVar.d() != null) {
                jD = hcVar.d().d();
                jHc = hcVar.d().hc();
            } else {
                jD = 0;
                jHc = 0;
            }
            if (hcVar2.d() != null) {
                jD2 = hcVar2.d().d();
                jHc2 = hcVar2.d().hc();
            } else {
                jHc2 = 0;
                jD2 = 0;
            }
            if (jD == 0 || jD2 == 0) {
                return 0;
            }
            long j = jD - jD2;
            if (Math.abs(j) > 2147483647L) {
                return 0;
            }
            if (j != 0) {
                return (int) j;
            }
            if (jHc == 0 || jHc2 == 0) {
                return 0;
            }
            return (int) (jHc - jHc2);
        }
        return hcVar.u() - hcVar2.u();
    }

    @Override // com.bytedance.sdk.component.gb.d.tt
    public void d() {
        u uVar = this.h;
        if (uVar == null) {
            return;
        }
        d(uVar.u());
        hc();
    }

    public b u() {
        return this.u;
    }

    public void d(Handler handler) {
        this.an = handler;
    }

    public boolean d(String str) {
        try {
            if (this.u != null || com.bytedance.sdk.component.gb.hc.d.d(str) || this.h == null) {
                return false;
            }
            synchronized (this) {
                if (this.u != null) {
                    return false;
                }
                this.u = new b(this.h, this);
                this.u.an();
                return true;
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.gb.hc.b.b.b(th.getMessage(), this.h);
            return false;
        }
    }

    @Override // com.bytedance.sdk.component.gb.d.tt
    public void d(com.bytedance.sdk.component.gb.d.hc hcVar) {
        u uVar;
        if (hcVar == null || (uVar = this.h) == null) {
            com.bytedance.sdk.component.gb.hc.b.b.c("error : log config is null", this.h);
            return;
        }
        String strU = uVar.u();
        hcVar.d(System.currentTimeMillis());
        d(strU);
        c cVarC = this.h.c();
        b bVar = this.u;
        if (bVar != null) {
            d(cVarC, hcVar);
            bVar.d(hcVar, hcVar.u() == 4);
        }
    }

    private void d(final c cVar, com.bytedance.sdk.component.gb.d.hc hcVar) {
        if (cVar != null) {
            try {
                if (cVar.b()) {
                    long jHc = 0;
                    if (hcVar != null && hcVar.d() != null) {
                        jHc = hcVar.d().hc();
                    }
                    final long j = jHc;
                    if (j == 1) {
                        c = System.currentTimeMillis();
                    }
                    AtomicLong atomicLongW = d.w();
                    com.bytedance.sdk.component.gb.hc.b.hc.d(atomicLongW, 1, this.h);
                    if (atomicLongW.get() == 200) {
                        if (Looper.getMainLooper() == Looper.myLooper()) {
                            Executor executorGb = cVar.gb();
                            if (executorGb == null) {
                                executorGb = cVar.tt();
                            }
                            if (executorGb != null) {
                                executorGb.execute(new com.bytedance.sdk.component.gb.hc.u.hc("report") { // from class: com.bytedance.sdk.component.gb.hc.hc.hc.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        hc.this.d(cVar, j);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        d(cVar, j);
                    }
                }
            } catch (Exception e) {
                mq.d(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(c cVar, long j) {
        b bVar = this.u;
        if (cVar == null || bVar == null) {
            return;
        }
        com.bytedance.sdk.component.gb.hc.hc.d.d dVar = d;
        bVar.d(cVar.d(dVar.d(j, this.h)), true);
        dVar.an();
    }

    @Override // com.bytedance.sdk.component.gb.d.tt
    public void hc() {
        u uVar = this.h;
        if (uVar == null || uVar.c() == null) {
            com.bytedance.sdk.component.gb.hc.b.b.hc("discard flush config is null", uVar);
            return;
        }
        com.bytedance.sdk.component.gb.hc.b.b.hc("flushMemoryAndDB", uVar);
        c cVarC = uVar.c();
        final b bVar = this.u;
        if (Looper.myLooper() != Looper.getMainLooper()) {
            if (bVar != null) {
                bVar.d(72, "start_child2");
                return;
            }
            return;
        }
        Executor executorGb = cVarC.gb();
        if (executorGb == null) {
            executorGb = cVarC.tt();
        }
        if (executorGb == null) {
            com.bytedance.sdk.component.gb.hc.b.b.hc("discard flush executor is null", uVar);
        } else {
            executorGb.execute(new com.bytedance.sdk.component.gb.hc.u.hc("flush") { // from class: com.bytedance.sdk.component.gb.hc.hc.hc.3
                @Override // java.lang.Runnable
                public void run() {
                    b bVar2 = bVar;
                    if (bVar2 != null) {
                        bVar2.d(72, "start_child1");
                    }
                }
            });
        }
    }
}
