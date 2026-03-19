package com.bytedance.msdk.an.hc;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.List;
import java.util.function.Supplier;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class h extends com.bytedance.sdk.openadsdk.core.ba.c implements Supplier<SparseArray<Object>> {
    private com.bytedance.sdk.openadsdk.mediation.init.d.hc.d.hc d;

    public h(com.bytedance.sdk.openadsdk.mediation.init.d.hc.d.hc hcVar) {
        this.d = hcVar;
    }

    public PluginValueSet b() {
        com.bykv.d.d.d.d.d dVarD = com.bykv.d.d.d.d.d.d();
        dVarD.d(8476, c());
        dVarD.d(8477, u());
        dVarD.d(8478, an());
        dVarD.d(8027, d());
        dVarD.d(8028, hc());
        return dVarD.hc();
    }

    public List<String> c() {
        com.bytedance.sdk.openadsdk.mediation.init.d.hc.d.hc hcVar = this.d;
        if (hcVar != null) {
            return hcVar.d();
        }
        return null;
    }

    public List<String> u() {
        com.bytedance.sdk.openadsdk.mediation.init.d.hc.d.hc hcVar = this.d;
        if (hcVar != null) {
            return hcVar.hc();
        }
        return null;
    }

    public boolean an() {
        com.bytedance.sdk.openadsdk.mediation.init.d.hc.d.hc hcVar = this.d;
        if (hcVar != null) {
            return hcVar.b();
        }
        return true;
    }

    public boolean d() {
        com.bytedance.sdk.openadsdk.mediation.init.d.hc.d.hc hcVar = this.d;
        if (hcVar != null) {
            return hcVar.c();
        }
        return false;
    }

    public boolean hc() {
        com.bytedance.sdk.openadsdk.mediation.init.d.hc.d.hc hcVar = this.d;
        if (hcVar != null) {
            return hcVar.u();
        }
        return true;
    }

    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        if (i == -99999986) {
            return (T) b().sparseArray();
        }
        return null;
    }

    @Override // java.util.function.Supplier
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public SparseArray<Object> get() {
        PluginValueSet pluginValueSetB = b();
        if (pluginValueSetB != null) {
            return pluginValueSetB.sparseArray();
        }
        return null;
    }
}
