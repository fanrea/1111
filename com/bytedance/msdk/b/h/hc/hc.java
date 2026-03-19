package com.bytedance.msdk.b.h.hc;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc implements Runnable {
    private boolean b = false;
    private com.bytedance.msdk.core.tc.hc d;
    private Runnable hc;

    public hc(com.bytedance.msdk.core.tc.hc hcVar, Runnable runnable) {
        this.d = hcVar;
        this.hc = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.bytedance.msdk.core.tc.hc hcVar = this.d;
        if (hcVar != null && hcVar.an() == 4) {
            this.d.u().put("serverBidding_timeout", Boolean.TRUE);
        }
        this.b = true;
        Runnable runnable = this.hc;
        if (runnable != null) {
            runnable.run();
        }
    }

    public boolean d() {
        return this.b;
    }
}
