package com.bytedance.msdk.an.hc;

import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.HashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class gb extends com.bytedance.sdk.openadsdk.core.ba.c {
    private com.bytedance.sdk.openadsdk.mediation.init.d.hc.d.b d;

    public gb(com.bytedance.sdk.openadsdk.mediation.init.d.hc.d.b bVar) {
        this.d = bVar;
    }

    public PluginValueSet d() {
        com.bykv.d.d.d.d.d dVarD = com.bykv.d.d.d.d.d.d();
        com.bytedance.sdk.openadsdk.mediation.init.d.hc.d.b bVar = this.d;
        dVarD.d(8468, bVar != null ? bVar.d() : new HashMap());
        com.bytedance.sdk.openadsdk.mediation.init.d.hc.d.b bVar2 = this.d;
        dVarD.d(8469, bVar2 != null ? bVar2.u() : 0);
        com.bytedance.sdk.openadsdk.mediation.init.d.hc.d.b bVar3 = this.d;
        dVarD.d(8470, bVar3 != null ? bVar3.b() : "");
        com.bytedance.sdk.openadsdk.mediation.init.d.hc.d.b bVar4 = this.d;
        dVarD.d(8471, bVar4 != null ? bVar4.c() : "");
        com.bytedance.sdk.openadsdk.mediation.init.d.hc.d.b bVar5 = this.d;
        dVarD.d(8472, bVar5 != null ? bVar5.hc() : "");
        com.bytedance.sdk.openadsdk.mediation.init.d.hc.d.b bVar6 = this.d;
        dVarD.d(8473, bVar6 != null ? bVar6.an() : "");
        com.bytedance.sdk.openadsdk.mediation.init.d.hc.d.b bVar7 = this.d;
        dVarD.d(8474, bVar7 != null ? bVar7.h() : "");
        return dVarD.hc();
    }

    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        if (i == -99999986) {
            return (T) d().sparseArray();
        }
        return null;
    }
}
