package com.ss.texturerender;

import android.os.Build;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class DeviceManager {
    private static int mIsVRDevice = -1;

    public static boolean isVRDevice() {
        if (mIsVRDevice < 0) {
            mIsVRDevice = Build.MANUFACTURER.equalsIgnoreCase("Pico") ? 1 : 0;
        }
        return mIsVRDevice == 1;
    }
}
