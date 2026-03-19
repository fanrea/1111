package com.bytedance.sdk.component.tc.hc;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import com.bytedance.sdk.component.utils.zw;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d {
    private Handler b;
    private final c<hc> d;
    private Handler hc;

    private d() {
        this.d = c.d(2);
    }

    public static d d() {
        return C0284d.d;
    }

    /* renamed from: com.bytedance.sdk.component.tc.hc.d$d, reason: collision with other inner class name */
    private static class C0284d {
        private static final d d = new d();
    }

    public Handler hc() {
        if (this.hc == null) {
            synchronized (d.class) {
                if (this.hc == null) {
                    this.hc = d("csj_io_handler");
                }
            }
        }
        return this.hc;
    }

    public Handler b() {
        if (this.b == null) {
            synchronized (d.class) {
                if (this.b == null) {
                    this.b = d("csj_main_handler");
                }
            }
        }
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final Handler handler, final Handler handler2) {
        if (Build.VERSION.SDK_INT >= 23) {
            if (handler.getLooper().getQueue().isIdle()) {
                handler.removeCallbacksAndMessages(null);
                handler.getLooper().quit();
            } else {
                handler2.postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.tc.hc.d.1
                    @Override // java.lang.Runnable
                    public void run() {
                        d.this.d(handler, handler2);
                    }
                }, 1000L);
            }
        }
    }

    public zw d(zw.d dVar, final String str) {
        hc hcVar = (hc) this.d.d();
        if (hcVar != null) {
            hcVar.d(dVar);
            hcVar.post(new Runnable() { // from class: com.bytedance.sdk.component.tc.hc.d.2
                @Override // java.lang.Runnable
                public void run() {
                    Thread.currentThread().setName(str);
                }
            });
            return hcVar;
        }
        return hc(dVar, str);
    }

    public zw d(String str) {
        return d((zw.d) null, str);
    }

    private hc hc(zw.d dVar, String str) {
        HandlerThread handlerThread = new HandlerThread(str);
        handlerThread.start();
        return new hc(handlerThread, dVar);
    }

    public boolean d(zw zwVar) {
        if (!(zwVar instanceof hc)) {
            return false;
        }
        hc hcVar = (hc) zwVar;
        if (this.d.d((c<hc>) hcVar)) {
            return true;
        }
        hcVar.hc();
        return true;
    }
}
