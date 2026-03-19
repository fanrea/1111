package com.bytedance.msdk.b.d;

import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.Map;
import java.util.function.Function;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class c extends com.bytedance.msdk.hc.b {
    protected com.bytedance.msdk.b.an.hc.d tc;
    protected Function<SparseArray<Object>, Object> tt;

    public abstract <T> T d(int i, PluginValueSet pluginValueSet, Class<T> cls);

    public c(com.bytedance.msdk.b.an.hc.d dVar) {
        this.tc = dVar;
    }

    public boolean g() {
        com.bytedance.msdk.b.an.hc.d dVar = this.tc;
        if (dVar != null) {
            return dVar.d();
        }
        return false;
    }

    @Override // com.bytedance.msdk.hc.b
    public void w() {
        super.w();
        if (this.tt != null) {
            this.tt.apply(com.bytedance.sdk.openadsdk.w.c.d().d(8148).d(Void.class).hc());
        }
    }

    @Override // com.bytedance.msdk.hc.b
    public void cb() {
        super.cb();
        if (this.tt != null) {
            this.tt.apply(com.bytedance.sdk.openadsdk.w.c.d().d(8149).d(Void.class).hc());
        }
    }

    @Override // com.bytedance.msdk.hc.b
    public void yo() {
        super.yo();
        if (this.tt != null) {
            this.tt.apply(com.bytedance.sdk.openadsdk.w.c.d().d(8109).d(Void.class).hc());
        }
    }

    @Override // com.bytedance.msdk.hc.b
    public boolean u() {
        if (this.tt == null) {
            return false;
        }
        this.tt.apply(com.bytedance.sdk.openadsdk.w.c.d().d(8120).d(Boolean.class).hc());
        return false;
    }

    @Override // com.bytedance.msdk.hc.b
    public void hc(Map<String, Object> map) {
        if (tj() && this.tt != null) {
            this.tt.apply(com.bytedance.sdk.openadsdk.w.c.d().d(8142).d(Void.class).d(8006, map).hc());
        }
    }

    @Override // com.bytedance.msdk.hc.b
    public void d(Map<String, Object> map) {
        if (tj()) {
            Object obj = map.get("bidding_lose_reason_NUM");
            int iIntValue = obj instanceof Integer ? ((Integer) obj).intValue() : 0;
            if (iIntValue <= 0) {
                iIntValue = 10001;
            }
            map.put("bidding_lose_reason_dex_adapter", Integer.valueOf(com.bytedance.msdk.core.d.d.u.d(nr(), iIntValue)));
            if (this.tt != null) {
                this.tt.apply(com.bytedance.sdk.openadsdk.w.c.d().d(8144).d(Void.class).d(8006, map).hc());
            }
        }
    }

    @Override // com.bytedance.msdk.hc.b
    public Map<String, Object> j() {
        if (this.tt != null) {
            Object objApply = this.tt.apply(com.bytedance.sdk.openadsdk.w.c.d().d(8239).d(Map.class).hc());
            b(objApply instanceof Map ? (Map) objApply : null);
        }
        return super.j();
    }

    @Override // com.bytedance.msdk.hc.b
    public long xi() {
        if (this.tt != null) {
            Object objApply = this.tt.apply(com.bytedance.sdk.openadsdk.w.c.d().d(8245).d(Long.class).hc());
            if (objApply instanceof Long) {
                return ((Long) objApply).longValue();
            }
            return 0L;
        }
        return super.xi();
    }

    @Override // com.bytedance.msdk.hc.b
    public long yb() {
        if (this.tt != null) {
            Object objApply = this.tt.apply(com.bytedance.sdk.openadsdk.w.c.d().d(8246).d(Long.class).hc());
            if (objApply instanceof Long) {
                return ((Long) objApply).longValue();
            }
            return 0L;
        }
        return super.yb();
    }

    @Override // com.bytedance.msdk.hc.b
    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        if (i == 8128) {
            this.tt = (Function) pluginValueSet.objectValue(8035, Function.class);
        } else if (i == 8208) {
            String strStringValue = pluginValueSet.stringValue(8058);
            if (!TextUtils.isEmpty(strStringValue)) {
                k(strStringValue);
            }
        } else if (i == 8209) {
            mk(pluginValueSet.intValue(8060));
        } else if (i == 8140) {
            mq(pluginValueSet.intValue(8059));
        }
        return (T) d(i, pluginValueSet, cls);
    }
}
