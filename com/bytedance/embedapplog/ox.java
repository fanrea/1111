package com.bytedance.embedapplog;

import android.os.Bundle;
import com.bytedance.embedapplog.pq;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class ox extends pq.d {
    private volatile boolean d = false;

    @Override // com.bytedance.embedapplog.pq
    public void d(int i, long j, boolean z, float f, double d, String str) {
    }

    @Override // com.bytedance.embedapplog.pq
    public void d(int i, Bundle bundle) {
        if (i != 0 || bundle == null) {
            return;
        }
        this.d = bundle.getBoolean("oa_id_limit_state");
    }

    public boolean hc() {
        return this.d;
    }
}
