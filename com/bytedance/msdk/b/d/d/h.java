package com.bytedance.msdk.b.d.d;

import android.app.Activity;
import com.bytedance.sdk.component.utils.mq;
import java.util.function.Function;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class h extends b {
    public h(com.bytedance.msdk.b.b.hc.d.d.hc hcVar, Function function) {
        super(hcVar, function);
    }

    @Override // com.bytedance.msdk.hc.b
    public void d(Activity activity, Object obj, String str) {
        try {
            b(activity);
        } catch (Exception e) {
            mq.d(e);
        }
    }

    public void b(Activity activity) {
        if (this.tt != null) {
            this.tt.an();
        }
        if (this.tc != null) {
            this.tc.apply(com.bytedance.sdk.openadsdk.w.c.d().d(8113).d(20033, activity).d(Void.class).hc());
        }
    }
}
