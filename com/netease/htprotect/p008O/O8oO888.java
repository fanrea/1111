package com.netease.htprotect.p008O;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.common.utility.DeviceUtils;

/* renamed from: com.netease.htprotect.〇O.O8〇oO8〇88, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class O8oO888 {

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static final boolean f215O8oO888;

    /* renamed from: 〇O8, reason: contains not printable characters */
    private static final String f216O8;

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    private static final boolean f217Ooo;

    /* renamed from: 〇o0〇o0, reason: contains not printable characters */
    private static final String f218o0o0;

    /* renamed from: 〇oO, reason: contains not printable characters */
    private static final String f219oO;

    static {
        f215O8oO888 = Build.VERSION.SDK_INT >= 29;
        f217Ooo = Build.VERSION.SDK_INT >= 28;
        f216O8 = Build.MANUFACTURER.toUpperCase();
        f218o0o0 = Build.BRAND.toUpperCase();
        f219oO = Build.PRODUCT.toUpperCase();
    }

    /* JADX WARN: Removed duplicated region for block: B:121:0x0177  */
    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m635O8oO888(android.content.Context r8) throws java.lang.NoSuchMethodException, java.lang.ClassNotFoundException, java.lang.SecurityException {
        /*
            Method dump skipped, instructions count: 522
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.netease.htprotect.p008O.O8oO888.m635O8oO888(android.content.Context):java.lang.String");
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static boolean m636O8oO888() {
        return DeviceUtils.ROM_SMARTISAN.equals(f218o0o0) || "DELTAINNO".equals(f216O8);
    }

    private static boolean Oo0() {
        return "EEBBK".equals(f216O8) || "EEBBK".equals(f218o0o0);
    }

    /* renamed from: 〇O, reason: contains not printable characters */
    private static boolean m637O() throws ClassNotFoundException {
        String strM672O8oO888 = o8o0.m672O8oO888("ro.build.freeme.label", "unknown");
        return !TextUtils.isEmpty(strM672O8oO888) && "FREEMEOS".equalsIgnoreCase(strM672O8oO888);
    }

    /* renamed from: 〇O8, reason: contains not printable characters */
    private static boolean m638O8() {
        String str = f216O8;
        return DeviceUtils.ROM_LENOVO.equals(str) || "MOTOLORA".equals(str) || "ZUK".equals(f218o0o0);
    }

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    private static boolean m639Ooo() {
        String str = f216O8;
        return "HUAWEI".equals(str) || "HONOR".equals(str) || "华为".equals(f218o0o0);
    }

    /* renamed from: 〇o0〇o0, reason: contains not printable characters */
    private static boolean m640o0o0() {
        String str = f216O8;
        return DeviceUtils.ROM_OPPO.equals(str) || "ONEPLUS".equals(str) || "REALME".equals(str) || f219oO.startsWith("ONEPLUS") || !TextUtils.isEmpty(o8o0.m672O8oO888("ro.build.version.opporom", ""));
    }

    /* renamed from: 〇oO, reason: contains not printable characters */
    private static boolean m641oO() {
        String str = f216O8;
        return "XIAOMI".equals(str) || "BLACKSHARK".equals(str) || "REDMI".equals(str) || "MEITU".equals(f218o0o0);
    }

    /* renamed from: 〇o〇0O〇0O, reason: contains not printable characters */
    private static boolean m642o0O0O() {
        return DeviceUtils.ROM_VIVO.equals(f216O8) || !TextUtils.isEmpty(o8o0.m672O8oO888("ro.vivo.os.version", ""));
    }

    /* renamed from: 〇〇, reason: contains not printable characters */
    private static boolean m643() {
        return !TextUtils.isEmpty(o8o0.m672O8oO888("ro.build.skyui_version", "")) || "NIO".equals(f216O8);
    }
}
