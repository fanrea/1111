package com.alliance.ssp.ad.t;

import android.util.Log;

/* compiled from: NetworkExposeInfo.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class i {
    public static boolean a = false;

    public static void a(String str) {
        if (a) {
            Log.e("YTAdSDK", "╔═══════════════════════════════════════════════════════════════════\n║ " + str + "\n╚═══════════════════════════════════════════════════════════════════\n");
        }
    }

    public static void a(int i, String str) {
        if (a) {
            Log.e("YTAdSDK", "╔═══════════════════════════════════════════════════════════════════\n║ errorCode:\"" + i + "\"\n║ errorMsg:\"" + str + "\"\n╚═══════════════════════════════════════════════════════════════════\n");
        }
    }

    public static void a(String str, String str2, String str3, String str4, String str5) {
        if (a) {
            if (str3 != null) {
                Log.i("YTAdSDK", "╔═══════════════════════════════════════════════════════════════════\n║ \"请求ID\":\"" + str + "\"\n║ \"应用ID\":\"" + com.alliance.ssp.ad.o0.i.a + "\"\n║ \"代码位ID\":\"" + str2 + "\"\n║ \"当前时间戳\":\"" + System.currentTimeMillis() + "\"\n║ \"渲染类型\":\"" + str4 + "\"\n║ \"广告类型\":\"" + str5 + "\"\n║ \"ADN版本号\":\"" + com.alliance.ssp.ad.o0.i.f() + "\"\n║ \"请求广告宽度\":\"" + str3 + "\"\n╚═══════════════════════════════════════════════════════════════════\n");
            } else {
                Log.i("YTAdSDK", "╔═══════════════════════════════════════════════════════════════════\n║ \"请求ID\":\"" + str + "\"\n║ \"应用ID\":\"" + com.alliance.ssp.ad.o0.i.a + "\"\n║ \"代码位ID\":\"" + str2 + "\"\n║ \"当前时间戳\":\"" + System.currentTimeMillis() + "\"\n║ \"渲染类型\":\"" + str4 + "\"\n║ \"广告类型\":\"" + str5 + "\"\n║ \"ADN版本号\":\"" + com.alliance.ssp.ad.o0.i.f() + "\"\n╚═══════════════════════════════════════════════════════════════════\n");
            }
        }
    }

    public static void a(String str, String str2, int i, String str3) {
        if (a) {
            Log.e("YTAdSDK", "╔═══════════════════════════════════════════════════════════════════\n║ \"请求结果\":\"请求失败\"\n║ \"请求ID\":\"" + str + "\"\n║ \"应用ID\":\"" + com.alliance.ssp.ad.o0.i.a + "\"\n║ \"代码位ID\":\"" + str2 + "\"\n║ \"当前时间戳\":\"" + System.currentTimeMillis() + "\"\n║ \"错误码\":\"" + i + "\"\n║ \"错误信息\":\"" + str3 + "\"\n╚═══════════════════════════════════════════════════════════════════\n");
        }
    }

    public static void a(String str, String str2) {
        if (a) {
            Log.i("YTAdSDK", "╔═══════════════════════════════════════════════════════════════════\n║ \"请求结果\":\"请求成功\"\n║ \"请求ID\":\"" + str + "\"\n║ \"应用ID\":\"" + com.alliance.ssp.ad.o0.i.a + "\"\n║ \"代码位ID\":\"" + str2 + "\"\n║ \"当前时间戳\":\"" + System.currentTimeMillis() + "\"\n╚═══════════════════════════════════════════════════════════════════\n");
        }
    }
}
