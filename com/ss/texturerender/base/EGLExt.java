package com.ss.texturerender.base;

import android.hardware.HardwareBuffer;
import android.opengl.EGLDisplay;
import com.ss.texturerender.TextureRenderLog;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class EGLExt {
    private static boolean isLibLoaded;

    private static native int nBindHardwareBufferToTexture(long j, HardwareBuffer hardwareBuffer, int i, int i2);

    static {
        try {
            try {
                System.loadLibrary("texturerender_native");
            } catch (Exception e) {
                TextureRenderLog.e(-1, "EGLExt", "load texturerender_native fail,error:" + e.toString());
            }
        } finally {
            TextureRenderLog.d(-1, "EGLExt", "load texturerender_native success");
            isLibLoaded = true;
        }
    }

    public static int bindHardwareBufferToTexture(EGLDisplay eGLDisplay, HardwareBuffer hardwareBuffer, int i, int i2) {
        if (eGLDisplay == null || hardwareBuffer == null || i == 0 || !isLibLoaded) {
            return -1;
        }
        return nBindHardwareBufferToTexture(eGLDisplay.getNativeHandle(), hardwareBuffer, i, i2);
    }
}
