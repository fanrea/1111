package com.bytedance.msdk.b.b.d;

import android.text.TextUtils;
import com.bytedance.msdk.b.b.d.d;
import com.bytedance.msdk.gb.j;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class u implements d {
    private int d(int i) {
        switch (i) {
            case 1:
                return 840032;
            case 2:
                return 840033;
            case 3:
                return 840034;
            case 4:
            case 6:
            default:
                return 840029;
            case 5:
                return 840035;
            case 7:
                return 840036;
            case 8:
                return 840037;
            case 9:
                return 840030;
            case 10:
                return 840039;
        }
    }

    @Override // com.bytedance.msdk.b.b.d.d
    public void d(d.InterfaceC0214d interfaceC0214d) {
        com.bytedance.msdk.b.an.d.hc hcVarD = interfaceC0214d.d();
        com.bytedance.msdk.api.d.hc hcVarRf = hcVarD.rf();
        com.bytedance.msdk.api.hc.d dVar = !com.bytedance.msdk.core.hc.hc().d(hcVarD.rf().v(), hcVarD.rf().de()) ? new com.bytedance.msdk.api.hc.d(840031, com.bytedance.msdk.api.d.d(840031)) : null;
        if (dVar == null && !com.bytedance.msdk.core.hc.hc().d(hcVarD.rf().de())) {
            dVar = new com.bytedance.msdk.api.hc.d(d(hcVarD.rf().de()), com.bytedance.msdk.api.d.d(d(hcVarD.rf().de())));
        }
        if (dVar == null && !com.bytedance.msdk.an.b.hc()) {
            dVar = new com.bytedance.msdk.api.hc.d(1, com.bytedance.msdk.api.d.d(1));
        }
        if (dVar == null && hcVarD.an()) {
            dVar = new com.bytedance.msdk.api.hc.d(41044, com.bytedance.msdk.api.d.d(41044));
        }
        if (dVar == null && hcVarD.getContext() == null) {
            com.bytedance.msdk.d.u.b.c("TTMediationSDK", "Context为null！！！");
            dVar = new com.bytedance.msdk.api.hc.d(41005, com.bytedance.msdk.api.d.d(41005));
        }
        if (dVar == null && TextUtils.isEmpty(hcVarD.rf().v())) {
            dVar = new com.bytedance.msdk.api.hc.d(840026, "广告位id不能为空");
        }
        if (dVar == null && (hcVarD.mq() == null || j.d(hcVarD.mq().y()))) {
            if (com.bytedance.msdk.h.d.b.d().b()) {
                com.bytedance.msdk.d.u.b.c("TTMediationSDK", com.bytedance.msdk.d.u.u.d(hcVarRf.v()) + "settings config.......没有settings config配置信息,AdUnitId = " + hcVarRf.v());
                dVar = new com.bytedance.msdk.api.hc.d(840040, com.bytedance.msdk.api.d.d(840040));
                com.bytedance.msdk.u.an.hc(hcVarRf, 1);
            } else if (hcVarD.mq() != null && j.d(hcVarD.mq().y())) {
                com.bytedance.msdk.d.u.b.c("TTMediationSDK", com.bytedance.msdk.d.u.u.d(hcVarRf.v()) + "settings config.......注意，AdUnitId = " + hcVarRf.v() + "  没有对应的waterfall配置信息");
                com.bytedance.msdk.u.an.hc(hcVarRf, 3);
            } else {
                com.bytedance.msdk.d.u.b.c("TTMediationSDK", com.bytedance.msdk.d.u.u.d(hcVarRf.v()) + "settings config.......注意，AdUnitId = " + hcVarRf.v() + " 的配置信息为 null ！！");
                dVar = new com.bytedance.msdk.api.hc.d(44406, "检查广告位ID的状态是否正常、初始化 useMediation 参数是否为 true、新建广告位ID生效期为20min左右");
                com.bytedance.msdk.u.an.hc(hcVarRf, 2);
            }
            com.bytedance.msdk.core.k.hc.d(com.bytedance.msdk.core.hc.hc()).hc(1);
        }
        if (dVar == null) {
            String strTr = hcVarRf.tr();
            if (!TextUtils.isEmpty(strTr) && !hcVarRf.nv() && !com.bytedance.msdk.b.gb.c.d(hcVarRf.v(), strTr)) {
                dVar = new com.bytedance.msdk.api.hc.d(840044, "本次请求未包含聚合广告位头层设价最高的代码位，导致聚合请求失败；请调整请求，确保包含聚合广告位头层设价最高的代码位。");
            }
        }
        com.bytedance.msdk.api.hc.d dVar2 = dVar;
        if (dVar2 != null) {
            com.bytedance.msdk.u.an.d(hcVarRf, hcVarD.mq() != null ? hcVarD.mq().wl() : null, !hcVarD.v(), hcVarD.ba().d, dVar2.d, (Map<String, Object>) null);
            hcVarD.d(dVar2);
        } else {
            interfaceC0214d.d(interfaceC0214d.d());
        }
    }

    @Override // com.bytedance.msdk.b.b.d.d
    public void hc(d.InterfaceC0214d interfaceC0214d) {
        com.bytedance.msdk.b.an.d.hc hcVarD = interfaceC0214d.d();
        if (hcVarD.an()) {
            com.bytedance.msdk.d.u.b.c("TTMediationSDK", "调用过销毁方法_destroy()！！！");
            hcVarD.d(new com.bytedance.msdk.api.d(41044, com.bytedance.msdk.api.d.d(41044)));
        } else if (hcVarD.uo().u()) {
            hcVarD.d(new com.bytedance.msdk.api.d(10010, "延长瀑布流总超时时长或者缩短层超时并添加兜底代码位"));
        } else {
            interfaceC0214d.d((String) null);
        }
    }
}
