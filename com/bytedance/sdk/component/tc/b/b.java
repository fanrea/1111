package com.bytedance.sdk.component.tc.b;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class b extends com.bytedance.sdk.component.tc.d.b implements Runnable {
    final Runnable c;

    public b(Runnable runnable) {
        super(runnable);
        this.c = runnable;
        hc(false);
        d(false);
    }

    @Override // com.bytedance.sdk.component.tc.d.b, java.lang.Runnable
    public void run() {
        this.c.run();
    }
}
