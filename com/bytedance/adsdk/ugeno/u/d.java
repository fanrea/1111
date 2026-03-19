package com.bytedance.adsdk.ugeno.u;

import android.content.Context;
import com.bytedance.sdk.djx.core.log.ILogConst;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d implements gb {
    @Override // com.bytedance.adsdk.ugeno.u.gb
    public List<h> d() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new h(ILogConst.DRAW_ENTER_TYPE_SLIDE) { // from class: com.bytedance.adsdk.ugeno.u.d.1
            @Override // com.bytedance.adsdk.ugeno.u.h
            public com.bytedance.adsdk.ugeno.u.b.hc d(Context context) {
                return new com.bytedance.adsdk.ugeno.u.b.c(context);
            }
        });
        arrayList.add(new h("tap") { // from class: com.bytedance.adsdk.ugeno.u.d.2
            @Override // com.bytedance.adsdk.ugeno.u.h
            public com.bytedance.adsdk.ugeno.u.b.hc d(Context context) {
                return new com.bytedance.adsdk.ugeno.u.b.u(context);
            }
        });
        arrayList.add(new h("timer") { // from class: com.bytedance.adsdk.ugeno.u.d.3
            @Override // com.bytedance.adsdk.ugeno.u.h
            public com.bytedance.adsdk.ugeno.u.b.hc d(Context context) {
                return new com.bytedance.adsdk.ugeno.u.b.an(context);
            }
        });
        arrayList.add(new h("touchStart") { // from class: com.bytedance.adsdk.ugeno.u.d.4
            @Override // com.bytedance.adsdk.ugeno.u.h
            public com.bytedance.adsdk.ugeno.u.b.hc d(Context context) {
                return new com.bytedance.adsdk.ugeno.u.b.gb(context);
            }
        });
        arrayList.add(new h("touchEnd") { // from class: com.bytedance.adsdk.ugeno.u.d.5
            @Override // com.bytedance.adsdk.ugeno.u.h
            public com.bytedance.adsdk.ugeno.u.b.hc d(Context context) {
                return new com.bytedance.adsdk.ugeno.u.b.h(context);
            }
        });
        arrayList.add(new h("animateState") { // from class: com.bytedance.adsdk.ugeno.u.d.6
            @Override // com.bytedance.adsdk.ugeno.u.h
            public com.bytedance.adsdk.ugeno.u.b.hc d(Context context) {
                return new com.bytedance.adsdk.ugeno.u.b.d(context);
            }
        });
        return arrayList;
    }
}
