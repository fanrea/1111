package com.bytedance.msdk.b.b.hc.d.hc;

import android.app.Activity;
import android.content.Context;
import com.bytedance.sdk.openadsdk.core.z;
import com.bytedance.sdk.openadsdk.w.b.b.hc;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class an extends hc {
    public an(com.bytedance.msdk.b.d.hc hcVar) {
        super(hcVar);
    }

    @Override // com.bytedance.msdk.b.b.hc.d.hc
    public void hc(Context context, com.bytedance.msdk.b.an.hc.hc hcVar, com.bytedance.msdk.api.d.hc hcVar2, Map<String, Object> map) {
        if (hcVar2 == null) {
            d(new com.bytedance.msdk.api.d("load ad fail adSlot is null"));
        } else {
            new d().d(context.getApplicationContext(), hcVar2, hcVar, this);
        }
    }

    class d extends com.bytedance.msdk.hc.b {
        private com.bytedance.msdk.api.d.hc cb;
        private com.bytedance.msdk.b.b.hc.d.hc e;
        private com.bytedance.msdk.b.an.hc.hc k;
        private com.bytedance.sdk.openadsdk.w.b.hc.mk mk;
        private boolean mq;
        com.bytedance.sdk.openadsdk.sy.d.hc.d.c tt = new com.bytedance.sdk.openadsdk.sy.d.hc.d.c(null) { // from class: com.bytedance.msdk.b.b.hc.d.hc.an.d.1
            public void d(int i, String str) {
                d.this.mq = false;
                d.this.e.d(new com.bytedance.msdk.api.d(i, str));
            }

            public void d(com.bytedance.sdk.openadsdk.w.b.hc.mk mkVar) {
                if (mkVar == null) {
                    d.this.e.d(new com.bytedance.msdk.api.d(80001, "请求成功，但无广告可用"));
                    return;
                }
                d.this.mk = mkVar;
                d.this.h(true);
                d dVar = d.this;
                dVar.mq(dVar.mk.d());
                Map<String, Object> mapHc = d.this.mk.hc();
                com.bytedance.msdk.d.u.b.c("TTMediationSDK", "PangleFullVideoLoader WaterfallPangleFullVideoLoader extraInfo :".concat(String.valueOf(mapHc)));
                if (d.this.k.d() && mapHc != null) {
                    double d = com.bytedance.msdk.d.b.hc.d(mapHc.get("price"));
                    com.bytedance.msdk.d.u.b.d("TTMediationSDK_ECMP", com.bytedance.msdk.d.u.u.hc(d.this.k.hc(), d.this.k.mq()) + "pangle 全屏 返回的 cpm价格：" + d);
                    d dVar2 = d.this;
                    if (d <= 0.0d) {
                        d = 0.0d;
                    }
                    dVar2.d(d);
                }
                if (mapHc != null) {
                    d.this.c(mapHc);
                    Object obj = mapHc.get("materialMetaIsFromPreload");
                    if (obj instanceof Boolean) {
                        d.this.uo = ((Boolean) obj).booleanValue();
                        com.bytedance.msdk.d.u.b.d("TTMediationSDK", "pangle 全屏 返回的adnPreload：" + d.this.uo);
                    }
                }
                Function function = null;
                d.this.mk.d(new com.bytedance.sdk.openadsdk.w.b.d.b(function) { // from class: com.bytedance.msdk.b.b.hc.d.hc.an.d.1.1
                    public void d() {
                        if (d.this.b != null) {
                            d.this.b.d();
                        }
                    }

                    public void d(long j, long j2, String str, String str2) {
                        if (d.this.b != null) {
                            d.this.b.d(j, j2, (int) (j != 0 ? j2 / j : 0L), -1, str, str2);
                        }
                    }

                    public void hc(long j, long j2, String str, String str2) {
                        if (d.this.b != null) {
                            d.this.b.d(j, j2, str, str2);
                        }
                    }

                    public void b(long j, long j2, String str, String str2) {
                        if (d.this.b != null) {
                            d.this.b.hc(j, j2, str, str2);
                        }
                    }

                    public void d(long j, String str, String str2) {
                        if (d.this.b != null) {
                            d.this.b.d(j, str, str2);
                        }
                    }

                    public void d(String str, String str2) {
                        if (d.this.b != null) {
                            d.this.b.d(str, str2);
                        }
                    }
                });
                d.this.mk.d(new com.bytedance.sdk.openadsdk.np.d.hc.d.d(function) { // from class: com.bytedance.msdk.b.b.hc.d.hc.an.d.1.2
                    public void d() {
                        if (d.this.h instanceof com.bytedance.msdk.d.hc.hc) {
                            d.this.g().g_();
                        }
                    }

                    public void hc() {
                        if (d.this.h instanceof com.bytedance.msdk.d.hc.hc) {
                            d.this.g().h_();
                        }
                    }

                    public void b() {
                        if (d.this.h instanceof com.bytedance.msdk.d.hc.hc) {
                            d.this.g().b();
                        }
                    }

                    public void c() {
                        if (d.this.h instanceof com.bytedance.msdk.d.hc.hc) {
                            d.this.g().c();
                        }
                    }

                    public void u() {
                        if (d.this.h instanceof com.bytedance.msdk.d.hc.hc) {
                            d.this.g().an();
                        }
                    }
                });
                d.this.mq = true;
                d.this.e.d(d.this);
            }

            public void d() {
                com.bytedance.msdk.d.u.b.d("TMe", "pangle full cached");
            }

            public void hc(com.bytedance.sdk.openadsdk.w.b.hc.mk mkVar) {
                com.bytedance.msdk.d.u.b.d("TMe", "pangle full cached 2");
                d.this.mq = true;
                d.this.e.d(d.this, (com.bytedance.msdk.api.d) null);
            }
        };
        private boolean uo;

        @Override // com.bytedance.msdk.hc.b
        public boolean cw() {
            return true;
        }

        d() {
        }

        public void d(Context context, com.bytedance.msdk.api.d.hc hcVar, com.bytedance.msdk.b.an.hc.hc hcVar2, com.bytedance.msdk.b.b.hc.d.hc hcVar3) {
            this.k = hcVar2;
            this.e = hcVar3;
            this.cb = hcVar;
            z zVarD = an.this.d(context);
            if (zVarD == null) {
                return;
            }
            hc.d dVarD = com.bytedance.msdk.d.b.hc.d(this.cb, this.k, false);
            dVarD.d(1080).hc(1920).c(this.cb.fs());
            zVarD.d(dVarD.d(), this.tt);
        }

        @Override // com.bytedance.msdk.hc.b
        public void d(Activity activity, Object obj, String str) {
            com.bytedance.msdk.d.u.b.c("TTMediationSDK", "PangleFullVideoLoader WaterfallPangleFullVideoLoader showAd ritScenes:" + obj + "  ritScenesContent: " + str + "  mTTFullScreenVideoAd:" + this.mk + "  activity:" + activity);
            com.bytedance.sdk.openadsdk.w.b.hc.mk mkVar = this.mk;
            if (mkVar != null) {
                if (obj != null) {
                    mkVar.d(activity, obj, str);
                } else {
                    mkVar.d(activity);
                }
            }
        }

        @Override // com.bytedance.msdk.hc.b
        public Map<String, Object> j() {
            Map mapHc;
            com.bytedance.sdk.openadsdk.w.b.hc.mk mkVar = this.mk;
            if (mkVar == null || (mapHc = mkVar.hc()) == null) {
                return null;
            }
            HashMap map = new HashMap();
            map.put("coupon", mapHc.get("coupon"));
            map.put("live_room", mapHc.get("live_room"));
            map.put("product", mapHc.get("product"));
            b(map);
            return super.j();
        }

        @Override // com.bytedance.msdk.hc.b
        public Integer an() {
            com.bytedance.sdk.openadsdk.w.b.hc.mk mkVar = this.mk;
            if (mkVar != null && mkVar.c() > System.currentTimeMillis()) {
                return 2;
            }
            return 3;
        }

        @Override // com.bytedance.msdk.hc.b
        public boolean tr() {
            return this.uo;
        }

        @Override // com.bytedance.msdk.hc.b
        public void yo() {
            com.bytedance.sdk.openadsdk.w.b.hc.mk mkVar = this.mk;
            if (mkVar != null) {
                mkVar.d((com.bytedance.sdk.openadsdk.np.d.hc.d.d) null);
                this.mk.d((com.bytedance.sdk.openadsdk.w.b.d.b) null);
                this.mk.d((com.bytedance.sdk.openadsdk.w.b.d.hc) null);
                this.mk = null;
            }
        }

        @Override // com.bytedance.msdk.hc.b
        public boolean u() {
            return this.mk == null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public com.bytedance.msdk.d.hc.hc g() {
            return (com.bytedance.msdk.d.hc.hc) this.h;
        }

        @Override // com.bytedance.msdk.hc.b
        public long xi() {
            com.bytedance.sdk.openadsdk.w.b.hc.mk mkVar = this.mk;
            if (mkVar != null) {
                return com.bytedance.msdk.d.b.hc.d((Map<String, Object>) mkVar.hc());
            }
            return 0L;
        }

        @Override // com.bytedance.msdk.hc.b
        public long yb() {
            com.bytedance.sdk.openadsdk.w.b.hc.mk mkVar = this.mk;
            if (mkVar != null) {
                return com.bytedance.msdk.d.b.hc.hc((Map<String, Object>) mkVar.hc());
            }
            return 0L;
        }

        @Override // com.bytedance.msdk.hc.b
        public String ai() {
            com.bytedance.sdk.openadsdk.w.b.hc.mk mkVar = this.mk;
            return mkVar != null ? com.bytedance.msdk.d.b.hc.b((Map<String, Object>) mkVar.hc()) : "";
        }

        @Override // com.bytedance.msdk.hc.b
        public void d(com.bytedance.sdk.openadsdk.w.b.d.hc hcVar) {
            com.bytedance.sdk.openadsdk.w.b.hc.mk mkVar = this.mk;
            if (mkVar != null) {
                mkVar.d(hcVar);
            }
        }
    }
}
