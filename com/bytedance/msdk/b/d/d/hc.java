package com.bytedance.msdk.b.d.d;

import android.util.SparseArray;
import android.view.View;
import com.bytedance.sdk.component.utils.mq;
import java.util.function.Function;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc extends b {
    public hc(com.bytedance.msdk.b.b.hc.d.d.hc hcVar, Function<SparseArray<Object>, Object> function) {
        super(hcVar, function);
    }

    @Override // com.bytedance.msdk.hc.b
    public View tt() {
        return g();
    }

    public View g() {
        try {
            if (this.tc != null) {
                Object objApply = this.tc.apply(com.bytedance.sdk.openadsdk.w.c.d().d(8113).d(View.class).hc());
                if (objApply instanceof View) {
                    return (View) objApply;
                }
                return null;
            }
        } catch (Exception e) {
            mq.d(e);
        }
        return null;
    }
}
