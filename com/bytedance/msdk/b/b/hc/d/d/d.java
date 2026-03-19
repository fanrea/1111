package com.bytedance.msdk.b.b.hc.d.d;

import android.view.View;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.msdk.api.c.d.hc.hc.d;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d extends hc {
    private com.bytedance.msdk.b.d.d.b tt;

    public d(String str, com.bytedance.msdk.b.d.hc hcVar) {
        super(str, hcVar);
    }

    public void d(double d, Map<String, Object> map) {
        if (!hc()) {
            com.bytedance.msdk.d.u.b.c("TTMediationSDK", "自定义Adapter callLoadSuccess");
            com.bytedance.msdk.b.d.d.hc hcVar = new com.bytedance.msdk.b.d.d.hc(this, this.b);
            this.tt = hcVar;
            hcVar.b(this.u);
            this.tt.k(this.c.he());
            if (d > 0.0d && tt() == 1) {
                this.tt.d(d);
            }
            if (map != null) {
                this.u.putAll(map);
            }
            this.tt.c(this.u);
            d(this.tt);
            return;
        }
        com.bytedance.msdk.d.u.b.c("TTMediationSDK", "自定义Adapter 加载成功或者失败回调只能调用一次");
    }

    public void b() {
        if (this.tt != null) {
            d(new d.InterfaceC0213d() { // from class: com.bytedance.msdk.b.b.hc.d.d.d.1
                @Override // com.bytedance.msdk.api.c.d.hc.hc.d.InterfaceC0213d
                public void d() {
                    com.bytedance.msdk.api.c.d.d.d dVar = (com.bytedance.msdk.api.c.d.d.d) d.this.tt.yw();
                    if (dVar != null) {
                        dVar.hc(null);
                    }
                }
            });
        }
    }

    public void c() {
        if (this.tt != null) {
            d(new d.InterfaceC0213d() { // from class: com.bytedance.msdk.b.b.hc.d.d.d.2
                @Override // com.bytedance.msdk.api.c.d.hc.hc.d.InterfaceC0213d
                public void d() {
                    d.this.b(new d.InterfaceC0213d() { // from class: com.bytedance.msdk.b.b.hc.d.d.d.2.1
                        @Override // com.bytedance.msdk.api.c.d.hc.hc.d.InterfaceC0213d
                        public void d() {
                            com.bytedance.msdk.api.c.d.d.d dVar = (com.bytedance.msdk.api.c.d.d.d) d.this.tt.yw();
                            if (dVar != null) {
                                dVar.d((View) null);
                            }
                        }
                    });
                }
            });
        }
    }

    public void u() {
        if (this.tt != null) {
            d(new d.InterfaceC0213d() { // from class: com.bytedance.msdk.b.b.hc.d.d.d.3
                @Override // com.bytedance.msdk.api.c.d.hc.hc.d.InterfaceC0213d
                public void d() {
                    com.bytedance.msdk.api.c.d.d.d dVar = (com.bytedance.msdk.api.c.d.d.d) d.this.tt.yw();
                    if (dVar != null) {
                        dVar.f_();
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
            com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "Adn custom banner loader : callLoaderFail  code:" + iIntValue + " msg:" + strStringValue);
            d(iIntValue, strStringValue);
        } else if (i == 8107) {
            double dDoubleValue = 0.0d;
            if (pluginValueSet != null) {
                dDoubleValue = pluginValueSet.doubleValue(8409);
                map = (Map) pluginValueSet.objectValue(8075, Map.class);
            } else {
                map = null;
            }
            com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "Adn custom banner loader : callLoadSucceed price:" + dDoubleValue + " mextraMsg:" + map);
            d(dDoubleValue, map);
        } else if (i == 1008) {
            com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "Adn custom banner loader : callBannerAdShow");
            b();
        } else if (i == 1009) {
            com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "Adn custom banner loader : callBannerAdClick");
            c();
        } else if (i == 1014) {
            com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "Adn custom banner loader : callBannerAdClosed");
            u();
        }
        return null;
    }
}
