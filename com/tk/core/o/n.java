package com.tk.core.o;

import android.os.Handler;
import android.os.Message;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class n extends Handler {
    private final Runnable du;
    private boolean Qy = true;
    private final long Qv = 48;

    public n(long j, Runnable runnable) {
        this.du = runnable;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        if (this.Qy) {
            return;
        }
        this.du.run();
        sendEmptyMessageDelayed(0, this.Qv);
    }

    public final void start() {
        if (this.Qy) {
            this.Qy = false;
            sendEmptyMessage(0);
        }
    }

    public final void stop() {
        this.Qy = true;
        removeMessages(0);
    }

    public final boolean isRunning() {
        return !this.Qy;
    }
}
