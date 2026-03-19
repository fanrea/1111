package com.bytedance.msdk.d.u;

import android.text.TextUtils;
import com.baidu.mobstat.forbes.Config;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class u {
    public static String d() {
        return "TTMediationSDK_";
    }

    public static String d(String str) {
        if (TextUtils.isEmpty(str)) {
            return d();
        }
        return "TTMediationSDK_" + str + Config.replace;
    }

    public static String d(com.bytedance.msdk.core.tc.hc hcVar) {
        if (hcVar == null || TextUtils.isEmpty(hcVar.fs())) {
            return d();
        }
        return "TTMediationSDK_" + hcVar.fs() + Config.replace;
    }

    public static String d(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return d();
        }
        if (TextUtils.isEmpty(str2)) {
            return d(str);
        }
        return "TTMediationSDK_" + str + Config.replace + str2 + Config.replace;
    }

    public static String hc(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return d();
        }
        if (TextUtils.isEmpty(str2)) {
            return d(str);
        }
        return "TTMediationSDK_" + str + Config.replace + str2 + Config.replace;
    }
}
