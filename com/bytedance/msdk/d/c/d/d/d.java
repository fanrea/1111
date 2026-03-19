package com.bytedance.msdk.d.c.d.d;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.w.b;
import java.util.Map;
import java.util.function.Function;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d extends com.bytedance.msdk.api.c.d.h.d {
    public d(Function<SparseArray<Object>, Object> function) {
        PluginValueSet pluginValueSetHc;
        if (function == null || (pluginValueSetHc = b.hc(function)) == null) {
            return;
        }
        c(pluginValueSetHc.stringValue(8505));
        u(pluginValueSetHc.stringValue(8506));
        d(pluginValueSetHc.longValue(8507));
        an(pluginValueSetHc.stringValue(8508));
        d((Map<String, String>) pluginValueSetHc.objectValue(8509, Map.class));
        h(pluginValueSetHc.stringValue(8510));
        gb(pluginValueSetHc.stringValue(8511));
        hc((Map<String, Object>) pluginValueSetHc.objectValue(8512, Map.class));
        b(pluginValueSetHc.stringValue(8551));
    }
}
