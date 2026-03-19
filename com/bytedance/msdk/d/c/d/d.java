package com.bytedance.msdk.d.c.d;

import android.content.Context;
import android.util.SparseArray;
import com.baidu.mobads.sdk.internal.cm;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.msdk.an.hc.b;
import com.bytedance.msdk.an.hc.u;
import com.bytedance.msdk.api.c.d.hc.b.hc;
import com.bytedance.sdk.openadsdk.w.c;
import java.util.Map;
import java.util.function.Function;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d extends com.bytedance.msdk.api.c.d.hc.an.d {
    private final Function<SparseArray<Object>, Object> b = b.d(com.bytedance.msdk.core.d.mk().y()).d();
    private Function<SparseArray<Object>, Object> c;

    @Override // com.bytedance.msdk.api.c.d.hc.an.d
    public String hc() {
        return cm.d;
    }

    @Override // com.bytedance.msdk.api.c.d.hc.an.d
    public void d(Context context, hc hcVar, Map<String, Object> map) {
        if (hcVar != null) {
            c cVarD = c.d().d(8100).d(Void.class).d(8089, com.bytedance.msdk.core.d.mk().y().sparseArray()).d(8545, com.bytedance.sdk.openadsdk.w.b.c.d(hcVar.d())).d(8400, map).d(8401, this).d(8098, Boolean.TRUE);
            u.d(cVarD);
            this.b.apply(cVarD.hc());
        }
    }

    @Override // com.bytedance.msdk.api.c.d.hc.an.d
    public String d(Context context, Map<String, Object> map) {
        if (this.c != null) {
            Object objApply = this.c.apply(c.d().d(8139).d(String.class).d(8009, context).d(8075, map).hc());
            return objApply instanceof String ? (String) objApply : "";
        }
        return super.d(context, map);
    }

    @Override // com.bytedance.msdk.api.c.d.hc.an.d
    public String hc(Context context, Map<String, Object> map) {
        if (this.c != null) {
            Object objApply = this.c.apply(c.d().d(8217).d(String.class).d(8009, context).d(8075, map).hc());
            return objApply instanceof String ? (String) objApply : "";
        }
        return super.hc(context, map);
    }

    @Override // com.bytedance.msdk.api.c.d.hc.an.d
    public String d() {
        if (this.c == null) {
            return null;
        }
        Object objApply = this.c.apply(c.d().d(8218).d(String.class).hc());
        return objApply instanceof String ? (String) objApply : "";
    }

    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        if (i == 8216) {
            this.c = (Function) pluginValueSet.objectValue(8402, Function.class);
        } else if (i == 8219) {
            b();
        } else {
            if (i == 8220) {
                return (T) Boolean.valueOf(c());
            }
            if (i == 8270) {
                long jLongValue = pluginValueSet.longValue(8073);
                this.hc = pluginValueSet.intValue(8557);
                this.d = jLongValue;
            }
        }
        return (T) com.bytedance.msdk.core.cb.d.d(cls);
    }
}
