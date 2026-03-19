package com.bytedance.sdk.component.gb.hc.hc.b;

import android.os.Looper;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class u {
    protected final com.bytedance.sdk.component.gb.hc.hc.hc b;
    private volatile c d;
    protected final com.bytedance.sdk.component.gb.d.u hc;

    public void b() {
    }

    public u(com.bytedance.sdk.component.gb.d.u uVar, com.bytedance.sdk.component.gb.hc.hc.hc hcVar) {
        this.hc = uVar;
        this.b = hcVar;
    }

    public c u() {
        if (this.d == null) {
            synchronized (this) {
                if (this.d == null) {
                    this.d = new c();
                }
            }
        }
        return this.d;
    }

    public void an() {
        com.bytedance.sdk.component.gb.d.c cVarC = this.hc.c();
        if (cVarC == null || cVarC.e() == null) {
            c cVarU = u();
            cVarU.d(this);
            cVarU.start();
            return;
        }
        b();
    }

    public Looper h() {
        com.bytedance.sdk.component.gb.d.c cVarC = this.hc.c();
        if (cVarC == null || cVarC.e() == null) {
            return u().getLooper();
        }
        return cVarC.e();
    }
}
