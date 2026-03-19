package com.bytedance.msdk.b.d.d;

import android.app.Activity;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.component.utils.mq;
import java.util.List;
import java.util.function.Function;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class gb extends b {
    private int mk;
    private int mq;
    private boolean uo;

    public abstract void d(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, com.bytedance.msdk.api.c.d.h.tc tcVar);

    public gb(com.bytedance.msdk.b.b.hc.d.d.hc hcVar, Function<SparseArray<Object>, Object> function) {
        super(hcVar, function);
        this.mk = 0;
        this.mq = 0;
        this.uo = false;
    }

    public final void d(d dVar) {
        int i = this.mq;
        if (i < 60) {
            this.mq = i + 1;
            if (dVar != null) {
                dVar.d();
                return;
            }
            return;
        }
        com.bytedance.msdk.d.u.b.c("TTMediationSDK", "自定义Adapter click方法回调次数需要小于60次");
    }

    public final void hc(d dVar) {
        if (this.uo) {
            int i = this.mk;
            if (i < 2) {
                this.mk = i + 1;
                if (dVar != null) {
                    dVar.d();
                    return;
                }
                return;
            }
            com.bytedance.msdk.d.u.b.c("TTMediationSDK", "自定义Adapter show方法回调次数需要小于2次");
            return;
        }
        com.bytedance.msdk.d.u.b.c("TTMediationSDK", "自定义Adapter show方法回调必须由GroMore触发show时才会生效");
    }

    @Override // com.bytedance.msdk.hc.b
    public void d(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, com.bytedance.msdk.api.c.d.h.tc tcVar, List<View> list4) {
        super.d(activity, viewGroup, list, list2, list3, tcVar, list4);
        try {
            this.uo = true;
            d(activity, viewGroup, list, list2, list3, tcVar);
        } catch (Exception e) {
            mq.d(e);
        }
    }

    @Override // com.bytedance.msdk.hc.b
    public void mk() {
        try {
            this.uo = true;
            if (this.tc != null) {
                this.tc.apply(com.bytedance.sdk.openadsdk.w.c.d().d(6083).d(Void.class).hc());
            }
        } catch (Exception e) {
            mq.d(e);
        }
    }
}
