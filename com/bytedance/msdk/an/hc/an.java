package com.bytedance.msdk.an.hc;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.function.Supplier;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class an extends com.bytedance.sdk.openadsdk.core.ba.c implements Supplier<SparseArray<Object>> {
    private com.bytedance.sdk.openadsdk.w.b.b.b d;

    public an(com.bytedance.sdk.openadsdk.w.b.b.b bVar) {
        this.d = bVar;
    }

    public PluginValueSet d() {
        com.bykv.d.d.d.d.d dVarD = com.bykv.d.d.d.d.d.d();
        com.bytedance.sdk.openadsdk.w.b.b.b bVar = this.d;
        dVarD.d(8481, bVar != null ? bVar.d() : 0.0d);
        com.bytedance.sdk.openadsdk.w.b.b.b bVar2 = this.d;
        dVarD.d(8482, bVar2 != null ? bVar2.hc() : 0.0d);
        return dVarD.hc();
    }

    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        if (i == -99999986) {
            return (T) d().sparseArray();
        }
        return null;
    }

    @Override // java.util.function.Supplier
    /* renamed from: hc, reason: merged with bridge method [inline-methods] */
    public SparseArray<Object> get() {
        PluginValueSet pluginValueSetD = d();
        if (pluginValueSetD != null) {
            return pluginValueSetD.sparseArray();
        }
        return null;
    }
}
