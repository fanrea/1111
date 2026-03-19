package com.kwad.components.core.h;

import android.os.Handler;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a implements Runnable {
    private InterfaceC0470a Ss;
    private volatile Handler mHandler;
    private long Sp = 1000;
    private boolean Sq = true;
    private long Sr = 0;
    private float mSpeed = 1.0f;

    /* renamed from: com.kwad.components.core.h.a$a, reason: collision with other inner class name */
    public interface InterfaceC0470a {
        void D(long j);
    }

    public a(Handler handler) {
        this.mHandler = handler;
    }

    public final void a(InterfaceC0470a interfaceC0470a) {
        this.Ss = interfaceC0470a;
    }

    public final void start() {
        this.Sq = false;
        if (this.mHandler != null) {
            this.mHandler.post(this);
        }
    }

    public final void pause() {
        this.Sq = true;
    }

    public final void resume() {
        this.Sq = false;
    }

    public final void stop() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this);
        }
    }

    public final void destroy() {
        stop();
        this.mHandler = null;
    }

    public final void setSpeed(float f) {
        if (f > 0.0f) {
            this.mSpeed = f;
        }
    }

    @Override // java.lang.Runnable
    public final synchronized void run() {
        InterfaceC0470a interfaceC0470a;
        if (this.mHandler != null) {
            if (!this.Sq && (interfaceC0470a = this.Ss) != null) {
                interfaceC0470a.D(this.Sr);
                this.Sr += this.Sp;
            }
            if (this.mHandler != null) {
                this.mHandler.postDelayed(this, (long) (this.Sp / this.mSpeed));
            }
        }
    }
}
