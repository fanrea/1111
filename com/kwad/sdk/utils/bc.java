package com.kwad.sdk.utils;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.common.utility.DeviceUtils;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class bc {
    private static String cmQ;
    private static String cmR;

    public static boolean app() {
        return iB(DeviceUtils.ROM_EMUI);
    }

    public static boolean apq() {
        return iB(DeviceUtils.ROM_MIUI);
    }

    public static boolean anT() {
        return iB(DeviceUtils.ROM_VIVO);
    }

    public static boolean anS() {
        return iB(DeviceUtils.ROM_OPPO);
    }

    public static boolean apr() {
        return iB(DeviceUtils.ROM_FLYME);
    }

    public static String getName() {
        if (cmQ == null) {
            iB("");
        }
        return cmQ;
    }

    public static String getVersion() {
        if (cmR == null) {
            iB("");
        }
        return cmR;
    }

    private static boolean iB(String str) {
        String str2 = cmQ;
        if (str2 != null) {
            return str2.contains(str);
        }
        String str3 = br.get("ro.build.version.opporom");
        cmR = str3;
        if (!TextUtils.isEmpty(str3)) {
            cmQ = DeviceUtils.ROM_OPPO;
        } else {
            String str4 = br.get("ro.vivo.os.version");
            cmR = str4;
            if (!TextUtils.isEmpty(str4)) {
                cmQ = DeviceUtils.ROM_VIVO;
            } else {
                String str5 = br.get(com.alipay.sdk.m.c.a.a);
                cmR = str5;
                if (!TextUtils.isEmpty(str5)) {
                    cmQ = DeviceUtils.ROM_EMUI;
                } else {
                    String str6 = br.get("ro.miui.ui.version.name");
                    cmR = str6;
                    if (!TextUtils.isEmpty(str6)) {
                        cmQ = DeviceUtils.ROM_MIUI;
                    } else {
                        String str7 = br.get("ro.product.system.manufacturer");
                        cmR = str7;
                        if (!TextUtils.isEmpty(str7)) {
                            cmQ = "OnePlus";
                        } else {
                            String str8 = br.get("ro.smartisan.version");
                            cmR = str8;
                            if (!TextUtils.isEmpty(str8)) {
                                cmQ = DeviceUtils.ROM_SMARTISAN;
                            } else if (br.get("ro.product.manufacturer").toUpperCase().contains("SAMSUNG")) {
                                cmQ = "SAMSUNG";
                            } else {
                                String str9 = Build.DISPLAY;
                                cmR = str9;
                                if (str9.toUpperCase().contains(DeviceUtils.ROM_FLYME)) {
                                    cmQ = DeviceUtils.ROM_FLYME;
                                } else {
                                    cmR = "unknown";
                                    cmQ = Build.MANUFACTURER.toUpperCase();
                                }
                            }
                        }
                    }
                }
            }
        }
        return cmQ.contains(str);
    }
}
