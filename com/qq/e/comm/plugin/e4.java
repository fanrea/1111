package com.qq.e.comm.plugin;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class e4 implements d4 {
    private static final String d = "e4";
    private final qd a;
    private final h4 b;
    private ScheduledFuture<?> c;

    public e4(qd qdVar, h4 h4Var) {
        this.a = qdVar;
        this.b = h4Var;
    }

    @Override // com.qq.e.comm.plugin.d4
    public void onResume() {
        ScheduledFuture<?> scheduledFuture = this.c;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
    }

    @Override // com.qq.e.comm.plugin.d4
    public void onPause() {
        ScheduledFuture<?> scheduledFuture = this.c;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
        this.c = qg.f.scheduleAtFixedRate(new a(), 200L, 200L, TimeUnit.MILLISECONDS);
    }

    /* compiled from: A */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            mh mhVarC;
            ae aeVarB = e4.this.a.b();
            if (aeVarB == null || (mhVarC = aeVarB.c()) == null || !mhVarC.isPlaying()) {
                return;
            }
            String unused = e4.d;
            mhVarC.pause();
            b10.a(9411113, f5.a(e4.this.b));
            if (e4.this.c == null || e4.this.c.isCancelled()) {
                return;
            }
            e4.this.c.cancel(false);
        }
    }

    @Override // com.qq.e.comm.plugin.d4
    public void onDestroy() {
        ScheduledFuture<?> scheduledFuture = this.c;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
    }
}
