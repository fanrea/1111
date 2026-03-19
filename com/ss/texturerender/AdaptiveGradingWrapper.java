package com.ss.texturerender;

import java.lang.reflect.Method;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class AdaptiveGradingWrapper {
    private static final int HEIGHT_DEFAULT = 720;
    private static final String LOG_TAG = "AdaptiveGradingWrapper";
    private static final int MAX_RETRY_COUNT = 3;
    private static final String VIDEO_ADAPTIVE_GRADING_CLASS_NAME = "com.bytedance.bmf_mods.AdaptiveGrading";
    private static final int WIDTH_DEFAULT = 1440;
    private float[] mBrightnessThreshold;
    private String mCacheFile;
    private float[] mContrastThreshold;
    private int mMaxHeight;
    private int mMaxWidth;
    private float[] mSaturationThreshold;
    private int mTexType;
    private Object mAdaptiveGradingObject = null;
    private Method mInitMethod = null;
    private Method mProcessMethod = null;
    private Method mProcessOesMethod = null;
    private Method mFreeMethod = null;
    private int mMaxInitRetryCount = 0;

    public AdaptiveGradingWrapper(int i) {
        this.mTexType = i;
        TextureRenderLog.i(i, LOG_TAG, "new AdaptiveGradingWrapper");
    }

    public boolean init(int i, int i2, String str, float[] fArr, float[] fArr2, float[] fArr3) {
        if (this.mAdaptiveGradingObject == null || this.mInitMethod == null) {
            _initObjAndMethod();
        }
        if (i <= 0) {
            i = WIDTH_DEFAULT;
        }
        this.mMaxWidth = i;
        if (i2 <= 0) {
            i2 = 720;
        }
        this.mMaxHeight = i2;
        this.mCacheFile = str;
        this.mBrightnessThreshold = fArr;
        this.mContrastThreshold = fArr2;
        this.mSaturationThreshold = fArr3;
        Object obj_invokeMethod = _invokeMethod(this.mInitMethod, this.mAdaptiveGradingObject, Integer.valueOf(i), Integer.valueOf(this.mMaxHeight), str, fArr, fArr2, fArr3);
        if (obj_invokeMethod != null && (obj_invokeMethod instanceof Integer) && ((Integer) obj_invokeMethod).intValue() >= 0) {
            return true;
        }
        TextureRenderLog.i(this.mTexType, "AdaptiveGrading", "AdaptiveGrading init error:" + obj_invokeMethod);
        free();
        return false;
    }

    public int process(int i, int i2, int i3, float f, float f2, float f3, float f4, float f5, float f6, boolean z) {
        Object obj = this.mAdaptiveGradingObject;
        if (obj == null || this.mInitMethod == null) {
            TextureRenderLog.i(this.mTexType, "AdaptiveGrading", "AdaptiveGrading mInitMethod null");
            return i;
        }
        if (i < 0 || i2 <= 0 || i3 <= 0) {
            TextureRenderLog.i(this.mTexType, "AdaptiveGrading", "AdaptiveGrading width height = 0");
            return i;
        }
        Object obj_invokeMethod = _invokeMethod(this.mProcessMethod, obj, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6), Boolean.valueOf(z));
        if (obj_invokeMethod == null || !(obj_invokeMethod instanceof Integer)) {
            return i;
        }
        Integer num = (Integer) obj_invokeMethod;
        return num.intValue() < 0 ? i : num.intValue();
    }

    public int processOES(int i, int i2, int i3, float[] fArr, float f, float f2, float f3, float f4, float f5, float f6, boolean z) {
        Object obj = this.mAdaptiveGradingObject;
        if (obj == null || this.mInitMethod == null) {
            TextureRenderLog.i(this.mTexType, "AdaptiveGrading", "AdaptiveGrading oes mInitMethod null");
            return i;
        }
        if (i < 0 || i2 <= 0 || i3 <= 0) {
            TextureRenderLog.i(this.mTexType, "AdaptiveGrading", "AdaptiveGrading oes width height = 0");
            return i;
        }
        Object obj_invokeMethod = _invokeMethod(this.mProcessOesMethod, obj, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), fArr, Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6), Boolean.valueOf(z));
        if (obj_invokeMethod != null && (obj_invokeMethod instanceof Integer)) {
            Integer num = (Integer) obj_invokeMethod;
            if (num.intValue() >= 0) {
                return num.intValue();
            }
        }
        return i;
    }

    public void free() {
        _invokeMethod(this.mFreeMethod, this.mAdaptiveGradingObject, new Object[0]);
        this.mAdaptiveGradingObject = null;
        this.mInitMethod = null;
        this.mFreeMethod = null;
        this.mProcessMethod = null;
    }

    private void _initObjAndMethod() {
        try {
            Class<?> clzUsingPluginLoader = TextureRenderHelper.getClzUsingPluginLoader(1, VIDEO_ADAPTIVE_GRADING_CLASS_NAME);
            if (clzUsingPluginLoader != null) {
                this.mInitMethod = clzUsingPluginLoader.getDeclaredMethod("Init", Integer.TYPE, Integer.TYPE, String.class, float[].class, float[].class, float[].class);
                this.mProcessMethod = clzUsingPluginLoader.getDeclaredMethod("ProcessTexture", Integer.TYPE, Integer.TYPE, Integer.TYPE, Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE, Boolean.TYPE);
                this.mProcessOesMethod = clzUsingPluginLoader.getDeclaredMethod("ProcessOesTexture", Integer.TYPE, Integer.TYPE, Integer.TYPE, float[].class, Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE, Boolean.TYPE);
                this.mFreeMethod = clzUsingPluginLoader.getDeclaredMethod("Free", new Class[0]);
                this.mAdaptiveGradingObject = clzUsingPluginLoader.newInstance();
            }
        } catch (Exception e) {
            TextureRenderLog.e(this.mTexType, LOG_TAG, "VideoOCLSR get fail:" + e.toString());
            this.mAdaptiveGradingObject = null;
            this.mInitMethod = null;
            this.mFreeMethod = null;
            this.mProcessMethod = null;
        }
    }

    private Object _invokeMethod(Method method, Object obj, Object... objArr) {
        if (method == null || obj == null) {
            return null;
        }
        try {
            return method.invoke(obj, objArr);
        } catch (Exception e) {
            TextureRenderLog.e(this.mTexType, LOG_TAG, e.toString());
            return null;
        }
    }
}
