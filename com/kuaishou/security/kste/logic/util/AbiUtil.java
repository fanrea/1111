package com.kuaishou.security.kste.logic.util;

import android.os.Build;
import android.text.TextUtils;
import com.kuaishou.security.kste.logic.base.KSTEConst;
import com.kuaishou.security.kste.logic.base.XRay;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class AbiUtil {
    private static Abi sCurrentAbi;

    public enum Abi {
        UNKNOWN,
        ARMEABI_V7A,
        ARM64_V8A
    }

    private AbiUtil() {
    }

    public static Abi getCurrentAbi() {
        if (Build.VERSION.SDK_INT < 21) {
            return Abi.ARMEABI_V7A;
        }
        Abi abi = sCurrentAbi;
        if (abi != null) {
            return abi;
        }
        if (!vmIs64BitHasBug()) {
            try {
                Abi abi2 = ((Boolean) JavaCalls.callMethod(JavaCalls.callStaticMethod("dalvik.system.VMRuntime", "getRuntime", new Object[0]), "is64Bit", new Object[0])).booleanValue() ? Abi.ARM64_V8A : Abi.ARMEABI_V7A;
                sCurrentAbi = abi2;
                return abi2;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        try {
            Abi abi3 = ((Integer) JavaCalls.callMethod(JavaCalls.callStaticMethod("sun.misc.Unsafe", "getUnsafe", new Object[0]), "addressSize", new Object[0])).intValue() == 8 ? Abi.ARM64_V8A : Abi.ARMEABI_V7A;
            sCurrentAbi = abi3;
            return abi3;
        } catch (Throwable th2) {
            th2.printStackTrace();
            try {
                if (XRay.get().getMInitParams().context().getApplicationInfo().nativeLibraryDir.contains("arm64")) {
                    Abi abi4 = Abi.ARM64_V8A;
                    sCurrentAbi = abi4;
                    return abi4;
                }
            } catch (Throwable th3) {
                th3.printStackTrace();
            }
            Abi abi5 = Abi.UNKNOWN;
            sCurrentAbi = abi5;
            return abi5;
        }
    }

    public static String getCurrentAbiName() {
        Abi currentAbi = getCurrentAbi();
        return currentAbi == Abi.ARM64_V8A ? KSTEConst.ABI_ARM64_V8A : currentAbi == Abi.ARMEABI_V7A ? KSTEConst.ABI_ARMEABI_V7A : "";
    }

    public static boolean isArm64() {
        return getCurrentAbi() == Abi.ARM64_V8A;
    }

    public static boolean isSupportArm64() {
        String[] strArrSupportedAbis;
        if (Build.VERSION.SDK_INT >= 21 && (strArrSupportedAbis = supportedAbis()) != null && strArrSupportedAbis.length > 0) {
            for (String str : strArrSupportedAbis) {
                if ("arm64-v8a".equals(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String[] supportedAbis() {
        if (Build.VERSION.SDK_INT >= 21) {
            String[] strArr = Build.SUPPORTED_ABIS;
            if (strArr.length > 0) {
                return strArr;
            }
        }
        String str = Build.CPU_ABI2;
        return !TextUtils.isEmpty(str) ? new String[]{Build.CPU_ABI, str} : new String[]{Build.CPU_ABI};
    }

    private static boolean vmIs64BitHasBug() {
        return RomUtils.isEmui() && Build.VERSION.SDK_INT == 28;
    }
}
