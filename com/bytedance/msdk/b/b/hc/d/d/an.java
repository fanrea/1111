package com.bytedance.msdk.b.b.hc.d.d;

import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.msdk.api.c.d.hc.hc.d;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class an extends hc {
    private com.bytedance.msdk.b.d.d.b tt;

    public an(String str, com.bytedance.msdk.b.d.hc hcVar) {
        super(str, hcVar);
    }

    public void d(double d, Map<String, Object> map) {
        if (!hc()) {
            com.bytedance.msdk.d.u.b.c("TTMediationSDK", "自定义Adapter callLoadSuccess");
            com.bytedance.msdk.b.d.d.h hVar = new com.bytedance.msdk.b.d.d.h(this, this.b);
            this.tt = hVar;
            d(hVar, d, map);
            return;
        }
        com.bytedance.msdk.d.u.b.c("TTMediationSDK", "自定义Adapter 加载成功或者失败回调只能调用一次");
    }

    public void b() {
        if (this.tt != null) {
            d(new d.InterfaceC0213d() { // from class: com.bytedance.msdk.b.b.hc.d.d.an.1
                @Override // com.bytedance.msdk.api.c.d.hc.hc.d.InterfaceC0213d
                public void d() {
                    an.this.hc(new d.InterfaceC0213d() { // from class: com.bytedance.msdk.b.b.hc.d.d.an.1.1
                        @Override // com.bytedance.msdk.api.c.d.hc.hc.d.InterfaceC0213d
                        public void d() {
                            com.bytedance.msdk.api.c.d.u.d dVar = (com.bytedance.msdk.api.c.d.u.d) an.this.tt.yw();
                            if (dVar != null) {
                                dVar.d();
                            }
                        }
                    });
                }
            });
        }
    }

    public void c() {
        if (this.tt != null) {
            d(new d.InterfaceC0213d() { // from class: com.bytedance.msdk.b.b.hc.d.d.an.2
                @Override // com.bytedance.msdk.api.c.d.hc.hc.d.InterfaceC0213d
                public void d() {
                    an.this.b(new d.InterfaceC0213d() { // from class: com.bytedance.msdk.b.b.hc.d.d.an.2.1
                        @Override // com.bytedance.msdk.api.c.d.hc.hc.d.InterfaceC0213d
                        public void d() {
                            com.bytedance.msdk.api.c.d.u.d dVar = (com.bytedance.msdk.api.c.d.u.d) an.this.tt.yw();
                            if (dVar != null) {
                                dVar.hc();
                            }
                        }
                    });
                }
            });
        }
    }

    public void u() {
        if (this.tt != null) {
            d(new d.InterfaceC0213d() { // from class: com.bytedance.msdk.b.b.hc.d.d.an.3
                @Override // com.bytedance.msdk.api.c.d.hc.hc.d.InterfaceC0213d
                public void d() {
                    com.bytedance.msdk.api.c.d.u.d dVar = (com.bytedance.msdk.api.c.d.u.d) an.this.tt.yw();
                    if (dVar != null) {
                        dVar.b();
                    }
                }
            });
        }
    }

    public void k() {
        if (this.tt != null) {
            d(new d.InterfaceC0213d() { // from class: com.bytedance.msdk.b.b.hc.d.d.an.4
                @Override // com.bytedance.msdk.api.c.d.hc.hc.d.InterfaceC0213d
                public void d() {
                    com.bytedance.msdk.api.c.d.u.d dVar = (com.bytedance.msdk.api.c.d.u.d) an.this.tt.yw();
                    if (dVar != null) {
                        dVar.c();
                    }
                }
            });
        }
    }

    public void e() {
        if (this.tt != null) {
            d(new d.InterfaceC0213d() { // from class: com.bytedance.msdk.b.b.hc.d.d.an.5
                @Override // com.bytedance.msdk.api.c.d.hc.hc.d.InterfaceC0213d
                public void d() {
                    com.bytedance.msdk.api.c.d.u.d dVar = (com.bytedance.msdk.api.c.d.u.d) an.this.tt.yw();
                    if (dVar != null) {
                        dVar.u();
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
            com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "Adn custom interstitial loader : callLoaderFail  code:" + iIntValue + " msg:" + strStringValue);
            d(iIntValue, strStringValue);
        } else if (i == 8107) {
            double dDoubleValue = 0.0d;
            if (pluginValueSet != null) {
                dDoubleValue = pluginValueSet.doubleValue(8409);
                map = (Map) pluginValueSet.objectValue(8075, Map.class);
            } else {
                map = null;
            }
            com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "Adn custom interstitial loader : callLoadSucceed price:" + dDoubleValue + " mextraMsg:" + map);
            d(dDoubleValue, map);
        } else if (i == 1008) {
            com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "Adn custom interstitial loader : callInterstitialShow");
            b();
        } else if (i == 1009) {
            com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "Adn custom interstitial loader : callInterstitialAdClick");
            c();
        } else if (i == 1014) {
            com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "Adn custom interstitial loader : callInterstitialClosed");
            u();
        } else if (i == 1015) {
            com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "Adn custom interstitial loader : callInterstitialAdOpened");
            k();
        } else if (i == 1016) {
            com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "Adn custom interstitial loader : callInterstitialAdLeftApplication");
            e();
        }
        return null;
    }
}
