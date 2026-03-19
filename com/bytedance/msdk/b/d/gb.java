package com.bytedance.msdk.b.d;

import android.app.Activity;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class gb extends c {
    public gb(com.bytedance.msdk.b.an.hc.d dVar) {
        super(dVar);
    }

    private com.bytedance.msdk.api.c.d.gb.d xq() {
        return (com.bytedance.msdk.api.c.d.gb.d) this.h;
    }

    private com.bytedance.msdk.api.c.d.gb.d yl() {
        return (com.bytedance.msdk.api.c.d.gb.d) this.gb;
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
        if (i == 8115) {
            if (this.h instanceof com.bytedance.msdk.api.c.d.gb.d) {
                xq().j_();
            }
        } else if (i == 8116) {
            if (this.h instanceof com.bytedance.msdk.api.c.d.gb.d) {
                xq().b();
            }
        } else if (i == 8117) {
            if (this.h instanceof com.bytedance.msdk.api.c.d.gb.d) {
                xq().u();
            }
        } else if (i == 8118) {
            if (this.h instanceof com.bytedance.msdk.api.c.d.gb.d) {
                xq().c();
            }
        } else if (i == 8119) {
            if (this.h instanceof com.bytedance.msdk.api.c.d.gb.d) {
                xq().an();
            }
        } else if (i == 8230) {
            if (this.h instanceof com.bytedance.msdk.api.c.d.gb.d) {
                xq().i_();
            }
        } else if (i == 8231) {
            if (this.h instanceof com.bytedance.msdk.api.c.d.gb.d) {
                final boolean zBooleanValue = pluginValueSet.booleanValue(8017);
                final float fIntValue = pluginValueSet.intValue(8018);
                final String strStringValue2 = pluginValueSet.stringValue(8019);
                Map map = (Map) pluginValueSet.objectValue(8020, Map.class);
                final HashMap map2 = new HashMap();
                if (map != null) {
                    map2.putAll(map);
                }
                com.bytedance.msdk.api.b.d dVar = new com.bytedance.msdk.api.b.d() { // from class: com.bytedance.msdk.b.d.gb.1
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

                    @Override // com.bytedance.msdk.api.b.d
                    public Map<String, Object> c() {
                        return map2;
                    }
                };
                com.bytedance.sdk.gromore.d.d.u.c.d(dVar, "GMRewardAd reward verify");
                xq().d(dVar);
            }
        } else if (i == 1017) {
            if (this.h instanceof com.bytedance.msdk.api.c.d.gb.d) {
                int iIntValue = 0;
                if (pluginValueSet != null) {
                    iIntValue = pluginValueSet.intValue(8014, 0);
                    strStringValue = pluginValueSet.stringValue(8015);
                } else {
                    strStringValue = "";
                }
                xq().d(new com.bytedance.msdk.api.d(iIntValue, strStringValue));
            }
        } else if (i == 8232) {
            if (this.gb instanceof com.bytedance.msdk.api.c.d.gb.d) {
                yl().j_();
            }
        } else if (i == 8233) {
            if (this.gb instanceof com.bytedance.msdk.api.c.d.gb.d) {
                yl().b();
            }
        } else if (i == 8234) {
            if (this.gb instanceof com.bytedance.msdk.api.c.d.gb.d) {
                yl().u();
            }
        } else if (i == 8235) {
            if (this.gb instanceof com.bytedance.msdk.api.c.d.gb.d) {
                yl().c();
            }
        } else if (i == 8236) {
            if (this.gb instanceof com.bytedance.msdk.api.c.d.gb.d) {
                yl().an();
            }
        } else if (i == 8237) {
            if (this.gb instanceof com.bytedance.msdk.api.c.d.gb.d) {
                yl().i_();
            }
        } else if (i == 8238) {
            if (this.gb instanceof com.bytedance.msdk.api.c.d.gb.d) {
                final boolean zBooleanValue2 = pluginValueSet.booleanValue(8017);
                final float fIntValue2 = pluginValueSet.intValue(8018);
                final String strStringValue3 = pluginValueSet.stringValue(8019);
                Map map3 = (Map) pluginValueSet.objectValue(8020, Map.class);
                final HashMap map4 = new HashMap();
                if (map3 != null) {
                    map4.putAll(map3);
                }
                com.bytedance.msdk.api.b.d dVar2 = new com.bytedance.msdk.api.b.d() { // from class: com.bytedance.msdk.b.d.gb.2
                    @Override // com.bytedance.msdk.api.b.d
                    public boolean d() {
                        return zBooleanValue2;
                    }

                    @Override // com.bytedance.msdk.api.b.d
                    public float hc() {
                        return fIntValue2;
                    }

                    @Override // com.bytedance.msdk.api.b.d
                    public String b() {
                        return strStringValue3;
                    }

                    @Override // com.bytedance.msdk.api.b.d
                    public Map<String, Object> c() {
                        return map4;
                    }
                };
                com.bytedance.sdk.gromore.d.d.u.c.d(dVar2, "GMRewardAd play again reward verify");
                yl().d(dVar2);
            }
        } else if (i == 8111) {
            d(pluginValueSet.doubleValue(8016));
        }
        return (T) com.bytedance.msdk.core.cb.d.d(cls);
    }
}
