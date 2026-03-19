package com.bytedance.msdk.b.d;

import android.app.Activity;
import android.view.ViewGroup;
import com.bykv.vk.openvk.api.proto.PluginValueSet;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class tt extends c {
    private com.bytedance.msdk.d.hc.an mk;

    public tt(com.bytedance.msdk.b.an.hc.d dVar) {
        super(dVar);
    }

    private com.bytedance.msdk.d.hc.u xq() {
        return (com.bytedance.msdk.d.hc.u) this.h;
    }

    @Override // com.bytedance.msdk.hc.b
    public Integer an() {
        return com.bytedance.msdk.core.d.d.u.d(nr(), this.tt);
    }

    @Override // com.bytedance.msdk.hc.b
    public void d(ViewGroup viewGroup) {
        super.d(viewGroup);
        if (this.tt != null) {
            this.tt.apply(com.bytedance.sdk.openadsdk.w.c.d().d(6152).d(Void.class).d(20060, viewGroup).hc());
        }
    }

    @Override // com.bytedance.msdk.hc.b
    public void d(ViewGroup viewGroup, Activity activity) {
        super.d(viewGroup, activity);
        if (this.tt != null) {
            this.tt.apply(com.bytedance.sdk.openadsdk.w.c.d().d(6154).d(Void.class).d(20060, viewGroup).d(20033, activity).hc());
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

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.msdk.b.d.c
    public <T> T d(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        String strStringValue;
        if (i == 8143) {
            return (T) Double.valueOf(kb());
        }
        int iIntValue = 0;
        if (i == 1009) {
            if (pluginValueSet != null ? pluginValueSet.booleanValue(20040, false) : false) {
                com.bytedance.msdk.d.hc.an anVar = this.mk;
                if (!(anVar instanceof com.bytedance.msdk.api.c.d.tt.hc)) {
                    return null;
                }
                ((com.bytedance.msdk.api.c.d.tt.hc) anVar).c();
                return null;
            }
            if (xq() == null) {
                return null;
            }
            xq().c();
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
        if (i == 1011) {
            boolean zBooleanValue = pluginValueSet != null ? pluginValueSet.booleanValue(20040, false) : false;
            if (pluginValueSet != null) {
                pluginValueSet.intValue(8552);
            }
            if (zBooleanValue) {
                com.bytedance.msdk.d.hc.an anVar2 = this.mk;
                if (!(anVar2 instanceof com.bytedance.msdk.api.c.d.tt.hc)) {
                    return null;
                }
                ((com.bytedance.msdk.api.c.d.tt.hc) anVar2).hc(2);
                return null;
            }
            if (xq() == null) {
                return null;
            }
            xq().hc(2);
            return null;
        }
        if (i == 1008) {
            if (pluginValueSet != null ? pluginValueSet.booleanValue(20040, false) : false) {
                com.bytedance.msdk.d.hc.an anVar3 = this.mk;
                if (!(anVar3 instanceof com.bytedance.msdk.api.c.d.tt.hc)) {
                    return null;
                }
                ((com.bytedance.msdk.api.c.d.tt.hc) anVar3).u();
                return null;
            }
            if (xq() == null) {
                return null;
            }
            xq().u();
            return null;
        }
        if (i == 1019) {
            boolean zBooleanValue2 = pluginValueSet != null ? pluginValueSet.booleanValue(20040, false) : false;
            if (pluginValueSet != null) {
                pluginValueSet.intValue(8552);
            }
            if (zBooleanValue2) {
                com.bytedance.msdk.d.hc.an anVar4 = this.mk;
                if (!(anVar4 instanceof com.bytedance.msdk.api.c.d.tt.hc)) {
                    return null;
                }
                ((com.bytedance.msdk.api.c.d.tt.hc) anVar4).d(1);
                return null;
            }
            if (xq() == null) {
                return null;
            }
            xq().d(1);
            return null;
        }
        if (i == 1074) {
            if (xq() != null) {
                return (T) xq().getActivity();
            }
            return null;
        }
        if (i == 1051) {
            xq();
            return null;
        }
        if (i == 1052) {
            xq();
            return null;
        }
        if (i == 6156) {
            if (xq() == null) {
                return null;
            }
            xq().b();
            return null;
        }
        if (i != 8111) {
            return null;
        }
        d(pluginValueSet.doubleValue(8016));
        return null;
    }
}
