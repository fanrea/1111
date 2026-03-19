package com.bytedance.msdk.b.b.hc.d.hc;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.core.z;
import com.bytedance.sdk.openadsdk.w.b.b.hc;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class mq extends hc {
    private int hc;

    public mq(com.bytedance.msdk.b.d.hc hcVar) {
        super(hcVar);
        this.hc = 3000;
    }

    @Override // com.bytedance.msdk.b.b.hc.d.hc
    public void hc(Context context, com.bytedance.msdk.b.an.hc.hc hcVar, com.bytedance.msdk.api.d.hc hcVar2, Map<String, Object> map) {
        if (hcVar2 == null) {
            d(new com.bytedance.msdk.api.d("load ad fail adSlot is null"));
        } else {
            new d(map).d(context != null ? context.getApplicationContext() : com.bytedance.msdk.core.hc.getContext(), hcVar2, hcVar, this);
        }
    }

    class d extends com.bytedance.msdk.hc.b {
        private com.bytedance.msdk.api.d.hc k;
        private Map<String, Object> mk;
        private com.bytedance.msdk.b.an.hc.hc mq;
        private com.bytedance.sdk.openadsdk.w.b.hc.hc tc;
        private com.bytedance.msdk.b.b.hc.d.hc uo;

        d(Map<String, Object> map) {
            this.mk = map;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public com.bytedance.msdk.d.hc.u g() {
            return (com.bytedance.msdk.d.hc.u) this.h;
        }

        void d(Context context, com.bytedance.msdk.api.d.hc hcVar, com.bytedance.msdk.b.an.hc.hc hcVar2, com.bytedance.msdk.b.b.hc.d.hc hcVar3) {
            this.mq = hcVar2;
            this.uo = hcVar3;
            this.k = hcVar;
            z zVarD = mq.this.d(context);
            if (zVarD == null) {
                return;
            }
            Map<String, Object> map = this.mk;
            if (map == null) {
                mq.this.hc = 3000;
            } else {
                mq.this.hc = map.get("ad_load_timeout") != null ? ((Integer) this.mk.get("ad_load_timeout")).intValue() : 3000;
            }
            hc.d dVarD = com.bytedance.msdk.d.b.hc.d(this.k, this.mq, false);
            dVarD.d(this.k.yi()).hc(this.k.he()).d(this.k.k()).hc(this.k.e());
            d(zVarD, dVarD.d());
        }

        private void d(z zVar, com.bytedance.sdk.openadsdk.w.b.b.hc hcVar) {
            com.bytedance.sdk.openadsdk.sy.d.hc.d.d dVar = new com.bytedance.sdk.openadsdk.sy.d.hc.d.d(null) { // from class: com.bytedance.msdk.b.b.hc.d.hc.mq.d.1
                public void d(com.bytedance.sdk.openadsdk.w.b.hc.hc hcVar2) {
                    com.bytedance.msdk.d.u.b.c("TTMediationSDK", "new api onSplashLoadSuccess 111");
                    if (hcVar2 == null) {
                        d.this.uo.d(new com.bytedance.msdk.api.d(80001, "渲染成功但广告是空"));
                        return;
                    }
                    d.this.tc = hcVar2;
                    d.this.h(true);
                    d dVar2 = d.this;
                    dVar2.mq(dVar2.tc.c());
                    Map<String, Object> mapU = d.this.tc.u();
                    com.bytedance.msdk.d.u.b.c("TTMediationSDK", "PangleSplashLoader WaterfallPangleSplashLoader extraInfo :".concat(String.valueOf(mapU)));
                    if (mapU != null) {
                        d.this.c(mapU);
                    }
                    if (d.this.mq.d() && mapU != null) {
                        double d = com.bytedance.msdk.d.b.hc.d(mapU.get("price"));
                        com.bytedance.msdk.d.u.b.d("TTMediationSDK_ECMP", com.bytedance.msdk.d.u.u.hc(d.this.mq.hc(), d.this.mq.mq()) + "pangle Splash 返回的 cpm价格：" + d);
                        d dVar3 = d.this;
                        if (d <= 0.0d) {
                            d = 0.0d;
                        }
                        dVar3.d(d);
                    }
                    Function function = null;
                    d.this.tc.d(new com.bytedance.sdk.openadsdk.w.b.d.b(function) { // from class: com.bytedance.msdk.b.b.hc.d.hc.mq.d.1.1
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
                    d.this.tc.d(new com.bytedance.sdk.openadsdk.c.d.hc.d.d(function) { // from class: com.bytedance.msdk.b.b.hc.d.hc.mq.d.1.2
                        public void d(com.bytedance.sdk.openadsdk.w.b.hc.hc hcVar3) {
                            com.bytedance.msdk.d.u.b.c("TTMediationSDK", "new api onSplashAdShow");
                            if (d.this.h instanceof com.bytedance.msdk.d.hc.u) {
                                d.this.g().u();
                            }
                        }

                        public void hc(com.bytedance.sdk.openadsdk.w.b.hc.hc hcVar3) {
                            com.bytedance.msdk.d.u.b.c("TTMediationSDK", "new api onSplashAdClick");
                            if (d.this.h instanceof com.bytedance.msdk.d.hc.u) {
                                d.this.g().c();
                            }
                        }

                        public void d(com.bytedance.sdk.openadsdk.w.b.hc.hc hcVar3, int i) {
                            com.bytedance.msdk.d.u.b.c("TTMediationSDK", "new api onSplashAdClose closeType = ".concat(String.valueOf(i)));
                            if (i == 1 || i == 3) {
                                if (d.this.h instanceof com.bytedance.msdk.d.hc.u) {
                                    d.this.g().d(i);
                                }
                            } else if (d.this.h instanceof com.bytedance.msdk.d.hc.u) {
                                d.this.g().hc(i);
                            }
                        }
                    });
                    d.this.tc.d(new com.bytedance.sdk.openadsdk.c.d.hc.d.hc(function) { // from class: com.bytedance.msdk.b.b.hc.d.hc.mq.d.1.3
                        public void d(com.bytedance.sdk.openadsdk.w.b.hc.hc hcVar3) {
                            if (hcVar3 != null) {
                                com.bytedance.msdk.d.u.b.c("TTMediationSDK", "new api onSplashCardReadyToShow csjSplashAd.getSplashCardView()" + hcVar3.b());
                            }
                            if (d.this.h instanceof com.bytedance.msdk.d.hc.u) {
                                d.this.g();
                            }
                            if (d.this.h instanceof com.bytedance.msdk.d.hc.u) {
                                d.this.g().k_();
                            }
                        }

                        public void d() {
                            com.bytedance.msdk.d.u.b.c("TTMediationSDK", "new api onSplashCardClick");
                            try {
                                if (d.this.h instanceof com.bytedance.msdk.d.hc.u) {
                                    d.this.g().b();
                                }
                            } catch (Throwable th) {
                                com.bytedance.sdk.component.utils.mq.d(th);
                            }
                        }

                        public void hc() {
                            com.bytedance.msdk.d.u.b.c("TTMediationSDK", "new api onSplashCardClose");
                            if (d.this.h instanceof com.bytedance.msdk.d.hc.u) {
                                d.this.g().l_();
                            }
                        }
                    });
                    d.this.uo.d(d.this);
                }

                public void d(com.bytedance.sdk.openadsdk.w.b.hc.d dVar2) {
                    com.bytedance.msdk.d.u.b.c("TTMediationSDK", "new api onSplashLoadFail");
                    if (dVar2 != null) {
                        d.this.uo.d(new com.bytedance.msdk.api.d(dVar2.d(), dVar2.hc()));
                    } else {
                        d.this.uo.d(new com.bytedance.msdk.api.d(80001, "csjAdError is null"));
                    }
                }

                public void hc(com.bytedance.sdk.openadsdk.w.b.hc.hc hcVar2) {
                    com.bytedance.msdk.d.u.b.c("TTMediationSDK", "new api onSplashRenderSuccess");
                }

                public void d(com.bytedance.sdk.openadsdk.w.b.hc.hc hcVar2, com.bytedance.sdk.openadsdk.w.b.hc.d dVar2) {
                    com.bytedance.msdk.d.u.b.c("TTMediationSDK", "new api onSplashRenderFail");
                    if (dVar2 != null) {
                        d.this.uo.d(new com.bytedance.msdk.api.d(dVar2.d(), dVar2.hc()));
                    } else {
                        d.this.uo.d(new com.bytedance.msdk.api.d(80001, "csjAdError is null"));
                    }
                }
            };
            if (zVar != null) {
                zVar.d(hcVar, dVar, mq.this.hc);
            }
        }

        @Override // com.bytedance.msdk.hc.b
        public void d(ViewGroup viewGroup) {
            com.bytedance.sdk.openadsdk.w.b.hc.hc hcVar = this.tc;
            if (hcVar == null || viewGroup == null) {
                return;
            }
            hcVar.d(viewGroup);
        }

        @Override // com.bytedance.msdk.hc.b
        public void d(ViewGroup viewGroup, Activity activity) {
            com.bytedance.sdk.openadsdk.w.b.hc.hc hcVar = this.tc;
            if (hcVar != null) {
                hcVar.d(viewGroup, activity);
            }
        }

        @Override // com.bytedance.msdk.hc.b
        public Map<String, Object> j() {
            Map mapU;
            com.bytedance.sdk.openadsdk.w.b.hc.hc hcVar = this.tc;
            if (hcVar != null && (mapU = hcVar.u()) != null) {
                HashMap map = new HashMap();
                map.put("coupon", mapU.get("coupon"));
                map.put("live_room", mapU.get("live_room"));
                map.put("product", mapU.get("product"));
                b(map);
            }
            return super.j();
        }

        @Override // com.bytedance.msdk.hc.b
        public void yo() {
            com.bytedance.sdk.openadsdk.w.b.hc.hc hcVar = this.tc;
            if (hcVar != null) {
                hcVar.d((com.bytedance.sdk.openadsdk.c.d.hc.d.d) null);
                this.tc.d((com.bytedance.sdk.openadsdk.w.b.d.b) null);
                this.tc.d((com.bytedance.sdk.openadsdk.c.d.hc.d.hc) null);
                this.tc = null;
            }
        }

        @Override // com.bytedance.msdk.hc.b
        public boolean u() {
            return this.tc == null;
        }

        @Override // com.bytedance.msdk.hc.b
        public long xi() {
            com.bytedance.sdk.openadsdk.w.b.hc.hc hcVar = this.tc;
            if (hcVar != null) {
                return com.bytedance.msdk.d.b.hc.d((Map<String, Object>) hcVar.u());
            }
            return 0L;
        }

        @Override // com.bytedance.msdk.hc.b
        public long yb() {
            com.bytedance.sdk.openadsdk.w.b.hc.hc hcVar = this.tc;
            if (hcVar != null) {
                return com.bytedance.msdk.d.b.hc.hc((Map<String, Object>) hcVar.u());
            }
            return 0L;
        }

        @Override // com.bytedance.msdk.hc.b
        public String ai() {
            com.bytedance.sdk.openadsdk.w.b.hc.hc hcVar = this.tc;
            return hcVar != null ? com.bytedance.msdk.d.b.hc.b((Map<String, Object>) hcVar.u()) : "";
        }

        @Override // com.bytedance.msdk.hc.b
        public void d(com.bytedance.sdk.openadsdk.w.b.d.hc hcVar) {
            com.bytedance.sdk.openadsdk.w.b.hc.hc hcVar2 = this.tc;
            if (hcVar2 != null) {
                hcVar2.d(hcVar);
            }
        }

        @Override // com.bytedance.msdk.hc.b
        public void m() {
            com.bytedance.msdk.d.u.b.c("TTMediationSDK", "PangleSplashLoader hideSkipButton   WaterfallPangleSplashLoader  mCSJSplashAd:" + this.tc);
            com.bytedance.sdk.openadsdk.w.b.hc.hc hcVar = this.tc;
            if (hcVar != null) {
                hcVar.an();
            }
        }
    }
}
