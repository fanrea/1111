package com.baidu.mobads.container.rewardvideo;

import com.component.a.b.e;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class bh implements e.a {
    final /* synthetic */ NativeRewardActivity a;

    bh(NativeRewardActivity nativeRewardActivity) {
        this.a = nativeRewardActivity;
    }

    @Override // com.component.a.b.e.a
    public void a(com.component.a.b.e eVar, com.component.a.b.j jVar, com.component.a.b.o oVar) throws NumberFormatException {
        com.component.a.f.e eVarB;
        if ((eVar instanceof com.component.a.i.f) && (eVarB = ((com.component.a.i.f) eVar).b()) != null) {
            String strL = eVarB.l("");
            String strM = eVarB.m("");
            if ("close_view".equals(strM)) {
                if (this.a.aU) {
                    this.a.d(com.baidu.mobads.container.o.j.b("pixel_click_view") + com.baidu.mobads.container.o.j.a + this.a.aV + com.baidu.mobads.container.o.j.a + this.a.aW);
                    return;
                }
                return;
            }
            if ("shake_view".equals(strM)) {
                this.a.d(com.baidu.mobads.container.o.j.a(strM, eVarB));
                return;
            }
            if (com.component.a.g.c.bm.c.equals(strM)) {
                this.a.d(com.baidu.mobads.container.o.j.a(strM, eVarB));
                return;
            }
            if ("flip_card".equals(strM)) {
                this.a.d(com.baidu.mobads.container.o.j.l(strM, eVarB));
                return;
            }
            if ("answer_card".equals(strM)) {
                this.a.d(com.baidu.mobads.container.o.j.k(strM, eVarB));
                return;
            }
            if ("atmosphere_view".equals(strM)) {
                this.a.d(com.baidu.mobads.container.o.j.c(strM, eVarB));
                return;
            }
            if ("bubble_widget".equals(strM)) {
                this.a.d(com.baidu.mobads.container.o.j.g(strM, eVarB));
                return;
            }
            if ("dynamic_barrage".equals(strM)) {
                this.a.d(com.baidu.mobads.container.o.j.h(strM, eVarB));
                return;
            }
            if ("click_reward".equals(strM)) {
                this.a.d(com.baidu.mobads.container.o.j.o(strM, eVarB));
                return;
            }
            if ("interact_front_pack_rain".equals(strM)) {
                this.a.d(com.baidu.mobads.container.o.j.m(strM, eVarB));
                return;
            }
            if ("interact_front_flip_card".equals(strM)) {
                this.a.d(com.baidu.mobads.container.o.j.m(strM, eVarB));
                return;
            }
            if ("interact_front_lucky_bag".equals(strM)) {
                this.a.d(com.baidu.mobads.container.o.j.i(strM, eVarB));
                return;
            }
            if ("interact_back_welfare".equals(strM)) {
                this.a.d(com.baidu.mobads.container.o.j.j(strM, eVarB));
                return;
            }
            if ("interact_back_coupon".equals(strM)) {
                this.a.d(com.baidu.mobads.container.o.j.n(strM, eVarB));
                return;
            }
            if ("coupon_float".equals(strM)) {
                this.a.d(com.baidu.mobads.container.o.j.a(this.a.mAdInstanceInfo.getOriginJsonObject(), strM, eVarB));
                return;
            }
            if ("dc_view".equals(strM)) {
                this.a.d(com.baidu.mobads.container.o.j.b(strM) + com.baidu.mobads.container.o.j.a + this.a.az.a() + com.baidu.mobads.container.o.j.a + this.a.az.b());
                return;
            }
            if (strL != null && strL.contains("big_white_finger_content")) {
                this.a.d(com.baidu.mobads.container.o.j.d("big_white_finger", eVarB));
                return;
            }
            if ("one_purchase".equals(strM)) {
                this.a.d(com.baidu.mobads.container.o.j.p(strM, eVarB));
            } else if ("coupon_discount".equals(strM)) {
                this.a.d(com.baidu.mobads.container.o.j.q(strM, eVarB));
            } else {
                this.a.d(com.baidu.mobads.container.o.j.b(eVarB));
            }
        }
    }
}
