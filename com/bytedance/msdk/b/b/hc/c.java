package com.bytedance.msdk.b.b.hc;

import android.util.Pair;
import com.bytedance.msdk.b.b.hc.d;
import com.bytedance.msdk.core.gb.k;
import com.bytedance.msdk.core.gb.mk;
import com.bytedance.msdk.core.gb.mq;
import com.bytedance.msdk.core.gb.tt;
import com.bytedance.msdk.core.tc.tc;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class c implements d {
    @Override // com.bytedance.msdk.b.b.hc.d
    public void d(d.InterfaceC0215d interfaceC0215d) {
        com.bytedance.msdk.api.d dVar;
        com.bytedance.msdk.api.d dVar2;
        com.bytedance.msdk.b.an.hc.hc hcVarD = interfaceC0215d.d();
        com.bytedance.msdk.b.an.d.hc hcVarHc = interfaceC0215d.hc();
        tc tcVarGb = hcVarD.gb();
        String strV = hcVarHc.rf().v();
        if (tcVarGb != null) {
            if (tcVarGb.c() && !mk.d().b(strV, tcVarGb.yo())) {
                com.bytedance.msdk.d.u.b.hc("TMe", "adn 请求触发次数拦截............");
                Pair<String, String> pairD = mk.d().d(strV, tcVarGb.yo());
                if (pairD != null) {
                    dVar2 = new com.bytedance.msdk.api.hc.hc(41041, com.bytedance.msdk.api.d.d(41041), (String) pairD.second, (String) pairD.first);
                } else {
                    dVar2 = new com.bytedance.msdk.api.d(41041, com.bytedance.msdk.api.d.d(41041));
                }
                com.bytedance.msdk.api.d dVar3 = dVar2;
                com.bytedance.msdk.u.an.d(tcVarGb, hcVarHc.rf(), com.bytedance.msdk.core.u.d.d.d().d(tcVarGb.yo()), hcVarD.u(), 2, hcVarD.b(), hcVarD.h(), hcVarD.an(), dVar3, -1L, hcVarHc.ba().u, false);
                com.bytedance.msdk.u.an.d(dVar3, hcVarHc.rf(), tcVarGb, hcVarD.b(), hcVarD.h(), hcVarD.an(), com.bytedance.msdk.core.u.d.d.d().d(tcVarGb.yo()), 0L, (String) null, (String) null, (String) null, 0L);
                hcVarD.d(dVar3, tcVarGb);
                return;
            }
            if (tcVarGb.c() && !mq.d().b(strV, tcVarGb.yo())) {
                com.bytedance.msdk.d.u.b.hc("TMe", "adn 请求触发时间间隔拦截............");
                tt ttVarC = mq.d().c(strV, tcVarGb.yo());
                if (ttVarC != null) {
                    dVar = new com.bytedance.msdk.api.hc.b(41042, com.bytedance.msdk.api.d.d(41042), new StringBuilder().append(mq.d().d(strV, tcVarGb.yo())).toString(), ttVarC.tc());
                } else {
                    dVar = new com.bytedance.msdk.api.d(41042, com.bytedance.msdk.api.d.d(41042));
                }
                com.bytedance.msdk.api.d dVar4 = dVar;
                com.bytedance.msdk.u.an.d(tcVarGb, hcVarHc.rf(), com.bytedance.msdk.core.u.d.d.d().d(tcVarGb.yo()), hcVarD.u(), 2, hcVarD.b(), hcVarD.h(), hcVarD.an(), dVar4, -1L, hcVarHc.ba().u, false);
                com.bytedance.msdk.u.an.d(dVar4, hcVarHc.rf(), tcVarGb, hcVarD.b(), hcVarD.h(), hcVarD.an(), com.bytedance.msdk.core.u.d.d.d().d(tcVarGb.yo()), 0L, (String) null, (String) null, (String) null, 0L);
                hcVarD.d(dVar4, tcVarGb);
                return;
            }
            if (k.d().d(strV, tcVarGb.w())) {
                com.bytedance.msdk.api.d dVarD = k.d().d(strV, tcVarGb.e(), tcVarGb.yo());
                if (dVarD != null) {
                    com.bytedance.msdk.d.u.b.hc("TMe", "adn 请求触发了rit级别的错误码拦截............");
                    com.bytedance.msdk.u.an.d(tcVarGb, hcVarHc.rf(), com.bytedance.msdk.core.u.d.d.d().d(tcVarGb.yo()), hcVarD.u(), 2, hcVarD.b(), hcVarD.h(), hcVarD.an(), dVarD, -1L, hcVarHc.ba().u, false);
                    com.bytedance.msdk.u.an.d(dVarD, hcVarHc.rf(), tcVarGb, hcVarD.b(), hcVarD.h(), hcVarD.an(), com.bytedance.msdk.core.u.d.d.d().d(tcVarGb.yo()), 0L, (String) null, (String) null, (String) null, 0L);
                    hcVarD.d(dVarD, tcVarGb);
                    return;
                }
            } else {
                com.bytedance.msdk.api.d dVarD2 = com.bytedance.msdk.core.gb.b.d().d(tcVarGb.e(), tcVarGb.yo());
                if (dVarD2 != null) {
                    com.bytedance.msdk.d.u.b.hc("TMe", "adn 请求触发了错误码拦截............");
                    com.bytedance.msdk.u.an.d(tcVarGb, hcVarHc.rf(), com.bytedance.msdk.core.u.d.d.d().d(tcVarGb.yo()), hcVarD.u(), 2, hcVarD.b(), hcVarD.h(), hcVarD.an(), dVarD2, -1L, hcVarHc.ba().u, false);
                    com.bytedance.msdk.u.an.d(dVarD2, hcVarHc.rf(), tcVarGb, hcVarD.b(), hcVarD.h(), hcVarD.an(), com.bytedance.msdk.core.u.d.d.d().d(tcVarGb.yo()), 0L, (String) null, (String) null, (String) null, 0L);
                    hcVarD.d(dVarD2, tcVarGb);
                    return;
                }
            }
        }
        interfaceC0215d.d(this);
    }
}
