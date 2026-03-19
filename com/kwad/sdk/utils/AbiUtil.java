package com.kwad.sdk.utils;

import android.content.Context;
import android.os.Build;
import android.os.Process;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class AbiUtil {
    private static Abi ckT;

    public enum Abi {
        UNKNOWN,
        ARMEABI_V7A,
        ARM64_V8A
    }

    public static String cN(Context context) {
        return isArm64(context) ? "arm64-v8a" : "armeabi-v7a";
    }

    public static boolean isArm64(Context context) {
        return cO(context) == Abi.ARM64_V8A;
    }

    private static Abi cO(Context context) {
        Abi abi = ckT;
        if (abi != null) {
            return abi;
        }
        if (Build.VERSION.SDK_INT < 21) {
            ckT = Abi.ARMEABI_V7A;
        } else if (Build.VERSION.SDK_INT >= 23) {
            ckT = Process.is64Bit() ? Abi.ARM64_V8A : Abi.ARMEABI_V7A;
        } else if (Build.VERSION.SDK_INT >= 21) {
            try {
                ckT = ((Boolean) z.callMethod(z.a("dalvik.system.VMRuntime", "getRuntime", new Object[0]), "is64Bit", new Object[0])).booleanValue() ? Abi.ARM64_V8A : Abi.ARMEABI_V7A;
            } catch (Throwable th) {
                th.printStackTrace();
                try {
                    if (context.getApplicationInfo().nativeLibraryDir.contains("arm64")) {
                        ckT = Abi.ARM64_V8A;
                    } else {
                        ckT = Abi.UNKNOWN;
                    }
                } catch (Throwable th2) {
                    th2.printStackTrace();
                    ckT = Abi.UNKNOWN;
                }
            }
        }
        return ckT;
    }
}
