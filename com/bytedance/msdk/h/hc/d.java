package com.bytedance.msdk.h.hc;

import android.text.TextUtils;
import com.bytedance.msdk.d.u.b;
import com.bytedance.msdk.gb.zw;
import com.bytedance.sdk.component.utils.mq;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d {
    private static volatile d hc;
    private String an;
    private long c;
    private long u;
    private final String d = "d";
    private zw b = com.bytedance.msdk.h.d.u();

    private d() {
    }

    public static d d() {
        if (hc == null) {
            synchronized (d.class) {
                if (hc == null) {
                    hc = new d();
                }
            }
        }
        return hc;
    }

    public void d(long j) {
        try {
            if (this.b.hc("first_install_time", -1L) == -1) {
                long jHc = com.bytedance.msdk.h.d.d().hc("first_install_time", -1L);
                if (jHc != -1) {
                    j = jHc;
                }
                this.b.d("first_install_time", j);
            }
        } catch (Throwable th) {
            mq.d(th);
        }
    }

    public long hc() {
        try {
            long jHc = this.b.hc("first_install_time", -1L);
            if (jHc == -1) {
                jHc = com.bytedance.msdk.h.d.d().hc("first_install_time", -1L);
                if (jHc == -1) {
                    jHc = System.currentTimeMillis();
                }
                this.b.d("first_install_time", jHc);
            }
            return jHc;
        } catch (Throwable th) {
            mq.d(th);
            return 0L;
        }
    }

    public synchronized void b() {
        this.b.d("discard_num", this.b.hc("discard_num", 0) + 1);
    }

    public synchronized int c() {
        return this.b.hc("discard_num", 0);
    }

    public synchronized void u() {
        this.b.d("discard_num", 0);
    }

    public void an() {
        this.c = System.currentTimeMillis();
    }

    public void h() {
        this.u = System.currentTimeMillis();
    }

    public long gb() {
        long j = this.u - this.c;
        b.hc(this.d, "InitMethodDuration = ".concat(String.valueOf(j)));
        return j;
    }

    public long tt() {
        long jCurrentTimeMillis = System.currentTimeMillis() - this.c;
        b.hc(this.d, "SplashRequestDuration = ".concat(String.valueOf(jCurrentTimeMillis)));
        return jCurrentTimeMillis;
    }

    public long tc() {
        long jCurrentTimeMillis = System.currentTimeMillis() - this.c;
        b.hc(this.d, "SplashFillDuration = ".concat(String.valueOf(jCurrentTimeMillis)));
        return jCurrentTimeMillis;
    }

    public void d(String str) {
        this.an = str;
    }

    public boolean mk() {
        return TextUtils.isEmpty(this.an);
    }

    public boolean mq() {
        boolean zEquals = TextUtils.equals(this.an, com.bytedance.msdk.u.d.b);
        b.hc(this.d, "canUploadInitDuration = " + zEquals + " 当sessionId = " + com.bytedance.msdk.u.d.b + " 存储的sessionId = " + this.an);
        return !zEquals;
    }
}
