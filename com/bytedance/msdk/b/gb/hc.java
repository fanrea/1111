package com.bytedance.msdk.b.gb;

import android.content.Context;
import com.bytedance.sdk.openadsdk.sy.d.hc.d.h;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc {
    public static void d(Context context, com.bytedance.sdk.openadsdk.mediation.hc.hc.d dVar, com.bytedance.sdk.openadsdk.sy.d.hc.d.an anVar, boolean z) {
        com.bytedance.sdk.openadsdk.mediation.hc.hc.hc hcVarZw;
        if (dVar != null && (hcVarZw = dVar.zw()) != null && hcVarZw.tc() == null) {
            com.bytedance.msdk.d.u.b.c("TMe", "使用聚合信息流广告自渲染模版混用场景时，需设置MediationNativeToBannerListener监听回调否则会影响相关功能使用，具体可以参考接入文档，若不能及时设置，建议修改瀑布流配置为模版信息流广告暂不进行混用。");
        }
        new com.bytedance.sdk.gromore.d.d.h.c.u(context, dVar, anVar, z).d();
    }

    public static void d(Context context, com.bytedance.sdk.openadsdk.mediation.hc.hc.d dVar, com.bytedance.sdk.openadsdk.sy.d.hc.d.b bVar, boolean z) {
        new com.bytedance.sdk.gromore.d.d.h.c.an(context, dVar, bVar, z).d();
    }

    public static void d(Context context, com.bytedance.sdk.openadsdk.mediation.hc.hc.d dVar, com.bytedance.sdk.openadsdk.sy.d.hc.d.hc hcVar) {
        new com.bytedance.sdk.gromore.d.d.h.hc.b(context, dVar, hcVar).d();
    }

    public static void d(Context context, com.bytedance.sdk.openadsdk.mediation.hc.hc.d dVar, h hVar) {
        new com.bytedance.sdk.gromore.d.d.h.u.b(context, dVar, hVar).d();
    }

    public static void d(Context context, com.bytedance.sdk.openadsdk.mediation.hc.hc.d dVar, com.bytedance.sdk.gromore.d.d.d.d dVar2, boolean z) {
        new com.bytedance.sdk.gromore.d.d.h.d.b(context, dVar, dVar2, z).d();
    }

    public static void d(Context context, com.bytedance.sdk.openadsdk.mediation.hc.hc.d dVar, com.bytedance.sdk.gromore.d.d dVar2, com.bytedance.sdk.openadsdk.sy.d.hc.d.d dVar3, boolean z) {
        com.bytedance.sdk.gromore.d.d.h.an.b bVar = new com.bytedance.sdk.gromore.d.d.h.an.b(context, dVar, dVar3, z);
        if (dVar2 != null && dVar2.tt() != 0) {
            bVar.d(dVar2.tt());
        } else {
            bVar.d();
        }
    }

    public static void d(Context context, com.bytedance.sdk.openadsdk.mediation.hc.hc.d dVar, com.bytedance.sdk.openadsdk.sy.d.hc.d.c cVar) {
        new com.bytedance.sdk.gromore.d.d.h.b.b(context, dVar, cVar).d();
    }

    public static void hc(Context context, com.bytedance.sdk.openadsdk.mediation.hc.hc.d dVar, com.bytedance.sdk.openadsdk.sy.d.hc.d.c cVar) {
        new com.bytedance.sdk.gromore.d.d.h.b.h(context, dVar, cVar).d();
    }
}
