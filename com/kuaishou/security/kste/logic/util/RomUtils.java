package com.kuaishou.security.kste.logic.util;

import android.os.Build;
import android.text.TextUtils;
import java.lang.reflect.InvocationTargetException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class RomUtils {
    private static final String KEY_VERSION_EMUI = "ro.build.version.emui";
    private static final String KEY_VERSION_MIUI = "ro.miui.ui.version.name";
    private static final String KEY_VERSION_ONEPLUS = "ro.product.system.manufacturer";
    private static final String KEY_VERSION_OPPO = "ro.build.version.opporom";
    private static final String KEY_VERSION_SAMSUNG = "ro.product.manufacturer";
    private static final String KEY_VERSION_SMARTISAN = "ro.smartisan.version";
    private static final String KEY_VERSION_VIVO = "ro.vivo.os.version";
    private static final String PATTERN_EMOTIONUI = "EmotionUI";
    private static final String PATTERN_MAGICUI = "MagicUI";
    private static final String ROM_360 = "360";
    private static final String ROM_EMOTION = "EMOTION";
    private static final String ROM_EMUI = "EMUI";
    private static final String ROM_FLYME = "FLYME";
    private static final String ROM_MAGIC = "MAGIC";
    private static final String ROM_MIUI = "MIUI";
    private static final String ROM_ONEPLUS = "OnePlus";
    private static final String ROM_OPPO = "OPPO";
    private static final String ROM_QIKU = "QIKU";
    private static final String ROM_SAMSUNG = "SAMSUNG";
    private static final String ROM_SMARTISAN = "SMARTISAN";
    private static final String ROM_VIVO = "VIVO";
    private static String sName;
    private static String sVersion;

    class SystemProperties {
        SystemProperties() {
        }

        public static String get(String str) throws ClassNotFoundException {
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                return (String) cls.getDeclaredMethod("get", String.class).invoke(cls, str);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                return null;
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
                return null;
            } catch (NoSuchMethodException e3) {
                e3.printStackTrace();
                return null;
            } catch (InvocationTargetException e4) {
                e4.printStackTrace();
                return null;
            }
        }
    }

    public static boolean check(String str) throws ClassNotFoundException {
        if (sName == null) {
            setRomInfo();
        }
        return ((str.equals(ROM_EMOTION) || str.equals(ROM_MAGIC)) ? getRealName(getProp("ro.build.version.emui")) : sName).equals(str);
    }

    public static void clearCache() {
        sName = null;
    }

    public static String getName() throws ClassNotFoundException {
        if (sName == null) {
            setRomInfo();
        }
        return sName;
    }

    public static String getName2() throws ClassNotFoundException {
        if (sName == null) {
            setRomInfo();
        }
        return getRealName(getProp("ro.build.version.emui"));
    }

    public static String getProp(String str) throws ClassNotFoundException {
        String str2 = SystemProperties.get(str);
        return str2 == null ? "" : str2;
    }

    private static String getRealName(String str) {
        String str2 = sName;
        return str2 == null ? "" : !str2.equals("EMUI") ? sName : str.contains(PATTERN_EMOTIONUI) ? ROM_EMOTION : str.contains(PATTERN_MAGICUI) ? ROM_MAGIC : sName;
    }

    public static String getVersion() throws ClassNotFoundException {
        if (sVersion == null) {
            setRomInfo();
        }
        return sVersion;
    }

    public static boolean is360() {
        return check("QIKU") || check(ROM_360);
    }

    public static boolean isEmotion() {
        return check(ROM_EMOTION);
    }

    public static boolean isEmui() {
        return check("EMUI") || isEmotion() || isMagic();
    }

    public static boolean isFlyme() {
        return check("FLYME");
    }

    public static boolean isM5() {
        try {
            return Build.MODEL.toUpperCase().contains("M5");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean isMagic() {
        return check(ROM_MAGIC);
    }

    public static boolean isMeitu() {
        try {
            return Build.MANUFACTURER.toUpperCase().contains("MEITU");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean isMiui() {
        return check("MIUI");
    }

    public static boolean isOnePlus() {
        return check(ROM_ONEPLUS);
    }

    public static boolean isOppo() {
        return check("OPPO");
    }

    public static boolean isSamsung() {
        return check(ROM_SAMSUNG);
    }

    public static boolean isSmartisan() {
        return check("SMARTISAN");
    }

    public static boolean isVivo() {
        return check("VIVO");
    }

    private static void setRomInfo() throws ClassNotFoundException {
        String upperCase;
        String prop = getProp(KEY_VERSION_OPPO);
        sVersion = prop;
        if (TextUtils.isEmpty(prop)) {
            String prop2 = getProp(KEY_VERSION_VIVO);
            sVersion = prop2;
            if (TextUtils.isEmpty(prop2)) {
                String prop3 = getProp("ro.build.version.emui");
                sVersion = prop3;
                if (TextUtils.isEmpty(prop3)) {
                    String prop4 = getProp(KEY_VERSION_MIUI);
                    sVersion = prop4;
                    if (TextUtils.isEmpty(prop4)) {
                        String prop5 = getProp(KEY_VERSION_ONEPLUS);
                        sVersion = prop5;
                        if (TextUtils.isEmpty(prop5)) {
                            String prop6 = getProp(KEY_VERSION_SMARTISAN);
                            sVersion = prop6;
                            if (!TextUtils.isEmpty(prop6)) {
                                upperCase = "SMARTISAN";
                            } else {
                                if (getProp(KEY_VERSION_SAMSUNG).toUpperCase().contains(ROM_SAMSUNG)) {
                                    sName = ROM_SAMSUNG;
                                    return;
                                }
                                String str = Build.DISPLAY;
                                sVersion = str;
                                if (str.toUpperCase().contains("FLYME")) {
                                    sName = "FLYME";
                                    return;
                                } else {
                                    sVersion = "unknown";
                                    upperCase = Build.MANUFACTURER.toUpperCase();
                                }
                            }
                        } else {
                            upperCase = ROM_ONEPLUS;
                        }
                    } else {
                        upperCase = "MIUI";
                    }
                } else {
                    upperCase = "EMUI";
                }
            } else {
                upperCase = "VIVO";
            }
        } else {
            upperCase = "OPPO";
        }
        sName = upperCase;
    }
}
