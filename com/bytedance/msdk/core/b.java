package com.bytedance.msdk.core;

import android.text.TextUtils;
import com.bytedance.msdk.gb.z;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class b {
    private static String d;
    private static String hc;

    public static String d() {
        return z.d(u() + "/api/ad/union/mediation/config/");
    }

    public static String hc() {
        return z.d("https://" + hc.hc().mk());
    }

    public static String b() {
        return z.d(u() + "/api/ad/union/mediation/exchange/");
    }

    public static String c() {
        return z.d(u() + "/api/ad/union/mediation/reward_video/reward/");
    }

    private static String u() {
        String strAn = an();
        return !TextUtils.isEmpty(strAn) ? strAn : "https://gromore.pangolin-sdk-toutiao.com";
    }

    private static String an() {
        String strHc = com.bytedance.msdk.h.d.d().hc("server_dist_host");
        if (TextUtils.isEmpty(strHc)) {
            return null;
        }
        if (TextUtils.equals(strHc, d) && !TextUtils.isEmpty(hc)) {
            return hc;
        }
        d = strHc;
        hc = null;
        if (!TextUtils.isEmpty(strHc)) {
            hc = com.bytedance.msdk.gb.d.hc(d, com.bytedance.msdk.gb.hc.d());
        }
        if (TextUtils.isEmpty(hc)) {
            return null;
        }
        String str = "https://" + hc;
        hc = str;
        return str;
    }
}
