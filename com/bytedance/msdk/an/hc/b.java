package com.bytedance.msdk.an.hc;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.ss.mediakit.medialoader.AVMDLDataLoader;
import java.util.function.Function;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class b {
    private final PluginValueSet d;

    public static b d(PluginValueSet pluginValueSet) {
        return new b(pluginValueSet);
    }

    private b(PluginValueSet pluginValueSet) {
        this.d = pluginValueSet;
    }

    public Function<SparseArray<Object>, Object> d() {
        if (hc()) {
            return (Function) this.d.objectValue(AVMDLDataLoader.KeyIsMaxIpNum, Function.class);
        }
        return null;
    }

    private boolean hc() {
        PluginValueSet pluginValueSet = this.d;
        return (pluginValueSet == null || pluginValueSet.isEmpty()) ? false : true;
    }
}
