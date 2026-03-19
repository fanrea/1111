package com.fendasz.moku.planet.utils;

import android.os.Build;
import android.util.Log;
import com.bytedance.common.utility.DeviceUtils;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class OSUtil {
    private static final String KEY_COLOROS_VERSION_NAME = "ro.build.version.opporom";
    private static final String KEY_EMUI_VERSION_NAME = "ro.build.version.emui";
    private static final String KEY_FLYME_VERSION_NAME = "ro.build.display.id";
    private static final String KEY_HARMONYOS_VERSION_NAME = "hw_sc.build.platform.version";
    private static final String KEY_MAGICUI_VERSION = "ro.build.version.magic";
    private static final String KEY_MIUI_VERSION_NAME = "ro.miui.ui.version.name";
    private static final String KEY_NUBIA_VERSION_CODE = "ro.build.nubia.rom.code";
    private static final String KEY_NUBIA_VERSION_NAME = "ro.build.nubia.rom.name";
    private static final String KEY_ONEPLUS_VERSION_NAME = "ro.rom.version";
    private static final String KEY_VIVO_VERSION = "ro.vivo.os.version";
    private static final String KEY_VIVO_VERSION_NAME = "ro.vivo.os.name";
    private static final String TAG = "OSUtil==>";
    private static String customOS = "";
    private static String customOSVersion = "";

    private static boolean isMagicUI() {
        return false;
    }

    public static String getBrandName() {
        return Build.BRAND;
    }

    private static String getSystemPropertyValue(String str) throws NoSuchMethodException, ClassNotFoundException, SecurityException {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            Object[] objArr = {str};
            String str2 = (String) cls.getDeclaredMethod("get", String.class).invoke(cls, objArr);
            for (int i = 0; i < 1; i++) {
                Log.d(TAG, "getSystemPropertyValue=>" + objArr[i].toString());
            }
            Log.d(TAG, "VALUE=>" + str2);
            return str2;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean isHarmonyOS() {
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            return "Harmony".equalsIgnoreCase(cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0]).toString());
        } catch (Throwable unused) {
            LogUtils.logE(TAG, "isHarmonyOs exception");
            return false;
        }
    }

    public static String getHarmonySystemPropertyValue() throws ClassNotFoundException {
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            return (String) cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0]);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getPhoneSystem(String str) {
        if (StringUtils.isEmpty(customOS)) {
            setCustomOSInfo(str);
        }
        return customOS + customOSVersion;
    }

    public static String getCustomOS(String str) {
        if (StringUtils.isEmpty(customOS)) {
            setCustomOSInfo(str);
        }
        return customOS;
    }

    public static String getCustomOSVersion(String str) {
        if (StringUtils.isEmpty(customOS)) {
            setCustomOSInfo(str);
        }
        return customOSVersion;
    }

    private static String deleteSpaceAndToUpperCase(String str) {
        return StringUtils.isEmpty(str) ? "" : str.replaceAll(" ", "").toUpperCase();
    }

    private static void setCustomOSInfo(String str) {
        try {
            String strDeleteSpaceAndToUpperCase = deleteSpaceAndToUpperCase(str);
            Log.d(TAG, "setCustomOSInfo=>" + strDeleteSpaceAndToUpperCase);
            switch (strDeleteSpaceAndToUpperCase) {
                case "HUAWEI":
                    if (isHarmonyOS()) {
                        customOSVersion = getSystemPropertyValue("hw_sc.build.platform.version");
                        customOS = "HarmonyOS";
                        break;
                    } else {
                        customOS = DeviceUtils.ROM_EMUI;
                        customOSVersion = getSystemPropertyValue("ro.build.version.emui");
                        break;
                    }
                case "HONOR":
                    if (isHarmonyOS()) {
                        customOS = "HarmonyOS";
                        if (!StringUtils.isEmpty(getSystemPropertyValue("hw_sc.build.platform.version"))) {
                            customOSVersion = getSystemPropertyValue("hw_sc.build.platform.version");
                            break;
                        } else {
                            customOSVersion = "";
                            break;
                        }
                    } else if (!StringUtils.isEmpty(getSystemPropertyValue(KEY_MAGICUI_VERSION))) {
                        customOS = "MagicUI";
                        customOSVersion = getSystemPropertyValue(KEY_MAGICUI_VERSION);
                        break;
                    } else {
                        customOS = DeviceUtils.ROM_EMUI;
                        customOSVersion = getSystemPropertyValue("ro.build.version.emui");
                        break;
                    }
                case "XIAOMI":
                case "REDMI":
                    customOS = DeviceUtils.ROM_MIUI;
                    customOSVersion = getSystemPropertyValue(KEY_MIUI_VERSION_NAME);
                    break;
                case "REALME":
                case "OPPO":
                    customOS = "ColorOS";
                    customOSVersion = getSystemPropertyValue(KEY_COLOROS_VERSION_NAME);
                    break;
                case "VIVO":
                    customOS = "Funtouch";
                    customOSVersion = getSystemPropertyValue(KEY_VIVO_VERSION);
                    break;
                case "ONEPLUS":
                    customOS = "HydrogenOS";
                    customOSVersion = getSystemPropertyValue(KEY_ONEPLUS_VERSION_NAME);
                    break;
                case "MEIZU":
                    customOS = "Flyme";
                    customOSVersion = getSystemPropertyValue(KEY_FLYME_VERSION_NAME);
                    break;
                case "NUBIA":
                    customOS = getSystemPropertyValue(KEY_NUBIA_VERSION_NAME);
                    customOSVersion = getSystemPropertyValue(KEY_NUBIA_VERSION_CODE);
                    break;
                default:
                    customOS = "Android";
                    customOSVersion = Build.VERSION.RELEASE;
                    break;
            }
        } catch (Exception unused) {
            LogUtils.logE(TAG, "get phone os error");
        }
    }
}
