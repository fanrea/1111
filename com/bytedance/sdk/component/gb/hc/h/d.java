package com.bytedance.sdk.component.gb.hc.h;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.bytedance.sdk.component.gb.d.u;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d {
    private static int b = 3000;
    private static volatile d c;
    private volatile HandlerThread d;
    private volatile Handler hc = null;
    private Looper u;

    public static d d(u uVar) {
        if (c == null) {
            synchronized (d.class) {
                if (c == null) {
                    c = new d(uVar);
                }
            }
        }
        return c;
    }

    private d(u uVar) {
        this.d = null;
        this.u = null;
        if (uVar == null || uVar.c() == null || uVar.c().e() == null) {
            this.d = new HandlerThread("csj_ad_log", 10);
            this.d.start();
        } else {
            this.u = uVar.c().e();
        }
    }

    public Handler d() {
        if (this.u != null) {
            if (this.hc == null) {
                synchronized (d.class) {
                    if (this.hc == null) {
                        this.hc = new Handler(this.u);
                    }
                }
            }
        } else if (this.d == null || !this.d.isAlive()) {
            synchronized (d.class) {
                if (this.d == null || !this.d.isAlive()) {
                    this.d = new HandlerThread("csj_init_handle", -1);
                    this.d.start();
                    this.hc = new Handler(this.d.getLooper());
                }
            }
        } else if (this.hc == null) {
            synchronized (d.class) {
                if (this.hc == null) {
                    this.hc = new Handler(this.d.getLooper());
                }
            }
        }
        return this.hc;
    }

    public int hc() {
        if (b <= 0) {
            b = 3000;
        }
        return b;
    }
}
