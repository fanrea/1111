package com.kwad.components.ct.coupon.entry;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import java.lang.ref.WeakReference;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public abstract class a {
    private final long ano;
    private final long anp;
    private long anq;
    private boolean anr = false;
    private long ans;
    private boolean ant;
    private Handler mHandler;

    public abstract void onFinish();

    public abstract void onTick(long j);

    public a(long j, long j2) {
        this.mHandler = null;
        this.ano = j;
        this.anp = j2;
        this.mHandler = new HandlerC0501a(this);
    }

    public final synchronized void cancel() {
        this.anr = true;
        this.mHandler.removeMessages(1);
    }

    public final synchronized a xP() {
        this.anr = false;
        if (this.ano <= 0) {
            onFinish();
            return this;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime() + this.ano;
        this.anq = jElapsedRealtime;
        this.ans = jElapsedRealtime;
        this.ant = false;
        Handler handler = this.mHandler;
        handler.sendMessage(handler.obtainMessage(1));
        return this;
    }

    public final synchronized void pause() {
        this.ans = this.anq - SystemClock.elapsedRealtime();
        this.mHandler.removeMessages(1);
        this.ant = true;
    }

    public final synchronized void resume() {
        this.anq = SystemClock.elapsedRealtime() + this.ans;
        this.ant = false;
        Handler handler = this.mHandler;
        handler.sendMessage(handler.obtainMessage(1));
    }

    /* renamed from: com.kwad.components.ct.coupon.entry.a$a, reason: collision with other inner class name */
    static class HandlerC0501a extends Handler {
        private WeakReference<a> anu;

        HandlerC0501a(a aVar) {
            this.anu = new WeakReference<>(aVar);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            long j;
            synchronized (this) {
                a aVar = this.anu.get();
                if (aVar != null && !aVar.anr) {
                    if (aVar.ant) {
                        return;
                    }
                    long jElapsedRealtime = aVar.anq - SystemClock.elapsedRealtime();
                    long j2 = 0;
                    if (jElapsedRealtime <= 0) {
                        aVar.onFinish();
                    } else {
                        long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                        aVar.onTick(jElapsedRealtime);
                        long jElapsedRealtime3 = SystemClock.elapsedRealtime() - jElapsedRealtime2;
                        if (jElapsedRealtime >= aVar.anp) {
                            j = aVar.anp - jElapsedRealtime3;
                            while (j < 0) {
                                j += aVar.anp;
                            }
                        } else {
                            j = jElapsedRealtime - jElapsedRealtime3;
                            if (j < 0) {
                            }
                            sendMessageDelayed(obtainMessage(1), j2);
                        }
                        j2 = j;
                        sendMessageDelayed(obtainMessage(1), j2);
                    }
                }
            }
        }
    }
}
