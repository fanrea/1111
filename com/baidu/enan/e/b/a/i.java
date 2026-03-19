package com.baidu.enan.e.b.a;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.common.utility.DeviceUtils;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class i {
    public static String a(Context context) {
        String str;
        try {
            str = Build.MANUFACTURER;
        } catch (Throwable th) {
            com.baidu.enan.f.b.a(th);
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.equalsIgnoreCase("HUAWEI")) {
            return "EmotionUI";
        }
        if (str.equalsIgnoreCase("HONOR")) {
            return "MagicUI";
        }
        if (str.equalsIgnoreCase("XIAOMI")) {
            return System.getProperty("ro.miui.ui.version.name", DeviceUtils.ROM_MIUI);
        }
        if (str.equalsIgnoreCase(DeviceUtils.ROM_OPPO)) {
            return "ColorOS";
        }
        if (str.equalsIgnoreCase(DeviceUtils.ROM_VIVO)) {
            return System.getProperty("ro.vivo.os.name", "Funtouch");
        }
        if (str.equalsIgnoreCase("BBK")) {
            return "BBK";
        }
        if (str.equalsIgnoreCase("MEIZU")) {
            return System.getProperty("ro.build.user", "Flyme");
        }
        if (str.equalsIgnoreCase(DeviceUtils.ROM_SAMSUNG)) {
            return "SAMSUNG";
        }
        if (str.equalsIgnoreCase("GiONEE")) {
            return System.getProperty("ro.build.display.id", "Amigo");
        }
        if (!str.equalsIgnoreCase("ZTE")) {
            return (str.equalsIgnoreCase("LeMobile") || str.equalsIgnoreCase("Letv")) ? "EUI" : str.equalsIgnoreCase(DeviceUtils.ROM_LENOVO) ? DeviceUtils.ROM_LENOVO : str.equalsIgnoreCase("YuLong") ? "COOLUI" : str.equalsIgnoreCase("OnePlus") ? "H2OS" : str.equalsIgnoreCase("QiKU") ? DeviceUtils.ROM_QIKU : str.equalsIgnoreCase("nubia") ? System.getProperty("ro.build.nubia.rom.name", "NUBIAUI") : str.equalsIgnoreCase("motorola") ? "MOTOROLA" : str.equalsIgnoreCase("HTC") ? "HTC Sense" : str.equalsIgnoreCase("ZUK") ? "ZUI" : str.equalsIgnoreCase("coolpad") ? "COOLPAD" : str.equalsIgnoreCase("360") ? System.getProperty("ro.build.uiversion", "360") : str.equalsIgnoreCase("K-Touch") ? "KTOUCH" : str.equalsIgnoreCase("MeiTu") ? System.getProperty("ro.build.user", "MEITU") : str.equalsIgnoreCase("DOOV") ? System.getProperty("ro.fota.oem", "DOOV") : str.equalsIgnoreCase("TCL") ? "TCL" : str.equalsIgnoreCase("Yota Devices Limited") ? "Yota" : str.equalsIgnoreCase("lge") ? System.getProperty("ro.build.product", "LGE") : str.equalsIgnoreCase("hisense") ? "VISION" : str.equalsIgnoreCase("Changhong") ? "CHANGHONG" : str.equalsIgnoreCase("Sony") ? "Sony" : str.equalsIgnoreCase("smartisan") ? "smartisan" : str.equalsIgnoreCase("NM") ? "newman" : str.equalsIgnoreCase("REALME") ? "realmeUI" : str.equalsIgnoreCase("Google") ? "Google" : "";
        }
        String str2 = Build.MODEL;
        return (TextUtils.isEmpty(str2) || !str2.equalsIgnoreCase("X9180")) ? System.getProperty("ro.build.nubia.rom.name", "ZTE") : "Bliss";
    }
}
