package com.ss.mediakit.vcnlib;

import android.util.Log;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class VcnlibloadWrapper {
    private static boolean isVcnload = false;
    private static boolean isVcnverifyLiteload = false;
    private static boolean isVcnverifyload = false;

    public static boolean tryLoadVcnlib() {
        synchronized (VcnlibloadWrapper.class) {
            boolean z = true;
            if (isVcnload) {
                return true;
            }
            try {
                System.loadLibrary("vcn");
            } catch (UnsatisfiedLinkError e) {
                Log.e("vcn", "Can't load vcn library: " + e);
                z = false;
            }
            isVcnload = z;
            return z;
        }
    }

    public static boolean tryLoadVcnverifylib() {
        boolean z;
        synchronized (VcnlibloadWrapper.class) {
            boolean z2 = true;
            if (isVcnverifyload) {
                return true;
            }
            try {
                System.loadLibrary("vcnverify");
                z = true;
            } catch (UnsatisfiedLinkError e) {
                Log.e("vcn", "Can't load vcnverify library: " + e);
                z = false;
            }
            isVcnverifyload = z;
            if (!z && !tryLoadVcnverifyLitelib()) {
                z2 = false;
            }
            return z2;
        }
    }

    public static boolean tryLoadVcnverifyLitelib() {
        synchronized (VcnlibloadWrapper.class) {
            boolean z = true;
            if (isVcnverifyLiteload) {
                return true;
            }
            try {
                System.loadLibrary("vcnverifylite");
                Log.e("vcn", "load vcnverifylite suc");
                CustomVerify.init();
            } catch (UnsatisfiedLinkError e) {
                Log.e("vcn", "Can't load vcnverifylite library: " + e);
                z = false;
            }
            isVcnverifyLiteload = z;
            return z;
        }
    }
}
