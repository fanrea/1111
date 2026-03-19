package com.bytedance.sdk.component.utils;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.container.util.e.a;
import com.kwai.middleware.azeroth.utils.NetworkUtils;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class k {
    public static void d(e eVar) {
        yi.d(eVar);
    }

    public static boolean d(Context context) {
        return b(context) != 0;
    }

    public static int hc(Context context) {
        int iB = b(context);
        if (iB == 1) {
            return 0;
        }
        if (iB == 4) {
            return 1;
        }
        if (iB == 5) {
            return 4;
        }
        if (iB != 6) {
            return iB;
        }
        return 6;
    }

    public static int b(Context context) {
        return yi.d(context, 60000L);
    }

    public static boolean c(Context context) {
        return b(context) == 4;
    }

    public static boolean u(Context context) {
        return b(context) == 5;
    }

    public static boolean an(Context context) {
        return b(context) == 6;
    }

    public static String h(Context context) {
        int iB = b(context);
        return iB != 2 ? iB != 3 ? iB != 4 ? iB != 5 ? iB != 6 ? "mobile" : NetworkUtils.MOBILE_NETWORK_5G : NetworkUtils.MOBILE_NETWORK_4G : a.a : NetworkUtils.MOBILE_NETWORK_3G : NetworkUtils.MOBILE_NETWORK_2G;
    }

    public static boolean d(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("http://") || str.startsWith("https://");
    }
}
