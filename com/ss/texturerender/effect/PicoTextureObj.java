package com.ss.texturerender.effect;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class PicoTextureObj {
    public static final int PICO_VR_TEX_USE_FOR_CROP_SR_SCREEN = 2;
    public static final int PICO_VR_TEX_USE_FOR_FOV_SCREEN = 1;
    public static final int PICO_VR_TEX_USE_FOR_PLANE_ONLINE_SCREEN = 3;
    public static final int PICO_VR_TEX_USE_FOR_PLANE_SCREEN = 0;
    private int mHeight;
    private int mUnityTexId;
    private int mUseFor;
    private int mWidth;

    public PicoTextureObj(int i, int i2, int i3, int i4) {
        this.mUnityTexId = i;
        this.mWidth = i2;
        this.mHeight = i3;
        this.mUseFor = i4;
    }

    public int getUnityTexId() {
        return this.mUnityTexId;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getUseFor() {
        return this.mUseFor;
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }

    public void setWidth(int i) {
        this.mWidth = i;
    }

    public void setUnityTexId(int i) {
        this.mUnityTexId = i;
    }

    public void setUseFor(int i) {
        this.mUseFor = i;
    }
}
