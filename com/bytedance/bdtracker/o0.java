package com.bytedance.bdtracker;

import com.bytedance.bdtracker.b;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class o0 implements b.d {
    public final /* synthetic */ Throwable a;

    public o0(n0 n0Var, Throwable th) {
        this.a = th;
    }

    @Override // com.bytedance.bdtracker.b.d
    public void a(d dVar) {
        if (dVar.getInitConfig() == null || !dVar.getInitConfig().isMonitorEnabled()) {
            return;
        }
        l2.b(dVar.getMonitor(), this.a);
    }
}
