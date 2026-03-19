package com.bytedance.adsdk.ugeno.b;

import android.text.TextUtils;
import com.alipay.sdk.m.l.a;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class mk implements h {
    private float an;
    private AtomicInteger b;
    private AtomicInteger c;
    private AtomicInteger d;
    private de gb;
    private mq h;
    private AtomicInteger hc;
    private rf tt;
    private AtomicInteger u;

    public void d(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        if ((TextUtils.equals(str, "src") || TextUtils.equals(str, "backgroundImage")) && str2.startsWith(a.r)) {
            this.hc.incrementAndGet();
        }
    }

    public int hc() {
        int i = (int) (this.an * this.hc.get());
        this.d.set(i);
        return i;
    }

    public boolean b() {
        return this.d.get() > 0;
    }

    public void d(rf rfVar) {
        this.tt = rfVar;
    }

    public void d(de deVar) {
        this.gb = deVar;
    }

    @Override // com.bytedance.adsdk.ugeno.b.h
    public void d() {
        this.c.incrementAndGet();
        if (this.c.get() == 1) {
            synchronized (this) {
                this.c.get();
            }
        }
    }

    @Override // com.bytedance.adsdk.ugeno.b.h
    public void d(com.bytedance.adsdk.ugeno.hc.b bVar, String str) {
        if (this.b.incrementAndGet() == this.d.get()) {
            synchronized (this) {
                if (this.b.get() == this.d.get()) {
                    if (this.h != null) {
                        this.hc.get();
                    }
                    if (this.tt != null) {
                        sy syVar = new sy();
                        syVar.d(0);
                        syVar.d(bVar.hc(bVar));
                    }
                }
            }
        }
    }

    @Override // com.bytedance.adsdk.ugeno.b.h
    public void hc(com.bytedance.adsdk.ugeno.hc.b bVar, String str) {
        int iIncrementAndGet = this.u.incrementAndGet();
        if (iIncrementAndGet > this.hc.get() - this.d.get()) {
            synchronized (this) {
                if (iIncrementAndGet > this.hc.get() - this.d.get() && this.tt != null) {
                    sy syVar = new sy();
                    syVar.d(-3);
                    syVar.d("image download fail");
                    syVar.d(bVar.hc(bVar));
                }
            }
        }
    }
}
