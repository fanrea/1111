package com.bytedance.msdk.b.d;

import android.app.Activity;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class u extends c {
    public u(com.bytedance.msdk.b.an.hc.d dVar) {
        super(dVar);
    }

    private com.bytedance.msdk.api.c.d.c.d xq() {
        return (com.bytedance.msdk.api.c.d.c.d) this.h;
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
                return (String) objApply;
            }
            return null;
        }
        return super.ai();
    }

    @Override // com.bytedance.msdk.hc.b
    public boolean cw() {
        if (this.tt != null) {
            Object objApply = this.tt.apply(com.bytedance.sdk.openadsdk.w.c.d().d(8211).d(Boolean.class).hc());
            if (objApply instanceof Boolean) {
                return ((Boolean) objApply).booleanValue();
            }
            return super.cw();
        }
        return super.cw();
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
            xq().g_();
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
            xq().h_();
            return null;
        }
        if (i == 1014) {
            if (xq() == null) {
                return null;
            }
            xq().b();
            return null;
        }
        if (i == 1026) {
            if (xq() == null) {
                return null;
            }
            xq().c();
            return null;
        }
        if (i == 1021) {
            if (xq() == null) {
                return null;
            }
            xq().u();
            return null;
        }
        if (i == 1037) {
            if (xq() == null) {
                return null;
            }
            xq().an();
            return null;
        }
        if (i != 1018 || xq() == null) {
            return null;
        }
        final boolean zBooleanValue = pluginValueSet.booleanValue(8017);
        final float fIntValue = pluginValueSet.intValue(8018);
        final String strStringValue2 = pluginValueSet.stringValue(8019);
        xq().d(new com.bytedance.msdk.api.b.d() { // from class: com.bytedance.msdk.b.d.u.1
            @Override // com.bytedance.msdk.api.b.d
            public Map<String, Object> c() {
                return null;
            }

            @Override // com.bytedance.msdk.api.b.d
            public boolean d() {
                return zBooleanValue;
            }

            @Override // com.bytedance.msdk.api.b.d
            public float hc() {
                return fIntValue;
            }

            @Override // com.bytedance.msdk.api.b.d
            public String b() {
                return strStringValue2;
            }
        });
        return null;
    }
}
