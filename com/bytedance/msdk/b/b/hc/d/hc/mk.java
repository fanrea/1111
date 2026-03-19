package com.bytedance.msdk.b.b.hc.d.hc;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.cm;
import com.bytedance.sdk.openadsdk.w.b.hc.e;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class mk extends hc {
    private com.bytedance.msdk.b.an.hc.hc b;
    private com.bytedance.msdk.api.d.hc hc;

    public mk(com.bytedance.msdk.b.d.hc hcVar) {
        super(hcVar);
    }

    @Override // com.bytedance.msdk.b.b.hc.d.hc
    public void hc(Context context, com.bytedance.msdk.b.an.hc.hc hcVar, com.bytedance.msdk.api.d.hc hcVar2, Map<String, Object> map) {
        this.hc = hcVar2;
        this.b = hcVar;
        if (hcVar2 == null) {
            b();
        } else {
            new d(map).d(context != null ? context.getApplicationContext() : com.bytedance.msdk.core.hc.getContext());
        }
    }

    public void b() {
        d(new com.bytedance.msdk.api.d("load ad fail adSlot is null"));
    }

    class d extends com.bytedance.msdk.hc.b {
        private e mk;
        private boolean mq;
        com.bytedance.sdk.openadsdk.sy.d.hc.d.h tt = new AnonymousClass1(null);
        private Map<String, Object> uo;

        @Override // com.bytedance.msdk.hc.b
        public boolean cw() {
            return true;
        }

        d(Map<String, Object> map) {
            this.uo = map;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public com.bytedance.msdk.api.c.d.gb.d g() {
            return (com.bytedance.msdk.api.c.d.gb.d) this.gb;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public com.bytedance.msdk.api.c.d.gb.d xq() {
            return (com.bytedance.msdk.api.c.d.gb.d) this.h;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:12:0x0028  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void d(android.content.Context r9) {
            /*
                r8 = this;
                com.bytedance.msdk.b.b.hc.d.hc.mk r0 = com.bytedance.msdk.b.b.hc.d.hc.mk.this
                com.bytedance.sdk.openadsdk.core.z r9 = r0.d(r9)
                if (r9 != 0) goto L9
                return
            L9:
                com.bytedance.msdk.b.b.hc.d.hc.mk r0 = com.bytedance.msdk.b.b.hc.d.hc.mk.this
                com.bytedance.msdk.api.d.hc r0 = com.bytedance.msdk.b.b.hc.d.hc.mk.d(r0)
                java.util.Map r0 = r0.hv()
                if (r0 == 0) goto L28
                java.lang.String r1 = "pangle"
                java.lang.Object r0 = r0.get(r1)
                boolean r1 = r0 instanceof java.lang.String
                if (r1 == 0) goto L28
                java.lang.String r0 = (java.lang.String) r0
                boolean r1 = android.text.TextUtils.isEmpty(r0)
                if (r1 != 0) goto L28
                goto L2a
            L28:
                java.lang.String r0 = ""
            L2a:
                com.bytedance.msdk.b.b.hc.d.hc.mk r1 = com.bytedance.msdk.b.b.hc.d.hc.mk.this
                com.bytedance.msdk.api.d.hc r2 = com.bytedance.msdk.b.b.hc.d.hc.mk.d(r1)
                com.bytedance.msdk.b.b.hc.d.hc.mk r1 = com.bytedance.msdk.b.b.hc.d.hc.mk.this
                com.bytedance.msdk.b.an.hc.hc r1 = com.bytedance.msdk.b.b.hc.d.hc.mk.hc(r1)
                java.lang.String r3 = r1.mq()
                com.bytedance.msdk.b.b.hc.d.hc.mk r1 = com.bytedance.msdk.b.b.hc.d.hc.mk.this
                com.bytedance.msdk.b.an.hc.hc r1 = com.bytedance.msdk.b.b.hc.d.hc.mk.hc(r1)
                java.lang.String r4 = r1.cb()
                com.bytedance.msdk.b.b.hc.d.hc.mk r1 = com.bytedance.msdk.b.b.hc.d.hc.mk.this
                com.bytedance.msdk.b.an.hc.hc r1 = com.bytedance.msdk.b.b.hc.d.hc.mk.hc(r1)
                java.lang.String r5 = r1.w()
                com.bytedance.msdk.b.b.hc.d.hc.mk r1 = com.bytedance.msdk.b.b.hc.d.hc.mk.this
                com.bytedance.msdk.b.an.hc.hc r1 = com.bytedance.msdk.b.b.hc.d.hc.mk.hc(r1)
                java.lang.String r6 = r1.yi()
                r7 = 0
                com.bytedance.sdk.openadsdk.w.b.b.hc$d r1 = com.bytedance.msdk.d.b.hc.d(r2, r3, r4, r5, r6, r7)
                com.bytedance.msdk.b.b.hc.d.hc.mk r2 = com.bytedance.msdk.b.b.hc.d.hc.mk.this
                com.bytedance.msdk.api.d.hc r2 = com.bytedance.msdk.b.b.hc.d.hc.mk.d(r2)
                java.lang.String r2 = r2.z()
                com.bytedance.sdk.openadsdk.w.b.b.hc$d r2 = r1.an(r2)
                com.bytedance.sdk.openadsdk.w.b.b.hc$d r0 = r2.u(r0)
                com.bytedance.msdk.b.b.hc.d.hc.mk r2 = com.bytedance.msdk.b.b.hc.d.hc.mk.this
                com.bytedance.msdk.api.d.hc r2 = com.bytedance.msdk.b.b.hc.d.hc.mk.d(r2)
                java.lang.String r2 = r2.j()
                com.bytedance.sdk.openadsdk.w.b.b.hc$d r0 = r0.tc(r2)
                com.bytedance.msdk.b.b.hc.d.hc.mk r2 = com.bytedance.msdk.b.b.hc.d.hc.mk.this
                com.bytedance.msdk.api.d.hc r2 = com.bytedance.msdk.b.b.hc.d.hc.mk.d(r2)
                int r2 = r2.s()
                com.bytedance.sdk.openadsdk.w.b.b.hc$d r0 = r0.gb(r2)
                r2 = 1080(0x438, float:1.513E-42)
                com.bytedance.sdk.openadsdk.w.b.b.hc$d r0 = r0.d(r2)
                r2 = 1920(0x780, float:2.69E-42)
                com.bytedance.sdk.openadsdk.w.b.b.hc$d r0 = r0.hc(r2)
                com.bytedance.msdk.b.b.hc.d.hc.mk r2 = com.bytedance.msdk.b.b.hc.d.hc.mk.this
                com.bytedance.msdk.api.d.hc r2 = com.bytedance.msdk.b.b.hc.d.hc.mk.d(r2)
                int r2 = r2.fs()
                r0.c(r2)
                com.bytedance.sdk.openadsdk.w.b.b.hc r0 = r1.d()
                com.bytedance.sdk.openadsdk.sy.d.hc.d.h r1 = r8.tt
                r9.d(r0, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.b.b.hc.d.hc.mk.d.d(android.content.Context):void");
        }

        @Override // com.bytedance.msdk.hc.b
        public void yo() {
            e eVar = this.mk;
            if (eVar != null) {
                eVar.d((com.bytedance.sdk.openadsdk.w.b.d.b) null);
                this.mk.d((com.bytedance.sdk.openadsdk.vv.d.hc.d.d) null);
                this.mk.d((com.bytedance.sdk.openadsdk.w.b.d.hc) null);
                this.mk = null;
            }
        }

        @Override // com.bytedance.msdk.hc.b
        public boolean u() {
            return this.mk == null;
        }

        @Override // com.bytedance.msdk.hc.b
        public boolean tr() {
            return this.mq;
        }

        @Override // com.bytedance.msdk.hc.b
        public String ai() {
            e eVar = this.mk;
            return eVar != null ? com.bytedance.msdk.d.b.hc.b((Map<String, Object>) eVar.hc()) : "";
        }

        @Override // com.bytedance.msdk.hc.b
        public Integer an() {
            e eVar = this.mk;
            if (eVar != null && eVar.c() > System.currentTimeMillis()) {
                return 2;
            }
            return 3;
        }

        @Override // com.bytedance.msdk.hc.b
        public void d(Activity activity, Object obj, String str) {
            e eVar = this.mk;
            if (eVar != null) {
                if (obj != null) {
                    eVar.d(activity, obj, str);
                } else {
                    eVar.d(activity);
                }
            }
        }

        @Override // com.bytedance.msdk.hc.b
        public Map<String, Object> j() {
            e eVar = this.mk;
            if (eVar != null) {
                b(eVar.hc());
            }
            return super.j();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean yl() {
            return !cm.d.equals(mk.this.d("pangle")) && "4.4.0.0".compareTo(mk.this.d("pangle")) > 0;
        }

        /* renamed from: com.bytedance.msdk.b.b.hc.d.hc.mk$d$1, reason: invalid class name */
        class AnonymousClass1 extends com.bytedance.sdk.openadsdk.sy.d.hc.d.h {
            AnonymousClass1(Function function) {
                super(function);
            }

            public void d(int i, String str) {
                com.bytedance.msdk.d.u.b.c("TTMediationSDK", "pangle_reward_onError code:" + i + "  message:" + str);
                mk.this.d(new com.bytedance.msdk.api.d(i, str));
            }

            public void d(e eVar) {
                com.bytedance.msdk.d.u.b.c("TTMediationSDK", "pangle_reward_onRewardVideoAdLoad");
                if (eVar != null) {
                    d.this.mk = eVar;
                    d.this.h(true);
                    d dVar = d.this;
                    dVar.mq(dVar.mk.d());
                    Map<String, Object> mapHc = d.this.mk.hc();
                    com.bytedance.msdk.d.u.b.c("TTMediationSDK", "PangleRewardLoader WaterfallPangleRewardLoader extraInfo :".concat(String.valueOf(mapHc)));
                    if (mk.this.b.d() && mapHc != null) {
                        double d = com.bytedance.msdk.d.b.hc.d(mapHc.get("price"));
                        com.bytedance.msdk.d.u.b.d("TTMediationSDK_ECMP", com.bytedance.msdk.d.u.u.hc(mk.this.b.hc(), mk.this.b.mq()) + "pangle reward 返回的 cpm价格：" + d);
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
                            d.this.mq = ((Boolean) obj).booleanValue();
                            com.bytedance.msdk.d.u.b.d("TTMediationSDK", "pangle 激励 返回的adnPreload：" + d.this.mq);
                        }
                    }
                    Function function = null;
                    d.this.mk.d(new com.bytedance.sdk.openadsdk.w.b.d.b(function) { // from class: com.bytedance.msdk.b.b.hc.d.hc.mk.d.1.1
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
                    d.this.mk.hc(new com.bytedance.sdk.openadsdk.vv.d.hc.d.d(function) { // from class: com.bytedance.msdk.b.b.hc.d.hc.mk.d.1.2
                        public void d() {
                            com.bytedance.msdk.d.u.b.c("TTMediationSDK", "pangle_reward:onAdShow-----------2");
                            if (d.this.gb instanceof com.bytedance.msdk.api.c.d.gb.d) {
                                d.this.g().i_();
                            }
                        }

                        public void hc() {
                            com.bytedance.msdk.d.u.b.c("TTMediationSDK", "pangle_reward:onAdVideoBarClick---------2");
                            if (d.this.gb instanceof com.bytedance.msdk.api.c.d.gb.d) {
                                d.this.g().j_();
                            }
                        }

                        public void b() {
                            com.bytedance.msdk.d.u.b.c("TTMediationSDK", "pangle_reward:onAdClose-----------2");
                            if (d.this.gb instanceof com.bytedance.msdk.api.c.d.gb.d) {
                                d.this.g().b();
                            }
                        }

                        public void c() {
                            com.bytedance.msdk.d.u.b.c("TTMediationSDK", "pangle_reward:onVideoComplete----------2");
                            if (d.this.gb instanceof com.bytedance.msdk.api.c.d.gb.d) {
                                d.this.g().c();
                            }
                        }

                        public void u() {
                            com.bytedance.msdk.d.u.b.c("TTMediationSDK", "pangle_reward:onVideoError-----------2");
                            if (d.this.gb instanceof com.bytedance.msdk.api.c.d.gb.d) {
                                d.this.g().u();
                            }
                        }

                        @Deprecated
                        public void d(final boolean z, final int i, final String str, final int i2, final String str2) {
                            if (d.this.yl()) {
                                com.bytedance.msdk.d.u.b.c("TTMediationSDK", "pangle_reward:onRewardVerify-------------2");
                                if (d.this.gb instanceof com.bytedance.msdk.api.c.d.gb.d) {
                                    d.this.g().d(new com.bytedance.msdk.api.b.d() { // from class: com.bytedance.msdk.b.b.hc.d.hc.mk.d.1.2.1
                                        @Override // com.bytedance.msdk.api.b.d
                                        public boolean d() {
                                            return z;
                                        }

                                        @Override // com.bytedance.msdk.api.b.d
                                        public float hc() {
                                            int i3 = i;
                                            if (i3 >= 0) {
                                                return i3;
                                            }
                                            if (mk.this.hc != null) {
                                                return mk.this.hc.s();
                                            }
                                            return 0.0f;
                                        }

                                        @Override // com.bytedance.msdk.api.b.d
                                        public String b() {
                                            if (TextUtils.isEmpty(str)) {
                                                return mk.this.hc != null ? mk.this.hc.j() : "";
                                            }
                                            return str;
                                        }

                                        @Override // com.bytedance.msdk.api.b.d
                                        public Map<String, Object> c() {
                                            HashMap map = new HashMap();
                                            map.put("errorCode", Integer.valueOf(i2));
                                            map.put("errorMsg", str2);
                                            return map;
                                        }
                                    });
                                }
                            }
                        }

                        public void d(final boolean z, final int i, final Bundle bundle) {
                            if (d.this.yl()) {
                                return;
                            }
                            com.bytedance.msdk.d.u.b.c("TTMediationSDK", "pangle_reward:onRewardArrived-------------2");
                            if (d.this.gb instanceof com.bytedance.msdk.api.c.d.gb.d) {
                                d.this.g().d(new com.bytedance.msdk.api.b.d() { // from class: com.bytedance.msdk.b.b.hc.d.hc.mk.d.1.2.2
                                    @Override // com.bytedance.msdk.api.b.d
                                    public boolean d() {
                                        return z;
                                    }

                                    @Override // com.bytedance.msdk.api.b.d
                                    public float hc() {
                                        float f = bundle != null ? r0.getInt("reward_extra_key_reward_amount") : 0.0f;
                                        if (f >= 0.0f) {
                                            return f;
                                        }
                                        if (mk.this.hc != null) {
                                            return mk.this.hc.s();
                                        }
                                        return 0.0f;
                                    }

                                    @Override // com.bytedance.msdk.api.b.d
                                    public String b() {
                                        Bundle bundle2 = bundle;
                                        String string = bundle2 != null ? bundle2.getString("reward_extra_key_reward_name") : "";
                                        return !TextUtils.isEmpty(string) ? string : mk.this.hc != null ? mk.this.hc.j() : "";
                                    }

                                    @Override // com.bytedance.msdk.api.b.d
                                    public Map<String, Object> c() {
                                        HashMap map = new HashMap();
                                        map.put("extraInfo", bundle);
                                        map.put("rewardType", Integer.valueOf(i));
                                        return map;
                                    }
                                });
                            }
                        }

                        public void an() {
                            com.bytedance.msdk.d.u.b.c("TTMediationSDK", "pangle_reward:onSkippedVideo-------------2");
                            if (d.this.gb instanceof com.bytedance.msdk.api.c.d.gb.d) {
                                d.this.g().an();
                            }
                        }
                    });
                    d.this.mk.d(new com.bytedance.sdk.openadsdk.vv.d.hc.d.d(function) { // from class: com.bytedance.msdk.b.b.hc.d.hc.mk.d.1.3
                        public void d() {
                            com.bytedance.msdk.d.u.b.c("TTMediationSDK", "pangle_reward:onAdShow");
                            if (d.this.h instanceof com.bytedance.msdk.api.c.d.gb.d) {
                                d.this.xq().i_();
                            }
                        }

                        public void hc() {
                            com.bytedance.msdk.d.u.b.c("TTMediationSDK", "pangle_reward:onAdVideoBarClick");
                            if (d.this.h instanceof com.bytedance.msdk.api.c.d.gb.d) {
                                d.this.xq().j_();
                            }
                        }

                        public void b() {
                            com.bytedance.msdk.d.u.b.c("TTMediationSDK", "pangle_reward:onAdClose");
                            if (d.this.h instanceof com.bytedance.msdk.api.c.d.gb.d) {
                                d.this.xq().b();
                            }
                        }

                        public void c() {
                            com.bytedance.msdk.d.u.b.c("TTMediationSDK", "pangle_reward:onVideoComplete");
                            if (d.this.h instanceof com.bytedance.msdk.api.c.d.gb.d) {
                                d.this.xq().c();
                            }
                        }

                        public void u() {
                            com.bytedance.msdk.d.u.b.c("TTMediationSDK", "pangle_reward:onVideoError");
                            if (d.this.h instanceof com.bytedance.msdk.api.c.d.gb.d) {
                                d.this.xq().u();
                            }
                        }

                        @Deprecated
                        public void d(final boolean z, final int i, final String str, final int i2, final String str2) {
                            if (d.this.yl()) {
                                com.bytedance.msdk.d.u.b.c("TTMediationSDK", "pangle_reward:onRewardVerify-------------2");
                                if (d.this.h instanceof com.bytedance.msdk.api.c.d.gb.d) {
                                    d.this.xq().d(new com.bytedance.msdk.api.b.d() { // from class: com.bytedance.msdk.b.b.hc.d.hc.mk.d.1.3.1
                                        @Override // com.bytedance.msdk.api.b.d
                                        public boolean d() {
                                            return z;
                                        }

                                        @Override // com.bytedance.msdk.api.b.d
                                        public float hc() {
                                            int i3 = i;
                                            if (i3 >= 0) {
                                                return i3;
                                            }
                                            if (mk.this.hc != null) {
                                                return mk.this.hc.s();
                                            }
                                            return 0.0f;
                                        }

                                        @Override // com.bytedance.msdk.api.b.d
                                        public String b() {
                                            if (TextUtils.isEmpty(str)) {
                                                return mk.this.hc != null ? mk.this.hc.j() : "";
                                            }
                                            return str;
                                        }

                                        @Override // com.bytedance.msdk.api.b.d
                                        public Map<String, Object> c() {
                                            HashMap map = new HashMap();
                                            map.put("errorCode", Integer.valueOf(i2));
                                            map.put("errorMsg", str2);
                                            return map;
                                        }
                                    });
                                }
                            }
                        }

                        public void d(final boolean z, final int i, final Bundle bundle) {
                            if (d.this.yl()) {
                                return;
                            }
                            com.bytedance.msdk.d.u.b.c("TTMediationSDK", "pangle_reward:onRewardArrived-------------2");
                            if (d.this.h instanceof com.bytedance.msdk.api.c.d.gb.d) {
                                d.this.xq().d(new com.bytedance.msdk.api.b.d() { // from class: com.bytedance.msdk.b.b.hc.d.hc.mk.d.1.3.2
                                    @Override // com.bytedance.msdk.api.b.d
                                    public boolean d() {
                                        return z;
                                    }

                                    @Override // com.bytedance.msdk.api.b.d
                                    public float hc() {
                                        float f = bundle != null ? r0.getInt("reward_extra_key_reward_amount") : 0.0f;
                                        if (f >= 0.0f) {
                                            return f;
                                        }
                                        if (mk.this.hc != null) {
                                            return mk.this.hc.s();
                                        }
                                        return 0.0f;
                                    }

                                    @Override // com.bytedance.msdk.api.b.d
                                    public String b() {
                                        Bundle bundle2 = bundle;
                                        String string = bundle2 != null ? bundle2.getString("reward_extra_key_reward_name") : "";
                                        return !TextUtils.isEmpty(string) ? string : mk.this.hc != null ? mk.this.hc.j() : "";
                                    }

                                    @Override // com.bytedance.msdk.api.b.d
                                    public Map<String, Object> c() {
                                        HashMap map = new HashMap();
                                        map.put("extraInfo", bundle);
                                        map.put("rewardType", Integer.valueOf(i));
                                        return map;
                                    }
                                });
                            }
                        }

                        public void an() {
                            com.bytedance.msdk.d.u.b.c("TTMediationSDK", "pangle_reward:onSkippedVideo");
                            if (d.this.h instanceof com.bytedance.msdk.api.c.d.gb.d) {
                                d.this.xq().an();
                            }
                        }
                    });
                    mk.this.d(d.this);
                    return;
                }
                mk.this.d(new com.bytedance.msdk.api.d("请求成功，但无广告可用"));
            }

            public void d() {
                com.bytedance.msdk.d.u.b.c("TTMediationSDK", "pangle_reward_onRewardVideoCached");
            }

            public void hc(e eVar) {
                com.bytedance.msdk.d.u.b.c("TTMediationSDK", "pangle_reward_onRewardVideoCached 2");
                mk.this.d(d.this, (com.bytedance.msdk.api.d) null);
            }
        }

        @Override // com.bytedance.msdk.hc.b
        public long xi() {
            e eVar = this.mk;
            if (eVar != null) {
                return com.bytedance.msdk.d.b.hc.d((Map<String, Object>) eVar.hc());
            }
            return 0L;
        }

        @Override // com.bytedance.msdk.hc.b
        public long yb() {
            e eVar = this.mk;
            if (eVar != null) {
                return com.bytedance.msdk.d.b.hc.hc((Map<String, Object>) eVar.hc());
            }
            return 0L;
        }

        @Override // com.bytedance.msdk.hc.b
        public void d(Object obj) {
            com.bytedance.msdk.d.u.b.c("TTMediationSDK", "PangleRewardLoader WaterfallPangleRewardLoader setRewardAdPlayAgainController rewardAdPlayAgainController:" + obj + "  mTTRewardVideoAd: " + this.mk);
            e eVar = this.mk;
            if (eVar == null || !(obj instanceof com.bytedance.sdk.openadsdk.vv.d.hc.d.hc)) {
                return;
            }
            eVar.d((com.bytedance.sdk.openadsdk.vv.d.hc.d.hc) obj);
        }

        @Override // com.bytedance.msdk.hc.b
        public void d(com.bytedance.sdk.openadsdk.w.b.d.hc hcVar) {
            com.bytedance.msdk.d.u.b.c("TTMediationSDK", "PangleRewardLoader WaterfallPangleRewardLoader setAdInteractionListener pluginTTAdInteractionListener:" + hcVar + "  mTTRewardVideoAd: " + this.mk);
            e eVar = this.mk;
            if (eVar != null) {
                eVar.d(hcVar);
            }
        }
    }
}
