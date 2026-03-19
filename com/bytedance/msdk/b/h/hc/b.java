package com.bytedance.msdk.b.h.hc;

import android.os.Handler;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class b implements d {
    private Handler d;
    private hc hc;

    @Override // com.bytedance.msdk.b.h.hc.d
    public void d(Handler handler, com.bytedance.msdk.core.tc.hc hcVar, hc hcVar2) {
        this.d = handler;
        this.hc = hcVar2;
        if (handler == null || hcVar2 == null || hcVar == null) {
            return;
        }
        hcVar.u().put("serverBidding_timeout", Boolean.FALSE);
        handler.postDelayed(hcVar2, hcVar.h());
    }

    @Override // com.bytedance.msdk.b.h.hc.d
    public void d() {
        hc hcVar;
        if (this.d == null || (hcVar = this.hc) == null || hcVar.d()) {
            return;
        }
        this.d.removeCallbacks(this.hc);
        this.hc.run();
    }
}
