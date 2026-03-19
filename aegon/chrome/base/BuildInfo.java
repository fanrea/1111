package aegon.chrome.base;

import aegon.chrome.base.compat.ApiHelperForP;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class BuildInfo {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int MAX_FINGERPRINT_LENGTH = 128;
    private static final String TAG = "BuildInfo";
    private static PackageInfo sBrowserPackageInfo = null;
    private static String sFirebaseAppId = "";
    private static boolean sInitialized;
    public final String abiString;
    public final String androidBuildFingerprint;
    public final String customThemes;
    public final String extractedFileSuffix;
    public final String gmsVersionCode;
    public final String hostPackageLabel;
    public final long hostVersionCode;
    public final String installerPackageName;
    public final String packageName;
    public final String resourcesVersion;
    public final long versionCode;
    public final String versionName;

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    static class Holder {
        private static BuildInfo sInstance = new BuildInfo();

        private Holder() {
        }
    }

    private static String[] getAll() {
        BuildInfo buildInfo = getInstance();
        String[] strArr = new String[24];
        strArr[0] = Build.BRAND;
        strArr[1] = Build.DEVICE;
        strArr[2] = Build.ID;
        strArr[3] = Build.MANUFACTURER;
        strArr[4] = Build.MODEL;
        strArr[5] = String.valueOf(Build.VERSION.SDK_INT);
        strArr[6] = Build.TYPE;
        strArr[7] = Build.BOARD;
        strArr[8] = "";
        strArr[9] = String.valueOf(buildInfo.hostVersionCode);
        strArr[10] = buildInfo.hostPackageLabel;
        strArr[11] = buildInfo.packageName;
        strArr[12] = String.valueOf(buildInfo.versionCode);
        strArr[13] = buildInfo.versionName;
        strArr[14] = buildInfo.androidBuildFingerprint;
        strArr[15] = buildInfo.gmsVersionCode;
        strArr[16] = buildInfo.installerPackageName;
        strArr[17] = buildInfo.abiString;
        strArr[18] = sFirebaseAppId;
        strArr[19] = buildInfo.customThemes;
        strArr[20] = buildInfo.resourcesVersion;
        strArr[21] = buildInfo.extractedFileSuffix;
        strArr[22] = isAtLeastQ() ? "1" : "0";
        strArr[23] = isDebugAndroid() ? "1" : "0";
        return strArr;
    }

    private static String nullToEmpty(CharSequence charSequence) {
        return charSequence == null ? "" : charSequence.toString();
    }

    private static long packageVersionCode(PackageInfo packageInfo) {
        if (Build.VERSION.SDK_INT >= 28) {
            return ApiHelperForP.getLongVersionCode(packageInfo);
        }
        return packageInfo.versionCode;
    }

    public static void setBrowserPackageInfo(PackageInfo packageInfo) {
        sBrowserPackageInfo = packageInfo;
    }

    public static BuildInfo getInstance() {
        return Holder.sInstance;
    }

    private BuildInfo() {
        String string;
        sInitialized = true;
        this.hostVersionCode = 0L;
        this.versionCode = 0L;
        this.versionName = "";
        this.packageName = "";
        this.hostPackageLabel = "";
        this.installerPackageName = "";
        this.gmsVersionCode = "gms versionCode not available.";
        this.customThemes = "false";
        this.extractedFileSuffix = "";
        if (BuildConfig.R_STRING_PRODUCT_VERSION != 0) {
            try {
                string = ContextUtils.getApplicationContext().getString(BuildConfig.R_STRING_PRODUCT_VERSION);
            } catch (Exception unused) {
                string = "Not found";
            }
        } else {
            string = "Not Enabled";
        }
        this.resourcesVersion = string;
        if (Build.VERSION.SDK_INT >= 21) {
            this.abiString = TextUtils.join(", ", Build.SUPPORTED_ABIS);
        } else {
            this.abiString = String.format("ABI1: %s, ABI2: %s", Build.CPU_ABI, Build.CPU_ABI2);
        }
        this.androidBuildFingerprint = Build.FINGERPRINT.substring(0, Math.min(Build.FINGERPRINT.length(), 128));
    }

    public static boolean isDebugAndroid() {
        return "eng".equals(Build.TYPE) || "userdebug".equals(Build.TYPE);
    }

    public static boolean isAtLeastQ() {
        return Build.VERSION.SDK_INT >= 29;
    }

    public static boolean targetsAtLeastQ() {
        return ContextUtils.getApplicationContext().getApplicationInfo().targetSdkVersion >= 29;
    }

    public static void setFirebaseAppId(String str) {
        sFirebaseAppId = str;
    }

    public static String getFirebaseAppId() {
        return sFirebaseAppId;
    }
}
