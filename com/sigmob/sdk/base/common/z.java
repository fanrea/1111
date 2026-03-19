package com.sigmob.sdk.base.common;

import android.os.Handler;
import android.os.HandlerThread;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class z {
    private static final String a = "NativeLoadReadyRecordManager";
    private static final z f = new z();
    private boolean b = false;
    private int c = 120;
    private HandlerThread d;
    private Handler e;

    private class a implements Runnable {
        private a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (z.this.b) {
                z.this.d();
                try {
                    HashMap<String, y> mapA = y.a();
                    if (com.sigmob.sdk.base.utils.e.b(mapA)) {
                        for (y yVar : new ArrayList(mapA.values())) {
                            if (yVar != null) {
                                ac.a(yVar);
                                yVar.b();
                            }
                        }
                    }
                } catch (Throwable unused) {
                }
                if (com.sigmob.sdk.base.utils.n.b(z.this.e)) {
                    z.this.e.postDelayed(this, z.this.c * 1000);
                }
            }
        }
    }

    private z() {
    }

    public static z a() {
        return f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        Handler handler = this.e;
        if (handler == null) {
            return;
        }
        handler.removeCallbacksAndMessages(null);
    }

    public void a(int log_interval_time) {
        if (log_interval_time <= 0) {
            c();
            return;
        }
        int iMax = Math.max(log_interval_time, 10);
        if (this.c == iMax) {
            return;
        }
        this.c = iMax;
        if (!this.b) {
            b();
        } else if (com.sigmob.sdk.base.utils.n.b(this.e)) {
            this.e.removeCallbacksAndMessages(null);
            this.e.postDelayed(new a(), log_interval_time * 1000);
        }
    }

    public synchronized void b() {
        if (this.b) {
            return;
        }
        this.b = true;
        y.c();
        if (this.d == null) {
            HandlerThread handlerThread = new HandlerThread(a);
            this.d = handlerThread;
            handlerThread.start();
        }
        if (this.e == null) {
            this.e = new Handler(this.d.getLooper());
        }
        this.e.removeCallbacksAndMessages(null);
        this.e.postDelayed(new a(), this.c * 1000);
    }

    public void c() {
        this.b = false;
        d();
    }
}
