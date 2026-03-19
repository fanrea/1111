package com.kwad.components.core.a;

import android.os.SystemClock;
import android.text.TextUtils;
import com.kwad.sdk.core.c.b;
import com.kwad.sdk.core.c.d;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.report.g;
import com.kwad.sdk.core.report.n;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a {
    private String OV;
    private String OW;
    private long OX;
    private long OY;
    private boolean OZ = false;
    private Timer mTimer;
    private final long period;

    /* renamed from: com.kwad.components.core.a.a$a, reason: collision with other inner class name */
    static final class C0457a {
        private static final a Pb = new a();
    }

    public static a of() {
        return C0457a.Pb;
    }

    public a() {
        this.OX = -1L;
        try {
            this.OX = SystemClock.elapsedRealtime();
        } catch (Throwable th) {
            this.OX = System.currentTimeMillis();
            c.printStackTraceOnly(th);
        }
        this.period = TimeUnit.MINUTES.toMillis(e.XL());
        d dVar = new d() { // from class: com.kwad.components.core.a.a.1
            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            public final void onBackToForeground() {
                super.onBackToForeground();
                a.this.az();
            }

            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            public final void onBackToBackground() {
                super.onBackToBackground();
                a.this.aA();
            }
        };
        b.aaf();
        b.a(dVar);
    }

    public final void az() {
        if (this.OZ) {
            return;
        }
        this.OZ = true;
        if (this.period <= 0) {
            return;
        }
        this.mTimer = new Timer();
        aA(1);
        TimerTask timerTask = new TimerTask() { // from class: com.kwad.components.core.a.a.2
            @Override // java.util.TimerTask, java.lang.Runnable
            public final void run() {
                a.this.aA(2);
            }
        };
        try {
            Timer timer = this.mTimer;
            long j = this.period;
            timer.schedule(timerTask, j, j);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aA() {
        this.OZ = false;
        if (this.period <= 0) {
            return;
        }
        Timer timer = this.mTimer;
        if (timer != null) {
            timer.cancel();
        }
        aA(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aA(int i) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j = jElapsedRealtime - this.OX;
        this.OX = jElapsedRealtime;
        if (i == 1) {
            this.OY = 0L;
            this.OW = UUID.randomUUID().toString();
            if (TextUtils.isEmpty(this.OV)) {
                this.OV = this.OW;
            }
        }
        this.OY++;
        n nVar = new n(10220L);
        nVar.bBn = this.OY;
        if (j > 0) {
            nVar.bFQ = j;
        }
        nVar.bFR = i;
        nVar.OV = this.OV;
        nVar.OW = this.OW;
        g.a(nVar);
    }
}
