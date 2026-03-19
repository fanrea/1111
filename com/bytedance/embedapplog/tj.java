package com.bytedance.embedapplog;

import android.os.Bundle;
import com.bytedance.embedapplog.pq;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class tj extends pq.d {
    private volatile String d = "";

    @Override // com.bytedance.embedapplog.pq
    public void d(int i, long j, boolean z, float f, double d, String str) {
    }

    @Override // com.bytedance.embedapplog.pq
    public void d(int i, Bundle bundle) {
        if (i != 0 || bundle == null) {
            return;
        }
        this.d = bundle.getString("oa_id_flag");
    }

    public String hc() {
        return this.d;
    }
}
