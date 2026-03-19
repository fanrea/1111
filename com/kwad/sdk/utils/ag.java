package com.kwad.sdk.utils;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class ag {
    private static String sAppTag = "";

    public static void e(Context context, String str, long j) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_pref", str, j);
    }

    public static long aj(Context context, String str) {
        if (context == null) {
            return 0L;
        }
        return b(context, "ksadsdk_pref", str, 0L);
    }

    public static boolean dC(Context context) {
        if (context == null) {
            return true;
        }
        return c(context, "ksadsdk_pref", "ksadsdk_guider_slide_left", true);
    }

    public static void dD(Context context) {
        if (context == null) {
            return;
        }
        b(context, "ksadsdk_pref", "ksadsdk_guider_slide_left", false);
    }

    public static boolean dE(Context context) {
        if (context == null) {
            return true;
        }
        return c(context, "ksadsdk_pref", "ksadsdk_guider_slideup", true);
    }

    public static void dF(Context context) {
        if (context == null) {
            return;
        }
        b(context, "ksadsdk_pref", "ksadsdk_guider_slideup", false);
    }

    public static void f(Context context, String str, long j) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_download_package_length", str, j);
    }

    public static long ak(Context context, String str) {
        if (context == null) {
            return 0L;
        }
        return b(context, "ksadsdk_download_package_length", str, 0L);
    }

    public static void g(Context context, String str, String str2) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_download_package_md5", str, str2);
    }

    public static String al(Context context, String str) {
        return context == null ? "" : b(context, "ksadsdk_download_package_md5", str, "");
    }

    public static String dG(Context context) {
        return context == null ? "" : b(context, "ksadsdk_egid", "KEY_SDK_EGID", "");
    }

    private static String dH(Context context) {
        return context == null ? "" : b(context, "ksadsdk_uaid", "KEY_SDK_UAID", "");
    }

    public static String dI(Context context) {
        return context == null ? "" : b(context, "ksadsdk_uaid_token", "KEY_SDK_UAID_TOKEN", "");
    }

    public static boolean aov() {
        return c(getContext(), "ksadsdk_uaid_enable", "KEY_SDK_UAID_ENABLE", false);
    }

    public static long aow() {
        return b(getContext(), "ksadsdk_uaid_expire_sec", "KEY_SDK_UAID_EXPIRE_SEC", 0L);
    }

    private static long aox() {
        return b(getContext(), "ksadsdk_uaid_create_time", "KEY_SDK_UAID_CREATE_TIME", 0L);
    }

    public static void e(Context context, long j) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_gidExpireTimeMs", "KEY_SDK_EGID", j);
    }

    public static long dJ(Context context) {
        if (context == null) {
            return 0L;
        }
        return b(context, "ksadsdk_gidExpireTimeMs", "KEY_SDK_EGID", 0L);
    }

    public static void am(Context context, String str) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_egid", "KEY_SDK_EGID", str);
    }

    public static void an(Context context, String str) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_uaid", "KEY_SDK_UAID", str);
    }

    public static void ao(Context context, String str) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_uaid_token", "KEY_SDK_UAID_TOKEN", str);
    }

    public static void f(Context context, long j) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_uaid_create_time", "KEY_SDK_UAID_CREATE_TIME", j);
    }

    public static void c(Context context, boolean z) {
        if (context == null) {
            return;
        }
        b(context, "ksadsdk_uaid_enable", "KEY_SDK_UAID_ENABLE", z);
    }

    public static void g(Context context, long j) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_uaid_expire_sec", "KEY_SDK_UAID_EXPIRE_SEC", j);
    }

    public static void o(Context context, int i) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_config_request", "KEY_CONFIG_REQUEST_FAIL", i);
    }

    public static int dK(Context context) {
        if (context == null) {
            return 0;
        }
        return b(context, "ksadsdk_config_request", "KEY_CONFIG_REQUEST_FAIL", 0);
    }

    public static String dL(Context context) {
        if (context == null) {
            return "";
        }
        String strB = b(context, "ksadsdk_model", "KEY_SDK_MODEL", "");
        bp.i(strB, "ksadsdk_model", "KEY_SDK_MODEL");
        return strB;
    }

    public static void ap(Context context, String str) {
        if (context == null) {
            return;
        }
        a("ksadsdk_model", "KEY_SDK_MODEL", str, true);
    }

    public static String dM(Context context) {
        return context == null ? "" : b(context, "ksadsdk_wallpaper_path", "KEY_SDK_WALLPAPER_PATH", "");
    }

    public static void aq(Context context, String str) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_wallpaper_path", "KEY_SDK_WALLPAPER_PATH", str);
    }

    public static String aoy() {
        Context context = getContext();
        return context == null ? "" : b(context, "ksadsdk_interstitial_daily_show_count", "KEY_INTERSTITIAL_DAILY_SHOW_COUNT", "");
    }

    public static void ar(Context context, String str) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_interstitial_daily_show_count", "KEY_INTERSTITIAL_DAILY_SHOW_COUNT", str);
    }

    public static void p(Context context, int i) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_reward_full_ad_jump_direct", "KEY_REWARD_AD_SHOW_INTERACT_INTERVAL_SHOW_COUNT", i);
    }

    public static int dN(Context context) {
        if (context == null) {
            return 0;
        }
        return b(context, "ksadsdk_reward_full_ad_jump_direct", "KEY_REWARD_AD_SHOW_INTERACT_INTERVAL_SHOW_COUNT", 0);
    }

    public static void as(Context context, String str) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_reward_full_ad_jump_direct", "KEY_REWARD_INTERACT_AD_SHOW_INFO", str);
    }

    public static String dO(Context context) {
        return context == null ? "" : b(context, "ksadsdk_reward_full_ad_jump_direct", "KEY_REWARD_INTERACT_AD_SHOW_INFO", "");
    }

    public static String aoz() {
        Context context = getContext();
        return context == null ? "" : b(context, "ksadsdk_reward_full_ad_jump_direct", "KEY_REWARD_FULL_AD_JUMP_DIRECT", "");
    }

    public static void at(Context context, String str) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_reward_full_ad_jump_direct", "KEY_REWARD_FULL_AD_JUMP_DIRECT", str);
    }

    public static String aoA() {
        Context context = getContext();
        if (context == null) {
            return "";
        }
        if (bo.apP()) {
            return b(context, "ksadsdk_splash_local_ad_force_active", "KEY_SPLASH_DAILY_SHOW_COUNT", "");
        }
        return b(context, "ksadsdk_splash_daily_show_count", "KEY_SPLASH_DAILY_SHOW_COUNT", "");
    }

    public static void au(Context context, String str) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_splash_local_ad_force_active", "KEY_SPLASH_DAILY_SHOW_COUNT", str);
        bo.apO();
    }

    public static String aoB() {
        Context context = getContext();
        if (context == null) {
            return "";
        }
        if (bo.apR()) {
            return h("ksadsdk_reward_full_ad_jump_direct", "KEY_REWARD_AUTO_CALL_APP_CARD_SHOW_COUNT", "");
        }
        return b(context, "ksadsdk_reward_auto_call_app_card_show_count", "KEY_REWARD_AUTO_CALL_APP_CARD_SHOW_COUNT", "");
    }

    public static void av(Context context, String str) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_reward_full_ad_jump_direct", "KEY_REWARD_AUTO_CALL_APP_CARD_SHOW_COUNT", str);
        bo.apQ();
    }

    public static String aoC() {
        return h("ksadsdk_interstitial_daily_show_count", "KEY_INTERSTITIAL_AUTO_CALL_APP_CARD_SHOW_COUNT", "");
    }

    public static void aw(Context context, String str) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_interstitial_daily_show_count", "KEY_INTERSTITIAL_AUTO_CALL_APP_CARD_SHOW_COUNT", str);
    }

    public static String dP(Context context) {
        return context == null ? "" : b(context, "ksadsdk_device_sig", "KEY_SDK_DEVICE_SIG", "");
    }

    public static void ax(Context context, String str) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_device_sig", "KEY_SDK_DEVICE_SIG", str);
    }

    public static void h(Context context, long j) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_pref", "feed_interstitial_ad_time", j);
    }

    public static long dQ(Context context) {
        if (context == null) {
            return -1L;
        }
        return b(context, "ksadsdk_pref", "feed_interstitial_ad_time", -1L);
    }

    public static void ay(Context context, final String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        h.execute(new bh() { // from class: com.kwad.sdk.utils.ag.1
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                ag.az(ServiceProvider.getContext(), str);
            }
        });
    }

    public static void az(Context context, String str) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_pref", "appTag", str);
    }

    public static String aoD() {
        if (!TextUtils.isEmpty(sAppTag)) {
            return sAppTag;
        }
        Context context = getContext();
        return context == null ? "" : b(context, "ksadsdk_pref", "appTag", "");
    }

    public static void i(Context context, long j) {
        if (context == null) {
            return;
        }
        a("ksadsdk_pref", "login_userId", j);
    }

    public static long dR(Context context) {
        if (context == null) {
            return 0L;
        }
        return b("ksadsdk_pref", "login_userId", 0L);
    }

    public static void aA(Context context, String str) {
        if (context == null) {
            return;
        }
        a("ksadsdk_pref", "webview_ua", str, true);
    }

    public static String dS(Context context) {
        if (context == null) {
            return "";
        }
        String strH = h("ksadsdk_pref", "webview_ua", "");
        bp.i(strH, "ksadsdk_pref", "webview_ua");
        return strH;
    }

    public static String aoE() {
        Context context = getContext();
        return context == null ? "" : dG(context);
    }

    public static String aoF() {
        Context context = getContext();
        return context == null ? "" : dH(context);
    }

    public static String aoG() {
        Context context = getContext();
        return context == null ? "" : dI(context);
    }

    public static boolean aoH() {
        return !TextUtils.isEmpty(aoG());
    }

    public static boolean aoI() {
        return (TextUtils.isEmpty(aoF()) || aoJ()) ? false : true;
    }

    private static boolean aoJ() {
        long jCurrentTimeMillis = (System.currentTimeMillis() - aox()) / 1000;
        long jAow = aow();
        return jAow != 0 && jCurrentTimeMillis >= jAow;
    }

    public static String dT(Context context) {
        if (bo.apM()) {
            return bo.aM(context.getApplicationContext(), "ksadsdk_sdk_config_data");
        }
        String strH = bp.h("ksadsdk_sdk_config_data", "config_str", "");
        bo.i(context.getApplicationContext(), "ksadsdk_sdk_config_data", strH);
        return strH;
    }

    public static void aB(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        bo.j(context.getApplicationContext(), "ksadsdk_sdk_config_data", str);
    }

    public static long aoK() {
        return b("ksadsdk_push_ad_common", "key_push_last_show_time", -1L);
    }

    public static void bz(long j) {
        a("ksadsdk_push_ad_common", "key_push_last_show_time", j);
    }

    public static String aoL() {
        return getContext() == null ? "" : h("ksadsdk_install_tips_show_count", "init_install_tips_show_count", "");
    }

    public static void aC(Context context, String str) {
        if (context == null) {
            return;
        }
        g("ksadsdk_install_tips_show_count", "init_install_tips_show_count", str);
    }

    public static void aoM() {
        b("ksadsdk_perf", "image_load_total", c("ksadsdk_perf", "image_load_total", 0) + 1);
    }

    public static void aoN() {
        b("ksadsdk_perf", "image_load_suc", c("ksadsdk_perf", "image_load_suc", 0) + 1);
    }

    public static void aoO() {
        b("ksadsdk_perf", "image_load_failed", c("ksadsdk_perf", "image_load_failed", 0) + 1);
    }

    public static void bA(long j) {
        b("ksadsdk_perf", "image_load_complete_count", c("ksadsdk_perf", "image_load_complete_count", 0) + 1);
        a("ksadsdk_perf", "image_load_complete_total", b("ksadsdk_perf", "image_load_complete_total", 0L) + j);
    }

    public static double aoP() {
        int iC = c("ksadsdk_perf", "image_load_complete_count", 0);
        long jB = b("ksadsdk_perf", "image_load_complete_total", 0L);
        b("ksadsdk_perf", "image_load_complete_count", 0);
        a("ksadsdk_perf", "image_load_complete_total", 0L);
        if (iC == 0) {
            return 0.0d;
        }
        return jB / iC;
    }

    public static int aoQ() {
        int iC = c("ksadsdk_perf", "image_load_total", 0);
        com.kwad.sdk.core.d.c.d("Ks_UnionUtils", "imageLoadTotal:" + iC);
        b("ksadsdk_perf", "image_load_total", 0);
        return iC;
    }

    public static int aoR() {
        int iC = c("ksadsdk_perf", "image_load_suc", 0);
        com.kwad.sdk.core.d.c.d("Ks_UnionUtils", "imageLoadSuccess:" + iC);
        b("ksadsdk_perf", "image_load_suc", 0);
        return iC;
    }

    public static int aoS() {
        int iC = c("ksadsdk_perf", "image_load_failed", 0);
        com.kwad.sdk.core.d.c.d("Ks_UnionUtils", "imageLoadFailed:" + iC);
        b("ksadsdk_perf", "image_load_failed", 0);
        return iC;
    }

    public static void g(String str, String str2, String str3) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        a(context, str, str2, str3);
    }

    public static String h(String str, String str2, String str3) {
        Context context = getContext();
        return context == null ? str3 : b(context, str, str2, str3);
    }

    public static void a(String str, String str2, String str3, boolean z) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        a(context, str, str2, str3, true);
    }

    private static void a(String str, String str2, long j) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        a(context, str, str2, j);
    }

    private static long b(String str, String str2, long j) {
        Context context = getContext();
        return context == null ? j : b(context, str, str2, j);
    }

    public static void b(String str, String str2, int i) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        a(context, str, str2, i);
    }

    public static int c(String str, String str2, int i) {
        Context context = getContext();
        return context == null ? i : b(context, str, str2, i);
    }

    public static void n(String str, String str2, boolean z) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        b(context, str, str2, z);
    }

    public static boolean o(String str, String str2, boolean z) {
        Context context = getContext();
        return context == null ? z : c(context, str, str2, z);
    }

    public static Context getContext() {
        return ServiceProvider.anu();
    }

    public static void a(Context context, String str, String str2, String str3) {
        if (context == null) {
            return;
        }
        if (af.ir(str)) {
            bp.g(str, str2, str3);
            if (com.kwad.framework.a.a.qr.booleanValue()) {
                com.kwad.sdk.core.d.c.d("Ks_UnionUtils", "putString Sp key:" + str2 + " value:" + str3);
                return;
            }
            return;
        }
        com.kwad.sdk.utils.a.e.aN(context, str).putString(str2, str3);
        if (com.kwad.framework.a.a.qr.booleanValue()) {
            com.kwad.sdk.core.d.c.d("Ks_UnionUtils", "putString key:" + str2 + " value:" + str3);
        }
        af.az(str2, str3);
    }

    private static void a(Context context, String str, String str2, String str3, boolean z) {
        if (context == null) {
            return;
        }
        if (af.ir(str)) {
            bp.a(str, str2, str3, z);
            if (com.kwad.framework.a.a.qr.booleanValue()) {
                com.kwad.sdk.core.d.c.d("Ks_UnionUtils", "putString Sp key:" + str2 + " value:" + str3);
                return;
            }
            return;
        }
        com.kwad.sdk.utils.a.e.aN(context, str).putString(str2, str3);
        if (com.kwad.framework.a.a.qr.booleanValue()) {
            com.kwad.sdk.core.d.c.d("Ks_UnionUtils", "putString key:" + str2 + " value:" + str3);
        }
        af.az(str2, str3);
    }

    public static String b(Context context, String str, String str2, String str3) {
        String string;
        if (context == null) {
            return str3;
        }
        if (af.ir(str)) {
            string = bp.h(str, str2, str3);
            if (com.kwad.framework.a.a.qr.booleanValue()) {
                com.kwad.sdk.core.d.c.d("Ks_UnionUtils", "getString From Sp key:" + str2 + " value:" + string);
            }
        } else {
            string = com.kwad.sdk.utils.a.e.aN(context, str).getString(str2, str3);
            af.aA(str2, string);
            if (com.kwad.framework.a.a.qr.booleanValue()) {
                com.kwad.sdk.core.d.c.d("Ks_UnionUtils", "getString key:" + str2 + " value:" + string);
            }
        }
        return com.kwad.sdk.core.a.c.isEncodeKsSdk(string) ? com.kwad.sdk.core.a.c.decodeKsSdk(string) : string;
    }

    private static void a(Context context, String str, String str2, long j) {
        if (context == null) {
            return;
        }
        if (af.ir(str)) {
            bp.a(str, str2, j);
        } else {
            com.kwad.sdk.utils.a.e.aN(context, str).putLong(str2, j);
        }
    }

    private static long b(Context context, String str, String str2, long j) {
        if (context == null) {
            return j;
        }
        if (af.ir(str)) {
            return bp.b(str, str2, j);
        }
        return com.kwad.sdk.utils.a.e.aN(context, str).getLong(str2, j);
    }

    private static void a(Context context, String str, String str2, int i) {
        if (context == null) {
            return;
        }
        if (af.ir(str)) {
            bp.b(str, str2, i);
        } else {
            com.kwad.sdk.utils.a.e.aN(context, str).putInt(str2, i);
        }
    }

    private static int b(Context context, String str, String str2, int i) {
        if (context == null) {
            return i;
        }
        if (af.ir(str)) {
            return bp.c(str, str2, i);
        }
        return com.kwad.sdk.utils.a.e.aN(context, str).getInt(str2, i);
    }

    private static void b(Context context, String str, String str2, boolean z) {
        if (context == null) {
            return;
        }
        if (af.ir(str)) {
            bp.n(str, str2, z);
        } else {
            com.kwad.sdk.utils.a.e.aN(context, str).putBoolean(str2, z);
        }
    }

    private static boolean c(Context context, String str, String str2, boolean z) {
        if (context == null) {
            return z;
        }
        if (af.ir(str)) {
            return bp.o(str, str2, z);
        }
        return com.kwad.sdk.utils.a.e.aN(context, str).getBoolean(str2, z);
    }

    public static void h(Context context, String str, String str2) {
        if (context == null) {
            return;
        }
        if (af.ir(str)) {
            bp.aE(str, str2);
        } else {
            com.kwad.sdk.utils.a.e.aN(context, str).remove(str2);
            af.az(str2, "");
        }
    }

    public static void i(String str, String str2, String str3) {
        if (af.ir(str2)) {
            bp.i(str, str2, str3);
        }
    }
}
