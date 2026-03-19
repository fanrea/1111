package com.bytedance.msdk.b.d.d;

import android.util.SparseArray;
import android.view.ViewGroup;
import com.bytedance.sdk.component.utils.mq;
import java.util.function.Function;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class tc extends b {
    public tc(com.bytedance.msdk.b.b.hc.d.d.hc hcVar, Function<SparseArray<Object>, Object> function) {
        super(hcVar, function);
    }

    @Override // com.bytedance.msdk.hc.b
    public void d(ViewGroup viewGroup) {
        try {
            hc(viewGroup);
        } catch (Exception e) {
            mq.d(e);
        }
    }

    public void hc(ViewGroup viewGroup) {
        if (this.tt != null) {
            this.tt.an();
        }
        if (this.tc != null) {
            this.tc.apply(com.bytedance.sdk.openadsdk.w.c.d().d(6152).d(20060, viewGroup).d(Void.class).hc());
        }
    }
}
