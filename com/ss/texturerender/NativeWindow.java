package com.ss.texturerender;

import android.view.Surface;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class NativeWindow {
    private static String TAG = "TR_NativeWindow";
    private static boolean isLibLoaded;
    private long mHandle;
    private Surface mSurface;
    private int mTexType;

    private static native int nativeGetFormat(Surface surface);

    private static native int nativeGetHeight(long j);

    private static native int nativeGetSurfaceFormat(long j);

    private static native int nativeGetWidth(long j);

    private static native int nativeReleaseSurface(long j);

    private static native int nativeSetBuffersGeometry(long j, int i, int i2, int i3);

    private static native long nativeSetSurface(Surface surface);

    static {
        try {
            try {
                System.loadLibrary("texturerender_native");
            } catch (Exception e) {
                TextureRenderLog.e(-1, TAG, "load texturerender_native fail,error:" + e.toString());
            }
        } finally {
            TextureRenderLog.d(-1, TAG, "load texturerender_native success");
            isLibLoaded = true;
        }
    }

    public NativeWindow(int i, Surface surface) {
        this.mSurface = null;
        this.mHandle = 0L;
        if (!isLibLoaded) {
            TextureRenderLog.d(this.mTexType, TAG, "lib not loaded");
            return;
        }
        this.mSurface = surface;
        this.mHandle = nativeSetSurface(surface);
        this.mTexType = i;
    }

    public int setBuffersGeometry(int i, int i2, int i3) {
        if (this.mHandle <= 0) {
            return -1;
        }
        TextureRenderLog.d(this.mTexType, TAG, "setBuffersGeometry,w:" + i + ",h:" + i2 + ",fmt:" + i3);
        return nativeSetBuffersGeometry(this.mHandle, i, i2, i3);
    }

    public int getSurfaceFormat() {
        long j = this.mHandle;
        if (j <= 0) {
            return -1;
        }
        return nativeGetSurfaceFormat(j);
    }

    public int releaseWindow() {
        long j = this.mHandle;
        if (j <= 0) {
            return -1;
        }
        int iNativeReleaseSurface = nativeReleaseSurface(j);
        this.mHandle = 0L;
        return iNativeReleaseSurface;
    }

    public int getWidth() {
        long j = this.mHandle;
        if (j <= 0) {
            return -1;
        }
        return nativeGetWidth(j);
    }

    public int getHeight() {
        long j = this.mHandle;
        if (j <= 0) {
            return -1;
        }
        return nativeGetHeight(j);
    }

    public static int getFormat(Surface surface) {
        if (!isLibLoaded) {
            TextureRenderLog.d(-1, TAG, "lib not loaded");
            return -1;
        }
        return nativeGetFormat(surface);
    }
}
