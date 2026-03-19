package com.bytedance.msdk.b.b.hc.d.d;

import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.msdk.api.c.d.hc.hc.d;
import com.bytedance.msdk.b.d.d.tc;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class gb extends hc {
    private com.bytedance.msdk.b.d.d.b tt;

    public gb(String str, com.bytedance.msdk.b.d.hc hcVar) {
        super(str, hcVar);
    }

    public void d(double d, Map<String, Object> map) {
        if (!hc()) {
            com.bytedance.msdk.d.u.b.c("TTMediationSDK", "自定义Adapter callLoadSuccess");
            tc tcVar = new tc(this, this.b);
            this.tt = tcVar;
            d(tcVar, d, map);
            return;
        }
        com.bytedance.msdk.d.u.b.c("TTMediationSDK", "自定义Adapter 加载成功或者失败回调只能调用一次");
    }

    public void b() {
        if (this.tt != null) {
            d(new d.InterfaceC0213d() { // from class: com.bytedance.msdk.b.b.hc.d.d.gb.1
                @Override // com.bytedance.msdk.api.c.d.hc.hc.d.InterfaceC0213d
                public void d() {
                    gb.this.b(new d.InterfaceC0213d() { // from class: com.bytedance.msdk.b.b.hc.d.d.gb.1.1
                        @Override // com.bytedance.msdk.api.c.d.hc.hc.d.InterfaceC0213d
                        public void d() {
                            com.bytedance.msdk.api.c.d.tt.hc hcVar = (com.bytedance.msdk.api.c.d.tt.hc) gb.this.tt.yw();
                            if (hcVar != null) {
                                hcVar.c();
                            }
                        }
                    });
                }
            });
        }
    }

    public void c() {
        if (this.tt != null) {
            d(new d.InterfaceC0213d() { // from class: com.bytedance.msdk.b.b.hc.d.d.gb.2
                @Override // com.bytedance.msdk.api.c.d.hc.hc.d.InterfaceC0213d
                public void d() {
                    gb.this.hc(new d.InterfaceC0213d() { // from class: com.bytedance.msdk.b.b.hc.d.d.gb.2.1
                        @Override // com.bytedance.msdk.api.c.d.hc.hc.d.InterfaceC0213d
                        public void d() {
                            com.bytedance.msdk.api.c.d.tt.hc hcVar = (com.bytedance.msdk.api.c.d.tt.hc) gb.this.tt.yw();
                            if (hcVar != null) {
                                hcVar.u();
                            }
                        }
                    });
                }
            });
        }
    }

    public void u() {
        if (this.tt != null) {
            d(new d.InterfaceC0213d() { // from class: com.bytedance.msdk.b.b.hc.d.d.gb.3
                @Override // com.bytedance.msdk.api.c.d.hc.hc.d.InterfaceC0213d
                public void d() {
                    com.bytedance.msdk.api.c.d.tt.hc hcVar = (com.bytedance.msdk.api.c.d.tt.hc) gb.this.tt.yw();
                    if (hcVar != null) {
                        hcVar.d(1);
                    }
                }
            });
        }
    }

    public void k() {
        if (this.tt != null) {
            d(new d.InterfaceC0213d() { // from class: com.bytedance.msdk.b.b.hc.d.d.gb.4
                @Override // com.bytedance.msdk.api.c.d.hc.hc.d.InterfaceC0213d
                public void d() {
                    com.bytedance.msdk.api.c.d.tt.hc hcVar = (com.bytedance.msdk.api.c.d.tt.hc) gb.this.tt.yw();
                    if (hcVar != null) {
                        hcVar.hc(2);
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
            com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "Adn custom splash loader : callLoaderFail  code:" + iIntValue + " msg:" + strStringValue);
            d(iIntValue, strStringValue);
        } else if (i == 8107) {
            double dDoubleValue = 0.0d;
            if (pluginValueSet != null) {
                dDoubleValue = pluginValueSet.doubleValue(8409);
                map = (Map) pluginValueSet.objectValue(8075, Map.class);
            } else {
                map = null;
            }
            com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "Adn custom splash loader : callLoadSucceed price:" + dDoubleValue + " mextraMsg:" + map);
            d(dDoubleValue, map);
        } else if (i == 1009) {
            com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "Adn custom splash loader : callSplashAdClicked");
            b();
        } else if (i == 1008) {
            com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "Adn custom splash loader : callSplashAdShow");
            c();
        } else if (i == 1019) {
            com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "Adn custom splash loader : callSplashAdSkip");
            u();
        } else if (i == 1011) {
            com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "Adn custom splash loader : callSplashAdDismiss");
            k();
        }
        return null;
    }
}
