package com.baidu.mobads.container.e;

import com.baidu.mobads.container.o.j;
import com.component.a.b.e;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class r implements e.a {
    final /* synthetic */ l a;

    r(l lVar) {
        this.a = lVar;
    }

    @Override // com.component.a.b.e.a
    public void a(com.component.a.b.e eVar, com.component.a.b.j jVar, com.component.a.b.o oVar) throws NumberFormatException {
        com.component.a.f.e eVarB;
        int iOptInt;
        if ((eVar instanceof com.component.a.i.f) && (eVarB = ((com.component.a.i.f) eVar).b()) != null) {
            String strL = eVarB.l("");
            String strM = eVarB.m("");
            if ("close_view".equals(strM)) {
                if (this.a.bd) {
                    this.a.c(com.baidu.mobads.container.o.j.b("pixel_click_view") + com.baidu.mobads.container.o.j.a + this.a.be + com.baidu.mobads.container.o.j.a + this.a.bf);
                    return;
                }
                return;
            }
            if ("bubble_widget".equals(strM)) {
                this.a.c(com.baidu.mobads.container.o.j.g(strM, eVarB));
                return;
            }
            if (strL != null && strL.contains("big_white_finger_content")) {
                if (com.baidu.mobads.container.o.j.a(this.a.mAdInstanceInfo.getOriginJsonObject(), strL).contains("big_white_finger_content")) {
                    this.a.c(com.baidu.mobads.container.o.j.d("big_white_finger", eVarB));
                    return;
                } else {
                    if (com.baidu.mobads.container.o.j.a(this.a.mAdInstanceInfo.getOriginJsonObject(), strL).contains("atmosphere_view")) {
                        this.a.c(com.baidu.mobads.container.o.j.c("atmosphere_view", eVarB));
                        return;
                    }
                    return;
                }
            }
            if (strL != null && strL.contains("coc_lottie")) {
                this.a.c(com.baidu.mobads.container.o.j.e("big_coc_view", eVarB));
                return;
            }
            if ("shake_view".equals(strM)) {
                if (eVarB.e(1) == 1) {
                    this.a.c(com.baidu.mobads.container.o.j.a(strM, eVarB));
                    return;
                }
                return;
            }
            if ("coupon_flip_page".equals(strM)) {
                this.a.c(com.baidu.mobads.container.o.j.f(strM, eVarB));
                return;
            }
            if ("coupon_float".equals(strM)) {
                this.a.c(com.baidu.mobads.container.o.j.a(this.a.mAdInstanceInfo.getOriginJsonObject(), strM, eVarB));
                return;
            }
            if ("interact_front_lucky_bag".equals(strM)) {
                this.a.c(com.baidu.mobads.container.o.j.i(strM, eVarB));
                return;
            }
            if ("interact_front_pack_rain".equals(strM)) {
                this.a.c(com.baidu.mobads.container.o.j.m(strM, eVarB));
                return;
            }
            if ("interact_front_flip_card".equals(strM)) {
                this.a.c(com.baidu.mobads.container.o.j.m(strM, eVarB));
                return;
            }
            if ("interact_back_coupon".equals(strM)) {
                this.a.c(com.baidu.mobads.container.o.j.n(strM, eVarB));
                return;
            }
            if ("interact_back_welfare".equals(strM)) {
                this.a.c(com.baidu.mobads.container.o.j.j(strM, eVarB));
                return;
            }
            if ("front_slide_view".equals(strM) && this.a.v()) {
                if (eVarB.e(1) == 1) {
                    this.a.c(com.baidu.mobads.container.o.j.b(strM) + "");
                    return;
                }
                return;
            }
            if ("slide_view".equals(strM)) {
                this.a.c(com.baidu.mobads.container.o.j.b(strM) + "");
                return;
            }
            if ("front_easter_egg".equals(strM) && this.a.v()) {
                this.a.c(com.baidu.mobads.container.o.j.b(strM, eVarB));
                return;
            }
            if ("easter_egg".equals(strM)) {
                this.a.c(com.baidu.mobads.container.o.j.b(strM, eVarB));
                return;
            }
            if ("dynamic_barrage".equals(strM)) {
                this.a.c(com.baidu.mobads.container.o.j.h("dynamic_barrage", eVarB));
                return;
            }
            if ("bookmark".equals(strM)) {
                this.a.c(j.a.BOOKMARK.b() + "");
                return;
            }
            if (!"dc_view".equals(strM) || eVarB.e(1) != 1) {
                if (com.component.a.g.c.bm.d.equals(strM) && this.a.v()) {
                    if (eVarB.e(1) == 1) {
                        this.a.c(com.baidu.mobads.container.o.j.a(strM, eVarB));
                        return;
                    }
                    return;
                } else {
                    if (com.component.a.g.c.bm.e.equals(strM)) {
                        this.a.c(com.baidu.mobads.container.o.j.a(strM, eVarB));
                        return;
                    }
                    if ("one_purchase".equals(strM)) {
                        this.a.c(com.baidu.mobads.container.o.j.p(strM, eVarB));
                        return;
                    } else if ("coupon_discount".equals(strM)) {
                        this.a.c(com.baidu.mobads.container.o.j.q(strM, eVarB));
                        return;
                    } else {
                        this.a.c(com.baidu.mobads.container.o.j.b(eVarB));
                        return;
                    }
                }
            }
            int i = 0;
            if (eVarB.c() == null) {
                iOptInt = 0;
            } else {
                int iOptInt2 = eVarB.c().optInt("delay_time", 0);
                iOptInt = eVarB.c().optInt(com.baidu.mobads.container.adrequest.n.m, 0);
                i = iOptInt2;
            }
            this.a.c(com.baidu.mobads.container.o.j.b(strM) + com.baidu.mobads.container.o.j.a + i + com.baidu.mobads.container.o.j.a + iOptInt);
        }
    }
}
