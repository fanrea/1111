package com.bytedance.adsdk.ugeno.u;

import com.bytedance.adsdk.ugeno.u.an;
import com.sigmob.sdk.base.n;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class u implements b {
    @Override // com.bytedance.adsdk.ugeno.u.b
    public List<hc> d() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new hc(n.q) { // from class: com.bytedance.adsdk.ugeno.u.u.1
            @Override // com.bytedance.adsdk.ugeno.u.hc
            public com.bytedance.adsdk.ugeno.u.hc.d d(com.bytedance.adsdk.ugeno.hc.b bVar, String str, an.d dVar) {
                return new com.bytedance.adsdk.ugeno.u.hc.u(bVar, str, dVar);
            }
        });
        arrayList.add(new hc("emit") { // from class: com.bytedance.adsdk.ugeno.u.u.2
            @Override // com.bytedance.adsdk.ugeno.u.hc
            public com.bytedance.adsdk.ugeno.u.hc.d d(com.bytedance.adsdk.ugeno.hc.b bVar, String str, an.d dVar) {
                return new com.bytedance.adsdk.ugeno.u.hc.hc(bVar, str, dVar);
            }
        });
        arrayList.add(new hc("startAnimate") { // from class: com.bytedance.adsdk.ugeno.u.u.3
            @Override // com.bytedance.adsdk.ugeno.u.hc
            public com.bytedance.adsdk.ugeno.u.hc.d d(com.bytedance.adsdk.ugeno.hc.b bVar, String str, an.d dVar) {
                return new com.bytedance.adsdk.ugeno.u.hc.c(bVar, str, dVar);
            }
        });
        return arrayList;
    }
}
