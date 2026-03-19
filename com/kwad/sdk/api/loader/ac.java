package com.kwad.sdk.api.loader;

import android.os.Build;
import android.os.Process;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
final class ac {
    static boolean is64Bit() {
        if (Build.VERSION.SDK_INT >= 23) {
            return Process.is64Bit();
        }
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                return ((Boolean) ApiReflect.dE("dalvik.system.VMRuntime").dH("getRuntime").dH("is64Bit").get()).booleanValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static String PV() {
        return is64Bit() ? "arm64-v8a" : "armeabi-v7a";
    }
}
