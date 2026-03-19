package com.sigmob.sdk.base.utils;

import android.os.CountDownTimer;
import com.czhj.sdk.logger.SigmobLogger;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class j {
    public static final String a = "j";
    private CountDownTimer b;
    private long c;
    private final long d;
    private final long e;
    private boolean f = false;
    private a g;

    public interface a {
        void onTimerFinished();
    }

    public j(long totalTime, long interval) {
        this.d = totalTime;
        this.e = interval;
        this.c = totalTime;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.sigmob.sdk.base.utils.j$1] */
    public void a() {
        SigmobLogger.d(a, "start", new Object[0]);
        CountDownTimer countDownTimer = this.b;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.b = new CountDownTimer(this.c, this.e) { // from class: com.sigmob.sdk.base.utils.j.1
            @Override // android.os.CountDownTimer
            public void onFinish() {
                SigmobLogger.d(j.a, "start#onFinish", new Object[0]);
                j.this.c = 0L;
                if (j.this.g == null) {
                    return;
                }
                j.this.g.onTimerFinished();
            }

            @Override // android.os.CountDownTimer
            public void onTick(long millisUntilFinished) {
                SigmobLogger.d(j.a, "start#onTick: remainingTime = " + Math.round(millisUntilFinished / 1000.0f), new Object[0]);
                j.this.c = millisUntilFinished;
            }
        }.start();
        this.f = false;
    }

    public void a(a listener) {
        this.g = listener;
    }

    public void b() {
        SigmobLogger.d(a, com.component.feed.a.e, new Object[0]);
        CountDownTimer countDownTimer = this.b;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.c = this.d;
        this.f = false;
    }

    public void c() {
        SigmobLogger.d(a, "pause", new Object[0]);
        CountDownTimer countDownTimer = this.b;
        if (countDownTimer == null || this.f) {
            return;
        }
        countDownTimer.cancel();
        this.f = true;
    }

    public void d() {
        SigmobLogger.d(a, "resume", new Object[0]);
        if (this.f) {
            a();
        }
    }

    public void e() {
        SigmobLogger.d(a, "destroy", new Object[0]);
        CountDownTimer countDownTimer = this.b;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.b = null;
        }
        this.g = null;
    }

    public long f() {
        return this.c;
    }
}
