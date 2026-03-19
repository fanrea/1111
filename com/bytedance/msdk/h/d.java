package com.bytedance.msdk.h;

import com.baidu.mobstat.forbes.Config;
import com.bytedance.msdk.core.hc;
import com.bytedance.msdk.gb.zw;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d {
    public static zw d() {
        return zw.d("tt_sdk_new_settings_" + com.bytedance.msdk.core.d.mk().mq(), hc.getContext());
    }

    public static zw hc() {
        return zw.d("tt_sdk_app_common_settings_" + com.bytedance.msdk.core.d.mk().mq(), hc.getContext());
    }

    public static zw b() {
        return zw.d("tt_sdk_mediation_mp_settings", hc.getContext());
    }

    public static zw c() {
        return zw.d("tt_sdk_adn_init_settings_" + com.bytedance.msdk.core.d.mk().mq(), hc.getContext());
    }

    public static zw d(int i) {
        return zw.d("tt_sdk_rit_settings_" + com.bytedance.msdk.core.d.mk().mq() + Config.replace + com.bytedance.msdk.hc.d.hc(i), hc.getContext());
    }

    public static zw u() {
        return zw.d("tt_sdk_gm_data_" + com.bytedance.msdk.core.d.mk().mq(), hc.getContext());
    }

    public static zw an() {
        return zw.d("sp_gm_sdk_init_" + com.bytedance.msdk.core.d.mk().mq(), hc.getContext());
    }
}
