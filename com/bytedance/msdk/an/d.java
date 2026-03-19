package com.bytedance.msdk.an;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.msdk.api.c.tc;
import com.bytedance.msdk.core.d.d.u;
import com.kwad.sdk.api.model.AdnName;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d {
    public static void d() {
        try {
            if (com.bytedance.msdk.d.u.b.hc() && tc.d()) {
                hc();
            }
        } catch (Throwable unused) {
        }
    }

    private static synchronized void hc() {
        if (com.bytedance.msdk.core.hc.getContext() == null) {
            return;
        }
        com.bytedance.msdk.h.d.hc.d().c();
    }

    private static int b(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return 0;
        }
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (TextUtils.isEmpty(str2)) {
            return 1;
        }
        if (str.startsWith("v") || str.startsWith(ExifInterface.GPS_MEASUREMENT_INTERRUPTED)) {
            str = str.substring(1);
        }
        if (str2.startsWith("v") || str2.startsWith(ExifInterface.GPS_MEASUREMENT_INTERRUPTED)) {
            str2 = str2.substring(1);
        }
        String[] strArrSplit = str.split("\\.");
        String[] strArrSplit2 = str2.split("\\.");
        int iMin = Math.min(strArrSplit.length, strArrSplit2.length);
        for (int i = 0; i < iMin; i++) {
            if (strArrSplit[i].length() != strArrSplit2[i].length()) {
                return strArrSplit[i].length() > strArrSplit2[i].length() ? 1 : -1;
            }
            int iCompareTo = strArrSplit[i].compareTo(strArrSplit2[i]);
            if (iCompareTo != 0) {
                return iCompareTo;
            }
        }
        if (strArrSplit.length == strArrSplit2.length) {
            return 0;
        }
        return strArrSplit.length > strArrSplit2.length ? 1 : -1;
    }

    public static boolean d(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        if (str.equals(AdnName.BAIDU) || str.equals("admob") || str.equals("pangle")) {
            return true;
        }
        str.hashCode();
        switch (str) {
            case "klevin":
                if (b(str2, "2.11.0.3") != 0) {
                    com.bytedance.msdk.d.u.b.c("TTMediationSDK_InitChecker", "klevin版本不符合, 要求版本等于2.11.0.3，当前是" + str2);
                    return false;
                }
                com.bytedance.msdk.d.u.b.d("TTMediationSDK_InitChecker", "klevin版本正常, 要求版本等于2.11.0.3，当前是" + str2);
                break;
            case "sigmob":
                if (b(str2, "4.22.2") != 0) {
                    com.bytedance.msdk.d.u.b.c("TTMediationSDK_InitChecker", "sigmob版本不符合, 要求版本等于4.22.2，当前是" + str2);
                    return false;
                }
                com.bytedance.msdk.d.u.b.d("TTMediationSDK_InitChecker", "sigmob版本正常, 要求版本等于4.22.2，当前是" + str2);
                break;
            case "xiaomi":
                if (b(str2, "2.11.0.3.31") != 0) {
                    com.bytedance.msdk.d.u.b.c("TTMediationSDK_InitChecker", "xiaomi版本不符合, 要求版本等于2.11.0.3.31，当前是" + str2);
                    return false;
                }
                com.bytedance.msdk.d.u.b.d("TTMediationSDK_InitChecker", "xiaomi版本正常, 要求版本等于2.11.0.3.31，当前是" + str2);
                break;
            case "ks":
                if (b(str2, "3.3.76.5") != 0) {
                    com.bytedance.msdk.d.u.b.c("TTMediationSDK_InitChecker", "快手版本不符合, 要求版本等于3.3.76.5，当前是" + str2);
                    return false;
                }
                com.bytedance.msdk.d.u.b.d("TTMediationSDK_InitChecker", "快手版本正常, 要求版本等于3.3.76.5，当前是" + str2);
                break;
            case "gdt":
                if (b(str2, "4.640.1510") != 0) {
                    com.bytedance.msdk.d.u.b.c("TTMediationSDK_InitChecker", "gdt版本不符合，要求等于4.640.1510，当前是" + str2);
                    return false;
                }
                com.bytedance.msdk.d.u.b.d("TTMediationSDK_InitChecker", "gdt版本正常，要求等于4.640.1510，当前是" + str2);
                break;
            case "unity":
                if (b(str2, "4.3.0") != 0) {
                    com.bytedance.msdk.d.u.b.c("TTMediationSDK_InitChecker", "unity版本不符合，要求等于4.3.0，当前是" + str2);
                    return false;
                }
                com.bytedance.msdk.d.u.b.d("TTMediationSDK_InitChecker", "unity版本正常，要求等于4.3.0，当前是" + str2);
                break;
            case "mintegral":
                if (!TextUtils.isEmpty(str2) && str2.contains("16.6.57")) {
                    com.bytedance.msdk.d.u.b.d("TTMediationSDK_InitChecker", "Mintegral版本正常, 要求版本等于16.6.57，当前是" + str2);
                    break;
                } else {
                    com.bytedance.msdk.d.u.b.c("TTMediationSDK_InitChecker", "Mintegral版本不符合, 要求版本等于16.6.57，当前是" + str2);
                    return false;
                }
                break;
            default:
                return false;
        }
        return true;
    }

    public static boolean hc(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        if (str.equals("pangle")) {
            return true;
        }
        str.hashCode();
        switch (str) {
            case "klevin":
                if (c("2.11.0.3", str2)) {
                    d("klevinAdapter", "2.11.0.3", str2);
                    break;
                } else {
                    hc("klevinAdapter", "2.11.0.3", str2);
                    return false;
                }
            case "sigmob":
                if (c("4.22.2", str2)) {
                    d("sigmobAdapter", "4.22.2", str2);
                    break;
                } else {
                    hc("sigmobAdapter", "4.22.2", str2);
                    return false;
                }
            case "xiaomi":
                if (c("2.11.0.3.31", str2)) {
                    d("xiaomiAdapter", "2.11.0.3.31", str2);
                    break;
                } else {
                    hc("xiaomiAdapter", "2.11.0.3.31", str2);
                    return false;
                }
            case "ks":
                if (u.b("ks") != null) {
                    return false;
                }
                if (c("3.3.76.5", str2)) {
                    d("ksAdapter", "3.3.76.5", str2);
                    break;
                } else {
                    hc("ksAdapter", "3.3.76.5", str2);
                    return false;
                }
            case "gdt":
                if (u.b("gdt") != null) {
                    return false;
                }
                if (c("4.640.1510", str2)) {
                    d("gdtAdapter", "4.640.1510", str2);
                    break;
                } else {
                    hc("gdtAdapter", "4.640.1510", str2);
                    return false;
                }
            case "admob":
                if (c("17.2.0", str2)) {
                    d("admobAdapter", "17.2.0", str2);
                    break;
                } else {
                    hc("admobAdapter", "17.2.0", str2);
                    return false;
                }
            case "baidu":
                if (c("9.3905", str2)) {
                    d("baiduAdapter", "9.3905", str2);
                    break;
                } else {
                    hc("baiduAdapter", "9.3905", str2);
                    return false;
                }
            case "unity":
                if (c("4.3.0", str2)) {
                    d("unityAdapter", "4.3.0", str2);
                    break;
                } else {
                    hc("unityAdapter", "4.3.0", str2);
                    return false;
                }
            case "mintegral":
                if (c("16.6.57", str2)) {
                    d("mtgAdapter", "16.6.57", str2);
                    break;
                } else {
                    hc("mtgAdapter", "16.6.57", str2);
                    return false;
                }
            default:
                return false;
        }
        return true;
    }

    private static void d(String str, String str2, String str3) {
        com.bytedance.msdk.d.u.b.d("TTMediationSDK_InitChecker", str + "接入版本正常, 要求版为：" + str2 + "，当前版本为：" + str3);
    }

    private static void hc(String str, String str2, String str3) {
        com.bytedance.msdk.d.u.b.c("TTMediationSDK_InitChecker", str + "接入版本不符合, 要求版为：" + str2 + ".x，当前版本为：" + str3);
    }

    private static boolean c(String str, String str2) {
        if (str == null || str2 == null || str.length() == 0 || str2.length() == 0 || str.length() > str2.length()) {
            return false;
        }
        if (str.startsWith("v") || str.startsWith(ExifInterface.GPS_MEASUREMENT_INTERRUPTED)) {
            str = str.substring(1);
        }
        if (str2.startsWith("v") || str2.startsWith(ExifInterface.GPS_MEASUREMENT_INTERRUPTED)) {
            str2 = str2.substring(1);
        }
        String[] strArrSplit = str.split("\\.");
        String[] strArrSplit2 = str2.split("\\.");
        for (int i = 0; i < strArrSplit.length; i++) {
            if (strArrSplit[i].length() == strArrSplit[i].length() && strArrSplit[i].compareTo(strArrSplit2[i]) != 0) {
                return false;
            }
        }
        return true;
    }
}
