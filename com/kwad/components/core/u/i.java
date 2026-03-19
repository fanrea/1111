package com.kwad.components.core.u;

import android.os.Handler;
import android.os.Looper;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class i {
    private long Gc;
    private a aaA;
    private long aay = 100;
    private long aaz = 0;
    private boolean Sq = false;
    private Handler aaB = new Handler(Looper.getMainLooper());
    private Runnable aaC = new Runnable() { // from class: com.kwad.components.core.u.i.1
        @Override // java.lang.Runnable
        public final void run() {
            if (i.this.aaB == null) {
                return;
            }
            if (i.this.Sq) {
                i.this.aaB.postDelayed(this, i.this.aay / 2);
                return;
            }
            i.this.tw();
            if (i.this.aaB != null) {
                i.this.aaB.postDelayed(this, i.this.aay);
            }
        }
    };

    public interface a {
        void onProgress(long j, long j2);
    }

    public i(long j) {
        this.Gc = j;
    }

    public final void start() {
        Handler handler = this.aaB;
        if (handler == null) {
            return;
        }
        handler.post(this.aaC);
    }

    public final void stop() {
        Handler handler = this.aaB;
        if (handler != null) {
            handler.removeCallbacks(this.aaC);
            this.aaB = null;
        }
    }

    public final void pause() {
        this.Sq = true;
    }

    public final void resume() {
        this.Sq = false;
    }

    public final void a(a aVar) {
        this.aaA = aVar;
    }

    protected final void tw() {
        a aVar = this.aaA;
        if (aVar != null) {
            long j = this.Gc;
            long j2 = j - this.aaz;
            aVar.onProgress(j2, j);
            if (j2 <= 0) {
                stop();
            }
        }
        this.aaz += this.aay;
    }
}
