package com.ss.android.socialbase.appdownloader.an;

import android.os.Build;
import android.text.TextUtils;
import com.alipay.sdk.m.c.a;
import com.baidu.mobstat.forbes.Config;
import com.bytedance.common.utility.DeviceUtils;
import com.bytedance.sdk.component.utils.mq;
import com.ss.android.socialbase.appdownloader.h;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class u {
    private static String an = null;
    public static String b = null;
    private static String c = "";
    public static String d = null;
    private static Boolean gb = null;
    private static String h = null;
    public static String hc = "";
    private static String u;

    public static boolean d() {
        return d(DeviceUtils.ROM_EMUI) || d("MAGICUI");
    }

    public static boolean hc() {
        return d("MAGICUI");
    }

    public static boolean b() {
        return d(DeviceUtils.ROM_MIUI);
    }

    public static boolean c() {
        return d(DeviceUtils.ROM_VIVO);
    }

    public static boolean u() {
        yo();
        return d(d);
    }

    public static boolean an() {
        return d(DeviceUtils.ROM_FLYME);
    }

    public static boolean h() {
        return d("SAMSUNG");
    }

    public static String gb() {
        if (u == null) {
            d("");
        }
        return u;
    }

    public static String tt() {
        if (an == null) {
            d("");
        }
        return an;
    }

    public static String tc() {
        if (b == null) {
            d("");
        }
        return b;
    }

    private static void yo() {
        if (TextUtils.isEmpty(d)) {
            com.ss.android.socialbase.downloader.downloader.b.z();
            d = com.ss.android.socialbase.downloader.hc.u.hc;
            c = "ro.build.version." + com.ss.android.socialbase.downloader.hc.u.b + Config.ROM;
            hc = "com." + com.ss.android.socialbase.downloader.hc.u.b + ".market";
        }
    }

    public static boolean d(String str) {
        yo();
        String str2 = u;
        if (str2 != null) {
            return str2.equals(str);
        }
        String strC = c("ro.miui.ui.version.name");
        an = strC;
        if (!TextUtils.isEmpty(strC)) {
            u = DeviceUtils.ROM_MIUI;
            b = "com.xiaomi.market";
            h = an;
        } else {
            String strC2 = c(a.a);
            an = strC2;
            if (!TextUtils.isEmpty(strC2)) {
                String str3 = w() ? "MAGICUI" : DeviceUtils.ROM_EMUI;
                u = str3;
                if (TextUtils.equals(str3, "MAGICUI")) {
                    b = "com.hihonor.appmarket";
                } else {
                    b = "com.huawei.appmarket";
                }
            } else {
                String strC3 = c("ro.build.version.magic");
                an = strC3;
                if (!TextUtils.isEmpty(strC3)) {
                    u = "MAGICUI";
                    b = "com.hihonor.appmarket";
                } else {
                    String strC4 = c(c);
                    an = strC4;
                    if (!TextUtils.isEmpty(strC4)) {
                        u = d;
                        if (h.d(hc) >= 0) {
                            b = hc;
                        } else {
                            b = "com.heytap.market";
                        }
                    } else {
                        String strC5 = c("ro.vivo.os.version");
                        an = strC5;
                        if (!TextUtils.isEmpty(strC5)) {
                            u = DeviceUtils.ROM_VIVO;
                            b = "com.bbk.appstore";
                        } else {
                            String strC6 = c("ro.smartisan.version");
                            an = strC6;
                            if (!TextUtils.isEmpty(strC6)) {
                                u = DeviceUtils.ROM_SMARTISAN;
                                b = "com.smartisanos.appstore";
                            } else {
                                String strC7 = c("ro.gn.sv.version");
                                an = strC7;
                                if (!TextUtils.isEmpty(strC7)) {
                                    u = DeviceUtils.ROM_GIONEE;
                                    b = "com.gionee.aora.market";
                                } else {
                                    String strC8 = c("ro.lenovo.lvp.version");
                                    an = strC8;
                                    if (!TextUtils.isEmpty(strC8)) {
                                        u = DeviceUtils.ROM_LENOVO;
                                        b = "com.lenovo.leos.appstore";
                                    } else if (mk().toUpperCase().contains("SAMSUNG")) {
                                        u = "SAMSUNG";
                                        b = "com.sec.android.app.samsungapps";
                                    } else if (mk().toUpperCase().contains("ZTE")) {
                                        u = "ZTE";
                                        b = "zte.com.market";
                                    } else if (mk().toUpperCase().contains("NUBIA")) {
                                        u = "NUBIA";
                                        b = "cn.nubia.neostore";
                                    } else if (mq().toUpperCase().contains(DeviceUtils.ROM_FLYME)) {
                                        u = DeviceUtils.ROM_FLYME;
                                        b = "com.meizu.mstore";
                                        an = mq();
                                    } else if (mk().toUpperCase().contains("ONEPLUS")) {
                                        u = "ONEPLUS";
                                        an = c("ro.rom.version");
                                        if (h.d(hc) >= 0) {
                                            b = hc;
                                        } else {
                                            b = "com.heytap.market";
                                        }
                                    } else {
                                        u = mk().toUpperCase();
                                        b = "";
                                        an = "";
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return u.equals(str);
    }

    public static String hc(String str) {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop ".concat(String.valueOf(str))).getInputStream()), 1024);
            try {
                String line = bufferedReader.readLine();
                bufferedReader.close();
                com.ss.android.socialbase.downloader.e.an.d(bufferedReader);
                return line;
            } catch (Throwable unused) {
                com.ss.android.socialbase.downloader.e.an.d(bufferedReader);
                return null;
            }
        } catch (Throwable unused2) {
            bufferedReader = null;
        }
    }

    public static String b(String str) throws Throwable {
        return (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, str);
    }

    public static String c(String str) {
        if (com.ss.android.socialbase.downloader.uo.d.hc().optBoolean("enable_reflect_system_properties", true)) {
            try {
                return b(str);
            } catch (Throwable th) {
                mq.d(th);
            }
        }
        return hc(str);
    }

    public static String mk() {
        return Build.MANUFACTURER == null ? "" : Build.MANUFACTURER.trim();
    }

    public static String mq() {
        return Build.DISPLAY == null ? "" : Build.DISPLAY.trim();
    }

    public static boolean uo() {
        rf();
        return "V10".equals(h);
    }

    public static boolean k() {
        rf();
        return "V11".equals(h);
    }

    public static boolean e() {
        rf();
        return "V12".equals(h);
    }

    private static void rf() {
        if (h == null) {
            try {
                h = c("ro.miui.ui.version.name");
            } catch (Exception e) {
                mq.d(e);
            }
            String str = h;
            if (str == null) {
                str = "";
            }
            h = str;
        }
    }

    public static boolean cb() {
        if (gb == null) {
            gb = Boolean.valueOf(c.h().equals("harmony"));
        }
        return gb.booleanValue();
    }

    public static boolean w() {
        if (TextUtils.isEmpty(Build.BRAND) || !Build.BRAND.toLowerCase().startsWith("honor")) {
            return !TextUtils.isEmpty(Build.MANUFACTURER) && Build.MANUFACTURER.toLowerCase().startsWith("honor");
        }
        return true;
    }
}
