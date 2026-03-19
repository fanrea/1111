package com.bytedance.msdk.b.d;

import android.app.Activity;
import com.bykv.vk.openvk.api.proto.PluginValueSet;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class an extends c {
    public an(com.bytedance.msdk.b.an.hc.d dVar) {
        super(dVar);
    }

    private com.bytedance.msdk.api.c.d.u.d xq() {
        return (com.bytedance.msdk.api.c.d.u.d) this.h;
    }

    @Override // com.bytedance.msdk.hc.b
    public Integer an() {
        return com.bytedance.msdk.core.d.d.u.d(nr(), this.tt);
    }

    @Override // com.bytedance.msdk.hc.b
    public void d(Activity activity, Object obj, String str) {
        super.d(activity, obj, str);
        if (this.tt != null) {
            this.tt.apply(com.bytedance.sdk.openadsdk.w.c.d().d(8113).d(Void.class).d(20033, activity).hc());
        }
    }

    @Override // com.bytedance.msdk.hc.b
    public String ai() {
        if (this.tt != null) {
            Object objApply = this.tt.apply(com.bytedance.sdk.openadsdk.w.c.d().d(8147).d(String.class).hc());
            if (objApply instanceof String) {
                return objApply.toString();
            }
            return null;
        }
        return super.ai();
    }

    @Override // com.bytedance.msdk.b.d.c
    public <T> T d(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        String strStringValue;
        if (i == 8143) {
            return (T) Double.valueOf(kb());
        }
        if (i == 8111) {
            if (pluginValueSet == null) {
                return null;
            }
            if (!g() && !ox()) {
                return null;
            }
            d(pluginValueSet.doubleValue(8016));
            return null;
        }
        int iIntValue = 0;
        if (i == 8129) {
            if (pluginValueSet == null) {
                return null;
            }
            h(Boolean.valueOf(pluginValueSet.booleanValue(8033, false)).booleanValue());
            return null;
        }
        if (i == 1008) {
            if (xq() == null) {
                return null;
            }
            xq().d();
            return null;
        }
        if (i == 1017) {
            if (xq() == null) {
                return null;
            }
            if (pluginValueSet != null) {
                iIntValue = pluginValueSet.intValue(8014, 0);
                strStringValue = pluginValueSet.stringValue(8015);
            } else {
                strStringValue = "";
            }
            xq().d(new com.bytedance.msdk.api.d(iIntValue, strStringValue));
            return null;
        }
        if (i == 1009) {
            if (xq() == null) {
                return null;
            }
            xq().hc();
            return null;
        }
        if (i == 1014) {
            if (xq() == null) {
                return null;
            }
            xq().b();
            return null;
        }
        if (i == 1015) {
            if (xq() == null) {
                return null;
            }
            xq().c();
            return null;
        }
        if (i != 1016 || xq() == null) {
            return null;
        }
        xq().u();
        return null;
    }
}
