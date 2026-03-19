package com.bytedance.sdk.component.hc.d.hc;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class u implements Runnable {
    protected final String hc;

    protected abstract void hc();

    public u(String str, Object... objArr) {
        this.hc = tc.d(str, objArr);
    }

    @Override // java.lang.Runnable
    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName("csj_" + this.hc);
        try {
            hc();
        } finally {
            Thread.currentThread().setName(name);
        }
    }
}
