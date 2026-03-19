package com.snail.antifake.jni;

import android.content.Context;
import com.snail.antifake.deviceid.AndroidDeviceIMEIUtil;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class EmulatorDetectUtil {

    public interface Arch {
        public static final int ARM32 = 2;
        public static final int ARM64 = 3;
        public static final int X86 = 0;
        public static final int X86_64 = 1;
    }

    public static native boolean detectS();

    static {
        System.loadLibrary("emulator_check");
    }

    public static boolean isEmulator(Context context) {
        return detectS();
    }

    public static boolean isEmulatorFromAll(Context context) {
        return AndroidDeviceIMEIUtil.isRunOnEmulator(context) || detectS();
    }

    public static int getSystemArch() {
        String string = PropertiesGet.getString("ro.product.cpu.abi");
        if ("armeabi-v7a".equals(string)) {
            return 2;
        }
        if ("arm64-v8a".equals(string)) {
            return 3;
        }
        if ("x86".equals(string)) {
            return 0;
        }
        return "x86_64".equals(string) ? 1 : 3;
    }
}
