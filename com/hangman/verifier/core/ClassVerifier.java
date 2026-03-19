package com.hangman.verifier.core;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.hangman.verifier.Verifier;
import com.hangman.verifier.utils.DeviceInfoUtils;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class ClassVerifier {
    public static int a;
    public static int b;
    public static final AtomicBoolean c = new AtomicBoolean(false);

    public static void a(Context context) {
        if (DeviceInfoUtils.b() || DeviceInfoUtils.c() || !c.compareAndSet(false, true)) {
            return;
        }
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        a = Build.VERSION.SDK_INT;
        b = applicationInfo.targetSdkVersion;
        try {
            System.loadLibrary("verifier");
        } catch (Exception e) {
            String str = "load verifier failed. msg = " + e.getMessage();
            if (TextUtils.isEmpty(str) || !Verifier.isDebug()) {
                return;
            }
            Log.e("Verifier", str);
        }
    }

    public static native int nativeDisableClassVerify(int i, int i2);

    public static native int nativeDvmDisableClassVerify();

    public static native int nativeDvmEnableClassVerify();

    public static native int nativeEnableClassVerify();
}
