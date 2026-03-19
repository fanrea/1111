package com.bytedance.msdk.b.b.hc.d.d;

import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.msdk.api.c.d.hc.hc.d;
import com.bytedance.msdk.b.d.d.tt;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class h extends hc {
    private volatile com.bytedance.msdk.b.d.d.b tt;

    public h(String str, com.bytedance.msdk.b.d.hc hcVar) {
        super(str, hcVar);
    }

    public void d(double d, Map<String, Object> map) {
        if (!hc()) {
            com.bytedance.msdk.d.u.b.c("TTMediationSDK", "自定义Adapter callLoadSuccess");
            if (this.tt == null) {
                this.tt = new tt(this, this.b);
            }
            d(this.tt, d, map);
            return;
        }
        com.bytedance.msdk.d.u.b.c("TTMediationSDK", "自定义Adapter 加载成功或者失败回调只能调用一次");
    }

    public void b() {
        if (this.tt == null) {
            this.tt = new tt(this, this.b);
        }
        d(this.tt, (com.bytedance.msdk.api.d) null);
    }

    public void c() {
        if (this.tt != null) {
            d(new d.InterfaceC0213d() { // from class: com.bytedance.msdk.b.b.hc.d.d.h.1
                @Override // com.bytedance.msdk.api.c.d.hc.hc.d.InterfaceC0213d
                public void d() {
                    h.this.hc(new d.InterfaceC0213d() { // from class: com.bytedance.msdk.b.b.hc.d.d.h.1.1
                        @Override // com.bytedance.msdk.api.c.d.hc.hc.d.InterfaceC0213d
                        public void d() {
                            com.bytedance.msdk.api.c.d.gb.d dVar = (com.bytedance.msdk.api.c.d.gb.d) h.this.tt.yw();
                            if (dVar != null) {
                                dVar.i_();
                            }
                        }
                    });
                }
            });
        }
    }

    public final void u() {
        if (this.tt != null) {
            d(new d.InterfaceC0213d() { // from class: com.bytedance.msdk.b.b.hc.d.d.h.2
                @Override // com.bytedance.msdk.api.c.d.hc.hc.d.InterfaceC0213d
                public void d() {
                    h.this.b(new d.InterfaceC0213d() { // from class: com.bytedance.msdk.b.b.hc.d.d.h.2.1
                        @Override // com.bytedance.msdk.api.c.d.hc.hc.d.InterfaceC0213d
                        public void d() {
                            com.bytedance.msdk.api.c.d.gb.d dVar = (com.bytedance.msdk.api.c.d.gb.d) h.this.tt.yw();
                            if (dVar != null) {
                                dVar.j_();
                            }
                        }
                    });
                }
            });
        }
    }

    public final void k() {
        if (this.tt != null) {
            d(new d.InterfaceC0213d() { // from class: com.bytedance.msdk.b.b.hc.d.d.h.3
                @Override // com.bytedance.msdk.api.c.d.hc.hc.d.InterfaceC0213d
                public void d() {
                    com.bytedance.msdk.api.c.d.gb.d dVar = (com.bytedance.msdk.api.c.d.gb.d) h.this.tt.yw();
                    if (dVar != null) {
                        dVar.b();
                    }
                }
            });
        }
    }

    public final void e() {
        if (this.tt != null) {
            d(new d.InterfaceC0213d() { // from class: com.bytedance.msdk.b.b.hc.d.d.h.4
                @Override // com.bytedance.msdk.api.c.d.hc.hc.d.InterfaceC0213d
                public void d() {
                    com.bytedance.msdk.api.c.d.gb.d dVar = (com.bytedance.msdk.api.c.d.gb.d) h.this.tt.yw();
                    if (dVar != null) {
                        dVar.c();
                    }
                }
            });
        }
    }

    public final void cb() {
        if (this.tt != null) {
            d(new d.InterfaceC0213d() { // from class: com.bytedance.msdk.b.b.hc.d.d.h.5
                @Override // com.bytedance.msdk.api.c.d.hc.hc.d.InterfaceC0213d
                public void d() {
                    com.bytedance.msdk.api.c.d.gb.d dVar = (com.bytedance.msdk.api.c.d.gb.d) h.this.tt.yw();
                    if (dVar != null) {
                        dVar.u();
                    }
                }
            });
        }
    }

    public final void w() {
        if (this.tt != null) {
            d(new d.InterfaceC0213d() { // from class: com.bytedance.msdk.b.b.hc.d.d.h.6
                @Override // com.bytedance.msdk.api.c.d.hc.hc.d.InterfaceC0213d
                public void d() {
                    com.bytedance.msdk.api.c.d.gb.d dVar = (com.bytedance.msdk.api.c.d.gb.d) h.this.tt.yw();
                    if (dVar != null) {
                        dVar.an();
                    }
                }
            });
        }
    }

    public final void d(final com.bytedance.msdk.api.b.d dVar) {
        if (this.tt != null) {
            d(new d.InterfaceC0213d() { // from class: com.bytedance.msdk.b.b.hc.d.d.h.7
                @Override // com.bytedance.msdk.api.c.d.hc.hc.d.InterfaceC0213d
                public void d() {
                    com.bytedance.msdk.api.c.d.gb.d dVar2 = (com.bytedance.msdk.api.c.d.gb.d) h.this.tt.yw();
                    if (dVar2 != null) {
                        dVar2.d(dVar);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.msdk.b.b.hc.d.d.hc
    public <T> T d(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        Map<String, Object> map;
        if (i == 8123) {
            int iIntValue = pluginValueSet.intValue(8014);
            String strStringValue = pluginValueSet.stringValue(8015);
            com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "Adn custom reward loader : callLoaderFail  code:" + iIntValue + " msg:" + strStringValue);
            d(iIntValue, strStringValue);
        } else if (i == 8107) {
            double dDoubleValue = 0.0d;
            if (pluginValueSet != null) {
                dDoubleValue = pluginValueSet.doubleValue(8409);
                map = (Map) pluginValueSet.objectValue(8075, Map.class);
            } else {
                map = null;
            }
            com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "Adn custom reward loader : callLoadSucceed price:" + dDoubleValue + " mextraMsg:" + map);
            d(dDoubleValue, map);
        } else if (i == 8112) {
            com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "Adn custom reward loader : callAdVideoCache");
            b();
        } else if (i == 1008) {
            com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "Adn custom reward loader : callRewardedAdShow");
            c();
        } else if (i == 1009) {
            com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "Adn custom reward loader : callRewardClick");
            u();
        } else if (i == 1014) {
            com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "Adn custom reward loader : callRewardedAdClosed");
            k();
        } else if (i == 1026) {
            com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "Adn custom reward loader : callRewardVideoComplete");
            e();
        } else if (i == 1021) {
            com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "Adn custom reward loader : callRewardVideoError");
            cb();
        } else if (i == 1037) {
            com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "Adn custom reward loader : callRewardSkippedVideo");
            w();
        } else if (i == 1018 && pluginValueSet != null) {
            final boolean zBooleanValue = pluginValueSet.booleanValue(8017);
            final float fFloatValue = pluginValueSet.floatValue(8018);
            final String strStringValue2 = pluginValueSet.stringValue(8019);
            final Map map2 = (Map) pluginValueSet.objectValue(8075, Map.class);
            com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "Adn custom reward loader : callRewardVerify rewardVerify:" + zBooleanValue + " amount:" + fFloatValue + " name:" + strStringValue2 + " map:" + map2);
            d(new com.bytedance.msdk.api.b.d() { // from class: com.bytedance.msdk.b.b.hc.d.d.h.8
                @Override // com.bytedance.msdk.api.b.d
                public boolean d() {
                    return zBooleanValue;
                }

                @Override // com.bytedance.msdk.api.b.d
                public float hc() {
                    return fFloatValue;
                }

                @Override // com.bytedance.msdk.api.b.d
                public String b() {
                    return strStringValue2;
                }

                @Override // com.bytedance.msdk.api.b.d
                public Map<String, Object> c() {
                    return map2;
                }
            });
        }
        return null;
    }
}
