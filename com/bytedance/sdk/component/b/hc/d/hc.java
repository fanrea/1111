package com.bytedance.sdk.component.b.hc.d;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class hc implements Runnable {
    protected final String hc;

    protected abstract void b();

    public hc(String str, Object... objArr) {
        this.hc = b.d(str, objArr);
    }

    @Override // java.lang.Runnable
    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName("csj_" + this.hc);
        try {
            b();
        } finally {
            Thread.currentThread().setName(name);
        }
    }
}
