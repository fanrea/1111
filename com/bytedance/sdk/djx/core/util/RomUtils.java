package com.bytedance.sdk.djx.core.util;

import android.os.Build;
import android.text.TextUtils;
import com.alipay.sdk.m.c.a;
import com.bytedance.sdk.djx.utils.IOUtil;
import com.bytedance.sdk.djx.utils.LG;
import com.bytedance.sdk.djx.utils.SP;
import com.bytedance.sdk.djx.utils.thread.TTExecutor;
import com.bytedance.sdk.djx.utils.thread.TTFutureTask;
import com.bytedance.sdk.djx.utils.thread.TTRunnable;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.InputStreamReader;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class RomUtils {
    private static final String COLOROS = "coloros";
    private static final String EMUI = "emotionui";
    private static final String EUI = "eui";
    private static final String FLYME = "flyme";
    private static final String FOUTOUCH_OS_SOFTWARE_VERSION = "ro.vivo.product.version";
    private static final String FUNTOUCH_OS_VERSION = "ro.vivo.os.build.display.id";
    private static final int GET_PROPERTY_TIMEOUT = 1;
    private static final String KEY_360OS = "ro.build.uiversion";
    private static final String MIUI = "miui";
    private static final String MODEL_LETV = "ro.letv.release.version";
    private static final String RUNTIME_MIUI = "ro.miui.ui.version.name";
    private static final String RUNTIME_OPPO = "ro.build.version.opporom";
    private static final String RUNTIME_SMARTISAN = "ro.smartisan.version";
    private static final String SEPARATOR = "_";
    private static final String SMARTISAN = "smartisan";
    private static final String SP_KEY_ROM_PROPERTY_INFO = "rom_info";
    private static final String TAG = "RomUtils";
    public static boolean sIsInited = false;
    public static boolean sIsMiui = false;
    private static final CharSequence SONY = "sony";
    private static final CharSequence AMIGO = "amigo";
    private static final CharSequence FUNTOUCHOS = "funtouch";

    public static boolean isOnePlus() {
        try {
            return Build.MANUFACTURER.trim().toLowerCase().contains("oneplus");
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String getRomInfo() {
        if (isSmartisan()) {
            return getSmartisanOSVersion();
        }
        if (isMiui()) {
            return getMIUIVersion();
        }
        if (isFlyme()) {
            return getFlymeVersion();
        }
        if (isColorOS()) {
            return getColorOsVersion();
        }
        String eMUVersion = getEMUVersion();
        if (!TextUtils.isEmpty(eMUVersion)) {
            return eMUVersion;
        }
        if (isFunTouchOS()) {
            return getFuntouchOSVersion();
        }
        if (isAmigo()) {
            return getAmigoVersion();
        }
        if (is360OS()) {
            return get360OSVersion();
        }
        String eUIVersion = getEUIVersion();
        return !TextUtils.isEmpty(eUIVersion) ? eUIVersion : Build.DISPLAY;
    }

    public static boolean isFlyme() {
        return Build.DISPLAY.contains("Flyme") || Build.USER.equals(FLYME);
    }

    public static String get360OSVersion() {
        return getSystemPropertyTask(KEY_360OS) + "_" + Build.DISPLAY;
    }

    public static boolean is360OS() {
        String str = Build.MANUFACTURER + Build.BRAND;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        return lowerCase.contains("360") || lowerCase.contains("qiku");
    }

    public static boolean isMiui() {
        if (!sIsInited) {
            try {
                if (Class.forName("miui.os.Build") != null) {
                    sIsMiui = true;
                    sIsInited = true;
                    return true;
                }
            } catch (Exception unused) {
            }
            sIsInited = true;
        }
        return sIsMiui;
    }

    public static String getFuntouchOSVersion() {
        return getSystemPropertyTask(FUNTOUCH_OS_VERSION) + "_" + getSystemPropertyTask(FOUTOUCH_OS_SOFTWARE_VERSION);
    }

    public static boolean isFunTouchOS() {
        String systemPropertyTask = getSystemPropertyTask(FUNTOUCH_OS_VERSION);
        return !TextUtils.isEmpty(systemPropertyTask) && systemPropertyTask.toLowerCase().contains(FUNTOUCHOS);
    }

    public static boolean isAmigo() {
        return !TextUtils.isEmpty(Build.DISPLAY) && Build.DISPLAY.toLowerCase().contains(AMIGO);
    }

    public static String getAmigoVersion() {
        return Build.DISPLAY + "_" + getSystemPropertyTask("ro.gn.sv.version");
    }

    public static String getEUIVersion() {
        return isEUI() ? "eui_" + getSystemPropertyTask(MODEL_LETV) + "_" + Build.DISPLAY : "";
    }

    public static boolean isEUI() {
        return !TextUtils.isEmpty(getSystemPropertyTask(MODEL_LETV));
    }

    public static boolean isSony() {
        String str = Build.BRAND + Build.MANUFACTURER;
        return !TextUtils.isEmpty(str) || str.toLowerCase().contains(SONY);
    }

    public static String getMIUIVersion() {
        return isMiui() ? "miui_" + getSystemPropertyTask(RUNTIME_MIUI) + "_" + Build.VERSION.INCREMENTAL : "";
    }

    public static String getEMUVersion() {
        String emuiInfo = getEmuiInfo();
        return (emuiInfo == null || !emuiInfo.toLowerCase().contains(EMUI)) ? "" : emuiInfo + "_" + Build.DISPLAY;
    }

    public static String getEmuiInfo() {
        return getSystemPropertyTask(a.a);
    }

    public static boolean isSmartisan() {
        return SMARTISAN.equalsIgnoreCase(Build.MANUFACTURER) || SMARTISAN.equalsIgnoreCase(Build.BRAND);
    }

    public static String getSmartisanOSVersion() {
        if (isSmartisan()) {
            try {
                return "smartisan_" + getSystemPropertyTask(RUNTIME_SMARTISAN);
            } catch (Throwable unused) {
            }
        }
        return Build.DISPLAY;
    }

    public static String getFlymeVersion() {
        String str = Build.DISPLAY;
        return (str == null || !str.toLowerCase().contains(FLYME)) ? "" : str;
    }

    public static boolean isColorOS() {
        String str = Build.MANUFACTURER;
        return !TextUtils.isEmpty(str) && str.toLowerCase().contains("oppo");
    }

    public static String getColorOsVersion() {
        return isColorOS() ? "coloros_" + getSystemPropertyTask(RUNTIME_OPPO) + "_" + Build.DISPLAY : "";
    }

    public static boolean isHuaweiDevice() {
        try {
            if (TextUtils.isEmpty(Build.BRAND) || !Build.BRAND.toLowerCase().startsWith("huawei")) {
                if (TextUtils.isEmpty(Build.MANUFACTURER)) {
                    return false;
                }
                if (!Build.MANUFACTURER.toLowerCase().startsWith("huawei")) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean isEmui(String str) {
        if (TextUtils.isEmpty(str)) {
            str = getEmuiInfo();
        }
        return (!TextUtils.isEmpty(str) && str.toLowerCase().startsWith(EMUI)) || isHuaweiDevice();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getSystemProperty(String str) {
        BufferedReader bufferedReader;
        Throwable th;
        String line = "";
        try {
            Process processExec = Runtime.getRuntime().exec("getprop " + str);
            bufferedReader = new BufferedReader(new InputStreamReader(processExec.getInputStream()), 1024);
            try {
                line = bufferedReader.readLine();
                processExec.destroy();
                IOUtil.closeIOQuietly(new Closeable[]{bufferedReader});
                return line;
            } catch (Throwable th2) {
                th = th2;
                try {
                    LG.e(TAG, "Unable to read sysprop " + str, th);
                    IOUtil.closeIOQuietly(new Closeable[]{bufferedReader});
                    return line;
                } catch (Throwable th3) {
                    IOUtil.closeIOQuietly(new Closeable[]{bufferedReader});
                    throw th3;
                }
            }
        } catch (Throwable th4) {
            bufferedReader = null;
            th = th4;
        }
    }

    private static String getSystemPropertyTask(String str) {
        String propertyFromSp;
        try {
            propertyFromSp = getPropertyFromSp();
            try {
                if (TextUtils.isEmpty(propertyFromSp)) {
                    final TTFutureTask tTFutureTask = new TTFutureTask(new GetSystemPropertyTask(str), 5, 1);
                    TTExecutor.get().executeDefaultTask(new TTRunnable() { // from class: com.bytedance.sdk.djx.core.util.RomUtils.1
                        public void run() {
                            tTFutureTask.run();
                        }
                    });
                    propertyFromSp = (String) tTFutureTask.get(1L, TimeUnit.SECONDS);
                }
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            propertyFromSp = "";
        }
        return propertyFromSp == null ? "" : propertyFromSp;
    }

    public static class GetSystemPropertyTask implements Callable<String> {
        private String mPropName;

        public GetSystemPropertyTask(String str) {
            this.mPropName = str;
        }

        @Override // java.util.concurrent.Callable
        public String call() throws Exception {
            long jCurrentTimeMillis = System.currentTimeMillis();
            String systemProperty = RomUtils.getSystemProperty(this.mPropName);
            LG.d(RomUtils.TAG, "property:" + systemProperty + ",getSystemProperty use time :" + (System.currentTimeMillis() - jCurrentTimeMillis));
            if (!TextUtils.isEmpty(systemProperty)) {
                try {
                    LG.w(RomUtils.TAG, "SP-getPropertyFromSP:" + systemProperty);
                    SP.rom().put(RomUtils.SP_KEY_ROM_PROPERTY_INFO, systemProperty);
                } catch (Throwable unused) {
                }
            }
            return systemProperty;
        }
    }

    private static String getPropertyFromSp() {
        try {
            String string = SP.rom().getString(SP_KEY_ROM_PROPERTY_INFO, "");
            LG.i(TAG, "get Property From SP...=" + string);
            return string;
        } catch (Throwable unused) {
            return "";
        }
    }
}
