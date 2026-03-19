package com.alipay.sdk.m.u;

import android.content.Context;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.baidu.mobstat.forbes.Config;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class c {
    public static final String a = "00:00:00:00:00:00";
    public static c b;

    public c(Context context) {
    }

    public static c b(Context context) {
        if (b == null) {
            b = new c(context);
        }
        return b;
    }

    public static String c(Context context) {
        if (context == null) {
            return "";
        }
        try {
            return context.getResources().getConfiguration().locale.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static g d(Context context) {
        try {
            NetworkInfo networkInfoA = com.alipay.sdk.m.w.b.a(null, context);
            return (networkInfoA == null || networkInfoA.getType() != 0) ? (networkInfoA == null || networkInfoA.getType() != 1) ? g.NONE : g.WIFI : g.a(networkInfoA.getSubtype());
        } catch (Exception unused) {
            return g.NONE;
        }
    }

    public String a() {
        String str = b() + "|";
        String strC = c();
        return TextUtils.isEmpty(strC) ? str + Config.NULL_DEVICE_ID : str + strC;
    }

    public String b() {
        return Config.NULL_DEVICE_ID;
    }

    public String c() {
        return Config.NULL_DEVICE_ID;
    }

    public String d() {
        return a;
    }

    public static String a(Context context) {
        return b(context).a().substring(0, 8);
    }
}
